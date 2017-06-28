package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webDriver.Driver;

import java.io.IOException;


public class OldSitePageObjects {


    public WebElement userId() throws IOException {
		
		return Driver.findElement(By.cssSelector("[id='form1:userid']"));
	}
	
	public WebElement password() throws IOException {
		
		return Driver.findElement(By.cssSelector("[id='form1:password']"));
	}

	public WebElement login () throws IOException {
	    return Driver.findElement(By.cssSelector("[id='form1:loginbutton']"));
    }

	public WebElement workAreaDropdown () throws IOException {
		return Driver.findElement(By.cssSelector(".headlink.active>a>span"));
	}

	public WebElement statsLogs () throws IOException {
		return Driver.findElement(By.xpath("//*[@class=' headlink active']//*[contains(text(), 'Statistics & Logs')]"));

    }

	public WebElement Continue () throws IOException {
        return Driver.findElement(By.xpath("//*[@class='loginforce']//*[contains(text(), 'Continue')]"));
    }
}
