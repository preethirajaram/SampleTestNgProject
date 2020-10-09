package regSuite_Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import regSuite_BaseSuite.BaseSuite;
import regSuite_PageObjects.AmazonMusicPage;

public class AmazonTest extends BaseSuite {
	AmazonMusicPage amazonmusic;
		
		@Test
		public void OpenMenu() throws Exception{
			System.out.println("Open Menu");	
			amazonmusic = new AmazonMusicPage(getWebDriver());
			amazonmusic.OpenMenu();
			amazonmusic.assertOpenMenu();

}
}
