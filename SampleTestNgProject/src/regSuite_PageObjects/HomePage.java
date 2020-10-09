package regSuite_PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import regSuite_BaseSuite.BaseSuite;
import regSuits_Utils.DriverActions;

public class HomePage extends BaseSuite {
	WebDriver driver;
	//ReadDataFile dataFile;
	//public ReadDataFile dataFile = new ReadDataFile(System.getProperty("user.dir")+"//configs//data.properties");
	
	@FindBy(id="twotabsearchtextbox")
    WebElement searchBar;
	
	@FindBy(className ="nav-input")
	WebElement searchBarSubmit;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement searchresults;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchBook(String bookName) {
		
		DriverActions.clickElementBy(searchBar);
		DriverActions.enterInputData(searchBar,bookName);
		DriverActions.submitData(searchBarSubmit);
	}	
	
	public void assertSearchTitle() throws Exception{
		String actual = DriverActions.getDatafromPage(searchresults);
		String expected = dataFile.getData("expected_search_result");
		Assert.assertTrue(expected.equals(actual));
	}
}
