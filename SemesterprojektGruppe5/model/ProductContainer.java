package model;

import java.util.ArrayList;

public class ProductContainer {
    private static ArrayList<Product> ProductContainer = new ArrayList<Product>();

    private ProductContainer(){
        ProductContainer = null;
    }

    public static ArrayList<Product> getInstance()
    {
        if(ProductContainer == null){
            ProductContainer = new ArrayList<>();
        }
        return ProductContainer;
    }

    public void addProductToContainer(Product p){
        ProductContainer.add(p);
    }
}
