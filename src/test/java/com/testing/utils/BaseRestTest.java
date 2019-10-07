package com.testing.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseRestTest {
	public static Properties prop;
	
@BeforeSuite
public void RESTstartup() {

	System.out.println("Starting REST ASSURED Test...");
	
	prop=getProperty();

}

private Properties getProperty() {

	Properties prop = new Properties();
	System.out.println("Getting all the needed property files");
	try {
		prop.load(new FileInputStream("src/test/resources/environment.properties"));
		prop.load(new FileInputStream(prop.getProperty("resourcepath")));
		//prop.loadFromXML(new FileInputStream("src/test/resources/qa/Endpoint.xml"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return prop;
}



}
