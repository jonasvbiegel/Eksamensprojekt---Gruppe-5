package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Customer;
import model.CustomerContainer;
import model.Employee;
import model.EmployeeContainer;
import model.Sale;
import model.SaleContainer;

public class SaleControllerTest {
    SaleController sc;
    EmployeeController ec;

    CustomerController cc;

    public SaleControllerTest(){}

    @BeforeAll
    public static void initialization(){
        EmployeeContainer eContainer = EmployeeContainer.getInstance();
        CustomerContainer cContainer = CustomerContainer.getInstance();
        SaleContainer sContainer = SaleContainer.getInstance();
        Employee e = new Employee("John", "Johnvej 1", "12345678", "1", "john@john.dk");
        Customer c = new Customer("Peter", "Petervej 123", "88888888", "peter@peter.com");
        eContainer.addEmployeeToContainer(e);
        cContainer.addCustomerToContainer(c);
        Sale s = new Sale(1, e, c);
        sContainer.addSaleToContainer(s);
    }

    @BeforeEach
    public void setUp(){
        sc = new SaleController();
        ec = new EmployeeController();
        cc = new CustomerController();
    }

    @AfterEach
    public void tearDown(){}

    @Test
    public void testFindSaleByOrderNo(){
        Sale s = sc.findSaleByOrderNo(1);
        assertNotNull(s);
        assertEquals(s.getOrderNo(), 1);
    }

    @Test
    public void testFindSaleByOrderNoFail(){
        Sale s = sc.findSaleByOrderNo(2);
        assertNotNull(s);
        assertEquals(s.getOrderNo(), 1);
    }

    @Test
    public void testFindCustomerByPhoneNo(){
        Customer c = cc.findCustomerByPhoneNo("88888888");
        assertNotNull(c);
        assertEquals(c.getName(), "Peter");
    }

    @Test
    public void findEmployeeByEmployeeNo(){
        Employee e = ec.findEmployeeByEmployeeNo("1");
        assertNotNull(e);
        assertEquals(e.getName(), "John");
    }
}