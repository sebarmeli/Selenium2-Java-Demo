package com.selenium2.examples;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleMobileTest {

	WebDriver webDriver;

	@BeforeClass
	public void testInit() {

		try {
			webDriver = new IPhoneDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		webDriver.get("http://osdc.com.au");
	}

	@Test
	public void testBackgorundImg() throws InterruptedException {
		WebElement element = webDriver.findElement(By.tagName("header"));

		Assert.assertEquals("url(http://osdc.com.au/index2_files/logo.png)",
				element.getCssValue("background-image"));
	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
