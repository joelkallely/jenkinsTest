package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class CustomerProfilePage extends Init{
	public CustomerProfilePage() {
		PageFactory.initElements(driver, this);
	}
	JSWaiter jswait = new JSWaiter();

	@FindBy(xpath="//div[contains(text(),'Customer Profile')]/..")
	private WebElement customerProfile;
	@FindBy(xpath=".//*[@id='crumbs']/flytxt-breadcrumb[3]/paper-button[contains(text(),'Reports')]/../../flytxt-breadcrumb[4]/paper-button[contains(text(),'Customer Profile')]")
	private WebElement customerProfileBreadcrumb;	
	@FindBy(xpath="//label[contains(text(),'Customer Number')]/../input")
	private WebElement customerNumberInput;
	@FindBy(xpath="//paper-button[contains(.,'Search')]")
	private WebElement customerProfileSearchButton;
	@FindBy(xpath=".//*[@id='tabsContent']//div[contains(.,'Subscribed to Lists')]")
	private WebElement subscribedToListsTab;
	@FindBy(xpath=".//*[@id='tabsContent']//div[contains(.,'Customer Info')]")
	private WebElement customerInfoTab;
	@FindBy(xpath=".//*[@id='tabsContent']//div[contains(.,'Events')]")
	private WebElement eventsTab;
	@FindBy(xpath=".//*[@id='tabsContent']//div[contains(.,'Usage Metrics')]")
	private WebElement usageMetricsTab;
	@FindBy(xpath=".//*[@id='tabsContent']//div[contains(.,'Customer Support')]")
	private WebElement customerSupportTab;
	@FindBy(xpath="//label[contains(text(),'Customer Number')]/../../../../../../..//paper-icon-button[1]")
	private WebElement searchIcon;
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
	public void clickSearchButton() throws InterruptedException {
		jswait.loadClick(customerProfileSearchButton);
	}
	public void clickSearchIcon() throws InterruptedException {
		jswait.loadClick(searchIcon);
	}
	public void clickCustomerInfoTab() throws InterruptedException {
		jswait.loadClick(customerInfoTab);
	}
	public void clickSubscribedToListsTab() throws InterruptedException {
		jswait.loadClick(subscribedToListsTab);
	}
	public void clickEventsTab() throws InterruptedException {
		jswait.loadClick(eventsTab);
	}
	public void clickUsageMetricsTab() throws InterruptedException {
		jswait.loadClick(usageMetricsTab);
	}
	public void clickCustomerSupportTab() throws InterruptedException {
		jswait.loadClick(customerInfoTab);
	}
	public void enterValueForMsisdn(String msisdn) throws InterruptedException {
		jswait.loadSendKeys(customerNumberInput, msisdn);
	}
	public void searchMsisdn(String msisdn) throws InterruptedException {
		enterValueForMsisdn(msisdn);
		clickSearchButton();
	}
	public void navigateToCustomerProfile() throws InterruptedException {
		jswait.loadClick(customerProfile);
	}
	public boolean checkCustomerProfileBreadcrumb() throws InterruptedException{
		if(customerProfileBreadcrumb.isDisplayed()) {
			return true;
		}
		else return false;
	}

}
