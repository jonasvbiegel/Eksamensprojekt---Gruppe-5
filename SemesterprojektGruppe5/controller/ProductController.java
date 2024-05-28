package controller;
import java.util.ArrayList;
import java.util.Iterator;
import model.Product;
import model.ProductContainer;
import model.OrderLineItem;

public class ProductController
{
    
    public ProductController() {
    }

    /**
     * Method creates Product and adds to ProductContainer.
     */
    public void createProduct(String name, String serialNo) {
        Product currentProduct = new Product(name, serialNo);
        ProductContainer pc = ProductContainer.getInstance();
        pc.addProductToContainer(currentProduct);
    }
    
    /**
     * Method returns Product by provided SerialNo.
     */
    public Product findProductBarcode(String barcode) {
        Product foundProduct = null;
        ProductContainer pc = ProductContainer.getInstance();
        for(Product p : pc){
            if(p.getBarcode() == barcode){
                foundProduct = p;
                break;
            }
        }
        return foundProduct;
    }
    
    /**
     * Method creates OrderLineItem.
     */
    public void createOrderLineItem(Product product, int quantity) {
         OrderLineItem currentOrderLineItem = new OrderLineItem(product, quantity);
    }
}
