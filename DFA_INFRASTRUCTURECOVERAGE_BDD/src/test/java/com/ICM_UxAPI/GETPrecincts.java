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

public class GETPrecincts 
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
		reqSpec_Build.addPathParam("Operation", "getPrecincts");
		reqSpec_Build.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Build.build();
		
		ResponseSpecBuilder resSpec_Build = new ResponseSpecBuilder();
		resSpec_Build.expectContentType("application/json");
		resSpec_Build.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Build.build();
	}
	@Test(priority=0) /*Validating getPrecincts end point with all valid params*/
	public void getPrecinctsValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("Precincts"), containsString("Quickbase_Status"), containsString("QBRecordID"), containsString("Third_Party_Dependant_For_Conne"), containsString("Latitude"), containsString("Longitude"), containsString("fields"), containsString("features"), containsString("attributes"))
			.assertThat().body("features.size()", is(1000))
			.assertThat().body("exceededTransferLimit", is(true))
		;
	}
	@Test(priority=1) /*Validating getPrecincts end point with where param Quickbase_Status='Completed'*/
	public void whereParamQuickbase_StatusIsCompletedgetPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "Quickbase_Status='Completed'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Completed"), containsString("WIP"), containsString("Planned"))
		;
	}
	@Test(priority=2) /*Validating getPrecincts end point with invalid where param Quickbase_Status='Completedd'*/
	public void whereInvalidParamQuickbase_StatusIsCompleteddgetPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "Quickbase_Status='Completedd'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=3) /*Validating getPrecincts end point with wrong where param Quickbase_Status="Completed"*/
	public void whereWrongParamQuickbase_StatusIsCompletedgetPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "Quickbase_Status=\"Completed\"", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("Failed to execute query."), "errorCode", is(400))
		;
	}
	@Test(priority=4) /*Validating getPrecincts end point with valid where param Quickbase_Status='Planned'*/
	public void whereParamQuickbase_StatusIsPlannedgetPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "Quickbase_Status='Planned'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Completed"), containsString("WIP"), containsString("Planned"))
		;
	}
	@Test(priority=5) /*Validating getPrecincts end point with valid where param Quickbase_Status='WIP'*/
	public void whereParamQuickbase_StatusIsPartialBuildCompletedgetPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "Quickbase_Status='WIP'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Completed"), containsString("WIP"), containsString("Planned"))
		;
	}
	@Test(priority=6) /*Validating getPrecincts end point with valid param resultOffset=1001*/
	public void validresultOffsetIs1001getPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "1001", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("features.size()", is(1000))
			.assertThat().body(containsString("28.25427695"))
		;
	}
	@Test(priority=7) /*Validating getPrecincts end point with last param resultOffset=3000*/
	public void lastParamresultOffsetIs3000getPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "3000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
		;
	}
	@Test(priority=8) /*Validating getPrecincts end point with invalid param resultOffset=4000*/
	public void invalidresultOffsetIs4000getPrecincts()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "4000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
}
