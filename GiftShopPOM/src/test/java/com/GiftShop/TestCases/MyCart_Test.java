package com.GiftShop.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GiftShopPOM.PageBase.PageBase;
import com.GiftShopPOM.Pages.MyCart;

public class MyCart_Test extends PageBase{

		MyCart mycart;
		
		@BeforeMethod
		public void setup()
		{
			environmentSetup();
			mycart= new MyCart();
			mycart.visitMyCart();
			driver.findElement(By.name("uname")).sendKeys(prp.getProperty("uname"));
			driver.findElement(By.name("pwd")).sendKeys(prp.getProperty("pword"));
			driver.findElement(By.name("submit")).click();
			
		}
		
		@Test
		public void checkIfMyCartIsAvailableTest()
		{
			String url= driver.getCurrentUrl();
			Assert.assertEquals(url, prp.getProperty("urlcart"));
		}
		
		@Test
		public void checkProductAttributeLabelsTest()
		{
			mycart.checkVariouProductAttributeLabels();
		}
		
		@Test
		public void checkIfProductAttributesAvailableTest()
		{
			mycart.checkVariousProductAttributesAreDisplayed();
		}
		
		@Test
		public void buttonsAreDisplayedTest()
		{
			mycart.checkVariousCartButtonsAreDisplayed();
		}
		
		@Test
		public void continueShoppingButtonTest()
		{
			mycart.checkContinueShoppingButton();
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url, prp.getProperty("urlhome"));
		}
		
		@Test
		public void deleteItemButtonTest()
		{
			mycart.checkDeleteItemButton();
		}
		
		@Test
		public void codCheckboxTest()
		{
			mycart.checkCashOnDeliveryCheckbox();
			String url= driver.getCurrentUrl();
			Assert.assertEquals(url, prp.getProperty("urlcodbillpage"));
		}
		
		@Test
		public void paypalCheckboxTest()
		{
			mycart.checkPaypalCheckbox();
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url, prp.getProperty("urlpaypalbillpage"));
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}
