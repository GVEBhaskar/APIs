package System_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpgradeWithValidOrderIDNInvalidProdID {
	@Test  /*Verifying Upgrade with Valid OrderID & InValidProductID*/
	public void verifyUpgradeWithValidOrderIDnInValidProdID()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/test-paygsystemapi/v1/upgradeOrder";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("Authorization", "CALiveAPICreator udg9NY10GqmqSgiRohO9:1")
			.queryParam("OrderID", "612397")
			.queryParam("prodID", "14271")
			.request(Method.GET);
		
		String responseBody=response.getBody().asString();
		System.out.println("The Response Body is: ");
		System.out.println(responseBody);
		
		JsonPath jsonPath=response.jsonPath();
		Assert.assertEquals(jsonPath.get("resultCode"), -1);
		Assert.assertEquals(jsonPath.get("errorCode"), 422);
		Assert.assertEquals(jsonPath.get("resultMessage"), "Error while executing Resource JavaScript API-level function billingOrder - line 57: TypeError: Cannot read property \"Pric_PricingID\" from undefined in FU2048 at line number 57");
															
		System.out.println("Status Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is: "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is: "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		System.out.println();
	}
}
