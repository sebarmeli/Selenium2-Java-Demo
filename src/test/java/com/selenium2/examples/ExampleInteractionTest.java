package com.selenium2.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;

public class ExampleInteractionTest {

	WebDriver webDriver;

	@BeforeClass
	public void testInit() {

		webDriver = new OperaDriver();
		webDriver.get("http://google.com");
	}

	@Test
	public void testSelenium2() {

		WebElement element = webDriver.findElement(By.name("q"));
		element.sendKeys("selenium 2");

		element.sendKeys(Keys.RETURN);

		(new WebDriverWait(webDriver, 10))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return webDriver.findElement(By.id("ires")) != null;
					}
				});

		Assert.assertEquals(
				"Selenium 2.0 and WebDriver Ñ Selenium Documentation",
				webDriver.findElements(By.className("r")).get(0).getText());

		Assert.assertEquals("seleniumhq.org/docs/03_webdriver.html", webDriver
				.findElements(By.tagName("cite")).get(0).getText());

	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
