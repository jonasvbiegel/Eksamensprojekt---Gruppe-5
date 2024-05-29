package controller;

import model.Sale;
import model.SaleContainer;

public class SaleController
{
    
    public SaleController() {
        
    }

    /**
     * Method creates Sale.
     */
    public void createSale(int orderNo, String phoneNo, String employeeNo) {
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController();
        Sale sale = new Sale(orderNo, employeeController.findEmployeeByEmployeeNo(employeeNo), customerController.findCustomerByPhoneNo(phoneNo));
    }
    
    /**
     * Method adds Product to Sale.
     */
    public void addProductToSale(String barcode, int quantity, int orderNo) {
        ProductController productController = new ProductController();
        Sale s = SaleContainer.getInstance().findSaleByOrderNo(orderNo);
        s.addItem(productController.createOrderLineItem(productController.findProductByBarcode(barcode), quantity));
    }

    /**
     * Method adds Sale to SaleContainer.
     */
    public void finalizeSale(Sale s){
        SaleContainer.getInstance().addSaleToContainer(s);
    }
}
