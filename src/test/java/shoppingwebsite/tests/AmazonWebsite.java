package shoppingwebsite.tests;

import org.testng.annotations.Test;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;



import shoppingwebsite.TestComponents.BaseTest;
import shoppingwebsite.TestComponents.Retry;
import shoppingwebsite.pageobjects.CartPage;
import shoppingwebsite.pageobjects.CheckOut;
import shoppingwebsite.pageobjects.ProductCatalogPage;
import shoppingwebsite.pageobjects.SignUpPage;
import shoppingwebsite.pageobjects.SearchProduct;

public class AmazonWebsite extends BaseTest{
	WebDriver driver;
	
	ProductCatalogPage prdCatlog;
	SearchProduct iphonePro;
	CartPage ctPage;
	CheckOut ckIn;
	
	String emails="prajeevknd@gmail.com" ;
	String psswd= "Ganga@3535";
	
	
	
	 @Test(dataProvider="getData", groups="Regression")
	 public void amazonTest(HashMap<String,String> input) throws InterruptedException  {
		 ProductCatalogPage prdCatlog=signIn.SignUp(input.get("Email"), input.get("Pwd"));
		 SearchProduct iphonePro=prdCatlog.searchForProducts(input.get("Product"));
		 iphonePro.ProductRes(input.get("ProductName"));
		 CartPage ctPage= iphonePro.addToCartItem();
		 CheckOut ckIn=ctPage.cartItems();
		 ckIn.checkin();
		 driver.getCurrentUrl();		 
	 }
	 
	 @Test(groups= {"Purchase"}, retryAnalyzer=Retry.class)
	 public void errorValidation(String emails, String psswd) throws InterruptedException{
		 ProductCatalogPage prdCatlog=signIn.SignUp(emails, psswd); 
		 
	 }
	 
	 
	 @DataProvider
		public Object[][] getData() throws IOException {
			
			List<HashMap<String, String>> datareader=jsonData(System.getProperty("user.dir")+"\\src\\test\\java\\shoppingwebsite\\testdata\\ProductResource.json");
			return new Object[][] {{datareader.get(0)},{datareader.get(1)}};
				
		}
	 
	 

}
