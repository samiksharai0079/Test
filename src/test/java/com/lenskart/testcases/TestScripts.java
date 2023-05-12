package com.lenskart.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.lenskart.constant.AppConstant;
import com.lenskart.driver.Driver;
import com.lenskart.pages.SearchPage;
import com.lenskart.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
public class TestScripts {
	
	@BeforeSuite
	public void initalizeProperties() {
		Driver.initializeProp(AppConstant.CONFIG_FILE);
	}
	
	@AfterTest
	public void closeBrowser() {
		Driver.closeBrowser();
	}
	
	@BeforeTest
	public void launchBrowser() {
		Driver.launchBroswer();
	}
	
	
	@Test
	public void querySearchTest() {
		SearchPage searchPage = new SearchPage();
		RestAssured.baseURI = AppConstant.REQRES_BASE_URI;
		RestAssured.basePath = searchPage.QUERY_URI;
		
		// hard coding the searchQuery, could have got this from test data file
		String searchQuery = "Dishwasher";
		List<String> searchResult = searchPage.getSearchResults(searchQuery);
		Response response = RestAssured.given().get();
		JSONObject object = new JSONObject(response.getBody().asString());
		JSONArray apiResult = object.getJSONArray("data");
		//if the size of both the search and api query do not match 
		if(searchResult.size() != apiResult.length()) {
			Assert.assertTrue(false,"the size of both the list did not match");
		} else {
			// if the size matches, match the name from UI search result and api result
			Assert.assertTrue(Utils.mapResultsSearch(searchResult, apiResult));
		}
		
	}
	
	
}
