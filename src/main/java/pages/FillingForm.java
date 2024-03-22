package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FillingForm {

		WebDriver driver;
	    String expectedErrorMessage = "Please fill out this field.";
	    String expectedSuccessMessage = "Thanks for contacting us, we will get back to you shortly.";
	 
	    @FindBy(how = How.ID, using = "name")
	    @CacheLookup
	    private WebElement textName;
	 
	    @FindBy(how = How.ID, using = "inputEmail4")
	    @CacheLookup
	    private WebElement textEmail;
	 
	    @FindBy(how = How.ID, using = "inputPassword4")
	    @CacheLookup
	    private WebElement textPassword;
	 
	    @FindBy(how = How.ID, using = "company")
	    @CacheLookup
	    private WebElement textCompany;
	 
	    @FindBy(how = How.ID, using = "websitename")
	    @CacheLookup
	    private WebElement textWebsiteName;
	 
	    @FindBy(how = How.NAME, using = "country")
	    @CacheLookup
	    private WebElement countryDropdown;
	 
	    @FindBy(how = How.NAME, using = "city")
	    @CacheLookup
	    private WebElement textCity;
	 
	    @FindBy(how = How.NAME, using = "address_line1")
	    @CacheLookup
	    private WebElement textAddress1;
	 
	    @FindBy(how = How.NAME, using = "address_line2")
	    @CacheLookup
	    private WebElement textAddress2;
	 
	    @FindBy(how = How.ID, using = "inputState")
	    @CacheLookup
	    private WebElement textState;
	 
	    @FindBy(how = How.ID, using = "inputZip")
	    @CacheLookup
	    private WebElement textZip;
	 
	    @FindBy(how = How.XPATH, using = "//button[text()='Submit']")
	    @CacheLookup
	    private WebElement buttonSubmit;
	 
	    public FillingForm(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	    public void formFill() {
	        buttonSubmit.click();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String actualErrorMessage = (String) js.executeScript("return document.getElementById('name').validationMessage");
	        System.out.println("Actual Error Message: " + actualErrorMessage);
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	        textName.sendKeys("bharathi");
	        textEmail.sendKeys("bharathi@yopmail.com");
	        textPassword.sendKeys("Sample@1234");
	        textCompany.sendKeys("Sample Company");
	        textWebsiteName.sendKeys("bharathi.com");
	        new Select(countryDropdown).selectByVisibleText("United States");
	        textCity.sendKeys("Dallas");
	        textAddress1.sendKeys("123, Mc Kence");
	        textAddress2.sendKeys("Dallaspuram");
	        textState.sendKeys("Texas");
	        textZip.sendKeys("1234567");
	        buttonSubmit.click();
	        WebElement messageElement = new WebDriverWait(driver, Duration.ofMillis(5000))
	                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@style='display: block;']")));
	        String messageText = messageElement.getText();
	        System.out.println("Text loaded: " + messageText);
	        Assert.assertEquals(messageText, expectedSuccessMessage);
	    }

}
