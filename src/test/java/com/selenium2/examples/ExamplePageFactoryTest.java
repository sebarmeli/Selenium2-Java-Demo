package com.selenium2.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium2.pages.FirstStepPage;
import com.selenium2.pages.SecondStepPage;

public class ExamplePageFactoryTest {

	WebDriver webDriver;
	final String url = "https://osdc2011.wufoo.com/forms/buy-tickets/";

	@BeforeClass
	public void testInit() {
		String chromeBinary = "src/main/resources/drivers/chrome/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeBinary);

		webDriver = new ChromeDriver();
	}

	@Test
	public void testRightPriceOnSecondStep() throws InterruptedException {
		FirstStepPage firstStepPage = FirstStepPage.goToFirstPage(url,
				webDriver);
		SecondStepPage secondStep = firstStepPage.ToNext();
		Assert.assertEquals("$349.00", secondStep.priceTotal());
	}

	@Test
	public void testBackAndChangeToStudentTicket() throws InterruptedException {
		FirstStepPage firstStepPage = FirstStepPage.goToFirstPage(url,
				webDriver);
		SecondStepPage secondStep = firstStepPage.ToNext();
		firstStepPage = secondStep.toPrev();
		firstStepPage.selectFirstStudentTicket();
		secondStep = firstStepPage.ToNext();
		Assert.assertEquals("$275.00", secondStep.priceTotal());
	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
