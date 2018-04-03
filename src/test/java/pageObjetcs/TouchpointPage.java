package pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class TouchpointPage extends Init{
	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public TouchpointPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[text()='Create New Touchpoint']")
	private WebElement clickCreateNewTouchpoint;
	//ussd touchpoint objects
	@FindBy(xpath=".//*[text()='USSD']")
	private WebElement ussdTouchpoints;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'Ordering Logic')]/../input")
	private WebElement ussdFormOrderingLogicSelector;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'Ordering Rule')]/../input")
	private WebElement ussdFormOrderingRuleSelector;
	@FindBy(xpath="//form[@id='ussdForm']//paper-item[contains(.,'FIFO')]")
	private WebElement ussdFormOrderingRuleFIFO;
	@FindBy(xpath="//form[@id='ussdForm']//paper-item[contains(.,'Rule-based')]")
	private WebElement ussdFormOrderingLogicRuleBased;
	@FindBy(xpath="//form[@id='ussdForm']//paper-item[contains(.,'Hours')]")
	private WebElement ussdFormTimeInterval1;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'Time Interval')]/../..//input")
	private WebElement ussdFormTimeIntervalSelector;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'Touchpoint Name')]/../input")
	private WebElement ussdFormTouchpointName;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'Refresh Every')]/../input")
	private WebElement ussdFormRefreshEvery;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'Maximum offers')]/../input")
	private WebElement ussdFormMaximumOffers;
	@FindBy(xpath=".//*[@id='ussdForm']//paper-button[contains(.,'Save')]")
	private WebElement ussdFormSaveButton;
	@FindBy(xpath=".//*[@id='ussdForm']//paper-button[contains(.,'Cancel')]")
	private WebElement ussdFormCancelButton;
	@FindBy(xpath=".//*[@id='addUssdModal']")
	private WebElement ussdFormDialogBox;
	@FindBy(xpath=".//*[@id='addUssdModal']//h2")
	private WebElement ussdFormHeading;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'USSD Application')]/../input")
	private WebElement ussdFormUssdApplicationSelector;
	@FindBy(xpath="//form[@id='ussdForm']//label[contains(.,'USSD Application')]/../../../../../..//paper-item")
	private WebElement ussdFormUssdApplication1;
	
	
	
	//api touchpoint objects
	@FindBy(xpath=".//*[text()='API']")
	private WebElement apiTouchpoints;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Ordering Logic')]/../input")
	private WebElement apiFormOrderingLogicSelector;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Ordering Rule')]/../input")
	private WebElement apiFormOrderingRuleSelector;
	@FindBy(xpath="//form[@id='apiForm']//paper-item[contains(.,'FIFO')]")
	private WebElement apiFormOrderingRuleFIFO;
	@FindBy(xpath="//form[@id='apiForm']//paper-item[contains(.,'Rule-based')]")
	private WebElement apiFormOrderingLogicRuleBased;
	@FindBy(xpath="//form[@id='apiForm']//paper-item[contains(.,'Hours')]")
	private WebElement apiFormTimeInterval1;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Time Interval')]/../..//input")
	private WebElement apiFormTimeIntervalSelector;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Touchpoint Name')]/../input")
	private WebElement apiFormTouchpointName;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Refresh Every')]/../input")
	private WebElement apiFormRefreshEvery;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Maximum offers')]/../input")
	private WebElement apiFormMaximumOffers;
	@FindBy(xpath=".//*[@id='apiForm']//paper-button[contains(.,'Save')]")
	private WebElement apiFormSaveButton;
	@FindBy(xpath=".//*[@id='apiForm']//paper-button[contains(.,'Cancel')]")
	private WebElement apiFormCancelButton;
	@FindBy(xpath=".//*[@id='addApiModal']")
	private WebElement apiFormDialogBox;
	@FindBy(xpath=".//*[@id='addApiModal']//h2")
	private WebElement apiFormHeading;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Application Type')]/../..//input")
	private WebElement apiFormApplicationType;
	@FindBy(xpath="//form[@id='apiForm']//label[contains(.,'Event For Tracking')]/../..//input")
	private WebElement apiFormEventForTracking;
	@FindBy(xpath="//paper-item[contains(.,'General')]")
	private WebElement apiFormApplicationTypeGeneral;
	@FindBy(xpath="//paper-item[contains(.,'Accepted Event')]")
	private WebElement apiFormEventForTrackingAcceptedEvent;
	
	
	
	//sms touchpoint objects
	@FindBy(xpath=".//*[text()='SMS']")
	private WebElement smsTouchpoints;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Short Code')]/../input")
	private WebElement smsFormShortCodeSelector;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Keyword')]/../input")
	private WebElement smsFormKeywordInput;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Ordering Logic')]/../input")
	private WebElement smsFormOrderingLogicSelector;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Ordering Rule')]/../input")
	private WebElement smsFormOrderingRuleSelector;
	@FindBy(xpath="//form[@id='smsForm']//paper-item[contains(.,'FIFO')]")
	private WebElement smsFormOrderingRuleFIFO;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Short Code')]/../../../../../..//div[contains(@class,'selectable-content')]/paper-item[1]")
	private WebElement smsFormShortCode1;
	@FindBy(xpath="//form[@id='smsForm']//paper-item[contains(.,'Rule-based')]")
	private WebElement smsFormOrderingLogicRuleBased;
	@FindBy(xpath="//form[@id='smsForm']//paper-item[contains(.,'Hours')]")
	private WebElement smsFormTimeInterval1;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Time Interval')]/../..//input")
	private WebElement smsFormTimeIntervalSelector;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Touchpoint Name')]/../input")
	private WebElement smsFormTouchpointName;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Refresh Every')]/../input")
	private WebElement smsFormRefreshEvery;
	@FindBy(xpath="//form[@id='smsForm']//label[contains(.,'Maximum offers')]/../input")
	private WebElement smsFormMaximumOffers;
	@FindBy(xpath=".//*[@id='smsForm']//paper-button[contains(.,'Save')]")
	private WebElement smsFormSaveButton;
	@FindBy(xpath=".//*[@id='smsForm']//paper-button[contains(.,'Cancel')]")
	private WebElement smsFormCancelButton;
	@FindBy(xpath=".//*[@id='addSmsModal']")
	private WebElement smsFormDialogBox;
	@FindBy(xpath=".//*[@id='addSmsModal']//h2")
	private WebElement smsFormHeading;
