package com.message;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YahooLogin extends DriverSetup {

	public static String baseURL = "https://www.yahoo.com";
	public static String actualText = "Hello";
	public static String expectedText;

	@BeforeTest
	public static void login() throws InterruptedException {

		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@class='_yb_12px8']")).click(); 
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("ebrahimhossaincse43@yahoo.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("@@##$$ebrahim881$$##@@");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@id='login-signin']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@id='ybarMailLink']")).click();
		Thread.sleep(1000);


	}

	@Test (priority = 1)
	public static void sendMessage() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@data-test-id='compose-button']"))
		.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='message-to-field']"))
		.sendKeys("ebrahim15-881@diu.edu.bd");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[contains(@data-test-id,'compose-subject')]"))
		.sendKeys("Hello");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@data-test-id='rte']"))
		.sendKeys("Hellow World");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']"))
		.click();
		Thread.sleep(1000);
		

	}

	@Test (priority = 2)
	public static void validateMessage() throws InterruptedException {

		driver.findElement(By.xpath("//a[@href='/d/folders/2']")).click();
		Thread.sleep(3000);

		expectedText = driver.findElement(By.xpath(
				"//div[@class='en_3ixhM o_h a_6D6F D_F ab_C']"))
				.getText();

		if (expectedText.equalsIgnoreCase(actualText)) {
			System.out.println("Successfully send message");
			Assert.assertTrue(true);
		} else {
			System.out.println("There will be problem.Try another way");
			Assert.assertTrue(false);
		}
	}
	
	@Test (priority = 3)
	public static void logOut() throws InterruptedException{
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(driver.findElement(By.xpath("//label[@id='ybarAccountMenuOpener']"))).build().perform();
		
		driver.findElement(By.xpath("//a[@class='_yb_tdi30 _yb_po6e2 _yb_m78yl _yb_16g61 _yb_1delc']")).click();
		Thread.sleep(3000);
	}

}
