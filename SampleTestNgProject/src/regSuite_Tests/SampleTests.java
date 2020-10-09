package regSuite_Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import regSuite_BaseSuite.BaseSuite;
import regSuite_PageObjects.HomePage;

public class SampleTests extends BaseSuite {
	HomePage homepage;
	
	@Test(priority=2)
	@Parameters("BookName")
	public void searchABook(String bookName) throws Exception{
		System.out.println("Search a Book");	
		homepage = new HomePage(getWebDriver());
		homepage.searchBook(bookName);
		homepage.assertSearchTitle();
	}
	
	@Test(priority=1)
	public void testSample(){
		System.out.println("Sale!");
	}
	
	@Test
	public void printName() {
		System.out.println("Preethi");
	}
	
	@Test
	public void buyOnline() {
		System.out.println("Chocolate");
	}
	
	@Test
	public void payOnline() {
		System.out.println("Money");
	}

}
