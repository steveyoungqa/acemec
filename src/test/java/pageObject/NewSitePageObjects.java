package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.io.IOException;


public class NewSitePageObjects {

	public WebElement userId() throws IOException {
		
		return Driver.findElement(By.id("username"));
	}
	
	public WebElement password() throws IOException {
		
		return Driver.findElement(By.id("password"));
	}

	public WebElement signIn () throws IOException {
	    return Driver.findElement(By.id("signin"));
    }
}
