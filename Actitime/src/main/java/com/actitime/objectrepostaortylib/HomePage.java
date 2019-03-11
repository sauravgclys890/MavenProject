package com.actitime.objectrepostaortylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//div[text()='TASKS']")
	
	private WebElement taskImg;
	
	@FindBy(xpath="//div[text()='REPORTS']")
	
	private WebElement reportImg;
	
	@FindBy(id="logoutLink")
	
	private WebElement logout;
	
	@FindBy(xpath="//div[text()='TIME-TRACK']")
	
	private WebElement timetrackImg;
	
	@FindBy(xpath="//img[contains(@src, 'logo.png')]")
	
	private WebElement logoImage;
	
	public WebElement getLogoImage() {
		return logoImage;
	}

	public void clickOnTaskImage() {
		
		taskImg.click();
	}
	
	public void clickOnReportImage() {
		
		reportImg.click();
	}
	
	public void logout() {
		
		logout.click();
	}
	
	public void clickOnTimetrackImage() {
		
		timetrackImg.click();
	}
	
	

}
