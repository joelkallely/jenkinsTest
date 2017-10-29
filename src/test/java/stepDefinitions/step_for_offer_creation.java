package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.browserInit;

public class step_for_offer_creation extends browserInit
{
	public WebDriverWait wait = new WebDriverWait(driver, 15);
	public Actions actions = new Actions(driver);
	
	public void offer_creation_details_tab(String offer_name, String Description, String Offer_type, String Channel, String Category, String Currency, String Discount) throws Throwable
	{
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(.,'Create New Offer')]"))).click();
	Thread.sleep(2000);
	actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Offer Name')]"))).click().sendKeys(offer_name).build().perform();
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
}
