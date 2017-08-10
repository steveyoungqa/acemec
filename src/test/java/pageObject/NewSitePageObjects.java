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

	public WebElement profileIcon () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='profileImage']"));
	}

	public WebElement dashBoardHome () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='dashboard']"));
	}

	public WebElement signOut () throws IOException {
		return Driver.findElement(By.xpath("//*[@data-original-title='Sign out']"));
	}

	public WebElement viewUsers () throws IOException {
		return Driver.findElement(By.xpath(".//*[@id='viewuser']"));
	}

	public WebElement selectRole () throws IOException {
		return Driver.findElement(By.xpath("(//*[@id='s2id_searchtype'])[1]"));
	}
	public WebElement selectRoleClick () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='select2-drop']//*[contains(text(), 'Role')]"));
	}

	public WebElement selectAllClick () throws IOException {
			return Driver.findElement(By.xpath("//*[@id='select2-drop']//*[contains(text(), 'All')]"));
		}

	public WebElement selectShow () throws IOException {
		return Driver.findElement(By.xpath("(//*[@id='s2id_searchtype'])[5]"));
	}

	public WebElement selectStudentClick () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='select2-drop']//*[contains(text(), 'Student')]"));
	}

	public WebElement selectTeacherClick () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='select2-drop']//*[contains(text(), 'Teacher')]"));
	}

	public WebElement selectAdminClick () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='select2-drop']//*[contains(text(), 'Admin')]"));
	}

	public WebElement selectStatus () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='s2id_userStatus']/a"));
	}
	public WebElement selectArchived () throws IOException {
		return Driver.findElement(By.xpath("//*[@id='select2-drop']//*[contains(text(), 'Archived')]"));
	}

}
