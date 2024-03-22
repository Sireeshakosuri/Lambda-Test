package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SliderDragAndDrop {

	
		
		WebDriver driver;
	    String slider15ExpectedValue = "95";
	 
	    @FindBy(how = How.XPATH, using = "//h4[text()=' Default value 15']/following::input[@class='sp__range'][1]")
	    @CacheLookup
	    private WebElement slider15;
	 
	    @FindBy(how = How.XPATH, using = "//h4[text()=' Default value 15']/following::output[@id='rangeSuccess']")
	    @CacheLookup
	    private WebElement slider15Value;
	 
	    public SliderDragAndDrop(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	    public void sliderDrag() throws Exception {
	        int initialPosition = Integer.parseInt(slider15.getAttribute("value"));
	        int targetPosition = 95;
	        int moveOffset = targetPosition - initialPosition;
	        for (int i = 1; i <= moveOffset; i++) {
	            slider15.sendKeys(Keys.ARROW_RIGHT);
	        }
	        Assert.assertTrue(slider15Value.getText().equals(slider15ExpectedValue));
	    }

}
