package Process_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProcessBatchLinkUsage 
{
	@Test(priority=1) /*Validating Process Batch Link Usage with all valid parameters*/
	public void processBatchLinkUsageWithAllValidParams()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
			.queryParam("clientId", "frogfoot")
			.queryParam("startDate", "25-10-2019")
			.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
			.queryParam("endDate", "24-11-2019")
			.queryParam("productType", "GPON")
			.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 0);
		Assert.assertEquals(jsonPath.get("resultMessage"), "successfully processed the batch link usage, and sent report to [BhaskarVaraEswara.Ganugula@dfafrica.co.za]");
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=1800000);
		System.out.println();
	}
	
	@Test(priority=2) /*Validating Process Batch Link Usage with all valid parameters along with 2 valid emailLists*/
	public void batchLinkUsageWithAllValidParams2emailList()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
			.queryParam("clientId", "frogfoot")
			.queryParam("startDate", "25-10-2019")
			.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za,siyabonga.mpangase@dfarica.co.za")
			.queryParam("endDate", "24-11-2019")
			.queryParam("productType", "GPON")
			.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 0);
		Assert.assertEquals(jsonPath.get("resultMessage"), "successfully processed the batch link usage, and sent report to [BhaskarVaraEswara.Ganugula@dfafrica.co.za,siyabonga.mpangase@dfarica.co.za]");
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=1800000);
		System.out.println();
	 }
	
	@Test(priority=3) /*Validating ProcessBatchLinkUsage with all valid params except clientId*/
	public void batchLinkUsageWithAllValidParamsExceptClientID()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoo")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid ClientId [frogfoo]");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=4) /*Validating ProcessBatchLinkUsage with all valid params except No ClientId*/
	public void batchLinkUsagewithAllValidParamsExceptNoClientID()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("errorCode"), 40032);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Parameter clientId is required for function processBatchLinkUsage, but no value was provided");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=5) /*Validating ProcessBatchLinkUsage with all valid params except startDate*/
	public void batchLinkUsagewithAllValidParamsExceptStartDate()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "24-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid Start date. eg: '25-01-2019'");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=6) /*Validating ProcessBatchLinkUsage with all valid params except No startDate*/
	public void batchLinkUsagewithAllValidParamsExceptNoStartDate()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("errorCode"), 40032);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Parameter startDate is required for function processBatchLinkUsage, but no value was provided");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=7) /*Validating ProcessBatchLinkUsage with all valid params except EmailList*/
	public void batchLinkUsagewithAllValidParamsExceptEmailList()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "dfdf")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid E-mail address List");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=8) /*Validating ProcessBatchLinkUsage with all valid params except No EmailList*/
	public void batchLinkUsagewithAllValidParamsExceptNoEmailList()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-08-2019")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("errorCode"), 40032);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Parameter emailList is required for function processBatchLinkUsage, but no value was provided");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=9) /*Validating ProcessBatchLinkUsage with all valid params except endDate*/
	public void batchLinkUsagewithAllValidParamsExceptendDate()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "25-09-2019")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid End date. eg: '24-02-2019'");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=9) /*Validating ProcessBatchLinkUsage with all valid params except No endDate*/
	public void batchLinkUsagewithAllValidParamsExceptNoendDate()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("productType", "GPON")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("errorCode"), 40032);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Parameter endDate is required for function processBatchLinkUsage, but no value was provided");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=10) /*Validating ProcessBatchLinkUsage with all valid params except Product Type*/
	public void batchLinkUsagewithAllValidParamsExceptProductType()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-09-2019")
		.queryParam("productType", "pon")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 1);
		Assert.assertEquals(jsonPath.get("errorCode"), 400);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Invalid Product Type [pon]");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test(priority=11) /*Validating ProcessBatchLinkUsage with all valid params except No Product Type*/
	public void batchLinkUsagewithAllValidParamsExceptNoProductType()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-08-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-09-2019")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 0);
		Assert.assertEquals(jsonPath.get("resultMessage"), "successfully processed the batch link usage, and sent report to [BhaskarVaraEswara.Ganugula@dfafrica.co.za]");
		
		System.out.println("Status Code is: "+response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.statusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=1800000);
		System.out.println();
	}

}
