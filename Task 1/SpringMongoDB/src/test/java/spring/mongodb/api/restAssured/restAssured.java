package spring.mongodb.api.restAssured;

import static org.hamcrest.CoreMatchers.equalTo; 
import static  org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test; 
import org.springframework.util.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import spring.mongodb.api.model.employee;

import static io.restassured.RestAssured.*;


class restAssured {

    @Test
    public void test_get() {

    	Response response =
    			  RestAssured.get("http://localhost:8080/findAllEmployees");
    			  System.out.println(response.statusCode());
    			  System.out.println(response.asString());
    			  System.out.println(response.getBody().asString());
    			  int statusCode = response.getStatusCode();
    			  assertEquals(statusCode, 200);
    }
    
  

	@Test void addEmployee()
	{

		employee emp=new employee(100,"rahul");
		Response response=
				given()
						.contentType("application/json")
						.body(emp)
						.when()
						.post("http://localhost:8080/addEmployee")
						.then()
						.extract().response();
		assertEquals(200, response.statusCode());

	}


	@Test void getUpdate() {
		employee emp =new employee(100,"reddy");
		Response response=given()
				.contentType("application/json")
				.body(emp)
				.when().put("http://localhost:8080/updateEmployee") .then()
				.extract().response();
		assertEquals(200, response.statusCode());
		
	}


	@Test void deleteEmployee() {
		Response response =
				RestAssured.delete("http://localhost:8080/deleteEmployee/100");
		Assertions.assertEquals(200, response.statusCode());
	}

	@Test void findEmployeeById(){

		Response response =
				RestAssured.get("http://localhost:8080/findEmployee/100");
		String name =response.getBody().jsonPath().get("employeeName");
		assertEquals("reddy",name);

	}
	
	  @Test
	    public void test_url() {

	    	Response response =
	    			  RestAssured.get("http://localhost:8080/randomUrl");
	    			  int statusCode = response.getStatusCode();
	    			  assertEquals(statusCode, 404);
	    }






}





