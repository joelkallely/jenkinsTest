package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class LoginAndLogout extends browserInit
{
	
	ExcelHelper eh = new ExcelHelper();
	
	@Given("^init browser$")
    public void initBrowser() throws InterruptedException {
		init();
		driver.get("http://192.168.150.27");
	}
	@Given("^login$")
    public void loginuser() throws InterruptedException {
		init();
		 eh.setExcelFile("login","Sheet1");
		 //driver.get("http://"+eh.getCell(1, 2)+"/#/login");
		 driver.get("http://192.168.150.27");
		 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//input[@type='email']")).sendKeys(eh.getCell(1, 0));
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(eh.getCell(1, 1));
		 driver.findElement(By.id("loginButton")).click();				        
    }
	@Given("^login to legacy$")
    public void loginLegacy() throws InterruptedException {
		init();
		 eh.setExcelFile("login","Sheet1");
		 //driver.get("http://"+eh.getCell(1, 2)+"/#/login");
		 driver.get("http://192.168.150.27:8098");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@name='email']")).sendKeys("flyops@flytxt.com");
			driver.findElement(By.xpath(".//*[@name='password']")).sendKeys("flytxt");
			driver.findElement(By.xpath("//input[@value='Log In']")).click();			        
    }
	@Given("^initialize$")
    public void initialize() throws InterruptedException {
		initGecko();
	}
	
	@When("^logout$")
    public void logout() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 driver.findElement(By.xpath("//*[@id='topBar']/a/img")).click();
			driver.findElement(By.xpath("//div[5]/paper-menu-button/div/paper-icon-button/iron-icon")).click();
			driver.findElement(By.xpath("//div/paper-item")).click();
			System.out.println("logged out");
			driver.close();
	}

public void LoginWithValidUser(){
    
	 init();
	 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://192.168.150.45/#/login");
	 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope gold-email-input']")).sendKeys("flyops@flytxt.com");
		driver.findElement(By.xpath("//*[@id='input'and @class='style-scope paper-input']")).sendKeys("flytxt");
	 driver.findElement(By.id("loginButton")).click();
	 
	 
	// WebDriverWait wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("outLogo")));
	 //driver.findElement(By.id("outLogo")).click();
}


public void LogoutandExitBrowser(){
	System.out.println("inside logout and exit");
	WebDriverWait wait = new WebDriverWait(driver, 60);
	 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-trigger style-scope notification-panel x-scope paper-icon-button-0']"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='trigger']/paper-icon-button"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentWrapper']/div/paper-menu/div/paper-item"))).click();

	 
	 //driver.findElement(By.xpath("//*[@d='M7 10l5 5 5-5z']/../../..")).click();
	//driver.findElement(By.xpath("//*[@class='dropdown-trigger style-scope notification-panel x-scope paper-icon-button-0']")).click();
 //driver.findElement(By.xpath("//*[@id='router']/app-route[24]/product-list/div[1]/paper-button")).click();
 //driver.findElement(By.id("outLogo")).click();
 //driver.findElement(By.linkText("Logout")).click();
 //driver.close();
}
}