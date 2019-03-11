package com.actitime.genriclib;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.objectrepostaortylib.HomePage;
import com.actitime.objectrepostaortylib.Login;



/**
 * Below class is devloped to capture the screen shot whenever test case are getting failed
 * @author ADMIN
 *
 */


public class BaseClass implements ITestListener {
	
	public static WebDriver driver;
	
	public static FileLib flib= new FileLib();

	
	@BeforeSuite
	public void configBS() {
		
		System.out.println("connect to the DB");
	}
	
	@BeforeClass
	public void configBC() throws Throwable {
		
		Reporter.log("Launch the Browser", true);
		
		String browserName= flib.getPropertyKeyValue("Browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			
			 driver= new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			
			driver= new FirefoxDriver();
			
		}else if(browserName.equals("ie")) {
			
			driver= new InternetExplorerDriver();
		}
	   
	   driver.manage().window().maximize();
	   
	   driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void logintoApp() throws Throwable {
		
		
		Reporter.log("Login to Application");
		
		String URL=flib.getPropertyKeyValue("url");
		
		String USER=flib.getPropertyKeyValue("username");
		
		String Password=flib.getPropertyKeyValue("password");
		
		driver.get(URL);
		
		Login lp= PageFactory.initElements(driver, Login.class);
		
		lp.logintoApp(USER, Password);
		
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void logouttoApp() throws Throwable {
		
		Thread.sleep(2000);
		
		Reporter.log("logout the Appliaction");
		
		HomePage hp= PageFactory.initElements(driver, HomePage.class);
		
		hp.logout();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		
		System.out.println("close the browser");
		
		driver.close();
	}
	@AfterSuite
	public void configAC() {
		
		System.out.println("Dissconnect to DB");
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult itestresult) {
		
String failedTestCaseName= itestresult.getMethod().getMethodName();
		
		EventFiringWebDriver efiringweb= new EventFiringWebDriver(BaseClass.driver);
		
		File screenfile=efiringweb.getScreenshotAs(OutputType.FILE);
		
		File dstfile= new File("./screenshot/"+failedTestCaseName+".png");
		
		try {
			FileUtils.copyFile(screenfile, dstfile);
		} catch (IOException e) {
		
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
