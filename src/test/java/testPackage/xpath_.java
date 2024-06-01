package testPackage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_ {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver surya = new ChromeDriver();
		surya.navigate().to("https://artoftesting.com/samplesiteforselenium");
		surya.manage().window().maximize();
		surya.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
WebElement a= surya.findElement(By.name("firstName"));
	  a.sendKeys("Surya");
	   Thread.sleep(3000);
	   surya.findElement(By.id("idOfButton")).click();
	   Thread.sleep(3000);
	   surya.findElement(By.id("female")).click();
	   Thread.sleep(3000);
	   surya.findElement(By.className("Permance")).click();
	   Thread.sleep(3000);
	   a.clear();
	   a.sendKeys("Thivakar");
	   Thread.sleep(3000);
	   surya.findElement(By.id("idOfButton")).click();
	   Thread.sleep(3000);
	   surya.findElement(By.id("male")).click();
	   Thread.sleep(3000);
	   surya.findElement(By.className("Automation")).click();
	   Thread.sleep(3000);
	  a.clear();
	   Thread.sleep(3000);
	   a.sendKeys("Priyanga");
	   surya.close();
	   surya.findElement(By.xpath("//tagname=[@attributeName='attributeValue']"));
	   System.out.println("Suryachanges");
	}

}
