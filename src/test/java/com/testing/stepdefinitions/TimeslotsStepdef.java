package com.testing.stepdefinitions;

import org.apache.poi.util.SystemOutLogger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.testing.javaobject.timeslots.Items;
import com.testing.javaobject.timeslots.Root;
import com.testing.utils.BaseRestTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TimeslotsStepdef extends BaseRestTest {
	
	/*Building the URI for the service 
	 * 
	 * */
	@Given("build the url for service")
	public void build_the_url_for_service() {
		RestAssured.baseURI=prop.getProperty("Timeslot.baseurl");
		requestHeaders();
	}
	
	public RequestSpecification requestHeaders() {
		RequestSpecification httprequest=RestAssured.given();
		httprequest.header("Content-Type","application/json");
		httprequest.header("x-api-key","AIzaSyCyHRnvuc5FKgEd5PUD6m88V_81ITPa0xg");
		httprequest.header("Referer","postman-heb-mls-qa1");
		mycontainer.put("httprequest", httprequest);
		return httprequest;
	}
	
	
	/*Adding the below parameters if there is any
		 Query Parameter
		 Body Parameter
	*/
	
	@And("needed parameters added to the API")
	public void needed_parameters_added_to_the_API() {
		RequestSpecification httprequest=(RequestSpecification) mycontainer.get("httprequest");
		httprequest.queryParam("store_id", "92");
		httprequest.queryParam("fulfillment_type", "delivery");
		httprequest.queryParam("date_from", "2019-12-20T08:00:00-06:00");
		httprequest.queryParam("date_to", "2019-12-20T21:00:00-06:00");
	}


	@When("run GET restservice details")
	public void run_GET_restservice_details() {
		RequestSpecification httprequest=(RequestSpecification) mycontainer.get("httprequest");
		Response response = httprequest.request(Method.GET, "/timeslot/v1/timeslots");
		mycontainer.put("response", response);
		
		Root Rootresponse = response.getBody().as(Root.class);
		System.out.println("Total timeslots available "+ Rootresponse.getItems().length);
		/*String timeslot_id= Rootresponse.getItems()[0].getTimeslot().getId();
		String date = Rootresponse.getItems()[0].getDate();
		System.out.println(timeslot_id+" Date :"+date);
		mycontainer.put("timeslotid", timeslot_id);
		mycontainer.put("date", date);
		*/
		
		for(Items item : Rootresponse.getItems()) {
			item.getTimeslot().getId();
			System.out.println(item.getTimeslot().getId());
		}
	}

	/*	Post a reservation using the timeslotid detail which is retrived */
	
	@When("build url and parameter for posting reservation in a happy path")
	public void build_url_and_parameter_for_posting_reservation_in_a_happy_path() {
		requestHeaders();
		RequestSpecification httprequest=(RequestSpecification) mycontainer.get("httprequest");
		JSONObject bodyparam = new JSONObject();
		JSONObject timeslot = new JSONObject();
		
		bodyparam.put("user_id", "242074");
		bodyparam.put("date", mycontainer.get("date"));
		bodyparam.put("timeslot", timeslot.put("id", mycontainer.get("timeslotid")));
		httprequest.body(bodyparam.toJSONString());
		Response response = httprequest.request(Method.POST, "/timeslot/v1/reservations");
		
		String responsebody = response.getBody().toString();
		System.out.println(responsebody);
	}
	
	@Then("validate the reponse details")
	public void validate_the_reponse_details() {
		
		Response response = (Response) mycontainer.get("response");
		
		JsonPath rep = response.getBody().jsonPath();
		
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
