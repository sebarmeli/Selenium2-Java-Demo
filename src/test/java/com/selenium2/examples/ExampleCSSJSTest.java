package com.selenium2.examples;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;

public class ExampleCSSJSTest {

	WebDriver webDriver;

	@BeforeClass
	public void testInit() {

		webDriver = new OperaDriver();
		webDriver.get("http://osdc.com.au");
	}

	@Test
	public void testScroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		Long x = (Long) js.executeScript("return window.scrollY");

		Assert.assertEquals(new Long(0), x);
	}

	@Test
	public void testCSSLogo() throws InterruptedException {

		WebElement element = webDriver.findElement(By.id("logo"));

		Assert.assertEquals("76px", element.getCssValue("height"));
		Assert.assertEquals("url(\"http://osdc.com.au/ribbon_bg.png\")",
				element.getCssValue("background-image"));
	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
