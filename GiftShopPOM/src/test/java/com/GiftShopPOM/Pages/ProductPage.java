package com.GiftShopPOM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GiftShopPOM.PageBase.PageBase;

public class ProductPage extends PageBase{
	
	@FindBy(css="tr>td>img[width='400']")
	private WebElement ProductImage;
	
	@FindBy(css="img[onclick='addtocart( 3)']")
	private WebElement addToCartButton;
	
	@FindBy(id="rating_3")
	private WebElement productStarRating;
	
	@FindBy(css="div.star_1.ratings_stars.ratings_blank")
	private WebElement oneStarRating;
	
	@FindBy(css="div.star_2.ratings_stars.ratings_blank")
	private WebElement twoStarRating;
	
	@FindBy(css="div.star_3.ratings_stars.ratings_blank")
	private WebElement threeStarRating;
	
	@FindBy(css="div.star_4.ratings_stars.ratings_blank")
	private WebElement fourStarRating;
	
	@FindBy(css="div.star_5.ratings_stars.ratings_blank")
	private WebElement fiveStarRating;
	
	@FindBy(css="div[class='more-products']")
	private WebElement moreProductsSlider;
	
	@FindBy(linkText="About Us")
	private WebElement AboutUsLink;
	
	@FindBy(linkText="Contact Us")
	private WebElement ContactUsLink;
	
	@FindBy(linkText="FAQ's")
	private WebElement FAQsLink;
	
	@FindBy(linkText="Cancellations and returns")
	private WebElement CancellationsAndReturnsLink;
	
	@FindBy(linkText="Shipping")
	private WebElement ShippingLink;
	
	@FindBy(linkText="Payments")
	private WebElement PaymentsLink;
	
	@FindBy(linkText="Terms And Conditions")
	private WebElement TermsAndConditionsLink;
	
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateProductImage()
	{
		return ProductImage.isDisplayed();
	}
	
	public String validatePageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean addToCartButtonIsDisplayed()
	{
		return addToCartButton.isDisplayed();
	}
	
	public boolean productStarRatingIsDisplayed()
	{
		return productStarRating.isDisplayed();
	}
	
	public void productStarRatingIsClickable()
	{
		oneStarRating.click();
		twoStarRating.click();
		threeStarRating.click();
		fourStarRating.click();
		fiveStarRating.click();
	}
	
	public void addToCartButtonIsClickable()
	{
		addToCartButton.click();
	}
	
	public boolean moreProductsSliderIsDisplayed()
	{
		return moreProductsSlider.isDisplayed();
	}
	
	public void footerLinksAreDisplayed()
	{
		AboutUsLink.isDisplayed();
		ContactUsLink.isDisplayed();
		FAQsLink.isDisplayed();
		CancellationsAndReturnsLink.isDisplayed();
		ShippingLink.isDisplayed();
		PaymentsLink.isDisplayed();
		TermsAndConditionsLink.isDisplayed();
	}
	

}
