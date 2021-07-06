package spring.mongodb.api.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.mongodb.api.model.employee;
import spring.mongodb.api.repository.employeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class employeeServiceImplTest {

	@Autowired
	private employeeService employeeService;

	@MockBean
	private employeeRepository employeeRepository;

	@Test
	void testAddEmployee() {
		employee emp = new employee(1,"Rahul");
		employeeService.addEmployee(emp);
		verify(employeeRepository,times(1)).save(emp);
	}

	@Test
	void testGetEmployees() {
		when(employeeRepository.findAll()).thenReturn(
				Stream.of(new employee(1,"Rahul"),new employee(2,"Reddy")).collect(Collectors.toList()));
		assertEquals(2, employeeService.getEmployees().size());
	}

	@Test
	void testFindEmployeeById() {
		int id = 1;
		employee emp = new employee(1,"Rahul"); 
		when(employeeRepository.getById(id)).thenReturn(emp);
		assertEquals(emp,employeeService.findEmployeeById(id));
	}

	@Test
	void testDeleteById() {
		employee emp = new employee(1,"Rahul");
		employeeService.deleteById(emp.getId());
		verify(employeeRepository,times(1)).deleteById(emp.getId());
	}

	@Test
	void testUpdate() {
		employee emp = new employee(1,"Rahul");
		employeeService.update(emp);
		verify(employeeRepository,times(1)).save(emp);
	}

}
