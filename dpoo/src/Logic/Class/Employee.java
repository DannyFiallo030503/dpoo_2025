package Logic.Class;

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
    private String educationLevel;
    private String role;
    
/*
* 
* -------------Constructors---------------
* 
*/
    public Employee(String firstName, String lastName, String idNumber, String employeeNumber, double salary,
            String educationLevel, String role) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdNumber(idNumber);
        this.setEmployeeNumber(employeeNumber);
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
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
/*
* 
* -------------Methods---------------
* 
*/
}
