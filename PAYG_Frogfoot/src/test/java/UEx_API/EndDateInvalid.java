package UEx_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndDateInvalid {
	@Test/*Validating endDate with Invalid Params*/
	public void endDateWithInvalidParams()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "24-11-2019 23:59:59")
				.request(Method.GET);
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		Assert.assertEquals(responseBody, "{\"success\":\"false\",\"message\":\"13: Invalid End Date\\n13: Invalid End Date\"}");
		System.out.println("Does errorMsg contains? : "+response.asString().contains("13: Invalid End Date"));
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "ResponseTime must be within limit");
		System.out.println();		
	}
}
