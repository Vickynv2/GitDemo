package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LogInPage extends AbstractComponents {
	WebDriver driver;	
	public LogInPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submitButton;
	
	public ProductCatalogue logInActions(String eamilId,String password )
	{
		email.sendKeys(eamilId);
		passwordEle.sendKeys(password);
		submitButton.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void URL()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}








