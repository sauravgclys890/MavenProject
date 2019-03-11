package com.actitime.objectrepostaortylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskList {
	
	@FindBy(xpath="//a[text()='Completed Tasks']")
	
	private WebElement completedTaskbtn;
	
	@FindBy(xpath="//a[text()='Projects & Customers']")
	
	private WebElement projectAndcustomerbtn;
	
	@FindBy(xpath="//a[text()='Archives']")
	
	private WebElement archivesBtn;
	
	@FindBy(xpath="//a[text()='Open Tasks']")
	
	private WebElement OpenTasksBtn;
	
	@FindBy(xpath="//span[text()='Create Tasks']")
	
	private WebElement createTasksBtn;
	
	@FindBy(xpath="//div[@id='ext-comp-1002']/span")
	
	private WebElement createNewCustomerBtn;
	
	@FindBy(xpath="//span[@class='successmsg']")
	
	private WebElement createCustomerNameDetails;
	
	public WebElement getCreateCustomerNameDetails() {
		return createCustomerNameDetails;
	}

	public void clickOnCreateTask() {
		
		createTasksBtn.click();
	}
	
	public void navigateToCustomerNewPage() {
		
		projectAndcustomerbtn.click();
		
		createNewCustomerBtn.click();
	}
	
	
	

}
