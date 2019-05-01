package automation.testcasses;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProvider="getData")
	public void AddCustomer(String Firstname, String Lastname, String Postcode)
	{
		driver.findElement(By.cssSelector(obj.getProperty("Firstname"))).sendKeys(Firstname);
		driver.findElement(By.cssSelector(obj.getProperty("Lastname"))).sendKeys(Lastname);
		driver.findElement(By.cssSelector(obj.getProperty("Postcode"))).sendKeys(Postcode);
		driver.findElement(By.cssSelector(obj.getProperty("Addcbtn"))).click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		String Sheetname="AddCustomerTest";
		int rows = reader.getRowCount(Sheetname);
		int cols = reader.getColumnCount(Sheetname);
		
		System.out.println(reader.getRowCount(Sheetname));
		System.out.println(reader.getColumnCount(Sheetname));
		
		Object[][] obj = new Object[rows-1][cols];
		
		for(int rowNum=2;rowNum<=rows;rowNum++)
		{
			for(int colNum=0;colNum<cols;colNum++)
			{
				obj[rowNum-2][colNum]= reader.getCellData("DataP", colNum, rowNum);
			}
		}
		
		
		return obj;
	}
}
