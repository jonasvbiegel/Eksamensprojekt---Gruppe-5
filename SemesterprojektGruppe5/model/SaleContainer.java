package model;

import java.util.ArrayList;

public class SaleContainer {
    private ArrayList<Sale> sales;
    private static SaleContainer instance;

    private SaleContainer(){
        sales = new ArrayList<>();
    }

    public static SaleContainer getInstance()
    {
        if(instance == null){
            instance = new SaleContainer();
        }
        return instance;
    }

    public ArrayList<Sale> getSales() {
        return this.sales;
    }

    public void addSaleToContainer(Sale s){
        sales.add(s);
    }

    public Sale findSaleByOrderNo(int orderNo){
        Sale foundSale = null;
        for(Sale s : sales){
            if(s.getOrderNo() == orderNo){
                foundSale = s;
                break;
            }
        }
        return foundSale;
    }
}
