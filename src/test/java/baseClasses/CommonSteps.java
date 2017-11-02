package baseClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends browserInit 
{
	WebDriverWait wait = new WebDriverWait(driver, 5);
	@Then("^navigate to products$")
	public void naviagte_to_products() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
	}
	
	@Then("^navigate to offers$")
	public void naviagte_to_offers() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym2']"))).click();
		Thread.sleep(1000);
	}
	@Then("^navigate to life cycle marketing$")
	public void naviagte_to_life_cycle_marketing() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainContainer']/paper-menu/div/hexagon-icon[3]/label/.."))).click();
		Thread.sleep(1000);
	}
	
	
	@When("^click filter button$")
    public void filter() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(1000);
	}
	
	@Then("^navigate to precision marketing$")
    public void precisionMarketing() throws InterruptedException 
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='outLogo']"))).click();
		Thread.sleep(1000);
	}
	
	@Then("^navigate to offer management$")
    public void offerManagement() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
		Thread.sleep(1000);
	}
	
	@Then("^go to landing page$")
    public void landingPage() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topBar']/a/img"))).click();
		Thread.sleep(1000);
	}

	@Then("^close browser$")
    public void closeBrowser() throws InterruptedException {
		driver.close();
	}

}
