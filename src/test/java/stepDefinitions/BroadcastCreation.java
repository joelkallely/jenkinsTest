package stepDefinitions;
import baseClasses.SSH;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.internal.FindsByXPath;

import baseClasses.ExcelHelper;
import baseClasses.HttpResponseCode;
import baseClasses.browserInit;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BroadcastCreation extends browserInit{
	public static SSH ec = new SSH();
	public ExcelHelper eM = new ExcelHelper(); 
    public WebDriverWait wait = new WebDriverWait(driver, 8);
    public Actions actions = new Actions(driver);
    
    @Then("^Create New Offer Catalogue for product$")
    
    public void createNewOfferCatalogueForProduct() throws Throwable{
 	   
 	    eM.setExcelFile("inputData","singleProductPage");
 	    Random rn = new Random();
 		int  n = rn.nextInt(5000) + 1;
 		String name = (String) eM.getCell(1, 13);
 		name =  name.replaceAll("[0-9]", "")+n;
 		name= n+name;
 		eM.setCell(1, 13, name);
 	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Create New Catalog']"))).click();
 	   driver.findElement(By.xpath("//div[2]/paper-input[1]/paper-input-container/div[2]/div/input")).sendKeys(name);
 	   driver.findElement(By.xpath("//paper-input[2]/paper-input-container/div[2]/div/input")).sendKeys("test");
 	   driver.findElement(By.xpath("//div[3]/paper-button[2]")).click();
 	   Thread.sleep(3000);
 	   }
    @Then("^Add offer to Offer Catalogue for product$")
    public void addOffertoCatalogueForProduct() throws Throwable
    {
    	eM.setExcelFile("inputData","singleProductPage");
 	 Thread.sleep(2000);
 	 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
 	 Thread.sleep(2000);
 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input"))).sendKeys(eM.getCell(1, 12));
 	 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
 	Thread.sleep(2000);
 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[1]/data-table-cell[1][contains(.,'"+eM.getCell(1, 12)+"')]"))).click();
 	Thread.sleep(2000);
 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Add to Catalog']"))).click();
 	 Thread.sleep(5000);
    }
    @Then("^navigate to \"([^\"]*)\" category$")
    public void navigate_to_category(String category) throws Throwable
    {
    	Thread.sleep(2000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='scrollThreshold']/paper-card[1]/div[2]/div/a/div[contains(.,'"+category+"')]"))).click();
    }
    @Then("^create new campaign$")
    public void create_new_campaign() throws Throwable
    {
    	eM.setExcelFile("inputData","singleProductPage");
 	    Random rn = new Random();
 		int  n = rn.nextInt(5000) + 1;
 		String name = (String) eM.getCell(1, 14);
 		name =  name.replaceAll("[0-9]", "")+n;
 		name= n+name;
 		eM.setCell(1, 14, name);
    	Thread.sleep(2000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[8]/campaign-list/div/div/a/paper-button"))).click();
    	 Thread.sleep(1000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Type')]/../input"))).click();
    	 Thread.sleep(1000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']/div/paper-item[3]"))).click();
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath(".//campaign-details//label[contains(.,'Name')]/../input")).sendKeys(name);
    	 Thread.sleep(500);
    	 driver.findElement(By.xpath(".//*[@id='textarea']")).sendKeys("Campaign to check bc craetion in selenium");
    	 Thread.sleep(500);
    	 driver.findElement(By.xpath(".//campaign-details//label[contains(.,'Offer Catalog')]/../input")).sendKeys(eM.getCell(1, 13));
    	 Thread.sleep(1000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']/div/paper-item[contains(.,'"+eM.getCell(1, 13)+"')]"))).click();
    	 Thread.sleep(500);
    	 driver.findElement(By.xpath(".//*[@id='topBar']/paper-button[2]")).click();
    	 Thread.sleep(1000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[9]/campaign-form/wizard-tab/div/iron-pages/target-conditions/div/paper-icon-button"))).click();
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath(".//*[@id='conditionForm']/paper-dropdown-menu//paper-input-container/div[2]")).click();
    	 Thread.sleep(1000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWrapper']/div/paper-listbox/paper-item[contains(.,'Customer Insight')]"))).click();
    	 Thread.sleep(2000);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='conditionForm']/div//paper-input//label[contains(.,'Field')]/../.."))).click();
    	 Thread.sleep(700);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']/div/paper-item[contains(.,'Age')][1]"))).click();
    	 Thread.sleep(700);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='conditionForm']//field-simple//iron-dropdown/.."))).click();
    	 Thread.sleep(700);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWrapper']/div/paper-listbox/paper-item[contains(.,'is greater than')][1]"))).click();
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath(".//*[@id='conditionForm']//field-simple/div//paper-input//input")).sendKeys("18");
    	 Thread.sleep(700);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='conditionCard']/paper-button[2]"))).click();
    	 Thread.sleep(700);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[2]"))).click();
    	 Thread.sleep(700);
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[9]/campaign-form/wizard-tab/div/iron-pages/campaign-schedule/form/paper-card/paper-date-time-input/div/paper-input[2]/paper-input-container/div[2]"))).click();
    	 Thread.sleep(700);
    	 Calendar rightNow =Calendar.getInstance();
    	 int hours = rightNow.get(Calendar.HOUR);
    	 int min = rightNow.get(Calendar.MINUTE);
    	 int am_pm = rightNow.get(Calendar.AM_PM);
    	 int day = rightNow.get(Calendar.DAY_OF_MONTH);
    	 int year = rightNow.get(Calendar.YEAR);
    	 int month = rightNow.get(Calendar.MONTH)+1;
    	 min+=2;
    	 int rem = min%5;
    	 rem = 5-rem;
    	 min+=rem;
    	 if(min>59){
    		 min-=60;
    		 hours++;
    	 }
    	 Actions builder = new Actions(driver);
    	 WebElement num = driver.findElement(By.xpath(".//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
         builder.moveToElement(num).click().build().perform();
         Thread.sleep(2000);
    	 WebElement num1 = driver.findElement(By.xpath(".//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
         builder.moveToElement(num1).click().build().perform();
         if(am_pm==0)
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[1]"))).click();
         else
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[2]"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='timeDialog']/div/paper-button[2]"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[3]"))).click();
    	 Thread.sleep(2000);
    	
    }
    @Then("^create new \"([^\"]*)\" broadcast$")
    public void create_new_broadcast(String bc_type) throws Throwable
    {
    	eM.setExcelFile("inputData","singleProductPage");
    	Random rn = new Random();
 		int  n = rn.nextInt(5000) + 1;
 		String name = (String) eM.getCell(1, 14);
 		name =  name.replaceAll("[0-9]", "")+n;
 		name= n+name;
 		eM.setCell(1, 15, name);
    	Calendar rightNow =Calendar.getInstance();
		String date = Integer.toString(rightNow.get(Calendar.YEAR))+"-"+Integer.toString(rightNow.get(Calendar.MONTH)+1)+"-"+String.format("%02d",rightNow.get(Calendar.DAY_OF_MONTH));
    	int hours = rightNow.get(Calendar.HOUR);
      	 int min = rightNow.get(Calendar.MINUTE);
      	 int am_pm = rightNow.get(Calendar.AM_PM);
      	 int day = rightNow.get(Calendar.DAY_OF_MONTH);
      	 int year = rightNow.get(Calendar.YEAR);
      	 int month = rightNow.get(Calendar.MONTH)+1;
      	 min+=2;
      	 int rem = min%5;
      	 rem = 5-rem;
      	 min+=rem;
      	 if(min>59){
      		 min-=60;
      		 hours++;
      	 }
      	 Actions builder = new Actions(driver);
    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z/../../..']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@val='campaigns']//*[@id='filterForm']//label[contains(.,'Name')]/../input"))).sendKeys(eM.getCell(1, 14));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@val='campaigns']//*[@id='filterDialog']/div/paper-button[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[25]/neon-broadcasts/div/div/paper-button"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Broadcast Name')]/../input"))).sendKeys(name);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Purpose')]/../input"))).sendKeys("purp");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Label')]/../input"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select']/div/paper-item[1][contains(.,'Crossell')]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Triggers')]/../input"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Inventory')]/../input"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']/div/paper-item[contains(.,'Inv-CG')]"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Base Lists')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']/div/paper-item[contains(.,'adipoli_list')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Target Conditions')]/../paper-radio-group/paper-radio-button[1]/div[1]"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//data-table-cell[contains(.,'"+eM.getCell(1, 12)+"')]/..//*[@id='checkboxContainer']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Track session')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWrapper']/div/paper-listbox/paper-item[contains(.,'After')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='offerDetailForm']/section[1]/paper-card/div[2]/broadcast-tracking/div/paper-input/paper-input-container/div[2]//input"))).sendKeys("2");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Tracking Source')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']//paper-item[contains(.,'recharge_track')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Sender ID: Broadcast')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']//paper-item[contains(.,'Address-SMPP')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Route over which this broadcast')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']//paper-item[contains(.,'SMPP Robi outbond')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Sender ID: Fulfillment')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='card-content style-scope broadcast-offers-config']//paper-autocomplete[3]//paper-item[contains(.,'Address-SMPP')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Route over which Fulfillment')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='card-content style-scope broadcast-offers-config']//paper-autocomplete[4]//paper-item[contains(.,'SMPP Robi outbond')]"))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[2]"))).click();
		Thread.sleep(2000);
