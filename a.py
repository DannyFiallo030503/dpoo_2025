import zipfile
import os

def extraer_java_a_txt(archivo_zip, archivo_salida):
    try:
        with zipfile.ZipFile(archivo_zip, 'r') as zip_ref:
            with open(archivo_salida, 'w', encoding='utf-8') as output_file:
                # Iterar sobre todos los archivos en el ZIP
                for file_info in zip_ref.infolist():
                    # Verificar si es un archivo .java
                    if file_info.filename.endswith('.java') and not file_info.is_dir():
                        try:
                            # Leer el contenido del archivo .java
                            with zip_ref.open(file_info.filename) as java_file:
                                contenido = java_file.read().decode('utf-8')
                                
                            # Escribir información del archivo
                            output_file.write(f"\n\n// ===== Archivo: {file_info.filename} =====\n\n")
                            output_file.write(contenido)
                        except Exception as e:
                            print(f"Error al procesar {file_info.filename}: {str(e)}")
        
        print(f"Se ha creado el archivo {archivo_salida} con éxito!")
    except Exception as e:
        print(f"Error: {str(e)}")

# Ejemplo de uso
archivo_zip = "/home/dan/Documents/University/dpoo_2025/dpoo.zip"
archivo_salida = "/home/dan/Documents/University/dpoo_2025/Text File.txt"

extraer_java_a_txt(archivo_zip, archivo_salida) 
