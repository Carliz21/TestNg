package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HrmsTestCase {

	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();

	}

	@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		;
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		;
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
		String expextedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expextedTitle)) {
			System.out.println("Titles matched. Test Pass");
		} else {
			System.out.println("Titles do not match.Test fail");
		}

	}

	@Test
	public void invalidLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement message = driver.findElement(By.id("spanMessage"));
		String expectedMsg = "Password cannot be empty";
		String actualMsg = message.getText();
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
