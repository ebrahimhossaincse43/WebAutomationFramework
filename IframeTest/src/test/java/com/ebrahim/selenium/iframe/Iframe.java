package com.ebrahim.selenium.iframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Iframe extends DriverSetup{

	public static String baseURL = "https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html";
	
	@Test
	public static void iframe() throws InterruptedException{
		
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		int number_of_iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of iframes on a page : "+number_of_iframes);
		
		driver.switchTo().frame("packageListFrame");
		
		driver.findElement(By.xpath("//a[contains(@href,'allclasses-frame.html')]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[contains(@href,'org/openqa/selenium/package-summary.html')]")).click();
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//a[@href='org/openqa/selenium/support/pagefactory/AbstractAnnotations.html']")).click();
		Thread.sleep(3000);
		
		
	}
	
}
