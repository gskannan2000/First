package com.atos.main;
 

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 
class TestForm {
	private WebDriver driver = null;
	private String url = "http://localhost:1111/";

	@Test
	void testFirstName() throws InterruptedException {
		System.setProperty("webdriver.geckodriver.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).sendKeys("Kannan");
		
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).sendKeys("G S");
		
		driver.findElement(By.id("female")).click();
		
		try {
			driver.findElement(By.id("exp6")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (NoSuchElementException e) {
			driver.close();
		}
		
		
		driver.findElement(By.name("doj")).click();
		driver.findElement(By.name("doj")).sendKeys("08-09-2021");
		
		driver.findElement(By.id("at")).click();
		
		driver.findElement(By.id("web")).click();
		
		driver.findElement(By.id("cont")).click();
		driver.findElement(By.id("3")).click();
		
		driver.findElement(By.id("cmd")).click();
		driver.findElement(By.id("c1")).click();
		driver.findElement(By.id("c2")).click();
		driver.findElement(By.id("c5")).click();
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close(); // close the confirm dialog box
		driver.quit(); // close all windows
	}

}
