package shoppingwebsite.pageobjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingwebsite.AbstractComponent.AbstractComponent;

public class SearchProduct extends AbstractComponent{
	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-component-type='s-search-result']")
	List<WebElement> products;
	
	@FindBy(xpath="//span[contains(text(),'1-16 of 20 results for')]")
	WebElement resultText;
	
	@FindBy(xpath="//a[@title='See All Buying Options']")
	WebElement buyOptions;
	
	@FindBy(xpath="//input[@name='submit.addToCart']")
	WebElement addToCart;
	
	public void ProductRes(String ProductName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));
		//System.out.println(resultText.getText());
		
        products.stream().filter(f->f.getText().contains(ProductName))
				.findFirst().ifPresent(product -> product.findElement(By.tagName("a")).click());
        
	}
	
	public CartPage addToCartItem() {
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String ParentWindow=it.next();
		String ChildWindow=it.next();
		driver.switchTo().window(ChildWindow);
		buyOptions.click();
		addToCart.submit();
		CartPage ctPage=new CartPage(driver);
		return ctPage;	
	}
	
	
	
	
}

	

	
	
	
	

