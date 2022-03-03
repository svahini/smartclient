package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownTable {
	WebDriver driver;
	
	public DropDownTable( WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class, 'selectItemLiteText') and contains(@role, 'presentation')]/ancestor::tr[1]/td[2]")
	private WebElement drpItems;
	
	@FindBy(xpath = "//tr/td/div[contains(text(), 'Exercise')]//ancestor::tr/td[2]/div[contains(text(), 'Ea')]//ancestor::tr/td[3][number(.) > 1.1]//ancestor::tr")
	private List<WebElement> drpListExerciseItems;
	
	@FindBy(xpath = "(//table[@class='listTable'])[2]/tbody/tr")
	private List<WebElement> drpListItems;
	
	@FindBy(xpath = "(//div[@class = 'vScrollThumb'])[2]")
	private WebElement scrList;
	
	public void clickItems() {
		drpItems.click();
	}
	
	
	public void verifyDropDownListItems() {
		if(drpListExerciseItems.size() > 0) {
			System.out.println("Dropdown table has " + drpListExerciseItems.size() + " matching data");
			System.out.println("===============================");
			for(int i = 0; i < drpListExerciseItems.size(); i++) {	
					System.out.println(drpListExerciseItems.get(i).getText());		
			}
			System.out.println("===============================");
		}
	}
	
	
	public void scrollList(){
		Actions move = new Actions(driver);
	    move.dragAndDropBy(scrList, 0,25).perform();
	}


}
