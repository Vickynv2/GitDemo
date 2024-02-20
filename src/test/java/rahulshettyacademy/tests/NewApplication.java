package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.BaseComponent.BaseTest;
import rahulshettyacademy.pageObjects.CheckOutPage;
import rahulshettyacademy.pageObjects.ConfirmationMagPage;
import rahulshettyacademy.pageObjects.LogInPage;
import rahulshettyacademy.pageObjects.PlaceOrderPage;
import rahulshettyacademy.pageObjects.ProductCatalogue;

public class NewApplication extends BaseTest{
	    
	   // String productName="ZARA COAT 3";

		@Test(dataProvider="getData",groups= {"Purchage"})
		public void submitOrder(HashMap<String ,String> input) throws IOException 
		{
		
		ProductCatalogue productCatalogue=loginPage.logInActions(input.get("email"),input.get("password"));
		List<WebElement> products=productCatalogue.getProductList();
		CheckOutPage checkOutPage=productCatalogue.addToCart(input.get("productName"));
		boolean actualItem = checkOutPage.assertingItem(input.get("productName"));
		Assert.assertTrue(actualItem);
		PlaceOrderPage placeOrder=checkOutPage.checkOutButton();
		ConfirmationMagPage confirmPG=placeOrder.placeOrderConfirm();
		String msg=confirmPG.getConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
		
		
		@DataProvider
		public Object[][] getData()
		{
			HashMap <String , String>map=new HashMap<String , String>();
			map.put("email", "vicky123@gmail.com");
			map.put("password", "Ramana@143");
			map.put("productName", "ZARA COAT 3");
			
			HashMap map1=new HashMap();
			map1.put("email", "ram143@gmail.com");
			map1.put("password", "Ramana@111");
			map1.put("productName", "ADIDAS ORIGINAL");
			return new Object[][] {{map},{map1}};
					
		}
		
		/*@DataProvider
		public Object[][] getData()
		{
			return new Object[][] {{"vicky123@gmail.com","Ramana@143","ZARA COAT 3"}, {"ram143@gmail.com","Ramana@111","ADIDAS ORIGINAL"}};
		}*/
	

}



