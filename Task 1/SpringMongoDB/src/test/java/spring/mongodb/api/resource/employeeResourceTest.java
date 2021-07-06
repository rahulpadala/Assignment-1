package spring.mongodb.api.resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import spring.mongodb.api.Service.employeeService;
import spring.mongodb.api.model.employee;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class employeeResourceTest {

    @Autowired
    private employeeResource employeeResource;

    @MockBean
    private employeeService employeeService;

    @Test
    void addEmployee() {
        employee emp = new employee(1,"Rahul");
        employeeResource.addEmployee(emp);
        verify(employeeService,times(1)).addEmployee(emp);
    }

    @Test
    void getEmployees() {
        when(employeeService.getEmployees()).thenReturn(
                Stream.of(new employee(1,"Rahul"),new employee(2,"Reddy")).collect(Collectors.toList()));
        assertEquals(2, employeeResource.getEmployees().size());
    }

    @Test
    void getEmployeeById() {
        int id = 1;
        employee emp = new employee(1,"Rahul");
        when(employeeService.findEmployeeById(id)).thenReturn(emp);
        assertEquals(emp,employeeResource.getEmployeeById(id));
    }

    @Test
    void deleteEmployee() {
        employee emp = new employee(1,"Rahul");
        employeeResource.deleteEmployee(emp.getId());
        verify(employeeService,times(1)).deleteById(emp.getId());
    }

    @Test
    void updateEmployee() {
        employee emp = new employee(1,"Rahul");
        employeeResource.updateEmployee(emp);
        verify(employeeService,times(1)).update(emp);
    }
}