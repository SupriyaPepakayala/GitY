package shoppingwebsite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingwebsite.AbstractComponent.AbstractComponent;

public class ProductCatalogPage {
	
	WebDriver driver;
	
	public ProductCatalogPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(id="nav-search-submit-button")
	WebElement serIcon;

	
	
	public SearchProduct searchForProducts(String ProductN) {
		Actions a=new Actions(driver);
		a.moveToElement(search).sendKeys(Keys.ENTER).build().perform();
		search.sendKeys(ProductN);
		//search.submit();
		serIcon.submit();
		SearchProduct iphonePro=new SearchProduct(driver);
		return iphonePro;
	}
	
	
	
	
}
