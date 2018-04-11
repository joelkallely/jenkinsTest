
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.github.mkolisnyk.cucumber.runner.BeforeSuite;

import baseClasses.Init;
import baseClasses.JSWaiter;
import baseClasses.PropHandler;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjetcs.CommonObjects;
import pageObjetcs.CustomerProfilePage;
import pageObjetcs.LandingPageObjects;
import pageObjetcs.LoginPageObjects;
import pageObjetcs.RegistrationListPage;

public class CommonSteps extends Init {
	JSWaiter jswait = new JSWaiter();
	LoginPageObjects loginPage = new LoginPageObjects();
	LandingPageObjects landingPage = new LandingPageObjects();
	CustomerProfilePage customerProfilePage = new CustomerProfilePage();
	CommonObjects commonObjetcs = new CommonObjects();
	RegistrationListPage registrationListPage = new RegistrationListPage();
	
	public CommonSteps() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='mainContainer']/paper-menu/div/hexagon-icon[4]/label")
	private WebElement offerManagement;
	@FindBy(xpath="//label[text()='Reports']/..")
	private WebElement reports;
	@FindBy(xpath="//*[@id='sym1']")
	private WebElement products;
	@Given("^login$")
    public void loginuser() throws Exception {
		 driver.get("http://"+p.getValue("env"));
		 loginPage.login(p.getValue("username"), p.getValue("password"));
    }
	@Then("^logout")
	public void logout() throws InterruptedException {
		landingPage.clickDropdownLogout();
	}
	@Then("^navigate to precision marketer")
	public void navigateToPrecisionMarketer() throws InterruptedException {
		landingPage.navigateToPrecisionMarketer();
	}
	@Then("^navigate to landing page")
	public void navigateToLandingPage() throws InterruptedException {
		landingPage.navigateToLandingPage();
	}
	@Then("^navigate to reports")
	public void navigateToReports() throws InterruptedException {
		jswait.loadClick(reports);
	}
	@Then("^navigate to customer profile")
	public void navigateToCustomerProfile() throws InterruptedException {
		customerProfilePage.navigateToCustomerProfile();
	}
	@Then("^close browser")
	public void closeBrowser() throws InterruptedException {
		driver.close();
	}
	@Then("^open browser")
	public void openBrowser() throws InterruptedException {
		Init.init();
	}
	@Then("^navigate to intent management")
	public void navigateToIntentManagement() throws InterruptedException {
		landingPage.navigateToIntentManagement();
	}
	@Then("^navigate to data foundation")
	public void navigateToDataFoundation() throws InterruptedException {
		landingPage.navigateToDataFoundation();
	}
	@Then("^navigate to registration list")
	public void navigateToRegistrationList() throws InterruptedException {
		registrationListPage.navigateToRegistrationList();
	}
	@Then("^navigate to configuration management")
	public void navigateToConfiurationManagement() throws InterruptedException {
		landingPage.navigateToConfigurationManagement();
	}
	@Then("^navigate to offer management$")
    public void offerManagement() throws InterruptedException {
		jswait.loadClick(offerManagement);
	}
	@Then("^wait for some time")
	public void waitForSomeTime() throws InterruptedException {
		Thread.sleep(5000);
	}
	@Then("^navigate to products$")
	public void naviagte_to_products() throws Exception
	{
		jswait.loadClick(products);
	}
	@Then("^pass next scenario based on this step$")
	public void passNextScenarioBasedOnThisScenario() throws Exception
	{
		passScenario = 1;
	}
	@Then("^check previous step and pass this$")
	public void checkPrevousScenarioAndPassScenario() throws Exception
	{
		Assert.assertTrue(passScenario==1, "Previous condition failed, so this scenario fails");
		passScenario = 0;
	}
	@Then("^navigate to offers")
	public void navigate_to_offers() throws Throwable
	{
		commonObjetcs.navigateToOffers();
	}
}
