package pageObjects;
import org.openqa.selenium.*;


import org.openqa.selenium.WebDriver;
import baseClasses.browserInit;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
class FbLoginPage {
 
	WebDriver driver;
 
        
}
public class TouchpointPageObjects extends browserInit {
	//static WebDriver driver = null;
	public static WebDriverWait wait = new WebDriverWait(driver, 8);
    private static WebElement element = null;
    
  //Element Locators
    By createButton = By.xpath("//paper-button[contains(.,'Create Program')]");
    By smsFormShortCodeSelector = By.xpath("//form[@id='smsForm']//label[contains(.,'Short Code')]/../input");
    By keyword_input = By.xpath("//form[@id='smsForm']//label[contains(.,'Keyword')]/../input");
    By sms_ordering_logic_selector = By.xpath("//form[@id='smsForm']//label[contains(.,'Ordering Logic')]/../input");
    By sms_ordering_rule_selector = By.xpath("//form[@id='smsForm']//label[contains(.,'Ordering Rule')]/../input");
    
  //****************************************************************************************************************
  //****************************************************************************************************************
  //Element Functions
    public void clickCreateProgramButton(){		//click create program button
    	wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }
    public void selectShortCode(String short_code_value) throws InterruptedException {		//select short code
    	wait.until(ExpectedConditions.elementToBeClickable(smsFormShortCodeSelector)).click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+short_code_value+"')]"))).click();
    }
    public void enter_keyword_input(String sms_keyword) {
    	wait.until(ExpectedConditions.elementToBeClickable(keyword_input)).sendKeys(sms_keyword);
    }
    public void select_sms_ordering_logic(String ordering_logic) throws InterruptedException {
    	wait.until(ExpectedConditions.elementToBeClickable(sms_ordering_logic_selector)).click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+ordering_logic+"')]"))).click();
    }
    public void select_sms_ordering_rule(String ordering_rule) throws InterruptedException {
    	wait.until(ExpectedConditions.elementToBeClickable(sms_ordering_logic_selector)).click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'"+ordering_rule+"')]"))).click();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    


    public static WebElement orderingRule_select(WebDriver driver, String value) throws InterruptedException{
    	element = driver.findElement(By.xpath(""));
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
