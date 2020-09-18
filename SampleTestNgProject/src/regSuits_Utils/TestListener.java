package regSuits_Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import regSuite_BaseSuite.BaseSuite;

public class TestListener extends BaseSuite implements ITestListener{

	String filePath = System.getProperty("user.dir")+"/Screenshots/";

	@Override		
	public void onTestFailure(ITestResult result) {	
		try {
			System.out.println("***** Error "+result.getName()+" test has failed *****");
			String methodName=result.getName().toString().trim();
			System.out.println(methodName);
			File scrFile = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
			System.out.println("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
			System.out.println("*********** Exception Occured ***********");
			e.printStackTrace();
		}
	}	

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
