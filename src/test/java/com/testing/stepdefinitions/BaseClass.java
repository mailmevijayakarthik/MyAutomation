package com.testing.stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * @author Vijayakarthikeyan
 *
 */
public class BaseClass {
	public static RemoteWebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	
	/*Getting all the Properties of environment.properties file and based on this value loading the needed resource.properties
	 * Initalization of Driver value based on the environment.properties details - Docker | local 
	 * ExtentReport - Not yet customized */ 
	
	@BeforeSuite
	public void Initiaziation() throws MalformedURLException {
		System.out.println("Executing TestNG's @Beforesuite...");
		
		prop=getProperty();
		
		DriverInitialization(prop.getProperty("browsername"));
		
		//getlistoffiles();
		report=new ExtentReports();
		
	}
	
	/*Quiting the Driver which is created */
	
	@AfterMethod
	public void tearDown() {
		 report.flush();
		System.out.println("@AfterTest TestNG Annotation is tearing down");
		driver.quit();
	}
	
 
	/*Initializing Remote Driver 
	  Added implicit wait 
      Loaded the BrowserURl*/
	
 public RemoteWebDriver DriverInitialization(String browsername) throws MalformedURLException {
	   
	    String spec= prop.getProperty("DockerUrl");
	    String Execution=prop.getProperty("Executionmode");
	    if(Execution.equalsIgnoreCase("Docker")) {
	     System.out.println("Creating Driver for Docker container..");
	     if(browsername.equalsIgnoreCase("Chrome")) {
	    	 DesiredCapabilities cap = DesiredCapabilities.chrome();
	 		cap.setPlatform(Platform.LINUX);
	 		driver = new RemoteWebDriver(new URL(spec), cap);
	     }else if (browsername.equalsIgnoreCase("FireFox")) {
	    	 DesiredCapabilities cap = DesiredCapabilities.firefox();
		 		cap.setPlatform(Platform.LINUX);
		 		driver = new RemoteWebDriver(new URL(spec), cap);
		}
	    	 
	     }else if(Execution.equalsIgnoreCase("Local")) {
	    	 System.out.println("Creating Driver for Local Execution ..");
	    	 if(browsername.equalsIgnoreCase("Chrome")) {
	 			
	 			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\lib\\chromedriver.exe");
	 			driver = new ChromeDriver();
	 			
	 		}else if (browsername.equalsIgnoreCase("FireFox")) {
	 			
	 			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\lib\\geckodriver.exe");
	 			driver = new FirefoxDriver();
	 			
	 		}else if (browsername.equalsIgnoreCase("IE")) {
	 			
	 			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\lib\\IEDriverserver.exe");
	 			driver = new InternetExplorerDriver();
	 			
	 		}else if (browsername.equalsIgnoreCase("safari")) {
	 			driver = new SafariDriver();
	 		}
	    	
	    }
	 
		 
  System.out.println(driver+ "Driver created successfully");
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.get(prop.getProperty("browserurl"));
 return driver;
 }
 
 /*Get Property method to load the details / values from the property file */
 
 public Properties getProperty(){
		
		Properties prop = new Properties();
		System.out.println("Getting all the needed property files");
		try {
			prop.load(new FileInputStream("src/test/resources/environment.properties"));
			prop.load(new FileInputStream(prop.getProperty("resourcepath")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
 
 /*Need to be re-looked - Not completed */
 
 public  void getlistoffiles(){
    
	 File file = new File("prod");
	 String path = file.getAbsolutePath();
	 System.out.println("Root Path :"+ path);
	File file1 = new File(path);
	String[] files = file1.list();
	 
    for (String f : files)
    {
        System.out.println(f);
    }
 }
}
