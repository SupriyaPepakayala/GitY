package shoppingwebsite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-csa-c-type='button']")
	WebElement GoToCart;
	
	//@FindBy(xpath="//span[@class='a-button-text a-declarative']")
	//List<WebElement> drpdwn;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement cart;
	
	public CheckOut cartItems() {
		GoToCart.click();
		cart.click();
	    CheckOut ckIn=new CheckOut(driver);
	    return ckIn;
		
	}

}
