package model;
import java.util.ArrayList;

public class ComplexProduct extends Product
{
    private ArrayList<Product> products;
    
    public ComplexProduct(String name, String serialNo){
        super(name, serialNo);
        products = new ArrayList();
    }
    
    public ArrayList<Product> getProducts(){
        return this.products;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
}
