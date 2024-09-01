package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BedSheets {
	
	WebDriver driver;
	
	public BedSheets(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//*[@class='cate_head']") WebElement category;
	
	@FindBy(xpath="(//*[@class='catIconMenu homeDecor'])[1]") WebElement Home_Furniture;
	
	@FindBy(linkText="Bedsheets") WebElement Bedsheets;
	
	public void BedsheetsClick() {
		
		Actions a = new Actions(driver);
		
		a.moveToElement(category).build().perform();
		
		a.moveToElement(Home_Furniture).build().perform();
		
		Bedsheets.click();
	}
	
	
}
