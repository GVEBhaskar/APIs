package com.ICM_UxAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetPointToMultiPoint 
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
		reqSpec_Builder.addPathParam("Operation", "getPointToMultiPoint");
		reqSpec_Builder.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Builder.build();
		
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test(priority=0)/*Validating getPointToMultiPoint operation with all valid params*/
	public void getPointToMultiPointValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("NAME"), containsString("Shape.STArea()"), containsString("Shape.STLength()"), containsString("fields"), containsString("name"), containsString("type"), containsString("alias"), containsString("length"), containsString("features"), containsString("attributes"))
		;
	}
	@Test(priority=1) /*Validating getPointToMultiPoint end point with where param 1=11*/
	public void whereParam1Is11getPointToMultiPoint()
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
	@Test(priority=2)/*Validating getPointToMultiPoint end point with invalid param resultOffset=92000*/
	public void invalidresultOffsetIs92000getPointToMultiPoint()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "92000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=4)/*Validating getPointToMultiPoint end point with valid param returnGeometry=true*/
	public void returnGeometryIstruegetPointToMultiPoint()
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
	@Test(priority=5)/*Validating getPointToMultiPoint end point with invalid param returnGeometry=truee*/
	public void invalidreturnGeometryIstrueegetPointToMultiPoint()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resulfOffset", "0", "returnGeometry", "truee")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("Parameter.returnGeometry must be of type Boolean (true/false)."), "errorCode", is(400))
		;
	}
	@Test(priority=6)/*Validating getPointToMultiPoint end point with valid param returnGeometry=falsee*/
	public void returnGeometryIsfalseegetPointToMultiPoint()
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
