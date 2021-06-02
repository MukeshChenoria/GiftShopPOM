package com.GiftShopPOM.PageBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.GiftShop.Utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {
	
	public static WebDriver driver;
	public static Properties prp;
	Utilities utils;
	
	public PageBase() {
		
		
		try {
			File f = new File("C:\\Users\\hp\\eclipse-workspace\\GiftShopPOM\\src\\test\\java\\com\\GiftShop\\configurations\\config.properties");
			FileInputStream input = new FileInputStream(f);
			prp= new Properties();
			prp.load(input);
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void environmentSetup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prp.getProperty("urlproductpage"));
		driver.manage().timeouts().implicitlyWait(utils.implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(utils.pageLoadTime, TimeUnit.SECONDS);
	}

}
