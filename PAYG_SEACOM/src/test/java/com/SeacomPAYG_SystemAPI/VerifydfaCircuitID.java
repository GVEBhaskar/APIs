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

public class VerifydfaCircuitID 
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
		reqSpec_Builder.addPathParam("Operation", "verifydfaCircuitID");
		reqSpec_Builder.addHeader("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1");
		requestSpec=reqSpec_Builder.build();
		
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test(priority=0)  /*Verifying dfaCircuitID with Valid Param*/
	public void verifydfaCircuitIDwithValidParams()
	{
		given()
			.spec(requestSpec)
			.queryParam("dfaCircuitID", "DFA21-0005039")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(0), "resultMessage", is("success"))
			.assertThat().body(containsString("CrctNb_Name"), containsString("Orde_OrderQuoteID"), containsString("Orde_Status"), containsString("OrIt_LineItemID"), containsString("prod_companyid"), containsString("prod_name"), containsString("prod_bandwidth_code"), containsString("OrIt_listprice"))
		;
	}
	@Test(priority=1) /*Verifying dfaCircuitID with invalid Param*/
	public void verifydfaCircuitIDwithinvalidParam()
	{
		given()
			.spec(requestSpec)
			.queryParam("dfaCircuitID", "DFA21-000503900")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(-1), "errorCode", is(400), "errorMessage", is("No record found for DFACircuitID : DFA21-000503900 confirm that the Order is on status 7.5.10 and Prod_bandwidth_code is not 'NULL'"))
		;
	}
	@Test(priority=2) /*Verifying dfaCircuitID without ID*/
	public void verifydfaCircuitIDwithoutParamID()
	{
		given()
			.spec(requestSpec)
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode", is(40032), "errorMessage", is("Parameter dfaCircuitID is required for function verifydfaCircuitID, but no value was provided"))
		;
	}
}
