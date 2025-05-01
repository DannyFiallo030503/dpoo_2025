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

    public Store(String name, String address, String phone) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
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

    public Employee searchEmployee(String id) {
        Employee emp = null;

        for (int i = 0; i < employees.size() && emp == null; i++) {
            if (employees.get(i).getIdNumber() == id) {
                emp = employees.get(i);
            }
        }

        return emp;
    }
    
    public int searchEmployeePos(String id) {
        int pos = -1;

        for (int i = 0; i < employees.size() && pos == -1; i++) {
            if (employees.get(i).getIdNumber() == id) {
                pos = i;
            }
        }

        return pos;
    }

    public boolean addEmployee(Employee employee) {
        boolean adding = false;
        Employee emp = searchEmployee(employee.getIdNumber());

        if (emp == null) {
            adding = true;
            this.employees.add(employee);
        }

        return adding;
    }

    public Employee deleteEmployee(String id) {
        return employees.remove(this.searchEmployeePos(id));
    }

    public MusicalProduct searchProduct(String name) {
        return null;
    }

    public int searchProductPos(String name) {
        return 0;
    }

    public boolean addProduct(MusicalProduct product) {
        return true;
    }

    public MusicalProduct deleteMusicalProduct(String name) {
        return null;
    }

    public RecordingService searchRecordingService(String name) {
        return null;
    }

    public int searchRecordingServicetPos(String name) {
        return 0;
    }

    public boolean addRecordingService(MusicalProduct product) {
        return true;
    }

    public RecordingService deleteRecordingService(String name) {
        return null;
    }

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
