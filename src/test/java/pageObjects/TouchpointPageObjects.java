package pageObjects;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import baseClasses.browserInit;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TouchpointPageObjects extends browserInit {
	//static WebDriver driver = null;
	public static WebDriverWait wait = new WebDriverWait(driver, 8);
    private static WebElement element = null;
    public static WebElement shortCode_seledfct(WebDriver driver) throws InterruptedException{
       
        return element;
        }
    public static WebElement shortCode_select(WebDriver driver, String value) throws InterruptedException{
    	 element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Short Code')]/../input"));
         wait.until(ExpectedConditions.elementToBeClickable(element));
         element.click();
         Thread.sleep(2000);
         element = driver.findElement(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+value+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
        }
    public static WebElement keyword_input(WebDriver driver, String value) throws InterruptedException{
        element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Keyword')]/../input"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
        return element;
        }
    public static WebElement orderingLogic_select(WebDriver driver, String value) throws InterruptedException{
    	element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Ordering Logic')]/../input"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
        element = driver.findElement(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+value+"')]"));
       wait.until(ExpectedConditions.elementToBeClickable(element));
       element.click();
       return element;
        }
    public static WebElement orderingRule_select(WebDriver driver, String value) throws InterruptedException{
    	element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Ordering Rule')]/../input"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
        element = driver.findElement(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+value+"')]"));
       wait.until(ExpectedConditions.elementToBeClickable(element));
       element.click();
       return element;
        }
    public static WebElement refreshEvery_input(WebDriver driver, String value) throws InterruptedException{
    	 element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Refresh Every')]/../input"));
         wait.until(ExpectedConditions.elementToBeClickable(element));
         element.sendKeys(value);
         return element;    	
    }
    public static WebElement timeInterval_select(WebDriver driver, String value) throws InterruptedException{
    	element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Time Interval')]/../input"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
       element = driver.findElement(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+value+"')]"));
       wait.until(ExpectedConditions.elementToBeClickable(element));
       element.click();
       return element;
        }
    public static WebElement maximumOffers_input(WebDriver driver, String value) throws InterruptedException{
   	 element = driver.findElement(By.xpath("//form[@id='smsForm']//label[contains(.,'Maximum offers')]/../input"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
        return element;    	
   }
    public static WebElement smsTouchpointSave_click(WebDriver driver) throws InterruptedException{
      	 element = driver.findElement(By.xpath(".//*[@id='smsForm']//paper-button[contains(.,'Save')]"));
           wait.until(ExpectedConditions.elementToBeClickable(element));
           element.click();
           return element;    	
      }
}
