package com.selenium2.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleGrid2Test {

	WebDriver webDriver;

	@BeforeClass
	public void testInit() {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setVersion("15");
		capability.setPlatform(Platform.MAC);
		try {
			webDriver = new RemoteWebDriver(new URL(
					"http://localhost:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		webDriver.get("http://osdc.com.au");
	}

	@Test
	public void testRemotely() throws InterruptedException {
		List<WebElement> elements = webDriver.findElements(By
				.cssSelector("section#sponsors table"));
		
		Assert.assertEquals(4, elements.size());
	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
