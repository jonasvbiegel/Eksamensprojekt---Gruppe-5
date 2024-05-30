package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import model.*;

public class SaleControllerTest
{
    SaleController saleController;
    EmployeeController employeeController;
    CustomerController customerController;

    public SaleControllerTest(){
    }

    @BeforeAll
    public static void init(){        
        EmployeeController eCon = new EmployeeController();
        CustomerController cCon = new CustomerController();
        SaleController sCon = new SaleController();
        cCon.createCustomer("Tonni", "Tonnivej 2, Tonniby 2000", "12345678", "tonnimail@email.dk");
        eCon.createEmployee("Mulle", "11223344", "mullemail@email.dk", "Mullevej 1, Mulleby 1000", "1");
        sCon.createSale(2, "12345678", "1");

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp(){
        saleController = new SaleController();
        employeeController = new EmployeeController();
        customerController = new CustomerController();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown(){
    }

    @Test
    public void testFindSaleByOrderNo(){
        Sale s = saleController.findSaleByOrderNo(2);
        assertNotNull(s);
        assertEquals(s.getOrderNo(), 2);
    }
    
    @Test
    public void testFindCustomerByPhoneNo(){
        Customer c = customerController.findCustomerByPhoneNo("12345678");
        assertNotNull(c);
        assertEquals(c.getPhoneNo(), "12345678");
    }
    
    @Test
    public void testFindEmployeeByEmployeeNo(){
        Employee e = employeeController.findEmployeeByEmployeeNo("1");
        assertNotNull(e);
        assertEquals(e.getEmployeeNo(), "1");
    }
}
