package automation.testcasses;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void loginTestManager() throws InterruptedException
	{
		driver.findElement(By.cssSelector(obj.getProperty("BMLbtn"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(ISElementPresent(By.cssSelector(obj.getProperty("cusbtn"))));
		
		log.debug("Login test run successfully!!");
	}

}
