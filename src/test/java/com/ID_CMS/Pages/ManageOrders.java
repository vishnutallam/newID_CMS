package com.ID_CMS.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ID_CMS.utilities.BaseClass;
import com.ID_CMS.utilities.ReadConfig;

public class ManageOrders extends BaseClass {
	//static ReadConfig readconfig=new ReadConfig();
	
	static By mng_orders_button= By.xpath("(//span[normalize-space()='Manage Orders'])");
	static By sal_name_text= By.xpath("//table[@class='table table-hover']/tbody/tr[2]/td[1]");
	static By order_num_text= By.xpath("//table[@class='table table-hover']/tbody/tr[2]/td[2]");
	static By edit_button= By.xpath("//table[@class='table table-hover']/tbody/tr[2]/td[12]/a[1]");
	static By updt_add_button= By.xpath("//button[@id='updt_addr_primary_btn']");
	static By updt_add_title= By.xpath("(//h5[normalize-space()='Update Customer Address Details:'])[1]");
	static By address_field= By.xpath("(//textarea[@id='customer_address1'])");
	static By state_field= By.xpath("//label[@for='customer_state']/following-sibling::select");
	static By city_field= By.xpath("(//input[@id='customer_city_name'])");
	static By pincode_field= By.xpath("(//input[@id='customer_pincode'])");
	static By updateAdd_button= By.xpath("(//button[@type='submit'][normalize-space()='Update Address'])");
	static By order_num= By.xpath("//table[@class='table table-hover']/tbody/tr[2]/td[2]");
	static By search_Onum= By.xpath("//input[@id='search_text']");
	static By search_button= By.xpath("//button[@id='btnSearch']");
	
	
	//public static String oStatus=readconfig.getorderstatus();
	//static By OrderSt= By.xpath("//label[normalize-space()='"+oStatus+"']/input");
	static By acc_radioButton= By.xpath("//label[normalize-space()='Accept']/input");
	static By decl_radioButton= By.xpath("//label[normalize-space()='Decline']/input");
	static By updateOrder_Button= By.xpath("//button[@id='values_chng']");
	static By delivery_status= By.xpath("//td[contains(text(),'Undelivered')]");
	static By reason_Decline= By.xpath("//label[@for='order_reject_remark']/following-sibling::select");
	static By newpro_dd= By.xpath("//form[@id='main_form2']//div[@class='selectize-input items not-full has-options']");
	
	static By newpro_ddvalue= By.xpath("//form[@id='main_form2']//div[@class='selectize-input items not-full has-options']/following-sibling::div/div[1]/div[1]");
	
	static By newpro_addbutton= By.xpath("//form[@id='main_form2']/descendant::button[@type='submit'][normalize-space()='Add']");
	
	static By serff_rd= By.xpath("//input[@id='serice_delivery_status1']");
	
	static By updateOrder_buttonff= By.xpath("//button[@id='btnSer']");
	static By prodel_rd= By.xpath("//input[@id='delivery_status2']");
	static By updateOrder_buttonDel= By.xpath("//button[@id='btnProd']");
	

	private static String orderNumber; 
	
	public static void manageOrders() throws InterruptedException
	{
	WebElement ManageOrders=driver.findElement(mng_orders_button);
	logger.info("Text of manage orders is "+ManageOrders.getText());
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
	wait.until(ExpectedConditions.elementToBeClickable(ManageOrders));
	ManageOrders.click();//Manage orders
	
	

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
	}
	
	
//	public static String getOrderNum() throws InterruptedException {
//      if (orderNumber == null) { // Check if orderNumber is not already obtained
//          WebElement getOrderNum = driver.findElement(order_num);
//          orderNumber = getOrderNum.getText();
//          System.out.println("Order number is ---" + orderNumber);
//          logger.info("Order number is ---" + orderNumber);
//      }
//      return orderNumber;
//  }
		
	public static String edit() throws InterruptedException
	{
		if (orderNumber == null) { 
		WebElement salonName=driver.findElement(sal_name_text);
		logger.info("salon name is "+salonName.getText());
		
		WebElement getOrderNum = driver.findElement(order_num);
      orderNumber = getOrderNum.getText();
      System.out.println("Order number is ---" + orderNumber);
      logger.info("Order number is ---" + orderNumber);
//		WebElement Ordernum=driver.findElement(order_num_text);
//		String orderNumber=Ordernum.getText();
//		logger.info("order number is "+orderNumber);
		driver.findElement(edit_button).click();//Edit order	
		}
		
		 return orderNumber;
	}
	
	
//	public static void editAfterSearch() {
//		WebElement salonName=driver.findElement(sal_name_text);
//		logger.info("salon name is "+salonName.getText());
//		
//		WebElement getOrderNum = driver.findElement(order_num);
//      orderNumber = getOrderNum.getText();
//      System.out.println("Order number is ---" + orderNumber);
//      logger.info("Order number is ---" + orderNumber);
//
//		driver.findElement(edit_button).click();//Edit order
//		
//	}

	
	public static void updateAddress() throws InterruptedException
	{

		 driver.findElement(updt_add_button).click();
//		 
//		 WebElement UpdateAddTitle=driver.findElement(updt_add_title);
//	
//		logger.info(UpdateAddTitle.getText());
//		
//		if(UpdateAddTitle.getText().equals("Update Customer Address Details:")) {
//			Assert.assertTrue(true);
//			logger.info("Navigated to Update Address page");
//		}
//		else {
//			Assert.assertTrue(false);
//			logger.info("FAILED to navigate to Address page");
//		}
//		
		
		WebElement address=driver.findElement(address_field);
		address.clear();
		address.sendKeys("Mumbai");
		logger.info("Entered Address");
		
		Select st=new Select(driver.findElement(state_field));
	//    st.selectByValue("2");
		st.selectByIndex(4);
		//st.selectByVisibleText("BALI");		
		logger.info("Selected state");
		

		WebElement city=driver.findElement(city_field);
		city.clear();
		city.sendKeys("Agripada");
		logger.info("Entered City");
		
		WebElement pincode=driver.findElement(pincode_field);
		pincode.clear();
		pincode.sendKeys("40011");
		logger.info("Entered Pincode");
		
		WebElement updateAdd=driver.findElement(updateAdd_button);
		updateAdd.click();
		logger.info("Clicked on update address button");
		
	}
	
//	public static String getOrderNum() throws InterruptedException {
//        if (orderNumber == null) { // Check if orderNumber is not already obtained
//            WebElement getOrderNum = driver.findElement(order_num);
//            orderNumber = getOrderNum.getText();
//            System.out.println("Order number is ---" + orderNumber);
//            logger.info("Order number is ---" + orderNumber);
//        }
//        return orderNumber;
//    }

