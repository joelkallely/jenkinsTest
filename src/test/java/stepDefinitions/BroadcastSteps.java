package stepDefinitions;

import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Then;
import pageObjetcs.BroadcastPageObjects;
import pageObjetcs.CampaignObjects;
import pageObjetcs.CommonObjects;

public class BroadcastSteps extends Init{

	JSWaiter jswait = new JSWaiter();
	public ExcelHelper eM = new ExcelHelper(); 
	CampaignObjects campaignObjects = new CampaignObjects();
	CommonObjects commonObjetcs = new CommonObjects();
	BroadcastPageObjects broadcastPageObjects = new BroadcastPageObjects();
	public WebDriverWait wait = new WebDriverWait(driver, 8);
	@Then("^check if create new bc lands in details tab$")
    public void checkLandingOfCreateNewBc() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastName("check");
    }
	@Then("^activate bc$")
    public void activateBc() throws Throwable
    {  
		broadcastPageObjects.clickCreateButton();
		broadcastPageObjects.clickActivateButton();
		broadcastPageObjects.clickActivateConfirmYes();
		Thread.sleep(10000);
    }
	@Then("^verify textual editor for target condition$")
    public void verifyTextualEditorOfTargetCondition() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("check");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectBaseList("list");
		commonObjetcs.clickOptionsIcon();
		commonObjetcs.clickTargetConditionOptionEdit();
		campaignObjects.createTargetCondition();
    }
	@Then("^verify delete option of target condition$")
    public void verifyDeleteOptionOfTargetCondition() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("check");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectBaseList("list");
		commonObjetcs.clickOptionsIcon();
		commonObjetcs.clickTargetConditionOptionDelete();
		campaignObjects.createTargetCondition();
    }
	@Then("^verify proceed button without adding target condition$")
    public void verifyProceedWithoutTargetCondition() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("check");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectBaseList("list");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectOffer("Offer");
    }
	@Then("^verify choose offer window after selecting offer$")
    public void verifyChooseOfferWindowAfterSelectingOffer() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("check");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectBaseList("list");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectOffer("Offer");
		broadcastPageObjects.selectTrackSession();
		broadcastPageObjects.selectTrackingSource();
		broadcastPageObjects.selectSenderAndRoute();
		broadcastPageObjects.clickProceedButton();
    }
	@Then("^verify selecting channel and sender$")
    public void verifySelectingChannelAndSender() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("check");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectBaseList("list");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectOffer("Offer");
		broadcastPageObjects.selectTrackSession();
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectTrackingSource();
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectSenderAndRoute();
		broadcastPageObjects.clickProceedButton();
    }
	@Then("^verify mandatory fields in details tab$")
    public void verifyMandatoryFieldsInDetailsTab() throws Throwable
    {  
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.enterBroadcastName("check");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.enterBroadcastPurpose("purpose");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectInventoryUnlimited();
		broadcastPageObjects.clickProceedButton();
    }
	@Then("^verify proceeding to target tab$")
    public void verifyProceedingToTab() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("ProceedCheck");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.selectBaseList("list");
    }
	@Then("^verify headers after proceeding to next target tab$")
    public void verifyHeaderAfterProceedingToNextTab() throws Throwable
    {  
		broadcastPageObjects.enterBroadcastBasicDetails("ProceedCheck");
		broadcastPageObjects.clickProceedButton();
		broadcastPageObjects.checkDetailsTabHeaderColor();
    }
	@Then("^verify validations of bc details tab$")
    public void verifyValidationsOfBcDetails() throws Throwable
    {  
		broadcastPageObjects.validateNameField();
		broadcastPageObjects.validatePurposeField();
		broadcastPageObjects.verifySelectionFields();
    }
	@Then("^enter details for new broadcast from sheet \"([^\"]*)\" with \"([^\"]*)\"$")
    public void create_new_broadcast(String sheet, String offer) throws Throwable
    {  
    	Thread.sleep(3000);
    	ExcelHelper list = new ExcelHelper();
    	list.setExcelFile("registrationListInputData", "Sheet1");
    	eM.setExcelFile("bcInputData",sheet);
    	String baseList = list.getCell(1, 2).toString();
    	ExcelHelper offerExcel = new ExcelHelper(); 
    	offerExcel.setExcelFile("offerInputData", offer);
    	Random rn = new Random();
 		int  n = rn.nextInt(5000) + 1;
 		String name = (String) eM.getCell(1, 0);
 		name =  name.replaceAll("[0-9]", "")+n;
 		eM.setCell(1, 0, name);
 	  	String bc_type =(String) eM.getCell(1, 7);
    	Calendar rightNow =Calendar.getInstance();
    	String mn = "";
    	if(rightNow.get(Calendar.MONTH)+1<9) {
    		mn = "0"+Integer.toString(rightNow.get(Calendar.MONTH)+1);
    	}
    	else 
    		mn = Integer.toString(rightNow.get(Calendar.MONTH)+1);
		String date = Integer.toString(rightNow.get(Calendar.YEAR))+"-"+mn+"-"+String.format("%02d",rightNow.get(Calendar.DAY_OF_MONTH));
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
      	 if((String)eM.getCell(1, 6)=="later"){
      		 day++;
      	 }
      	 Actions builder = new Actions(driver);
      	broadcastPageObjects.createBC(name, bc_type,baseList,offerExcel.getCell(1, 0).toString());
      	
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Target Conditions')]/../paper-radio-group/paper-radio-button[1]/div[1]"))).click();
//		Thread.sleep(1500);

if(bc_type.contentEquals("one-off")){
	Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='radioLabel' and contains(.,'One-off')]/../div[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Send Time')]/../input"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//div[@date='"+date+"']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//*[@id='dateDialog']/div/paper-button[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']//paper-date-time-input[1]//paper-input[2]//input"))).click();
		
     Thread.sleep(2000);
   	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[1]/div[1]"))).click();
	 WebElement num = driver.findElement(By.xpath(".//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
     builder.moveToElement(num).click().build().perform();
     Thread.sleep(2000);
//     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[1]/div[3]"))).click();
	 WebElement num1 = driver.findElement(By.xpath(".//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
	 Thread.sleep(1000);
	 builder.moveToElement(num1).click().build().perform();
//	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[1]/div[5]"))).click();
//	    num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//*[@id='secondClock']//*[@id='numbers']//*[@class='number style-scope paper-clock-selector'][41]"));
//	    builder.moveToElement(num1).click().build().perform();
//	    Thread.sleep(2000);     
     if(am_pm==0)
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[1]"))).click();
     else
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[2]"))).click();
        
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='timeDialog']/div/paper-button[2]"))).click();
	    Thread.sleep(2000);
				
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Target Render Time')]/../input"))).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//div[@date='"+date+"']"))).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='dateDialog']/div/paper-button[2]"))).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']//paper-date-time-input[2]//paper-input[2]//input"))).click();
  Thread.sleep(2000);
  num = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
  builder.moveToElement(num).click().build().perform();
  Thread.sleep(1000);
//  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='heading']/iron-selector[1]/div[3]"))).click();
  WebElement num2 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='minuteClock']//*[@id='numbers']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
  builder.moveToElement(num2).click().build().perform();
  Thread.sleep(1000);
//  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='heading']/iron-selector[1]/div[5]"))).click();
//  num1 = driver.findElement(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[2]//*[@id='secondClock']//*[@id='numbers']//*[@class='number style-scope paper-clock-selector'][21]"));
//  builder.moveToElement(num1).click().build().perform();
//  Thread.sleep(1000);
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
  Thread.sleep(1000);	
    }
else if(bc_type.contentEquals("recurring")||bc_type.contentEquals("seedingRecurring")||bc_type.contentEquals("seedingTriggerable")){
	Thread.sleep(2000);
	if(bc_type.contentEquals("recurring")){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='radioLabel' and contains(.,'Reccurring')]/../div[1]"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//paper-date-time-input//paper-input[1]//input"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//div[@date='"+date+"']"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']/div/paper-date-time-input[1]//*[@id='dateDialog']/div/paper-button[2]"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='one-off-form']//paper-date-time-input[1]//paper-input[2]//input"))).click();
	}	
	     Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//paper-date-time-input//paper-input[2]//input"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[1]//*[@id='heading']/iron-selector[1]/div[1]"))).click();
			 WebElement num = driver.findElement(By.xpath(".//*[@id='deliverDetailForm']//*[@class='start-time-wrap style-scope broadcast-deliver-details']//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
		     builder.moveToElement(num).click().build().perform();
		     Thread.sleep(2000);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='heading']/iron-selector[1]/div[3]"))).click();
			 WebElement num1 = driver.findElement(By.xpath(".//*[@id='deliverDetailForm']//*[@class='start-time-wrap style-scope broadcast-deliver-details']//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
			 Thread.sleep(1000);
			 builder.moveToElement(num1).click().build().perform();
			 Thread.sleep(1000);
			 num1 = driver.findElement(By.xpath(".//*[@id='deliverDetailForm']//*[@class='start-time-wrap style-scope broadcast-deliver-details']//*[@id='timeDialog']/div/paper-button[2]"));
			 builder.moveToElement(num1).click().build().perform();
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='deliverDetailForm']//paper-input-container//label[contains(.,'Time Zone')]/..//input"))).click();
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//paper-item[contains(.,'GMT+05:30')]"))).click();
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='deliver-card']//label[contains(.,'Recurrence Pattern')]/..//input"))).click();
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']//paper-item[contains(.,'Days')]"))).click();
			 Thread.sleep(1000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'recurrence')]//input"))).sendKeys("1");
			 Thread.sleep(1000);
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
		     Thread.sleep(2000);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='deliver-card']/../paper-card[2]//*[@id='timeDialog']/div/paper-button[2]"))).click();
			    Thread.sleep(2000);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='radioLabel' and contains(.,'Real Time')]/../div[1]"))).click();
		
			    
			    
		}
 }
}
