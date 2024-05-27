package model;

public class Product
{
    private String name;
    private String serialNo;
    private int quantityInStock;
    /* Price list for keeping track of current and past prices
     * Needs "Price" class
     * Price prices = ArrayList<Price>
     */
    
    public Product(String name, String serialNo){
        this.name = name;
        this.serialNo = serialNo;
        quantityInStock = 0;
    }
}
