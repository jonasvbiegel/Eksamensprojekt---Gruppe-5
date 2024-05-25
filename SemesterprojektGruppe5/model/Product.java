package model;

public class Product
{
    private String name;
    private String serialNo;
    private int quantityInStock;
    
    public Product(String name, String serialNo){
        this.name = name;
        this.serialNo = serialNo;
        quantityInStock = 0;
    }
}
