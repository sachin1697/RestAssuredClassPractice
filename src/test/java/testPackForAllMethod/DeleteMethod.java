package testPackForAllMethod;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteMethod {
	public String id;
	//first we need to create workspace and then we will delete the workspace
	@Test
	public void createWorkspaceUsinPostMethod() {
			RestAssured.baseURI = "https://api.getpostman.com";
			Response response = given()
												.header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
												.body("{\r\n"
														+ "    \"workspace\": {\r\n"
														+ "        \"name\": \"Delete\",\r\n"
														+ "        \"description\": \"Automation this workspace is created by automation test case name createWorkspaceUsinPostMethod()\",\r\n"
														+ "        \"type\": \"personal\"\r\n"
														+ "    }\r\n"
														+ "}")
												.when()
												.post("/workspaces")
												.then()
												.extract()
												.response();
			System.out.println(response.asPrettyString());
			System.out.println((response.getStatusCode()));
			System.out.println((response.getTime()));
			
			JsonPath json=	response.jsonPath();
			 id = json.getString("workspace.id");
			System.out.println(id);
		}

	@Test()
	public void deleteWorkspaceUsingDeleteMethod() {
		RestAssured.baseURI = "https://api.getpostman.com";
		Response response = given()
											.header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")									
											.when()
											.delete("/workspaces/9241e1a0-8239-4460-ac97-100d5a8a5ea6")
											.then()
											.extract()
											.response();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	}
}
