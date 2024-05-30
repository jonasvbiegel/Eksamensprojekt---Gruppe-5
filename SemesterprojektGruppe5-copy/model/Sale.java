package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sale
{
    private int orderNo;
    private LocalDate date;
    private Customer customer;
    private Employee employee;
    private ArrayList<OrderLineItem> items; 

    public Sale(int orderNo, Employee employee, Customer customer){
        this.orderNo = orderNo;
        this.employee = employee;
        this.customer = customer;
        this.date = LocalDate.now();
        items = new ArrayList<>();
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
    public void setDate(String date){
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMyyyy"));
    }

    public ArrayList<OrderLineItem> getItems(){
        return this.items;
    }

    public void addItem(OrderLineItem item){
        this.items.add(item);
    }
}
