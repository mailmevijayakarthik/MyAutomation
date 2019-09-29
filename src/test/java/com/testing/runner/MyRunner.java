package com.testing.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.stepdefinitions.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features=("src\\test\\resources\\features"),
				 glue= {"com.testing.stepdefinitions"},
				 strict = true,
				 plugin= {"pretty","html:target/cucumber",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
                 )

public class MyRunner extends BaseClass{
private TestNGCucumberRunner testNGCucumberRunner;

	
	@BeforeClass(alwaysRun = true)  
    public void setUpClass() throws Exception {  
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
    } 
	
	 @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
	    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
	        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
	  } 
	  @DataProvider  
	  public Object[][] scenarios() {  
	        return testNGCucumberRunner.provideScenarios();  
	  }  
	  @AfterClass(alwaysRun = true)  
	    public void tearDownClass() throws Exception {  
	        testNGCucumberRunner.finish();  
	       
	  } 
	
}
