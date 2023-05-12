package com.lenskart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.*;
import com.lenskart.driver.Driver;
public class SearchPage extends Driver{
	// API URI to be called for the search
	public String QUERY_URI= "api/users?page=2";
	
	// XPATH for the elements 
	private By cookieCloseBtn = By.xpath("//button[@class='cookie-bar__close cookie-bar__main-close']");
	private By searchBtn= By.xpath("//button[@class='nv00-gnb__utility-btn gnb__search-btn-js']");
	private By searchText= By.xpath("//input[@id='gnb-search-keyword']");
	private By searchResults = By.xpath("//ul[@class='result-list__wrap']/li[@class='result-list__item']/div[@class='result-item result-item--product']");
	
	// to naviagte to the concerned page and 
	// get list of search results
	public List<String> getSearchResults(String searchQuery) {
		List<String> searchResult = new ArrayList<String>();
		driver.findElement(cookieCloseBtn).click();
		driver.findElement(searchBtn).click();
		driver.findElement(searchText).sendKeys(searchQuery);
		driver.findElement(searchText).sendKeys(Keys.RETURN);
		int size = driver.findElements(searchResults).size();
		
		for(int i=1;i<=size;i++) {
			String searchOutputText = "//ul[@class='result-list__wrap']/li[@class='result-list__item']/div[@class='result-item result-item--product']/div[@class='result-item__content']/h3[@class='result-title line-clamp-mobile-3']/a[@an-la='product:product:product click:page1:result"+i+"']";
			searchResult.add(driver.findElement(By.xpath(searchOutputText)).getText());
		}
		return searchResult;
	}
	
}
