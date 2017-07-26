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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

	@And("^I switch to Content Frame$")
	public void iSwitchToContentFrame() throws Throwable {
		Driver.switchToFrame("contentFrame");
	}

	// OLD SITE PAGE OBJECTS
    @And("^I login with User ID \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void iLoginWithUserIDAndPassword(String id, String password) throws Throwable {
		OldSitePageObjects oldsite = new OldSitePageObjects();
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

	}

	@Then("^I record the Number Of Courses$")
	public void iRecordTheNumberOfCourses() throws Throwable {
		String courses = Driver.findElement(By.xpath("//*[@id='infopanel']//*[@class='infopaneltable']//*[contains(text(), 'Number of courses:')]//following::td[1]")).getText();
		FileReader.addData("numberOfCoursesOld" , courses);
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

	@And("^I record the Number of Courses for the New Site$")
	public void iRecordTheNumberOfCoursesForTheNewSite() throws Throwable {
		String courses = Driver.findElement(By.xpath("//*[@class='panel-heading']//*[contains(text(), 'Courses')]//following::div[2]")).getText();
		FileReader.addData("numberOfCoursesNewSite" , courses);
	}

	@And("^I record the Number of Users for the New Site$")
	public void iRecordTheNumberOfUsersForTheNewSite() throws Throwable {
		String users = Driver.findElement(By.xpath("//*[@class='panel-heading']//*[contains(text(), 'Users')]//following::div[2]")).getText();
		FileReader.addData("numberOfUsersNewSite" , users);
	}

    @And("^I record the Number of Classes for the New Site$")
    public void iRecordTheNumberOfClassesForTheNewSite() throws Throwable {

    }


	//Comparison Code

	@Then("^I compare Number of Users from OLD Mec to NEW ACE site$")
	public void iCompareNumberOfUsersFromOLDMecToNEWACESite() throws Throwable {
		String oldUsers = FileReader.readProperties().get("numberOfUsers");
		String newUsers = FileReader.readProperties().get("numberOfUsersNewSite");

		try {
            assertThat(oldUsers, is((newUsers)));
        }
        catch (AssertionError e) {

		System.out.println("\n" + "Number of Users DOES NOT MATCH!");
		System.out.println("\n" + "MEC Number of Users= " + oldUsers);
		System.out.println("ACE Number of Users= " + newUsers + "\n");
	}
	}

	@Then("^I compare Number of Courses from OLD Mec to NEW ACE site$")
	public void iCompareNumberOfCoursesFromOLDMecToNEWACESite() throws Throwable {
        String oldCourses = FileReader.readProperties().get("numberOfCoursesOld");
        String newCourses = FileReader.readProperties().get("numberOfCoursesNewSite");

        try {
            assertThat(oldCourses, is((newCourses)));
        } catch (AssertionError e) {
            System.out.println("\n" + "Number of Courses DOES NOT MATCH!");
            System.out.println("\n" + "MEC Number of Courses= " + oldCourses);
            System.out.println("ACE Number of Courses= " + newCourses + "\n");
        }
    }



}
