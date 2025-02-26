package com.internetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.internetbanking.PageObjects.AddCustomerPage;
import com.internetbanking.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("Providing Customer details");
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("19", "08", "2003");
		addcust.custaddress("INDIA");
		addcust.custcity("Hyderabad");
		addcust.custstate("AP");
		addcust.custpinno("5000076");
		addcust.custTelephoneNumber("987890094");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemaiid(email);
		addcust.custsubmit();
		
		Thread.sleep(4000);
		
		logger.info("Validation started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case filed....");
		}
	}
	
	public String randomestring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	public String randomeNum() {
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
	

}
