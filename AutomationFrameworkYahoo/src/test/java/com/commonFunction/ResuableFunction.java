package com.commonFunction;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.objectRepositery.ObjectRepository_xpath;
import com.utilities.PageActions;

public class ResuableFunction extends PageActions {
	ExtentReports extent;
	ExtentTest test;

	public static void enterUserID() {
		String userName = getData.getCellData(sheetName, startIter, "UserId");

		getElement("Yahoo login page", "User Id Textbox Found", (By.xpath(ObjectRepository_xpath.yahooUserName)),
				defaultElementLoadTime, "sendKeys", userName);
	}

	public static void clickUserIdSignIn() {

		getElement("Yahoo login page", "User Id sign in button Found",
				(By.xpath(ObjectRepository_xpath.yahooUserSignIn)), defaultElementLoadTime, "click", "");
	}

	public static void enterUserPassword() {
		String password = getData.getCellData(sheetName, startIter, "Password");

		getElement("Yahoo login page", "Password Textbox Found", (By.xpath(ObjectRepository_xpath.yahooPassWord)),
				defaultElementLoadTime, "sendKeys", password);
	}

	public static void clickPasswordSignIn() {

		getElement("Yahoo login page", "User password signin button Found",
				(By.xpath(ObjectRepository_xpath.yahooPassSignIn)), defaultElementLoadTime, "click", "");
	}
	
	public static void clickComposeButton() {

		getElement("Yahoo login page", "User compose signin button Found",
				(By.xpath(ObjectRepository_xpath.yahooMessageCompose)), defaultElementLoadTime, "click", "");
	}
	
	public static void enterMessageTo() {
		String userMessageTo = getData.getCellData(sheetName, startIter, "To");

		getElement("Yahoo login page", "User Message TO Textbox Found", (By.xpath(ObjectRepository_xpath.yahooMessageTo)),
				defaultElementLoadTime, "sendKeys", userMessageTo);
	}
	
	public static void enterMessageSubject() {
		String userMessageSubject= getData.getCellData(sheetName, startIter, "Subject");

		getElement("Yahoo login page", "User message subject Textbox Found", (By.xpath(ObjectRepository_xpath.yahooMessageSubject)),
				defaultElementLoadTime, "sendKeys", userMessageSubject);
	}
	
	public static void enterMessageBody() {
		String userMessageBody= getData.getCellData(sheetName, startIter, "Body");

		getElement("Yahoo login page", "User message subject Textbox Found", (By.xpath(ObjectRepository_xpath.yahooMessageBody)),
				defaultElementLoadTime, "sendKeys", userMessageBody);
	}
	
	public static void clickSendButton() {

		getElement("Yahoo login page", "User send message button Found",
				(By.xpath(ObjectRepository_xpath.yahooMessageSend)), defaultElementLoadTime, "click", "");
	}
	

}
