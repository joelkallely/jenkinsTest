package stepDefinitions;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import baseClasses.JSWaiter;
import baseClasses.TimePicker;
import cucumber.api.java.en.Then;
import pageObjetcs.CampaignObjects;
import pageObjetcs.CommonObjects;
import pageObjetcs.LoginPageObjects;

public class CampaignManagement extends Init{
	JSWaiter jswait = new JSWaiter();
	public ExcelHelper eM = new ExcelHelper(); 
	CampaignObjects campaignObjects = new CampaignObjects();
	CommonObjects commonObjects = new CommonObjects();
	public WebDriverWait wait = new WebDriverWait(driver, 8);
	LoginPageObjects loginPage = new LoginPageObjects();
	public CampaignManagement() {
		PageFactory.initElements(driver, this);
	}
	 @Then("^create new campaign from sheet \"([^\"]*)\"$")
	    public void create_new_campaign(String sheet) throws Throwable
	    {
	    	Thread.sleep(4000);
	    	ExcelHelper catalogExcel = new ExcelHelper();
	    	catalogExcel.setExcelFile("offerCatalogInputData", "defaultCatalog");
	    	Thread.sleep(4000);
	    	eM.setExcelFile("campaignInputData",sheet);
	 	    Random rn = new Random();
	 		int  n = rn.nextInt(5000) + 1;
	 		String name = (String) eM.getCell(1, 0);
	 		String catalog = (String) catalogExcel.getCell(1, 0);
	 		name =  name.replaceAll("[0-9]", "")+n;
	 		eM.setCell(1, 0, name);
	 		campaignObjects.clickCreateNewCampaignButton();
	 		campaignObjects.createCampaign(name, catalog);

//	    	 
//	    	 List<WebElement> condition_form = driver.findElements(By.xpath("//target-form/form/condition-form"));
//	    	 System.out.println(condition_form.size());
//	    	 condition_form.get(0).click();
//	    	 String condition_input_xpath = "//target-form/form/condition-form[1]//input";
//	    	 List<WebElement> condition_inputs = driver.findElements(By.xpath(condition_input_xpath));
//	    	 String xpath = "";
//	    	 condition_inputs = driver.findElements(By.xpath(condition_input_xpath));
//	    	 System.out.println("size:"+condition_inputs.size());
//	    	 System.out.println("get value:"+condition_inputs.get(condition_inputs.size()-1));
//	    	 condition_inputs.get(condition_inputs.size()-1).click();
//	    	 Thread.sleep(4000);
//	    	 int i = condition_inputs.get(condition_inputs.size()-1).toString().indexOf("xpath:");
//	    	 i+=7;
//	    	 xpath = condition_inputs.get(condition_inputs.size()-1).toString().substring(i);
//	    	 xpath = xpath.substring(0, xpath.length()-1);
//	    	 xpath = xpath+"/../../../../../../..//paper-item";
//	    	 System.out.println(xpath);
//	    	 driver.findElement(By.xpath(xpath)).click(); 
//	    	 Thread.sleep(4000);
//	    	 condition_inputs = driver.findElements(By.xpath(condition_input_xpath));
//	    	 System.out.println("size:"+condition_inputs.size());
//	    	 System.out.println("get value:"+condition_inputs.get(condition_inputs.size()-1));
//	    	 condition_inputs.get(condition_inputs.size()-1).click();
//	    	 Thread.sleep(4000);
//	    	 i = condition_inputs.get(condition_inputs.size()-1).toString().indexOf("xpath:");
//	    	 i+=7;
//	    	 xpath = condition_inputs.get(condition_inputs.size()-1).toString().substring(i);
//	    	 xpath = xpath.substring(0, xpath.length()-1);
//	    	 xpath = xpath+"/../../../../../../..//paper-item";
//	    	 System.out.println(xpath);
//	    	 driver.findElement(By.xpath(xpath)).click(); 
	 		TimePicker dt = new TimePicker();
	 		dt.gteDateTime();
	    	 Thread.sleep(2000);
	    }
	 @Then("^navigate to life cycle marketing$")
		public void naviagte_to_life_cycle_marketing() throws Exception
		{
		 	campaignObjects.navigateToLIfeCycleMarketing();
		}
	    @Then("^navigate to \"([^\"]*)\" category$")
	    public void navigate_to_category(String category) throws Throwable
	    {
	    	Thread.sleep(2000);
	    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+category+"']"))).click();
	    	 Thread.sleep(4000);
	    }
	    @Then("^naigate to \"([^\"]*)\" campaign view broadcasts$")
	    public void navigateToCampaign(String sheet) throws Throwable
	    {
	    	eM.setExcelFile("campaignInputData", sheet);
	    	String name = eM.getCell(1, 0).toString();
	    	commonObjects.filterName(name);
	    	
//	    	Thread.sleep(30000);//NX-8537 bug wait
	    	
	    	jswait.loadClick(".//vaadin-grid-cell-content[contains(.,'"+name+"')]//following::*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..");
			campaignObjects.clickOptionsViewBroadcasts();
	    }
	    @Then("^click create new broadcast button$")
	    public void create_new_broadcast_button() throws Throwable
	    {
	    	campaignObjects.clickCreateNewBroadcastButton();
	    }
}
