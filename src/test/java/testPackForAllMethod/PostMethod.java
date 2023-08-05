package testPackForAllMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostMethod {
			@Test
			public void createWorkspaseUsingPostMethod() {
				RestAssured.baseURI = "https://api.getpostman.com";
				Response postResp = given()
													 .header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
													 .body("{\r\n"
															 + "    \"workspace\": {\r\n"
															 + "        \"name\": \"CreatedByAutomation\",\r\n"
															 + "        \"description\": \"Automation this workspace is created by automation test case name createWorkspaceusingPostMthod()\",\r\n"
															 + "        \"type\": \"personal\"\r\n"
															 + "    }\r\n"
															 + "}")
													 .when()
													 .post("/workspaces")
													 .then()
													 .extract()
													 .response();
				
				System.out.println(postResp.asPrettyString());
				System.out.println(postResp.getStatusCode());
				System.out.println(postResp.getTime());			
			}

}
