package com.actitime.logintest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.genriclib.BaseClass;
import com.actitime.objectrepostaortylib.HomePage;

public class VerifyHomePageTest extends BaseClass {
	
	@Test
	public void verifyHomePageTest() throws Throwable {
		
		String acttitleofpage=driver.getTitle();
		
		String exptitleofthepage=flib.getExcelData("Sheet1", 15, 2);
		
		Reporter.log(exptitleofthepage, true);
		
		Reporter.log(acttitleofpage, true);
		
		Assert.assertEquals(acttitleofpage, exptitleofthepage);
	}
	
	@Test
	public void verifyLogoOnHomePage() {
		
		HomePage hp= PageFactory.initElements(driver, HomePage.class);
		
		Boolean status=hp.getLogoImage().isDisplayed();
		
		Assert.assertTrue(status);
	}

}
