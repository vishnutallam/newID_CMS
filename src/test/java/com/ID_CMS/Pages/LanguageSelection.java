package com.ID_CMS.Pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ID_CMS.utilities.BaseClass;


public class LanguageSelection extends BaseClass{
	

	
	public static void lanSelTest() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		
		driver.findElement(By.xpath("//*[@class='nav-link opacity_1']/div[1]/label[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement salon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='Manage Salon'])")));
		
		
		String ActResult=salon.getText();
		String ExpResult="Manage Salon";
		if(ExpResult.equals(ActResult))
		{
			Assert.assertTrue(true);
	       logger.info("Language is in English");
		   System.out.println("Language is in English");
			
		}
		else
		{
			
	       logger.info("Language not changed");
			System.out.println("Language not changed");
			Assert.assertTrue(false);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		
	}
	


}
