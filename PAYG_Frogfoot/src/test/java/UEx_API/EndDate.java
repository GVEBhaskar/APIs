package UEx_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndDate 
{
	@Test /*Validating endDate with valid Params*/
	public void endDateWithValidParams()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		System.out.println("Does Response Body contains solidId? : "+responseBody.contains("solidId"));
		System.out.println("Does Response Body contains dfaCircuitNumber? : "+responseBody.contains("dfaCircuitNumber"));
		System.out.println("Does Response Body contains linkSpeed? : "+responseBody.contains("linkSpeed"));
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "ResponseTime must be within limit");
				
		JsonPath jp = new JsonPath(response.asString());
		String recordNumbers = jp.get("result.size()").toString();
		System.out.println("Total no. of records from response body: "+recordNumbers);
		System.out.println();
	}
	
}