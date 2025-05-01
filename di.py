import os
import re
from typing import List, Dict, Optional

class JavaClass:
    def __init__(self):
        self.name: str = ""
        self.type: str = ""  # class, interface, enum
        self.package: str = ""
        self.extends: Optional[str] = None
        self.implements: List[str] = []
        self.fields: List[Dict] = []
        self.methods: List[Dict] = []
        self.constructors: List[Dict] = []
        self.enum_values: List[str] = []

class JavaProjectAnalyzer:
    def __init__(self, project_path: str):
        self.project_path = project_path
        self.classes: List[JavaClass] = []
    
    def analyze_project(self):
        # Buscar todos los archivos .java recursivamente
        java_files = []
        for root, _, files in os.walk(self.project_path):
            for file in files:
                if file.endswith('.java'):
                    java_files.append(os.path.join(root, file))
        
        # Procesar cada archivo
        for java_file in java_files:
            with open(java_file, 'r', encoding='utf-8') as f:
                content = f.read()
                self._analyze_java_file(content)
        
        return self.classes
    
    def _analyze_java_file(self, content: str):
        lines = content.split('\n')
        current_class = None
        in_class = False
        in_comment = False
        
        for line in lines:
            stripped = line.strip()
            
            # Manejo de comentarios multi-línea
            if '/*' in line and '*/' not in line:
                in_comment = True
                continue
            if '*/' in line:
                in_comment = False
                continue
            if in_comment or stripped.startswith('//'):
                continue
            
            # Detectar paquete
            if stripped.startswith('package '):
                package = stripped.replace('package ', '').replace(';', '').strip()
                if current_class is None:
                    current_class = JavaClass()
                current_class.package = package
                continue
            
            # Detectar declaración de clase/interfaz/enum
            if not in_class and re.match(r'^(public\s+)?(abstract\s+)?(class|interface|enum)\s+\w+', stripped):
                in_class = True
                if current_class is None:
                    current_class = JavaClass()
                
                # Determinar tipo
                if 'enum' in stripped:
                    current_class.type = 'enum'
                elif 'interface' in stripped:
                    current_class.type = 'interface'
                else:
                    current_class.type = 'class'
                
                # Obtener nombre
                class_name = re.search(r'(class|interface|enum)\s+(\w+)', stripped)
                if class_name:
                    current_class.name = class_name.group(2)
                
                # Herencia
                extends = re.search(r'extends\s+(\w+)', stripped)
                if extends:
                    current_class.extends = extends.group(1)
                
                # Implementaciones
                implements = re.search(r'implements\s+([\w\s,]+)', stripped)
                if implements:
                    current_class.implements = [i.strip() for i in implements.group(1).split(',')]
                
                continue
            
            # Fin de clase
            if in_class and stripped == '}':
                in_class = False
                if current_class:
                    self.classes.append(current_class)
                    current_class = None
                continue
            
            # Dentro de una clase
            if in_class and current_class:
                # Campos
                field_match = re.match(r'^(private|protected|public)\s+([\w<>]+)\s+(\w+)\s*(=\s*.+)?;', stripped)
                if field_match:
                    current_class.fields.append({
                        'modifier': field_match.group(1),
                        'type': field_match.group(2),
                        'name': field_match.group(3)
                    })
                    continue
                
                # Métodos
                method_match = re.match(r'^(private|protected|public)?\s*(abstract\s+)?([\w<>]+)\s+(\w+)\s*\(', stripped)
                if method_match:
                    current_class.methods.append({
                        'modifier': method_match.group(1) or 'public',
                        'return_type': method_match.group(3),
                        'name': method_match.group(4)
                    })
                    continue
                
                # Valores de enum
                if current_class.type == 'enum' and re.match(r'^\w+\s*(,\s*)?$', stripped):
                    enum_val = stripped.replace(',', '').strip()
                    if enum_val:
                        current_class.enum_values.append(enum_val)
                    continue

class PlantUMLGenerator:
    def __init__(self, classes: List[JavaClass]):
        self.classes = classes
    
    def generate(self) -> str:
        plantuml = "@startuml\n"
        plantuml += "skinparam classAttributeIconSize 0\n"
        plantuml += "hide empty members\n\n"
        
        # Agregar clases
        for cls in self.classes:
            plantuml += self._generate_class(cls)
        
        # Agregar relaciones
        plantuml += "\n' Relaciones\n"
        for cls in self.classes:
            plantuml += self._generate_relationships(cls)
        
        plantuml += "@enduml"
        return plantuml
    
    def _generate_class(self, cls: JavaClass) -> str:
        class_def = ""
        
        if cls.type == 'class':
            class_def += f"class {cls.name}"
            if cls.extends:
                class_def += f" extends {cls.extends}"
            if cls.implements:
                class_def += f" implements {','.join(cls.implements)}"
            class_def += " {\n"
            
            for field in cls.fields:
                visibility = self._get_visibility_symbol(field['modifier'])
                class_def += f"    {visibility}{field['name']} : {field['type']}\n"
            
            for method in cls.methods:
                visibility = self._get_visibility_symbol(method['modifier'])
                class_def += f"    {visibility}{method['name']}() : {method['return_type']}\n"
            
            class_def += "}\n\n"
        
        elif cls.type == 'interface':
            class_def += f"interface {cls.name}"
            if cls.extends:
                class_def += f" extends {cls.extends}"
            class_def += " {\n"
            
            for method in cls.methods:
                class_def += f"    {method['name']}()\n"
            
            class_def += "}\n\n"
        
        elif cls.type == 'enum':
            class_def += f"enum {cls.name} {{\n"
            for value in cls.enum_values:
                class_def += f"    {value}\n"
            class_def += "}\n\n"
        
        return class_def
    
    def _generate_relationships(self, cls: JavaClass) -> str:
        relationships = ""
        
        # Herencia
        if cls.extends:
            relationships += f"{cls.extends} <|-- {cls.name}\n"
        
        # Implementación de interfaces
        for interface in cls.implements:
            relationships += f"{interface} <|.. {cls.name}\n"
        
        # Asociaciones (campos que son otras clases)
        for field in cls.fields:
            field_type = field['type']
            if any(c.name == field_type for c in self.classes):
                relationships += f"{cls.name} --> {field_type}\n"
        
        return relationships
    
    def _get_visibility_symbol(self, modifier: str) -> str:
        if modifier == 'private':
            return '-'
        elif modifier == 'protected':
            return '#'
        return '+'

def generate_uml_diagram(project_path: str, output_file: str):
    analyzer = JavaProjectAnalyzer(project_path)
    classes = analyzer.analyze_project()
    
    generator = PlantUMLGenerator(classes)
    plantuml_code = generator.generate()
    
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(plantuml_code)
    
    print(f"Diagrama UML generado en {output_file}")
    print(f"Total de clases analizadas: {len(classes)}")

# Ejemplo de uso
project_path = os.path.join('dpoo', 'src')  # Ruta a la carpeta src
output_file = 'diagrama.puml'

if os.path.exists(project_path):
    generate_uml_diagram(project_path, output_file)
else:
    print(f"Error: No se encontró la carpeta del proyecto en {project_path}")
    print("Asegúrate de que el script esté en la misma ruta que la carpeta 'dpoo'")