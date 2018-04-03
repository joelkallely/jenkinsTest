package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class ProductClassesPageObjects extends Init{
	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public ProductClassesPageObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[contains(text(),'Product Classes')]")
	private WebElement productClasses;
	@FindBy(xpath="//paper-button[contains(text(),'Create Product Class')]")
	private WebElement createProductClassButton;
	@FindBy(xpath="//label[contains(text(),'Class Name')]/..//textarea")
	private WebElement className;
	@FindBy(xpath="//label[contains(text(),'Description')]/..//textarea")
	private WebElement classDescription;
	@FindBy(xpath=".//*[@id='addClassModal']//paper-button[contains(text(),'Save')]")
	private WebElement productClassSaveButton;
	@FindBy(xpath=".//*[@id='addClassModal']//paper-button[contains(text(),'Cancel')]")
	private WebElement productClassCancelButton;
	@FindBy(xpath="//paper-item[contains(.,'Edit')]")
	private WebElement optionsEdit;
	@FindBy(xpath="//paper-item[contains(.,'Delete')]")
	private WebElement optionsDelete;
	@FindBy(xpath="//paper-item[contains(.,'Duplicate')]")
	private WebElement optionsDuplicate;
	@FindBy(xpath="//paper-item[contains(.,'Deactivate')]")
	private WebElement optionsDeactivate;
	@FindBy(xpath="//paper-item[contains(.,'Activate')]")
	private WebElement optionsActivate;
	@FindBy(xpath="//paper-item[contains(.,'Attributes')]")
	private WebElement optionsAttributes;
	@FindBy(xpath="//paper-item[contains(.,'Share')]")
	private WebElement optionsShare;
	@FindBy(xpath="//paper-button[contains(text(),'Add Attribute')]")
	private WebElement addAttributeButton;
	@FindBy(xpath=".//*[@id='addAttrModal']//label[contains(text(),'Name')]/..//input")
	private WebElement addAttributeName;
	@FindBy(xpath=".//*[@id='addAttrModal']//label[contains(text(),'Label')]/..//input")
	private WebElement addAttributeLabel;
	@FindBy(xpath=".//*[@id='checkboxLabel'][contains(text(),'Mandatory')]")
	private WebElement addAttributeMandatoryCheckBox;
	@FindBy(xpath=".//*[@id='checkboxLabel'][contains(text(),'Allow Multiple')]")
	private WebElement addAttributeAllowMultipleCheckBox;
	
	@FindBy(xpath=".//*[@id='addAttrModal']//label[contains(text(),'Type')]/..//input")
	private WebElement addAttributeType;
	@FindBy(xpath="//paper-item[contains(.,'NUMBER')]")
	private WebElement typeNumber;
	@FindBy(xpath="//paper-item[contains(.,'TEXT')]")
	private WebElement typeText;
	@FindBy(xpath="//paper-item[contains(.,'SINGLE SELECT')]")
	private WebElement typeSingleSelect;
	@FindBy(xpath="//paper-item[contains(.,'MULTI SELECT')]")
	private WebElement typeMultiSelect;
	@FindBy(xpath="//paper-item[contains(.,'COMBO')]")
	private WebElement typeCombo;
	@FindBy(xpath=".//*[@id='addAttrModal']//label[contains(text(),'Default Value')]/..//input")
	private WebElement addAttributeDefaultValue;
	@FindBy(xpath=".//div[contains(@class,'optionsArea ')]//label[contains(text(),'Name')]/..//input")
	private WebElement selectOptionName;
	@FindBy(xpath=".//div[contains(@class,'optionsArea ')]//label[contains(text(),'Label')]/..//input")
	private WebElement selectOptionLabel;
	@FindBy(xpath=".//div[contains(@class,'optionsArea ')]//*[@id='icon']/..")
	private WebElement selectOptionsAddNew;
	@FindBy(xpath=".//div[contains(@class,'optionsArea ')]//div[contains(@class,'option-row')][2]//label[contains(text(),'Label')]/..//input")
	private WebElement selectOptionLabel2;
	@FindBy(xpath=".//div[contains(@class,'optionsArea ')]//div[contains(@class,'option-row')][2]//label[contains(text(),'Name')]/..//input")
	private WebElement selectOptionName2;
	@FindBy(xpath=".//*[@id='addAttrModal']//paper-button[contains(text(),'Save')]")
	private WebElement addAttributeSave;
	@FindBy(xpath=".//*[@id='addAttrModal']//paper-button[contains(text(),'Cancel')]")
	private WebElement addAttributeCancel;
	@FindBy(xpath="//paper-item[contains(.,'Add Sub-Attribute')]")
	private WebElement addSubAttributeButton;
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
	public void navigateToProductClasses() throws InterruptedException {
		jswait.loadClick(productClasses);
	}
	public void clickCreateProcutClassSave() throws InterruptedException {
		jswait.loadClick(productClassSaveButton);
	}
	public void clickAddSubAttribute() throws InterruptedException {
		jswait.loadClick(addSubAttributeButton);
	}
	public void clickCreateProcutClassButton() throws InterruptedException {
		jswait.loadClick(createProductClassButton);
	}
	public void clickselectOptionsAddNew() throws InterruptedException {
		jswait.loadClick(selectOptionsAddNew);
	}
	public void clickEdit() throws InterruptedException {
		jswait.loadClick(optionsEdit);
	}
	public void clickDelete() throws InterruptedException {
		jswait.loadClick(optionsDelete);
	}
	public void clickDuplicate() throws InterruptedException {
		jswait.loadClick(optionsDuplicate);
	}
	public void clickActivate() throws InterruptedException {
		jswait.loadClick(optionsActivate);
	}
	public void clickDeactivate() throws InterruptedException {
		jswait.loadClick(optionsDeactivate);
	}
	public void clickAttributes() throws InterruptedException {
		jswait.loadClick(optionsAttributes);
	}
	public void clickShare() throws InterruptedException {
		jswait.loadClick(optionsShare);
	}
	public void clickAddAttributeSave() throws InterruptedException {
		jswait.loadClick(addAttributeSave);
	}
	public void clickAddAttributeCancel() throws InterruptedException {
		jswait.loadClick(addAttributeCancel);
	}
	public void clickCreateProcutClassCancel() throws InterruptedException {
		jswait.loadClick(productClassCancelButton);
	}
	public void clickAddAttribute() throws InterruptedException {
		jswait.loadClick(addAttributeButton);
	}
	public void enterClassName(String name) throws InterruptedException {
		jswait.loadSendKeys(className, name);
	}
	public void enterClassDescription(String desc) throws InterruptedException {
		jswait.loadSendKeys(classDescription, desc);
	}
	public void enterAttributeName(String name) throws InterruptedException {
		jswait.loadSendKeys(addAttributeName, name);
	}
	public void enterAttributeLabel(String label) throws InterruptedException {
		jswait.loadSendKeys(addAttributeLabel, label);
	}
	public void enterDefaultValue(String def) throws InterruptedException {
		jswait.loadSendKeys(addAttributeDefaultValue, def);
	}
	public void clickMandatory() throws InterruptedException {
		jswait.loadClick(addAttributeMandatoryCheckBox);
	}
	public void clickAllowMultiple() throws InterruptedException {
		jswait.loadClick(addAttributeAllowMultipleCheckBox);
	}
	public void selectType(String type) throws InterruptedException {
		jswait.loadClick(addAttributeType);
		if(type=="NUMBER")
			jswait.loadClick(typeNumber);
		else if(type=="TEXT")
			jswait.loadClick(typeText);
		else if(type=="SINGLE SELECT")
			jswait.loadClick(typeSingleSelect);
		else if(type=="MULTI SELECT")
			jswait.loadClick(typeMultiSelect);
		else if(type=="COMBO")
			jswait.loadClick(typeCombo);
	}
	public void createProductClass(String name,String desc) throws InterruptedException {
		clickCreateProcutClassButton();
		enterClassName(name);
		enterClassDescription(desc);
		clickCreateProcutClassSave();
	}
	public void addOption1() throws InterruptedException{
		jswait.loadSendKeys(selectOptionName, "option1");
		jswait.loadSendKeys(selectOptionLabel, "label1");
	}
	public void addOption2() throws InterruptedException{
		jswait.loadSendKeys(selectOptionName2, "option2");
		jswait.loadSendKeys(selectOptionLabel2, "label2");
	}
	public void addComboAttribute() throws InterruptedException{
		clickAddAttribute();
		enterAttributeName("comboAttr");
		enterAttributeLabel("COMBOATTR");
		selectType("COMBO");
		clickAddAttributeSave();
		jswait.loadClick("//span[contains(.,'comboAttr')]/../..//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..");
		clickAddSubAttribute();
		enterAttributeName("numCombo");
		enterAttributeLabel("NUMCOMBO");
		selectType("NUMBER");
		enterDefaultValue("18");
		clickAddAttributeSave();
		
	}
	
	public void addDefaultAttributes() throws InterruptedException {
		//first attribute
		clickAddAttribute();
		enterAttributeName("num");
		enterAttributeLabel("NUM");
		selectType("NUMBER");
		enterDefaultValue("181");
		clickAddAttributeSave();
		//second attribute
		clickAddAttribute();
		enterAttributeName("txt");
		enterAttributeLabel("TXT");
		selectType("TEXT");
		enterDefaultValue("New");
		clickAddAttributeSave();
		//single select attribute
		clickAddAttribute();
		enterAttributeName("ss");
		enterAttributeLabel("SS");
		selectType("SINGLE SELECT");
		addOption1();
		clickselectOptionsAddNew();
		addOption2();
		clickAddAttributeSave();
		
		//multi select attribute
		clickAddAttribute();
		enterAttributeName("ms");
		enterAttributeLabel("MS");
		selectType("MULTI SELECT");
		addOption1();
		clickselectOptionsAddNew();
		addOption2();
		clickAddAttributeSave();
		//combo attribute
		addComboAttribute();
		//allow multiple attribute
				clickAddAttribute();
				enterAttributeName("numAllowMultiple");
				enterAttributeLabel("NUMAllowMultiple");
				clickAllowMultiple();
				selectType("NUMBER");
				enterDefaultValue("666");
				clickAddAttributeSave();
				//non mandatory attribute
				clickAddAttribute();
				enterAttributeName("notMandatory");
				enterAttributeLabel("NOTMANDATORY");
				clickMandatory();
				selectType("NUMBER");
				clickAddAttributeSave();
	}
}
