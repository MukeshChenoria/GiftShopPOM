package com.GiftShop.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.GiftShopPOM.PageBase.PageBase;
import com.GiftShopPOM.Pages.ProductPage;

public class ProductPage_Test extends PageBase{
	
	ProductPage productpage;
	
	@BeforeMethod
	public void setup()
	{
		environmentSetup();
		productpage= new ProductPage();
	}
	
	@Test
	public void productPageUrlTest()
	{
		String url=productpage.validatePageUrl();
		Assert.assertEquals(url, "http://182.76.176.205/giftshop/describe.php?id=3");
	}
	
	@Test
	public void productImageTest()
	{
		boolean validate = productpage.validateProductImage();
		Assert.assertTrue(validate);
	}
	
	@Test
	public void addToCartButtonDisplayedTest()
	{
		boolean validate= productpage.addToCartButtonIsDisplayed();
		Assert.assertTrue(validate);
	}
	
	@Test
	public void productStarRatingIsDisplayedTest()
	{
		boolean validate= productpage.productStarRatingIsDisplayed();
		Assert.assertTrue(validate);
	}
	
	@Test
	public void productStarRatingisClickableTest()
	{
		productpage.productStarRatingIsClickable();
	}
	
	@Test
	public void addToCartButtonClickableTest()
	{
		productpage.addToCartButtonIsClickable();
		driver.findElement(By.name("uname")).sendKeys(prp.getProperty("uname"));
		driver.findElement(By.name("pwd")).sendKeys(prp.getProperty("pword"));
		driver.findElement(By.name("submit")).click();
		String url= driver.getCurrentUrl();
		Assert.assertEquals(url, prp.getProperty("urlcart"));
	}
	
	@Test
	public void moreProductsSliderIsDisplayedTest()
	{
		boolean validate = productpage.moreProductsSliderIsDisplayed();
		Assert.assertTrue(validate);
	}
	
	@Test
	public void footerLinksAvailabilityTest()
	{
		productpage.footerLinksAreDisplayed();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
