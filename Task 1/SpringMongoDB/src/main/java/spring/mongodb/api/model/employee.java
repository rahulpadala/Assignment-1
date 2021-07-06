package spring.mongodb.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;



@Document(collection = "employee")
public class employee {
	
	@Id
	private int id;
	private String employeeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public employee(int id, String employeeName) {

		this.id = id;
		this.employeeName = employeeName;
	}
	public employee() {

	}







}
