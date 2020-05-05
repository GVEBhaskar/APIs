package com.ICM_UxAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAggregationSites 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void setUP()
	{
		RequestSpecBuilder reqSpec_Build = new RequestSpecBuilder();
		reqSpec_Build.addHeader("orgId", "123");
		reqSpec_Build.addHeader("clientId", "123");
		reqSpec_Build.addHeader("accesskey", "pass");
		reqSpec_Build.setBaseUri("http://dfaapigw01.dfa.local:8080/");
		reqSpec_Build.setBasePath("infrastructurecoverageuxapi/");
		reqSpec_Build.addPathParam("Operation","getAggregationSites");
		reqSpec_Build.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Build.build();
		
		ResponseSpecBuilder resSpec_Build = new ResponseSpecBuilder();
		resSpec_Build.expectContentType("application/json");
		resSpec_Build.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Build.build();
	}
	@Test(priority=0) /*Validating getAggregationSites end point with all valid params*/
	public void getAggregationSitesValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("DFA_AGGREGATION_NODE_NAME"), containsString("NODE_STATUS"), containsString("fieldAliases"), containsString("Lat"), containsString("Long"), containsString("fields"), containsString("name"), containsString("type"), containsString("alias"), containsString("length"), containsString("features"), containsString("attributes"))
			.assertThat().body("features.size()", is(118))
			//.log().all()
			;
	}
	@Test(priority=1) /*Validating getAggregationSites end point with where param NODE_STATUS='Completed'*/
	public void whereParamNODE_STATUSIsCompletedgetAggregationSites()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "NODE_STATUS='Completed'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("features.size()", is(118))
			.assertThat().body(containsString("Completed"))
			;
	}
	@Test(priority=2) /*Validating getAggregationSites end point with where invali param NODE_STATUS='Completedd'*/
	public void whereInvalidParamNODE_STATUSIsCompleteddgetAggregationSites()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "NODE_STATUS='Completedd'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=3) /*Validating getAggregationSites end point with where wrong param NODE_STATUS="Completed"*/
	public void whereWrongParamNODE_STATUSIsCompletedgetAggregationSites()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "NODE_STATUS=\"Completed\"", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.spec(responseSpec)
			.assertThat().body("resultCode", is(1), "errorMessage", is("Failed to execute query."), "errorCode", is(400))
		;
	}
	@Test(priority=4) /*Validating getAggregationSites end point with invalid param returnGeometry=falsee*/
	public void InvalidreturnGeometryIsfalseegetAggregationSites()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "falsee")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("Parameter.returnGeometry must be of type Boolean (true/false)."), "errorCode", is(400))
		;
	}
	@Test(priority=5) /*Validating getAggregationSites end point with  param returnGeometry=true*/
	public void returnGeometryIstruegetAggregationSites()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "true")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("features.size()", is(118))
			.assertThat().body(containsString("geometryType"), containsString("esriGeometryPoint"), containsString("spatialReference"), containsString("wkid"), containsString("latestWkid"), containsString("geometry"))
		;
	}
	@Test(priority=6) /*Validating getAggregationSites end point with invalid param returnGeometry=truee*/
	public void invalidreturnGeometryIstrueegetAggregationSites()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "truee")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("Parameter.returnGeometry must be of type Boolean (true/false)."), "errorCode", is(400))
		;
	}
}
