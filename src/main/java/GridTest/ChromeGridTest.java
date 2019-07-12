package GridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeGridTest {

	public static void main(String[] args) throws MalformedURLException {
			
		 
		//Define desired capabilities
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		//Chrome option  
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		options.setHeadless(true);
		
		//Hub URL
		String huburl ="http://localhost:4444/wd/hub";
		 
		// Create driver with hub address and capability
		WebDriver driver=new RemoteWebDriver(new URL(huburl), options);
		 
		//Test case
		driver.get("https://www.findmyfare.com/");
		 
		System.out.println("Title is "+driver.getTitle());
		 
		driver.close();


	}

}
