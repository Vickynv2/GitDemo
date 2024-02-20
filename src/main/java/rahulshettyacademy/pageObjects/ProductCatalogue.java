package rahulshettyacademy.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement disAppearEle;
	
	
	By productBy=By.cssSelector(".mb-3");
	By addToCardBtn=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.id("toast-container");
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProduct(String productName)
	{
		WebElement product=getProductList().stream().filter(prod->prod.findElement(By.cssSelector(".card-body b")).getText().equals(productName)).findFirst().orElse(null);
		return product;
	}
	public CheckOutPage addToCart(String productName)
	{
		WebElement product=getProduct(productName);
		product.findElement(addToCardBtn).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(disAppearEle);
		goToCartPage();
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
	
	
	
	
	
	
	
	
	
	
}
