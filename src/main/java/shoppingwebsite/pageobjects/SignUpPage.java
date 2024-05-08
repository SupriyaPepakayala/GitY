package shoppingwebsite.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	WebDriver driver;
	
	
	public SignUpPage(WebDriver driver) {
		
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[id='nav-link-accountList']")
	WebElement LogIn;
	
	@FindBy(xpath="//a[@data-nav-ref='nav_signin']")
	WebElement SignIn;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement Cont;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	
	
	public ProductCatalogPage SignUp(String Email, String Pwd) throws InterruptedException {
		Actions a=new Actions(driver);
		a.moveToElement(LogIn).build().perform();
				
		SignIn.click();
		Thread.sleep(5000);
		email.sendKeys(Email);
		Cont.click();
		password.sendKeys(Pwd);
		submit.click();
		ProductCatalogPage prdCatlog=new ProductCatalogPage(driver);
		return prdCatlog;
		
	}
	
	public void goTo()
	 {
		 driver.get("https://www.amazon.in/");	
		 }
	
	
	
	
}
