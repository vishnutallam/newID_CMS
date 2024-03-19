package com.ID_CMS.manageOrderAcceptFlowTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_CMS.Pages.ManageOrders;
import com.ID_CMS.utilities.BaseClass;

public class TC005_AcceptOrder extends BaseClass{
	
	static By order_status= By.xpath("//td[normalize-space()='Accepted']");
	static By edit_button= By.xpath("//table[@class='table table-hover']/tbody/tr[2]/td[12]/a[1]");
	@Test
	
	 public static void TC005_AcceptOrder() throws InterruptedException, IOException {
		 
		
		ManageOrders.accept();
		//after order acceptance, verify success msg
		 WebElement acceptSuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::strong"));
			
			System.out.println( "accept msg is  --- "+acceptSuccessMsg.getText());
			
			if(acceptSuccessMsg.getText().equals("Success!")) {
				Assert.assertTrue(true);
				System.out.println("Order Accept passed");
			}
			else {
				captureScreen(driver,"TC005_AcceptOrder");
				Assert.assertTrue(false);
				System.out.println("Order Accept failed");
			}
			//after order acceptance, verify order tracker status
WebElement orderTracker=driver.findElement(By.xpath("//h6[normalize-space()='Order Accepted']"));
			
			System.out.println( "Order Tracker status is  --- "+orderTracker.getText());
			if(orderTracker.getText().equals("Order Accepted")) {
				Assert.assertTrue(true);
				System.out.println("Order Tracker status is Accepted");
			}
			else {
				captureScreen(driver,"TC005_AcceptOrder");
				Assert.assertTrue(false);
				System.out.println("Order Tracker status is failed");
			}
			
			//after order acceptance, verify order status in edit
			WebElement orderStatus_Edit=driver.findElement(By.xpath("//h6[normalize-space()='Accepted']"));
						
						System.out.println( "Order  status in edit is  --- "+orderStatus_Edit.getText());
						if(orderStatus_Edit.getText().equals("Accepted")) {
							Assert.assertTrue(true);
							System.out.println("Order  status in edit is Accepted");
						}
						else {
							captureScreen(driver,"TC005_AcceptOrder");
							Assert.assertTrue(false);
							System.out.println("Order  status in edit is failed");
						}
						
			ManageOrders.manageOrders();
			ManageOrders.fetchOrder();
			
			//ManageOrders.deliveryStatus();
			String orderStatus=driver.findElement(order_status).getText();
			System.out.println("order status is ---" + orderStatus);
		    logger.info("order status is ---" + orderStatus);
		  //after order acceptance, verify Accepted status on grid view
		    if(orderStatus.equals("Accepted")) {
				Assert.assertTrue(true);
				System.out.println("order status passed i.e Accepted");
			}
			else {
				captureScreen(driver,"TC005_AcceptOrder");
				Assert.assertTrue(false);
				System.out.println("order status failed i.e Pending");
			}
		  //  driver.findElement(edit_button).click(); 
	 }
}
