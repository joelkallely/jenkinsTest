package stepDefinitions;

import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Then;
import pageObjetcs.CustomerProfilePage;
import pageObjetcs.LoginPageObjects;
import pageObjetcs.OfferPageObjects;

public class OfferSteps extends Init{
	public ExcelHelper eh = new ExcelHelper();
	Offer_creation_steps offer_creation = new Offer_creation_steps();
	JSWaiter jswait = new JSWaiter();
	LoginPageObjects loginPage = new LoginPageObjects();
	OfferPageObjects offerPageObjects = new OfferPageObjects();
	CustomerProfilePage customerProfilePage = new CustomerProfilePage();
	public OfferSteps() {
		PageFactory.initElements(driver, this);
	}
//	@Then("^navigate to offers")
//	public void logout() throws InterruptedException {
//		offerPageObjects.navigateToOffer();
//	}
	
	@Then("^create new offer from sheet \"([^\"]*)\" with product \"([^\"]*)\"$")
	public void create_new_Offer(String sheet, String productSheet) throws Throwable 
	{
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions actions = new Actions(driver);
		
		ExcelHelper prodcutFile = new ExcelHelper();
		prodcutFile.setExcelFile("productInputData",productSheet);
		eh.setExcelFile("offerInputData",sheet);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eh.setCell(1, 0, name);
		
		offerPageObjects.clickCreateNewOfferButton();
//******************Details tab******************:
		offerPageObjects.enterDetailsTabFields(sheet);
		offerPageObjects.clickProceedButton();
//******************Products tab*****************:
		offerPageObjects.enterProductTabFields(productSheet);
		offerPageObjects.clickProceedButton();
		
//******************Creative tab*****************:
		offerPageObjects.selectCreativeLanguageEnglish();
		if(((String) eh.getCell(1, 3)).contains("WAP Push")){
			offerPageObjects.enterWapCreative(eh.getCell(1, 10).toString(),eh.getCell(1, 11).toString());
		}
		if(eh.getCell(1, 3)=="SMS")
			offerPageObjects.enterSmsCreative(eh.getCell(1, 11).toString());
		offerPageObjects.clickProceedButton();
		Thread.sleep(3000);
		
//******************Track tab*****************:
		offerPageObjects.clickTrackSourceSelector();
		offerPageObjects.selectTrackSource("track");
		offerPageObjects.clickProceedButton();
		
//******************Rewards tab*****************:
		if(eh.getCell(1, 2).toString().contains("Seeding")){
			offerPageObjects.clickRewardTypeInputField();
			offerPageObjects.clickRewardTypeAccount();
		}
		offerPageObjects.clickSaveOfferButton();
	}
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Actions actions = new Actions(driver);
	
	@Then("^Create_offers_of_different_type_in_all_channel$")
	public void Create_offers_of_different_type_in_all_channel() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","details");
		int rows = eh.numRows();
		for(int i=1;i<rows;i++)
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		}
	}
	
	@Then("^Create_offers_with_SMS_channel$")
	public void Create_offers_with_SMS_channel() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 1;
		offerPageObjects.clickCreateNewOfferButton();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_with_VOICEpush_channel$")
	public void Create_offers_with_VOICEpush_channel() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 2;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_with_WAPpush_channel$")
	public void Create_offers_with_WAPpush_channel() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 3;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_BalanceDeduction_type$")
	public void Create_offers_of_BalanceDeduction_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 4;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_ComboOffer_type$")
	public void Create_offers_of_ComboOffer_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 5;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_informational_type$")
	public void Create_offers_of_informational_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 6;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_Recharge_type$")
	public void Create_offers_of_Recharge_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 7;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_Seeding_type$")
	public void Create_offers_of_Seeding_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 8;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_STV_type$")
	public void Create_offers_of_STV_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 9;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	
	@Then("^Create_offers_of_UsageBased_type$")
	public void Create_offers_of_UsageBased_type() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		int i = 4;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
//Details tab
		offer_creation.offer_creation_details_tab(eh.getCell(i, 0), eh.getCell(i, 1), eh.getCell(i, 2), eh.getCell(i, 3), eh.getCell(i, 4), eh.getCell(i, 5), eh.getCell(i, 6));
//Product tab
		offer_creation.Offer_creation_products_tab(eh.getCell(i, 7), eh.getCell(i, 8));
//Creative tab
		String channel = eh.getCell(i, 3).toString();
		if ("SMS".equals(channel))
		offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 11), eh.getCell(i, 12));
			else if ("Voice Push".equals(channel)) 
			offer_creation.offer_creation_creative_tab(eh.getCell(i, 9), eh.getCell(i, 10), eh.getCell(i, 13), eh.getCell(i, 14), eh.getCell(i, 15), eh.getCell(i, 16), eh.getCell(i, 17), eh.getCell(i, 18));
				else if ("WAP Push".equals(channel))
				offer_creation.offer_creation_creative_tab(eh.getCell(i, 19), eh.getCell(i, 20));
