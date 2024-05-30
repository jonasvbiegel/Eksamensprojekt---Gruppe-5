package model;

public class Manager extends Employee {

    private boolean access;

    public Manager(String name, String address, String phoneNo, String employeeNo, String email, boolean access) {
        super(name, address, phoneNo, employeeNo, email);
        this.access = access;
    }

    public boolean hasAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
