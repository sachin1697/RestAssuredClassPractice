package dataHandling;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static  io.restassured.RestAssured.*;

public class createAndValidate {
public String mesage;
	
				@Test(priority = 0)
				public void  createUser() {
					RestAssured.baseURI="https://petstore.swagger.io/v2";
					 Response response = given()
							 							.header("Content-Type", "application/json")
							 							.body("{\r\n"
							 									+ "  \"id\": 1234576543,\r\n"
							 									+ "  \"username\": \"Yogesh\",\r\n"
							 									+ "  \"firstName\": \"kadam\",\r\n"
							 									+ "  \"lastName\": \"haridas\",\r\n"
							 									+ "  \"email\": \"girish123@gmail.com\",\r\n"
							 									+ "  \"password\": \"girish1234\",\r\n"
							 									+ "  \"phone\": \"9970566019\",\r\n"
							 									+ "  \"userStatus\": 200\r\n"
							 									+ "}")
							 							.when()
							 							.post("/user")
							 							.then()
							 							.extract()
							 							.response();
					JsonPath js= response.jsonPath();
					mesage=js.getString("message");
					System.out.println(response.asPrettyString());
				}
				
				@Test
				public void getUserDeatilsAndVerifyID() {
					RestAssured.baseURI="https://petstore.swagger.io/v2";
					 Response response = given()
							 							.header("Content-Type", "application/json")
							 							.when()
							 							.get("/user/Yogesh")
							 							.then()
							 							.extract()
							 							.response();
					 System.out.println(response.asPrettyString());
					JsonPath js= response.jsonPath();
					String ID =js.getString("id");
					Assert.assertEquals(ID, mesage);
					
				}
}
