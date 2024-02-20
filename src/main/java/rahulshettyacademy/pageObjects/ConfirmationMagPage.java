package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ConfirmationMagPage extends AbstractComponents {
	WebDriver driver;
	public ConfirmationMagPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="[class='hero-primary']")
	WebElement confirmMessage;
	
	public String getConfirmationMsg()
	{
		String msg=confirmMessage.getText();
		return msg;
	}
	
	
	
}
