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

public class FetchLinkUsage 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void startUP()
	{
		RequestSpecBuilder reqSpec_Builder = new RequestSpecBuilder();
		reqSpec_Builder.setContentType(ContentType.JSON);
		reqSpec_Builder.setBaseUri("http://dfaapicrlab01.dfa.local:8080/");
		reqSpec_Builder.setBasePath("APIServer/rest/default/paygsystemapi/v1/");
		reqSpec_Builder.addPathParam("Operation", "fetchLinkUsage");
		reqSpec_Builder.addHeader("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1");
		requestSpec=reqSpec_Builder.build();
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test(priority=0) /*Validating fetchLinkUsage with valid orderID*/
	public void fetchLinkUsagewithValidOrderID()
	{
		given()
			.spec(requestSpec)
			.queryParam("orderID", "600221")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(0))
			.assertThat().body(containsString("resultMessage"), containsString("CrctNb_Name"), containsString("Orde_reference"), containsString("Orde_OrderQuoteID"), containsString("Orde_OrderQuoteID"), containsString("oppo_link_type"), containsString("Prod_ProductFamilyID"), containsString("Prod_ProductID"), containsString("prod_name"), containsString("prod_min_bandwidth"), containsString("prod_max_bandwidth"), containsString("prod_bandwidth_code"), containsString("prod_companyid"))
		;
	}
	@Test(priority=1) /*Validating fetchLinkUsage with invalid orderID*/
	public void fetchLinkUsagewithinvalidOrderID()
	{
		given()
			.spec(requestSpec)
			.queryParam("orderID", "19247022")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(-1), "errorCode", is(400), "errorMessage", is("No Link Usage information found for orderID: 19247022"))
		;
	}
	@Test(priority=2) /*Validating fetchLinkUsage without orderID*/
	public void fetchLinkUsageWithoutorderID()
	{
		given()
			.spec(requestSpec)
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode", is(40032), "errorMessage", is("Parameter orderID is required for function fetchLinkUsage, but no value was provided"))
		;
	}
}
