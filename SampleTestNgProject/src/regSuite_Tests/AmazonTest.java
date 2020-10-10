package regSuite_Tests;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import regSuite_BaseSuite.BaseSuite;
import regSuite_PageObjects.AmazonMusicPage;

public class AmazonTest extends BaseSuite {
	AmazonMusicPage amazonmusic;
	static Logger log = Logger.getLogger(AmazonTest.class.getName());

	@Test
	public void AmazonPrimeMusic() throws Exception{	
		log.info("Amazon PrimeMusic Testcase");
		amazonmusic = new AmazonMusicPage(getWebDriver());
		amazonmusic.NavigateToPrimeMusicImage();
		amazonmusic.assertPrimeMusicImage();
	}
}
