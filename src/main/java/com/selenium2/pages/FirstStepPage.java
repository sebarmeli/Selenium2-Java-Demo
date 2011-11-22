package com.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FirstStepPage {

	private final String NEXTPAGE_ID = "nextPageButton";
	private final String FIRST_DROPDOWN_ID = "Field5";
	private WebDriver webDriver;
	
	@FindBy(how = How.ID, using = NEXTPAGE_ID)
	@CacheLookup
	private WebElement nextPageLink;
	
	@FindBy(how = How.ID, using = FIRST_DROPDOWN_ID)
	@CacheLookup
	private WebElement firstDropDownElement;
	
	public FirstStepPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public SecondStepPage ToNext() {
		nextPageLink.click();
		return PageFactory.initElements(webDriver, SecondStepPage.class);
	}
	
	public void selectFirstStudentTicket() {
		Select firstSelect = new Select(firstDropDownElement);
		firstSelect.selectByIndex(1);
	}
	
	public static FirstStepPage goToFirstPage(String url, WebDriver webDriver){
		webDriver.get(url);
		return PageFactory.initElements(webDriver, FirstStepPage.class);
		
	}
}
