package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IssueWithoutAssertion {

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

	//@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		if (welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in. Test pass");

		} else {
			System.out.println("Admin is not logged in. Test fail");
		}

	}
	
	@Test
	public void titleValidation() {
		String expextedTitle = "Human Management Systems";
		String actualTitle = driver.getTitle();//"Human Management System"
		if (actualTitle.equals(expextedTitle)) {
			System.out.println("Titles matched. Test Pass");
		} else {
			System.out.println("Titles do not match.Test fail");
		}

	}

}
