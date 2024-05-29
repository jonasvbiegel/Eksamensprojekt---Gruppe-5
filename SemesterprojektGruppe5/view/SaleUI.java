package view;
import controller.CustomerController;
import controller.EmployeeController;
import controller.SaleController;

import java.util.Scanner;

public class SaleUI {
    public SaleUI(){
        MainMenu();
    }

    Scanner sn;

    public void MainMenu(){
        boolean running = true;
        sn = new Scanner(System.in);
        System.out.println("Welcome to the Vestbjerg A/S Sales System");
        while(running){
            System.out.println("-----------------------------------------");
            System.out.println("1. Create Sale");
            System.out.println("2. Generate test data");
            System.out.println();
            System.out.println("9. Exit");

            switch(sn.nextInt()){
                case 1: CreateSale();
                break;
                case 2: testData();
                break;
                case 3: findEmployee();
                break;
                case 4: findCustomer();
                break;
                case 5: findSale(1);
                case 9: running = false;
            }
        }
    }

    public void findEmployee(){
        sn = new Scanner(System.in);
        System.out.println("Enter employee number:");
        String employeeNo = sn.nextLine();
        EmployeeController e = new EmployeeController();
        System.out.println(e.findEmployeeByEmployeeNo(employeeNo).getName());
    }

    public void findCustomer(){
        sn = new Scanner(System.in);
        System.out.println("Enter customer phone number:");
        String phoneNo = sn.nextLine();
        CustomerController c = new CustomerController();
        System.out.println(c.findCustomerByPhoneNo(phoneNo).getName());
    }

    public void testData(){
        Test t = new Test();
        t.generateTestData();
        t.findEmployee("1");
    }

    public void CreateSale() {
        SaleController saleController = new SaleController();
        sn = new Scanner(System.in);
        System.out.println("Enter employee number:");
        String employeeNo = sn.nextLine();
        System.out.println(employeeNo);

        System.out.println("Enter customers phone number:");
        String phoneNo = sn.nextLine();
        System.out.println(phoneNo);

        System.out.println("Enter order number for the order:");
        int orderNo = sn.nextInt();
        System.out.println(orderNo);
        sn.nextLine(); //this has to be here

        createSale(orderNo, phoneNo, employeeNo);

        System.out.println("Enter barcode of product:");
        String barcode = sn.nextLine();
        System.out.println(barcode);

        //saleController.productInformation(barcode);
        System.out.println("Quantity:");
        int quantity = sn.nextInt();
        System.out.println(quantity);
        sn.nextLine();
        addProductToSale(barcode, orderNo, quantity);
        //addProductToSale("abc", 1, 1);
    }

    public void addProductToSale(String barcode, int quantity, int orderNo){
        SaleController s = new SaleController();
        s.addProductToSale(barcode, quantity, orderNo);
    }

    public void createSale(int orderNo, String phoneNo, String employeeNo){
        SaleController s = new SaleController();
        s.createSale(orderNo, phoneNo, employeeNo);
    }

    public void findSale(int orderNo){
        SaleController s = new SaleController();
        System.out.println(s.findSaleByOrderNo(orderNo).getOrderNo());
    }

}
