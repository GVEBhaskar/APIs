package System_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthKeyNo {
	@Test /*Validating SystemAPI URL with No AuthKey*/
	public void InvalidAuthKeyWithValidParams()
	{
		RestAssured.baseURI = "http://dfaapicrlab01.dfa.local:8080/APIServer/rest/default/test-paygsystemapi/v1/verifydfaCircuitID";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given()
			.queryParam("dfaCircuitID", "PCL12-0000095")
			.request(Method.GET);
		
		System.out.println("The Response Body is:");
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
	}
}
