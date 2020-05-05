package com.BDDRough;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Rough 
{
	@Test
	public void authPassing()
	{
		//baseURI="http://dfaapigw01.dfa.local:8080/infrastructurecoverageuxapi/";
		//RestAssured.defaultParser = Parser.JSON;
		//int sizeOfList=
	//	Response response=
		 given()
			.headers("orgId", "123", "clientId", "123", "accesskey", "pass")
			.pathParam("DuctbankLayer", "getDuctBank")
			.queryParams("where", "owner='EBU'", "resultOffset", "0", "returnGeometry", "false")
			
		.when()
			.get("http://dfaapigw01.dfa.local:8080/infrastructurecoverageuxapi/{DuctbankLayer}")
		//System.out.println(response.jsonPath().get("features.size()").toString());
		.then()
			.contentType(ContentType.JSON)
			.statusCode(200).statusLine("HTTP/1.1 200 OK").time(lessThan(60000l))
			//.assertThat().body("exceededTransferLimit", is(true))
			.assertThat().body("displayFieldName", is("name"))
			/*Validating where parameter 'EBU'*/
			.rootPath("features.attributes")
			.assertThat().body("owner", hasItem("EBU"))
			.assertThat().body("stage", hasItem("Completed"))
			//.assertThat().body("fieldAliases", everyItem(hasItem("owner")))
			//assertThat(status().isOk()).
			/*when().
        		get("/myEndpoint").
				then().
        		root("contents").
        		body("", hasItems(hasEntry("field2", "value2"), hasEntry("field1", "value1")),
             	"", hasItems(hasEntry("field1", "value3"), hasEntry("field2", "value4")))*/
			.assertThat().body(containsString("displayFieldName"), containsString("fieldAliases"))
			/*	.assertThat().body(containsString("fieldAliases"))
			.assertThat().body(containsString("owner"))
			.assertThat().body(containsString("stage"))
			.assertThat().body(containsString("ea1"))
			.assertThat().body(containsString("ea2"))
			.assertThat().body(containsString("fields"))
			.assertThat().body(containsString("name"))
			.assertThat().body(containsString("type"))
			.assertThat().body(containsString("alias"))
			.assertThat().body(containsString("length"))
			.assertThat().body(containsString("features"))
			.assertThat().body(containsString("attributes"))*/
			//.assertThat().body("features[0].attributes.owner", is("EBU"))
			
			//.body("features.size()", is(465))

			.log().body().body("features.size()", is(465))
	;
//		
	}
/*	@BeforeTest
	public void setUp(RequestSpecification requestSpec, ResponseSpecification responseSpec)
	{
		RequestSpecBuilder req_Builder = new RequestSpecBuilder();
		
		req_Builder.addHeader("orgId", "123");
		req_Builder.addHeader("clientId", "123");
		req_Builder.addHeader("accesskey", "pass");
		req_Builder.addParam("gpsLatitude", "-25.859770");
		req_Builder.addParam("gpsLongitude", "28.214739");
		req_Builder.addParam("bandwidth", "5");
		req_Builder.addParam("term", "1");
		req_Builder.addParam("product", "magellan");
		req_Builder.setBaseUri("http://dfaapigwlab01.dfa.local:8080/");
		req_Builder.setContentType(ContentType.JSON);
		requestSpec = req_Builder.build();
		
		ResponseSpecBuilder res_Builder = new ResponseSpecBuilder();
		
		res_Builder.expectStatusCode(200);
		res_Builder.expectStatusLine("HTTP/1.1 200 OK");
		res_Builder.expectHeader("Content-Type", "application/json");
		res_Builder.expectResponseTime(lessThan(60000L));
		responseSpec=res_Builder.build();
	}
	@Test
	public void requestAndResponseSpec()
	{
		RequestSpecification requestSpec = null;
		ResponseSpecification res_Builder = null;
		given()
			.spec(requestSpec)
		.when()
			.get("getPreFeasibilityUxAPI")
		.then()
			.spec(res_Builder);
	}*/
	
}
