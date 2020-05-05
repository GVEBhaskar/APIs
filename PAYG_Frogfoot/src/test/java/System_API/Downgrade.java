package System_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Downgrade {
	@Test  /*Verifying downgrade with Valid OrderID & Valid ProductID*/
	public void verifydowngradeWithValidOrderIDnValidProdID()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/test-paygsystemapi/v1/downgradeOrder";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1")
			.queryParam("OrderID", "612397")
			.queryParam("prodID", "1586")
			.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("The Response Body is: ");
		System.out.println(responseBody);
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("statusCode"), -1);
		Assert.assertEquals(jsonPath.get("errorCode"), 100);
		Assert.assertEquals(jsonPath.get("errorMessage"), "Order 612397 Could not be Downgraded");
															
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();}
}
