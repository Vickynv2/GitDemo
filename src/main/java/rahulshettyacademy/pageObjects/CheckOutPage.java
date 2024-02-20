package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> orderItems;
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkOutBtn;
	
	public Boolean assertingItem(String productName)
	{
		Boolean actualItem=orderItems.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
		return actualItem;
	}
	public PlaceOrderPage checkOutButton()
	{
		checkOutBtn.click();
		PlaceOrderPage placeOrder=new PlaceOrderPage(driver);
		return placeOrder;
	}
	
	
}







