package BaseClasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyListener implements ITestListener {
	ExtentSparkReporter spark;
	ExtentReports report;
	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test.set(report.createTest(result.getName()));
	  }
	
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS,result.getName()+" from "+result.getTestClass()+" passed");
		test.remove();
	  }
	
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL,"Test failed "+result.getName());
		test.remove();
	  }
	
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//newReport.html");
	    spark.config().setDocumentTitle("Customized Report");
	    spark.config().setReportName("Testing Links");
	    report = new ExtentReports();
	    report.attachReporter(spark);
	    
	    report.setSystemInfo("Tester", "default");
	    report.setSystemInfo("Browser", "Chrome");
	    report.setSystemInfo("Environment", "QA");
	  }

	  
	  public void onFinish(ITestContext context) {
	    report.flush();
	  }
}
