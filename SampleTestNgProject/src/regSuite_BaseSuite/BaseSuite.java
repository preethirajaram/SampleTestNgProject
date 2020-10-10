package regSuite_BaseSuite;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import regSuite_Tests.AmazonTest;
import regSuits_Utils.ISeleniumTest;
import regSuits_Utils.ReadDataFile;

public class BaseSuite implements ISeleniumTest
{
	public static ReadDataFile dataFile;
	//public ReadDataFile dataFile = new ReadDataFile(System.getProperty("user.dir")+"//configs//data.properties");
	static Logger log = Logger.getLogger(BaseSuite.class.getName());


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
		log.info("BeforeSuite: Load the Properties");
		String log4jConfigFile = System.getProperty("user.dir")
				+"//configs//log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		dataFile = new ReadDataFile(System.getProperty("user.dir")+"//configs//data.properties");
		return dataFile;
	}

	@BeforeClass
	public void setUp() 
	{
		log.info("BeforeClass: Launch the Browser");
		String path = System.getProperty("user.dir");
		String browserType;
		try {
			browserType = dataFile.getData("browser");		
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
		} catch (Exception e) {
			log.info("Browser not found");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod(){
		log.info("AfterMethod: End of TestMethod ");
	}

	@AfterClass
	public void close(){
		log.info("AfterClass: End of Class ");
		driver.close();
	}

	@BeforeMethod
	public void launchApp() throws Exception{
		log.info("BeforeMethod: Start of TestMethod ");
		driver.get(dataFile.getData("url"));
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void teardown(){
		log.info("AfterSuite: End of Suite");
		driver.quit();
	}
}
