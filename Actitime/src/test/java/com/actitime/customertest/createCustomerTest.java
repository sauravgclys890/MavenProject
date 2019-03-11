package com.actitime.customertest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genriclib.BaseClass;
import com.actitime.objectrepostaortylib.CreateNewCustomerPage;
import com.actitime.objectrepostaortylib.HomePage;
import com.actitime.objectrepostaortylib.TaskList;

@Listeners(com.actitime.genriclib.BaseClass.class)
public class createCustomerTest extends BaseClass{
	
	@Test
	public void createCustomerTest() throws Throwable {
		
		//read data from excel
		
		String customerName= flib.getExcelData("Sheet1", 11, 2);
		
		//click on task Image
		
		HomePage hp= PageFactory.initElements(driver, HomePage.class);
		
		hp.clickOnTaskImage();
		
		//navigate to create new customer page
		TaskList tl= PageFactory.initElements(driver, TaskList.class);
		
		tl.navigateToCustomerNewPage();
		
		//create new customer
		
		CreateNewCustomerPage  cp=PageFactory.initElements(driver, CreateNewCustomerPage.class);
		
		cp.createcustomer(customerName);
		
		//step 5 verify
		
		String expcustomernamesuccessmessage= flib.getExcelData("Sheet1", 11, 3);
		
		Thread.sleep(2000);
		
		String actcustomersuccessmessgae=tl.getCreateCustomerNameDetails().getText();
		
		Assert.assertEquals(actcustomersuccessmessgae, expcustomernamesuccessmessage);
			
		
	}

	@Test
	public void createcustomerwithdescription() throws Throwable {
		
		String customername= flib.getExcelData("Sheet1", 13, 2);
		
		String discription= flib.getExcelData("Sheet1", 13, 3);
		
		//click on task Image
		
				HomePage hp= PageFactory.initElements(driver, HomePage.class);
				
				hp.clickOnTaskImage();
				
				//navigate to create new customer page
				TaskList tl= PageFactory.initElements(driver, TaskList.class);
				
				tl.navigateToCustomerNewPage();
				
				//create new customer
				
				CreateNewCustomerPage  cp=PageFactory.initElements(driver, CreateNewCustomerPage.class);
				
				cp.createCustomewithDescription(customername, discription);
				
				//step 5 verify
				
				String expcustomernamesuccessmessage= flib.getExcelData("Sheet1", 13, 4);
				
				Thread.sleep(2000);
				
				String actcustomersuccessmessgae=tl.getCreateCustomerNameDetails().getText();
				
				Assert.assertEquals(actcustomersuccessmessgae, expcustomernamesuccessmessage);
		
	}
}
