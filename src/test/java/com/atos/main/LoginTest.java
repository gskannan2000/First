package com.atos.main;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class LoginTest {

	private WebDriver driver = null;
	private String url = "http://localhost:1111/login.html";

	@Test
	void testFirstName() throws InterruptedException {
		System.setProperty("webdriver.geckodriver.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.id("user_name")).click();
		driver.findElement(By.id("user_name")).sendKeys("Kannan");

		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("Kannan");

		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
//		String text = driver.switchTo().alert().getText();
//		
//		assertSame(text, "You Login");
		driver.switchTo().alert().accept();
		driver.close();
		driver.quit();
	}

}
