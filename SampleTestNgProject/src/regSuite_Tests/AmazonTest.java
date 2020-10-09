package regSuite_Tests;

import org.testng.annotations.Test;

import regSuite_BaseSuite.BaseSuite;
import regSuite_PageObjects.AmazonMusicPage;

public class AmazonTest extends BaseSuite {
	AmazonMusicPage amazonmusic;

	@Test
	public void AmazonPrimeMusic() throws Exception{
		System.out.println("Amazon PrimeMusic");	
		amazonmusic = new AmazonMusicPage(getWebDriver());
		amazonmusic.NavigateToPrimeMusicImage();
		amazonmusic.assertPrimeMusicImage();
	}
}
