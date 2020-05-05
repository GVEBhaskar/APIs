package com.UxAPI;

import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test 
{
	@org.testng.annotations.Test
	public void getPreFeasibilityValidationTrue()
	{
		
		for (int i=5; i<=100; i=i+5)
		{
			RestAssured.baseURI = "http://dfaapigwlab01.dfa.local:8080/getPreFeasibilityUxAPI";
			RequestSpecification httpRequest = RestAssured.given();
			Response response=httpRequest.given().header("orgId", "123").header("clientId", "123").header("accesskey", "pass")
					.queryParam("gpsLatitude", "-26.203326	")
					.queryParam("gpsLongitude", "28.126586")
					.queryParam("bandwidth", "5")
					.queryParam("term", "1")
					.queryParam("product", "magellan")
					.request(Method.GET);
			//Response bW=httpRequest.given().queryParam("bandwidth", "i").request(Method.GET);
			
			System.out.println(response.getBody().asString());
		}
		
		
//		String responseBody=response.getBody().asString();
//		System.out.println("Response Body is: "+responseBody);
//		System.out.println("Does the response body has 'feasibleProduct'?: "+responseBody.contains("feasibleProduct"));
//		System.out.println("Does the response body has 'bandwidth'?: "+responseBody.contains("bandwidth"));
//		System.out.println("Does the response body has 'value'?: "+responseBody.contains("value"));
//		System.out.println("Does the response body has 'unit'?: "+responseBody.contains("unit"));
//		System.out.println("Does the response body has 'rate'?: "+responseBody.contains("rate"));
//		System.out.println("Does the response body has 'term'?: "+responseBody.contains("term"));
//		System.out.println("Does the response body has 'distance'?: "+responseBody.contains("distance"));
//		
//		System.out.println("Status Code is: "+response.getStatusCode());
//		Assert.assertEquals(response.getStatusCode(), 200);
//		System.out.println("Status Line is: "+response.getStatusLine());
//		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
//		System.out.println("Response Time is: "+response.getTime());
//		Assert.assertTrue(response.getTime()<=60000, "Response Time should be in limit");
//		
//		JsonPath jsonPath=response.jsonPath();
//		Assert.assertEquals(jsonPath.get("status"), "Ok");
//		Assert.assertEquals(jsonPath.get("isFeasible"), true);
	}
}
