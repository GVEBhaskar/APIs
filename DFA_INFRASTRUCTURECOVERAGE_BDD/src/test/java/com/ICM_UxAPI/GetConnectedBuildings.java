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

public class GetConnectedBuildings 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void startUp()
	{
		RequestSpecBuilder reqSpec_Build = new RequestSpecBuilder();
		reqSpec_Build.addHeader("orgId", "123");
		reqSpec_Build.addHeader("clientId", "123");
		reqSpec_Build.addHeader("accesskey", "pass");
		reqSpec_Build.setBaseUri("http://dfaapigw01.dfa.local:8080/");
		reqSpec_Build.setBasePath("infrastructurecoverageuxapi/");
		reqSpec_Build.addPathParam("Operation", "getConnectedBuildings");
		reqSpec_Build.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Build.build();
		
		ResponseSpecBuilder resSpec_Build = new ResponseSpecBuilder();
		resSpec_Build.expectContentType("application/json");
		resSpec_Build.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Build.build();		
	}
	@Test(priority=0) /*Validating getConnectedBuildings end point with all valid params*/
	public void getConnectedBuildingsValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("DFA_Connected_Y_N"), containsString("QBRecordID"), containsString("Longitude"), containsString("Latitude"), containsString("fields"), containsString("name"), containsString("type"), containsString("alias"), containsString("length"), containsString("features"), containsString("attributes"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
			//.log().all()
		;
	}
	@Test(priority=1) /*Validating getConnectedBuildings end point with invalid param 1=11*/
	public void invalidwhere1Is11getConnectedBuildings()
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
	@Test(priority=2) /*Validating getConnectedBuildings end point with  valid param resultOffset=1001*/
	public void validresultOffsetIs1001getConnectedBuildings()
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
			.assertThat().body(containsString("28.80173561"))
		;
	}
	@Test(priority=3) /*Validating getConnectedBuildings end point with last param resultOffset=10000*/
	public void lastParamresultOffsetIs10000getConnectedBuildings()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "10000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
		;
	}
	@Test(priority=4) /*Validating getConnectedBuildings end point with invalid param resultOffset=29300011*/
	public void invalidresultOffsetIs29300011getConnectedBuildings()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "29300011", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	@Test(priority=5) /*Validating getConnectedBuildings end point with invalid param returnGeometry=falsee*/
	public void invalidreturnGeometryIsfalseegetConnectedBuildings()
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
	@Test(priority=6) /*Validating getConnectedBuildings end point with valid param returnGeometry=true*/
	public void validreturnGeometryIstruegetConnectedBuildings()
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
	@Test(priority=9) /*Validating getConnectedBuildings end point with invalid param returnGeometry=truee*/
	public void invalidreturnGeometryIstrueegetConnectedBuildings()
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
