package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BrowserFactory;

public class EventListner implements ITestListener{
	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());
	BrowserFactory baseObj = new BrowserFactory();

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		log.info("Flow Finished "+arg0);
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		log.info("FLow Started "+arg0);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("Test Failed but within success percentage "+arg0);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		baseObj.getScreenshot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("Test Skipped "+arg0);
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("Test Started "+arg0);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		log.info("Test Success "+arg0);
	}
	
	
}