if(bc_type.contentEquals("one-off")){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='radioLabel' and contains(.,'One Off')]/../div[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Send Time')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//div[@date='"+date+"']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//*[@id='dateDialog']/div/paper-button[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']//paper-date-time-input[1]//paper-input[2]//input"))).click();
		
     Thread.sleep(2000);
   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[1]/div[1]"))).click();
	 WebElement num = driver.findElement(By.xpath(".//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
     builder.moveToElement(num).click().build().perform();
     Thread.sleep(2000);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[1]/div[3]"))).click();
	 WebElement num1 = driver.findElement(By.xpath(".//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
	 Thread.sleep(1000);
	 builder.moveToElement(num1).click().build().perform();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[1]/div[5]"))).click();
	    num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//*[@id='secondClock']//*[@id='numbers']//*[@class='number style-scope paper-clock-selector'][41]"));
	    builder.moveToElement(num1).click().build().perform();
	    Thread.sleep(2000);     
     if(am_pm==0)
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[1]"))).click();
     else
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[2]"))).click();
        
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='timeDialog']/div/paper-button[2]"))).click();
	    Thread.sleep(2000);
				
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Target Render Time')]/../input"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//div[@date='"+date+"']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='dateDialog']/div/paper-button[2]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']//paper-date-time-input[2]//paper-input[2]//input"))).click();
  Thread.sleep(2000);
  num = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
  builder.moveToElement(num).click().build().perform();
  Thread.sleep(1000);
  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='heading']/iron-selector[1]/div[3]"))).click();
  WebElement num2 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='minuteClock']//*[@id='numbers']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
  builder.moveToElement(num2).click().build().perform();
  Thread.sleep(1000);
  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='heading']/iron-selector[1]/div[5]"))).click();
  num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='secondClock']//*[@id='numbers']//*[@class='number style-scope paper-clock-selector'][21]"));
  builder.moveToElement(num1).click().build().perform();
  Thread.sleep(1000);
  if(am_pm==0)
  {
  	num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='heading']/iron-selector[2]/div[1]"));
  	builder.moveToElement(num1).click().build().perform();
     
  }
  else
  {
  	num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='heading']/iron-selector[2]/div[2]"));
  	builder.moveToElement(num1).click().build().perform();
  }
  
  num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='timeDialog']/div/paper-button[2]"));
  builder.moveToElement(num1).click().build().perform();
  Thread.sleep(2000);	
  
  driver.findElement(By.xpath(".//*[@id='topBar']/paper-button[3]")).click();	
  Thread.sleep(2000);
  
  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='broadcastSummary']/div[2]/paper-button[3]"))).click();
  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='confirmBox']/div/paper-button[2]"))).click();
  Thread.sleep(15000);
  
    }
		else if(bc_type.contentEquals("recurring")){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='radioLabel' and contains(.,'Reccurring')]/../div[1]"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//paper-date-time-input//paper-input[1]//input"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//div[@date='"+date+"']"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//*[@id='dateDialog']/div/paper-button[2]"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']//paper-date-time-input[1]//paper-input[2]//input"))).click();
			
	     Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//paper-date-time-input//paper-input[2]//input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[1]//*[@id='heading']/iron-selector[1]/div[1]"))).click();
			 WebElement num = driver.findElement(By.xpath(".//*[@id='deliverDetailForm']//*[@class='start-time-wrap style-scope broadcast-deliver-details']//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
		     builder.moveToElement(num).click().build().perform();
		     Thread.sleep(2000);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='heading']/iron-selector[1]/div[3]"))).click();
			 WebElement num1 = driver.findElement(By.xpath(".//*[@id='deliverDetailForm']//*[@class='start-time-wrap style-scope broadcast-deliver-details']//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
			 Thread.sleep(1000);
			 builder.moveToElement(num1).click().build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='deliverDetailForm']//paper-input-container//label[contains(.,'Time Zone')]/..//input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//paper-item[contains(.,'GMT+05:30')]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='deliver-card']//label[contains(.,'Recurrence Pattern')]/..//input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']//paper-item[contains(.,'Days')]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']//label[contains(.,'Recur Every')]/..//input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']//label[contains(.,'Start broadcasts at')]/..//input"))).click();
			 Thread.sleep(2000);
		   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='heading']/iron-selector[1]/div[1]"))).click();
			 num = driver.findElement(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='timePicker']//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
		     builder.moveToElement(num).click().build().perform();
		     Thread.sleep(2000);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='heading']/iron-selector[1]/div[3]"))).click();
			 num1 = driver.findElement(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='timePicker']//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
			 Thread.sleep(1000);
			 builder.moveToElement(num1).click().build().perform();
			
			    Thread.sleep(1000);     
		     if(am_pm==0)
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='heading']/iron-selector[2]/div[1]"))).click();
		     else
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='heading']/iron-selector[2]/div[2]"))).click();
		        
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='timeDialog']/div/paper-button[2]"))).click();
			    Thread.sleep(2000);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='radioLabel' and contains(.,'Real Time')]/../div[1]"))).click();
		
			    
			    driver.findElement(By.xpath(".//*[@id='topBar']/paper-button[3]")).click();	
			    Thread.sleep(2000);
			    
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='broadcastSummary']/div[2]/paper-button[3]"))).click();
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='confirmBox']/div/paper-button[2]"))).click();
			    Thread.sleep(15000);
		
		}
 }
    
    @Then("^check bc status$")
    public void checkBCsatus() throws Throwable
    {  	eM.setExcelFile("inputData","singleProductPage");
    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z/../../..']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@val='broadcastViews']//*[@id='filterForm']//label[contains(.,'Name')]/../input"))).sendKeys(eM.getCell(1, 15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@val='broadcastViews']//*[@id='filterDialog']/div/paper-button[3]"))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]"))).click();
		Thread.sleep(2000);
		
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iron-data-table[@id='broadcastGrid']//iron-list[@id='list']//data-table-row//data-table-cell[2]"))).getText();
        System.out.println(status); 
        while(!status.contains("Completed")){
        	Thread.sleep(3000);
        	status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iron-data-table[@id='broadcastGrid']//iron-list[@id='list']//data-table-row//data-table-cell[2]"))).getText();
        }
        String targeted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iron-data-table[@id='broadcastGrid']//iron-list[@id='list']//data-table-row//data-table-cell[5]"))).getText();
        System.out.println(targeted);
        String sent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iron-data-table[@id='broadcastGrid']//iron-list[@id='list']//data-table-row//data-table-cell[6]"))).getText();
        System.out.println(sent);
        Exception countMismatch = new Exception("targted count doesnt match sent");
        if(targeted.contentEquals(sent)){
        	throw countMismatch;    	
        }
            
    }
    
    @Given("^go to mesos$")
	public void go_to_mesos() throws Exception {
		System.out.println("mesos");		
		 eM.setExcelFile("login","Sheet1");
		 driver.get("http://192.168.150.45:5050/#/");		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@table-content='active_tasks']//a[contains(.,'neon_apps_platform_legacy-fe')]/../../td[6]/a"))).click();
		Thread.sleep(500);
		String reqURL = driver.findElement(By.xpath("//tbody/tr[3]//button[contains(.,'Download')]/..")).getAttribute("href");
		reqURL = reqURL.replaceAll("(download)", "read");
		System.out.println(reqURL);
		int offset = -1;
		String tempOffset ="";
		String req = "";
		int len=0;
		req=reqURL+"&offset="+offset+"&length=50000";
		String response = HttpResponseCode.getRequest(req);
		if(response.contains("{\"data\":\"\",\"offset")){
			tempOffset = response.substring(20);
			len = tempOffset.length();
			offset = Integer.parseInt(tempOffset.substring(0, len-1));
			offset-=50000;
			System.out.println(offset);
		}
		while(true){
		req=reqURL+"&offset="+offset+"&length=50000";
		response = HttpResponseCode.getRequest(req);
		System.out.println(response);
		offset+=50000;
		Thread.sleep(3000);
		}


		
	}
    
}