package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DemoOfTheForm {

	
		WebDriver driver;
	    String expectedPageURL = "simple-form-demo";
	    String textToPass = "Welcome to LambdaTest";
	 
	    @FindBy(how = How.ID, using ="showInput")
	    @CacheLookup
	    private WebElement buttonShowMessage;
	 
	    @FindBy(how = How.ID, using = "user-message")
	    @CacheLookup
	    private WebElement textBoxUserMessage;
	 
	    public DemoOfTheForm(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	    public void validateURL() {
	        String actualPageURL = driver.getCurrentUrl();
	        Assert.assertTrue(actualPageURL.contains(expectedPageURL));
	    }
	 
	    public void passText() {
	        textBoxUserMessage.sendKeys(textToPass);
	    }
	 
	    public void clickButtonAndValidate() {
	        buttonShowMessage.click();
	        WebElement messageElement = new WebDriverWait(driver, Duration.ofMillis(5000))
	                .until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
	        String messageText = messageElement.getText();
	        System.out.println("Text loaded: " + messageText);
	        Assert.assertEquals(messageText, textToPass);
	    }
}
