package com.ResponseTimes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RespTimes {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.request(Method.GET);
		System.out.println(response.getTime());
		
		Response response1=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.request(Method.GET);
		System.out.println(response1.getTime());
		
			Response response2=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-03-25 00:00:00")
					.queryParam("endDate", "2019-04-24 23:59:59")
					.request(Method.GET);
			System.out.println(response2.getTime());
		
			Response response3=httpRequest.given().header("apiKey", "1eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-03-25 00:00:00")
					.queryParam("endDate", "2019-04-24 23:59:59")
					.request(Method.GET);
			System.out.println(response3.getTime());
		
			Response response4=httpRequest.given().request(Method.GET);
			System.out.println(response4.getTime());
		
			Response response5=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "2019-11-24 23:59:59")
					.request(Method.GET);
			System.out.println(response5.getTime());
		
			Response response6=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "25-10-2019 00:00:00")
					.queryParam("endDate", "2019-11-24 23:59:59")
					.request(Method.GET);
			System.out.println(response6.getTime());
		
			Response response7=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-20 00:00:00")
					.queryParam("endDate", "2019-11-24 23:59:59")
					.request(Method.GET);
			System.out.println(response7.getTime());
		
			Response response8=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:01")
					.queryParam("endDate", "2019-11-24 23:59:59")
					.request(Method.GET);
			System.out.println(response8.getTime());
		
			Response response9=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "2019-11-24 23:59:59")
					.request(Method.GET);
			System.out.println(response9.getTime());
		
			Response response10=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "24-11-2019 23:59:59")
					.request(Method.GET);
			System.out.println(response10.getTime());
		
			Response response11=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "2019-11-25 23:59:59")
					.request(Method.GET);
			System.out.println(response11.getTime());
		
			Response response12=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "209-11-24 23:59:58")
					.request(Method.GET);
			System.out.println(response12.getTime());
		
			Response response13=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "2019-11-23 23:59:59")
					.request(Method.GET);
			System.out.println(response13.getTime());
		
			Response response14=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-10-25 00:00:00")
					.queryParam("endDate", "2019-11-26 23:59:59")
					.request(Method.GET);
			System.out.println(response14.getTime());
		
			Response response15=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:59")
					.request(Method.GET);
			System.out.println(response15.getTime());
		
			Response response16=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:59")
					.queryParam("lastSolidId", "334378")
					.request(Method.GET);
			System.out.println(response16.getTime());
		
			Response response17=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:59")
					.request(Method.GET);
			System.out.println(response17.getTime());
		
			Response response18=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:5")
					.request(Method.GET);
			System.out.println(response18.getTime());
		
			Response response19 = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:5")
					.request(Method.GET);
			System.out.println(response19.getTime());
		
			Response response20 = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:59")
					.request(Method.GET);
			System.out.println(response20.getTime());
		
			Response response21 = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-06-25 00:00:00")
					.queryParam("endDate", "2019-07-24 23:59:59")
					.request(Method.GET);
			System.out.println(response21.getTime());
		
			Response response22 = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-01-25 00:00:00")
					.queryParam("endDate", "2019-02-24 23:59:59")
					.request(Method.GET);
			System.out.println(response22.getTime());
		
			Response response23 = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
					.queryParam("startDate", "2019-08-25 00:00:00")
					.queryParam("endDate", "2019-09-24 23:59:59")
					.request(Method.GET);
			System.out.println(response23.getTime());
			System.out.println();
		
		
		

	}

}
