package stepDefinitions;

import java.io.IOException;
import java.util.Calendar;
import pageObjects.TouchpointPageObjects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Touch;

import baseClasses.ExcelHelper;
import baseClasses.browserInit;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class IM_steps extends browserInit {
	public ExcelHelper eM = new ExcelHelper(); 

	public WebDriverWait wait = new WebDriverWait(driver, 8);

	@Then("^navigate to intercative marketing$")
	public void navigateInteractiveMarketing() throws Throwable{
		loadClick("//span[text()='Interactive Marketing']");	
	}
	@Then("^create new ussd application$")
	public void createUSSDapplication() throws Throwable{
		eM.setExcelFile("ussdApplicatioInputData","newApplication");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		loadClick("//a/span[text()='USSD Application']");
		loadClick("//button[text()='New USSD Application']");
		loadClick("//span[text()='USSD Push Application']");
		loadSendKeys("//*[@id='applicationName']",name);
		loadSendKeys("//*[@id='maxMessageSize']","22");
		loadSendKeys("//*[@id='backMenuText']","autoBack");
		loadSendKeys("//*[@id='backMenuId']","#");
		loadSendKeys("//*[@id='errorMessage']","autoError");
		loadSendKeys("//input[@id='header']","autoHead");
		loadSendKeys("//input[@id='footer']","autoFoot");
		loadSendKeys("//*[@id='sessionExpiryTime']","100");
		loadClick("//button[text()='Save and Exit']");
		Thread.sleep(7000);
		
	}
	@Then("^check touchpoint landing page$")
	public void checkTouchpointLandingPage() throws Throwable{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Customer Care']"))).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@val='customerCare' and contains(@class,'selected')]//iron-data-table[@id='customerTable']")).isDisplayed())
			System.out.println("true");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Create New Touchpoint']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addCustomerForm']/..//paper-button[contains(.,'Save')]"))).click();
		
	}
	@Then("^verify sms tp creation form$")
	public void checksmsTPCreationForm() throws Throwable{
		Thread.sleep(1500);
		driver.findElement(By.xpath(".//*[@id='addSmsModal']/div/h2[contains(text(),'Create New SMS Touchpoint')]"));
		enterSmsTouchpointDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='smsForm']//paper-button[contains(.,'Save')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='smsForm']//paper-button[contains(.,'Cancel')]")));
	}
	
	public void enterTriggerTouchpointDetails() throws Throwable{
		eM.setExcelFile("touchpointInputData","triggerTouchpoint");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//label[contains(.,'Touchpoint Name')]/../input"))).sendKeys(name);
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//label[contains(.,'Trigger')]/../input"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'trig')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Ordering Logic')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'Rule-based')]")).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Ordering Rule')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'FIFO')]")).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Refresh Every')]/../input")).sendKeys("5");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Time Interval')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'Hours')]")).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Maximum offers')]/../input")).sendKeys("5");
		Thread.sleep(1000);
	}
	@Then("^check trigger touchpoint in grid$")
	public void checkTriggerTP() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//data-table-cell[contains(.,'"+(String) eM.getCell(1, 0)+"')]"));
	}
	@Then("^create trigger touchpoint$")
	public void createTriggerTP() throws Throwable{  
		enterTriggerTouchpointDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(5000);
	}
	
	@Then("^check mandatory fields for trigger touchpoint$")
	public void mandatoryFieldsTriggerTP() throws Throwable{  
		eM.setExcelFile("touchpointInputData","triggerTouchpoint");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//label[contains(.,'Touchpoint Name')]/../input"))).sendKeys(name);
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//label[contains(.,'Trigger')]/../input"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'t')]"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Ordering Logic')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'Rul')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Ordering Rule')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'FIFO')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Refresh Every')]/../input")).sendKeys("5");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Time Interval')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'Hours')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Maximum offers')]/../input")).sendKeys("5");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(5000);
	}
	
	@Then("^check mandatory fields for sms touchpoint$")
	public void mandatoryFieldsSmsTP() throws Throwable{  
		eM.setExcelFile("touchpointInputData","triggerTouchpoint");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//label[contains(.,'Touchpoint Name')]/../input"))).sendKeys(name);
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//label[contains(.,'Trigger')]/../input"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'t')]"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Ordering Logic')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'Rul')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Ordering Rule')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'FIFO')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Refresh Every')]/../input")).sendKeys("5");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Time Interval')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='triggerForm']//paper-item[contains(.,'Hours')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		driver.findElement(By.xpath("//form[@id='triggerForm']//label[contains(.,'Maximum offers')]/../input")).sendKeys("5");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='triggerForm']//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(5000);
	}
	@Then("^navigate to touchpoints$")
	public void navigateTouchpoints() throws Throwable{   
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Touchpoints']/.."))).click();
		Thread.sleep(2000);
	
	}
	@Then("^navigate to sms$")
	public void smsTouchpoints() throws Throwable{ 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='SMS']"))).click();
	}
	@Then("^navigate to customer care$")
	public void CCTouchpoints() throws Throwable{ 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Customer Care']"))).click();
		Thread.sleep(2000);
	}
	public void enterCCTouchpointDetails() throws Throwable{
		eM.setExcelFile("touchpointInputData","CCTouchpoint");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addCustomerForm']//label[contains(.,'Touchpoint Name')]/../input"))).sendKeys(name);
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//label[contains(.,'Ordering Logic')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//paper-item[contains(.,'Rule-based')]")).click();
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//label[contains(.,'Ordering Rule')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//paper-item[contains(.,'FIFO')]")).click();
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//label[contains(.,'Refresh Every')]/../input")).sendKeys("5");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//label[contains(.,'Time Interval')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//paper-item[contains(.,'Hours')]")).click();
		driver.findElement(By.xpath("//form[@id='addCustomerForm']//label[contains(.,'Maximum offers')]/../input")).sendKeys("5");
		Thread.sleep(1000);
	}
	@Then("^check customer care touchpoint in grid$")
	public void checkCCTP() throws Throwable{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//data-table-cell[contains(.,'"+(String) eM.getCell(1, 0)+"')]"));
	}
	@Then("^create customer care touchpoint$")
	public void createCCTP() throws Throwable{  
		enterCCTouchpointDetails();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addCustomerForm']/..//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(2000);
	}
	////////////////////////////////////////////////////
	@Then("^navigate to api$")
	public void apiTouchpoints() throws Throwable{ 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='API']"))).click();
		Thread.sleep(2000);
	}
	public void enterApiTouchpointDetails() throws Throwable{
		eM.setExcelFile("touchpointInputData","apiTouchpoint");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='apiForm']//label[contains(.,'Touchpoint Name')]/../input"))).sendKeys(name);
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Application Type')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='apiForm']//paper-item[contains(.,'General')]")).click();
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Event For Track')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='apiForm']//paper-item[contains(.,'Accepted Event')]")).click();
		
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Ordering Logic')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='apiForm']//paper-item[contains(.,'Rule-based')]")).click();
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Ordering Rule')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='apiForm']//paper-item[contains(.,'FIFO')]")).click();
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Refresh Every')]/../input")).sendKeys("5");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Time Interval')]/../input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//form[@id='apiForm']//paper-item[contains(.,'Hours')]")).click();
		driver.findElement(By.xpath("//form[@id='apiForm']//label[contains(.,'Maximum offers')]/../input")).sendKeys("5");
		Thread.sleep(1000);
	}
	@Then("^check api touchpoint in grid$")
	public void checkApiTP() throws Throwable{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//data-table-cell[contains(.,'"+(String) eM.getCell(1, 0)+"')]"));
	}
	@Then("^create api touchpoint$")
	public void createApiTP() throws Throwable{  
		enterApiTouchpointDetails();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='apiForm']/..//paper-button[contains(.,'Save')]"))).click();
		Thread.sleep(2000);
	}
