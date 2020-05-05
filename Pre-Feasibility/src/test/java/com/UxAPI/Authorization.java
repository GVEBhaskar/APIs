package com.UxAPI;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization 
{
	@BeforeTest
	public void startUP()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://dfaapigwlab01.dfa.local:8080/getPreFeasibilityUxAPI";
	}
	@Test(priority=0) /*Validating Authorization with Valid Params*/
	public void validauthorizationWithValidParams()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
				.request(Method.GET);
		
		//Printing Response Body
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		System.out.println("Does the response body has 'feasibleProduct'?: "+responseBody.contains("feasibleProduct"));
		System.out.println("Does the response body has 'bandwidth'?: "+responseBody.contains("bandwidth"));
		System.out.println("Does the response body has 'value'?: "+responseBody.contains("value"));
		System.out.println("Does the response body has 'unit'?: "+responseBody.contains("unit"));
		System.out.println("Does the response body has 'rate'?: "+responseBody.contains("rate"));
		System.out.println("Does the response body has 'term'?: "+responseBody.contains("term"));
		System.out.println("Does the response body has 'distance'?: "+responseBody.contains("distance"));
		//Printing and Validating StatusCode
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Printing and Validating StatusLine
		String statusLine=response.getStatusLine();
		System.out.println("Status Line is : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//Printing and Validating ResponseTime
		long responseTime=response.getTime();
		System.out.println("Response Time is : "+responseTime);
		Assert.assertTrue(responseTime<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.get("status"), "Ok");
		Assert.assertEquals(jsonPath.get("isFeasible"), true);
		System.out.println();
	}
	@Test(priority=1) /*Validating Authorization without Headers with valid params*/
	public void noHeaders()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given()
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "accesskey is missing.  /n Invalid authentication headers provided. Check credentials and confirm if all parameters are passed. ");
		System.out.println();
	}
	@Test(priority=2) /*Validating Authorization without orgId with valid params*/
	public void noOrgId()
	{	
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("clientId", "123").header("accesskey", "pass")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "orgId is missing. \n Invalid authentication headers provided. Check credentials and confirm if all parameters are passed.");
		System.out.println();
	}
	@Test(priority=3) /*Validating Authorization without ClientId with valid params*/
	public void noClientId()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("orgId", "123").header("accesskey", "pass")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "clientId is missing. Invalid authentication headers provided. Check credentials and confirm if all parameters are passed.");
		System.out.println();
	}
	@Test(priority=4) /*Validating Authorization without accessKey with valid params*/
	public void noaccessKey()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "accesskey is missing.  /n Invalid authentication headers provided. Check credentials and confirm if all parameters are passed. ");
		System.out.println();
	}
	@Test(priority=5) /*Validating Authorization without OrgId&ClientId with valid params*/
	public void noOrgIdClientId()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("accesskey", "pass")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "orgId is missing. \n Invalid authentication headers provided. Check credentials and confirm if all parameters are passed.");
		System.out.println();
	}
	@Test(priority=6) /*Validating Authorization without OrgId&accessKey with valid params*/
	public void noOrgIdaccessKey()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("clientId", "123")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "accesskey is missing.  /n Invalid authentication headers provided. Check credentials and confirm if all parameters are passed. ");
		System.out.println();
	}
	@Test(priority=7) /*Validating Authorization without ClientId&accessKey with valid params*/
	public void noClientIdaccessKey()
	{
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Response Object
		Response response=httpRequest.given().header("orgId", "123")
				.queryParam("gpsLatitude", "-25.859770")
				.queryParam("gpsLongitude", "28.214739")
				.queryParam("bandwidth", "5")
				.queryParam("term", "1")
				.queryParam("product", "magellan")
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
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("success"), false);
		Assert.assertEquals(jsonPath.get("errorCode"), 4001);
		Assert.assertEquals(jsonPath.get("errorMessage"), "accesskey is missing.  /n Invalid authentication headers provided. Check credentials and confirm if all parameters are passed. ");
		System.out.println();
	}
	@AfterTest
	public void tearDown()
	{
		System.out.println("Test Scenario Closed");
	}
}
