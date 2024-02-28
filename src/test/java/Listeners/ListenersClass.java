package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import resources.BaseClass;
import ReportsConfig.extentManager;

public class ListenersClass extends extentManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		setTest(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		
		getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " Test Case Passed",ExtentColor.GREEN));

		System.out.println(testMethodName + " " + "Test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " Test Case Failed",ExtentColor.RED));
		getTest().log(Status.FAIL, result.getThrowable());

		try {
			String path=BaseClass.screenShot(BaseClass.driver, result.getName());
			getTest().addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getTest().log(Status.FAIL, testMethodName + " " + "Failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		getTest().log(Status.SKIP, testMethodName + " " + "Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		getTest().log(Status.WARNING, testMethodName + " " + "Test failed but within success percentage");

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		getTest().log(Status.WARNING, testMethodName + " " + "onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test Suite Started");	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test Suite Ended");	
	}





}










































