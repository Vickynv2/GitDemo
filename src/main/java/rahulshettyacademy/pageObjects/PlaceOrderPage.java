package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class PlaceOrderPage extends AbstractComponents{
	WebDriver driver;
	public PlaceOrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy(css="[class='ta-item list-group-item ng-star-inserted']:last-of-type")
	WebElement clickCountry;
	@FindBy(css="a[class*='action__submit']")
	WebElement placeOrderBtn;
	
	
	public ConfirmationMagPage placeOrderConfirm()
	{
		selectCountry.sendKeys("india");
		clickCountry.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", placeOrderBtn);
		ConfirmationMagPage confirmPG=new ConfirmationMagPage(driver);
		return confirmPG;
	}
	
	
	
	
	
	
	
}
