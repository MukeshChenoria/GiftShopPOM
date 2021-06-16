package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.en.*;

public class LoginStepDefinition {
	
	WebDriver driver;
	String path, url="http://182.76.176.205/giftshop/login.php";
	
	//1st Scenario
	 @Given("Environment Setup for checking the availability.")
	    public void environment_setup_for_checking_the_availability() {
		 	
		 	path=System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		 
	    }

	    @Given("User is on the login page already.")
	    public void user_is_on_the_login_page_already() {
	    	
	    	Assert.assertEquals(driver.getCurrentUrl(), url);
	    }

	    @Then("User checks the availability of Username and Password labels.")
	    public void user_checks_the_availability_of_username_and_password_labels(){
	    	
	    	driver.findElement(By.xpath("//b[contains(text(),'Username :')]")).isDisplayed();
	    	driver.findElement(By.xpath("//b[contains(text(),'Password:')]")).isDisplayed();
	    	
	    }

	    @Then("User checks the availability of Username and Password fields.")
	    public void user_checks_the_availability_of_username_and_password_fields(){
	    	
	    	driver.findElement(By.name("uname")).isDisplayed();
			driver.findElement(By.name("pwd")).isDisplayed();
	    	
	    }

	    @Then("user checks the availability of login button, Sign Up Now button, and Back button.")
	    public void user_checks_the_availability_of_login_button_sign_up_now_button_and_back_button() {
	    	
	    	driver.findElement(By.cssSelector("button[name='submit']>img")).isDisplayed();
	    	driver.findElement(By.cssSelector("td>a>img[height='40']")).isDisplayed();
	    	driver.findElement(By.cssSelector("td>a>img[height='60']")).isDisplayed();
	    	
	    }

	    @Then("User checks whether Sign Up Now button is clickable or not and is taking to the registration page or not.")
	    public void user_checks_whether_sign_up_now_button_is_clickable_or_not_and_is_taking_to_the_registration_page_or_not() {
	    	
	    	driver.findElement(By.cssSelector("td>a>img[height='40']")).click();
	    	Assert.assertEquals(driver.getCurrentUrl(), "http://182.76.176.205/giftshop/signup.php");
	    	
	    }

	    @Then("User checks whether Back button is clickable or not and is taking to the homepage or not.")
	    public void user_checks_whether_back_button_is_clickable_or_not_and_is_taking_to_the_homepage_or_not() {
	    	
	    	driver.get(url);
	    	driver.findElement(By.cssSelector("td>a>img[height='60']")).click();
	    	Assert.assertEquals(driver.getCurrentUrl(), "http://182.76.176.205/giftshop/index.php");
	    	driver.close();
	    	
	    }
	
	//2nd Scenario.
	@Given("Environment Setup.")
	public void environment_setup() {
		path=System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
		
	
	@Given("User is already on the login page.")
	public void user_is_already_on_the_login_page() {
		
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	
	@Then("User enters invalid {string} and invalid {string}.")
	public void user_enters_invalid_username_and_invalid_password(String uname, String pwd){
		
		driver.findElement(By.name("uname")).sendKeys(uname);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
	        
	}

	@Then("user clicks on login button.")
	public void user_clicks_on_login_button() {
		
		driver.findElement(By.cssSelector("button[name='submit']>img")).click();
	        
	}
	
	@And("user is still on the login page")
    public void user_is_still_on_the_login_page() {
		
		Assert.assertEquals(driver.getCurrentUrl(), url);
		driver.close();
    }
	
	//3rd Scenario
	@Given("Environment Setup2.")
	public void environment_setup2() {
		path=System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Given("user is on the login page.")
	public void user_is_on_the_login_page() {
		
		Assert.assertEquals(driver.getCurrentUrl(), url);
	        
	}

	@Then("User enters correct username and password.")
	public void user_enters_correct_username_and_password() {
	   
		driver.findElement(By.name("uname")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("admin");
	}

	@Then("User clicks on login button again.")
	public void user_clicks_on_login_button_again() {
		
	    driver.findElement(By.cssSelector("button[name='submit']>img")).click();
	    
	}

	@Then("User cart is available.")
	public void user_is_on_homepage() {
	   
		Assert.assertEquals(driver.getCurrentUrl(), "http://182.76.176.205/giftshop/shoppingcart.php");
		driver.close();
		
	}

}
