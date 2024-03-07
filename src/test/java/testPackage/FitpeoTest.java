package testPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pageObjectPackage.PageObjectClass;

public class FitpeoTest  extends BaseClass{
	public static Logger logger;
	public static WebDriver driver;
	public static PageObjectClass pageObject;
	
	@BeforeClass
	public static Logger logger() {
		logger = Logger.getLogger("FlipKart App");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		return logger;
	
	}
	@AfterSuite
	public static void quitMethod() {
		browserQuitMethod();
	}
	@Test(priority = 1, description =" Launch Browser Test")
	@Description("Launch User Defined Browser")
	@Epic("Fitpeo")
	@Feature("Feature 1")
	@Story("Test_Case 1")
	@Step("To verify the User Defined Browser launched or not")
	@Severity(SeverityLevel.BLOCKER)
	public static void launchBrowserMethod() {
		driver = launchBrowserMethod(readPropertyFile("Browser"));
		pageObject= new PageObjectClass(driver);
		staticWaitMethod(2000);
		maximizeWindowMethod();
		logger.info("************ Launch Chrome Browser*********");
		}
	
	@Test(priority = 2, description ="FlipKark Home Page")
	@Description("Flipkart Home Page Validation")
	@Epic("Fitpeo")
	@Feature("Feature 2")
	@Story("Test_Case 2")
	@Step("To verify the Home Page display or not")
	@Severity(SeverityLevel.CRITICAL)
	public static void UserLoginTitleMethod() throws IOException {
		getBrowserMethod(readPropertyFile("FlipkartURL"));
		staticWaitMethod(2000);
		logger.info("************ Open Flipkart Application*********");
		Assert.assertEquals(getTitleMethod(),readPropertyFile("FlipKartTitle"));	
		takesScreenShotMethod();
		Assert.assertTrue(isdisplayedMethod(pageObject.getFlipKartLogo()), "HomaPage Not Load SuccessFully");
		logger.info("************FlipKart HomePage Verified SuccessFully*********");
	}
	@Test(priority = 3, description ="FlipKark Search And Add To Cart")
	@Description("Flipkart Search and AddToCart Validation")
	@Epic("Fitpeo")
	@Feature("Feature 3")
	@Story("Test_Case 3")
	@Step("To verify the Search and AddToCart display or not")
	@Severity(SeverityLevel.MINOR)
	public static void SearchAndAddToCartMethod() throws Exception{
		
	}
	

//		public static void main(String[] args) throws InterruptedException {
//		
//
//			System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\eclipse1\\FitPeo\\Driver\\chromedriver.exe");
//
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--incognito");
//			
//			WebDriver driver = new ChromeDriver(options);
//			driver.manage().window().maximize();
//
//			driver.get("https://www.flipkart.com/");
//
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//			// verifying homepage is loading successfully
//
//			WebElement homePageLogo = driver.findElement(By.xpath("//img[@title='Flipkart']"));
//			if (homePageLogo.isDisplayed()) {
//				System.out.println("Homepage loaded successfully.");
//			} else {
//				System.out.println("Homepage failed to load");
//				driver.quit();
//				return;
//			}
//
//			WebElement searchLaptop = driver.findElement(By.xpath("//input[@type='text']"));
//			searchLaptop.sendKeys("Laptops");
//			searchLaptop.submit();
//
//			WebElement clicklaptop = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
//			clicklaptop.click();
//
//			// Selected Laptop Name
//			String selectedLaptopName = clicklaptop.getText();
//			System.out.println(selectedLaptopName);
//
//			// To switch to new Window and perform actions
//			Set<String> windowHandles = driver.getWindowHandles();
//			ArrayList<String> a = new ArrayList<>(windowHandles);
//
//			String title = driver.switchTo().window(a.get(1)).getTitle();
//			System.out.println(title);
//
//			WebElement pinCodeEnter = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
//			pinCodeEnter.sendKeys("600024");
//			pinCodeEnter.sendKeys(Keys.ENTER);
//
//			Thread.sleep(3000);
//			WebElement addToCart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
//			addToCart.click();
//
//			WebElement product = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']"));
//			String productName = product.getText();
//			System.out.println(productName);
//
//			// Verifying the prodcut name with the help of the title name
//			try {
//				Assert.assertEquals(selectedLaptopName, productName);
//				System.out.println("Selected Laptop and Laptop added in Cart are same");
//
//			} catch (Exception e) {
//				System.out.println("Wrong Product added in the cart ");
//			}
//			Thread.sleep(2000);
//			WebElement placeOrderButton = driver.findElement(By.xpath("//span[text()='Place Order']/parent::button"));
//			placeOrderButton.click();
//			
//			WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='text']"));
//			phoneNumber.sendKeys("7550137837");
//			
//			WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
//			continueButton.click();
//			
//			WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
//			name.sendKeys("Kishore");
//			
//			WebElement mobileNumber = driver.findElement(By.xpath("//input[@name='phone']"));
//			mobileNumber.sendKeys("9042350039");
//			
//			WebElement pincode = driver.findElement(By.xpath("//input[@name='pincode']"));
//			pincode.sendKeys("600023");
//			
//			WebElement locality = driver.findElement(By.xpath("//input[@name='addressLine2']"));
//			locality.sendKeys("Chennai");
//			
//			WebElement addressField = driver.findElement(By.xpath("//textarea[@name='addressLine1']"));
//			addressField.sendKeys("");
//			
//			
//			WebElement cityName = driver.findElement(By.xpath("//input[@name='city']"));
//			cityName.sendKeys("Chennai");
//			
//			WebElement stateDropDown = driver.findElement(By.xpath("//select[@name='state']"));
//			Select s = new Select(stateDropDown);
//			s.selectByValue("Tamil Nadu");
//			
//			WebElement saveAndDeliver = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
//			saveAndDeliver.click();
//			
//			WebElement continueButton1 = driver.findElement(By.xpath("//span[@id='to-payment']"));
//			continueButton.click();
//			
//			WebElement agreeAndContinue = driver.findElement(By.xpath("//button[text()='Accept & Continue']"));
//			agreeAndContinue.click();
//		
//			WebElement creditCard = driver.findElement(By.xpath("//label[@for='CREDIT']/input"));
//			creditCard.click();
//			
//			WebElement cardNUmber = driver.findElement(By.xpath("//input[@name='cardNumber']"));
//			cardNUmber.sendKeys("1234567891234567");
//			
//			WebElement cardMonth = driver.findElement(By.xpath("//select[@name='month']"));
//			Select s1 = new Select(cardMonth);
//			s.selectByValue("02");
//			
//			WebElement cardYear = driver.findElement(By.xpath("//select[@name='year']"));
//			Select s2 = new Select(cardYear);
//			s.selectByVisibleText("24");
//			
//			WebElement cvv = driver.findElement(By.xpath("//input[@type='password']"));
//			cardNUmber.sendKeys("123");
//	}
}
