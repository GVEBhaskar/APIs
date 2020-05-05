package com.UxAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class ContentType 
{
	@BeforeTest
	public void startUP()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://dfaapigwlab01.dfa.local:8080/getPreFeasibilityUxAPI";
	}
	
		@Test(priority=0) /*Validating the availability of Content-Type*/
		public void contentTypeAvailabilityInHeaders()
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
			Assert.assertEquals(jsonPath.get("isFeasible"), true);;
			
			//Printing Content-Type availability in Headers List
			boolean cT=response.headers().toString().contains("Content-Type");
			System.out.println("Does headers contains 'Content-Type'?: "+cT);
			
			System.out.println();
		}
		
		@Test(priority=1) /*Validating the format of Content-Type*/
		public void contentTypeformat()
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
			
			//Capture details of Content-Type and Validating			
			String contentType=response.header("Content-Type");
			System.out.println("Content-Type is: "+contentType);
			Assert.assertEquals(contentType, "application/json");
			
		}
		
	}

