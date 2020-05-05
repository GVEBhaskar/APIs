package com.SeacomPAYG_ProcessAPI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProcessBatchLinkUsage 
{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeTest()
	public void startUP()
	{
		RequestSpecBuilder reqSpec_Builder = new RequestSpecBuilder();
		reqSpec_Builder.addHeader("Authorization", "CALiveAPICreator FgkjOvIHVljki2fOeMYn:1");
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
	//@Test(priority=0) /*Validating Process Batch Link Usage with all valid parameters*/
	public void processBatchLinkUsageWithAllValidParams()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "25-01-2020", "endDate", "24-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(0), "resultMessage", is("successfully processed the batch link usage, and sent report to [Bhaskar.GVE@dfafrica.co.za]"))
			//.log().all()
		;
	}
	@Test(priority=1) /*Validating Process Batch Link Usage with all valid parameters along with 2 valid emailLists*/
	public void batchLinkUsageWithAllValidParams2emailList()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "25-01-2020", "endDate", "24-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za,siyabonga.mpangase@dfarica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(200).statusLine("HTTP/1.1 200 OK")
			.assertThat().body("resultCode", is(0), "resultMessage", is("successfully processed the batch link usage, and sent report to [Bhaskar.GVE@dfafrica.co.za,siyabonga.mpangase@dfarica.co.za]"))
		//.log().body()
			;
	}
	@Test(priority=2) /*Validating ProcessBatchLinkUsage with all valid params except clientId*/
	public void batchLinkUsageWithAllValidParamsExceptClientID()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seaco", "startDate", "25-01-2020", "endDate", "24-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorCode", is(400), "errorMessage", is("Invalid ClientId [seaco]"))
			//.log().body()
			;
	}
	@Test(priority=3) /*Validating ProcessBatchLinkUsage with all valid params except No ClientId*/
	public void batchLinkUsagewithAllValidParamsExceptNoClientID()
	{
		given()
			.spec(requestSpec)
			.queryParams("startDate", "25-01-2020", "endDate", "24-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode",  is(40032), "errorMessage", is("Parameter clientId is required for function processBatchLinkUsage, but no value was provided"))
			//.log().body()
			;
	}
	@Test(priority=4) /*Validating ProcessBatchLinkUsage with all valid params except startDate*/
	public void batchLinkUsagewithAllValidParamsExceptStartDate()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "24-01-2020", "endDate", "24-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorCode", is(400), "errorMessage", is("Invalid Start date. eg: '25-01-2019'"))
		;
	}
	@Test(priority=5) /*Validating ProcessBatchLinkUsage with all valid params except No startDate*/
	public void batchLinkUsagewithAllValidParamsExceptNoStartDate()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "endDate", "25-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode", is(40032), "errorMessage", is("Parameter startDate is required for function processBatchLinkUsage, but no value was provided"))
		;
	}
	@Test(priority=6) /*Validating ProcessBatchLinkUsage with all valid params except EmailList*/
	public void batchLinkUsagewithAllValidParamsExceptEmailList()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "25-01-2020", "endDate", "24-02-2020", "emailList", "dfdf")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorCode", is(400), "errorMessage", is("Invalid E-mail address List"))
		;
	}
	@Test(priority=7) /*Validating ProcessBatchLinkUsage with all valid params except No EmailList*/
	public void batchLinkUsagewithAllValidParamsExceptNoEmailList()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "25-01-2020", "endDate", "24-02-2020")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode", is(40032), "errorMessage", is("Parameter emailList is required for function processBatchLinkUsage, but no value was provided"))
		;
	}
	@Test(priority=8) /*Validating ProcessBatchLinkUsage with all valid params except endDate*/
	public void batchLinkUsagewithAllValidParamsExceptendDate()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "25-01-2020", "endDate", "25-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorCode", is(400), "errorMessage", is("Invalid End date. eg: '24-02-2019'"))
		;
	}
	@Test(priority=9) /*Validating ProcessBatchLinkUsage with all valid params except No endDate*/
	public void batchLinkUsagewithAllValidParamsExceptNoendDate()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "25-01-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("statusCode", is(400), "errorCode", is(40032), "errorMessage", is("Parameter endDate is required for function processBatchLinkUsage, but no value was provided"))
		;
	}
	@Test(priority=10) /*Validating ProcessBatchLinkUsage with all valid params except Product Type*/
	public void batchLinkUsagewithAllValidParamsExceptProductType()
	{
		given()
			.spec(requestSpec)
			.queryParams("clientId", "Seacom", "startDate", "24-01-2020", "endDate", "25-02-2020", "emailList", "Bhaskar.GVE@dfafrica.co.za", "productType", "Hel")
		.when()
			.get("{Operation}")
		.then()
			.spec(responseSpec)
			.statusCode(400).statusLine("HTTP/1.1 400 Bad Request")
			.assertThat().body("resultCode", is(1), "errorCode", is(400), "errorMessage", is("Invalid Product Type [Hel]"))
		;
	}
}
