package TestCases;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SliderDragAndDrop;
import pages.DemoOfTheForm;
import pages.FillingForm;
import pages.PlayGround;

public class ParallelChromeTest {
	public RemoteWebDriver driver=null;
	public String username = "bathinabharathi.cse";
	public String accesskey = "7RnBEXMrZE8c8mQoUm7uyne4bEmcrJdFZzcc6idk2LaKYKIdwu";
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	  @BeforeTest
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	public void setupSelenium(String browser, String version, String platform) throws Exception {
		  DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("browserName", browser);
	      capabilities.setCapability("version", version);
	      capabilities.setCapability("platform", platform); 
	      capabilities.setCapability("build", "Selenium Grid");
	      capabilities.setCapability("name", "Sample Test");
	      capabilities.setCapability("network", true); // To enable network logs
	      capabilities.setCapability("visual", true); // To enable step by step screenshot
	      capabilities.setCapability("video", true); // To enable video recording
	      capabilities.setCapability("console", true); // To capture console logs
	      try {
	          driver = new RemoteWebDriver(new java.net.URL("https://" + username + ":" +accesskey + gridURL),capabilities);
	      } catch (MalformedURLException e) {
	          System.out.println("Invalid grid URL");
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	}
 
	@Test(priority = 1)
	public void TestCaseOne() throws Exception {
		System.out.println("The thread ID for testTitle Chrome is " + Thread.currentThread().getId());
		driver.get("https://www.lambdatest.com/selenium-playground/");
		PlayGround pg = new PlayGround(driver);
		pg.clickLinkForForm();
		DemoOfTheForm fd = new DemoOfTheForm(driver);
		fd.passText();
		fd.clickButtonAndValidate();
	}
 
	@Test(priority = 2)
	public void TestCaseTwo() throws Exception {
		System.out.println("The thread ID for testTitle Chrome is " + Thread.currentThread().getId());
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
		PlayGround sp = new PlayGround(driver);
		sp.clickLinkForSliders();
		SliderDragAndDrop sdd = new SliderDragAndDrop(driver);
		sdd.sliderDrag();
	}
 
	@Test(priority = 3)
	public void TestCaseThree() throws Exception {
		System.out.println("The thread ID for testTitle Chrome is " + Thread.currentThread().getId());
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/input-form-demo");
		FillingForm sff = new FillingForm(driver);
		sff.formFill();
	}
 
	@AfterTest
	public void tearDown() {
		if (driver != null) {
	          ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
	          driver.quit();
	      }
	}

}
