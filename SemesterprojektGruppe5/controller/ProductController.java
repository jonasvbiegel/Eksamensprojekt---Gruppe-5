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
    public void createProduct(String name, String barcode) {
        Product currentProduct = new Product(name, barcode);
        ProductContainer pc = ProductContainer.getInstance();
        pc.addProductToContainer(currentProduct);
    }
    
    /**
     * Method returns Product by provided SerialNo.
     */
    public Product findProductByBarcode(String barcode){
        Product foundProduct = null;
        ArrayList<Product> list = ProductContainer.getInstance().getProducts();
        for(Product p : list){
            if(p.getBarcode() == barcode){
                foundProduct = p;
                break;
            }
        }
        if(foundProduct == null){
            throw new IllegalArgumentException("Product not found");
        }
        return foundProduct;
    }
    
    /**
     * Method creates OrderLineItem.
     */
    public OrderLineItem createOrderLineItem(Product product, int quantity) {
         OrderLineItem currentOrderLineItem = new OrderLineItem(product, quantity);
         return currentOrderLineItem;
    }
}
