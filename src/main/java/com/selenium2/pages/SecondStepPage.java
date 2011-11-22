package com.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SecondStepPage{

	private final String PREVIOUSPAGE_CSS = "button#previousPageButton";
	private final String PRICE_CSS = "table#run tbody span";
	private WebDriver webDriver;

	@FindBy(how = How.CSS, using = PREVIOUSPAGE_CSS)
	@CacheLookup
	private WebElement prevPageLink;
	
	@FindBy(how = How.CSS, using = PRICE_CSS)
	@CacheLookup
	private WebElement priceElement;

	public SecondStepPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public FirstStepPage toPrev() {
		prevPageLink.click();
		return PageFactory.initElements(webDriver, FirstStepPage.class);
	}
	
	public String priceTotal() {
		return priceElement.getText();
	}
}
