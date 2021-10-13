package com.atos.main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class LoginIDETest {

	private WebDriver driver;
	private Map<String, Object> vars;
	private JavascriptExecutor js;

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.geckodriver.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		String url = "http://localhost:1111/login.html";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).click();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("gskannan2000");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.id("pass_word")).sendKeys("kannan");

		driver.findElement(By.cssSelector("#submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		assertThat(driver.switchTo().alert().getText(), is("You Login"));
		driver.switchTo().alert().accept();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Forgot Password")).click();
		driver.close();
	}
}
