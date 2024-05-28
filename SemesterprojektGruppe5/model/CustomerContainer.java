package model;
import java.util.ArrayList;

public class CustomerContainer {
    private ArrayList<Customer> customers;
    private static CustomerContainer instance;

    private CustomerContainer(){
        customers = new ArrayList<>();
    }

    public static CustomerContainer getInstance()
    {
        if(instance == null){
            instance = new CustomerContainer();
        }
        return instance;
    }

    public void addCustomerToContainer(Customer c){
        customers.add(c);
    }
}
