package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class OfferPageObjects extends Init{
	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public OfferPageObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=".//*[@id='sym2']")
	private WebElement offerButton;
	@FindBy(xpath="//paper-button[contains(.,'Create New Offer')]")
	private WebElement createNewOfferButton;
	@FindBy(xpath="//label[contains(text(),'Offer Name')]/../..//input")
	private WebElement offerName;
	@FindBy(xpath="//label[contains(text(),'Description')]/../..//textarea")
	private WebElement offerDescription;
	@FindBy(xpath="//label[contains(.,'Offer Type')]/../..//input")
	private WebElement offerType;
	@FindBy(xpath="//label[contains(.,'Channel')]/../..//input")
	private WebElement offerChannel;
	@FindBy(xpath="//label[contains(.,'Category')]/../..//input")
	private WebElement offerCategory;
	@FindBy(xpath="//paper-button[contains(.,'Proceed')]")
	private WebElement offerProceedButton;
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
	
	//offer page functions
			public void navigateToOffer() throws InterruptedException {
				jswait.loadClick(offerButton);
			}
			public void enterOfferName(String name) throws InterruptedException {
				jswait.loadSendKeys(offerName,name);
			}
			public void enterOfferDescription(String desc) throws InterruptedException {
				jswait.loadSendKeys(offerDescription,desc);
			}
			public void clickCreateNewOfferButton() throws InterruptedException {
				jswait.loadClick(createNewOfferButton);
			}
			public void clickOfferType() throws InterruptedException {
				jswait.loadClick(offerType);
			}
			public void clickOfferChannel() throws InterruptedException {
				jswait.loadClick(offerChannel);
			}
			public void clickOfferCategory() throws InterruptedException {
				jswait.loadClick(offerCategory);
			}
			public void clickProceedButton() throws InterruptedException {
				jswait.loadClick(offerProceedButton);
			}
}
