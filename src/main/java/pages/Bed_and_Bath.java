package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bed_and_Bath {
	
	WebDriver driver;
	
	public Bed_and_Bath(WebDriver driver){
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="cate_head") WebElement category;
	
	@FindBy(xpath="(//*[@class='catIconMenu homeDecor'])[1]") WebElement Home_Furniture;
	
	@FindBy(linkText="Bed & Bath") WebElement BedBath; 
	
	public void BedBathClick() {
		
		Actions a = new Actions(driver);
		a.moveToElement(category).build().perform();
		
		a.moveToElement(Home_Furniture).build().perform();
		
		BedBath.click();
	}
	
	
	
	
}
