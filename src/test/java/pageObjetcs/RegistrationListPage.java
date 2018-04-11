package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class RegistrationListPage extends Init{

	public RegistrationListPage() {
		PageFactory.initElements(driver, this);
	}
	JSWaiter jswait = new JSWaiter();
	
	@FindBy(xpath="//div[contains(text(),'Registration Lists')]/../..")
	private WebElement registrationListButton;
	@FindBy(xpath="//paper-button[text()='Create New Registration List']")
	private WebElement createNewRegistrationListButton;
	@FindBy(xpath=".//*[@id='createNew']//label[text()='Name']/../input")
	private WebElement registrationListName;
	@FindBy(xpath=".//*[@id='createNew']//label[text()='Description']/..//textarea")
	private WebElement registrationListDescription;
	@FindBy(xpath=".//*[@id='createNew']//label[text()='List Type']/..//input")
	private WebElement registrationListTypeSelector;
	@FindBy(xpath=".//*[@id='createNew']//paper-item[text()='Standard']")
	private WebElement registrationListTypeStandard;
	@FindBy(xpath=".//*[@id='createNew']//paper-button[text()='Save']")
	private WebElement registrationListSaveButton;
	@FindBy(xpath=".//table-select//paper-icon-button[2]")
	private WebElement registrationListSelectAllPartners;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
//	@FindBy(xpath="")
//	private WebElement registrationListButton;
	
	
	
	public void navigateToRegistrationList() throws InterruptedException {
		jswait.loadClick(registrationListButton);
	}
	public void enterRegistrationListName(String name) throws InterruptedException {
		jswait.loadSendKeys(registrationListName, name);
	}
	public void enterRegistrationListDescription(String desc) throws InterruptedException {
		jswait.loadSendKeys(registrationListDescription, desc);
	}
	public void selectRegistrationListTypeStandard() throws InterruptedException {
		jswait.loadClick(registrationListTypeSelector);
		jswait.loadClick(registrationListTypeStandard);
	}
	public void clickSaveButton() throws InterruptedException {
		jswait.loadClick(registrationListSaveButton);
	}
	public void SelectAllPartners() throws InterruptedException {
		jswait.loadClick(registrationListSelectAllPartners);
	}
	public void enterRegistratonListDetails(String name,String desc) throws InterruptedException {
		enterRegistrationListName(name);
		enterRegistrationListDescription(desc);
		selectRegistrationListTypeStandard();
		SelectAllPartners();
	}
	public void clickCreateNewRegistrationListButton() throws InterruptedException {
		jswait.loadClick(createNewRegistrationListButton);
	}
}
