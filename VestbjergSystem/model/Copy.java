package model;

public class Copy
{
    private String copyNo;
    
    public Copy(String copyNo){
        this.copyNo = copyNo;
    }
    
    public String getCopyNo(){
        return this.copyNo;
    }
    public void setCopyNo(String copyNo){
        this.copyNo = copyNo;
    }
}
