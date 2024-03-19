package com.ID_CMS.manageOrderDeclineFlowTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_CMS.Pages.LanguageSelection;
import com.ID_CMS.Pages.ManageOrders;
import com.ID_CMS.utilities.BaseClass;

public class TC005_DeclineOrder extends BaseClass{
	static By order_status= By.xpath("//td[contains(text(),'Declined')]");
	static By pro_status= By.xpath("//td[contains(text(),'Undelivered')]");
	static By ser_status= By.xpath("//td[contains(text(),'Unfulfilled')]");
	@Test
	
	 public static void TC005_DeclineOrder() throws InterruptedException, IOException {

		//String reason =ManageOrders.decline();

	 
		 ManageOrders.decline();
		 WebElement declineSuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::strong"));
			
			System.out.println( "decline msg is  --- "+declineSuccessMsg.getText());
			
			if(declineSuccessMsg.getText().equals("Success!")) {
				Assert.assertTrue(true);
				System.out.println("Order Decline passed");
			}
			else {
				captureScreen(driver,"TC005_DeclineOrder");
				Assert.assertTrue(false);
				System.out.println("Order Decline failed");
			}
			
			//after order declined, verify order tracker status
			WebElement orderTracker=driver.findElement(By.xpath("//h6[normalize-space()='Order Declined']"));
						
						System.out.println( "Order Tracker status is  --- "+orderTracker.getText());
						if(orderTracker.getText().equals("Order Declined")) {
							Assert.assertTrue(true);
							System.out.println("Order Tracker status is Order Declined");
						}
						else {
							captureScreen(driver,"TC005_DeclineOrder");
							Assert.assertTrue(false);
							System.out.println("Order Tracker status is failed");
						}
			
			//after order declined, verify order status in edit
			WebElement orderStatus_Edit=driver.findElement(By.xpath("//h6[normalize-space()='Declined']"));
						
						System.out.println( "Order  status in edit is  --- "+orderStatus_Edit.getText());
						if(orderStatus_Edit.getText().equals("Declined")) {
							Assert.assertTrue(true);
							System.out.println("Order  status in edit is Declined");
						}
						else {
							captureScreen(driver,"TC005_DeclineOrder");
							Assert.assertTrue(false);
							System.out.println("Order  status in edit is failed");
						}
			ManageOrders.manageOrders();
			ManageOrders.fetchOrder();
			//ManageOrders.deliveryStatus();
			String orderStatus=driver.findElement(order_status).getText();
			System.out.println("order status is ---" + orderStatus);
		    logger.info("order status is ---" + orderStatus);
			
		    
//		    if(reason.contains(orderStatus))
//		    {
//		    	Assert.assertTrue(true);
//		    	System.out.println("reason is passed");
//				logger.info("reason is passed");
//		    }
//		    else {
//				Assert.assertTrue(false);
//				System.out.println("reason is failed");
//				logger.info("reason is failed");
//			}
		    
		    
		    if(orderStatus.contains("Declined")) {
				Assert.assertTrue(true);
				System.out.println("order status passed i.e Declined");
				logger.info("order status passed i.e Declined");
			}
			else {
				captureScreen(driver,"TC005_DeclineOrder");
				Assert.assertTrue(false);
				System.out.println("order status failed i.e Pending");
				logger.info("order status failed i.e Pending");
			}
		    
		    String proDevStatus=driver.findElement(pro_status).getText();
			System.out.println("product delivery status is ---" + proDevStatus);
		    logger.info("product delivery status is ---" + proDevStatus);
			
		    if(proDevStatus.contains("Undelivered")) {
				Assert.assertTrue(true);
				System.out.println("product delivery status passed i.e Undelivered");
				logger.info("product delivery status passed i.e Undelivered");
			}
			else {
				captureScreen(driver,"TC005_DeclineOrder");
				Assert.assertTrue(false);
				System.out.println("product delivery status failed i.e Delivered");
				logger.info("product delivery status failed i.e Delivered");
			}
		    
		    String serDevStatus=driver.findElement(ser_status).getText();
			System.out.println("service delivery status is ---" + serDevStatus);
		    logger.info("service delivery status is ---" + serDevStatus);
			
		    if(serDevStatus.equals("Unfulfilled")) {
				Assert.assertTrue(true);
				System.out.println("service delivery status passed i.e Unfulfilled");
				logger.info("service delivery status passed i.e Unfulfilled");
			}
			else {
				captureScreen(driver,"TC005_DeclineOrder");
				System.out.println("service delivery status failed i.e Fulfilled");
				logger.info("service delivery status failed i.e Fulfilled");
				Assert.assertTrue(false);
			}
	 }

}
