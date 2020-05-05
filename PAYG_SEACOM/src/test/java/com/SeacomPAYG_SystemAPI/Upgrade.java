package com.SeacomPAYG_SystemAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Upgrade 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void setUP()
	{
		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
		reqSpecBuilder.setContentType(ContentType.JSON);
		reqSpecBuilder.setBaseUri("http://dfaapicrlab01.dfa.local:8080/");
		reqSpecBuilder.setBasePath("APIServer/rest/default/paygsystemapi/v1/");
		reqSpecBuilder.addPathParam("Operation", "upgradeOrder");
		reqSpecBuilder.addHeader("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1");
		requestSpec=reqSpecBuilder.build();
		ResponseSpecBuilder resSpecBuilder = new ResponseSpecBuilder();
		resSpecBuilder.expectContentType("application/json");
		resSpecBuilder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpecBuilder.build();
	}
	@Test(priority=0) /*Upgrade validation with valid OrderID & ProdID*/
	public void upgradeValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("OrderID", "74236", "prodID", "1401")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("payload"), containsString("Reference"), containsString("ProdName"), containsString("resultMessage"))
			.assertThat().body("resultCode", is(0), "errorCode", is(200))
		;
	}
	@Test(priority=1) /*Upgrade validation with invalid OrderID & ProdID*/
	public void upgradeInvalidValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("OrderID", "876161", "prodID", "15861")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(-1), "errorCode", is(422))
			.assertThat().body(containsString("resultMessage"))
		;
	}
	@Test(priority=2) /*Upgrade validation with invalid OrderID & Valid ProdID*/
	public void upgradeInvalidOrderIDnValidProdID()
	{
		given()
			.spec(requestSpec)
			.queryParams("OrderID", "6137341", "prodID", "1586")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(-1), "errorCode", is(422))
			.assertThat().body(containsString("resultMessage"))
		;
	}
	@Test(priority=3) /*Upgrade validation with Valid OrderID & Invalid ProdID*/
	public void upgradeValidOrderIDnInvalidProdID()
	{
		given()
			.spec(requestSpec)
			.queryParams("OrderID", "612397", "prodID", "14271")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(-1), "errorCode", is(422))
			.assertThat().body(containsString("resultMessage"))
		;
	}
	@Test(priority=4)
	public void upgradeNoParams()
	{
		given()
			.spec(requestSpec)
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode", is(40032), "errorMessage", is("Parameter OrderID is required for function upgradeOrder, but no value was provided"))
		;
	}
}
