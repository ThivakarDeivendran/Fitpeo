package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {
	
	public static WebDriver driver;
	
	public PageObjectClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(xpath="//img[@title='Flipkart']")
	private WebElement FlipKartLogo;

	public WebElement getFlipKartLogo() {
		return FlipKartLogo;
	}
	
	

}
