package com.testing.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseRestTest {
	public static Properties prop;
	public static HashMap<String, Object> mycontainer;

@Parameters("myname")
@BeforeClass
public void RESTstartup(@Optional("Arul")String myname) {

	System.out.println("Starting REST ASSURED Test.......");
	
	System.out.println("My Name :"+myname);
	prop=getProperty();
	mycontainer = Datacontainer();
}

private Properties getProperty() {

	Properties prop = new Properties();
	System.out.println("Getting all the needed property files");
	try {
		prop.load(new FileInputStream("src/test/resources/environment.properties"));
		
		prop.loadFromXML(new FileInputStream("src/test/resources/qa/Endpoint.xml"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return prop;
}

@AfterTest
public void AfterTest() {
	System.out.println("Deleting the static variables ");
	mycontainer = null;
	prop= null;
}

private HashMap Datacontainer() {
	HashMap<String, Object> mycontainer = new HashMap<String,Object>();
	return mycontainer;
}


}
