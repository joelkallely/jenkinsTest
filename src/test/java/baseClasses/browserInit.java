package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browserInit{
	
	public static WebDriver driver;
	

	public static void init(){
	
	System.setProperty("webdriver.chrome.driver", "browser_files\\chromedriver1.exe");
	driver =  new ChromeDriver();
	driver.manage().window().maximize();  
	}
	public void loadClick(String xpath) throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, 8);
		 Thread.sleep(1000);
		 try{
		while(!driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style").contains("none")){
			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		while(!driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style").contains("none")){
			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
		 }
		 catch(Exception e){
			 while(!driver.findElement(By.xpath(".//*[@id='loading-mask']")).getAttribute("style").contains("hidden")||!driver.findElement(By.xpath(".//*[@id='loading']")).getAttribute("style").contains("hidden")){
					Thread.sleep(1000);
				}
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				while(!driver.findElement(By.xpath(".//*[@id='loading-mask']")).getAttribute("style").contains("hidden")||!driver.findElement(By.xpath(".//*[@id='loading']")).getAttribute("style").contains("hidden")){
					Thread.sleep(1000);
				}
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
		 }
}

public void loadSendKeys(String xpath, String key) throws InterruptedException{
	 WebDriverWait wait = new WebDriverWait(driver, 8);
	 Thread.sleep(1000);
	 try{
	while(!driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style").contains("none")){
		Thread.sleep(1000);
	}
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	while(!driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style").contains("none")){
		Thread.sleep(1000);
	}
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(key);	
	 }
	 catch(Exception e){
		 while(!driver.findElement(By.xpath(".//*[@id='loading-mask']")).getAttribute("style").contains("hidden")||!driver.findElement(By.xpath(".//*[@id='loading']")).getAttribute("style").contains("hidden")){
				Thread.sleep(1000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//					elementToBeClickable(By.xpath(xpath)));
			while(!driver.findElement(By.xpath(".//*[@id='loading-mask']")).getAttribute("style").contains("hidden")||!driver.findElement(By.xpath(".//*[@id='loading']")).getAttribute("style").contains("hidden")){
				Thread.sleep(1000);
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(key);	
	 }
}
public void waitUntil(String xpath) throws InterruptedException{
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	Thread.sleep(2000);
}
	public static void initGecko(){
		
		//driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
		System.setProperty("webdriver.chrome.driver", "browser_files\\chromedriver1.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();  
	}
	
}