//	///////////////////////////////////////////////////
	
////////////////////////////////////////////////////
@Then("^navigate to ussd$")
public void ussdTouchpoints() throws Throwable{ 
Thread.sleep(2000);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='USSD']"))).click();
Thread.sleep(2000);
}
public void enterUssdTouchpointDetails() throws Throwable{
eM.setExcelFile("touchpointInputData","ussdTouchpoint");
Thread.sleep(1500);
Random rn = new Random();
int  n = rn.nextInt(5000) + 1;
String name =(String) eM.getCell(1, 0);
name =  name.replaceAll("[0-9]", "")+n;
eM.setCell(1, 0, name);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='ussdForm']//label[contains(.,'Touchpoint Name')]/../input"))).sendKeys(name);
driver.findElement(By.xpath("//form[@id='ussdForm']//label[contains(.,'USSD Application')]/../input")).click();
Thread.sleep(1500);
driver.findElement(By.xpath("//form[@id='ussdForm']//paper-item[contains(.,'')]")).click();

driver.findElement(By.xpath("//form[@id='ussdForm']//label[contains(.,'Ordering Logic')]/../input")).click();
Thread.sleep(1500);
driver.findElement(By.xpath("//form[@id='ussdForm']//paper-item[contains(.,'Rule-based')]")).click();
driver.findElement(By.xpath("//form[@id='ussdForm']//label[contains(.,'Ordering Rule')]/../input")).click();
Thread.sleep(1500);
driver.findElement(By.xpath("//form[@id='ussdForm']//paper-item[contains(.,'FIFO')]")).click();
driver.findElement(By.xpath("//form[@id='ussdForm']//label[contains(.,'Refresh Every')]/../input")).sendKeys("5");
Thread.sleep(1500);
driver.findElement(By.xpath("//form[@id='ussdForm']//label[contains(.,'Time Interval')]/../input")).click();
Thread.sleep(1500);
driver.findElement(By.xpath("//form[@id='ussdForm']//paper-item[contains(.,'Hours')]")).click();
driver.findElement(By.xpath("//form[@id='ussdForm']//label[contains(.,'Maximum offers')]/../input")).sendKeys("5");
Thread.sleep(1000);
}
@Then("^check ussd touchpoint in grid$")
public void checkUssdTP() throws Throwable{
Thread.sleep(1000);
driver.findElement(By.xpath("//data-table-cell[contains(.,'"+(String) eM.getCell(1, 0)+"')]"));
}
@Then("^create ussd touchpoint$")
public void createUssdTP() throws Throwable{  
enterUssdTouchpointDetails();
Thread.sleep(2000);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='ussdForm']/..//paper-button[contains(.,'Save')]"))).click();
Thread.sleep(2000);
}
/////////////////////////////////////////////////////
	@Then("^navigate to trigger$")
	public void triggerTouchpoints() throws Throwable{ 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Trigger']"))).click();
	}
	@Then("^click create new touchpoint$")
	public void clickCreateNewTouchpoint() throws Throwable{ 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Create New Touchpoint']"))).click();
	}
	@Then("^navigate to programs$")
	public void gotoPrograms() throws Throwable{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Programs')]/.."))).click();
		
	}
	@Then("^click create program button$")
	public void proceedButtonPrograms() throws Throwable{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create Program')]"))).click();
		Thread.sleep(1500);
	}
	@Then("^click confirm button$")
	public void SaveButtonPrograms() throws Throwable{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Confirm')]"))).click();
		Thread.sleep(4000);
	}
	@Then("^enter program details$")
	public void createPrograms() throws Throwable{
		eM.setExcelFile("inputData","singleProductPage");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 17);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 17, name);
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
		Calendar rightNow = Calendar.getInstance();
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
        Thread.sleep(1000);
	}
	public void enterSmsTouchpointDetails() throws InterruptedException, IOException {
		eM.setExcelFile("touchpointInputData","smsTouchpoint");
		Thread.sleep(1500);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name =(String) eM.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eM.setCell(1, 0, name);
		TouchpointPageObjects.shortCode_select(driver, "2255");
		Thread.sleep(1000);
		TouchpointPageObjects.keyword_input(driver, name);
		Thread.sleep(1000);
		TouchpointPageObjects.orderingLogic_select(driver,"Rule-based");
		Thread.sleep(1000);
		TouchpointPageObjects.orderingRule_select(driver, "FIFO");
		Thread.sleep(1000);
		TouchpointPageObjects.refreshEvery_input(driver, "1");
		Thread.sleep(1000);
		TouchpointPageObjects.timeInterval_select(driver, "Hours");
		Thread.sleep(1000);
		TouchpointPageObjects.maximumOffers_input(driver, "10");
		Thread.sleep(1000);
		
	}
	@Then("^create sms touchpoint$")
	public void createSMSTouchpoint() throws Throwable{ 
		enterSmsTouchpointDetails();
		TouchpointPageObjects.smsTouchpointSave_click(driver);
		Thread.sleep(1500);
		
	}
	public void cancelBtnSMSTouchpoint() throws InterruptedException {
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='smsForm']//paper-button[contains(.,'Cancel')]"))).click();
	}
	public void cancelBtnTriggerTouchpoint() throws InterruptedException {
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='triggerForm']//paper-button[contains(.,'Cancel')]"))).click();
	}
	@Then("^verify cancel button of sms touchpoint$")
	public void cancelSMSTouchpoint() throws Throwable{ 
		enterSmsTouchpointDetails();
		Thread.sleep(1500);
		cancelBtnSMSTouchpoint();
		Thread.sleep(1500);
		Exception e = new Exception("item saved after cancel button");
		try {
			checkSmsTP();
			throw e;
		}catch(Exception noError) {		
		}	
	}
	@Then("^verify cancel button of trigger touchpoint$")
	public void cancelTriggerTouchpoint() throws Throwable{ 
		enterTriggerTouchpointDetails();
		Thread.sleep(1500);
		cancelBtnTriggerTouchpoint();
		Thread.sleep(1500);
		Exception e = new Exception("item saved after cancel button");
		try {
			checkTriggerTP();
			throw e;
		}catch(Exception noError) {		
		}	
	}
	@Then("^check sms touchpoint in grid$")
	public void checkSmsTP() throws Throwable{
	Thread.sleep(1000);
	driver.findElement(By.xpath("//data-table-cell[contains(.,'"+(String) eM.getCell(1, 0)+"')]"));
	}
	@Then("^verify delete trigger touchpoint$")
	public void deleteTriggerTP() throws Throwable{
	Thread.sleep(1000);
	driver.findElement(By.xpath("//data-table-cell[contains(.,'"+(String) eM.getCell(1, 0)+"')]/..//paper-icon-button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//trigger-touchpoint-grid//*[@id='deleteTP']//paper-button[2]")).click();
	Exception e = new Exception("item not deleted");
	try {
		checkTriggerTP();
		throw e;
	}catch(Exception noError) {		
	 }	
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
	@Then("^verify program landing page$")
	public void verfyProgramLandingPage() throws Throwable{ 
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='programList']"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Name')]"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Status')]"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Offer Catalog')]"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Channels')]"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'# Rules')]"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'# Views')]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create Program')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")));
		
	}
	public void entervaluesforProgramDetails() throws Throwable{ 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Name')]/..//*[@id='input']"))).sendKeys("name");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Description')]/..//textarea"))).sendKeys("Description of Program");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Choose Offer Catalog')]/..//*[@id='input']"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'at')]"))).click();
	}
	@Then("^verify create program page$")
	public void verfyProgramCreationPage() throws Throwable{ 
		entervaluesforProgramDetails();
				driver.findElement(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Cancel')]"));
				driver.findElement(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Save')]"));
				driver.findElement(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Proceed')]"));
				driver.findElement(By.xpath(".//*[@id='crumbs']/flytxt-breadcrumb[4]//paper-button[contains(.,'Create Program')]"));
	}
	@Then("^verify program proceed button functionality for details tab$")
	public void verfyProgramProceedDetails() throws Throwable{ 	
		entervaluesforProgramDetails();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
				Thread.sleep(2000);
				//Touchpoints
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Add Touchpoint')]"))).click();
	}
	@Then("^verify program cancel button functionality for details tab$")
	public void verfyProgramCancelDetails() throws Throwable{ 	
		entervaluesforProgramDetails();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Cancel')]"))).click();
				Thread.sleep(2000);
				//Touchpoints
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create Program')]"))).click();
	}
	
	@Then("^verify program choose catalog field values$")
	public void verfyProgramChooseCatalog() throws Throwable{ 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Choose Offer Catalog')]/..//*[@id='input']"))).sendKeys("at");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'at')][2]"))).click();
	}
	@Then("^verify program field validation for details tab$")
	public void verfyProgramDetailsValidation() throws Throwable{ 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Name')]/..//*[@id='input']"))).sendKeys("name");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(.,'Basic Information')]/..//label[contains(.,'Choose Offer Catalog')]/..//*[@id='input']"))).sendKeys("at");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'at')][2]"))).click();
		Thread.sleep(2000);
		//Touchpoints
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create Program')]"))).click();
	}
	
	@Then("^verify program touchpoint tab$")
	public void verfyProgramtouchpointTab() throws Throwable{ 
		entervaluesforProgramDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(2000);  
		//Touchpoints  
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Touchpoint')]"));
		driver.findElement(By.xpath("//data-table-cell[text()='Channel']"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Response Channel')]"));
		driver.findElement(By.xpath("//data-table-cell[contains(.,'Other Attrib')]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Add Touchpoint')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Cancel')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Save')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Proceed')]")));
	}
	
	@Then("^verify program touchpoint addition$")
	public void verfyProgramtouchpointAddition() throws Throwable{ 
		entervaluesforProgramDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(2000);  
		//Touchpoints  
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Add Touchpoint')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Channel']/..//*[@id='input']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='SMS']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Keyword Aliases']/..//textarea"))).sendKeys("keword_program");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Touchpoint']/..//*[@id='input']"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Touchpoint']/..//*[@id='input']"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[contains(.,'2255')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Response Channel']/..//*[@id='input']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='addTouchpointForm']//label[text()='Response Channel']/../../../../../../..//paper-item[text()='SMS']"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addTouchpointForm']//paper-button[text()='Save']"))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(1500);
	}
	
	@Then("^get page source$")
	public void getPageSource() throws Throwable{ 
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topBar']/paper-button[contains(.,'Proceed')]"))).click();
		Thread.sleep(3000);
		String code= driver.getPageSource();
		int bodyIndex = 0;
		int end = 0;
		bodyIndex = code.indexOf("<body");
		end = code.length();
//		end = code.indexOf("</body");
		System.out.println("value of bodyIndex : "+ bodyIndex);
		System.out.println("value of end : "+ end);
		code = code.substring(bodyIndex, end);
		end  = code.length();
		int i =1;
		int j =0;
		String label = "";
		///////////////////////////////////////////////////////////////////////////////////////////////////
		for(;i!=0;) {
			//find i
			String patternStr = ">[a-zA-Z]+";
//			System.out.println(patternStr);
		    Pattern pattern = Pattern.compile(patternStr);
		    Matcher matcher = pattern.matcher(code);
		    if(matcher.find()){
		    
		    i = matcher.start();//this will give index of error
		    
		    }
		    else
		    	break;
		    code = code.substring(i, end);
		    end = code.length();
		    //find j
		    String patternStr1 = "<";
//		    String patternStr1 = "</div";
//			System.out.println(i);
		    Pattern pattern1 = Pattern.compile(patternStr1);
		    Matcher matcher1 = pattern1.matcher(code);
		    if(matcher1.find()){

		    j = matcher1.start();//this will give index of error
		    }
//		    System.out.println(j);
		    label += ",  "+code.substring(0, j);
//		    System.out.println(label);
		    code = code.substring(j, end);
		    end = code.length();
		    
		}
		System.out.println(label);
		
////		System.out.println(code);
//		
//		
//	    String slav1e = code.substring(i, i+500);
//	    System.out.println(slav1e);
//	    
//	    slav1e = code.substring(0, 10);
//	    System.out.println(slav1e);
//	    
//	    slav1e = code.substring(end-10, end-1);
//	    System.out.println(slav1e);
//	    
//	    System.out.println("value of i : "+ i);
//	    
//	    
//
//	    
//	    slav1e = code.substring(0, j);
//	    System.out.println(slav1e);
	    
//		System.out.println(i);
//		j = code.indexOf("");
//		System.out.println(j);
//		String slave = code.substring(i, j);
//		System.out.println(slave);
	}
}
