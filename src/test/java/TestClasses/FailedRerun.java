package TestClasses;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class FailedRerun {

	//@Test
	public void test1()
	{
		Assert.assertTrue(true);
	}
	
	//@Test
	public void test2()
	{
		Assert.assertTrue(false);
	}
	
	//@Test(retryAnalyzer = BaseClasses.RetryAnalyzer.class)
	public void test3(ITestContext context)
	{
		if((int)context.getAttribute("retryCount")>=1)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
