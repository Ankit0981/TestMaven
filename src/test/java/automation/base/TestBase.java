package automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import automation.utilities.ExcelReader;

public class TestBase {
	
	/*
	 * WebDriver
	 * Properties
	 * Logs- log4j jars and log4j properties
	 * ExtendReports
	 * DB
	 * Excel
	 * Mail
	 * ReportNG
	 * Jenkins
	 */
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	public static Properties obj= new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader reader = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Book1.xlsx");
	
	
	@BeforeSuite
	public void setup() throws IOException
	{
		if(driver==null)
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");;
			config.load(fis);
			log.debug("config file loadded!!");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Object.properties");;
			obj.load(fis);
			log.debug("object file loadded!!");
			
			if(config.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver= new FirefoxDriver();
				log.debug("firefox driver open successfully!!");
			}
			else if(config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver= new ChromeDriver();
				log.debug("chrome driver open successfully!!");
			}
			
			log.debug("Navigate to:"+config.getProperty("testsiteurl"));
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}
	
	public static Boolean  ISElementPresent(By by)
	{
		try {
		driver.findElement(by);
		return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
		log.debug("test execution completed");
	}

}
