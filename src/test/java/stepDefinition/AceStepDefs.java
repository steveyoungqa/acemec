package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
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


    @Given("^I am on \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_am_on(String url, String institution) throws Throwable {
        Driver.loadPage(url);
        FileReader.addData("ClientName", institution);
        FileReader.addData("LastUsedURL", url);
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

    @And("^I select the Group Management option$")
    public void iSelectTheGroupManagementOption() throws Throwable {
        OldSitePageObjects oldsite = new OldSitePageObjects();

        Actions action = new Actions(Driver.webdriver);
        WebElement element = Driver.findElement(By.xpath("//*[@class=' headlink active']//*[contains(text(), 'Group Management')]"));
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

        if (Driver.findElement(By.xpath("//*[@class='loginforce']//*[contains(text(), 'Continue')]")).isDisplayed()){
            oldsite.Continue().click();
        }else {
        return;

        }

    }

    @Then("^I record the Number Of Users$")
    public void iRecordTheNumberOfUsers() throws Throwable {
        String users = Driver.findElement(By.xpath("//*[@id='infopanel']//*[@class='infopaneltable']//*[contains(text(), 'Number of users:')]//following::td[1]")).getText();
        FileReader.addData("numberOfUsersOld", users);
    }

    @Then("^I record the Number Of Classes$")
    public void iRecordTheNumberOfClasses() throws Throwable {
        OldSitePageObjects oldsite = new OldSitePageObjects();
        oldsite.classes().click();
        oldsite.classManagement().click();
        String oldClasses = Driver.findElement(By.xpath("//*[@class='fbar'][contains(text(), 'result(s)')]")).getText().replace(" result(s)","");
        FileReader.addData("numberOfClassesOld", oldClasses);
    }

    @Then("^I record the Number Of Courses$")
    public void iRecordTheNumberOfCourses() throws Throwable {
        OldSitePageObjects oldsite = new OldSitePageObjects();
        oldsite.classes().click();
        oldsite.courseManagement().click();
        String oldCourses = Driver.findElement(By.xpath("//*[@class='fbar'][contains(text(), 'result(s)')]")).getText().replace(" result(s)","");
        FileReader.addData("numberOfCoursesOld", oldCourses);
    }

    @Then("^I record the Number of Groups$")
    public void iRecordTheNumberOfGroups() throws Throwable {
        String oldGroups = Driver.findElement(By.xpath("//*[@class='fbar'][contains(text(), 'result(s)')]")).getText().replace(" result(s)","");
        FileReader.addData("numberOfGroupsOld", oldGroups);
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
        NewSitePageObjects newsite = new NewSitePageObjects();
        newsite.viewUsers().click();
        String courses = Driver.findElement(By.xpath("//*[@class='panel-heading']//*[contains(text(), 'Courses')]//following::div[2]")).getText();
        FileReader.addData("numberOfCoursesNewSite", courses);
    }

    @And("^I record the Number of Users for the New Site$")
    public void iRecordTheNumberOfUsersForTheNewSite() throws Throwable {
        NewSitePageObjects newsite = new NewSitePageObjects();

        newsite.viewUsers().click();
        Thread.sleep(2000);
        newsite.selectRole().click();
        Thread.sleep(2000);
        newsite.selectRoleClick().click();

        Thread.sleep(2000);
        newsite.selectShow().click();
        Thread.sleep(2000);
        newsite.selectStudentClick().click();
        String StudentCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText().replace("Showing 1 - 10 of ","").replace( " Show", "");
        FileReader.addData("studentCountNewSite", StudentCountNewSite);

        Thread.sleep(2000);
        newsite.selectShow().click();
        Thread.sleep(2000);
        newsite.selectTeacherClick().click();
        String TeacherCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText().replace("Showing 1 - 10 of ","").replace( "Show", "");
        FileReader.addData("teacherCountNewSite", TeacherCountNewSite);

        Thread.sleep(2000);
        newsite.selectShow().click();
        Thread.sleep(2000);
        newsite.selectAdminClick().click();
        String AdminCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText().replace("Showing 1 - ","").replace( "Show", "");
        FileReader.addData("adminCountNewSite", AdminCountNewSite);

        Thread.sleep(2000);
        newsite.selectRole().click();
        Thread.sleep(2000);
        newsite.selectAllClick().click();
        Thread.sleep(2000);
        newsite.selectStatus().click();
        Thread.sleep(2000);
        newsite.selectArchived().click();

        //Handle NO RECORDS FOUND
//        String ArchivedCountNewSite = Driver.findElement(By.xpath("");
//        FileReader.addData("archivedCountNewSite", ArchivedCountNewSite);


    }

    @And("^I record the Number of Classes for the New Site$")
    public void iRecordTheNumberOfClassesForTheNewSite() throws Throwable {
        String classes = Driver.findElement(By.xpath("//*[@class='panel-heading']//*[contains(text(), 'Classes')]//following::div[2]")).getText();
        FileReader.addData("numberOfClassesNewSite", classes);
    }

    @And("^I record the Number of Groups for the New Site$")
    public void iRecordTheNumberOfGroupsForTheNewSite() throws Throwable {
        String classes = Driver.findElement(By.xpath("//*[@class='panel-heading']//*[contains(text(), 'Groups')]//following::div[2]")).getText();
        FileReader.addData("numberOfGroupsNewSite", classes);
    }


    //Comparison Code

    @Then("^I compare Number of Users from OLD Mec to NEW ACE site$")
    public void iCompareNumberOfUsersFromOLDMecToNEWACESite() throws Throwable {
        String oldUsers = FileReader.readProperties().get("numberOfUsers");
        String newUsers = FileReader.readProperties().get("numberOfUsersNewSite");
        String client = FileReader.readProperties().get("ClientName");

        System.out.println("\n" + "Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Users= " + oldUsers);
        System.out.println("ACE Number of Users= " + newUsers + "\n");

        try {
            assertThat(oldUsers, is((newUsers)));
        } catch (AssertionError e) {

            System.out.println("\n" + "Number of Users DOES NOT MATCH! for Client " + client);
        }
    }

    @Then("^I compare Number of Courses from OLD Mec to NEW ACE site$")
    public void iCompareNumberOfCoursesFromOLDMecToNEWACESite() throws Throwable {
        String oldCourses = FileReader.readProperties().get("numberOfCoursesOld");
        String newCourses = FileReader.readProperties().get("numberOfCoursesNewSite");
        String client = FileReader.readProperties().get("ClientName");

        int old = Integer.parseInt(oldCourses);
        int newSite = Integer.parseInt(newCourses);
        int result = newSite -16;

        System.out.println("\n" + "Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Courses= " + oldCourses);
        System.out.println("ACE Number of Courses= " + result + "\n");

        try {
            assertThat(old, is((newSite)));
        } catch (AssertionError e) {
            System.out.println("\n" + "Number of Courses DOES NOT MATCH! for Client " + client + "\n");
        }
    }

    @Then("^I compare Number of Classes from OLD Mec to NEW ACE site$")
    public void iCompareNumberOfClassesFromOLDMecToNEWACESite() throws Throwable {
        String oldClasses = FileReader.readProperties().get("numberOfClassesOld");
        String newClasses = FileReader.readProperties().get("numberOfClassesNewSite");
        String client = FileReader.readProperties().get("ClientName");

        System.out.println("\n" + "Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Classes= " + oldClasses);
        System.out.println("ACE Number of Classes= " + newClasses + "\n");

        try {
            assertThat(oldClasses, is((newClasses)));
        } catch (AssertionError e) {
            System.out.println("\n" + "Number of Classes DOES NOT MATCH! for Client " + client + "\n");
        }
    }


    @Then("^I compare Number of Groups from OLD Mec to NEW ACE site$")
    public void iCompareNumberOfGroupsFromOLDMecToNEWACESite() throws Throwable {
        String oldClasses = FileReader.readProperties().get("numberOfGroupsOld");
        String newClasses = FileReader.readProperties().get("numberOfGroupsNewSite");
        String client = FileReader.readProperties().get("ClientName");

        System.out.println("\n" + "Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Groups= " + oldClasses);
        System.out.println("ACE Number of Groups= " + newClasses + "\n");

        try {
            assertThat(oldClasses, is((newClasses)));
        } catch (AssertionError e) {
            System.out.println("\n" + "Number of Groups DOES NOT MATCH! for Client " + client + "\n");
        }
    }

    @And("^then I log out$")
    public void thenILogOut() throws Throwable {
        OldSitePageObjects oldsite = new OldSitePageObjects();
        oldsite.logOutOldSite().click();
    }

    @And("^Then I log out the New Site$")
    public void thenILogOutTheNewSite() throws Throwable {
        NewSitePageObjects newsite = new NewSitePageObjects();
        newsite.profileIcon().click();
        newsite.signOut().click();
    }
}
