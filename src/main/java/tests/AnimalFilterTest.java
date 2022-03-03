package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AnimalFilter;

public class AnimalFilterTest {
	
	WebDriver driver;	
	AnimalFilter animal;
	
	@BeforeTest
	public void setup() throws Exception{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.smartclient.com/smartgwt/showcase/#featured_tile_filtering");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		animal = new AnimalFilter(driver);
		animal.scrollDownPage();
	}
	
	@Test(priority = 1)
	public void setAnimalFilter() throws Exception {
		animal.setAnimal("a");
	}
	
	@Test(priority = 2)
	public void clickSort() throws Exception{
		animal.clickSort();
	}
	
	@Test(priority = 3)
	public void selectSortValue() throws Exception{
		animal.selectSort();
	}
	
	@Test(priority = 4)
	public void selectAscending() throws Exception{
		animal.SelectAscending();
	}
	
	@Test(priority = 5)
	public void ChangeSliderValue() throws Exception{
		animal.slider();
	}
	
	@Test(priority = 6)
	public void VerifyAnimals() throws Exception{
		animal.verifyAnimals();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}


}
