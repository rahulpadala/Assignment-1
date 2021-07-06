package spring.mongodb.api.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class employeeTest {


    @Test
    void getId() {
        int id = 1;
        employee emp = new employee(id,"Rahul");
        assertEquals(id,emp.getId());
    }

    @Test
    void setId() {
        int id = 1;
        employee emp = new employee(2,"Rahul");
        emp.setId(id);
        assertEquals(id,emp.getId());
    }

    @Test
    void getEmployeeName() {
        String name = "rahul";
        employee emp = new employee(1,name);
        assertEquals(name,emp.getEmployeeName());
    }

    @Test
    void setEmployeeName() {
        String name = "reddy";
        employee emp = new employee(2,"Rahul");
        emp.setEmployeeName(name);
        assertEquals(name,emp.getEmployeeName());
    }
}