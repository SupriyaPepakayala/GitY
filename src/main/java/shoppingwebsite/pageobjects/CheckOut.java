package shoppingwebsite.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@data-testid='Address_selectShipToThisAddress']")
	WebElement address;
	
	@FindBy(xpath="//div[@class='a-row address-row']")
	List<WebElement> radio;
	
	public void checkin() {
		
		for(int i=0; i<radio.size();i++)
		{
			String rdbutton=radio.get(i).getText();
			System.out.println(rdbutton);
			if(rdbutton.contains("Rajeev P Main Road, Kandregula, KARAPA, ANDHRA PRADESH, 533462, India Edit address | Add delivery instructions"))
			{
				radio.get(i).click();
				break;
			}
		
			
		}
		
		address.click(); 
		
	}

}
