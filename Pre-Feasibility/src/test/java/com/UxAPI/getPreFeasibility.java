package com.UxAPI;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getPreFeasibility 
{
	@BeforeTest
	public void setUP() /*Launch URL*/
	{
		RestAssured.baseURI = "http://dfaapigwlab01.dfa.local:8080/getPreFeasibilityUxAPI";
	}
	@Test(priority=0) /*validating getPreFesibility by passing valid params to find isFeasible is true*/
	public void getPreFeasibilityValidationTrue()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'feasibleProduct'?: "+responseBody.contains("feasibleProduct"));
		System.out.println("Does the response body has 'bandwidth'?: "+responseBody.contains("bandwidth"));
		System.out.println("Does the response body has 'value'?: "+responseBody.contains("value"));
		System.out.println("Does the response body has 'unit'?: "+responseBody.contains("unit"));
		System.out.println("Does the response body has 'rate'?: "+responseBody.contains("rate"));
		System.out.println("Does the response body has 'term'?: "+responseBody.contains("term"));
		System.out.println("Does the response body has 'distance'?: "+responseBody.contains("distance"));
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("status"), "Ok");
		Assert.assertEquals(jsonPath.get("isFeasible"), true);
	}
	@Test(priority=1) /*validating getPreFesibility by passing valid params to find isFeasible is false*/
	public void getPreFeasibilityValidationFalse()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-29.872503")
							.queryParam("gpsLongitude", "31.004014")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'feasibleProduct'?: "+responseBody.contains("feasibleProduct"));
		System.out.println("Does the response body has 'bandwidth'?: "+responseBody.contains("bandwidth"));
		System.out.println("Does the response body has 'value'?: "+responseBody.contains("value"));
		System.out.println("Does the response body has 'unit'?: "+responseBody.contains("unit"));
		System.out.println("Does the response body has 'rate'?: "+responseBody.contains("rate"));
		System.out.println("Does the response body has 'term'?: "+responseBody.contains("term"));
		System.out.println("Does the response body has 'distance'?: "+responseBody.contains("distance"));
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("status"), "Ok");
		Assert.assertEquals(jsonPath.get("isFeasible"), false);
	}
	@Test(priority=2) /*validating getPreFesibility by passing invalid valid params*/
	public void invalidParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-29.780639")
							.queryParam("gpsLongitude", "31.129406")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "No access points found within range.");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=3) /*validating getPreFesibility by passing No/empty 'gpsLatitude'*/
	public void NoemptygpsLatitudeParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Latitude or Longitude cannot be null");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=4) /*validating getPreFesibility by passing invalid 'gpsLatitude'*/
	public void invalidgpsLatitudeParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-125.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Latitude must be between -90 and 90 degrees inclusive.");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=5) /*validating getPreFesibility by passing No/empty 'gpsLongitude'*/
	public void noEmptygpsLongitudeParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Latitude or Longitude cannot be null");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=6) /*validating getPreFesibility by passing invalid 'gpsLongitude'*/
	public void invalidgpsLongitudeParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "128.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "No access points found within range.");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=7) /*validating getPreFesibility by passing No/empty 'gpsLongtude' & 'gpsLongitude'*/
	public void noEmptygpsLongnLatParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Latitude or Longitude cannot be null");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=8) /*validating getPreFesibility by passing invalid string value 'gpsLongtude' & 'gpsLongitude'*/
	public void invalidStringgpsLongnLatParamsgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "xxxxx")
							.queryParam("gpsLongitude", "xxxxx")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Longitude/Latitude must be of type number");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=9) /*validating getPreFesibility by passing No/empty 'bandwidth'*/
	public void noEmptybandwidthgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Bandwidth must be provided");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=10) /*validating getPreFesibility by passing invalid integer 'bandwidth'*/
	public void invalidIntegerbandwidthgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "555")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid bandwidth provided (555 Mbps)");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=11) /*validating getPreFesibility by passing invalid string 'bandwidth'*/
	public void invalidStringbandwidthgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "xcv")
							.queryParam("term", "1")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Bandwidth must be of type integer/number");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=12) /*validating getPreFesibility by passing No/empty 'term'*/
	public void noEmptytermgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Term must be provided");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=13) /*validating getPreFesibility by passing invalid integer 'term'*/
	public void invalidInttermgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "123")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid Term (123 year/s)");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=14) /*validating getPreFesibility by passing invalid string 'term'*/
	public void invalidStringtermgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "xzx")
							.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Term must be of type integer/number");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=15) /*validating getPreFesibility by passing No/empty 'product'*/
	public void noEmptyProductgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							//.queryParam("product", "magellan")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Product must be provided");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=16) /*validating getPreFesibility by passing invalid integer 'product'*/
	public void invalidIntProductgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "12345")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Product must be of type string/text");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@Test(priority=17) /*validating getPreFesibility by passing invalid string 'product'*/
	public void invalidStringProductgetPreFeasibility()
	{
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
							.queryParam("gpsLatitude", "-25.859770")
							.queryParam("gpsLongitude", "28.214739")
							.queryParam("bandwidth", "5")
							.queryParam("term", "1")
							.queryParam("product", "magellanaa")
							.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		System.out.println("Does the response body has 'resultCode'?: "+responseBody.contains("resultCode"));
		System.out.println("Does the response body has 'errorMessage'?: "+responseBody.contains("errorMessage"));
		System.out.println("Does the response body has 'errorCode'?: "+responseBody.contains("errorCode"));
				
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Product does not exist");
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
	}
	@AfterTest
	public void tearDown() /*Test Scenario Closed*/
	{
		System.out.println("Test Scenario Closed");
	}
}
