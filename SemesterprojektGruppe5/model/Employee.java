package model;

public class Employee {
    private String name;
    private String address;
    private String phoneNo;
    private String employeeNo;
    private String email;

    public Employee(String name, String address, String phoneNo, String employeeNo, String email) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.employeeNo = employeeNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
