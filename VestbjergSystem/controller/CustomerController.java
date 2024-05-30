package controller;
import model.Customer;
import model.CustomerContainer;

import java.util.ArrayList;

public class CustomerController
{

    public CustomerController() {
        
    }

    /**
     * Method creates customer and adds to CustomerContainer.
     */
    public void createCustomer(String name, String address, String phoneNo, String email) {
        Customer c = new Customer(name, address, phoneNo, email);
        CustomerContainer.getInstance().addCustomerToContainer(c);
    }
    
    /**
     * Method returns customer by provided phoneNo.
     */
    public Customer findCustomerByPhoneNo(String phoneNo) {
        Customer foundCustomer = null;
        ArrayList<Customer> list = CustomerContainer.getInstance().getCustomers();
        for (Customer customer : list) {
            if (customer.getPhoneNo().equals(phoneNo)) {
                foundCustomer = customer;
                break;
            }
        }
        if (foundCustomer == null) {
            throw new IllegalArgumentException("Employee not found");
        }
        return foundCustomer;
    }
}
