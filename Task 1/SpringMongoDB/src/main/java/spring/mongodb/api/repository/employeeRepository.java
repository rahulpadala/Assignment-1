package spring.mongodb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.mongodb.api.model.employee;

public interface employeeRepository extends MongoRepository<employee , Integer>{
	
	public employee getById(int id);

}
