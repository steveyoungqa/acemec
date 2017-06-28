package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import supportMethods.FileReader;
import webDriver.Driver;
import webDriver.GlobalVariables;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Hooks {
	
	private static Boolean runOnce = false;
	
	@Before
	public void readConfigFileAtStart() throws FileNotFoundException, IOException {
		if (!runOnce) {
			GlobalVariables.config = FileReader.readProperties();
			runOnce = true;
		}
	}
	
	@Before
	public void before(Scenario scenario) {
		
		GlobalVariables.scenario = scenario;
	}
	
	@After
	public void after(Scenario scenario) {
		System.out.println("Cleaning up the browser");
		try {
			Driver.webdriver.quit();
		} catch (NullPointerException e) {
			System.out.println("Browser already shut down.");
		}
	}
	}

