package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Then;
import pageObjetcs.CustomerProfilePage;
import pageObjetcs.LandingPageObjects;
import pageObjetcs.LoginPageObjects;

public class UserProfileSteps extends Init{
	JSWaiter jswait = new JSWaiter();
	LandingPageObjects landingPage = new LandingPageObjects();
	CustomerProfilePage customerProfilePage = new CustomerProfilePage();
	public UserProfileSteps() {
		PageFactory.initElements(driver, this);
	}
	
	@Then("^click username on topbar")
	public void clickUsernameOnTopbar() throws InterruptedException {
		landingPage.clickProfileNameTopbar();
	}
	
	@Then("^verify dropdown")
	public void verifyDropdown() throws InterruptedException {
		Assert.assertTrue(landingPage.checkProfileDropdown(), "Error in Dropdown Displayed");
	}
	@Then("^click change password")
	public void clickChangePassword() throws InterruptedException {
		landingPage.clickDropdownChangePassword();
	}
	@Then("^click cancel in change password")
	public void clickCancelInChangePassword() throws InterruptedException {
		landingPage.clickChangePasswordCancel();
	}
	@Then("^change password \"([^\"]*)\" from \"([^\"]*)\"$")
	public void change_password(String newPassword,String oldPassword) throws Throwable {
		landingPage.enterCurrentPassword(oldPassword);
		landingPage.enterNewPassword(newPassword);
		landingPage.enterConfirmPassword(newPassword);
		landingPage.clickChangePasswordSave();
	}
//	@Then("^verify change password popup")
//	public void verifyChangePasswordPopup() throws InterruptedException {
//		landingPage.clickDropdownChangePassword();
//		landingPage.enterCurrentPassword("check");
//		landingPage.enterCurrentPassword("check");
//		landingPage.enterCurrentPassword("check");
//		landingPage.clickChangePasswordSave();
//		landingPage.clickChangePasswordCancel();
//	}
	@Then("^verify wrong password toast")
	public void verifyWrongPasswordMsg() throws Exception {
		jswait.waitUntil("//span[contains(.,'Current password entered is incorrect')]");
	}
	
}
