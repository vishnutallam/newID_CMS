package com.ID_CMS.manageOrderDeclineFlowTests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.EventLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_CMS.Pages.*;
import com.ID_CMS.utilities.BaseClass;

public class TC002_Edit extends BaseClass {
	@Test
	 
	   
    public static void TC002_Edit() throws InterruptedException, IOException {
	 

		LanguageSelection.lanSelTest();
	 logger.info("language selected");
	 ManageOrders.manageOrders();
 logger.info("Entered into Manage Orders");
// ManageOrders.getOrderNum();
// ManageOrders.fetchOrder();
	 ManageOrders.edit();
	 logger.info("edit the order");
	 
	 WebElement editHeader=driver.findElement(By.xpath("//section[@class='content-header']/h1"));
	System.out.println( editHeader.getText());
	
	if(editHeader.getText().equals("Edit Order Preview")) {
		Assert.assertTrue(true);
		System.out.println("Edit passed");
	}
	else {
		
		captureScreen(driver,"TC002_Edit");
		Assert.assertTrue(false);
		System.out.println("Edit failed");
	}
	
	}
        

}
