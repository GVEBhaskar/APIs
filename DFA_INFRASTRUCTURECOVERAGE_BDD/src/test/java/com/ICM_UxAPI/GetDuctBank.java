package com.ICM_UxAPI;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetDuctBank 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp()
	{
		RequestSpecBuilder reqSpec_Build = new RequestSpecBuilder();
		reqSpec_Build.addHeader("orgId", "123");
		reqSpec_Build.addHeader("clientId", "123");
		reqSpec_Build.addHeader("accesskey", "pass");
		reqSpec_Build.setBaseUri("http://dfaapigw01.dfa.local:8080/");
		reqSpec_Build.setBasePath("infrastructurecoverageuxapi/");
		reqSpec_Build.addPathParam("layer", "getDuctBank");
		reqSpec_Build.setContentType(ContentType.JSON);
		requestSpec = reqSpec_Build.build();
		
		ResponseSpecBuilder resSpec_Build = new ResponseSpecBuilder();
		resSpec_Build.expectHeader("Content-Type", "application/json");
		resSpec_Build.expectResponseTime(lessThan(60000L));
		responseSpec = resSpec_Build.build();		
	}
	@Test(priority=0) /*Validating getDuctBank end point with all valid params*/
	public void getDuctBankValidation()
	{
		given()
			.queryParams("where", "1=1", "returnGeometry", "false", "resultOffset", "0")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("owner"),containsString("stage"), containsString("ea1"), containsString("ea2"),
					containsString("fields"), containsString("name"), containsString("type"),
					containsString("alias"), containsString("length"), containsString("features"),
					containsString("attributes"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
			//.log().all()
			;
	}
	@Test(priority=1) /*Validating getDuctBank end point with where param stage='Completed'*/
	public void whereParamStageIsCompletedgetDuctBank()
	{
		given()
			.queryParams("where", "stage='Completed'", "resultOffset", "0", "returnGeometry", "false")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Completed"))
			//.assertThat().body(containsString("Construction"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
		;
	}
	@Test(priority=2) /*Validating getDuctBank end point with where Invalid param stage='Completedd'*/
	public void whereInvalidParamStageIsCompleteddgetDuctBank()
	{
		given()
			.queryParams("where", "stage='Completedd'", "resultOffset", "0", "returnGeometry", "false")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1))
			.assertThat().body("errorMessage", is("No records found"))
			.assertThat().body("errorCode", is(400))
			;
	}
	@Test(priority=3) /*Validating getDuctBank end point with where Wrong format param stage="Completed"*/
	public void whereWrongFormatParamStageIsCompletedgetDuctBank()
	{
		given()
			.queryParams("where", "stage=\"Completed\"", "resultOffset", "0", "returnGeometry", "false")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1))
			.assertThat().body("errorMessage", is("Failed to execute query."))
			.assertThat().body("errorCode", is(400))
		;
	}
	@Test(priority=4) /*Validating getDuctBank end point with where param stage='Construction'*/
	public void whereParamStageIsConstructiongetDuctBank()
	{
		given()
			.queryParams("where", "stage='Construction'", "resultOffset", "0", "returnGeometry", "false")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Construction"))
			.assertThat().body(containsString("Completed"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
			;	
	}
	@Test(priority=5) /*Validating getDuctBank end point with param resultOffset=1001*/
	public void resultOffsetParamIs1001getDuctBank()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "1001", "returnGeometry", "false")
		.when()
			.get("{layer}")			
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
		;
	}
	@Test(priority=6) /*Validating getDuctBank end point with last param resultOffset=91000*/
	public void resultOffsetLastParamIs91000getDuctBank()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "91000", "returnGeometry", "false")
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
		;
	}
	@Test(priority=7) /*Validating getDuctBank end point with invalid param resultOffset=92000*/
	public void resultOffsetInvalidParamIs92000getDuctBank()
	{
		given()
			.queryParams("where", "1=1", "resultOffset", "92000", "returnGeometry", "false")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1))
			.assertThat().body("errorMessage", is("No records found"))
			.assertThat().body("errorCode", is(400))
		;
	}
	@Test(priority=8) /*Validating getDuctBank end point with param returnGeometry=true*/
	public void returnGeometryParamIstruegetDuctBank()
	{
		given()
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "true")
			.spec(requestSpec)
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("geometryType"), containsString("esriGeometryPolyline"), containsString("spatialReference"), containsString("wkid"), containsString("latestWkid"), containsString("geometry"), containsString("paths"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
			.assertThat().body("geometryType", is("esriGeometryPolyline"))
			;
	}
	@Test(priority=9) /*Validating getDuctBank end point with invalid param returnGeometry=truee*/
	public void returnGeometryInvalidParamIstrueegetDuctBank()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "truee")
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1))
			.assertThat().body("errorMessage", is("Parameter.returnGeometry must be of type Boolean (true/false)."))
			.assertThat().body("errorCode", is(400))
		;
	}
	@Test(priority=10) /*Validating getDuctBank end point with invalid param returnGeometry=falsee*/
	public void returnGeometryInvalidParamIsfalseegetDuctBank()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "falsee")
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1))
			.assertThat().body("errorMessage", is("Parameter.returnGeometry must be of type Boolean (true/false)."))
			.assertThat().body("errorCode", is(400))
		;
	}
	@Test(priority=11) /*Validating getDuctBank end point with valid where param owner='DFA'*/
	public void ownerIsDFA()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "owner='DFA'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("DFA"))
			.assertThat().body(containsString("EBU"), containsString("Conduct"), containsString("Dark Fibre Africa"), containsString("DFA Internal Contracts"))
			//.log().all()
			;
	}
	@Test(priority=12) /*Validating getDuctBank end point with valid where param owner='EBU'*/
	public void ownerIsEBU()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "owner='EBU'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("EBU"))
			.assertThat().body(containsString("DFA"), containsString("Conduct"), containsString("Dark Fibre Africa"), containsString("DFA Internal Contracts"))
			;
	}
	@Test(priority=13) /*Validating getDuctBank end point with valid where param owner='Conduct'*/
	public void ownerIsConduct()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "owner='Conduct'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{layer}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Conduct"))
			.assertThat().body(containsString("DFA"), containsString("EBU"), containsString("Dark Fibre Africa"), containsString("DFA Internal Contracts"))
			;
	}
}
