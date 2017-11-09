package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.browserInit;
import cucumber.api.java.en.Then;

public class Touch_point_creation extends browserInit
{

	@Then("^create_API_touchpoint$")
	public void create_API_touchpoint() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tabsContent']/paper-tab[5]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[contains(text(),'Create New Touchpoint')]"))).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h2[@class='style-scope api-touchpoint-grid']")).isDisplayed())
		{
		action.moveToElement(driver.findElement(By.xpath("//paper-input-container/div[2]/div/label[contains(text(),'Touchpoint Name')]"))).click().sendKeys("test").build().perform();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Touchpoint Name')]"))).click();//sendKeys("test_touchpoint");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Application Type')]"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item[1]"))).click();
		}
	}

}
