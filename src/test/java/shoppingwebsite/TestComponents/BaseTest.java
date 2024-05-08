package shoppingwebsite.TestComponents;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import shoppingwebsite.pageobjects.SignUpPage;


public class BaseTest {
	public WebDriver driver;
	public SignUpPage signIn;
	
	public WebDriver Intilization() throws IOException {
		Properties prop=new Properties();
		FileInputStream fls=new FileInputStream("C:\\Users\\Rajeev\\eclipse-workspace\\Flipkart\\src\\main\\java\\shoppingwebsite\\resources\\GlobalData.properties");
	    prop.load(fls);
	    String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
	    
	    //String browserName=prop.getProperty("browser");
	    
	    if(browserName.contains("chrome"))
	    {
	    	ChromeOptions options=new ChromeOptions();
	    	WebDriverManager.chromedriver().setup();
	    	if(browserName.contains("headless"))
	    	{
	    		options.addArguments("headless");
	    		
	    	}
	    	driver=new ChromeDriver(options);
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajeev\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	    	driver.manage().window().setSize(new Dimension(1440, 900));
	    
	    }
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();	
	    	System.setProperty("webdriver.firefox.driver", "C:\\Users\\Rajeev\\Geckodriver\\geckodriver.exe");
	    }
	    
	    else if(browserName.equalsIgnoreCase("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();	
	    }
		
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    return driver;
	}
	
	
	public List<HashMap<String, String>> jsonData(String Filepath) throws IOException {
		//read Json to string
		String JsonContent=FileUtils.readFileToString(new File(Filepath));
		//String to HashMap Jackson Databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> datareader=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		 return datareader;
			
		}
	
	
	@BeforeMethod(alwaysRun=true)
	public SignUpPage launchingApplication() throws IOException {
		driver=Intilization();
		signIn=new SignUpPage(driver);
		signIn.goTo();
		return signIn;
		   
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//" +testCaseName+ ".PNG");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//" +testCaseName+ ".PNG";
	}
	
	       
	 
	
	@AfterMethod
	 public void testApp() {
		 driver.close();
	 }
	
	
	

}
