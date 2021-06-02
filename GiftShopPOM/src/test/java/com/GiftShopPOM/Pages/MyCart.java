package com.GiftShopPOM.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GiftShopPOM.PageBase.PageBase;

public class MyCart extends PageBase{
	
	@FindBy(css="img[onclick='addtocart( 3)']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//td[text()=\"1\"]")
	private WebElement productID;
	
	@FindBy(xpath="//td[text()=\"Dimpy Stuff Teddy\"]")
	private WebElement productName;
	
	@FindBy(xpath="//td[text()=\"Rs 400\"]")
	private WebElement productPrice;
	
	@FindBy(name="product3")
	private WebElement quantity;
	
	@FindBy(xpath="//img[@height='30px']")
	private WebElement deleteItemButton;
	
	@FindBy(xpath="//td[@align='center']/b")
	private WebElement totalAmount;
	
	@FindBy(xpath="//td[@colspan='3' and @align='right']/img[1]")
	private WebElement placeMyOrderLabel;
	
	@FindBy(xpath="//td[@colspan='3' and @align='right']/img[2]")
	private WebElement cashOnDeliveryLabel;
	
	@FindBy(xpath="//td[@colspan='3' and @align='right']/img[3]")
	private WebElement payPalLabel;
	
	@FindBy(xpath="//img[@height='40' and @onclick]")
	private WebElement ContinueShoppingButton;
	
	@FindBy(xpath="//img[@height='30' and @onclick]")
	private WebElement emptyCart;
	
	@FindBy(xpath="//input[1][@name='chose']")
	private WebElement codCheckbox;
	
	@FindBy(xpath="//input[2][@name='chose']")
	private WebElement paypalCheckbox;
	
	public MyCart()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void visitMyCart()
	{
		addToCartButton.click();
	}
	
	public void checkVariouProductAttributeLabels()
	{
		ArrayList<String> labels= new ArrayList<String>();
		labels.add("Productid");
		labels.add("Name");
		labels.add("Price");
		labels.add("Qty");
		labels.add("Amount");
		labels.add("Options");
		
		driver.findElements(By.xpath("//tr[@bgcolor='#FFFFFF' and @style]")).contains(labels);
		
	}
	
	public void checkVariousProductAttributesAreDisplayed()
	{
		productID.isDisplayed();
		productName.isDisplayed();
		productPrice.isDisplayed();
		quantity.isDisplayed();
		deleteItemButton.isDisplayed();
		totalAmount.isDisplayed();
		placeMyOrderLabel.isDisplayed();
		cashOnDeliveryLabel.isDisplayed();
		payPalLabel.isDisplayed();
		
	}
	
	public void checkVariousCartButtonsAreDisplayed()
	{
		ContinueShoppingButton.isDisplayed();
		emptyCart.isDisplayed();
		codCheckbox.isDisplayed();
		paypalCheckbox.isDisplayed();
	}
	
	public void checkContinueShoppingButton()
	{
		ContinueShoppingButton.click();
	}
	
	public void checkDeleteItemButton()
	{
		deleteItemButton.click();
	}
	
	public void checkCashOnDeliveryCheckbox()
	{
		codCheckbox.click();
	}
	
	public void checkPaypalCheckbox()
	{
		paypalCheckbox.click();
	}
	
	

}