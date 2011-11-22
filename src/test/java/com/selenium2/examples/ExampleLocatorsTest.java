package com.selenium2.examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleLocatorsTest {

	WebDriver webDriver;

	@BeforeClass
	public void testInit() {

		String chromeBinary = "src/main/resources/drivers/chrome/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromeBinary);

		webDriver = new ChromeDriver();
		webDriver.get("http://osdc.com.au");
	}

	@Test
	public void testLogoText() {
		WebElement element = webDriver.findElement(By.id("logo"));

		Assert.assertEquals("OSDC 11", element.getText());
	}

	@Test
	public void testSponsorLogos() {
		List<WebElement> elements = webDriver.findElements(By
				.className("sponsor_logos"));

		Assert.assertEquals(4, elements.size());
	}

	@Test
	public void testParagraphSponsor() {
		WebElement element = webDriver.findElement(By
				.cssSelector("section#sponsor>p"));

		Assert.assertTrue(element.getText().contains("We're seeking sponsors"));
	}

	@Test
	public void testSecondLink() {
		WebElement element = webDriver.findElement(By
				.xpath("//section[@id='miniconfs']/a[2]"));

		Assert.assertEquals("http://osdc.com.au/schedule/#osiaminiconf",
				element.getAttribute("href"));
 
	}

	@Test
	public void testAboutLink() {
		WebElement element = webDriver.findElement(By.linkText("About"));

		Assert.assertEquals("http://osdc.com.au/#about",
				element.getAttribute("href"));
	}

	@Test
	public void testPartialLink() {
		List<WebElement> elements = webDriver.findElements(By
				.partialLinkText("visitcanberra"));

		Assert.assertEquals(1, elements.size());
	}

	@AfterClass
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
