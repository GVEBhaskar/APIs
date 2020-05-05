package com.SeacomPAYG_UxAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class validParams 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest
	public void setUP()
	{
		RequestSpecBuilder reqSpec_Builder = new RequestSpecBuilder();
		reqSpec_Builder.setContentType(ContentType.JSON);
		reqSpec_Builder.setBaseUri("http://172.25.2.20:8080/");
		reqSpec_Builder.setBasePath("PAYGUxAPI/seacom/");
		reqSpec_Builder.addPathParam("Operation", "getlinkusage");
		reqSpec_Builder.addHeader("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk");
		requestSpec=reqSpec_Builder.build();
		
		ResponseSpecBuilder resSpec_Builder = new ResponseSpecBuilder();
		resSpec_Builder.expectContentType("application/json");
		resSpec_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=resSpec_Builder.build();
	}
	@Test
	public void validParamsValidation()
	{
		given()
			.spec(requestSpec)
			.queryParams("start_date", "2019-12-25 00:00:00", "end_date", "2020-01-24 23:55:00")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body(containsString("response_data"), containsString("services"), containsString("name"), containsString("id"), containsString("description"), containsString("timezone"), containsString("service_id"), containsString("ext_service_id"), containsString("date_time"), containsString("usage_data"), containsString("last_update"), containsString("utilization"), containsString("avg_in"), containsString("avg_out"))
			.rootPath("response_data")
			.assertThat().body("total", is(497), "resultset_size", is(497), "last_resultset", is(true))
			.log().all()
			;
	}
}
