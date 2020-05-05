package System_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthKey 
{
	@Test  /*Validation SystemAPI URL with Valid AuthKey*/
	public void validAuthKeywithValidParams()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/test-paygsystemapi/v1/verifydfaCircuitID";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1")
			.queryParam("dfaCircuitID", "PCL12-0000095")
			.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("The Response Body is: ");
		System.out.println(responseBody);
		
		JsonPath jsonPath=response.jsonPath();

		Assert.assertEquals(jsonPath.get("resultCode"), 0);
		Assert.assertEquals(jsonPath.get("resultMessage"), "success");
				
		System.out.println("Does Response Body contains CrctNb_Name? :"+responseBody.contains("CrctNb_Name"));
		System.out.println("Does Response Body contains Orde_OrderQuoteID? :"+responseBody.contains("Orde_OrderQuoteID"));
		System.out.println("Does Response Body contains Orde_Status? :"+responseBody.contains("Orde_Status"));
		System.out.println("Does Response Body contains OrIt_LineItemID? :"+responseBody.contains("OrIt_LineItemID"));
		System.out.println("Does Response Body contains OrIt_productfamilyid? :"+responseBody.contains("OrIt_productfamilyid"));
		System.out.println("Does Response Body contains prod_name? :"+responseBody.contains("prod_name"));
		System.out.println("Does Response Body contains prod_bandwidth_code? :"+responseBody.contains("prod_bandwidth_code"));
		System.out.println("Does Response Body contains OrIt_listprice? :"+responseBody.contains("OrIt_listprice"));
		
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
	
	
	
	
	

}

