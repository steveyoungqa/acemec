package webDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supportMethods.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static WebDriver webdriver;
	public static DesiredCapabilities browser;
	public static Platform systemPlatform;
	public static DesiredCapabilities additionalCapabilities = new DesiredCapabilities();
	
	public static Boolean useBrowserStack() {
		return Boolean.valueOf(GlobalVariables.config.get("useBrowserstack"));
	}

	public static WebDriver getCurrentDriver() throws IOException {
		String browser = FileReader.readProperties().get("browser");

		if (webdriver == null) {

			if (browser.equals("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "/Users/syn3286/Documents/Repos/MacMillan/selenium_cucumber_framework/selenium/chromedriverOSX");
//                    System.setProperty("webdriver.chrome.driver", "/Users/steveyoung/Documents/Repos/acemec/selenium/chromedriverOSX");
//                    ONLY USE THE ABOVE FOR RUNNING LOCALLY IN THE IDE
				webdriver = new ChromeDriver();
			}
			if (browser.equals("Firefox")) {
				webdriver = new FirefoxDriver();
			}

		}
		return webdriver;
	}
	
	private static class BrowserCleanup implements Runnable {
		public void run() {
			System.out.println("Cleaning up the browser");
			try { 
				quit();
			} catch (Exception e)
			{
				System.out.println("Browser already shut down.");
			}
		}
	}
	
	public static void quit() throws IOException {
		getCurrentDriver().quit();
	}
	
	public static void close() throws IOException {
		getCurrentDriver().close();
	}

	public static void loadPage(String url) throws IOException {
		getCurrentDriver().get(url);
	}

	public static WebElement findElement(By element) throws IOException {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		getCurrentDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			new WebDriverWait(getCurrentDriver(), 5).until(ExpectedConditions.elementToBeClickable((By) element));
		} catch (Exception e) {
			
		}
		WebElement foundElement;

		try {
			foundElement = getCurrentDriver().findElement(element);
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("Waiting 5 seconds.");
			foundElement = getCurrentDriver().findElement(element);
		}
		return foundElement;
	}

	public static List<WebElement> findElements(By element) throws IOException {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getCurrentDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			new WebDriverWait(getCurrentDriver(), 1).until(ExpectedConditions
					.presenceOfAllElementsLocatedBy((By) element));
		}
		catch (TimeoutException e)
		{ 
			System.out.println("Supressed: " + e.getMessage());
		}
		return getCurrentDriver().findElements(element);

	}

	public static String getCurrentUrl() throws IOException {
		return getCurrentDriver().getCurrentUrl();

	}

	public static String getTitle() throws IOException {
		return getCurrentDriver().getTitle();
	}

	public static String screenshot(String filename) throws IOException {
		File file = ((TakesScreenshot) getCurrentDriver())
				.getScreenshotAs(OutputType.FILE);
		String filePath = ("./screenshot/" + filename + ".jpg");
		FileUtils.copyFile(file, new File(filePath));
		return filePath;
	}

	public static void embedScreenshot() throws IOException {
		
		byte[] screenshot = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
		GlobalVariables.scenario.embed(screenshot, "image/png");
	}

	public static void writeToReport(String string) {
		GlobalVariables.scenario.write(string);
	}
	
	public static WebDriver switchToWindow(String window) throws IOException {
		return getCurrentDriver().switchTo().window(window);
	}
	
	public static WebDriver switchToFrame(String name) throws IOException {
		return getCurrentDriver().switchTo().frame(name);
	}

	public static WebDriver switchToFrame(int index) throws IOException {
		return getCurrentDriver().switchTo().frame(index);
	}
	
	public static WebDriver switchToFrame(WebElement iframe) throws IOException {
		return getCurrentDriver().switchTo().frame(iframe);
	}
	
	public static String getWindowHandle() throws IOException {
		return getCurrentDriver().getWindowHandle();
	}
	
	public static Set<String> getWindowHandles() throws IOException {
		return getCurrentDriver().getWindowHandles();
	}


	public static void otherTab() throws IOException {
		ArrayList<String> tabs = new ArrayList<String> (webdriver.getWindowHandles());
		int index = 0;
		for (String tab : tabs)
		{
			if (tab != GlobalVariables.mainWindowHandle)
			{
				index = tabs.indexOf(tab);
			}
		}
		Driver.switchToWindow(tabs.get(index));
	}

	
	public static Dimension getResolution() throws IOException {
		return getCurrentDriver().manage().window().getSize();
	}

	public static void setResolution(int x, int y) throws IOException {
		getCurrentDriver().manage().window().setSize(new Dimension(x, y));
	}
	
	public static void maximise() throws IOException {
		getCurrentDriver().manage().window().maximize();
	}
	
	public static Actions actions() throws IOException {
		return new Actions(getCurrentDriver());
	}
	
	public static void dragAndDrop(WebElement start, WebElement finish) throws IOException {
		Driver.actions().moveToElement(finish).perform();
		Driver.actions().moveToElement(start).perform();
		Driver.actions().clickAndHold(start).perform();
		Driver.actions().moveToElement(finish).perform();
		Driver.actions().moveToElement(finish).perform();
		Driver.actions().release(finish).perform();
	}
	
	public static Boolean waitForUrlToContain(String url, int time) throws IOException {
		return new WebDriverWait(getCurrentDriver(), time).until(ExpectedConditions.urlContains(url));
	}
	
}
