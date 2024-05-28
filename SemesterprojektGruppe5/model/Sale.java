package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sale
{
    private int orderNo;
    private LocalDate date;
    private Customer customer;
    private Employee employee;
    private ArrayList<OrderLineItem> items; 

    public Sale(int orderNo){
        this.orderNo = orderNo;
    }

    /**
     * Method returns orderNo.
     */
    public int getOrderNo(){
        return orderNo;
    }
    
    /**
     * Method returns date.     
     */
    public LocalDate getDate(){
        return date;
    }
    
    /**
     * Method sets orderNo.
     */
    public void setOrderNo(int newOrderNo){
        newOrderNo = orderNo;
    }
    
    /**
     * Method sets date.
     */
    public void setDate(){
        //TODO
    }
}
