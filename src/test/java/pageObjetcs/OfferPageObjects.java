package pageObjetcs;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import baseClasses.JSWaiter;

public class OfferPageObjects extends Init{
	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	CommonObjects commonObjects = new CommonObjects();
	public ExcelHelper eh = new ExcelHelper();
	public OfferPageObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=".//*[@id='sym2']")
	private WebElement offerButton;
	@FindBy(xpath="//paper-button[contains(.,'Create New Offer')]")
	private WebElement createNewOfferButton;
	@FindBy(xpath="//offer-details//label[contains(text(),'Offer Name')]/../..//input")
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
	@FindBy(xpath=".//*[@id='check']/div/iron-pages/offer-products/form/div/div[2]/paper-button")
	private WebElement offerAddProductButton;
	@FindBy(xpath="//*[@id='productDialog']/div[2]/paper-button[2]")
	private WebElement dialogBoxAddProductButton;
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
			public void clickOfferAddButton() throws InterruptedException {
				jswait.loadClick(offerAddProductButton);
			}
			public void clickDialogBoxAddButton() throws InterruptedException {
				jswait.loadClick(dialogBoxAddProductButton);
			}
			public void selectOfferType() throws InterruptedException {
				clickOfferType();
				jswait.loadClick("//paper-item[contains(.,'"+eh.getCell(1, 2)+"')]");
			}
			public void selectOfferChannel() throws InterruptedException {
				clickOfferChannel();
				jswait.loadClick("//paper-item[contains(.,'"+eh.getCell(1, 3)+"')]");
			}
			public void selectOfferCategory() throws InterruptedException {
				clickOfferCategory();
				jswait.loadClick("//paper-item[contains(.,'Combo Vouchers')]");
			}
			public void enterDetailsTabFields(String sheet) throws InterruptedException, IOException{
				eh.setExcelFile("offerInputData",sheet);
				Random rn = new Random();
				int  n = rn.nextInt(5000) + 1;
				String name = (String) eh.getCell(1, 0);
				name =  name.replaceAll("[0-9]", "")+n;
				eh.setCell(1, 0, name);
				enterOfferName(name);
				enterOfferDescription((String) eh.getCell(1, 1));
				selectOfferType();
				selectOfferChannel();
				selectOfferCategory();
			}
			public void enterProductTabFields(String productSheet) throws InterruptedException, IOException{
				ExcelHelper prodcutFile = new ExcelHelper();
				prodcutFile.setExcelFile("productInputData",productSheet);
				String productToAdd = (String) prodcutFile.getCell(1, 0);
				clickOfferAddButton();
				commonObjects.filterName(productToAdd);
				jswait.loadClick("//span[contains(.,'"+productToAdd+"')]");
				clickDialogBoxAddButton();
			}
}