//	@FindBy(xpath="")
//	private WebElement ;
	
	//customer care touchpoint objects
	@FindBy(xpath=".//*[text()='Customer Care']")
	private WebElement customerCareTouchpoints;
	@FindBy(xpath=".//*[@id='addCustomerForm']//label[contains(.,'Maximum offers')]/../input")
	private WebElement customerCareFormMaximumOffers;
	@FindBy(xpath=".//*[@id='addCustomerCare']//paper-button[contains(.,'Save')]")
	private WebElement customerCareFormSaveButton;
	@FindBy(xpath=".//*[@id='addCustomerCare']//paper-button[contains(.,'Cancel')]")
	private WebElement customerCareFormCancelButton;
	@FindBy(xpath=".//*[@id='addCustomerCare']//h2")
	private WebElement customerCareFormHeading;
	@FindBy(xpath=".//*[@id='addCustomerCare']")
	private WebElement customerCareForm;
	@FindBy(xpath="//form[@id='addCustomerForm']//label[contains(.,'Ordering Logic')]/../input")
	private WebElement customerCareFormOrderingLogicSelector;
	@FindBy(xpath="//form[@id='addCustomerForm']//label[contains(.,'Ordering Rule')]/../input")
	private WebElement customerCareFormOrderingRuleSelector;
	@FindBy(xpath="//form[@id='addCustomerForm']//paper-item[contains(.,'FIFO')]")
	private WebElement customerCareFormOrderingRuleFIFO;
	@FindBy(xpath="//form[@id='addCustomerForm']//paper-item[contains(.,'Rule-based')]")
	private WebElement customerCareFormOrderingLogicRuleBased;
	@FindBy(xpath="//form[@id='addCustomerForm']//paper-item[contains(.,'Hours')]")
	private WebElement customerCareFormTimeInterval1;
	@FindBy(xpath="//form[@id='addCustomerForm']//label[contains(.,'Time Interval')]/../..//input")
	private WebElement customerCareFormTimeIntervalSelector;
	@FindBy(xpath="//form[@id='addCustomerForm']//label[contains(.,'Refresh Every')]/../input")
	private WebElement customerCareFormRefreshEvery;
	@FindBy(xpath=".//*[@id='addTriggerModal']")
	private WebElement customerCareFormDialogBox;
	@FindBy(xpath=".//*[@id='addCustomerForm']//label[contains(.,'Touchpoint Name')]/../input")
	private WebElement customerCareFormTouchpointName;
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
	
	//trigger touchpoint objects
	@FindBy(xpath=".//*[text()='Trigger']")
	private WebElement triggerTouchpoint;
	@FindBy(xpath=".//form[@id='triggerForm']//label[contains(.,'Trigger')]/../input")
	private WebElement selectTrigger;
	@FindBy(xpath="//form[@id='triggerForm']//label[contains(.,'Touchpoint Name')]/../input")
	private WebElement triggerTouchpointName;
	@FindBy(xpath=".//*[@id='select']/div/paper-item[1]")
	private WebElement triggerFormTriggerSelect;
	@FindBy(xpath="//form[@id='triggerForm']//label[contains(.,'Ordering Logic')]/../input")
	private WebElement triggerFormOrderingLogicSelector;
	@FindBy(xpath="//form[@id='triggerForm']//label[contains(.,'Ordering Rule')]/../input")
	private WebElement triggerFormOrderingRuleSelector;
	@FindBy(xpath="//form[@id='triggerForm']//paper-item[contains(.,'FIFO')]")
	private WebElement triggerFormOrderingRuleFIFO;
	@FindBy(xpath="//form[@id='triggerForm']//paper-item[contains(.,'Rule-based')]")
	private WebElement triggerFormOrderingLogicRuleBased;
	@FindBy(xpath="//form[@id='triggerForm']//paper-item[contains(.,'Hours')]")
	private WebElement triggerFormTimeInterval1;
	@FindBy(xpath="//form[@id='triggerForm']//label[contains(.,'Time Interval')]/../..//input")
	private WebElement triggerFormTimeIntervalSelector;
	@FindBy(xpath="//form[@id='triggerForm']//label[contains(.,'Refresh Every')]/../input")
	private WebElement triggerFormRefreshEvery;
	@FindBy(xpath="//form[@id='triggerForm']//label[contains(.,'Maximum offers')]/../input")
	private WebElement triggerFormMaximumOffers;
	@FindBy(xpath=".//*[@id='triggerForm']//paper-button[contains(.,'Save')]")
	private WebElement triggerFormSaveButton;
	@FindBy(xpath=".//*[@id='triggerForm']//paper-button[contains(.,'Cancel')]")
	private WebElement triggerFormCancelButton;
	@FindBy(xpath=".//*[@id='addTriggerModal']")
	private WebElement triggerFormDialogBox;
	@FindBy(xpath=".//*[@id='addTriggerModal']//h2")
	private WebElement triggerFormHeading;
	@FindBy(xpath=".//*[@id='triggerDataTable']//div[@id='items']/div[1]/data-table-row//paper-icon-button")
	private WebElement triggerTouchpointDelete;
	@FindBy(xpath="//div[@val='trigger']//*[@id='deleteTP']//paper-button[contains(.,'Yes')]")
	private WebElement triggerDeleteYes;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;



	public void navigateToSms() throws InterruptedException {
		jswait.loadClick(smsTouchpoints);
	}
	public void navigateToUssd() throws InterruptedException {
		jswait.loadClick(ussdTouchpoints);
	}
	public void navigateToTrigger() throws InterruptedException {
		jswait.loadClick(triggerTouchpoint);
	}
	public void navigateToApi() throws InterruptedException {
		jswait.loadClick(apiTouchpoints);
	}
	public void navigateToCustomerCare() throws InterruptedException {
		jswait.loadClick(customerCareTouchpoints);
	}
	public void clickCreateNewTouchpoint() throws InterruptedException {
		jswait.loadClick(clickCreateNewTouchpoint);
	}
	
	//sms touchpoint functions
	public void smsClickSave() throws InterruptedException {
		jswait.loadClick(smsFormSaveButton);
	}
	public void smsClickCancel() throws InterruptedException {
		jswait.loadClick(smsFormCancelButton);
	}
	public void smsSelectShortCode() throws InterruptedException {
		jswait.loadClick(smsFormShortCodeSelector);
		jswait.loadClick(smsFormShortCode1);
	}
	public void smsEnterKeyword(String name) throws InterruptedException {
		jswait.loadSendKeys(smsFormKeywordInput, name);
	}
	public void smsSelectOrderingLogic() throws InterruptedException {
		jswait.loadClick(smsFormOrderingLogicSelector);
		jswait.loadClick(smsFormOrderingLogicRuleBased);
	}
	public void smsSelectOrderingRule() throws InterruptedException {
		jswait.loadClick(smsFormOrderingRuleSelector);
		jswait.loadClick(smsFormOrderingRuleFIFO);
	}
	public void smsEnterRefreshEvery(String name) throws InterruptedException {
		jswait.loadSendKeys(smsFormRefreshEvery, name);
	}
	public void smsSelectTimeInterval() throws InterruptedException {
		jswait.loadClick(smsFormTimeIntervalSelector);
		jswait.loadClick(smsFormTimeInterval1);
	}
	public void smsEnterMaximumOffers(String name) throws InterruptedException {
		jswait.loadSendKeys(smsFormMaximumOffers, name);
	}
	public void enterSmsTouchpointDetails(String keyword) throws InterruptedException {
		smsEnterKeyword(keyword);
		smsSelectShortCode();
		smsSelectOrderingLogic();
		smsSelectOrderingRule();
		smsEnterRefreshEvery("3");
		smsSelectTimeInterval();
		smsEnterMaximumOffers("5");
	}
	public void createSmsTouchpoint(String keyword) throws InterruptedException {
		clickCreateNewTouchpoint();
		enterSmsTouchpointDetails(keyword);
		smsClickSave();
	}
	public String getSmsFormHeading() throws InterruptedException {
		Exception wrongForm = new Exception("wrong form displayed");
		try{
			smsFormDialogBox.getAttribute("display");
			throw wrongForm;
		}catch(Exception e) {
			
		}
		jswait.waitUntil(smsFormHeading);
		return smsFormHeading.getText();
	}
	
	//trigger touchpoint functions
	public void triggerEnterTouchpointName(String name) throws InterruptedException {
		jswait.loadSendKeys(triggerTouchpointName, name);
	}
	public void selectTrigger() throws InterruptedException {
		jswait.loadClick(selectTrigger);
		jswait.loadClick(triggerFormTriggerSelect);
	}
	public void triggerClickSave() throws InterruptedException {
		jswait.loadClick(triggerFormSaveButton);
	}
	public void triggerClickCancel() throws InterruptedException {
		jswait.loadClick(triggerFormCancelButton);
	}
	public void triggerSelectOrderingLogic() throws InterruptedException {
		jswait.loadClick(triggerFormOrderingLogicSelector);
		jswait.loadClick(triggerFormOrderingLogicRuleBased);
	}
	public void triggerSelectOrderingRule() throws InterruptedException {
		jswait.loadClick(triggerFormOrderingRuleSelector);
		jswait.loadClick(triggerFormOrderingRuleFIFO);
	}
	public void triggerEnterRefreshEvery(String name) throws InterruptedException {
		jswait.loadSendKeys(triggerFormRefreshEvery, name);
	}
	public void triggerSelectTimeInterval() throws InterruptedException {
		jswait.loadClick(triggerFormTimeIntervalSelector);
		jswait.loadClick(triggerFormTimeInterval1);
	}
	public void triggerEnterMaximumOffers(String name) throws InterruptedException {
		jswait.loadSendKeys(triggerFormMaximumOffers, name);
	}
	public void enterTriggerTouchpointDetails(String name) throws InterruptedException {
		triggerEnterTouchpointName(name);
		selectTrigger();
		triggerSelectOrderingLogic();
		triggerSelectOrderingRule();
		triggerEnterRefreshEvery("3");
		triggerSelectTimeInterval();
		triggerEnterMaximumOffers("5");
	}
	public void createTriggerTouchpoint(String keyword) throws InterruptedException {
		clickCreateNewTouchpoint();
		enterTriggerTouchpointDetails(keyword);
		triggerClickSave();
	}
	//customer care functions
	public void customerCareSelectOrderingLogic() throws InterruptedException {
		jswait.loadClick(customerCareFormOrderingLogicSelector);
		jswait.loadClick(customerCareFormOrderingLogicRuleBased);
	}
	public void customerCareSelectOrderingRule() throws InterruptedException {
		jswait.loadClick(customerCareFormOrderingRuleSelector);
		jswait.loadClick(customerCareFormOrderingRuleFIFO);
	}
	public void customerCareEnterRefreshEvery(String name) throws InterruptedException {
		jswait.loadSendKeys(customerCareFormRefreshEvery, name);
	}
	public void customerCareSelectTimeInterval() throws InterruptedException {
		jswait.loadClick(customerCareFormTimeIntervalSelector);
		jswait.loadClick(customerCareFormTimeInterval1);
	}
	public void customerCareEnterMaximumOffers(String name) throws InterruptedException {
		jswait.loadSendKeys(customerCareFormMaximumOffers, name);
	}
	public void enterCustomerCareTouchpointDetails(String keyword) throws InterruptedException {
		customerCareEnterTouchpointName(keyword);
		customerCareSelectOrderingLogic();
		customerCareSelectOrderingRule();
		customerCareEnterRefreshEvery("3");
		customerCareSelectTimeInterval();
		customerCareEnterMaximumOffers("5");
	}
	public void createCustomerCareTouchpoint(String keyword) throws InterruptedException {
		clickCreateNewTouchpoint();
		enterCustomerCareTouchpointDetails(keyword);
		customerCareClickSave();
	}
	public void customerCareEnterTouchpointName(String name) throws InterruptedException {
		jswait.loadSendKeys(customerCareFormTouchpointName, name);
	}
	public void customerCareEnterMaximumOffers() throws InterruptedException {
		jswait.loadSendKeys(customerCareFormMaximumOffers, "5");
	}
	public void customerCareClickSave() throws InterruptedException {
		jswait.loadClick(customerCareFormSaveButton);
	}
	public void customerCareClickCancel() throws InterruptedException {
		jswait.loadClick(customerCareFormCancelButton);
	}
	public String getCustomerCareFormHeading() throws InterruptedException {
		jswait.waitUntil(customerCareFormHeading);
		return customerCareFormHeading.getText();
	}
	public boolean checkCustomerCareFormDisplayed() {
		if(customerCareForm.isDisplayed())
			return true;
		return false;
	}
	//api touchpoint functions
	public void apiEnterTouchpointName(String name) throws InterruptedException {
		jswait.loadSendKeys(apiFormTouchpointName, name);
	}
		public void apiClickSave() throws InterruptedException {
			jswait.loadClick(apiFormSaveButton);
		}
		public void apiClickCancel() throws InterruptedException {
			jswait.loadClick(apiFormCancelButton);
		}
		public void apiSelectOrderingLogic() throws InterruptedException {
			jswait.loadClick(apiFormOrderingLogicSelector);
			jswait.loadClick(apiFormOrderingLogicRuleBased);
		}
		public void apiSelectOrderingRule() throws InterruptedException {
			jswait.loadClick(apiFormOrderingRuleSelector);
			jswait.loadClick(apiFormOrderingRuleFIFO);
		}
		public void apiEnterRefreshEvery(String name) throws InterruptedException {
			jswait.loadSendKeys(apiFormRefreshEvery, name);
		}
		public void apiSelectTimeInterval() throws InterruptedException {
			jswait.loadClick(apiFormTimeIntervalSelector);
			jswait.loadClick(apiFormTimeInterval1);
		}
		public void apiSelectApplicationType() throws InterruptedException {
			jswait.loadClick(apiFormApplicationType);
			jswait.loadClick(apiFormApplicationTypeGeneral);
			
		}
		public void apiSelectEventForTracking() throws InterruptedException {
			jswait.loadClick(apiFormEventForTracking);
			jswait.loadClick(apiFormEventForTrackingAcceptedEvent);
		}
		public void apiEnterMaximumOffers(String name) throws InterruptedException {
			jswait.loadSendKeys(apiFormMaximumOffers, name);
		}
		public void enterApiTouchpointDetails(String keyword) throws InterruptedException {
			apiEnterTouchpointName(keyword);
			apiSelectApplicationType();
			apiSelectEventForTracking();
			apiSelectOrderingLogic();
			apiSelectOrderingRule();
			apiEnterRefreshEvery("3");
			apiSelectTimeInterval();
			apiEnterMaximumOffers("5");
		}
		public void createApiTouchpoint(String keyword) throws InterruptedException {
			clickCreateNewTouchpoint();
			enterApiTouchpointDetails(keyword);
			apiClickSave();
		}
		public String getApiFormHeading() throws InterruptedException {
			Exception wrongForm = new Exception("wrong form displayed");
			try{
				smsFormDialogBox.getAttribute("display");
				throw wrongForm;
			}catch(Exception e) {
				
			}
			jswait.waitUntil(smsFormHeading);
			return smsFormHeading.getText();
		}
		//ussd touchpoint functions
		public void ussdEnterTouchpointName(String name) throws InterruptedException {
			jswait.loadSendKeys(ussdFormTouchpointName, name);
		}
			public void ussdClickSave() throws InterruptedException {
				jswait.loadClick(ussdFormSaveButton);
			}
			public void ussdClickCancel() throws InterruptedException {
				jswait.loadClick(ussdFormCancelButton);
			}
			public void ussdSelectOrderingLogic() throws InterruptedException {
				jswait.loadClick(ussdFormOrderingLogicSelector);
				jswait.loadClick(ussdFormOrderingLogicRuleBased);
			}
			public void ussdSelectOrderingRule() throws InterruptedException {
				jswait.loadClick(ussdFormOrderingRuleSelector);
				jswait.loadClick(ussdFormOrderingRuleFIFO);
			}
			public void ussdEnterRefreshEvery(String name) throws InterruptedException {
				jswait.loadSendKeys(ussdFormRefreshEvery, name);
			}
			public void ussdSelectTimeInterval() throws InterruptedException {
				jswait.loadClick(ussdFormTimeIntervalSelector);
				jswait.loadClick(ussdFormTimeInterval1);
			}
			public void ussdSelectUssdApplication() throws InterruptedException {
				jswait.loadClick(ussdFormUssdApplicationSelector);
				jswait.loadClick(ussdFormUssdApplication1);
				
			}
			public void ussdEnterMaximumOffers(String name) throws InterruptedException {
				jswait.loadSendKeys(ussdFormMaximumOffers, name);
			}
			public void enterUssdTouchpointDetails(String keyword) throws InterruptedException {
				ussdEnterTouchpointName(keyword);
				ussdSelectUssdApplication();
				ussdSelectOrderingLogic();
				ussdSelectOrderingRule();
				ussdEnterRefreshEvery("3");
				ussdSelectTimeInterval();
				ussdEnterMaximumOffers("5");
			}
			public void createUssdTouchpoint(String keyword) throws InterruptedException {
				clickCreateNewTouchpoint();
				enterUssdTouchpointDetails(keyword);
				ussdClickSave();
			}
			public String getUssdFormHeading() throws InterruptedException {
				Exception wrongForm = new Exception("wrong form displayed");
				try{
					smsFormDialogBox.getAttribute("display");
					throw wrongForm;
				}catch(Exception e) {
					
				}
				jswait.waitUntil(smsFormHeading);
				return smsFormHeading.getText();
			}
			public void deleteTriggerTouchpoint(String name) throws InterruptedException{
				jswait.loadClick("//data-table-cell[contains(.,'"+name+"')]/..//paper-icon-button");
				jswait.loadClick(triggerDeleteYes);
			}
			public void checkTriggerMandatoryFields() throws InterruptedException{
				clickCreateNewTouchpoint();
				triggerEnterTouchpointName("mandatory");
				triggerClickSave();
				selectTrigger();
				triggerClickSave();
				triggerSelectOrderingLogic();
				triggerClickSave();
				triggerSelectOrderingRule();
				triggerClickSave();
				triggerEnterRefreshEvery("3");
				triggerClickSave();
				triggerSelectTimeInterval();
				triggerClickSave();
				triggerEnterMaximumOffers("5");
			}

}
