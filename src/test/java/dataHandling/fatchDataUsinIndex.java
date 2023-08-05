package dataHandling;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class fatchDataUsinIndex {
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
//		System.out.println(response.asPrettyString());
		
		JsonPath js= response.jsonPath();
		String text= js.getString("support.text");
		System.out.println(text);
		
		//we need to get data which parents contain multiple array
		System.out.println(js.getString("data[1].email"));
		
//		how to print all id's prest in data 
		for(int x=0;  x<6; x++) {
			int IDs= js.getInt("data["+x+"].id");
			System.out.println(IDs);
			
		}
		
		//if we need to get email id for user name "Charles" and we don't know size of element in Data
		for(int x=0;  x<js.getInt("data.size()"); x++) {
			String firstName= js.getString("data["+x+"].first_name");
				if(firstName.equals("Charles")) {
					System.out.println(js.getString("data["+x+"].email"));
				}
		}
		
		System.out.println(js.getInt("size()"));
	}
		
}
