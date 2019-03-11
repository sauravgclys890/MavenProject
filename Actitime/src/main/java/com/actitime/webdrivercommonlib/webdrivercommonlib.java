package com.actitime.webdrivercommonlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.genriclib.BaseClass;

public class webdrivercommonlib extends BaseClass {
	
	public void waitForPageLoad() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void explicitWait(String elementXpath, int time) {
		
		WebDriverWait wait= new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
	}
	
	public void select(WebElement element, String option) {
		
		Select sel= new Select(element);
		
		sel.selectByVisibleText(option);
	}
	
     

}
