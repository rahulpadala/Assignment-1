package spring.mongodb.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.mongodb.api.Service.employeeService;
import spring.mongodb.api.model.employee;
import spring.mongodb.api.repository.employeeRepository;

@RestController
public class employeeResource {
	
	@Autowired
	private employeeService service;
	
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST )
	public void addEmployee(@RequestBody employee emp) {
		service.addEmployee(emp);
	}
	
	@RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET )
	public List<employee> getEmployees(){
		return service.getEmployees();
	}
	
	@RequestMapping(value = "/findEmployee/{id}", method = RequestMethod.GET )
	public employee getEmployeeById(@PathVariable int id){
		return service.findEmployeeById(id);
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE )
	public void deleteEmployee(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT )
	public void updateEmployee(@RequestBody employee emp) {
		service.update(emp);
	}

}
