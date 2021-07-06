package spring.mongodb.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mongodb.api.model.employee;
import spring.mongodb.api.repository.employeeRepository;

@Service
public class employeeServiceImpl implements employeeService {
	
	@Autowired
	private employeeRepository repository;

	@Override
	public void addEmployee(employee emp) {
		repository.save(emp);	
	}

	@Override
	public List<employee> getEmployees(){
		return repository.findAll();
	}

	@Override
	public employee findEmployeeById(int id) {
		return repository.getById(id);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);	
	}

	@Override
	public void update(employee emp) {
		repository.save(emp);	
	}
	
	

}
