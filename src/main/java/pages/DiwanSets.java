package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiwanSets {

WebDriver driver;
	
	public DiwanSets(WebDriver driver) {
		
		this.driver =driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="cate_head") WebElement category;
	
	@FindBy(xpath="(//*[@class='catIconMenu homeDecor'])[1]") WebElement Home_Furniture;
	
	@FindBy(linkText="Diwan Sets") WebElement DiwanSets;
	
	public void DiwanSetClick() {
		
		Actions a = new Actions(driver);
		
		a.moveToElement(category).moveToElement(Home_Furniture).build().perform();
		
		DiwanSets.click();
	}
	

	
}
