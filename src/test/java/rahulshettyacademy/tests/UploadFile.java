package rahulshettyacademy.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		String projectPath=System.getProperty("user.dir");
		//driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\Ramana\\Pictures\\2021-05\\FB_IMG_16214995218339964.jpg");
		driver.findElement(By.id("uploadfile")).sendKeys(projectPath+"\\Files\\FB_IMG_16214995218339964.jpg");
	}

}
