package model;
import java.util.ArrayList;

public class EmployeeContainer {
    private ArrayList<Employee> employees;
    private static EmployeeContainer instance;

    private EmployeeContainer(){
        employees = new ArrayList<>();
    }

    public static EmployeeContainer getInstance()
    {
        if(instance == null){
            instance = new EmployeeContainer();
        }
        return instance;
    }

    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployeeToContainer(Employee e){
        employees.add(e);
    }
}
