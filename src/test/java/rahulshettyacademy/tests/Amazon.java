package rahulshettyacademy.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;


public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=676742245123&hvpos=&hvnetw=g&hvrand=7680205239713144477&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302242&hvtargid=kwd-10573980&hydadcr=14453_2367553");
	
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("men shoes");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//int totalCount = 
				apply(driver);
		//System.out.println(totalCount);
		
		
	}
	private static void apply(WebDriver driver) throws InterruptedException
	{
		//int count =0;
		while(true)
		{
			int count = driver.findElements(By.tagName("img")).size();
			System.out.println(count);
				//WebElement disabledBtn = driver.findElement(By.xpath("//span[@class='s-pagination-item s-pagination-next s-pagination-disabled ']"));
				
				WebElement nextButton=driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
				Thread.sleep(7000);
				if(nextButton.getAttribute("class").contains("s-pagination-item s-pagination-next s-pagination-disabled "))
				{
					
				   break;
					
				}
				
				nextButton.click();
			
		}
		//return count;
		
	}

}
