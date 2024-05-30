package view;
import controller.*;

public class Test {
    public void generateTestData(){
        // Employee e1 = new Employee("John Hansen", "Johnvej 23, 9000 Aalborg", "12312312", "1", "john@gmail.com");
        EmployeeController e = new EmployeeController();
        e.createEmployee("John", "12312312", "john@gmail.com", "Johnvej 12", "111");
        System.out.println("Generated Employee John with Employee Number 111");
        //Customer c1 = new Customer("Tina", "Tinavej 1, 9000 Aalborg", "11223344", "tina@gmail.com");
        CustomerController c = new CustomerController();
        c.createCustomer("Tina", "Tinavej 1", "12345678", "tina@gmail.com");
        System.out.println("Generated Customer Tina with Phone Number 12345678");

        ProductController p = new ProductController();
        p.createProduct("Søm", "1234");
        p.findProductByBarcode("1234").newPrice(10);
        System.out.println("Created product Søm with barcode 1234");
    }
}
