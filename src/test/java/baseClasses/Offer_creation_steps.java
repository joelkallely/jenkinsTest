package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Offer_creation_steps extends browserInit 
{
	public WebDriverWait wait = new WebDriverWait(driver, 50);
	public Actions actions = new Actions(driver);
	
	public void offer_creation_details_tab(CharSequence Offer_name, CharSequence Description, CharSequence Offer_type, CharSequence Channel, CharSequence Category, CharSequence Currency, CharSequence Discount) throws Throwable
	{
	
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys(Offer_name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Description')]"))).click().sendKeys(Description).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Offer Type')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Offer_type+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Channel')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Channel+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Category')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Category+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Currency')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Currency+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Discount')]"))).click().sendKeys(Discount).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	public void Offer_creation_products_tab(CharSequence product_name , CharSequence filteration_vaue) throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Product Name')]"))).sendKeys(product_name).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]"))).click().build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'"+filteration_vaue+"')]")))).click();
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='productDialog']/div[2]/paper-button[2]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);	

	}
	
	public void offer_creation_creative_tab(CharSequence Language, CharSequence Character_set, CharSequence Title, CharSequence details) throws Throwable
	{
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Language+"')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Character_set+"')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(Title).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Details')]"))).click().sendKeys(details).build().perform(); 
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
	}
	
	public void offer_creation_creative_tab(CharSequence Language, CharSequence Character_set, CharSequence Subject, CharSequence Reference, CharSequence Optional_1, CharSequence Optional_2, CharSequence Optional_3, CharSequence Optional_4) throws Throwable
	{
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Language+"')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'"+Character_set+"')]"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Subject')]"))).click().sendKeys(Subject).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reference')]"))).click().sendKeys(Reference).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional1')]"))).click().sendKeys(Optional_1).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional2')]"))).click().sendKeys(Optional_2).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional3')]"))).click().sendKeys(Optional_3).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Optional4')]"))).click().sendKeys(Optional_4).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
	}
	
	public void offer_creation_creative_tab(CharSequence Title, CharSequence URL) throws Throwable
	{
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Language')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'English (UK)')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Character Set')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'GSM Characters')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Title')]"))).click().sendKeys(Title).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'URL')]"))).click().sendKeys(URL).build().perform(); 
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
	}
	
	public void offer_creation_track_tab() throws Throwable
	{
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(@class,'style-scope paper-input') and contains(text(),'Source')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'recharge_track')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Proceed')]"))).click().build().perform();
		Thread.sleep(2000);
	}
	
	public void offer_creation_rewards_tab() throws Throwable
	{
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'Reward Type')]"))).click().build().perform();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-item[contains(.,'ApplyPackFlow')]"))).click().build().perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//label[contains(.,'PlanValue')]"))).click().build().perform();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.cssSelector("paper-listbox.dropdown-content.style-scope.add-seeding-reward.x-scope.paper-listbox-0 paper-item:nth-child(1)"))).click().build().perform();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//paper-button[contains(.,'Save Offer')]"))).click().build().perform();
		Thread.sleep(4000);
	}

}
