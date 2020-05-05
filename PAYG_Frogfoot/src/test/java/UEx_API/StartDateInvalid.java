package UEx_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StartDateInvalid {
	@Test /*Validating startDate with invalid format*/
	public void startDateWithInvalidFormat()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "25-10-2019 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		//boolean errorMsg=response.asString().contains("{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		Assert.assertEquals(responseBody, "{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		System.out.println("Does errorMsg contains? : "+response.asString().contains("11: Invalid Start Date"));
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be withing limit");
		System.out.println();
	}
}
