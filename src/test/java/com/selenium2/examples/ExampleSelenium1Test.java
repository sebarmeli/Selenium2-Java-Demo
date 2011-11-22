package com.selenium2.examples;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;
import com.thoughtworks.selenium.Selenium;

public class ExampleSelenium1Test {

	WebDriver webDriver;
	final String baseUrl = "http://osdc.com.au";

	@BeforeClass
	public void testInit() {

		webDriver = new OperaDriver();
		webDriver.get(baseUrl);
	}

	@Test
	public void testTwitterLink() {
		WebElement elementTwitter = webDriver.findElement(By.id("twitter_acc"));

		elementTwitter.click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Assert.assertEquals("OSDC - 2011 (osdc2011) on Twitter",
				webDriver.getTitle());

	}

	@Test
	public void testTwitterLinkSelenium1() {
		Selenium selenium = new WebDriverBackedSelenium(webDriver, baseUrl);

		selenium.open(baseUrl);
		selenium.click("id=twitter_acc");
		selenium.waitForPageToLoad("10000");
		Assert.assertEquals("OSDC - 2011 (osdc2011) on Twitter",
				selenium.getTitle());

	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
