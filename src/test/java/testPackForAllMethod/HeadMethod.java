package testPackForAllMethod;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class HeadMethod {
	
	
	
	
     		@Test
     		public void headMethodtocheckHearerValue() {
     			RestAssured.baseURI="https://api.getpostman.com";
     			 Response response = given()
     					 							  .header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
     					 							  .when()
     					 							  .head("/workspaces")
     					 							  .then()
     					 							  .extract()
     					 							  .response();
     			 
     			 int code= response.getStatusCode();
     			 System.out.println(code);
     			 
     			 //below stapes are very lage
     			 Headers headers = response.headers();
     			List<Header> hdrList = headers.asList();
     			Header firstvalue = hdrList.get(0);
     			System.out.println(firstvalue.getName());
     			System.out.println(firstvalue.getValue());
     			System.out.println();
     			System.out.println();
     			System.out.println(firstvalue.getName()+" = "+firstvalue.getValue());
     			 			 			
     		}
     		
     		
     		@Test
     		public void headMethodtocheckHearersValue() {
     			RestAssured.baseURI="https://api.getpostman.com";
     			 Response response = given()
     					 							  .header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
     					 							  .when()
     					 							  .head("/workspaces")
     					 							  .then()
     					 							  .extract()
     					 							  .response();
     			 
     			 System.out.println(response.getStatusCode());
     			 System.out.println();
     			 String headers = response.headers().toString();
     			 System.out.println(headers);
          		
      		}
     		
     		@Test
     		public void getHeaderValueByUsingName() {
     			RestAssured.baseURI="https://api.getpostman.com";
     			 Response response = given()
     					 							  .header("X-Api-Key","PMAK-649708d00eb6290031060f86-d28f70e9aedfd7b82aaff176cd141833ac")
     					 							  .when()
     					 							  .head("/workspaces")
     					 							  .then()
     					 							  .extract()
     					 							  .response();
     			 
     			 int code= response.getStatusCode();
     			 System.out.println(code);
     			 String HdrValue = response.getHeader("X-RateLimit-Reset");
     			  System.out.println(HdrValue);
      		}
}
