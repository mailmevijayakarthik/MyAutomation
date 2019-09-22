package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before 
	public void startupHooks() {
	System.out.println("Hooks: @Before Hook is executed ...");
}
    
    @After
    public void TestEndHooks() {
    	
    	System.out.println("Hooks: @After Hook is executed ...");
    }
}
