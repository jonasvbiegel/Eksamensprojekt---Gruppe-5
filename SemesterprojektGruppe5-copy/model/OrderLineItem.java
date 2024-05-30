package model;

public class OrderLineItem
{
    private Product product;
    private int quantity;
    
    public OrderLineItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    /**
     * Method returns product.
     */
    public Product getProduct() {
        return product;
    }
    
    /**
     * Method returns quantity.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Method sets product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    /**
     * Method sets quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
