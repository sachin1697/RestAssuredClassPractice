package testPackForAllMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetMethodBase {
	
			@Test
			public void getMethod() {
				RestAssured.baseURI = "https://reqres.in/";
				Response response = given()
													.when()
													.get("api/users?page2")
													.then()
													.extract()
													.response();
				System.out.println(response);
				System.out.println(response.asPrettyString());
				System.out.println("Status code of this api = "+response.getStatusCode());
				System.out.println("Response Time this api = "+response.getTime());
			}
}
