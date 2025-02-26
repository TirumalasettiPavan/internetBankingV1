//package com.internetbanking.testCases;
//
//import java.io.IOException;
//
//import org.openqa.selenium.NoAlertPresentException;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.internetbanking.PageObjects.LoginPage;
//import com.internetbanking.utilities.XLUtils;
//
//import junit.framework.Assert;
//
//public class TC_LoginDDT_002 extends BaseClass {
//	@Test(dataProvider = "LoginData")
//	public void loginDDT(String user,String pwd) throws InterruptedException {
//		LoginPage lp=new LoginPage(driver);
//		lp.setUserName(user);
//		logger.info("user name provided");
//		lp.setPassword(pwd);
//		logger.info("password provided");
//		lp.clickSubmit();
//		Thread.sleep(4000);
//		
//		if(isAlertPresent()==true) {
//			driver.switchTo().alert().accept();//close alert
//			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
//			logger.warn("Login failed");
//		}
//		else {
//			Assert.assertTrue(true);
//			logger.info("Login passed");
//			Thread.sleep(4000);
//			lp.clickLogout();
//			driver.switchTo().alert().accept();//close logout alert
//			driver.switchTo().defaultContent();
//		}
//		
//	}
//	
//	public boolean isAlertPresent() {
//		try {
//			driver.switchTo().alert();
//			return true;
//		}
//		catch(NoAlertPresentException e){
//			return false;
//			
//		}
//	}
//	
//	
//	@DataProvider(name="LoginData")
//	String[][] getData() throws IOException{
//		String path=System.getProperty("./testData/LoginData.xlsx");
//		int rownum=XLUtils.getRowCount(path, "Sheet1");
//		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
//		
//		String logindata[][]=new String[rownum][colcount];
//		for(int i=1;i<=rownum;i++) {
//			for(int j=0;j<colcount;j++) {
//				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1,0
//			}
//		}
//		return logindata;
//	}
//}

package com.internetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.PageObjects.LoginPage;
import com.internetbanking.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/internetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}

