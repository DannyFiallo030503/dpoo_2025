package Logic.Class;

import java.util.ArrayList;

import Logic.Utils;
import Logic.Enum.EducationLevel;

public class Employee {
/*
* 
* -------------Attributes---------------
* 
*/
    private String firstName;
    private String lastName;
    private String idNumber;
    private String employeeNumber;
    private double salary;
    private EducationLevel educationLevel;
    private String role;
    
/*
* 
* -------------Constructors---------------
* 
*/

    public Employee(String firstName, String lastName, String idNumber, double salary,
            EducationLevel educationLevel, String role, ArrayList<Employee> employees) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNumber(idNumber);
        this.setEmployeeNumber(employees);
        this.setSalary(salary);
        this.setEducationLevel(educationLevel);
        this.setRole(role);
    }
    
/*
* 
* -------------Gets and Sets---------------
* 
*/
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (Utils.validarSoloLetras(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("The name contains numbers or strange characters.");
        }
        
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (Utils.validarSoloLetras(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("The last name contains numbers or strange characters."); 
        }
        
    }
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        if (Utils.validarCarnetIdentidad(idNumber)) {
            this.idNumber = idNumber;
        } else {
            throw new IllegalArgumentException("The identity card must be in the format YYMMDD#####");
        }
        
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(ArrayList<Employee> employees) {
        this.employeeNumber = Utils.generarNumeroTrabajadorUnico(employees);
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (Utils.validarRangoDouble(salary, 3000, 20000)) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("The minimum wage of a worker must be 3000 and the maximum is around 20,000.");
        }
    }
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (Utils.validarSoloLetras(role)) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("The role contains numbers or strange characters.");
        }
        
    }
    
/*
* 
* -------------Methods---------------
* 
*/
    public void print() {
        System.out.println("-----Employee-----");
        System.out.println("Employee: " + this.firstName + " " + this.lastName);
        System.out.println("Id: " + this.idNumber);
        System.out.println("Id Employee: " + this.employeeNumber);
        System.out.println("Education Level: " + this.educationLevel);
        System.out.println("Salary: " + this.salary);
        System.out.println("Role: " + this.role);
    }
}
