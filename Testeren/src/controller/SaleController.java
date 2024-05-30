package controller;

import model.OrderLineItem;
import model.Sale;
import model.SaleContainer;

import java.util.ArrayList;

public class SaleController
{
    
    public SaleController() {
    }

    public void productInformation(String barcode){
        ProductController p = new ProductController();
        System.out.println(p.findProductByBarcode(barcode).getBarcode() + " " + p.findProductByBarcode(barcode).getName() + ": Quantity in stock: " + p.findProductByBarcode(barcode).getQuantityInStock());
    }

    public Sale findSaleByOrderNo(int orderNo){
        Sale foundSale = null;
        ArrayList<Sale> list = SaleContainer.getInstance().getSales();
        for(Sale s : list){
            if(s.getOrderNo() == orderNo){
                foundSale = s;
                break;
            }
        }
        if(foundSale == null){
            throw new IllegalArgumentException("Sale not found");
        }
        return foundSale;
    }

    /**
     * Method creates Sale.
     */

    public void createSale(int orderNo, String phoneNo, String employeeNo) {
        CustomerController customerController = new CustomerController();
        EmployeeController employeeController = new EmployeeController();
        Sale sale = new Sale(orderNo, employeeController.findEmployeeByEmployeeNo(employeeNo), customerController.findCustomerByPhoneNo(phoneNo));
        SaleContainer.getInstance().addSaleToContainer(sale);
    }
    
    /**
     * Method adds Product to Sale.
     */
    public void addProductToSale(String barcode, int quantity, int orderNo) {
        ProductController productController = new ProductController();
        Sale s = findSaleByOrderNo(orderNo);
        OrderLineItem o = productController.createOrderLineItem(productController.findProductByBarcode(barcode), quantity);
        s.addItem(o);
    }

    /**
     * Method adds Sale to SaleContainer.
     */
    public void addSaleToContainer(Sale s){
        SaleContainer.getInstance().addSaleToContainer(s);
    }
}
