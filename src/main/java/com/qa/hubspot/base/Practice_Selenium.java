package com.qa.hubspot.base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_Selenium {

	public static void main(String[] args)  {
		
        WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.navigate().to("http://app.hubspot.com/");
		By username=By.id("username");
		
//		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
//	            .withTimeout(Duration.ofSeconds(15))
//	            .pollingEvery(Duration.ofSeconds(3))
//	         .ignoring(NoSuchElementException.class);
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(username));
		element.sendKeys("rakesh.september.27@gmail.com");
		

		
		driver.findElement(By.id("password")).sendKeys("Sree@1991");
		
		driver.getWindowHandles();
		
  
		
        
}
}
