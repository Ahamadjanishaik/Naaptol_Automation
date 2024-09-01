package tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generics.Base;
import pages.BedSheets;
import pages.Bed_and_Bath;
import pages.Decor;
import pages.DiwanSets;


public class Tests extends Base {
		
	
	
	public static void capture(WebDriver driver, int n) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
				
		// getScreenshotAs to take SS
		File image = ts.getScreenshotAs(OutputType.FILE);
		
		// We have to create a new file in our local machine using File class by creating objects
		
		
		File img = new File(System.getProperty("user.dir")+"\\Screenshots\\image"+n+".png");
		
		FileUtils.copyFile(image, img);
		
	}
	
	Decor Decorpage;            // Object Declaration of Decor WebPage
	Bed_and_Bath BedBathPage; 
	BedSheets BedSheetsPage;
	DiwanSets DiwansetPage;
	
	
	@Test(priority=1, enabled=true)
	public void Decor1() throws Exception  {                              // Visit Decor Page 
		
		Decorpage = new Decor(driver); // Object creation 		
		
		Decorpage.DecorClick();  // Visit Decor WebPage 
		
		String actual ="Decor Online Store in India - Buy Decor at Best Price on Naaptol Online Shopping";
		
		String expected = driver.getTitle();
		
		Assert.assertEquals(actual, expected);     // Assert Title of Decor Page
		
		capture(driver, 1);
		
	}
	@Test(priority=2, enabled=true)
	public void Decor2() throws Exception {                // Click on Checkbox
		
		Decorpage = new Decor(driver); // Object creation 
		
		Decorpage.DecorClick();  // Visit Decor WebPage 
		
		driver.findElement(By.name("iscod")).click();  // Click on Cash on Delivery Checkbox
		
		driver.findElement(By.xpath("(//*[@class='button_1'])[1]")).click();  // Click on Set Button 
		
		capture(driver, 2);
	}
	
	@Test(priority=3, enabled=true)				
	public void Decor3() throws Exception {                // Click on Branded Checkbox
		
		Decorpage = new Decor(driver); // Object creation 
		
		Decorpage.DecorClick();  // Visit Decor WebPage 
				
		
		driver.findElement(By.name("Branded")).click();
		
		capture(driver, 3);
	}
		
	@Test(priority=4,enabled=true)
	public void Decor4() throws Exception {
		
		Decorpage = new Decor(driver); // Object creation 
		
		Decorpage.DecorClick();     // Visit Decor WebPage 
						
		driver.findElement(By.xpath("(//*[@alt='Pack of 4 - 3D Wall Stickers (3DWS1)'])[1]")).click(); // Click on Buy Now Button
		
		String parent = driver.getWindowHandle();
		
		Set<String> allHandles = driver.getWindowHandles();
		
		ArrayList<String> handles = new ArrayList<>(allHandles);
		
		String newHandle = handles.get(1);
		
		driver.switchTo().window(newHandle);
		
		driver.findElement(By.linkText("Click here to Buy")).click(); // Click on Buy Now Button
		
		driver.findElement(By.linkText("Proceed to Checkout")).click();  // Click on Proceed to CheckOut
		
		capture(driver, 4);
		
		driver.switchTo().window(parent);
					
	}
	
	@Test(priority=5,enabled=true)
	public void Decor5() throws Exception {                // Click on Compare
		
		Decorpage = new Decor(driver); // Object creation 
		
		Decorpage.DecorClick();  // Visit Decor WebPage 
		
		driver.findElement(By.xpath("(//*[@catname='Decor'])[1]")).click();  // Click on Add to Compare
		
		driver.findElement(By.xpath("(//*[@catname='Decor'])[2]")).click();  // Click on Add to Compare
		
		driver.findElement(By.id("compareButton")).click();  // Click on Compare Button 
		
		capture(driver, 5);
	}
	
	@Test(priority=6,enabled=true)
	public void Decor6() throws Exception {                // Click on Branded Checkbox
		
		Decorpage = new Decor(driver); // Object creation 
		
		Decorpage.DecorClick();  // Visit Decor WebPage 
				
		
		driver.findElement(By.name("Luxury Queen")).click();
		
		capture(driver, 6);
	}
	
	
	@Test(priority=7,enabled=true)
	public void BedBath1() throws Exception {
		
		BedBathPage = new Bed_and_Bath(driver); // Object creation
		
		BedBathPage.BedBathClick(); // Visit Bed and Bath Page
		
		String actualTitle = "Bed Bath Online Store in India - Buy Latest Bed Bath Online at Best Price Deals - Naaptol.com";
		
		String expTitle =driver.getTitle(); // Expected Title
		
		Assert.assertEquals(actualTitle, expTitle); // Assert Title 
		
		capture(driver, 7);
	}
	
	@Test(priority=8,enabled=true)
	public void BedBath2() throws Exception {
		
		BedBathPage = new Bed_and_Bath(driver); // Object creation
		
		BedBathPage.BedBathClick(); // Visit Bed and Bath Page
		
		driver.findElement(By.xpath("(//img[@alt='Foldable Double Bed Mosquito Net Buy 1 Get 1 Free (DMN2)'])[3]")).click();
		
		String parent = driver.getWindowHandle(); // Parent Handle (Current Page)
		
		Set<String> allHandles = driver.getWindowHandles();
		
		ArrayList<String> handles = new ArrayList<>(allHandles);  // Storing all Window Handles
		
		String newHandle = handles.get(1);
		
		driver.switchTo().window(newHandle);
		
		driver.findElement(By.linkText("Click here to Buy")).click(); // Click on Buy Now Button
		
		driver.findElement(By.linkText("Proceed to Checkout")).click();  // Click on Proceed to CheckOut
		
		capture(driver, 8);
		
		driver.switchTo().window(parent); // Switch back to parent handle 
		
	}
	
	@Test(priority=9,enabled=true)
	public void BS1() throws Exception {
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		String actualTitle = "Buy Bedsheets, Bed Covers, Bedding Sets, Bed Linen at Best Price in India on Naaptol.com";

		String expTitle =driver.getTitle(); // Expected Title
		
		Assert.assertEquals(actualTitle, expTitle); // Assert Title 
		
		capture(driver, 9);
		
	}
	@Test(priority=10,enabled=true)
	public void BS2() throws Exception {                          // Click on Price CHeckboxes
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
				 		
		driver.findElement(By.name("201 - 400")).click();
		
		capture(driver, 10);
		
	}
	
	@Test(priority=11,enabled=true)
	public void BS3() throws Exception {                          // Add to wishlist
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
				 		
		driver.findElement(By.xpath("(//*[@class='wish2'])[1]")).click(); // Add to wishlist 
		
		String actual ="LOGIN / REGISTER";
		
		String expected = driver.findElement(By.xpath("//*[@class='heading']")).getText();
		
		Assert.assertEquals(expected, actual);  // Assert Text 
		
		capture(driver, 11);
	}
	
	@Test(priority=12,enabled=true)
	public void BS4() throws Exception {                          // Click on Sort By Dropdown
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		WebElement dropdown = driver.findElement(By.id("sortByFilter"));
		
		Select s = new Select(dropdown);
		
		s.selectByIndex(1); // Select Most Popular
		
		capture(driver, 12);
				 				 
	}
	
	@Test(priority=13,enabled=true)
	public void BS5() throws Exception {                          // Click on Sort By Dropdown
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		WebElement dropdown = driver.findElement(By.id("sortByFilter"));
		
		Select s = new Select(dropdown);
		
		s.selectByIndex(2); // Select New Arrivals
		
		capture(driver, 13);
				 				 
	}
	
	@Test(priority=14,enabled=true)
	public void BS6() throws Exception {                          // Click on Sort By Dropdown
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		WebElement dropdown = driver.findElement(By.id("sortByFilter"));
		
		Select s = new Select(dropdown);
		
		s.selectByIndex(3); // Select Highest Rated
		
		capture(driver, 14);
				 				 
	}
	
	@Test(priority=15,enabled=true)
	public void BS7() throws Exception {                          // Click on Sort By Dropdown
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		WebElement dropdown = driver.findElement(By.id("sortByFilter"));
		
		Select s = new Select(dropdown);
		
		s.selectByIndex(4); // Select Most Expensive
				 				 
		capture(driver, 15);
	}
	
	@Test(priority=16,enabled=true)
	public void BS8() throws Exception {                          // Click on Sort By Dropdown
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		WebElement dropdown = driver.findElement(By.id("sortByFilter"));
		
		Select s = new Select(dropdown);
		
		s.selectByIndex(5); // Select Cheapest Dropdown
		
		capture(driver, 16);
				 				 
	}
	
	@Test(priority=17,enabled=true)
	public void BS9() throws Exception {                          // Add product to cart 
		
		BedSheetsPage = new BedSheets(driver); // Visit BedSheets Page
		
		BedSheetsPage.BedsheetsClick();
		
		driver.findElement(By.cssSelector("a[title='Pack of 8 Premium 3D Print Natures Delight Bedsheet Sets (8BS16 3D)']")).click(); // click on 1st product 
		
		String parent = driver.getWindowHandle();
		
		Set<String> allHandles = driver.getWindowHandles();
		
		ArrayList<String> handles = new ArrayList<>(allHandles);
		
		String target = handles.get(1);
		
		driver.switchTo().window(target);
		
		driver.findElement(By.linkText("Click here to Buy")).click(); // Click on Buy Now Button
		
		driver.findElement(By.linkText("Proceed to Checkout")).click();  // Click on Proceed to CheckOut
		
		driver.switchTo().window(parent); // Switch back to parent handle 
		
		capture(driver, 17);
		
	}
	
	@Test(priority=18,enabled=true)
	public void DS1() throws Exception {
		
		
		DiwansetPage = new DiwanSets(driver);
		
		DiwansetPage.DiwanSetClick();
		
		String url = "https://www.naaptol.com/shop-online/home-decor/bed-bath/diwan-sets.html";
		
		Assert.assertEquals(driver.getCurrentUrl(), url);
		
		capture(driver, 18);
		
	}
	
	@Test(priority=19,enabled=true)
	public void DS2() throws Exception {
		
		
		DiwansetPage = new DiwanSets(driver);
		
		DiwansetPage.DiwanSetClick();
		
		driver.findElement(By.name("iscod")).click();  // Click on Cash on Delivery Checkbox
		
		driver.findElement(By.xpath("(//*[@class='button_1'])[1]")).click();  // Click on Set Button 
		
		capture(driver, 19);
		
	}
	
	@Test(priority=20,enabled=true)
	public void DS3() throws Exception {
		
		
		DiwansetPage = new DiwanSets(driver);
		
		DiwansetPage.DiwanSetClick();
		
		driver.findElement(By.name("isfreeship")).click();            // Click on Free Delivery Checkbox
		
		capture(driver, 20);
	}
	
	@Test(priority=21,enabled=true)
	public void DS4() throws Exception {                                      // Add to Compare list 
		
		
		DiwansetPage = new DiwanSets(driver);
		
		DiwansetPage.DiwanSetClick();
		
		driver.findElement(By.xpath("(//*[@catname='Diwan Sets'])[1]")).click();
		
		driver.findElement(By.xpath("(//*[@catname='Diwan Sets'])[2]")).click();
		
		capture(driver, 21);
		
	}
	
	@Test(priority=22,enabled=true)
	public void DS5() throws Exception {                                      // Sort option 
		
		
		DiwansetPage = new DiwanSets(driver);
		
		DiwansetPage.DiwanSetClick();
		
		WebElement dropdown = driver.findElement(By.id("sortByFilter"));
		
		Select s = new Select(dropdown);
		
		s.selectByIndex(4); // Select Most Expensive
				 					
		capture(driver, 22);
	}
	
	
	
	
}
