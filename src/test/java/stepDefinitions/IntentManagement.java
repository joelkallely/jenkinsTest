package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import pageObjetcs.IntentManagementPageObjects;
import pageObjetcs.ProgramPage;
import pageObjetcs.TouchpointPage;

public class IntentManagement extends Init{
	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	IntentManagementPageObjects intentManagementPage = new IntentManagementPageObjects();
	TouchpointPage touchpointPage = new TouchpointPage();
	ProgramPage programPage = new ProgramPage();
	@Then("^navigate to touchpoints")
	public void navigateToTouchpoints() throws InterruptedException {
		intentManagementPage.navigateToTouchpoints();
	}
	@Then("^navigate to programs")
	public void navigateToPrograms() throws InterruptedException {
		intentManagementPage.navigateToPrograms();
	}
	@Then("^navigate to sms")
	public void navigateToSms() throws InterruptedException {
		touchpointPage.navigateToSms();
	}
	@Then("^navigate to trigger")
	public void navigateToTrigger() throws InterruptedException {
		touchpointPage.navigateToTrigger();
	}
	@Then("^click create new touchpoint")
	public void clickCreateNewTouchpoint() throws InterruptedException {
		touchpointPage.clickCreateNewTouchpoint();
	}
	@Then("^create trigger touchpoint")
	public void createTriggerTouchpoint() throws InterruptedException {
		touchpointPage.createTriggerTouchpoint("TrigTP");
	}
	@Then("^check touchpoint landing page$")
	public void checkTouchpointLandingPage() throws Throwable{
		Thread.sleep(2000);
		touchpointPage.navigateToCustomerCare();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@val='customerCare' and contains(@class,'selected')]//iron-data-table[@id='customerTable']")).isDisplayed())
			System.out.println("true");
		touchpointPage.clickCreateNewTouchpoint();
		String heading =touchpointPage.getCustomerCareFormHeading();
		Exception headingDoesntMatch = new Exception("Heading doesnt match the selected type");
		Exception wrongFormDisplayed = new Exception("wrong form is displayed");
		if(!heading.contains("Create New Customer Care Touchpoint"))
			throw headingDoesntMatch;
		if(!touchpointPage.checkCustomerCareFormDisplayed())
			throw wrongFormDisplayed;
		touchpointPage.customerCareEnterMaximumOffers();
		touchpointPage.customerCareClickSave();
		touchpointPage.customerCareClickCancel();
	}
	@Then("^create sms touchpoint$")
	public void createSmsTouchpoint() throws Throwable{
		touchpointPage.createSmsTouchpoint("SMSkey");
	}
	@Then("^verify sms touchpoint creation form$")
	public void verify_sms_tp_creation_form() throws Throwable {
		String heading = touchpointPage.getSmsFormHeading();
	    if(heading.contains("Create New SMS Touchpoint")) {
	    	touchpointPage.enterSmsTouchpointDetails("formTest");
	    	touchpointPage.smsClickSave();
	    }
	}
	@Then("^check sms touchpoint in grid$")
	public void checkSmsTouchpoint() throws Throwable{
		Thread.sleep(7000);
		jswait.waitUntil("//span[contains(.,'SMSkey')]");
	}
	@Then("^check trigger touchpoint in grid$")
	public void check_trigger_touchpoint_in_grid() throws Throwable {
		Thread.sleep(7000);
		jswait.waitUntil("//data-table-cell[contains(.,'TrigTP')]");
	}
	@Then("^navigate to customer care$")
	public void navigate_to_customer_care() throws Throwable {
	    touchpointPage.navigateToCustomerCare();
	}

	@Then("^create customer care touchpoint$")
	public void create_customer_care_touchpoint() throws Throwable {
		touchpointPage.createCustomerCareTouchpoint("CustTP");
	}

	@Then("^check customer care touchpoint in grid$")
	public void check_customer_care_touchpoint_in_grid() throws Throwable {
		Thread.sleep(7000);
		jswait.waitUntil("//data-table-cell[contains(.,'CustTP')]");
	}
	@Then("^navigate to api$")
	public void navigate_to_api() throws Throwable {
		touchpointPage.navigateToApi();
	}

	@Then("^create api touchpoint$")
	public void create_api_touchpoint() throws Throwable {
	  touchpointPage.createApiTouchpoint("ApiTP");
	}

	@Then("^check api touchpoint in grid$")
	public void check_api_touchpoint_in_grid() throws Throwable {
		Thread.sleep(7000);
		jswait.waitUntil("//data-table-cell[contains(.,'ApiTP')]");
	}
	@Then("^navigate to ussd$")
	public void navigate_to_ussd() throws Throwable {
		touchpointPage.navigateToUssd();
	}

	@Then("^create ussd touchpoint$")
	public void create_ussd_touchpoint() throws Throwable {
	  touchpointPage.createUssdTouchpoint("UssdTP1");
	}

	@Then("^check ussd touchpoint in grid$")
	public void check_ussd_touchpoint_in_grid() throws Throwable {
		Thread.sleep(7000);
		jswait.waitUntil("//data-table-cell[contains(.,'UssdTP1')]");
	}
	@Then("^verify cancel button of sms touchpoint$")
	public void verifyCancelButtonSmsTouchpoint() throws Throwable {
		touchpointPage.clickCreateNewTouchpoint();
		touchpointPage.smsClickCancel();
		touchpointPage.clickCreateNewTouchpoint();
	}
	@Then("^verify cancel button of trigger touchpoint$")
	public void verifyCancelButtonTriggerTouchpoint() throws Throwable {
		touchpointPage.clickCreateNewTouchpoint();
		touchpointPage.enterTriggerTouchpointDetails("CheckCancel");
		touchpointPage.triggerClickCancel();
		Exception touchpointSavedAfterCancel = new Exception("touchpoint saved after clicking cancel");
		try{
			jswait.waitUntil("//data-table-cell[contains(.,'CheckCancel')]");
			throw touchpointSavedAfterCancel;
		}catch(Exception E) {
			
		}
	}
	@Then("^verify delete trigger touchpoint$")
	public void verify_delete_trigger_touchpoint() throws Throwable {
		touchpointPage.createTriggerTouchpoint("DeleteCheck");
		touchpointPage.deleteTriggerTouchpoint("DeleteCheck");
		Thread.sleep(3000);
	}
	@Then("^check mandatory fields for trigger touchpoint$")
	public void check_mandatory_fields_for_trigger_touchpoint() throws Throwable {
		touchpointPage.checkTriggerMandatoryFields();
	}
	@Then("^verify program landing page$")
	public void verify_program_landing_page() throws Throwable {
		programPage.checkCancelButtonCreateProgram();
		programPage.checkFilterCancelButton();
		programPage.checkAllColumnsInProductList();
	}
	@Then("^verify create program page$")
	public void verify_create_program_page() throws Throwable {
		programPage.clickCreateProgramButton();
		programPage.enterProgramDetails("landing page");
		programPage.checkCreateProgramTopbarButtons();
	}
	@Then("^verify program proceed button functionality for details tab$")
	public void verifyProgramProceedButtonDetailsTab() throws Throwable {
		programPage.clickCreateProgramButton();
		programPage.enterProgramDetails("landing page");
		programPage.clickPorogramProceedButton();
		programPage.clickCreateProgramAddTouchpointButton();	
	}
	@Then("^click create program button$")
	public void click_create_program_button() throws Throwable {
		programPage.clickCreateProgramButton();
	}

	@Then("^verify program cancel button functionality for details tab$")
	public void verify_program_cancel_button_functionality_for_details_tab() throws Throwable {
		programPage.enterProgramDetails("landing page");
		programPage.clickCreateProgramCancelButton();
		programPage.clickCreateProgramButton();
	}
	@Then("^verify program choose catalog field values$")
	public void verifyCreateProgramChooseCatalogField() throws Throwable {
		programPage.createProgramCheckOfferCatalogField();
	}
	@Then("^verify program field validation for details tab$")
	public void verfyProgramDetailsValidation() throws Throwable{
		programPage.enterProgramName("testName/.,");
		programPage.clickPorogramProceedButton();
		programPage.enterProgramName("testMandatoryFields");
		programPage.clickPorogramProceedButton();
		programPage.selectOfferCatalog();
		programPage.clickPorogramProceedButton();
		programPage.clickCreateProgramAddTouchpointButton();
	}
	@Then("^verify program touchpoint tab$")
	public void verfyProgramtouchpointTab() throws Throwable{ 
		programPage.enterProgramDetails("name");
		programPage.clickPorogramProceedButton();
		programPage.checkCreateProgramTouchpointGrid();
		programPage.checkCreateProgramTopbarButtons();
	}
	@Then("^verify program touchpoint addition$")
	public void verfyProgramtouchpointAddition() throws Throwable{ 
		verifyProgramProceedButtonDetailsTab();
		programPage.addTouchPointToProgram();
		programPage.clickPorogramProceedButton();
	}
}
