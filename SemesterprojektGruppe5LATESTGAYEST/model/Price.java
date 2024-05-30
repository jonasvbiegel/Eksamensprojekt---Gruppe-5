package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Price
{
    private double value;
    private LocalDate date;
    
    public Price(double value){
        this.value = value;
        date = LocalDate.now();
    }
    
    public double getValue(){
        return this.value;
    }
    public LocalDate getDate(){
        return this.date;
    }
    
    public void setValue(double value){
        this.value = value;
    }
    public void setDate(String date){
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMyyyy"));
    }
}
