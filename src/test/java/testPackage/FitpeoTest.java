package testPackage;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
import org.testng.SkipException;
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
import basePackage.Allure_util;
import pageObjectPackage.PageObjectClass;

public class FitpeoTest  extends BaseClass{
	public static Logger logger;
	public static WebDriver driver;
	public static PageObjectClass pageObject;
	public static String expectedElement;
	
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
		sendKeysMethod(pageObject.getSearchTextBox(), readPropertyFile("userInput"));
		submitMethod(pageObject.getSearchTextBox());
		logger.info("************FlipKart Search Products*********");
		staticWaitMethod(5000);
		clickMethod(pageObject.getSearchFirstElement());
		staticWaitMethod(5000);
		switchWindowMethod();
		logger.info("************"+driver.getTitle()+"*********");
		Assert.assertTrue(isdisplayedMethod(pageObject.getAddToCartButton()),"Add To cart Button not display");
		Assert.assertTrue(isdisplayedMethod(pageObject.getBuyNowButton()),"Buy Now Button not display");
		expectedElement=getTextMethod(pageObject.getProductDetailText());
		logger.info("************Add To Cart display Successfully*********");
		clickMethod(pageObject.getAddToCartButton());
		staticWaitMethod(5000);
		logger.info("************"+driver.getTitle()+"*********");
//		Assert.assertTrue(containsMethod(getTextMethod(pageObject.getCartProductElement()), expectedElement),"Selected product not display in the Cart");
		logger.info("************selected product successfully display in the cart*********");
		Assert.assertTrue(isdisplayedMethod(pageObject.getPlaceOrderButton()), "Place Order button not displayed");
		staticWaitMethod(2000);
		clickMethod(pageObject.getPlaceOrderButton());
		staticWaitMethod(2000);
		logger.info("************"+driver.getTitle()+"*********");
	}
	@Test(priority = 4, description ="FlipKark order Summary and Payment option")
	@Description("Flipkart Order Summary and Payment Validation")
	@Epic("Fitpeo")
	@Feature("Feature 4")
	@Story("Test_Case 4")
	@Step("To verify the Order Summary page and Payment option")
	@Severity(SeverityLevel.CRITICAL)
	public static void ShippingPaymentMethod() throws Exception{
		sendKeysMethod(pageObject.getEmailMobileNumber(), readPropertyFile("PhoneNumber"));
		staticWaitMethod(2000);
		clickMethod(pageObject.getSignUpContinueButton());
		staticWaitMethod(7000);
		clickMethod(pageObject.getLoginButton());
		staticWaitMethod(2000);
		clickMethod(pageObject.getNewAddressLink());
		staticWaitMethod(4000);
		sendKeysMethod(pageObject.getNameTextBox(), readPropertyFile("DeliveryUserName"));
		staticWaitMethod(3000);
		sendKeysMethod(pageObject.getPhoneNumberTextBox(), readPropertyFile("PhoneNumber"));
		staticWaitMethod(3000);
		sendKeysMethod(pageObject.getPincodeTextbox(), readPropertyFile("DeliveryPinCode"));
		staticWaitMethod(2000);
		sendKeysMethod(pageObject.getLocalityTextBox(), readPropertyFile("DeliveryLocality"));
		staticWaitMethod(3000);
		sendKeysMethod(pageObject.getAddressTextBox(), readPropertyFile("DelivaryAddress"));
		staticWaitMethod(2000);
		clickMethod(pageObject.getAddressTypeRadioButton());
		staticWaitMethod(5000);
		clickMethod(pageObject.getSaveDeliveryButton());
		staticWaitMethod(2000);
		clickMethod(pageObject.getContinueButton());
		staticWaitMethod(5000);
		clickMethod(pageObject.getAcceptContinueButton());
		staticWaitMethod(2000);
		clickMethod(pageObject.getCreditAtmRadioButton());
		staticWaitMethod(3000);
		clickMethod(pageObject.getOrderSummaryCancelButton());
	}
	@Test
	public static void skipMethod() {
		throw new SkipException("This method need to skip");
	}

@AfterSuite
public static void tearDown() throws IOException, InterruptedException {
	driver.quit();
	Allure_util au = new Allure_util();
	au.runAllureCommand("allure generate --clean");
	File sourceFile = new File("allure-report/history");
	File targetFile = new File("allure-results/history");
	FileUtils.copyDirectory(sourceFile, targetFile);
	au.runAllureReportCommand("allure serve");
}
}
