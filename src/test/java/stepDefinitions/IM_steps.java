package stepDefinitions;

import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.browserInit;
import cucumber.api.java.en.Then;

public class IM_steps extends browserInit {
	public ExcelHelper eM = new ExcelHelper(); 

	public WebDriverWait wait = new WebDriverWait(driver, 8);

	@Then("^navigate to intercative marketing$")
	public void navigateInteractiveMarketing() throws Throwable{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Interactive Marketing']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='USSD Application']"))).click();
			
		//button[text()='New USSD Application']
		//span[text()='USSD Push Application']
		//*[@id='applicationName']
		//*[@id='maxMessageSize']
		//*[@id='backMenuText']
		//*[@id='backMenuId']
		//*[@id='errorMessage']
		//input[@id='header']
		//input[@id='footer']
		//*[@id='sessionExpiryTime']
		//button[text()='Save and Exit']
		
		
	}
	@Then("^navigate to touchpoints$")
	public void navigateTouchpoints() throws Throwable{   
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Touchpoints']/.."))).click();
		Thread.sleep(2000);
	}
	@Then("^navigate to sms$")
	public void smsTouchpoints() throws Throwable{ 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='SMS']"))).click();
	}
	@Then("^click create new touchpoint$")
	public void clickCreateNewTouchpoint() throws Throwable{ 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Create New Touchpoint']"))).click();
	}
	@Then("^navigate to programs$")
	public void gotoPrograms() throws Throwable{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Programs')]/.."))).click();
		
	}
	@Then("^create program$")
	public void createPrograms() throws Throwable{
		eM.setExcelFile("inputData","singleProductPage");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 17);
		name =  name.replaceAll("[0-9]", "")+n;
		name= n+name;
		eM.setCell(1, 17, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create Program')]"))).click();
		Thread.sleep(1500);
		//Details - Basic Information
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Name')]/..//*[@id='input']"))).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Description')]/..//textarea"))).sendKeys("Description of Program");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Choose Offer Catalog')]/..//*[@id='input']"))).sendKeys(eM.getCell(1, 13));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eM.getCell(1, 13)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(1500);
		
		//Touchpoints
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Add Touchpoint')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Channel']/..//*[@id='input']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='SMS']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Keyword Aliases']/..//textarea"))).sendKeys("keword_program");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Touchpoint']/..//*[@id='input']"))).sendKeys(eM.getCell(1, 16));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'"+eM.getCell(1, 16)+"')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Response Channel']/..//*[@id='input']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Response Channel']/../../../../../../..//paper-item[text()='SMS']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addTouchpointForm']//paper-button[text()='Save']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(1500);
		//Rules
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='+ Add Rule']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Rule Name']/../input"))).sendKeys("progRule");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Product']/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='"+eM.getCell(1, 0)+"']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Select Offer']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='radioLabel']/article"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-dialog[@id='selectOfferModal']//paper-button[text()='Done']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Heuristic Conditions']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hueristicConditions']//label[text()='List']/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='adipoli_list']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hueristicConditions']//paper-button[text()='Done']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Tracking session expires']/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='After']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='style-scope expiry-component']/paper-input//input"))).sendKeys("2");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='style-scope expiry-component']/paper-dropdown-menu[2]//input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='style-scope expiry-component']//paper-item[text()='Days']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Sender ID: Broadcast')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']//paper-item[contains(.,'Address-SMPP')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Route over which this broadcast')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']//paper-item[contains(.,'SMPP Robi outbond')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Sender ID: Fulfillment')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Sender ID: Fulfillment')]/../../../../../..//*[@id='select']//paper-item[contains(.,'Address-SMPP')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//label[contains(.,'Route over which Fulfillment')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Route over which Fulfillment')]/../../../../../..//*[@id='select']//paper-item[contains(.,'SMPP Robi outbond')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='createSegment']/div[2]/paper-button[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(1500);
		
		//Schedule
		Calendar rightNow =Calendar.getInstance();
		String date = Integer.toString(rightNow.get(Calendar.YEAR))+"-"+Integer.toString(rightNow.get(Calendar.MONTH)+1)+"-"+String.format("%02d",(rightNow.get(Calendar.DAY_OF_MONTH)+2));
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
      	 System.out.println(hours+min);
      	Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Start Date']/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='Now']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='End Date']/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='End Date']/../../../../../../..//paper-item[text()='At']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='End Date/Time']/../input"))).click();
		WebElement num = driver.findElement(By.xpath("//paper-date-time-input[@class='layout horizontal start style-scope program-schedule x-scope paper-date-time-input-0']//div[@date='"+date+"']"));
		builder.moveToElement(num).click().build().perform();
	     Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-date-time-input[@class='layout horizontal start style-scope program-schedule x-scope paper-date-time-input-0']//*[@id='dateDialog']//paper-button[text()='OK']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Refresh Cycle']/../input"))).click();

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='Days']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Every']/../input"))).sendKeys("1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Refresh At']/../input"))).click();
		Thread.sleep(1500);
		num = driver.findElement(By.xpath("//div[@class='refreshTpWrap style-scope program-schedule']//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
		builder.moveToElement(num).click().build().perform();
		Thread.sleep(1500);
		num = driver.findElement(By.xpath("//div[@class='refreshTpWrap style-scope program-schedule']//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
		builder.moveToElement(num).click().build().perform();
		Thread.sleep(1500);
		num = driver.findElement(By.xpath("//div[@class='refreshTpWrap style-scope program-schedule']//*[@id='heading']/iron-selector[2]/div[2]"));
		builder.moveToElement(num).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='refreshTpWrap style-scope program-schedule']//paper-dialog[@id='timeDialog']//paper-button[text()='OK']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Serve on']/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='All Days']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[3]"))).click();
        Thread.sleep(4000);
	}
	
	@Then("^create sms touchpoint$")
	public void createSMSTouchpoint() throws Throwable{ 
		eM.setExcelFile("inputData","singleProductPage");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 16);
		name = name+"sms";
		name =  name.replaceAll("[0-9]", "")+n;
		name= n+name;
		eM.setCell(1, 16, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Short Code')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select']/div/paper-item"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Keyword')]/../input"))).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Ordering Logic')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'Rule-based')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Ordering Rule')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'FIFO')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Refresh Every')]/../input"))).sendKeys("1");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Time Interval')]/../input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//paper-item[contains(.,'Hours')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='smsForm']//label[contains(.,'Maximum offers')]/../input"))).sendKeys("10");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='smsForm']//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(1500);
		
	}
	@Then("^wait till programs is active$")
	public void wait_for_program_to_be_active() throws Throwable{ 
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='filterForm']//label[contains(.,'Name')]/../input"))).sendKeys(eM.getCell(1, 17));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filterDialog']/div/paper-button[3]"))).click();
		Thread.sleep(2500);
		
		Boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hexData style-scope hexagon-content']/span[text()='S']"))).isDisplayed();
		while(!status){
			status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hexData style-scope hexagon-content']/span[text()='S']"))).isDisplayed();
			Thread.sleep(3000);
		}
	}	
	
}
