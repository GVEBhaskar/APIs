package com.ResponseTimes;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseTime 
{
	
	@Test(priority=0)
	public void responseTimeReq1()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=1)
	public void responseTimeReq2()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=2)
	public void responseTimeReq3()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-03-25 00:00:00")
				.queryParam("endDate", "2019-04-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=3)
	public void responseTimeReq4()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "1eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-03-25 00:00:00")
				.queryParam("endDate", "2019-04-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=4)
	public void responseTimeReq5()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=5)
	public void responseTimeReq6()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	
	
	@Test(priority=6)
	public void responseTimeReq7()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "25-10-2019 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=7)
	public void responseTimeReq8()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-20 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=8)
	public void responseTimeReq9()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:01")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=9)
	public void responseTimeReq10()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=10)
	public void responseTimeReq11()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "24-11-2019 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=11)
	public void responseTimeReq12()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-25 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=12)
	public void responseTimeReq13()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "209-11-24 23:59:58")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=13)
	public void responseTimeReq14()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-23 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=14)
	public void responseTimeReq15()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-26 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=15)
	public void responseTimeReq16()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=16)
	public void responseTimeReq17()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:59")
				.queryParam("lastSolidId", "334378")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=17)
	public void responseTimeReq18()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=18)
	public void responseTimeReq19()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:5")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=19)
	public void responseTimeReq20()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:5")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=20)
	public void responseTimeReq21()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=21)
	public void responseTimeReq22()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-06-25 00:00:00")
				.queryParam("endDate", "2019-07-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=22)
	public void responseTimeReq23()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-01-25 00:00:00")
				.queryParam("endDate", "2019-02-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
	}
	
	@Test(priority=23)
	public void responseTimeReq24()
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-08-25 00:00:00")
				.queryParam("endDate", "2019-09-24 23:59:59")
				.request(Method.GET);
		System.out.println(response.getTime());
		System.out.println();
	}
}
