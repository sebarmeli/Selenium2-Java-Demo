package com.selenium2.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;

public class ExampleFirstTest {

	WebDriver webDriver;

	@BeforeClass
	public void testInit() {

		webDriver = new OperaDriver();
		webDriver.get("http://osdc.com.au");
	}

	@Test
	public void testBuyTicketLinkText() {

		WebElement element = webDriver.findElement(By.id("buyticketstop"));
		final String stringExpected = "Buy Tickets";

		Assert.assertEquals(element.getText(), stringExpected);
	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
