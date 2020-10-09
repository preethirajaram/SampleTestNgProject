package regSuite_BaseSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import regSuits_Utils.ReadDataFile;

public class BaseSuite 
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
	public void setUp() throws Exception
	{
		System.out.println("** Before Suite ***");
		String path = System.getProperty("user.dir");
		String browserType = dataFile.getData("browser");		
		if(browserType.equalsIgnoreCase("Chrome")){
			System.out.println("Chrome Browser");
			System.setProperty("webdriver.chrome.driver",path+"//lib//chromedriver");
//			String driverPath = "/Users/manpreetkaur/automation/drivers/chromedriver";
//			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("Firefox") ){
			System.out.println("Firefox Browser");
			System.setProperty("webdriver.gecko.driver",path+"//lib//geckodriver");
			driver = new FirefoxDriver();
		}
	}

	@AfterSuite
	public void teardown(){
		System.out.println("***End of After Suite ***");
		driver.quit();
	}
	
	@BeforeClass
	public void launchApp() throws Exception{
		System.out.println("Launch the application");
		driver.get(dataFile.getData("url"));
		driver.manage().window().maximize();
		System.out.println("** End of Before Class ***");
	}
}
