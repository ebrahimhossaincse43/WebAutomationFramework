package com.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shawpno {

	public static WebDriver driver;
	public static String baseURL = "http://www.shwapno.com";
	public static String city = "Dhaka";
	public static String area = "Mirpur 12";
	public static WebElement element;

	@BeforeSuite
	public static void setLocation() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		
		//Select Location
		
		Select drpCity = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		drpCity.selectByVisibleText(city);
		Thread.sleep(1000);
		
		Select drpArea = new Select(driver.findElement(By.xpath("//select[@id='city']")));
		drpArea.selectByVisibleText(area);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='btnFindStore']")).click();
		Thread.sleep(1000);	
		
	}
	
	@BeforeClass
	public static void loginModule() throws InterruptedException{
		driver.findElement(By.xpath("//a[@class='loginlnk  header-login-link LoginPopUpLink']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_UserName']")).sendKeys("ebrahimhossaincse43@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_Password']")).sendKeys("ebrahim881");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_LoginImageButton']")).click();
		Thread.sleep(1000);
	}
	
	@BeforeTest
	public static void findProduct() throws InterruptedException{
		driver.findElement(By.xpath("//span[normalize-space()='Half Price Offers']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//img[@src='//storage.sg.content-cdn.io/cdn-cgi/image/width=400,height=400,quality=75,format=auto,fit=cover,g=top/in-resources/8845e144-8902-4204-b80f-9dc7dc2f4bcb/Images/ProductImages/Source/3015937.jpg']")).click();
		Thread.sleep(1000);
	}
	
	@Test
	public static void addProduct() throws InterruptedException{
		driver.findElement(By.xpath("//input[@class='snackbar-msg mj_btnbg BuyNow']")).click();
		Thread.sleep(1000);
	}
	
	@AfterSuite
	public static void viewCart() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(normalize-space(),'View Cart')]")).click();
		Thread.sleep(1000);
	}
	

}
