package com.testing.stepdefinitions;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.testing.utils.BaseRestTest;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTAssuredStepdef extends BaseRestTest{


	

	@Given("GET weather for the city {string}")
	public void get_weather_for_the_city(String place) {
		RestAssured.baseURI=prop.getProperty("Endpoint.baseurl");
		
		// Request Object 
		RequestSpecification httprequest=RestAssured.given();
				
		// Response Object 
		Response response = httprequest.request(Method.GET, "utilities/weather/city/"+place);
		
		// print response 
		
				String Responsebody= response.getBody().asString();
				System.out.println("Response Body :"+ Responsebody);
				int statuscode = response.statusCode();
				System.out.println("StatusCode :"+ statuscode);
				
	}

	
	@Given("Register a new customer")
	public void register_a_new_customer() {
	    
RestAssured.baseURI=prop.getProperty("Endpoint.baseurl");
		
		// Request Object 
		RequestSpecification httprequest=RestAssured.given();
		
		/*
		 * // Basic Authentication with Username and password PreemptiveBasicAuthScheme
		 * auth = new PreemptiveBasicAuthScheme(); auth.setUserName("user");
		 * auth.setPassword("fdfd");
		 * 
		 * RestAssured.authentication=auth;
		 */
		
		
		// Request Parameters 
		JSONObject requestParams=new JSONObject();
		
		  requestParams.put("FirstName","JohnXYZ");
		  requestParams.put("LastName","XYZJohn");
		  requestParams.put("UserName","JohnXYZ");
		  requestParams.put("Password","JohnXYZxyx");
		  requestParams.put("Email","JohnXYZ@gmail.com");
		  
		  httprequest.header("Content-Type","application/json");
		  httprequest.body(requestParams.toJSONString()); // attach above data to the request
				
		// Response Object 
		Response response = httprequest.request(Method.POST, "customer/register");
		
		// print response 
		
				String Responsebody= response.getBody().asString();
				System.out.println("Response Body :"+ Responsebody);
				int statuscode = response.statusCode();
				System.out.println("StatusCode :"+ statuscode);
				
			
				
		// Verification checkpoints
		/*
		 * Verify the Header response Content-Encoding is gzip
		 */
				
		 String contentheader= response.header("Content-Encoding");
		 Assert.assertEquals(contentheader, "gzip");
		 
		 // To verify any specific object in the response 
		 
			String errorreason= response.jsonPath().get("fault");
			Assert.assertEquals(errorreason, "FAULT_USER_ALREADY_EXISTS");
		 
	}
	
}
