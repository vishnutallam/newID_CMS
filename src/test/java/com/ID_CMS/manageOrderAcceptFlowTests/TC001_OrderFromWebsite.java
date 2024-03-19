package com.ID_CMS.manageOrderAcceptFlowTests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_OrderFromWebsite {
	public static WebDriver driver;
	@Test(priority = 1)
	
	public void setup() throws InterruptedException {
		
    	
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.navigate().to("https://test.lorealsalonshop.co.id/public/index/59888");
		
		driver.manage().window().maximize();
		System.out.println("Application Opened");
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		
		
		
    	WebElement toggle= driver.findElement(By.xpath("//div[@class='switch-field']//label[@for='radio-two']"));// change to EN
//    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
//       wait.until(ExpectedConditions. elementToBeClickable(toggle));
    	Thread.sleep(3000);
    	toggle.click();
    	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("Before getting text of exploreBrand");
		WebElement exploreBrand = driver.findElement(By.xpath("//h3[contains(text(),'Explore our professional brands')]"));
		System.out.println("exploreBrand Element Identified");
		js.executeScript("arguments[0].scrollIntoView();", exploreBrand);
		System.out.println("Scrolled into the exploreBrand Element");

		System.out.println(exploreBrand.getText());
	

		String ActResult = exploreBrand.getText();
		String ExpResult = "Explore our professional brands";

		if (ExpResult.equals(ActResult)) {
			Assert.assertTrue(true);
			System.out.println("Language changed");

		} else {
			

			System.out.println("Language not changed");
			Assert.assertTrue(false);
		}
	

	

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@href='https://test.lorealsalonshop.co.id/brands/Mg== ']//img")).click();// loreal
		System.out.println("loreal Brand selected");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;

 
    	System.out.println("Before clicking exp_our_range");
    	WebElement exp_our_range=driver.findElement(By.xpath("//h4[contains(text(),'EXPLORE OUR RANGE')]/parent::a"));
    	System.out.println("exp_our_range Element Identified");
    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", exp_our_range);
    	System.out.println("Scrolled into the exp_our_range Element");
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    	//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
    	
    	//wait.until(ExpectedConditions. elementToBeClickable(exp_our_range));
    	Thread.sleep(3000);
    	exp_our_range.click();
    	System.out.println("Clicked on exp_our_range");
		
    	
		WebElement product=driver.findElement(By.xpath("//div[@class='product-itm product-0']//a[1]"));
		
	product.click();
	
	WebElement productName=driver.findElement(By.xpath("//div[@class='w-100']//h1"));
	System.out.println("product name "+productName.getText());
	
	WebElement product_price_size=driver.findElement(By.xpath("//div[@class='w-100']//h5"));
	System.out.println("product price and size "+product_price_size.getText());
	
	driver.findElement(By.xpath("//div[@class='w-100']//button")).click();
	System.out.println("Product added to wishlist");
	
	driver.findElement(By.xpath("//img[@id='cart_heart_img']")).click();
	System.out.println("Clicked on Wishlist");
	
	driver.findElement(By.xpath("//div[@class='quantity']/button[2]")).click();
	System.out.println("Increased quantity");
	

	driver.findElement(By.xpath("//ul[@class='navbar-nav ml-auto']/li[4]/a")).click();// Click on services 
	System.out.println("Redirects to service page");
	
	js.executeScript("window.scrollTo(0,311)");
	WebElement SubService=driver.findElement(By.xpath("//div[@class='row']/div[1]/a[1]/img"));// Click on sub services
	SubService.click();
	System.out.println("Redirects to sub service page");

	WebElement subServiceName=driver.findElement(By.xpath("//div[@class='w-100']//h1"));
	System.out.println("sub service name "+subServiceName.getText());
	
	WebElement subService_price=driver.findElement(By.xpath("//div[@class='w-100']//h5"));
	System.out.println("sub service price "+subService_price.getText());
	
	WebElement subService_duration=driver.findElement(By.xpath("//div[@class='w-100']/div[1]//h5"));
	System.out.println("sub service duration "+subService_duration.getText());
	
	driver.findElement(By.xpath("//div[@class='w-100']//button")).click();
	System.out.println("Subservice added to wishlist");
	
	driver.findElement(By.xpath("//img[@id='cart_heart_img']")).click();
	System.out.println("Clicked on Wishlist");
	
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	WebElement Next=driver.findElement(By.xpath("//a[contains(text(),'NEXT')]"));//next button
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", Next);
	//wait.until(ExpectedConditions. elementToBeClickable(Next));
	Thread.sleep(3000);
	Next.click();
	
	//Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	
	driver.findElement(By.xpath("//input[@id='customer_mobile']")).sendKeys("6280000000");
	System.out.println("Provided mobile num");
	driver.findElement(By.xpath("//button[contains(text(),'Send verification code')]")).click();
	
	//Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	
	driver.findElement(By.xpath("//input[@id='otp'][@type='text']")).sendKeys("9999");
	System.out.println("Provided otp");
	driver.findElement(By.xpath("//button[@id='verifyBtn']")).click();
	
	//Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	
	WebElement name=driver.findElement(By.xpath("//input[@id='customer_fname']"));
	name.clear();
	name.sendKeys("testab");
	System.out.println("name provided");
	
	WebElement email=driver.findElement(By.xpath("//input[@id='customer_email']"));
	email.clear();
	email.sendKeys("testab@gmail.com");
	System.out.println("email provided");
	
	
	WebElement city=driver.findElement(By.xpath("//input[@id='customer_city_name']"));
	city.clear();
	city.sendKeys("Chennai");
	System.out.println("city provided");
	
	WebElement pincode=driver.findElement(By.xpath("//input[@id='customer_pincode']"));
	pincode.clear();
	pincode.sendKeys("12345");
	System.out.println("pincode provided");
	
	//Thread.sleep(3000);
	Select st=new Select(driver.findElement(By.xpath("//select[@id='lang_spec']")));
	st.selectByVisibleText("EN");
	System.out.println("language changes to EN");
	//Thread.sleep(3000);
	
	System.out.println("watsapp_check Before clicking");
	WebElement watsapp_check=driver.findElement(By.xpath("//input[@id='m_o_c1']"));
	System.out.println(" watsapp_check Element Identified");
	js.executeScript("arguments[0].scrollIntoView();", watsapp_check);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	System.out.println("Scrolled into the watsapp_check Element");

	
	if(watsapp_check.isSelected()==false) {
		
		
		//wait.until(ExpectedConditions. elementToBeClickable(watsapp_check));

		watsapp_check.click();
	System.out.println("watsapp selected");
	}
	
	
	System.out.println(" I_agree_to Before clicking");
	WebElement I_agree_to=driver.findElement(By.xpath("//div[@class='row']/div[12]/label/input"));
	System.out.println(" I_agree Element Identified");
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", I_agree_to);
	System.out.println("Scrolled into the I_agree_to_checkbox");
	
	
	
	if(I_agree_to.isSelected()==false) {
		//
		System.out.println("I_agree_to is not selected, then check");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		I_agree_to.click();
	System.out.println("I_agree_to selected");
	
	}
	
	System.out.println("Before checkout completed");
	WebElement next_button=driver.findElement(By.xpath("//button[@id='btnCheckout'][@type='submit']"));
	js.executeScript("arguments[0].scrollIntoView({block:'center'});",next_button);
	next_button.click();
	System.out.println("checkout completed");
	
	
	System.out.println("Before ratings and reviews");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

	WebElement ratingElement=driver.findElement(By.xpath("//div[@class='rating']//a[contains(text(),'4')]"));
	System.out.println("Element rating Identified");
	
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", ratingElement);
	System.out.println("Scrolled into the rating Element");
	
	Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

	ratingElement.click();
	System.out.println("provided rating");
	
	

	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("autest");
	System.out.println("provided comments");
	
	WebElement submit=driver.findElement(By.xpath("//div[@id='feedbackform']/form/div/button"));
	
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", submit);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	Thread.sleep(3000);
    submit.click();
	System.out.println("submitted ratings and reviews");
	
	
	js.executeScript("window.scrollTo(0, 0)");

}
	
    
	

	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
