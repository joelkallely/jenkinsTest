package stepDefinitions;

import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;
import pageObjetcs.CustomerProfilePage;
import pageObjetcs.LandingPageObjects;
import pageObjetcs.LoginPageObjects;

public class LandingPageSteps extends Init{
	JSWaiter jswait = new JSWaiter();
	LoginPageObjects loginPage = new LoginPageObjects();
	LandingPageObjects landingPage = new LandingPageObjects();
	CustomerProfilePage customerProfilePage = new CustomerProfilePage();
	public LandingPageSteps() {
		PageFactory.initElements(driver, this);
	}
	
	
}
