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

public class GetAggregationBoundaries 
{	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void setUP()
	{
		RequestSpecBuilder reqSpec_Builder = new RequestSpecBuilder();
		reqSpec_Builder.addHeader("orgId", "123");
		reqSpec_Builder.addHeader("clientId", "123");
		reqSpec_Builder.addHeader("accesskey", "pass");
		reqSpec_Builder.setBaseUri("http://dfaapigw01.dfa.local:8080/");
		reqSpec_Builder.setBasePath("infrastructurecoverageuxapi/");
		reqSpec_Builder.addPathParam("Operation", "getAggregationBoundaries");
		reqSpec_Builder.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Builder.build();
		
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test(priority=0) /*Validating the operation getAggregationBoundaries with valid params*/
	public void getAggregationBoundariesValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("NAME"), containsString("fields"), containsString("name"), containsString("type"), containsString("alias"), containsString("length"), containsString("features"), containsString("attributes"))
		;
	}
	@Test(priority=1) /*Validating the operation getAggregationBoundaries with invalid whereParam 1=11*/
	public void whereParamNameIsVereeniginggetAggregationBoundaries()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=11", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=2) /*Validating the operation getAggregationBoundaries with invalid param resultOffset=91000*/
	public void invalidParamresultOffsetIs91000getAggregationBoundaries()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "91000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=3) /*Validating the operation getAggregationBoundaries with valid returnGeometry=true*/
	public void returnGeometryistruegetAggregationBoundaries()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "true")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("geometryType"), containsString("esriGeometryPolygon"), containsString("spatialReference"), containsString("wkid"), containsString("latestWkid"), containsString("geometry"), containsString("rings"))
		;
	}
	@Test(priority=4) /*Validating the operation getAggregationBoundaries with valid returnGeometry=truee*/
	public void returnGeometryistrueegetAggregationBoundaries()
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
	@Test(priority=5) /*Validating the operation getAggregationBoundaries with valid returnGeometry=falsee*/
	public void returnGeometryisfalseegetAggregationBoundaries()
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
}
