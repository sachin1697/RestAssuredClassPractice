package testPackForAllMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAllWorkspacesUsingHdr {
			
				@Test
				public void getAllWorkspacesWithUsingHDR() {
					RestAssured.baseURI="https://api.getpostman.com";
					Response Response = given()
														.header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
														.when()
														.get("/workspaces")
														.then()
														.extract()
														.response();
					System.out.println(Response.asPrettyString());
					System.out.println(Response.getStatusCode());
					System.out.println((Response.getTime()));
				}
				
				@Test (description ="This is test for using ID to get information related to workspace. ID is get by above workspaces")
				public void getAllWorkspacesInfoByUsingID() {
					RestAssured.baseURI="https://api.getpostman.com";
					Response Response = given()
														.header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
														.when()
														.get("/workspaces/24dc734d-63ac-42f7-8a04-1683ddb6dd11")
														.then()
														.extract()
														.response();
					System.out.println(Response.asPrettyString());
					System.out.println(Response.getStatusCode());
					System.out.println((Response.getTime()));
				
				}
				
				@Test (description ="This is test for using ID to get information related to workspace. ID is get by above workspaces")
				public void get1AllWorkspacesInfoByUsingID() {
					RestAssured.baseURI="https://api.getpostman.com";
					Response Response = given()
														.header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
														.when()
														.get("/workspaces/7b0cba1c-f3e4-4074-9de9-c5663db5a1af")////7b0cba1c-f3e4-4074-9de9-c5663db5a1af//ee1e5b5d-9728-45c8-89fe-54aea6249118//82ea2717-3411-487c-b449-65dca9222370//17e8864a-0f9f-4887-8513-f525000253e8//
														.then()
														.extract()
														.response();
					System.out.println(Response.asPrettyString());
					System.out.println(Response.getStatusCode());
					System.out.println((Response.getTime()));
				
				}

}

