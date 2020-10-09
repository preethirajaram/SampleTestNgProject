package regSuits_Utils;

import org.openqa.selenium.WebElement;

import regSuite_BaseSuite.BaseSuite;

public class DriverActions extends BaseSuite {
	
	public static void clickElementBy(WebElement searchBar){
		searchBar.click();
	}

	public static void enterInputData(WebElement searchBar, String text){
		searchBar.sendKeys(text);
	}
	
	public static void submitData(WebElement searchBarSubmit){
		searchBarSubmit.submit();
	}
	
	public static String getDatafromPage(WebElement searchresults){
		return searchresults.getText();
	}
	
	public static boolean isElementVisible(WebElement element) {
		return element.isDisplayed();
	}


}
