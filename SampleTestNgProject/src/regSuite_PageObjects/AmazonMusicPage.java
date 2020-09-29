package regSuite_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import regSuits_Utils.DriverActions;
import regSuits_Utils.ReadDataFile;

public class AmazonMusicPage {
	WebDriver driver;
	public ReadDataFile dataFile = new ReadDataFile(System.getProperty("user.dir")+"//configs//data.properties");
	
	
	@FindBy(id="nav-hamburger-menu")
    WebElement  Menu;
	
	@FindBy(xpath="//*[@id='hmenu-content']/ul[1]/li[3]/a")
	WebElement AmazonMusic;
	
	@FindBy(xpath="//*[@id='hmenu-content']/ul[3]/li[3]/a")
	WebElement AmazonMusicUnlimited;
	
	@FindBy (xpath="//*[@id='navBackToTop']/div/span")
	WebElement BacktoTop;
	
	@FindBy(xpath="//img[contains(@src,'AMU_logo.png')]")
	WebElement MusicUnlimitedImage;
	
	public AmazonMusicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void OpenMenu()
    {

		DriverActions.clickElementBy(Menu);
		DriverActions.clickElementBy(AmazonMusic);
		DriverActions.clickElementBy(AmazonMusicUnlimited);
		//DriverActions.clickElementBy(BacktoTop);
		
	}	
	
	public void assertOpenMenu() throws Exception{
		Assert.assertTrue(DriverActions.isElementVisible(MusicUnlimitedImage));
	}
}



