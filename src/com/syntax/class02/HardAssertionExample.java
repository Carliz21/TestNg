package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertionExample {
	
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();

	}
	
	@AfterMethod 
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@Test
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test 
	public void logoValidation() {
	WebElement element=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
	Assert.assertTrue(element.isDisplayed());		
		
	}
	
	@Test 
	public void loginFormText () {
		String expectedText = "LOGIN Panel";
		WebElement loginForm= driver.findElement(By.id("logInPanelHeading"));
		Assert.assertEquals(loginForm.getText(), expectedText, "Text on the Login Panel does not match");
		
		
	}
}
