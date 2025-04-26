import java.util.ArrayList;
import java.util.List;
import Logic.Class.Employee;
import Logic.Utils;

public class App {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println("=== Pruebas de la clase Utils ===");

        // Prueba de validarCarnetIdentidad
        System.out.println("\n1. Prueba de validarCarnetIdentidad:");
        testValidarCarnetIdentidad();

        // Prueba de validarRangoDouble
        System.out.println("\n2. Prueba de validarRangoDouble:");
        testValidarRangoDouble();

        // Prueba de generarNumeroTrabajadorUnico
        System.out.println("\n3. Prueba de generarNumeroTrabajadorUnico:");
        testGenerarNumeroTrabajadorUnico();

        // Prueba de validarSoloLetras
        System.out.println("\n4. Prueba de validarSoloLetras:");
        testValidarSoloLetras();

        // Prueba de validarNumeroEspecial
        System.out.println("\n5. Prueba de validarNumeroEspecial:");
        testValidarNumeroEspecial();

        // Prueba de validarEmail
        System.out.println("\n6. Prueba de validarEmail:");
        testValidarEmail();
    }

    private static void testValidarCarnetIdentidad() {
        // Carnets válidos
        String[] validos = { "00010112345", "99123198765", "01022954321" }; // 29 de feb (año bisiesto)
        // Carnets inválidos
        String[] invalidos = { "00013212345", "991231", "01023054321", "abcdefghijk", "0001011234X" };

        System.out.println("Carnets válidos:");
        for (String ci : validos) {
            System.out.printf("%s: %b%n", ci, Utils.validarCarnetIdentidad(ci));
        }

        System.out.println("\nCarnets inválidos:");
        for (String ci : invalidos) {
            System.out.printf("%s: %b%n", ci, Utils.validarCarnetIdentidad(ci));
        }
    }

    private static void testValidarRangoDouble() {
        System.out.println("5.0 en rango 1-10: " + Utils.validarRangoDouble(5.0, 1, 10));
        System.out.println("0.0 en rango 1-10: " + Utils.validarRangoDouble(0.0, 1, 10));
        System.out.println("10.0 en rango 1-10: " + Utils.validarRangoDouble(10.0, 1, 10));
        System.out.println("NaN en rango 1-10: " + Utils.validarRangoDouble(Double.NaN, 1, 10));
    }

    private static void testGenerarNumeroTrabajadorUnico() {
        List<Employee> empleados = new ArrayList<>();
        empleados.add(
                new Employee("Juan", "Pérez", "85010112345", "70000001", 2500.0, "Universitario", "Desarrollador"));
        empleados.add(new Employee("Ana", "Gómez", "90050554321", "50012345", 3000.0, "Master", "Gerente"));

        System.out.println("Empleados existentes:");
        empleados.forEach(e -> System.out.println(e.getEmployeeNumber()));

        System.out.println("\nNúmeros generados:");
        for (int i = 0; i < 5; i++) {
            String nuevoNumero = Utils.generarNumeroTrabajadorUnico(empleados);
            System.out.println(nuevoNumero);
            // Agregamos a la lista para probar unicidad
            empleados.add(
                    new Employee("Temp" + i, "Temp", "0101010000" + i, nuevoNumero, 1000.0, "Técnico", "Temporal"));
        }
    }

    private static void testValidarSoloLetras() {
        String[] validos = { "Juan", "María de los Ángeles", "Ñandú", "áéíóú" };
        String[] invalidos = { "Juan123", "M@ría", "123", "" };

        System.out.println("Válidos:");
        for (String s : validos) {
            System.out.printf("%s: %b%n", s, Utils.validarSoloLetras(s));
        }

        System.out.println("\nInválidos:");
        for (String s : invalidos) {
            System.out.printf("%s: %b%n", s, Utils.validarSoloLetras(s));
        }
    }

    private static void testValidarNumeroEspecial() {
        String[] validos = { "51234567", "79999999" };
        String[] invalidos = { "12345678", "61234567", "5123456", "512345678", "abcdefgh" };

        System.out.println("Válidos:");
        for (String s : validos) {
            System.out.printf("%s: %b%n", s, Utils.validarNumeroEspecial(s));
        }

        System.out.println("\nInválidos:");
        for (String s : invalidos) {
            System.out.printf("%s: %b%n", s, Utils.validarNumeroEspecial(s));
        }
    }

    private static void testValidarEmail() {
        String[] validos = { "usuario@dominio.com", "nombre.apellido@sub.dominio.com", "a@b.cd" };
        String[] invalidos = { "usuario@", "@dominio.com", "usuario@dominio", "sin arroba.com", "" };

        System.out.println("Válidos:");
        for (String s : validos) {
            System.out.printf("%s: %b%n", s, Utils.validarEmail(s));
        }

        System.out.println("\nInválidos:");
        for (String s : invalidos) {
            System.out.printf("%s: %b%n", s, Utils.validarEmail(s));
        }
    }
}