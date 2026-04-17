package BaseClasses; 

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

  private int retryCount = 0;
  private static final int maxRetryCount = 3;

  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
    	ITestContext con=result.getTestContext();
      retryCount++;
      con.setAttribute("retryCount", retryCount);
      return true;
    }
    return false;
  }
}