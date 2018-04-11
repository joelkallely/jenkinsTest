package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class CatalogPageObjects extends Init{
	public CatalogPageObjects() {
		PageFactory.initElements(driver, this);
	}
	JSWaiter jswait = new JSWaiter();
	public WebDriverWait wait = new WebDriverWait(driver, 8);
	CommonObjects commonObjects = new CommonObjects();
	@FindBy(xpath="//paper-button[text()='Create New Catalog']")
	private WebElement createNewCatalogButton;
	@FindBy(xpath="//div[2]/paper-input[1]/paper-input-container/div[2]/div/input")
	private WebElement catalogName;
	@FindBy(xpath="//paper-input[2]/paper-input-container/div[2]/div/input")
	private WebElement catalogDescription;
	@FindBy(xpath="//div[3]/paper-button[2]")
	private WebElement catalogSaveButton;
	@FindBy(xpath="//paper-button[contains(text(),'Add Offers')]")
	private WebElement catalogAddOffer;
	@FindBy(xpath="//paper-button[text()='Add to Catalog']")
	private WebElement addToCatalogButton;
	@FindBy(xpath="//*[@id='sym1' and @icon='app-primary:offer-catalogue']")
	private WebElement offerCatalogButton;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;

	public void enterCatalogName(String name) throws InterruptedException {
		jswait.loadSendKeys(catalogName, name);
	}
	public void enterCatalogDescription(String desc) throws InterruptedException {
		jswait.loadSendKeys(catalogDescription, desc);
	}
	public void clickCreateCatalogButton() throws InterruptedException {
		jswait.loadClick(createNewCatalogButton);
	}
	public void clickCatalogAddOffers() throws InterruptedException {
		jswait.loadClick(catalogAddOffer);
	}
	public void navigateToOfferCatalog() throws InterruptedException {
		jswait.loadClick(offerCatalogButton);
	}
	public void clickAddToCatalogButton() throws InterruptedException {
		jswait.loadClick(addToCatalogButton);
	}
	public void clickSaveCatalogButton() throws InterruptedException {
		jswait.loadClick(catalogSaveButton);
	}
	public void enterCatalogDetails(String name) throws InterruptedException {
		enterCatalogName(name);
		enterCatalogDescription("Selenium");		
	}
	public void createCatalog(String name) throws InterruptedException {
		clickCreateCatalogButton();
		enterCatalogDetails(name);
		clickSaveCatalogButton();
	}
	

}
