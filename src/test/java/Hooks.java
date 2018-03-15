import cucumber.api.Scenario;
import cucumber.api.java.After;
import baseClasses.browserInit;
public class Hooks extends browserInit{
//after all classes
	@After
	public void afterClass(Scenario scenario){
		driver.close();
	}
}
