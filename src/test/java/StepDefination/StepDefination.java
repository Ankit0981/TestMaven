package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination extends TestBase {
	
	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver= new ChromeDriver();
	}

	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
	    driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("Click on Bank Manager Login")
	public void click_on_Bank_Manager_Login() {
	    driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
	}

	@Given("Navigate to Add Customer Test")
	public void navigate_to_Add_Customer_Test() {
	   driver.findElements(By.xpath("//button[contains(text(),'Add Customer')]")).get(0).click();
	}

	@When("Enter user {string} and {string} and {string}")
	public void enter_user_and_and(String string, String string2, String string3) {
	    driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys(string);
	    driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys(string2);
	    driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys(string3);
	}

	@When("Click on AddCustomer Button")
	public void click_on_AddCustomer_Button() {
		driver.findElements(By.xpath("//button[contains(text(),'Add Customer')]")).get(1).click();
	}

	@Then("Customer is entered sucessfully with Customer Id")
	public void customer_is_entered_sucessfully_with_Customer_Id() {
	    System.out.println(driver.switchTo().alert().getText());
	    
	}


}
