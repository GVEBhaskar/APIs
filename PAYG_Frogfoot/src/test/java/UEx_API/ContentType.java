package UEx_API;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContentType 
{

	
		@Test /*Validating the availability of Content-Type*/
		public void contentTypeAvailabilityInHeaders()
		{
			//Specify Base URI
			RestAssured.baseURI ="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
			
			//Request Object
			RequestSpecification httpRequest = RestAssured.given();
			
			//Specify Respone Object, apiKey Authentication and Parameters passing
			Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.request(Method.GET);
			
			//Printing Response Body
			String responseBody=response.getBody().asString();
			System.out.println("Response Body is: "+responseBody);
						
			//Printing Content-Type availability in Headers List
			boolean cT=response.headers().toString().contains("Content-Type");
			System.out.println("Does headers contains 'Content-Type'?: "+cT);
			
			
			//Printing and Validating StatusCode
			int statusCode=response.getStatusCode();
			System.out.println("Status Code is: "+statusCode);
			Assert.assertEquals(statusCode, 400);
			
			//Printing and Validating StatusLine
			String statusLine=response.getStatusLine();
			System.out.println("Status Line is : "+statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 400 Bad Request");
			
			//Printing and Validating ResponseTime
			long responseTime=response.getTime();
			System.out.println("Response Time is : "+responseTime);
			Assert.assertTrue(responseTime<=60000, "Response Time should be in limit");
			System.out.println();
		}
		
		@Test(priority=1) /*Validating the format of Content-Type*/
		public void contentTypeformat()
		{
			//Specify Base URI
			RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
			
			//Request Object
			RequestSpecification httpRequest = RestAssured.given();
			
			//Specify Respone Object, apiKey Authentication and Parameters passing
			Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.request(Method.GET);
			
			//Printing Response Body
			String responseBody=response.getBody().asString();
			System.out.println("Response Body is: "+responseBody);
			System.out.println();
		
			//Capture details of Content-Type and Validating			
			String contentType=response.header("Content-Type");
			System.out.println("Content-Type is: "+contentType);
			Assert.assertEquals(contentType, "application/json");
			
			//Printing and Validating StatusCode
			int statusCode=response.getStatusCode();
			System.out.println("Status Code is: "+statusCode);
			Assert.assertEquals(statusCode, 400);
			
			//Printing and Validating StatusLine
			String statusLine=response.getStatusLine();
			System.out.println("Status Line is : "+statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 400 Bad Request");
			
			//Printing and Validating ResponseTime
			long responseTime=response.getTime();
			System.out.println("Response Time is : "+responseTime);
			Assert.assertTrue(responseTime<=60000, "Response Time should be in limit");
			
			
		}
		
	}