    public static void fetchOrder() throws InterruptedException {
        String ordernum = edit(); // Getting the order number from edit() method
        
        System.out.println("fetching with stored order number  ---" + ordernum);
        logger.info("fetching with stored order number  ---" + ordernum);
        //Thread.sleep(3000);
        WebElement search_ordernum = driver.findElement(search_Onum);
        search_ordernum.sendKeys(ordernum);
        driver.findElement(search_button).click();
    }
    
    
    public static void editAfterSearch() throws InterruptedException {
		// TODO Auto-generated method stub
String ordernum = edit();
    	
//		WebElement salonName=driver.findElement(sal_name_text);
//		logger.info("salon name is "+salonName.getText());
		
		WebElement getOrderNum = driver.findElement(order_num);
      orderNumber = getOrderNum.getText();
      System.out.println("Order number is ---" + orderNumber);
      logger.info("Order number is ---" + orderNumber);
      if(orderNumber.equals(ordernum)) {

		driver.findElement(edit_button).click();//Edit order
      }
      else {
    	  System.out.println("Unabble to edit after searching with order num");
      }
	}

//    public static void editAfterSearch() throws InterruptedException {
//    	
//    	String ordernum = edit();
//    	
////		WebElement salonName=driver.findElement(sal_name_text);
////		logger.info("salon name is "+salonName.getText());
//		
//		WebElement getOrderNum = driver.findElement(order_num);
//      orderNumber = getOrderNum.getText();
//      System.out.println("Order number is ---" + orderNumber);
//      logger.info("Order number is ---" + orderNumber);
//      if(orderNumber==ordernum) {
//
//		driver.findElement(edit_button).click();//Edit order
//      }
//      else {
//    	  System.out.println("Unabble to edit after searching with order num");
//      }
//	}
    
	public static void accept() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement accept=driver.findElement(acc_radioButton);
    	System.out.println("Accept radio button Element Identified");
		
		js.executeScript("arguments[0].scrollIntoView(true);", accept);
		accept.click();
		driver.findElement(updateOrder_Button).click();
		
		
		
	}
	public static void decline() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement decline=driver.findElement(decl_radioButton);
    	System.out.println("Decline radio button Element Identified");
		
		js.executeScript("arguments[0].scrollIntoView(true);", decline);
		decline.click();
		
		Select st=new Select(driver.findElement(reason_Decline));
	    st.selectByValue("4");
//		st.selectByIndex(2);
	    WebElement selectedReason = st.getFirstSelectedOption();
	    String Reason = selectedReason.getText();
	    logger.info("Declined status selected: " + Reason);
		
		driver.findElement(updateOrder_Button).click();
		//return Reason;
		
	}
	public static void addNewPro() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement newProdd=driver.findElement(newpro_dd);
		js.executeScript("arguments[0].scrollIntoView();", newProdd);
		driver.findElement(newpro_dd).click();
		
		System.out.println("clicked on add new product dropdown");
		driver.findElement(newpro_ddvalue).click();
		System.out.println("clicked on add new product value");
		driver.findElement(newpro_addbutton).click();
		
		
	}
	public static void serFullfilled() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement serff=driver.findElement(serff_rd);
		js.executeScript("arguments[0].scrollIntoView();", serff);
		driver.findElement(serff_rd).click();
		System.out.println("clicked on fullfilled radio button");
		
		driver.findElement(updateOrder_buttonff).click();
		System.out.println("clicked on update order button at fullfilled");
		
		
		
	}
	
	public static void proDelivered() throws InterruptedException
	{
		//driver.findElement(edit_button).click();//Edit order
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement proDel=driver.findElement(prodel_rd);
		js.executeScript("arguments[0].scrollIntoView();", proDel);
		driver.findElement(prodel_rd).click();
		System.out.println("clicked on Delivered radio button");
		
		driver.findElement(updateOrder_buttonDel).click();
		System.out.println("clicked on update order button at delivered");
		
		
		
	}


	

	


	
}
