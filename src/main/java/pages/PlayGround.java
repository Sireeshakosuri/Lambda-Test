package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PlayGround {
		WebDriver driver;
		 
	    @FindBy(how = How.XPATH, using = "//a[text()='Simple Form Demo']")
	    @CacheLookup
	    private WebElement linkForForm;
	 
	    @FindBy(how = How.XPATH, using = "//a[text()='Drag & Drop Sliders']")
	    @CacheLookup
	    private WebElement linkForSliders;
	 
	    public  PlayGround(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	    public void clickLinkForForm() {
	        linkForForm.click();
	    }
	 
	    public void clickLinkForSliders() {
	        linkForSliders.click();
	    }
}
