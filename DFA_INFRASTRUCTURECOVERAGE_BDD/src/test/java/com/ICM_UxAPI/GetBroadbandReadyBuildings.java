package com.ICM_UxAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class GetBroadbandReadyBuildings 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void setUP()
	{
		RequestSpecBuilder reqSpec_Build=new RequestSpecBuilder();
		reqSpec_Build.addHeader("orgId", "123");
		reqSpec_Build.addHeader("clientID", "123");
		reqSpec_Build.addHeader("accesskey", "pass");
		reqSpec_Build.setBaseUri("http://dfaapigw01.dfa.local:8080/");
		reqSpec_Build.setBasePath("/infrastructurecoverageuxapi");
		reqSpec_Build.addPathParam("Operation", "getBroadbandReadyBuildings");
		reqSpec_Build.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Build.build();
		
		ResponseSpecBuilder resSpec_Build=new ResponseSpecBuilder();
		resSpec_Build.expectHeader("Content-Type", "application/json");
		resSpec_Build.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Build.build();
	}
	@Test(priority=0) /*Validating getBroadbandReadyBuildings end point with all valid params*/
	public void getBroadbandReadyBuildingsValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"), containsString("Broadband_Buildings"), containsString("Building_Name"), containsString("Longitude"), containsString("Latitude"), containsString("fields"), containsString("name"), containsString("type"), containsString("alias"), containsString("length"), containsString("features"), containsString("attributes"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
			//.log().all()
		;
	}
	@Test(priority=1) /*Validating getBroadbandReadyBuildings end point with invalid where param 1=11*/
	public void invalidWhereParam1is11getBroadbandReadyBuildings()
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
			//.log().all()
			;
	}
	@Test(priority=2) /*Validating getBroadbandReadyBuildings end point with param returnGeometry=true*/
	public void whereParamreturnGeometryIstrueReadyBuildings()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "0", "returnGeometry", "true")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("geometryType", is("esriGeometryPolygon"))
			.assertThat().body(containsString("spatialReference"), containsString("wkid"), containsString("latestWkid"), containsString("geometry"), containsString("rings"))
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
		;
	}
	@Test(priority=3) /*Validating getBroadbandReadyBuildings end point with invalid param returnGeometry=truee*/
	public void whereInvalidParamreturnGeometryIstrueeReadyBuildings()
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
	@Test(priority=4) /*Validating getBroadbandReadyBuildings end point with invalid param returnGeometry=falsee*/
	public void whereInvalidParamreturnGeometryIsfalseeReadyBuildings()
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
	@Test(priority=5) /*Validating getBroadbandReadyBuildings end point with valid param resultOffset=1001*/
	public void resultOffsetParamIs1001getBroadbandReadyBuildings()
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
			.assertThat().body(containsString("28.12601621"))
			.assertThat().body("features.size()", is(1000))
		;
	}
	@Test(priority=6) /*Validating getBroadbandReadyBuildings end point with valid Last param resultOffset=8000*/
	public void resultOffsetLastParamIs8000getBroadbandReadyBuildings()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "8000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("features.size()", is(1000))
		;
	}
	@Test(priority=7) /*Validating getBroadbandReadyBuildings end point with valid invalid param resultOffset=9000*/
	public void resultOffsetInvalidParamIs9000getBroadbandReadyBuildings()
	{
		given()
			.spec(requestSpec)
			.queryParams("where", "1=1", "resultOffset", "9000", "returnGeometry", "false")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorMessage", is("No records found"), "errorCode", is(400))
		;
	}
	}
