package stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import cucumber.api.java.en.Then;

public class OfferCatalogSteps extends Init{
	public ExcelHelper eM = new ExcelHelper(); 
    public WebDriverWait wait = new WebDriverWait(driver, 15);
    public Actions action = new Actions(driver);
	   @Then("^Navigate to Offer Catalogue$")
	    public void navigatetoOfferCatalogue() throws Throwable{
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sym1' and @icon='app-primary:offer-catalogue']"))).click();
		   Thread.sleep(2000);
	    }
	   @Then("^Create New Offer Catalogue from sheet \"([^\"]*)\"$")
	    
	    public void createNewOfferCatalogueFromSheet(String sheet) throws Throwable{
	    	Thread.sleep(2000);
	 	    eM.setExcelFile("offerCatalogInputData",sheet);
	 	    Random rn = new Random();
	 		int  n = rn.nextInt(5000) + 1;
	 		String name = (String) eM.getCell(1, 0);
	 		name =  name.replaceAll("[0-9]", "")+n;
	 		eM.setCell(1, 0, name);
	 	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Create New Catalog']"))).click();
	 	   driver.findElement(By.xpath("//div[2]/paper-input[1]/paper-input-container/div[2]/div/input")).sendKeys(name);
	 	   driver.findElement(By.xpath("//paper-input[2]/paper-input-container/div[2]/div/input")).sendKeys("test");
	 	   driver.findElement(By.xpath("//div[3]/paper-button[2]")).click();
	 	   Thread.sleep(3000);
	 	   }
	   
	   @Then("^Add \"([^\"]*)\" offer to Offer Catalogue$")
	    public void addOffertoCatalogueForProduct(String sheet) throws Throwable
	    {
	     Thread.sleep(3000);
	     eM.setExcelFile("offerInputData",sheet);
	 	 Thread.sleep(2000);
	 	 driver.findElement(By.xpath("//paper-button[contains(text(),'Add Offers')]")).click();
	 	 Thread.sleep(4000);
	 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../.."))).click();
	 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/paper-input[1]/paper-input-container/div[2]/div/input"))).sendKeys(eM.getCell(1, 0));
	 	 driver.findElement(By.xpath("//paper-button[contains(text(),'Apply')]")).click();
	 	Thread.sleep(3000);
	 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[1]/data-table-cell[1][contains(.,'"+eM.getCell(1, 0)+"')]"))).click();
	 	Thread.sleep(2000);
	 	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//paper-button[text()='Add to Catalog']"))).click();
	 	 Thread.sleep(5000);
	    }
}
