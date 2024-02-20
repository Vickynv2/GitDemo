package rahulshettyacademy.BaseComponent;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.pageObjects.LogInPage;


public class BaseTest {
	
		public WebDriver driver;
		public LogInPage loginPage;

		public WebDriver initializeDriver() throws IOException
		{
			Properties prop=new Properties();
			FileInputStream fis=new FileInputStream("C:/Users/Ramana/Desktop/eclipse-workspace/seleniumFrameworkDesign/src/main/java/rahulshettyacademy/Resources/GlobalData.properties");
			prop.load(fis);
			String browserName=prop.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("chrome"))
			{
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(options);
				driver.manage().deleteAllCookies();
			}
			else if(browserName.equalsIgnoreCase("fireFox"))
			{
				// Firefox
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			return driver;
		}
		
		public String getScreenshot(String testCaseName , WebDriver driver) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName +".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
			
			
		}
		
		
		
		
		
		
		@BeforeMethod
		public LogInPage launchApplication() throws IOException
		{
			driver=initializeDriver();
		    loginPage=new LogInPage(driver);
			loginPage.URL();
			return loginPage;	
		}
		@AfterMethod
		public void closing()
		{
			driver.close();
		}
		
	
}
