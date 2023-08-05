package testPackForAllMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PutMethod {
			
			@Test
			public void chnageWrokspaceNameUsingPut() {
				RestAssured.baseURI="https://api.getpostman.com";
			Response response = given()
				 .header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
				 .body("{\r\n"
						 + "    \"workspace\": {\r\n"
						 + "        \"name\": \"changedWSNameByPut\",\r\n"
						 + "        \"description\": \"Automation this workspace name is changed  by automation test case name chnageWrokspaceNameUsingPut()\",\r\n"
						 + "        \"type\": \"personal\"\r\n"
						 + "    }\r\n"
						 + "}")
				 .when()
				 .put("/workspaces/24dc734d-63ac-42f7-8a04-1683ddb6dd11")
				 .then()
				 .extract()
				 .response();
			
			System.out.println(response.asPrettyString());
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			
			}

}
