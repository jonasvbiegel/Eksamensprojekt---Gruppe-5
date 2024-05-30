package model;
import java.util.ArrayList;

public class Product
{
    private String name;
    private String barcode;
    private int quantityInStock;
    private ArrayList<Price> prices;
    
    public Product(String name, String barcode){
        this.name = name;
        this.barcode = barcode;
        quantityInStock = 0;
        prices = new ArrayList<>();
    }
    
    public String getName() {
        return this.name; 
    }
    public String getBarcode() { 
        return this.barcode; 
    }
    public int getQuantityInStock(){
        return this.quantityInStock;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public void setQuantityInStock(int quantity){
        this.quantityInStock = quantity;
    }
    
    public void newPrice(double value){
        Price p = new Price(value);
        prices.add(p);
    }
    public double getCurrentPrice(){
        return prices.get(prices.size() - 1).getValue();
    }
}
