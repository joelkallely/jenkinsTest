package pageObjetcs;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class ProductPage extends Init{
	JSWaiter jswait = new JSWaiter();
	CommonObjects commonObjects =  new CommonObjects();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='sym1']")
	private WebElement productButton;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Name')]/..//input")
	private WebElement createProductName;
	@FindBy(xpath="//*[@id='form']//label[text()='Description']/..//input")
	private WebElement createProductDescription;
	@FindBy(xpath="//*[@id='form']//label[text()='Scope']/..//input")
	private WebElement createProductScopeSelector;
	@FindBy(xpath="//paper-item[contains(.,'Open')]")
	private WebElement createProductScopeOpenMarket;
	@FindBy(xpath="//paper-item[contains(.,'Open')]")
	private WebElement createProductScopeSegmented;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Category')]/..//input")
	private WebElement createProductCategorySelector;
	@FindBy(xpath="//paper-item[contains(.,'Combo Vouchers')]")
	private WebElement createProductCategoryComboVouchers;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Validity')]/..//input")
	private WebElement createProductValidity;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Price')]/..//input")
	private WebElement createProductPrice;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Processing Fee')]/..//input")
	private WebElement createProductProcessingFee;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Service Tax')]/..//input")
	private WebElement createProductServiceTax;
	@FindBy(xpath="//label[contains(.,'Service Code')]/following::input[1]")
	private WebElement createProductServiceCode;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Benefit Description')]/..//input")
	private WebElement createProductBenefitDescription;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Usage Leg')]/..//input")
	private WebElement createProductUsageLegSelector;
	@FindBy(xpath="//paper-item[contains(.,'Data 2G')]")
	private WebElement createProductUsageLeg1;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Type')]/..//input")
	private WebElement createProductTypeSelector;
	@FindBy(xpath="//paper-item[contains(.,'Data MB')]")
	private WebElement createProductType1;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'Value')]/..//input")
	private WebElement createProductValue;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'NUMCOMBO')]/..//input")
	private WebElement selClassNumCombo;
	@FindBy(xpath="//form[@id='form']/..//paper-button[contains(.,'Save')]")
	private WebElement createProductSaveButton;
	@FindBy(xpath=".//*[@id='scrollable']/div/div[2]/div/paper-button")
	private WebElement createProgramAddBenefitButton;
	@FindBy(xpath="//div[contains(@class,'benefitDiv')]//benefit-form[2]//label[contains(.,'Usage Leg')]/..//input")
	private WebElement createProductUsageLeg2Selector;
	@FindBy(xpath="//label[contains(.,'SS')]/..//input")
	private WebElement selClassSingleSelectSelector;
	@FindBy(xpath="//label[contains(.,'MS')]/../..//iron-icon")
	private WebElement selClassMultiSelectSelector;
	@FindBy(xpath="//div[contains(@class,'benefitDiv')]//benefit-form[2]//paper-item[contains(.,'Data 2G')]")
	private WebElement createProductUsageLeg2;
	@FindBy(xpath="//label[contains(.,'SS')]/../../../../../../..//paper-item[contains(.,'label2')]")
	private WebElement selClassSingleSelectOp2;
	@FindBy(xpath="//label[contains(.,'SS')]/../../../../../../..//paper-item[contains(.,'label1')]")
	private WebElement selClassSingleSelectOp1;
	@FindBy(xpath="//label[contains(.,'MS')]/../../../../../../../..//paper-item[contains(.,'label1')]")
	private WebElement selClassMultiSelectOp1;
	@FindBy(xpath="//label[contains(.,'MS')]/../../../../../../../..//paper-item[contains(.,'label2')]")
	private WebElement selClassMultiSelectOp2;
	@FindBy(xpath="//div[contains(@class,'benefitDiv')]//benefit-form[2]//label[contains(.,'Type')]/..//input")
	private WebElement createProductType2Selector;
	@FindBy(xpath="//div[contains(@class,'benefitDiv')]//benefit-form[2]//paper-item[contains(.,'Data MB')]")
	private WebElement createProductType2;
	@FindBy(xpath="//div[contains(@class,'benefitDiv')]//benefit-form[2]//label[contains(.,'Value')]/..//input")
	private WebElement createProductValue2;
	@FindBy(xpath="//paper-button[contains(.,'Create New Product')]")
	private WebElement createNewProductButton;
	@FindBy(xpath=".//*[@id='prdClsScrollThreshold']/paper-card[1]//a")
	private WebElement prepaidTelecomViewProducts;
	@FindBy(xpath="//form[@id='form']/..//paper-button[contains(.,'Cancel')]")
	private WebElement createProductCancelButton;
	@FindBy(xpath="//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")
	private WebElement productGridOptions;
	@FindBy(xpath="//*[@id='contentWrapper']/div/paper-menu/div/paper-item[2]")
	private WebElement productGridDeleteButton;
	@FindBy(xpath="//*[@id='contentWrapper']/div/paper-menu/div/paper-item[3]")
	private WebElement productGridDuplicateButton;
	@FindBy(xpath="//*[@id='contentWrapper']/div/paper-menu/div/paper-item[1]")
	private WebElement productGridEditButton;
	@FindBy(xpath="//*[@id='contentWrapper']/div/paper-menu/div/paper-item[4]")
	private WebElement productGridViewOffersButton;
	@FindBy(xpath="//*[@id='contentWrapper']/div/paper-menu/div/paper-item[5]")
	private WebElement productGridDeactivateButton;
	@FindBy(xpath="//*[@id='contentWrapper']/div/paper-menu/div/paper-item[5]")
	private WebElement productGridActivateButton;
	@FindBy(xpath=".//*[@id='deleteProduct']/div/paper-button[2]")
	private WebElement deleteConfirmYes;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'NUM')]/..//input")
	private WebElement selClassProductNUM;
	@FindBy(xpath="//*[@id='form']//label[contains(.,'TXT')]/..//input")
	private WebElement selClassProductTXT;
	String selClassProductNUMAllowMultipleXpath = "//*[@id='form']//label[contains(.,'NUMAllowMultiple')]/..//input";
	@FindBy(xpath=".//*[@id='item2']//data-table-cell[2]")
	private WebElement productCellInGrid;
	@FindBy(xpath="//*[@id='form']//*[@id='icon']")
	private WebElement allowMultipleAddButton;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
	
	
	//product page functions
		public void navigateToProduct() throws InterruptedException {
			jswait.loadClick(productButton);
		}
		public void clickDeleteConfirmYes() throws InterruptedException {
			jswait.loadClick(deleteConfirmYes);
		}
		public void clickProductDeleteButton() throws InterruptedException {
			jswait.loadClick(productGridDeleteButton);
		}
		public void clickDeactivateButton() throws InterruptedException {
			jswait.loadClick(productGridDeactivateButton);
		}
		public void clickActivateButton() throws InterruptedException {
			jswait.loadClick(productGridActivateButton);
		}
		public void clickProductDuplicateButton() throws InterruptedException {
			jswait.loadClick(productGridDuplicateButton);
		}
		public void clickProductEditButton() throws InterruptedException {
			jswait.loadClick(productGridEditButton);
		}
		public void clickProductGridOptions() throws InterruptedException {
			jswait.loadClick(productGridOptions);
		}
		public void clickCreateProductCancelButton() throws InterruptedException {
			jswait.loadClick(createProductCancelButton);
		}
		public void clickCreateNewProduct() throws InterruptedException {
			jswait.loadClick(createNewProductButton);
		}
		public void clickPrepaidTelecom() throws InterruptedException {
			jswait.loadClick(prepaidTelecomViewProducts);
		}
		public void clickCreateProductSaveButton() throws InterruptedException {
			jswait.loadClick(createProductSaveButton);
		}
		public void enterCreateProductName(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductName, name);
		}
		public void enterSelClassNum(String num) throws InterruptedException {
			jswait.loadSendKeys(selClassProductNUM, num);
		}
		public void enterSelClassTxt(String txt) throws InterruptedException {
			jswait.loadSendKeys(selClassProductTXT, txt);
		}
		public void enterCreateProductDescription(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductDescription, name);
		}
		public void selectCreateProductScopeOpenMarket() throws InterruptedException {
			jswait.loadClick(createProductScopeSelector);
			jswait.loadClick(createProductScopeOpenMarket);
		}
		public void selectCreateProductScopeSegmented() throws InterruptedException {
			jswait.loadClick(createProductScopeSelector);
			jswait.loadClick(createProductScopeSegmented);
		}
		public void selectCreateProductCategory() throws InterruptedException {
			jswait.loadClick(createProductCategorySelector);
			jswait.loadClick(createProductCategoryComboVouchers);
		}
		public void enterCreateProductValidity(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductValidity, name);
		}
		public void enterCreateProductPrice(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductPrice, name);
		}
		public void enterCreateProductProcessingFee(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductProcessingFee, name);
		}
		public void enterCreateProductServiceTax(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductServiceTax, name);
		}
		public void enterCreateProductServiceCode(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductServiceCode, name);
		}
		public void enterCreateProductBenefitDescription(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductBenefitDescription, name);
		}
		public void selectCreateProductUsageLeg() throws InterruptedException {
			jswait.loadClick(createProductUsageLegSelector);
			jswait.loadClick(createProductUsageLeg1);
		}
		public void selectCreateProductType() throws InterruptedException {
			jswait.loadClick(createProductTypeSelector);
			jswait.loadClick(createProductType1);
		}
		public void enterCreateProductValue(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductValue, name);
		}
		public void selectCreateProductUsageLeg2() throws InterruptedException {
			jswait.loadClick(createProductUsageLeg2Selector);
			jswait.loadClick(createProductUsageLeg2);
		}
		public void selectSelClassSingleSelect() throws InterruptedException {
			jswait.loadClick(selClassSingleSelectSelector);
			jswait.loadClick(selClassSingleSelectOp2);
		}
		public void selectSelClassSingleSelect2() throws InterruptedException {
			jswait.loadClick(selClassSingleSelectSelector);
			jswait.loadClick(selClassSingleSelectOp1);
		}
		public void selectSelClassMultiSelect() throws InterruptedException {
			Thread.sleep(2000);
			jswait.loadClick(selClassMultiSelectSelector);
			jswait.loadClick(selClassMultiSelectOp1);
			jswait.loadClick(selClassMultiSelectOp2);
		}
		public void selectCreateProductType2() throws InterruptedException {
			jswait.loadClick(createProductType2Selector);
			jswait.loadClick(createProductType2);
		}
		public void clickAllowMultipleAddButton() throws InterruptedException {
			jswait.loadClick(allowMultipleAddButton);
		}
		public void enterCreateProductValue2(String name) throws InterruptedException {
			jswait.loadSendKeys(createProductValue2, name);
		}
		public void enterCreateProductAllowMultipleField(String val1,String val2) throws InterruptedException {
			commonObjects.clickPlusIcon();
			List<WebElement> we = driver.findElements(By.xpath(selClassProductNUMAllowMultipleXpath));
			jswait.loadSendKeys(we.get(0), val1);
			jswait.loadSendKeys(we.get(1), val2);
			
		}
		public void enterSelClassNumCombo(String name) throws InterruptedException {
			jswait.loadSendKeys(selClassNumCombo, name);
		}
		public void enterProductDetails(String name,String scope) throws InterruptedException{
			enterCreateProductName(name);
			enterCreateProductDescription("Description for "+name);
			if(scope.contains("Open Market"))
				selectCreateProductScopeOpenMarket();
			else if(scope.contains("Segmented")) 
				selectCreateProductScopeSegmented();
			selectCreateProductCategory();
			enterCreateProductValidity("3");
			enterCreateProductPrice("100");
			enterCreateProductProcessingFee("5");
			enterCreateProductServiceTax("4");
			enterCreateProductBenefitDescription("benefit desription");
			addProductBenefit1();
		}
		public void enterSelClassProductDetails(String name) throws InterruptedException{
			enterCreateProductName(name);
			enterCreateProductDescription("Description for "+name);
			enterSelClassNum("18");
			enterSelClassTxt("TxtField");
			selectSelClassMultiSelect();
			selectSelClassSingleSelect();
			enterSelClassNumCombo("3");
			enterCreateProductAllowMultipleField("232","323");
		}
		public void createSelClassProduct(String name) throws InterruptedException {
			enterSelClassProductDetails(name);
			clickCreateProductSaveButton();
		}
		public void createProductClassWithoutAttributes(String name) throws InterruptedException {
			enterCreateProductName(name);
			enterCreateProductDescription("NO ATTRIBUTES HERE");
			clickCreateProductSaveButton();
		}
		public void verifySelClassDetailsInGrid() throws Throwable {
			jswait.waitUntil("//label[contains(.,'Product Class Name')]/../label[contains(.,'SelClass')]");
			jswait.waitUntil("//label[contains(.,'NUM')]/../label[contains(.,'18')]");
			jswait.waitUntil("//label[contains(.,'TXT')]/../label[contains(.,'TxtField')]");
			jswait.waitUntil("//label[contains(.,'SS')]/../label[contains(.,'label2')]");
			jswait.waitUntil("//label[contains(.,'MS')]/../label[contains(.,'label1,label2')]");
			jswait.waitUntil("//label[contains(.,'NUMCOMBO')]/../label[contains(.,'3')]");
		}
		public void createProduct(String name,String scope) throws InterruptedException {
			enterProductDetails(name,scope);
			clickCreateProductSaveButton();
		}
		public void addProductBenefit1() throws InterruptedException{
			selectCreateProductUsageLeg();
			selectCreateProductType();
			enterCreateProductValue("20");
		}
		public void addProductBenefit2() throws InterruptedException{
			selectCreateProductUsageLeg2();
			selectCreateProductType2();
			enterCreateProductValue2("20");
		}
		public void expandFirstProduct() throws InterruptedException{
			jswait.loadClick(productCellInGrid);
		}
		public void clickCreateProductAddBenefit() throws InterruptedException {
			jswait.loadClick(createProgramAddBenefitButton);
		}
		public void checkProductNameInGrid(String name) throws InterruptedException {
			driver.findElement(By.xpath("//span[contains(.,'"+name+"')]"));
		}
		public String getTextFromNameField() throws InterruptedException, UnsupportedFlavorException, IOException{
			String text = commonObjects.getTextFormTextField(createProductName);
			return text;
		}
		public String getTextFromDescrptionField() throws InterruptedException, UnsupportedFlavorException, IOException{
			String text = commonObjects.getTextFormTextField(createProductDescription);
			return text;
		}
		public String getTextFromNumField() throws InterruptedException, UnsupportedFlavorException, IOException{
			String text = commonObjects.getTextFormTextField(selClassProductNUM);
			return text;
		}
		public String getTextFromTxtField() throws InterruptedException, UnsupportedFlavorException, IOException{
			String text = commonObjects.getTextFormTextField(selClassProductTXT);
			return text;
		}
		public boolean checkProductGridOptions() throws InterruptedException, UnsupportedFlavorException, IOException{
			if(jswait.checkClickable(productGridDeleteButton)&&jswait.checkClickable(productGridDuplicateButton)&&jswait.checkClickable(productGridEditButton)&&jswait.checkClickable(productGridViewOffersButton)&&jswait.checkClickable(productGridDeactivateButton))
			{
				return true;
			}
			else 
				return false;
		}
		

}
