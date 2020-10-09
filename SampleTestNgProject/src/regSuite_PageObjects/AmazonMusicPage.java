package regSuite_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import regSuite_BaseSuite.BaseSuite;
import regSuits_Utils.DriverActions;

public class AmazonMusicPage extends BaseSuite{
	WebDriver driver;
	
	@FindBy(id="nav-hamburger-menu")
    WebElement  Menu;
	
	@FindBy(xpath="//a[@class='hmenu-item']/div[text()='Amazon Prime Music']")
	WebElement AmazonMusic;
	
	@FindBy(xpath="//ul[@data-menu-id='7']/li/div[text()='amazon prime music']")
	WebElement AmazonMusicSubMenu;
	
	@FindBy(xpath="//ul[@data-menu-id='7']/li[3]/a")
	WebElement PrimeMusicImage;
	
	public AmazonMusicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void NavigateToPrimeMusicImage() throws InterruptedException
    {
		DriverActions.clickElementBy(Menu);
		DriverActions.clickElementBy(AmazonMusic);
		DriverActions.clickElementBy(AmazonMusicSubMenu);
	}	
	
	public void assertPrimeMusicImage() throws Exception{
		Assert.assertTrue(DriverActions.isElementVisible(PrimeMusicImage));
	}
}



