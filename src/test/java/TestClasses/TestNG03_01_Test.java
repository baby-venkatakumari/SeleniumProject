package TestClasses;

import org.testng.annotations.Test;

public class TestNG03_01_Test {

	@Test(groups= {"smoke","regression","functional"})
	public void test1()
	{
		System.out.println("Smoke, regression and functional");
	}
	@Test(groups= {"smoke","regression"})
	public void test2()
	{
		System.out.println("Smoke, regression");
	}
	@Test(groups= {"smoke","functional"})
	public void test3()
	{
		System.out.println("Smoke and functional");
	}
	@Test(groups= {"regression","functional"})
	public void test4()
	{
		System.out.println("regression and functional");
	}
	@Test(groups= {"smoke"})
	public void test5()
	{
		System.out.println("Smoke");
	}
	@Test(groups= {"regression"})
	public void test6()
	{
		System.out.println("regression");
	}
	@Test(groups= {"functional"})
	public void test7()
	{
		System.out.println("functional");
	}
}
