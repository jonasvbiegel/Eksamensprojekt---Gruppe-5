package view;
import model.*;
import controller.*;

public class Test {
    public void generateTestData(){
        // Employee e1 = new Employee("John Hansen", "Johnvej 23, 9000 Aalborg", "12312312", "1", "john@gmail.com");
        EmployeeController e = new EmployeeController();
        e.createEmployee("John", "12312312", "john@gmail.com", "Johnvej 12", "a");
        System.out.println("Generated Employee John with Employee Number a");
        //Customer c1 = new Customer("Tina", "Tinavej 1, 9000 Aalborg", "11223344", "tina@gmail.com");
        CustomerController c = new CustomerController();
        c.createCustomer("Tina", "Tinavej 1", "1", "tina@gmail.com");
        System.out.println("Generated Customer Tina with Phone Number 1");

        ProductController p = new ProductController();
        p.createProduct("Søm", "abc");
        System.out.println("Created product Søm with barcode abc");
    }

    public void findEmployee(String employeeNo){
        EmployeeController e = new EmployeeController();
        System.out.println(e.findEmployeeByEmployeeNo(employeeNo).getName());
    }
}
