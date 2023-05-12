package com.lenskart.constant;

public class AppConstant {
	
	//path to chrome driver
	public final static String CHROME_DRIVER = System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe";
	
	// initial application url to be launched at start of test 
	public final static String APPLICATION_URL = "applicationURL";
	
	// path of the config file
	public final static String CONFIG_FILE = System.getProperty("user.dir") + "//src//test//resources//config.properties";
	
	// base URL for the api call
	public final static String REQRES_BASE_URI= "https://reqres.in/";
}
