package com.ResponseTimes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RT {
@Test(priority=0)
public void rtFebMar()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-02-25 00:00:00")
			.queryParam("endDate", "2019-03-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=1)
public void rtMarApril()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-03-25 00:00:00")
			.queryParam("endDate", "2019-04-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=2)
public void rtAprilMay()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-04-25 00:00:00")
			.queryParam("endDate", "2019-05-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=3)
public void rtMayJune()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-05-25 00:00:00")
			.queryParam("endDate", "2019-06-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=4)
public void rtJuneJuly()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-06-25 00:00:00")
			.queryParam("endDate", "2019-07-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=5)
public void rtJulyAug()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-07-25 00:00:00")
			.queryParam("endDate", "2019-08-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=6)
public void rtAugSep()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-08-25 00:00:00")
			.queryParam("endDate", "2019-09-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=7)
public void rtSepOct()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-09-25 00:00:00")
			.queryParam("endDate", "2019-10-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
@Test(priority=8)
public void rtOctNov()
{
	RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
	RequestSpecification httpRequest = RestAssured.given();
	Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
			.queryParam("startDate", "2019-10-25 00:00:00")
			.queryParam("endDate", "2019-11-24")
			.request(Method.GET);
	System.out.println(response.getTime());
}
}

