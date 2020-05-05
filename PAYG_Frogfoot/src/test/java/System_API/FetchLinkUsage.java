package System_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FetchLinkUsage 
{
	@Test  /*Verifying fetchLinkUsage with Valid OrderID*/
	public void verifyfetchLikUsagewithValidOrderID()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/test-paygsystemapi/v1/fetchLinkUsage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1")
			.queryParam("orderID", "612398")
			.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("The Response Body is: ");
		System.out.println(responseBody);
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), 0);
		Assert.assertEquals(jsonPath.get("resultMessage"), "found the Link Usage information for orderID: 612398");
		System.out.println("Does Payload contains CrctNb_Name? :"+responseBody.contains("CrctNb_Name"));
		System.out.println("Does Payload contains Orde_reference? :"+responseBody.contains("Orde_reference"));
		System.out.println("Does Payload contains Orde_OrderQuoteID? :"+responseBody.contains("Orde_OrderQuoteID"));
		System.out.println("Does Payload contains oppo_link_type? :"+responseBody.contains("oppo_link_type"));		
		System.out.println("Does Payload contains Prod_ProductFamilyID? :"+responseBody.contains("Prod_ProductFamilyID"));
		System.out.println("Does Payload contains Prod_ProductID? :"+responseBody.contains("Prod_ProductID"));		
		System.out.println("Does Payload contains prod_name? :"+responseBody.contains("prod_name"));
		System.out.println("Does Payload contains prod_min_bandwidth? :"+responseBody.contains("prod_min_bandwidth"));
		System.out.println("Does Payload contains prod_min_bandwidth? :"+responseBody.contains("prod_min_bandwidth"));
		System.out.println("Does Payload contains prod_max_bandwidth? :"+responseBody.contains("prod_max_bandwidth"));
		System.out.println("Does Payload contains prod_bandwidth_code? :"+responseBody.contains("prod_bandwidth_code"));	
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	
	
	
}
