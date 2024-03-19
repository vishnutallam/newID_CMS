package com.ID_CMS.utilities;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.ID_CMS.utilities.Mailing;

import io.github.bonigarcia.wdm.WebDriverManager;





public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String email=readconfig.getEmail();
	public String password=readconfig.getPassword();


	
	public static WebDriver driver;
	public static Logger logger;

	
	static By email_xpath=By.xpath("//input[@id='email']");
	static By password_xpath=By.xpath("//input[@id='password']");
	static By login_xpath=By.xpath("//button[@type='submit']");
	

	

	@BeforeSuite
	public void setup() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		

		
	    logger=Logger.getLogger("SoComm");
		PropertyConfigurator.configure("Log4j.properties");
		
		
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        System.out.println("Application Opened");
        driver.findElement(email_xpath).sendKeys(email);
		driver.findElement(password_xpath).sendKeys(password);
		driver.findElement(login_xpath).click();
		
		
		
	WebElement dashboard=driver.findElement(By.xpath("//*[@class='content-header']/ol/li/a"));
	String ActResult=dashboard.getText();
	String ExpResult="Dashboard";
	if(ExpResult.equals(ActResult))
	{
		Assert.assertTrue(true);
       logger.info("Login Successfull");
	   System.out.println("Login Successfull");
		
	}
	else
	{
       logger.info("Login failed");
		System.out.println("Login failed");
		Assert.assertTrue(false);
	}
		
}
	

	
	@AfterTest
	public static void SendingMail() throws AddressException, IOException, MessagingException{
		
		Runtime r=Runtime.getRuntime();  	  
		r.addShutdownHook(new Thread(){  
		public void run(){  
			Mailing sm = new Mailing();
			try {
				sm.mail();
				System.out.println("Report has been sent"); 
			} catch (IOException | MessagingException e) {
				e.printStackTrace();
			}
			
		    }  
		}  
		);  
		try{Thread.sleep(5000);}catch (Exception e) 
		{
			System.out.println(e);
		}  
		//driver.quit();
		
		}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		
		
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}

