package stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void Initiaziation() {
		System.out.println("Executing TestNG's @Beforesuite...");
		
		prop=getProperty();
		startDriver(prop.getProperty("browsername"));
		report=new ExtentReports();
		
	}
	
	@AfterMethod
	public void tearDown() {
		 report.flush();
		System.out.println("@AfterTest TestNG Annotation is tearing down");
		driver.quit();
	}
	
 public WebDriver startDriver(String browsername) {
	 if(browsername.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver");
			driver = new ChromeDriver();
			
		}else if (browsername.equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "src/test/resources/lib/geckodriver");
			driver = new FirefoxDriver();
			
		}else if (browsername.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", "src/test/resources/lib/IEDriverServer");
			driver = new InternetExplorerDriver();
			
		}else if (browsername.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	 
	return driver;
	 
 }
 
 public Properties getProperty(){
		
		Properties prop = new Properties();
		System.out.println("Getting all the needed property files");
		try {
			prop.load(new FileInputStream("src/test/resources/environment.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
}
