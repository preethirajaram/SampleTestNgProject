package regSuits_Utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import regSuite_BaseSuite.BaseSuite;
import regSuite_Tests.AmazonTest;

public class TestListener extends BaseSuite implements ITestListener{

	String filePath = System.getProperty("user.dir")+"\\Screenshots\\";
	static Logger log = Logger.getLogger(TestListener.class.getName());

	@Override		
	public void onTestFailure(ITestResult result) {	
		try {
			final String methodName =result.getName().toString().trim();
			System.out.println(methodName);
			Object currentClass = result.getInstance();
			if(!(currentClass instanceof ISeleniumTest)){
				return;
			}
			WebDriver driver = ((ISeleniumTest) currentClass).getWebDriver();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
			log.info("Testcase Failed: "+methodName);
			log.info("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
			log.info("*********** Exception Occured ***********");
			e.printStackTrace();
		}
	}	

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		log.info("*********** ON_FINISH ***********");
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		log.info("*********** ON_START ***********");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("*********** ON_TEST_SKIPPED ***********");

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("*********** ON_TEST_START ***********");

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("*********** ON_TEST_SUCCESS ***********");
	}
	
	public String getMethodName(ITestResult result){
		return result.getName().trim();
	}
}
