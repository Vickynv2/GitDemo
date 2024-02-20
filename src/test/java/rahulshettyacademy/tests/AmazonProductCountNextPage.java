package rahulshettyacademy.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductCountNextPage {

    public static void main(String[] args) {
        // Set the path to chromedriver
        

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Amazon
        driver.get("https://www.amazon.com");

        // Search for a product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("men shoes"); // Replace "your product name" with the actual product name
        searchBox.submit();

        // Wait for search results to load
        try {
            Thread.sleep(5000); // Adjust the wait time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Count products on the first page
        int numResults = countProductsOnPage(driver);

        // Print the number of products available on the first page
        System.out.println("Number of products available on the first page: " + numResults);

        // Click the "Next" button to navigate to the next page of results
        WebElement nextButton = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
        nextButton.click();

        // Wait for the next page of search results to load
        try {
            Thread.sleep(5000); // Adjust the wait time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Count products on the next page
        numResults = countProductsOnPage(driver);

        // Print the number of products available on the next page
        System.out.println("Number of products available on the next page: " + numResults);

        // Close the browser
        driver.quit();
    }

    // Method to count the number of products on the current page
    public static int countProductsOnPage(WebDriver driver) {
        // Retrieve the search results
        WebElement searchResultsContainer = driver.findElement(By.cssSelector(".s-result-list"));
        return searchResultsContainer.findElements(By.cssSelector(".s-result-item")).size();
    }
}