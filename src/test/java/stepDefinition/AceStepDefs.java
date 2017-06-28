package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObject.NewSitePageObjects;
import pageObject.OldSitePageObjects;
import supportMethods.FileReader;
import webDriver.Driver;

public class AceStepDefs {





	@Given("^I am on \"(.*?)\"$")
	public void i_am_on(String url) throws Throwable {
		Driver.loadPage(url);
	}

	@Then("^my web page title is \"(.*?)\"$")
	public void my_web_page_title_is(String expectedBrowserTitle) throws Throwable {
		String browserTitle = Driver.getTitle();
		Assert.assertEquals(expectedBrowserTitle, browserTitle);
	}

	// OLD SITE PAGE OBJECTS
    @And("^I login with User ID \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void iLoginWithUserIDAndPassword(String id, String password) throws Throwable {
		OldSitePageObjects oldsite = new OldSitePageObjects();
		Driver.switchToFrame("contentFrame");
		oldsite.userId().sendKeys(id);
		oldsite.password().sendKeys(password);
    }

	@Given("^I select the Work Area dropdown$")
	public void iSelectTheWorkAreaDropdown() throws Throwable {
		OldSitePageObjects oldsite = new OldSitePageObjects();

		Actions action = new Actions(Driver.webdriver);

		WebElement element = Driver.findElement(By.cssSelector(".headlink.active>a>span"));
		action.moveToElement(element).build().perform();

	}

	@And("^I select the Statistics & Logs option$")
	public void iSelectTheStatisticsLogsOption() throws Throwable {
		OldSitePageObjects oldsite = new OldSitePageObjects();

		Actions action = new Actions(Driver.webdriver);
		WebElement element = Driver.findElement(By.xpath("//*[@class=' headlink active']//*[contains(text(), 'Statistics & Logs')]"));
		action.moveToElement(element).build().perform();
		action.click();
		action.perform();
		Thread.sleep(10000);

	}

	@Then("^I select Login$")
	public void iSelectLogin() throws Throwable {
        OldSitePageObjects oldsite = new OldSitePageObjects();
        oldsite.login().click();
	}

	@And("^I select Continue to the MEC area link$")
	public void iSelectContinueToTheMECAreaLink() throws Throwable {
		OldSitePageObjects oldsite = new OldSitePageObjects();
		oldsite.Continue().click();
	}

	@Then("^I record the Number Of Users$")
	public void iRecordTheNumberOfUsers() throws Throwable {
		String users = Driver.findElement(By.xpath("//*[@id='infopanel']//*[@class='infopaneltable']//*[contains(text(), 'Number of users:')]//following::td[1]")).getText();
		FileReader.addData("numberOfUsers" , users);


	}

	@Then("^I record the Number Of Classes$")
	public void iRecordTheNumberOfClasses() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I record the Number Of Courses$")
	public void iRecordTheNumberOfCourses() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}


	//NEW SITE PAGE OBJECTS
    @And("^I login to the New Site with User ID \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void iLoginToTheNewSiteWithUserIDAndPassword(String id, String password) throws Throwable {
        NewSitePageObjects newsite = new NewSitePageObjects();
        newsite.userId().sendKeys(id);
        newsite.password().sendKeys(password);
    }

    @Then("^I select Sign In$")
    public void iSelectSignIn() throws Throwable {
        NewSitePageObjects newsite = new NewSitePageObjects();
        newsite.signIn().click();
    }

}
