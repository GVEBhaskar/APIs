package Process_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContentType 
{
	@Test(priority=1) /*Validating availability of ContentType*/
	public void contentTypeAvailabilityInHeaders()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Object, Authentication & Params passing
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1").request(Method.GET);
		
		//Printing Response Body
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//Validating & Printing Content-Type availability in Headers List
		boolean contentType=response.headers().toString().contains("Content-Type");
		System.out.println("Does the Response Body contains 'Content-Type' :"+contentType);
		
		//Printing & Validating Status Code
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is : "+statusCode);
		Assert.assertEquals(statusCode, 400);
		
		//Printing & Validating Status Line
		String statusLine=response.getStatusLine();
		System.out.println("Status Line is : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 400 Bad Request");
		
		//Printing & Validating Response Time
		long responseTime=response.getTime();
		System.out.println("Response Time is : "+responseTime);
		Assert.assertTrue(responseTime<=60000);
		System.out.println();
	}
	
	@Test (priority=2) /*Validating Format of Content Type*/
	public void contentTypeFormat()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/paygprocessapi/v1/processBatchLinkUsage";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Specify Object, Authorization and Params
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator oO4aPxNoiq0zkvs6peqQ:1").request(Method.GET);
		
		//Capture details of Content-Type and Validation
		String contentType=response.header("Content-Type");
		System.out.println("Content-Type is: "+contentType);
		Assert.assertEquals(contentType, "application/json");
		
		//Printing and Validating Status Code
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		Assert.assertEquals(statusCode, 400);
		
		//Printing and Validating Status Line
		String statusLine=response.getStatusLine();
		System.out.println("Status Line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 400 Bad Request");
		
		//Printing and Validating Response Time
		long responseTime=response.getTime();
		System.out.println("Response Time is: "+responseTime);
		Assert.assertTrue(responseTime<=60000);
	}
	

}
