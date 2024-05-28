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
    public void createEmployee(String name, String phoneNo, String email) {
        
    }
    
    /**
     * Method returns Employee by provided employeeNo.
     */
    public Employee findEmployeeByEmployeeNo() {
        Employee foundEmployee = null;
        ArrayList<Employee> list = EmployeeContainer.getInstance();
        for(Employee p : list){
            if(p.getBarcode() == barcode){
                foundProduct = p;
                break;
            }
        }
        return foundProduct;
    }
}
