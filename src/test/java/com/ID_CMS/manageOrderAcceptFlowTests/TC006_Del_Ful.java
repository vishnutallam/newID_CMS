package com.ID_CMS.manageOrderAcceptFlowTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_CMS.Pages.ManageOrders;
import com.ID_CMS.utilities.BaseClass;

public class TC006_Del_Ful extends BaseClass{
	static By order_status= By.xpath("//td[normalize-space()='Completed']");
	static By proDel_status= By.xpath("//td[contains(text(),'Delivered')]");
	static By serDel_status= By.xpath("//td[contains(text(),'Fulfilled')]");
//	static By order_status_pro= By.xpath("//td[normalize-space()='Accepted']");
//	static By order_status_ser= By.xpath("//td[normalize-space()='Accepted']");
	
	
	
	@Test
	
	 public static void TC006_Del_Ful() throws InterruptedException, IOException {
	//if stored order num and fetched order num both are same, edit the order	 
	ManageOrders.editAfterSearch();
	// update product status to delivered and check success msg
		ManageOrders.proDelivered();
		 WebElement DelSuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::strong"));
			
			System.out.println( "accept msg is  --- "+DelSuccessMsg.getText());
			
			if(DelSuccessMsg.getText().equals("Success!")) {
				Assert.assertTrue(true);
				System.out.println("Product delivered Passed");
			}
			else {
				captureScreen(driver,"TC006_Del_Ful");
				Assert.assertTrue(false);
				System.out.println("Product delivered failed");
			}
	// check the product delivery status on order tracker		
WebElement orderTrackerPro=driver.findElement(By.xpath("//h6[normalize-space()='Product Delivered']"));
			
			System.out.println( "Order Tracker status is  --- "+orderTrackerPro.getText());
			if(orderTrackerPro.getText().equals("Product Delivered")) {
				Assert.assertTrue(true);
				System.out.println("Order Tracker status has Delivered");
			}
			else {
				captureScreen(driver,"TC006_Del_Ful");
				Assert.assertTrue(false);
				System.out.println("Order Tracker status is failed");
			}
			
			//after order delivered, verify product delivery  status in edit
			WebElement orderStatus_Edit_pro=driver.findElement(By.xpath("//h6[normalize-space()='Delivered']"));
						
						System.out.println( "Order  status for product delivery in edit is  --- "+orderStatus_Edit_pro.getText());
						if(orderStatus_Edit_pro.getText().equals("Delivered")) {
							Assert.assertTrue(true);
							System.out.println("Order  status for product delivery in edit is Accepted");
						}
						else {
							captureScreen(driver,"TC006_Del_Ful");
							Assert.assertTrue(false);
							System.out.println("Order  status for product delivery in edit is failed");
						}
						
			// update service status to fulfilled and check success msg		
			ManageOrders.serFullfilled();
			 WebElement serSuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::strong"));
				
				System.out.println( "accept msg is  --- "+serSuccessMsg.getText());
				
				if(serSuccessMsg.getText().equals("Success!")) {
					Assert.assertTrue(true);
					System.out.println("Service Fulfilled Passed");
				}
				else {
					captureScreen(driver,"TC006_Del_Ful");
					Assert.assertTrue(false);
					System.out.println("Service Fulfilled failed");
				}
				
				//after order fulfilled, delivered, verify order status in edit is completed or not
				WebElement orderStatus_Edit_com=driver.findElement(By.xpath("//h6[normalize-space()='Completed']"));
							
							System.out.println( "Order  status in edit if both are successfully delivered & fulfilled --- "+orderStatus_Edit_com.getText());
							if(orderStatus_Edit_com.getText().equals("Completed")) {
								Assert.assertTrue(true);
								System.out.println("Order  status in edit is Completed");
							}
							else {
								captureScreen(driver,"TC006_Del_Ful");
								Assert.assertTrue(false);
								System.out.println("Order  status in edit is failed");
							}
							
				// check the service delivery status on order tracker	
				WebElement orderTrackerSer=driver.findElement(By.xpath("//h6[normalize-space()='Service Fulfilled']"));
				
				System.out.println( "Order Tracker status is  --- "+orderTrackerSer.getText());
				if(orderTrackerSer.getText().equals("Service Fulfilled")) {
					Assert.assertTrue(true);
					System.out.println("Order Tracker status has fulfilled");
				}
				else {
					captureScreen(driver,"TC006_Del_Ful");
					Assert.assertTrue(false);
					System.out.println("Order Tracker status is failed");
				}
				// check the completed status on order tracker
WebElement orderTrackerCom=driver.findElement(By.xpath("//h6[normalize-space()='Order Completed']"));
				
				System.out.println( "Order Tracker status is  --- "+orderTrackerCom.getText());
				if(orderTrackerCom.getText().equals("Order Completed")) {
					Assert.assertTrue(true);
					System.out.println("Order Tracker status has Completed");
				}
				else {
					captureScreen(driver,"TC006_Del_Ful");
					Assert.assertTrue(false);
					System.out.println("Order Tracker status is failed");
				}
				
				ManageOrders.manageOrders();
				ManageOrders.fetchOrder();
				//ManageOrders.deliveryStatus();
				String orderStatus=driver.findElement(order_status).getText();
				System.out.println("order status is ---" + orderStatus);
			    logger.info("order status is ---" + orderStatus);
			//after search with stored order num, check order status is complted or not after successfull product and service delivered	
			    if(orderStatus.equals("Completed")) {
					Assert.assertTrue(true);
					System.out.println("order status passed i.e Completed");
				}
				else {
					captureScreen(driver,"TC006_Del_Ful");
					Assert.assertTrue(false);
					System.out.println("order status failed i.e Accepted");
				}
			    
			    String proDelStatus=driver.findElement(proDel_status).getText();
				System.out.println("Product delivery status is ---" + proDelStatus);
			    logger.info("Product delivery status is ---" + proDelStatus);
				// check product delivery status changes to Delivered or not 
			    if(proDelStatus.equals("Delivered")) {
					Assert.assertTrue(true);
					System.out.println("Product delivery status passed i.e Delivered");
				}
				else {
					captureScreen(driver,"TC006_Del_Ful");
					Assert.assertTrue(false);
					System.out.println("Product delivery status failed i.e Undelivered");
				}
			    
			  
			    
			    String serDelStatus=driver.findElement(serDel_status).getText();
				System.out.println("Service delivery status is ---" + serDelStatus);
			    logger.info("Service delivery status is ---" + serDelStatus);
			    
			 // check service delivery status changes to Fulfilled or not 
			    if(serDelStatus.equals("Fulfilled")) {
					Assert.assertTrue(true);
					System.out.println("Service delivery status passed i.e Fulfilled");
				}
				else {
					captureScreen(driver,"TC006_Del_Ful");
					Assert.assertTrue(false);
					System.out.println("Service delivery status failed i.e Unfulfilled");
				}
	}

}
