package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Offer_creation_steps;
import baseClasses.browserInit;
import cucumber.api.java.en.Then;



public class Regression_offer extends browserInit 
{
	Offer_creation_steps offer_creation = new Offer_creation_steps();
	ExcelHelper eh =new ExcelHelper();
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
	
}
