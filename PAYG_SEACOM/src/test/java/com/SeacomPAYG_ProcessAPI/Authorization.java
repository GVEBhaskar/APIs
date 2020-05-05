package com.SeacomPAYG_ProcessAPI;

import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Authorization 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest()
	public void startUP()
	{
		RequestSpecBuilder reqSpec_Builder = new RequestSpecBuilder();
		reqSpec_Builder.addQueryParam("clientId", "Seacom");
		reqSpec_Builder.addQueryParam("startDate", "25-01-2020");
		reqSpec_Builder.addQueryParam("endDate", "24-02-2020");
		reqSpec_Builder.addQueryParam("emailList", "Bhaskar.GVE@dfafrica.co.za");
		reqSpec_Builder.setBaseUri("http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/");
		reqSpec_Builder.setBasePath("paygprocessapi/v1/");
		reqSpec_Builder.addPathParam("Operation", "processBatchLinkUsage");
		reqSpec_Builder.setContentType(ContentType.JSON);
		requestSpec=reqSpec_Builder.build();
		
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(1800000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test(priority=0)
	public void invalidAuthorization()
	{
		given()
			.spec(requestSpec)
			.header("Authorization", "CALiveAPICreator oO4a1212PxNoiq0zkvs6peqQ:11qqqqqss2231")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(401).statusLine("HTTP/1.1 401 Unauthorized")
			.assertThat().body("statusCode", is(401), "errorCode", is(4012), "errorMessage", is("Auth Token cannot be accepted: Auth Token not found"))
		.log().all();
			;
	}
	@Test(priority=1)
	public void missingAuthorization()
	{
		given()
			.spec(requestSpec)
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(401).statusLine("HTTP/1.1 401 Unauthorized")
			.assertThat().body("statusCode", is(401), "errorCode", is(4011), "errorMessage", is("Auth Token not found or not authorized: Error - unable to find authorization"))
		.log().all();
	}
}
