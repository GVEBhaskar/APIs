package UEx_API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Success 
{
	@Test/*Validating succees message is true*/
	public void successMsgTrue()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
		.queryParam("startDate", "2019-06-25 00:00:00")
		.queryParam("endDate", "2019-07-24 23:59:59")
		.request(Method.GET);
		
		System.out.println("Response Body is : "+response.getBody().asString());
		System.out.println("Does Response Body contains success? : "+response.asString().contains("success"));
		JsonPath jsonPath = response.jsonPath();
		System.out.println("Value of success is : "+jsonPath.get("success"));
		System.out.println("Tot no of records from Response : "+jsonPath.get("result.size"));
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println("*****************************");
	}
	
	
}

