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

public class GETAccessPoints 
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
		reqSpec_Build.addPathParam("Operation", "getAccessPoints");
		reqSpec_Build.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Build.build();
		
		ResponseSpecBuilder resSpec_Build = new ResponseSpecBuilder();
		resSpec_Build.expectContentType("application/json");
		resSpec_Build.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Build.build();
	}
	@Test(priority=0) /*Validating getAccessPoints end point with all valid params*/
	public void getAccessPointsValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where",  "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("name"), containsString("owner"), containsString("stage"), containsString("ea3"), containsString("gpslatitude"), containsString("gpslongitude"), containsString("fields"), containsString("type"), containsString("alias"), containsString("length"), containsString("features"), containsString("attributes"))
			.assertThat().body("features.size()", is(1000))
			.assertThat().body("exceededTransferLimit", is(true))
			//.log().all();
		;
	}
	@Test(priority=1) /*Validating getAccessPoints end point with where param stage='Completed'*/
	public void whereParamnstageIsCompletedgetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "stage='Completed'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")			
			.assertThat().body(containsString("Completed"))
			.assertThat().body(containsString("Construction"))
			//.log().all()
		;
	}
	@Test(priority=2) /*Validating getAccessPoints end point with where invalid param stage='Completedd'*/
	public void whereInvalidParamstageIsCompletedgetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "stage='Completedd'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=3) /*Validating getAccessPoints end point with where wrong param stage="Completed"*/
	public void whereWrongParamstageIsCompletedgetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "stage=\"Completed\"", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("Failed to execute query."), "errorCode", is(400))
		;
	}
	@Test(priority=4) /*Validating getAccessPoints end point with where param stage='Construction'*/
	public void whereParamstageIsConstructiongetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "stage='Construction'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("Construction"), containsString("Completed"))
		;
	}
	@Test(priority=5) /*Validating getAccessPoints end point with where param owner='DFA'*/
	public void whereParamOwnerIsDFAgetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "owner='DFA'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("DFA"), containsString("Dark Fibre Africa"), containsString("EBU"), containsString("DFA Internal Contracts"), containsString("Conduct"))
		;
	}
	@Test(priority=6) /*Validating getAccessPoints end point with where param owner='EBU'*/
	public void whereParamOwnerIsEBUgetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "owner='EBU'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("DFA"), containsString("Dark Fibre Africa"), containsString("EBU"), containsString("DFA Internal Contracts"), containsString("Conduct"))
		;
	}
	@Test(priority=7) /*Validating getAccessPoints end point with where param owner='Conduct'*/
	public void whereParamOwnerIsConductgetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "owner='Conduct'", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("DFA"), containsString("Dark Fibre Africa"), containsString("EBU"), containsString("DFA Internal Contracts"), containsString("Conduct"))
		;
	}
	@Test(priority=8) /*Validating getAccessPoints end point with invalid param returnGeometry=falsee*/
	public void invalidreturnGeometryIsfalseegetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resulfOffset", "0", "returnGeometry", "falsee")
		.when()
			.get("{Operation}")
		.then()
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("Parameter.returnGeometry must be of type Boolean (true/false)."), "errorCode", is(400))
		;
	}
	@Test(priority=9) /*Validating getAccessPoints end point with param returnGeometry=true*/
	public void validreturnGeometryIstruegetAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "true")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("geometryType"), containsString("esriGeometryPolygon"), containsString("spatialReference"), containsString("wkid"), containsString("latestWkid"), containsString("features"), containsString("attributes"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
		;
	}
	@Test(priority=10) /*Validating getAccessPoints end point with invalid param returnGeometry=truee*/
	public void invalidreturnGeometryIstrueegetAccessPoints()
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
	@Test(priority=11) /*Validating getAccessPoints end point with valid resultOffset=1001*/
	public void validresultOffsetIs1001getAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "1001", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
			.assertThat().body(containsString("28.0495493961771"))
		;
	}
	@Test(priority=12) /*Validating getAccessPoints end point with last param resultOffset=71000*/
	public void lastParamresultOffsetIs71000getAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "71000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
		;
	}
	@Test(priority=13) /*Validating getAccessPoints end point with invalid resultOffset=75000*/
	public void invalidresultOffsetIs75000getAccessPoints()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "75000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
}
