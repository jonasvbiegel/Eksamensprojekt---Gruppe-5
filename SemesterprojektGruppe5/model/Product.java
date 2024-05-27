package model;

public class Product
{
    private String name;
    private String serialNo;
    private int quantityInStock;
    /* TODO Price list for keeping track of current and past prices
     * Needs "Price" class
     * Price prices = ArrayList<Price>
     */
    
    public Product(String name, String serialNo){
        this.name = name;
        this.serialNo = serialNo;
        quantityInStock = 0;
    }
    
    public String getName() {
        return this.name; 
    }
    public String getSerialNo() { 
        return this.serialNo; 
    }
    public int getQuantityInStock(){
        return this.quantityInStock;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSerialNo(String serialNo){
        this.serialNo = serialNo;
    }
    public void setQuantityInStock(int quantity){
        this.quantityInStock = quantity;
    }
    
    /*
     * TODO Price getters and setters
     */
}
