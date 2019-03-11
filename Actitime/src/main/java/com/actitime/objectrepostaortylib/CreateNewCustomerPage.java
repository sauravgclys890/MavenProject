package com.actitime.objectrepostaortylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerPage {
	
	@FindBy(id="customerLightBox_nameField")
	
	private WebElement customerNameEdt;
	
	@FindBy(id="customerLightBox_descriptionField")
	
	private WebElement customerDescriptionEdt;
	
	@FindBy(xpath="//span[text()='Create Customer'][1]")
	
	private WebElement createCustomerBtn;
	
	//Overloading concept
	
	public void createcustomer(String customerName) {
		
		customerNameEdt.sendKeys(customerName);
		
		createCustomerBtn.click();
	}
	
	public void createCustomewithDescription(String customerName, String description) {
		
		customerNameEdt.sendKeys(customerName);
		
		customerDescriptionEdt.sendKeys(description);
		
		createCustomerBtn.click();
	}

}
