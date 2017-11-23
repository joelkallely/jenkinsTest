package stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.MarathonHelper;
import baseClasses.SSH;
import baseClasses.browserInit;
import cucumber.api.java.en.Then;

public class IAJStepDefinition extends browserInit {

	
	public static SSH ec = new SSH();
	public ExcelHelper eM = new ExcelHelper(); 
    public WebDriverWait wait = new WebDriverWait(driver, 8);
    public Actions actions = new Actions(driver);
    String name ="newIAJ";
    
    @Then("^create new iaj from$")
    
    public void createNewIAJ() throws Throwable{
    	Random rn = new Random();
 		int  n = 0;
 		n = rn.nextInt(5000) + 1;
 		 //(String) eM.getCell(1, 14);
 		//name =  name.replaceAll("[0-9]", "")+n;
 		name= n+name;
    	Thread.sleep(5000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Start New Analysis']"))).click();
    	Thread.sleep(1500);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Active Customer Base']/../input"))).click();
    	Thread.sleep(1000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='list']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Create']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Condition Type']/../input"))).click();
        Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='Customer Insight']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Field']/../input"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='Age']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Condition']/../input"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='is greater than']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='conditionForm']//input[@type='number']"))).sendKeys("18");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='conditionCard']/paper-button[text()='Save']"))).click();
    	Thread.sleep(1500);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Add KPI']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='KPI Name']/../input"))).sendKeys("newKPI");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='KPI Description']/../input"))).sendKeys("test");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Attribute Type']/../input"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//kpi-fieldset//paper-item[text()='Usage Metric']"))).click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Usage Metric']/../input"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='ARPU']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='kpiForm']//usage-metric//div[contains(@class,'usageMetricDiv')]/../paper-dropdown-menu[1]"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='by month']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='kpiForm']//usage-metric//div[contains(@class,'usageMetricDiv')]/../paper-dropdown-menu[2]"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-item[text()='last month']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='kpiDialog']//paper-button[text()='Confirm']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Proceed']"))).click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Analysis Name']/../input"))).sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Description']/../input"))).sendKeys("test");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Save Analysis']"))).click();
    	Thread.sleep(6000);
    	
    }
    @Then("^check IAJ status$")
    public void checkBCsatus() throws Throwable
    {  	eM.setExcelFile("login","Sheet1");
    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z/../../..']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filterDialog']//label[contains(.,'Name')]/../input"))).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filterDialog']//paper-button[contains(.,'Apply')]"))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../.."))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]"))).click();
		Thread.sleep(10000);
		if(MarathonHelper.getContainerStatus((String)eM.getCell(1, 2), "neon/apps/platform/conveyor-belt")<1)
			MarathonHelper.scaleContainer((String)eM.getCell(1, 2), "neon/apps/platform/conveyor-belt", "1");
		if(MarathonHelper.getContainerStatus((String)eM.getCell(1, 2), "zeppelin")<1)
			MarathonHelper.scaleContainer((String)eM.getCell(1, 2), "zeppelin", "1");
		String status = driver.findElement(By.xpath("//a[text()='"+name+"']/../../data-table-cell[3]//hexagon-content//span")).getText();
        System.out.println(status); 
        while(true){
        	Thread.sleep(3000);
        	status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+name+"']/../../data-table-cell[3]//hexagon-content//span"))).getText();
        	//System.out.println(status);
        	if(status.contains("C")||status.contains("F"))
        		break;
        }
        Thread.sleep(1500);
        Exception failedIAJ = new Exception("IAJ status is failed");
        if(status.contains("F")){
        	throw failedIAJ;    	
        }
        String customer_base = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+name+"']/../../data-table-cell[7]//b"))).getText();
        System.out.println("Customer Base::::::::"+customer_base);        
    }
 	   
}
