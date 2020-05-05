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

public class Authorization 
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
		requestSpec=reqSpec_Builder.build();
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test(priority=0) /*Invalid Authorization*/
	public void invalidAuthorization()
	{
		given()
			.spec(requestSpec)
			.header("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO91:1")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(401).statusLine("HTTP/1.1 401 Unauthorized")
			.assertThat().body("statusCode", is(401), "errorCode", is(4012), "errorMessage", is("Auth Token cannot be accepted: Auth Token not found"))
		;
	}
	@Test(priority=1) /*No Authorization*/
	public void noAuthorization()
	{
		given()
			.spec(requestSpec)
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(401).statusLine("HTTP/1.1 401 Unauthorized")
			.assertThat().body("statusCode", is(401), "errorCode", is(4011), "errorMessage", is("Auth Token not found or not authorized: Error - unable to find authorization"))
		;
	}
}
