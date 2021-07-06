package spring.mongodb.api.Service;

import java.util.List;
import java.util.Optional;

import spring.mongodb.api.model.employee;

public interface employeeService {

	void addEmployee(employee emp);

	List<employee> getEmployees();

	employee findEmployeeById(int id);

	void deleteById(int id);

	void update(employee emp);

}
