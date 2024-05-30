package model;
import java.util.ArrayList;

public class ApplianceProduct extends Product
{
    private ArrayList<Copy> copies;
    private String serialNo;
    
    public ApplianceProduct(String name, String barcode){
        super(name, barcode);
        this.copies = new ArrayList();
    }
    
    public ArrayList<Copy> getCopies(){
        return this.copies;
    }
    public void createCopy(String copyNo){
        Copy c = new Copy(copyNo);
        this.copies.add(c);
    }
}
