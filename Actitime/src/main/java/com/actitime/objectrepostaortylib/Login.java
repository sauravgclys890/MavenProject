package com.actitime.objectrepostaortylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(id="username")
	
	private WebElement usernameEditbox;
	
	@FindBy(name="pwd")
	
	private WebElement passwordEdirbox;
	
	  	@FindBy(id="loginButton")
	  	
	  	private WebElement loginbutton;
	  	
	@FindBy(xpath="//img[conatins(@src, 'timer.pnd')]")
	
	private WebElement actitimeImage;
	
	@FindBy(xpath="//img[contains[@src, 'logo.png']]")
	
	private WebElement actitimeLogo;
	
	@FindBy(id="keepLoggedInCheckBox")
	
	private WebElement actitmecheckBox;
	
    @FindBy(id="keepLoggedInLabel")
	
	private WebElement checkBoxMessage;
	
	public WebElement getUsernameEditbox() {
		return usernameEditbox;
	}

	public WebElement getPasswordEdirbox() {
		return passwordEdirbox;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getActitimeImage() {
		return actitimeImage;
	}

	public WebElement getActitimeLogo() {
		return actitimeLogo;
	}

	public WebElement getActitmecheckBox() {
		return actitmecheckBox;
	}

	public WebElement getCheckBoxMessage() {
		return checkBoxMessage;
	}

	public void logintoApp(String username, String password) {
		
		usernameEditbox.sendKeys(username);
		
		passwordEdirbox.sendKeys(password);
		
		loginbutton.click();
	}
	
	
	
	

}
