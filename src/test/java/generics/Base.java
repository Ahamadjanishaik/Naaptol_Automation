package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Base {
	
	protected WebDriver driver;
	
	String Url;
	
	ExtentReports report;
    com.aventstack.extentreports.ExtentTest test;

    @BeforeClass
    public void reportconfig() {
        // Specify the path where the report will be saved
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\janus\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Naaptol_project_TestNG\\report.html");
        
        // Initialize ExtentReports
        report = new ExtentReports();
        
        // Attach the reporter to ExtentReports
        report.attachReporter(sparkReporter);
        
        // Start a new test
        test = report.createTest("Naaptol Testing");
    }
	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		driver = new ChromeDriver();
		
		Properties pr = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\janus\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Naaptol_project_TestNG\\src\\test\\resources\\config.properties");
		
		pr.load(fis);
		
		Url = pr.getProperty("url");
		
		driver.get(Url);
				
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@AfterClass
    public void tearDown() {
        // Flush the reports to write all details to the file
        if (report != null) {
            report.flush();
        }
    }
	
	
}
