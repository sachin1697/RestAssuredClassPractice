package dataHandling;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseAssert {
		
			@Test
			public void getAllWorkspacesWithUsingHDR() {
				RestAssured.baseURI="https://api.getpostman.com";
												given()
												.header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
												.when()
												.get("/workspaces")
												.then()
												.assertThat()
												.header("Server", "nginx")
												.contentType(ContentType.JSON)
												.statusCode(200)
												//for using body method we need maninten secquence for verification 
												.body("workspaces.name",  contains("My Workspace","PostWorkspace","changedWSNameByPut","CreatedByAutomation","CreatedForTestDelete"))
												.body("workspaces.name",  hasItem("PostWorkspace"))
												.body("workspaces.name",  containsInAnyOrder("PostWorkspace","My Workspace","CreatedByAutomation","changedWSNameByPut","CreatedForTestDelete"));
												
			}
}
