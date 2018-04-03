package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjetcs.LoginPageObjects;

public class LoginPageSteps extends Init{

	JSWaiter jswait = new JSWaiter();
	LoginPageObjects loginPage = new LoginPageObjects();
	public LoginPageSteps() {
		PageFactory.initElements(driver, this);
	}
	
	@Given("^neon is loaded$")
	public void neon_is_loaded() throws Throwable {
		 driver.get("http://192.168.150.27");
	}
	@Then("^login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginWith(String email, String password) throws InterruptedException, IOException {		
		loginPage.login(email, password);
	}
	@Then("^verify login success$")
	public void verify_login_success() throws Throwable {
		assertTrue(loginPage.checkLogin(),"Login Unsuccessful");
	}
	@Then("^verify login failure$")
	public void verify_login_failure() throws Throwable {
		assertFalse(loginPage.checkLogin(),"Login Successful");
	}
	@Then("^change url to landing$")
	public void changeUrlToLanding() throws Throwable {
		driver.navigate().to("http://192.168.150.27/#/landing");
	}
	@Then("^Verify the Branding Area Content of Login page \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_the_Branding_Area_Content_of_Login_page(String arg1, String arg2) throws Throwable {
		jswait.waitUntil("//div[contains(.,'"+arg1+"')]");
		jswait.waitUntil("//div[contains(.,'"+arg2+"')]");
	}
	@Then("^verify login button$")
	public void verify_login_button() throws Throwable {
		Assert.assertTrue(loginPage.checkLoginButtonClickable(), "Login button not disabled");
	}
	@Then("^verify forgot password by not adding username$")
	public void verify_forgot_password_by_not_adding_username() throws Throwable {
		loginPage.clickForgotPassword();
		Assert.assertFalse(loginPage.checkForgotPasswordConfirmMessage(), "Confirmation displyed without username");
		jswait.waitUntil("//span[contains(.,'Please provide a registered email address.')]");
	}
}
