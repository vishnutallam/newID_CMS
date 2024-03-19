package com.ID_CMS.manageOrderAcceptFlowTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_CMS.Pages.LanguageSelection;
import com.ID_CMS.Pages.ManageOrders;
import com.ID_CMS.utilities.BaseClass;

public class TC003_UpdateAddress extends BaseClass {
	@Test
	 
	   
    public static void TC003_UpdateAddress() throws InterruptedException, IOException {
	 
		
		 ManageOrders.updateAddress();
		 WebElement updateAddSuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::strong"));
			
			System.out.println( "upadted address msg is  --- "+updateAddSuccessMsg.getText());
			
			if(updateAddSuccessMsg.getText().equals("Success!")) {
				Assert.assertTrue(true);
				System.out.println("Update Address passed");
			}
			else {
				captureScreen(driver,"TC003_UpdateAddress");
				Assert.assertTrue(false);
				System.out.println("Update Address failed");
			}
	
	}

}
