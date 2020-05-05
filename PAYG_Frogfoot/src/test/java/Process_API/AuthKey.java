package Process_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthKey 
{
	@Test (priority=1) /*Validation ProcessAPI URL with Valid AuthKey*/
	public void validAuthKeywithValidParams()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1")
			.queryParam("clientId", "frogfoot")
			.queryParam("startDate", "25-09-2019")
			.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
			.queryParam("endDate", "24-10-2019")
			.queryParam("productType", "gpon")
			.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("The Response Body is: ");
		System.out.println(responseBody);
		
		JsonPath jsonPath=response.jsonPath();
		System.out.println("The value of resultCode is: "+jsonPath.get("resultCode"));
		Assert.assertEquals(jsonPath.get("resultCode"), 0);
		//System.out.println(Assert.assertEquals(jsonPath.get("resultCode"), 0));
		System.out.println("The value of resultMessage is: "+jsonPath.get("resultMessage"));
		Assert.assertEquals(jsonPath.get("resultMessage"), "successfully processed the batch link usage, and sent report to [BhaskarVaraEswara.Ganugula@dfafrica.co.za]");
		System.out.println("Does Response Body contains the required text? :"+responseBody.contains("successfully processed the batch link usage"));
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=1800000);
		System.out.println();
	}
	
	@Test (priority=2) /*Validation ProcessAPI URL with Invalid AuthKey*/
	public void NoAuthKeywithValidParams()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given()
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-09-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-10-2019")
		.queryParam("productType", "gpon")
		.request(Method.GET);
		
		System.out.println("The Response Body is: ");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("errorCode"), 4011);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Auth Token not found or not authorized: Error - unable to find authorization");
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);
		
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 401 Unauthorized");
		
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	@Test (priority=3) /*Validating ProcessAPI URL with Invalid AuthKey*/
	public void InvalidAuthKeyWithValidParams()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4a1212PxNoiq0zkvs6peqQ:11qqqqqss2231")
		.queryParam("clientId", "frogfoot")
		.queryParam("startDate", "25-09-2019")
		.queryParam("emailList", "BhaskarVaraEswara.Ganugula@dfafrica.co.za")
		.queryParam("endDate", "24-10-2019")
		.queryParam("productType", "gpon")
		.request(Method.GET);
		
		System.out.println("The Response Body is:");
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("errorCode"), 4012);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Auth Token cannot be accepted: Auth Token not found");
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 401 Unauthorized");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
	}
	

}
