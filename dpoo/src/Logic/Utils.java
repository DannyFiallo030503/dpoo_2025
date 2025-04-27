package Logic;

import java.time.DateTimeException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Random;

import Logic.Class.Employee;

public class Utils {
    private static String numero;

    // Valida carnet de identidad cubano (YYMMDD#####)
    public static boolean validarCarnetIdentidad(String carnet) {
        if (carnet == null || carnet.length() != 11 || !carnet.matches("\\d{11}")) {
            return false;
        }

        try {
            int yy = Integer.parseInt(carnet.substring(0, 2));
            int mm = Integer.parseInt(carnet.substring(2, 4));
            int dd = Integer.parseInt(carnet.substring(4, 6));

            // Validación de fecha usando año bisiesto como referencia
            YearMonth yearMonth = YearMonth.of(2000, mm);
            if (dd < 1 || dd > yearMonth.lengthOfMonth()) {
                return false;
            }

        } catch (NumberFormatException | DateTimeException e) {
            return false;
        }

        return true;
    }

    // Valida rango para valores double
    public static boolean validarRangoDouble(double valor, double min, double max) {
        return !Double.isNaN(valor) && valor >= min && valor <= max;
    }

    // Genera número de trabajador único (8 dígitos que empiezan en 5 o 7)
    public static String generarNumeroTrabajadorUnico(ArrayList<Employee> empleados) {
        if (empleados == null) {
            empleados = new ArrayList<>(); 
        }

        Random random = new Random();
        boolean esUnico;
        int intentos = 0;
        final int MAX_INTENTOS = 1000;

        do {
            int primerDigito = random.nextBoolean() ? 5 : 7;
            int resto = random.nextInt(10000000);
            numero = String.format("%d%07d", primerDigito, resto);
            esUnico = empleados.stream().noneMatch(e -> numero.equals(e.getEmployeeNumber()));
            intentos++;
        } while (!esUnico && intentos < MAX_INTENTOS);

        if (intentos >= MAX_INTENTOS) {
            throw new RuntimeException("Error generando ID único");
        }

        return numero;
    }

    // Valida que solo contenga letras
    public static boolean validarSoloLetras(String input) {
        return input != null && !input.isEmpty() && input.matches("^[a-zA-Z\\sáéíóúÁÉÍÓÚñÑ]+$");
    }

    // Valida formato numérico especial (8 dígitos empezando con 5 o 7)
    public static boolean validarNumeroEspecial(String input) {
        return input != null && input.matches("^[57]\\d{7}$");
    }

    // Método adicional sugerido: Validar formato de email
    public static boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }
}
