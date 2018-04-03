

import org.testng.annotations.BeforeSuite;

import baseClasses.Init;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
	public class Hooks extends Init{
	
		@Before("@initBrowser")
		public static void beforeSuite() throws InterruptedException {
			Init.init();
		}
	@After("@closeBrowser")
	public void afterClass(Scenario scenario){
		driver.close();
	}
}