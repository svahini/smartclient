package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalFilter {
WebDriver driver;
	
	public AnimalFilter( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "isc_2P")
	private WebElement txtAnimal;
	
	@FindBy(id = "isc_3C")
	private WebElement drpSort;
	
	@FindBy(xpath = "//body[1]/div[7]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]")
	private WebElement sortValue;
	
	@FindBy(id = "isc_3K")
	private WebElement optSort;
	
	@FindBy(id = "isc_2B")
	private WebElement slider;
	
	@FindBy(xpath = "//img[@src='https://www.smartclient.com/smartgwt/showcase/imagesTahoe/animals/']")
	private WebElement images;
	
	@FindBy(xpath = "//div[not(contains(@style, 'left: 0px; top: 0px;')) and (contains(@class, 'simpleTile'))]")
	private List<WebElement> animals;	
	
	public void slider(){
		Actions move = new Actions(driver);
	    move.dragAndDropBy(slider, 81,0).perform();
	}
		
	public void setAnimal(String val) {
		txtAnimal.sendKeys(val);
	}
	
	public void clickSort() {
		drpSort.click();
	}
	
	public void selectSort() {
		sortValue.click();
	}
	
	public void scrollDownPage() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", drpSort);
	}
	
	public void SelectAscending() {
		optSort.click();
	}
	
	public void verifyAnimals() {
		if(animals.size() > 12) {
			System.out.println("Animals has more than 12");
		}
	}

}
