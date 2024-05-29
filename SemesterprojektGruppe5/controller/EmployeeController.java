package controller;
import model.Employee;
import model.EmployeeContainer;
import java.util.ArrayList;

public class EmployeeController
{
    
    public EmployeeController() {
        
    }

    /**
     * Method creates Employee and adds to EmployeeContainer.
     */
    public void createEmployee(String name, String phoneNo, String email, String address, String employeeNo) {
        Employee e = new Employee(name, address, phoneNo, employeeNo, email);
        EmployeeContainer.getInstance().addEmployeeToContainer(e);
    }
    
    /**
     * Method returns Employee by provided employeeNo.
     */
    public Employee findEmployeeByEmployeeNo(String employeeNo) {
        Employee foundEmployee = null;
        ArrayList<Employee> list = EmployeeContainer.getInstance().getEmployees();
        for(Employee e : list){
            if(e.getEmployeeNo().equals(employeeNo)){
                foundEmployee = e;
                break;
            }
        }
        if(foundEmployee == null){
            throw new IllegalArgumentException("Employee not found");
        }
        return foundEmployee;
    }
}
