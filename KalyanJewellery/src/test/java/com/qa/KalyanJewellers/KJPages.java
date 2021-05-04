package com.qa.KalyanJewellers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KJPages {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBox;

	@FindAll(@FindBy(className = "tagalys-product-tile"))
	List <WebElement> searchResults;
	
	
	@FindBy(className = "no-products")
	WebElement noResult;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List <WebElement> getSearchResults() {
		return searchResults;
	}
	
	public WebElement getIsNoResult() {
		return noResult;
	}

	public KJPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}

