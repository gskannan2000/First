package com.atos.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AmazonTest {
	private WebDriver driver = null;
	private String url = "https://www.amazon.in/";

	@Test
	void test() throws InterruptedException {
		System.setProperty("webdriver.geckodriver.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get(url);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));

		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Laptop");

		Thread.sleep(3000);

		driver.close();

	}

}
