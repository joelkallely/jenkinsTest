package stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Then;
import pageObjetcs.CatalogPageObjects;
import pageObjetcs.CommonObjects;

public class OfferCatalogSteps extends Init{
	public ExcelHelper eM = new ExcelHelper();
	CommonObjects commonObjects = new CommonObjects();
	JSWaiter jswait = new JSWaiter();
	CatalogPageObjects catalogPageObjects = new CatalogPageObjects();
    public WebDriverWait wait = new WebDriverWait(driver, 15);
    public Actions action = new Actions(driver);
	   @Then("^Navigate to Offer Catalogue$")
	    public void navigatetoOfferCatalogue() throws Throwable{
		   catalogPageObjects.navigateToOfferCatalog();
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
	 		catalogPageObjects.createCatalog(name);
	 	   Thread.sleep(3000);
	 	   }
	   
	   @Then("^Add \"([^\"]*)\" offer to Offer Catalogue$")
	    public void addOffertoCatalogueForProduct(String sheet) throws Throwable
	    {
	     eM.setExcelFile("offerInputData",sheet);
	 	 catalogPageObjects.clickCatalogAddOffers();
	 	 commonObjects.filterName(eM.getCell(1, 0).toString());
	 	 jswait.loadClick(".//div[1]/data-table-cell[1][contains(.,'"+eM.getCell(1, 0)+"')]");
	 	 catalogPageObjects.clickAddToCatalogButton();
	    }
}
