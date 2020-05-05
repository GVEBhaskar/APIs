package UEx_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiKeyInvaid {
	@Test /*Validating apiKey with InvalidOne and no Params*/
	public void invalidapiKey()
	{
		//Specify Base URI
				RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
				
				//Specify Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				//Specify Response Object
				Response response=httpRequest.given().header("apiKey", "1eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
						.queryParam("startDate", "2019-03-25 00:00:00")
						.queryParam("endDate", "2019-04-24 23:59:59")
						.request(Method.GET);
				
				//Printing Response Body
				String responseBody=response.getBody().asString();
				System.out.println("Response Body is : "+responseBody);
				
				//Printing and Validating StatusCode
				int statusCode=response.getStatusCode();
				System.out.println("Status Code is : "+statusCode);
				Assert.assertEquals(statusCode, 401);
				
				//Printing and Validating StatusLine
				String statusLine=response.getStatusLine();
				System.out.println("Status Line is : "+statusLine);
				Assert.assertEquals(statusLine, "HTTP/1.1 401 Unauthorized");
				
				//Printing and Validating ResponseTime
				long responseTime=response.getTime();
				System.out.println("Response Time is : "+responseTime);
				Assert.assertTrue(responseTime<=60000, "Response Time should be in limit");
				System.out.println();
	}
}
