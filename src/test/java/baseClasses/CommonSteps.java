package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends browserInit 
{
	public ExcelHelper eM = new ExcelHelper(); 

	WebDriverWait wait = new WebDriverWait(driver, 5);
	@Then("^go to legacy ui$")
	public void gotoLegacy() throws Throwable{
		driver.get("http://192.168.150.208:8098");	
	}
	@Then("^navigate to landing page$")
	public void naviagte_to_landing_page() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//flytxt-breadcrumb//iron-icon"))).click();
		Thread.sleep(2000);
	}
	
	@Then("^navigate to products$")
	public void naviagte_to_products() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1']"))).click();
		Thread.sleep(2000);
	}
	@Then("^navigate to analytics$")
	public void naviagte_to_analytics() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Analytics']/.."))).click();
		Thread.sleep(2000);
	}
	@Then("^navigate to explore segments$")
	public void naviagte_to_explore_segments() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Explore Segments')]/.."))).click();
		Thread.sleep(2000);
	}
	
	@Then("^navigate to offers$")
	public void naviagte_to_offers() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym2']"))).click();
		Thread.sleep(2000);
	}
	@Then("^navigate to life cycle marketing$")
	public void naviagte_to_life_cycle_marketing() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainContainer']/paper-menu/div/hexagon-icon[3]/label/.."))).click();
		Thread.sleep(2000);
	}
	
	
	@When("^click filter button$")
    public void filter() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
		Thread.sleep(2000);
	}
	
	@Then("^navigate to precision marketing$")
    public void precisionMarketing() throws InterruptedException 
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='outLogo']"))).click();
		Thread.sleep(2000);
	}
	
	@Then("^navigate to offer management$")
    public void offerManagement() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label"))).click();
		Thread.sleep(1000);
	}
	@Then("^navigate to intent management$")
    public void intentManagement() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='Intent Management']/../.."))).click();
		Thread.sleep(1000);
	}
	@Then("^navigate to data foundation$")
    public void dataFoundation() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Data Foundation']/../../a"))).click();
		Thread.sleep(2000);
	}
	
	@Then("^go to landing page$")
    public void landingPage() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topBar']/img"))).click();
		Thread.sleep(1000);
	}
	@Then("^navigate to data fusion engine$")
	public void gotoDFE() throws Throwable{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Data Fusion Engine']/.."))).click();
		Thread.sleep(1000);
		
	}
	@Then("^close browser$")
    public void closeBrowser() throws InterruptedException {
		driver.close();
	}
}
