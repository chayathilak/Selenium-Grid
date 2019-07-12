package GridTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends TestBase {
 
    public GoogleSearchTest(){
        super(new ChromeOptions());
    }
 
    @Test
    public void openGoogle() {
        WebDriver webDriver = getDriver();
        webDriver.navigate().to("http://www.google.com");
        Assert.assertEquals("Google", webDriver.getTitle());
    }
 
    @Test
    public void enterGoogleSearchAndViewResults() {
        WebDriver webDriver = getDriver();
        By searchLocator = By.cssSelector("input[value='Google Search']");
        webDriver.navigate().to("http://www.google.com");
        WebElement searchText = webDriver.findElement(By.cssSelector("input[title=Search]"));
        searchText.sendKeys("hi");
        WebElement searchButton = webDriver.findElement(searchLocator);
        searchButton.click();
        Assert.assertEquals("hi - Google Search", webDriver.getTitle());
    }
 
    @Test
    public void enterGoogleSearchAndImageSearch() {
        WebDriver webDriver = getDriver();
        By searchLocator = By.cssSelector("input[value='Google Search']");
        webDriver.navigate().to("http://www.google.com");
        WebElement searchText = webDriver.findElement(By.cssSelector("input[title=Search]"));
        searchText.sendKeys("hi");
        WebElement searchButton = webDriver.findElement(searchLocator);
        searchButton.click();
        WebElement imageSearch = webDriver.findElement(By.xpath("//a[contains(text(), 'Images')]"));
        imageSearch.click();
    }
 
 
}