package shoppingwebsite.stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shoppingwebsite.TestComponents.BaseTest;
import shoppingwebsite.pageobjects.CartPage;
import shoppingwebsite.pageobjects.CheckOut;
import shoppingwebsite.pageobjects.ProductCatalogPage;
import shoppingwebsite.pageobjects.SearchProduct;
import shoppingwebsite.pageobjects.SignUpPage;

public class StepDefinationImp extends BaseTest{

	public SignUpPage signIn;
	public ProductCatalogPage prdCatlog;
	public SearchProduct iphonePro;
	public CartPage ctPage;
	public CheckOut ckIn;
	
	@Given("I landed on Amazon website")
	
	public void i_landed_on_amazon_website() throws IOException {
		signIn=launchingApplication();
	    //code
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	
	public void logged_in_with_username_and_password(String username, String password) throws InterruptedException {
		
		 prdCatlog=signIn.SignUp(username,password);	
	}
	
	 @When("^Search for product (.+) and select the product (.+) from screen$")
	
	 public void search_for_product_and_select_the_product_from_screen(String product,String productName) {
		 iphonePro=prdCatlog.searchForProducts(product);
		 iphonePro.ProductRes(productName);	 
	 }
	 
	 @When("Add the product to cart and proceed to Buy")
	 
	 public void add_the_product_to_cart_and_proceed_to_buy() {
		  ctPage= iphonePro.addToCartItem();
		  ckIn=ctPage.cartItems();
		  
	 }
	 
	 @Then("Select the address and use this address")
	 public void select_the_address_abd_use_this_address() {
		 
		 ckIn.checkin();
		 driver.close();
	 }
	 
	
	}
