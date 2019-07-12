package GridTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class TestBase {
 
    protected static ThreadLocal driver = new ThreadLocal<>();
 
    public WebDriver getDriver() {
        return (WebDriver) driver.get();
    }
 
    public MutableCapabilities capabilities;
 
    @Parameterized.Parameters
    public static MutableCapabilities[] getBrowserCapabilities() {
        return new MutableCapabilities[]{
                new ChromeOptions(),
                new FirefoxOptions()
        };
    }
 
    public TestBase(MutableCapabilities capabilities) {
        this.capabilities = capabilities;
    }
 
    @BeforeMethod
	public void setUp() throws Exception {
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.set(webDriver);
    }
 
    @AfterMethod
	public void tearDown() {
        getDriver().quit();
    }
 
    @AfterClass
    public static void remove() {
        driver.remove();
    }
 
}