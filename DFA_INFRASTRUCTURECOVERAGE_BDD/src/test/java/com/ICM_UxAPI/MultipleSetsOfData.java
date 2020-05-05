package com.ICM_UxAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MultipleSetsOfData 
{
	@Test(dataProvider="multiSets")
	public void multiSetsData(String ewhere, String eresultOffset, String ereturnGeometry)
	{
		baseURI = "http://dfaapigw01.dfa.local:8080/infrastructurecoverageuxapi/";
		given()
			.headers("orgId", "123", "clientId", "123", "accesskey", "pass")
			.queryParams("where",  ewhere, "resultOffset", eresultOffset, "returnGeometry", ereturnGeometry)
		.when()
			.get("getDuctBank")
		.then()
			.contentType("application/json")
			//.assertThat().body("errorMessage", is("Unable to complete operation"))
			//.assertThat().body("resultCode", is(1))
			.log().body();
			
			
	}

@DataProvider(name = "multiSets")
public String[][] createMD5TestData() {
         
    return new String[][] {
    	{"1=1","0","false"}, 
    	{"stage='Completed'","0","false"}, {"stage='Completedd'","0","false"}, {"stage=\"Completed\"", "0", "false"},
    	{"stage='Construction'","0","false"}, {"ea1='W01P07'","0","false"}, 
    	{"stage=1=1", "1001", "false"}, {"stage=1=1", "91000", "false"}, {"stage=1=1", "92000", "false"},
    	{"stage=1=1", "0", "truee"}, {"stage=1=1", "0", "falsee"}
    };
}
}
