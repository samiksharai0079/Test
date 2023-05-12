package com.lenskart.driver;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.lenskart.constant.AppConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;


// main file to setup config and driver
public class Driver {
	
	static File file;
	static Properties prop;
	static FileInputStream fis;
	public static WebDriver driver;
	public static void initializeProp(String filepath) {
		file = new File(filepath);
		try {
			// loading property 
			fis = new FileInputStream(file);
			prop = new Properties();
				prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException found in intialize properties");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException found in intialize properties");
		}
	}
	
	public static String readProperty(String property) {
		return prop.getProperty(property);
	}
	
	//setting driver as chrome and launching the base application URL
	//could have parameterized it to launch other browser as well.
	
	@SuppressWarnings("deprecation")
	public static void launchBroswer() {
		System.setProperty("webdriver.chrome.driver", AppConstant.CHROME_DRIVER);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(readProperty(AppConstant.APPLICATION_URL));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	// closing the browser
	public static void closeBrowser() {
		driver.close();
	}
}
