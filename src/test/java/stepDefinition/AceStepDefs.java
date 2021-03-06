package stepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObject.NewSitePageObjects;
import pageObject.OldSitePageObjects;
import supportMethods.FileReader;
import webDriver.Driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
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
        String client = FileReader.readProperties().get("ClientName");
        oldsite.login().click();

        try {
            Driver.findElement(By.xpath("//*[@id='msgBox']//*[contains(text(), 'The user ID or password that you entered was not recognized')]"));
            System.out.println("\n" + "\033[0;1m" + "LOGIN OR PASSWORD IS INCORRECT FOR CLIENT INSTITUTION " + client);
            Driver.webdriver.close();
            System.exit(1);

        }
        catch (NoSuchElementException e) {

        }
    }

    @And("^I select Continue to the MEC area link$")
    public void iSelectContinueToTheMECAreaLink() throws Throwable {
        OldSitePageObjects oldsite = new OldSitePageObjects();

        try {
           Driver.findElement(By.xpath("//*[@class='loginforce']//*[contains(text(), 'Continue')]")).isDisplayed();
           oldsite.Continue().click();
        }
        catch (NoSuchElementException e)
        {
//            System.out.println("Continue page not displayed");
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
        String client = FileReader.readProperties().get("ClientName");
        newsite.signIn().click();

        try {
            Driver.findElement(By.xpath("//*[@id='divErrorMsg'][contains(text(), 'The username or password you entered is incorrect')]"));
            System.out.println("\n" + "\033[0;1m" + "LOGIN OR PASSWORD IS INCORRECT FOR CLIENT INSTITUTION " + client);
            Driver.webdriver.close();
            System.exit(1);

        }
        catch (NoSuchElementException e) {

        }


    }

    @And("^I record the Number of Courses for the New Site$")
    public void iRecordTheNumberOfCoursesForTheNewSite() throws Throwable {
        NewSitePageObjects newsite = new NewSitePageObjects();
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
        String StudentCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText();
        Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
        Matcher matcher = pattern.matcher(StudentCountNewSite);
        if (matcher.find()) {
            FileReader.addData("studentCountNewSite", matcher.group(1));
        }


        Thread.sleep(2000);
        newsite.selectShow().click();
        Thread.sleep(2000);
        newsite.selectTeacherClick().click();
        String TeacherCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText();
        Pattern pattern2 = Pattern.compile("\\d+ of (\\d+)");
        Matcher matcher2 = pattern2.matcher(TeacherCountNewSite);
        if (matcher2.find()) {
            FileReader.addData("teacherCountNewSite", matcher2.group(1));
        }

        Thread.sleep(2000);
        newsite.selectShow().click();
        Thread.sleep(2000);

        newsite.selectAdminClick().click();

        try {
            Driver.findElement(By.xpath("//*[@class='alert alert-danger ng-binding'][contains(text(), 'No records found.')]")).isDisplayed();
            FileReader.addData("adminCountNewSite", "0");
        }

        catch (NoSuchElementException e) {


            String AdminCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText();
            Pattern pattern3 = Pattern.compile("\\d+ of (\\d+)");
            Matcher matcher3 = pattern3.matcher(AdminCountNewSite);
            if (matcher3.find()) {
                FileReader.addData("adminCountNewSite", matcher3.group(1));
            }
        }

        Thread.sleep(2000);
        newsite.selectRole().click();
        Thread.sleep(2000);
        newsite.selectAllClick().click();
        Thread.sleep(2000);
        newsite.selectStatus().click();
        Thread.sleep(2000);
        newsite.selectArchived().click();

        try {
            Driver.findElement(By.xpath("//*[@class='alert alert-danger ng-binding'][contains(text(), 'No records found.')]")).isDisplayed();
            FileReader.addData("archivedCountNewSite", "0");
        }
        catch (NoSuchElementException e)
        {
            String ArchivedCountNewSite = Driver.findElement(By.xpath("//*[@id='userContentJws']//*[contains(text(), 'Showing')]")).getText();
            Pattern pattern4 = Pattern.compile("\\d+ of (\\d+)");
            Matcher matcher4 = pattern4.matcher(ArchivedCountNewSite);
            if (matcher4.find()) {
                FileReader.addData("archivedCountNewSite", matcher4.group(1));
            }
        }
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
        String oldUsers = FileReader.readProperties().get("numberOfUsersOld");

        String newStudents = FileReader.readProperties().get("studentCountNewSite");
        String newTeachers = FileReader.readProperties().get("teacherCountNewSite");
        String newAdmin = FileReader.readProperties().get("adminCountNewSite");
        String newArchived = FileReader.readProperties().get("archivedCountNewSite");

        int mecUsers = Integer.parseInt(oldUsers);
        int students = Integer.parseInt(newStudents);
        int teachers = Integer.parseInt(newTeachers);
        int admin = Integer.parseInt(newAdmin);
        int archived = Integer.parseInt(newArchived);

        int result = students+teachers+admin+archived;


        String client = FileReader.readProperties().get("ClientName");

        System.out.println("\n" + "\033[0;1m" +"Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Users=" + oldUsers);
        System.out.println("\n" + "ACE Number of Students=" + newStudents);
        System.out.println("\n" + "ACE Number of Teachers=" + newTeachers);
        System.out.println("\n" + "ACE Number of Admin=" + admin);
        System.out.println("\n" + "ACE Number of Archived=" + newArchived);

        System.out.println("\n" + "Total Number of ACE Users=" + result);

        try {
            assertEquals(mecUsers, is((result)));
        } catch (AssertionError e) {

            System.out.println("\n" + "Number of Users DOES NOT MATCH! for Client " + client);
            System.out.println("\n" + "MEC is " + oldUsers + " versus " + "ACE is " + result + "" +"\n");
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

        System.out.println("\033[0;1m" +"Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Courses= " + oldCourses);
        System.out.println("ACE Number of Courses= " + result);

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

        System.out.println("\n" + "\033[0;1m" + "Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Classes= " + oldClasses);
        System.out.println("ACE Number of Classes= " + newClasses);

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

        System.out.println("\n" + "\033[0;1m" +"Client Institution: " + client);
        System.out.println("\n" + "MEC Number of Groups= " + oldClasses);
        System.out.println("ACE Number of Groups= " + newClasses);

        try {
            assertThat(oldClasses, is((newClasses)));
        } catch (AssertionError e) {
            System.out.println("\n" + "Number of Groups DOES NOT MATCH! for Client " + client + "\n");
            System.out.println("\n");
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

    @Then("^I go back to the New Site Dashboard$")
    public void iGoBackToTheNewSiteDashboard() throws Throwable {
        NewSitePageObjects newsite = new NewSitePageObjects();
        newsite.dashBoardHome().click();
        Thread.sleep(4000);
    }

    @Then("^I quit the browser$")
    public void iQuitTheBrowser() throws Throwable {
        Driver.webdriver.close();
    }
}
