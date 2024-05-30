package view;
import controller.CustomerController;
import controller.EmployeeController;
import controller.SaleController;
import model.OrderLineItem;

import java.util.Scanner;

public class SaleUI {
    public SaleUI(){
        mainMenu();
    }

    Scanner sn;

    public void mainMenu(){
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
                case 3: printSale();
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
        sn = new Scanner(System.in);
        System.out.println("Enter employee number:");
        String employeeNo = sn.nextLine();

        System.out.println("Enter customers phone number:");
        String phoneNo = sn.nextLine();

        System.out.println("Enter order number for the order:");
        int orderNo = sn.nextInt();
        sn.nextLine(); //this has to be here

        try{
            createSale(orderNo, phoneNo, employeeNo);
        } catch (Exception e) {
            System.out.println("Something went wrong; order cancelled");
            return;
        }

        boolean addingProducts = true;

        while(addingProducts) {
            System.out.println("Press 0 to stop adding products, or enter to add more products");
            if ("0".equals(sn.nextLine())) {
                addingProducts = false;
            } else {
                System.out.println("Enter barcode of product:");
                String barcode = sn.nextLine();

                System.out.println("Quantity:");
                int quantity = sn.nextInt();
                sn.nextLine();
                addProductToSale(barcode, quantity, orderNo);
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

    public void printSale(){
        double totalPrice = 0;
        SaleController s = new SaleController();
        sn = new Scanner(System.in);
        System.out.println("Enter order number:");
        int orderNo = sn.nextInt();
        System.out.println("Sale with order number " + orderNo);
        System.out.println("Date: " + s.findSaleByOrderNo(orderNo).getDate());
        for(OrderLineItem o : s.findSaleByOrderNo(orderNo).getItems()){
            System.out.println(o.getProduct().getName() + " x " + o.getQuantity() + " " + o.getProduct().getCurrentPrice() * o.getQuantity() + " DKK");
            totalPrice += o.getProduct().getCurrentPrice() * o.getQuantity();
        }
        System.out.println("Total price: " + totalPrice);
    }

}