//Track tab
		String offer_type = eh.getCell(i, 2).toString();
		if ("Informational".equals(offer_type))
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		else
			offer_creation.offer_creation_track_tab();
//Rewards tab
		if("Seeding".equals(offer_type))
			offer_creation.offer_creation_rewards_tab();
		else
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
				Thread.sleep(3000);
		
	}
	

	@Then("^Check_Offer_cancel_button$")
	public void Check_cancel_button() throws Throwable
	{
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
			int pass=0;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
			Thread.sleep(2000);
			offer_creation.offer_creation_details_tab(eh.getCell(1, 0), eh.getCell(1, 1), eh.getCell(1, 2), eh.getCell(1, 3), eh.getCell(1, 4), eh.getCell(1, 5), eh.getCell(1, 6));
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//data-table-cell[contains(.,'Benefits')]")).isDisplayed())
					pass=1;
			else
				throw new NoSuchElementException("check cancel button in the offer creation tab");
				
	}
	
	@Then("^Check_Offer_help_icon$")
	public void Check_Offer_help_icon() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flytxt-context-help[@id='Offers']"))).click();
		Thread.sleep(3000);
		WebElement help_dialogueBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//object[contains(@data,'./../context-help/Offers.html')]")));
		Thread.sleep(2000);
		try 
		{
			if(help_dialogueBox.isDisplayed())
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M14.59 8L12 10.59 9.41 8 8 9.41 10.59 12 8 14.59 9.41 16 12 13.41 14.59 16 16 14.59 13.41 12 16 9.41 14.59 8zM12 2C6.47 2 2 6.47 2 12s4.47 10 10 10 10-4.47 10-10S17.53 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8z']/../../.."))).click();
		} 
		catch (Exception e) 
		{
			System.out.println("Help dialogue box is not displayed");
			e.printStackTrace();
			
		}	
	}
	
	@Then("^Check_details_tab_without_entering_details$")
	public void Check_details_tab_without_entering_details() throws Throwable
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Deduction')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'SMS')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Top ups')]"))).click().build().perform();
//		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
//		Thread.sleep(1000);
//		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'INR')]"))).click().build().perform();
//		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys("20").build().perform();
//		Thread.sleep(1000);
//		
		WebElement error_msg = driver.findElement(By.xpath("//div[@class='content style-scope offer-details']/paper-input[1]/paper-input-container/div[4]/paper-input-error[contains(.,'This field is required')]"));
		
		if(error_msg.isDisplayed())
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
			
		else 
			throw new Exception("Offer created without invalid details tab");
		
	}
	
	@Then("^Check_add_button_in_product_tab$")
	public void Check_add_button_in_product_tab() throws Throwable
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys("name").build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys("desc").build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Deduction')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'SMS')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'Balance Top ups')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'INR')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys("20").build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		
		WebElement Add_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button")));
		if(Add_button.isDisplayed())
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
			
		else 
			throw new NoSuchElementException("Add button is not displayed in the products tab");
			
	}
	
	@Then("^Check_filter_operation_in_products_tab_with_ProductName$")
	public void Check_filter_operation_in_products_tab_with_ProductName() throws Throwable
	{
		String product_name = "prod_2test_filterTab";
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		offer_creation.offer_creation_details_tab(eh.getCell(1, 0), eh.getCell(1, 1), eh.getCell(1, 2), eh.getCell(1, 3), eh.getCell(1, 4), eh.getCell(1, 5), eh.getCell(1, 6));
//click on filter button****************
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
//Checking Product name field***********
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(product_name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
			
		WebElement filtered_offer_1 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[1]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_2 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[2]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_3 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[3]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_4 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[4]/data-table-row/div[1]/data-table-cell[1]/span"));
				
		if(filtered_offer_1.getText().toString().contains(product_name) && 
				filtered_offer_2.getText().toString().contains(product_name) && 
					filtered_offer_3.getText().toString().contains(product_name) && 
						filtered_offer_4.getText().toString().contains(product_name))
		{
			actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[1]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
			Thread.sleep(2000);
		}
		
	}
	
	@Then("^Check_filter_operation_in_products_tab_with_Price$")
	public void Check_filter_operation_in_products_tab_with_Price() throws Throwable
	{
		String product_name = "prod_2test_filterTab";
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		offer_creation.offer_creation_details_tab(eh.getCell(1, 0), eh.getCell(1, 1), eh.getCell(1, 2), eh.getCell(1, 3), eh.getCell(1, 4), eh.getCell(1, 5), eh.getCell(1, 6));
//click on filter button****************
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
//Checking Product name field***********
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(product_name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
			
		WebElement filtered_offer_1 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[1]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_2 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[2]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_3 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[3]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_4 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[4]/data-table-row/div[1]/data-table-cell[1]/span"));
				
		if(filtered_offer_1.getText().toString().contains(product_name) && 
				filtered_offer_2.getText().toString().contains(product_name) && 
					filtered_offer_3.getText().toString().contains(product_name) && 
						filtered_offer_4.getText().toString().contains(product_name))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys("20").build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
			Thread.sleep(1000);

			if (!(filtered_offer_1.getText().toString()).equals("prod_2test_filterTab_1"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys("30").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
				Thread.sleep(1000);
			}
				
				if(!(filtered_offer_4.isDisplayed()))
				{
				
				actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[1]"))).click().build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
				Thread.sleep(2000);
				}
		}
		
	}
	
	
	@Then("^Check_filter_operation_in_products_tab_with_Validity$")
	public void Check_filter_operation_in_products_tab_with_Validity() throws Throwable
	{
		String product_name = "prod_2test_filterTab";
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		offer_creation.offer_creation_details_tab(eh.getCell(1, 0), eh.getCell(1, 1), eh.getCell(1, 2), eh.getCell(1, 3), eh.getCell(1, 4), eh.getCell(1, 5), eh.getCell(1, 6));
//click on filter button****************
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
//Checking Product name field***********
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(product_name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
			
		WebElement filtered_offer_1 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[1]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_2 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[2]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_3 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[3]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_4 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[4]/data-table-row/div[1]/data-table-cell[1]/span"));
				
		if(filtered_offer_1.getText().toString().contains(product_name) && 
				filtered_offer_2.getText().toString().contains(product_name) && 
					filtered_offer_3.getText().toString().contains(product_name) && 
						filtered_offer_4.getText().toString().contains(product_name))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys("20").build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
			Thread.sleep(1000);

			if (!(filtered_offer_1.getText().toString()).equals("prod_2test_filterTab_1"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys("30").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
				Thread.sleep(1000);
			}
					
			if(!(filtered_offer_4.isDisplayed()))
			{
			actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[1]"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
			Thread.sleep(2000);
			}
		}
		
	}
	
	@Then("^Check_filter_operation_in_products_tab_with_ServiceLeg$")
	public void Check_filter_operation_in_products_tab_with_ServiceLeg() throws Throwable
	{
		String product_name = "prod_2test_filterTab";
		eh.setExcelFile("Offer_Creation","offer_creation_specific_cases");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
		Thread.sleep(2000);
		offer_creation.offer_creation_details_tab(eh.getCell(1, 0), eh.getCell(1, 1), eh.getCell(1, 2), eh.getCell(1, 3), eh.getCell(1, 4), eh.getCell(1, 5), eh.getCell(1, 6));
//click on filter button****************
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
//Checking Product name field***********
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(product_name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
			
		WebElement filtered_offer_1 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[1]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_2 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[2]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_3 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[3]/data-table-row/div[1]/data-table-cell[1]/span"));
		WebElement filtered_offer_4 = driver.findElement(By.xpath("//div[@class='style-scope iron-list']/div[4]/data-table-row/div[1]/data-table-cell[1]/span"));
				
		if(filtered_offer_1.getText().toString().contains(product_name) && 
				filtered_offer_2.getText().toString().contains(product_name) && 
					filtered_offer_3.getText().toString().contains(product_name) && 
						filtered_offer_4.getText().toString().contains(product_name))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys("20").build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
			Thread.sleep(1000);

			if (!(filtered_offer_1.getText().toString()).equals("prod_2test_filterTab_1"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
				Thread.sleep(1000);
				actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys("30").build().perform();
				actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
				Thread.sleep(1000);
			}
						
			if(!(filtered_offer_4.isDisplayed()))
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
					Thread.sleep(1000);
					actions.moveToElement(driver.findElement(By.xpath("//div[@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
					actions.moveToElement(driver.findElement(By.xpath("//div[2][@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys("22").build().perform();
					actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
					Thread.sleep(1000);
				}
					if(!(filtered_offer_1.getText().toString().equals("prod_2test_filterTab_1")))
					{
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
						Thread.sleep(1000);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
						Thread.sleep(1000);
						actions.moveToElement(driver.findElement(By.xpath("//div[2][@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[3]"))).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
						actions.moveToElement(driver.findElement(By.xpath("//div[2][@class='layout horizontal flex style-scope data-table-column-filter-dialog']/paper-input[6]"))).click().sendKeys("32").build().perform();
						actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
						Thread.sleep(1000);
					}

						if(!(filtered_offer_4.isDisplayed()))
						{
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
							Thread.sleep(1000);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
							Thread.sleep(1000);
							actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Service Leg')]"))).click().sendKeys("Data 2G").build().perform();
							actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
							Thread.sleep(2000);
						}
					
							if(!filtered_offer_2.isDisplayed())
							{
								actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[1]"))).click().build().perform();
								actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Cancel')]"))).click().build().perform();
								Thread.sleep(2000);
							}
		}
		
	}
}
