package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	
	public static ExtentHtmlReporter hmtlReport;
	public static ExtentReports report;// we will create the object inside our our Before and after method
	public static ExtentTest test;
	
	
	@BeforeMethod(alwaysRun=true)// to make sure our test 100% running
	public static void setUpDriver() {
		ConfigsReader.readProperties(Constant.CREDENTIALS_FILEPATH);// we simply reading our properties in this line ("src/test/resources/configs/credentials.properties")
		String browser1=ConfigsReader.getProperty("browser");// Getting to browser in line
		if(browser1.equalsIgnoreCase("chrome")) {
			
		
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Sekander Salihi/Selenium/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers./chromedriver.exe");
		 driver=new ChromeDriver();
		}else if (browser1.equalsIgnoreCase("firefox")) {
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Sekander Salihi/Selenium/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");//...1
		 driver=new FirefoxDriver();//...2
		} else if (browser1.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriver.exe");
		driver=new InternetExplorerDriver();
		
		}else {
			System.out.println("Given brower in wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.get(ConfigsReader.getProperty("url"));
	driver.manage().window().maximize();

	}
	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		driver.quit();
	}
	
	@BeforeTest (alwaysRun=true)
	public void generateReport() {
		ConfigsReader.readProperties(Constant.CREDENTIALS_FILEPATH);
		//create an object of extentReport and htmlReporter
		hmtlReport=new ExtentHtmlReporter(Constant.REPORT_FILEPATH);
		 report=new ExtentReports();
		report.attachReporter(hmtlReport);
		//provide some info (optional)
		report.setSystemInfo("OS", Constant.OS_NAME);
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
		report.setSystemInfo("QA Engineer", Constant.USER_NAME);
		
		
	}
	
	@AfterTest (alwaysRun=true)
	public void flushReport() {
		report.flush();
		
	}
}
