package com.testing.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.pageobject.Homepage;

import cucumber.api.java.en.Given;

public class InternetStepDef extends BaseClass{

	/**
	 * @throws InterruptedException
	 */
	@Given("click on Form Authentication link")
	public void click_on_Form_Authentication_link() throws InterruptedException {
	 Homepage home = new Homepage<Object>(driver);
	 	
	 List<WebElement> elements = home.getSingleElement();
	 for(WebElement name : elements) {
		 
		
		System.out.println(name.getText());
		
	 }
	 
	 
	 System.out.println(prop.getProperty("customerName"));
	}
}
