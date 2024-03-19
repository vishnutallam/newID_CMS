package com.ID_CMS.manageOrderAcceptFlowTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_CMS.Pages.ManageOrders;
import com.ID_CMS.utilities.BaseClass;

public class TC004_AddNewPro extends BaseClass {
	
	@Test
	
	 public static void TC004_addNewPro() throws InterruptedException, IOException {
		 
		
		ManageOrders.addNewPro();
		 WebElement SuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::strong"));
			
			System.out.println( "accept msg is  --- "+SuccessMsg.getText());
			
			if(SuccessMsg.getText().contains("Product added successfully.")) {
				Assert.assertTrue(true);
				System.out.println("Add New Product passed");
			}
			else {
				captureScreen(driver,"TC004_addNewPro");
				Assert.assertTrue(false);
				System.out.println("Add New Product failed");
			}
			
	 }

}
