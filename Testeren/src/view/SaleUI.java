package view;
import controller.CustomerController;
import controller.EmployeeController;
import controller.SaleController;
import model.Customer;
import model.OrderLineItem;
import model.Sale;

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
            System.out.println("3. Find sale by order number");
            System.out.println();
            System.out.println("9. Exit");

            switch(sn.nextInt()){
                case 1: CreateSale();
                break;
                case 2: testData();
                break;
                case 3: findSale();
                break;
                case 9: running = false;
                break;
                default: System.out.println("Invalid option");
                break;
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
    }

    public void CreateSale() {
        SaleController saleController = new SaleController();
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        sn = new Scanner(System.in);
        System.out.println("Enter employee number:");
        String employeeNo = sn.nextLine();

        try {
            System.out.println(employeeController.findEmployeeByEmployeeNo(employeeNo).getName());
        } catch(Exception e) {
            System.out.println("Employee not found; action cancelled");
            return;
        }

        System.out.println("Enter customers phone number:");
        String phoneNo = sn.nextLine();

        try {
            System.out.println(customerController.findCustomerByPhoneNo(phoneNo).getName());
        } catch(Exception e) {
            System.out.println("Customer not found; action cancelled");
            return;
        }

        System.out.println("Enter order number for the order:");
        int orderNo = sn.nextInt();
        sn.nextLine(); //this has to be here

        try{
            createSale(orderNo, phoneNo, employeeNo);
        } catch (Exception e) {
            System.out.println("Something went wrong; order cancelled");
        }

        boolean adding = true;

        while(adding) {
            System.out.println("Enter barcode of product:");
            String barcode = sn.nextLine();

            System.out.println("Quantity:");
            int quantity = sn.nextInt();
            sn.nextLine();
            addProductToSale(barcode, quantity, orderNo);
            System.out.println("Press 0 to finalize sale, or any key to continue adding products");
            if(sn.nextLine().equals("0")){
                printSale(orderNo);
                return;
            }
        }
    }

    public void addProductToSale(String barcode, int quantity, int orderNo){
        SaleController s = new SaleController();
        s.addProductToSale(barcode, quantity, orderNo);
    }

    public void createSale(int orderNo, String phoneNo, String employeeNo){
        SaleController s = new SaleController();
        s.createSale(orderNo, phoneNo, employeeNo);
    }

    public void printSale(int orderNo){
        SaleController s = new SaleController();
        double totalPrice = 0;
        System.out.println("Sale with order number " + orderNo);
        System.out.println("Date: " + s.findSaleByOrderNo(orderNo).getDate());
        for(OrderLineItem o : s.findSaleByOrderNo(orderNo).getItems()){
            System.out.println(o.getProduct().getName() + " x " + o.getQuantity() + " " + o.getProduct().getCurrentPrice() * o.getQuantity() + " DKK");
            totalPrice += o.getProduct().getCurrentPrice() * o.getQuantity();
        }
        System.out.println("Total price: " + totalPrice + " DKK");
    }

    public void findSale(){
        sn = new Scanner(System.in);
        System.out.println("Enter order number:");
        int orderNo = sn.nextInt();
        printSale(orderNo);

    }

}
