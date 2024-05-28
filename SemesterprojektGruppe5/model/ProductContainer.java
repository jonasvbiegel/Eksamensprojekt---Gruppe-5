package model;

import java.util.ArrayList;

public class ProductContainer {
    private ArrayList<Product> products;
    private static ProductContainer instance;

    private ProductContainer(){
        products = new ArrayList<>();
    }

    public static ProductContainer getInstance()
    {
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProductToContainer(Product p){
        products.add(p);
    }
}
