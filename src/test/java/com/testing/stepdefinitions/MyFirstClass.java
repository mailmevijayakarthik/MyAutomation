package com.testing.stepdefinitions;


import com.testing.pageobject.Homepage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyFirstClass extends BaseClass{
	
	
	
	@Given("I am in the first step")
	public void i_am_in_the_first_step() {
	   System.out.println("Welcome to my Family");
	   driver.get(prop.getProperty("browserurl"));
	    
	}
	
	@Given("Enter the second step")
	public void enter_the_second_step() {
	  
		System.out.println("I am in the second step ");
		
	}

	@When("I enter third step")
	public void i_enter_third_step() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("You are in Third step");
	}

	@Then("Answer is fourth step")
	public void answer_is_fourth_step() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("My name is VijayaKarthik");
	}
}
