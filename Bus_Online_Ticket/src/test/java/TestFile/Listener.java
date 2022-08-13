package TestFile;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentSparkReportNG;

public class Listener extends Base implements ITestListener {

	ExtentReports extent = ExtentSparkReportNG.getReportObject();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test case is passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
	    extent.flush();
	}

}
