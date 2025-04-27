package Logic.Class;

import java.time.LocalDate;
import java.util.ArrayList;

import Logic.Abstract.MusicalProduct;

public class Store {
/*
* 
* -------------Attributes---------------
* 
*/
    private String name;
    private String address;
    private String phone;
    private Employee manager;
    private LocalDate managerStartDate;
    private ArrayList<Employee> employees;
    private ArrayList<MusicalProduct> products;
    private ArrayList<RecordingService> customRecordingServices;

/*
* 
* -------------Constructors---------------
* 
*/

    public Store(String name, String address, String phone, Employee manager, LocalDate managerStartDate) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
        this.setManager(manager);
        this.setManagerStartDate(managerStartDate);
        this.employees = new ArrayList<Employee>();
        this.products = new ArrayList<MusicalProduct>();
        this.customRecordingServices = new ArrayList<RecordingService>();
    }



/*
* 
* -------------Gets and Sets---------------
* 
*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee manager) {
        this.manager = manager;
    }
    public LocalDate getManagerStartDate() {
        return managerStartDate;
    }
    public void setManagerStartDate(LocalDate managerStartDate) {
        this.managerStartDate = managerStartDate;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public ArrayList<MusicalProduct> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<MusicalProduct> products) {
        this.products = products;
    }
    public ArrayList<RecordingService> getCustomRecordingServices() {
        return customRecordingServices;
    }

    public void setCustomRecordingServices(ArrayList<RecordingService> customRecordingServices) {
        this.customRecordingServices = customRecordingServices;
    }
    
/*
* 
* -------------Methods---------------
* 
*/

public void print() {
    System.out.println("-----Store-----");
    System.out.println("Name: " + this.name);
    System.out.println("Address: " + this.address);
    System.out.println("Phone: " + this.phone);
    System.out.println("Manager: ");
    this.manager.print();
    System.out.println("Employees: ");
    for (Employee e : this.employees) {
        System.out.println("Employee: ");
        e.print();
    }
    System.out.println("Products: ");
    for (MusicalProduct m : products) {
        System.out.println("Product: ");
        m.print();
    }
    System.out.println("Recodins Services: ");
    for (RecordingService r : customRecordingServices) {
        System.out.println("Rec. Serv.: ");
        r.print();
    }
}
}
