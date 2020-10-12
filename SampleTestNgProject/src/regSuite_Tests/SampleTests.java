package regSuite_Tests;

import java.util.logging.Logger;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import regSuite_BaseSuite.BaseSuite;
import regSuite_PageObjects.HomePage;

public class SampleTests extends BaseSuite {
	HomePage homepage;
	static Logger log = Logger.getLogger(SampleTests.class.getName());

	
	@Test(priority=2)
	@Parameters("BookName")
	public void searchABook(String bookName) throws Exception{
		log.info("Search a Book Testcase");
		homepage = new HomePage(getWebDriver());
		homepage.searchBook(bookName);
		homepage.assertSearchTitle();
	}
	
	@Test(priority=1)
	public void testSample(){
		System.out.println("Sale!");
	}
	
	@Test
	public void printName12() {
		System.out.println("Preethi12");
	}
	
	@Test
	public void buyOnline() {
		System.out.println("Chocolate");
	}
	
	@Test
	public void payOnline() {
		System.out.println("Money");
	}
	
	@Test
	public void payOnline1() {
		System.out.println("Money");
	}
	
	@Test
	public void payOnline2() {
		System.out.println("Money");
	}
	
	@Test
	public void printName13() {
		System.out.println("Preethi12");
	}
	

}
