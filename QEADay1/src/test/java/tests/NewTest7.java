package tests;

import org.testng.annotations.Test;

public class NewTest7 {
	
	@Test(groups = {"dry"})
	public void testGoogle()
	{
		System.out.println("in test google");
	}
	@Test(groups = {"smoke"})
	public void testHDFC()
	{
		System.out.println("in test hdfc");
	}
	@Test(groups = {"dry"})
	public void testCiti()
	{
		System.out.println("in test citi");
	}
}
