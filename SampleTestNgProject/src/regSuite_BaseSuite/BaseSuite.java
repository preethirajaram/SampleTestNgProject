package regSuite_BaseSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import regSuits_Utils.ISeleniumTest;
import regSuits_Utils.ReadDataFile;

public class BaseSuite implements ISeleniumTest
{
	public ReadDataFile dataFile = new ReadDataFile(System.getProperty("user.dir")+"//configs//data.properties");
	
	public WebDriver driver;
	public String testName;
	
	public WebDriver getWebDriver(){
		return driver;
	}
	
	public String getTestName(){
		return testName;
	}
	
	@BeforeSuite
	public static ReadDataFile loadProperties(){
		System.out.println("BeforeSuite: Load the Properties");
		ReadDataFile dataFile = new ReadDataFile(System.getProperty("user.dir")+"//configs//data.properties");
		return dataFile;
	}
	
	@BeforeClass
	public void setUp() throws Exception
	{
		System.out.println("BeforeClass: Launch the Browser");
		String path = System.getProperty("user.dir");
		String browserType = dataFile.getData("browser");		
		if(browserType.equalsIgnoreCase("Chrome")){
			System.out.println("Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver",path+"//lib//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("Firefox") ){
			System.out.println("Launching Firefox Browser");
			System.setProperty("webdriver.gecko.driver",path+"//lib//geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@AfterMethod
	public void afterMethod(){
		System.out.println("AfterMethod: End of TestMethod ");
	}
	
	@AfterClass
	public void close(){
		System.out.println("AfterClass: End of Class ");
		driver.close();
	}
	
	@BeforeMethod
	public void launchApp() throws Exception{
		System.out.println("BeforeMethod: Start of TestMethod ");
		driver.get(dataFile.getData("url"));
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown(){
		System.out.println("AfterSuite: End of Suite");
		driver.quit();
	}
}
