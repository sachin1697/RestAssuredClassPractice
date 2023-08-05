package scerilizationDescerilization;

import org.testng.annotations.Test;

import POJO.bodyDataForCreateUser;
import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateUser {

	
	@Test
	public void createUserWithDeatils() {
		
		bodyDataForCreateUser resBody= new bodyDataForCreateUser();
		resBody.setId(0);
		resBody.setUsername("sachinKa");
		resBody.setFirstName("sachin");		
		resBody.setLastName("kadam");
		resBody.setEmail("sachin.kadam@gamil.com");
		resBody.setPassword("sachin1234");
		resBody.setPhone("8965469991");
		resBody.setUserStatus(200);
		
		RestAssured.baseURI ="https://petstore.swagger.io/v2";
		 given()
		 .header("Content-Type", "application/json")
		.body(resBody)
		.log().all()
		.when()
		.post("/user")
		.then()
		.log().all();
		
	}
}
