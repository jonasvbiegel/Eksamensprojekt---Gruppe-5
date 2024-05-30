package model;

public class CommercialCustomer extends Customer {

    private String cvr;

    public CommercialCustomer(String name, String address, String phoneNo, String email, String cvr) {
        super(name, address, phoneNo, email);
        this.cvr = cvr;
    }
    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }
}
