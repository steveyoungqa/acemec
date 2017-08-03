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

	public WebElement classes () throws IOException {
		return Driver.findElement(By.cssSelector(".tab_3_center"));
	}

	public WebElement classManagement () throws IOException {
		return Driver.findElement(By.cssSelector("#course3>h3"));
	}

	public WebElement courseManagement () throws IOException {
		return Driver.findElement(By.cssSelector("#course1>h3"));
	}

	public WebElement statsLogs () throws IOException {
		return Driver.findElement(By.xpath("//*[@class=' headlink active']//*[contains(text(), 'Statistics & Logs')]"));

    }

	public WebElement Continue () throws IOException {
        return Driver.findElement(By.xpath("//*[@class='loginforce']//*[contains(text(), 'Continue')]"));
    }

	public WebElement logOutOldSite () throws IOException {
		return Driver.findElement(By.cssSelector("#b_head_logout"));
	}
}
