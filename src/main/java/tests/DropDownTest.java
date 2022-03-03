package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DropDownTable;

public class DropDownTest {

	WebDriver driver;
	DropDownTable drp;
	
	@BeforeTest
	public void setup() throws Exception{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.smartclient.com/smartgwt/showcase/#featured_dropdown_grid_category");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		drp = new DropDownTable(driver) ;
	}
	
	@Test(priority = 1)
	public void clickDropDown() throws Exception{
		drp.clickItems();
	}
	
	@Test(priority =  2)
	public void scrollDropdownList() throws Exception{
		drp.scrollList();
	}
	
	@Test(priority = 2)
	public void verifyDropdownList() throws Exception{
		drp.verifyDropDownListItems();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
