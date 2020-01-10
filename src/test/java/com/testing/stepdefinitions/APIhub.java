package com.testing.stepdefinitions;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIhub {
	@Given("get details from apihub")
	public void get_details_from_apihub() {
		RestAssured.baseURI="";
		RequestSpecification httprequest=RestAssured.given();
		 httprequest.header("Content-Type","application/json");
		 httprequest.header("apikey","deleted");
		// Response Object 
		Response response = httprequest.request(Method.GET, "/v1/stores/");
		JsonObject jsonObjectmain = new JsonObject();
		jsonObjectmain=response.as(JsonObject.class);
		
		JsonArray jsonArray = new JsonArray();
		jsonArray=jsonObjectmain.getAsJsonArray("stores");
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			System.out.println("Store Name : "+jsonObject.get("name").getAsString()+ " Open Date : "+jsonObject.get("openedDate").getAsString()+"Closed Date:"+jsonObject.get("closedDate").getAsString() );
			
		}
		
	}
}
