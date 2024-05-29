package controller;

import model.Sale;

public class TestClass {
    public static void main(String[] args) {
        CustomerController c = new CustomerController();
        EmployeeController e = new EmployeeController();
        SaleController s = new SaleController();

        c.createCustomer("a", "a", "1", "a");
        e.createEmployee("a", "1", "a", "a", "1");

        try{
            s.createSale(1, "1", "1");
        } catch (Exception eee){
            System.out.println("lol");
        }
    }
}
