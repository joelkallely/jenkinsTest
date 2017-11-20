package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class browserInit{
	
	public static WebDriver driver;

	public static void init(){
	
	System.setProperty("webdriver.chrome.driver", "browser_files\\chromedriver1.exe");
	driver =  new ChromeDriver();
	driver.manage().window().maximize();  
	}
	public static void initGecko(){
		
		//driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
		System.setProperty("webdriver.chrome.driver", "browser_files\\chromedriver1.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();  
		}
	
}
