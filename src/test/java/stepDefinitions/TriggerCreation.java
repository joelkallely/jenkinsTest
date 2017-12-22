package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.browserInit;

public class TriggerCreation extends browserInit{

	public static void main(String[] args) throws InterruptedException{
		init();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.get("http://129.213.36.32/#/login");
   	    driver.findElement(By.xpath("//*[@id='input'and @class='style-scope gold-email-input']")).sendKeys("flyops@flytxt.com");
		 driver.findElement(By.xpath("//*[@id='input'and @class='style-scope paper-input']")).sendKeys("flytxt");
		 driver.findElement(By.id("loginButton")).click();
		 Thread.sleep(1500);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='outLogo']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainContainer']/paper-menu/div/hexagon-icon[6]/div/iron-icon[5]/../.."))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[36]/configuration-dashboard/div[2]/paper-card[2]/div[3]/a"))).click();
		 Thread.sleep(2000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[38]/trigger-mgmt/div[1]/paper-button"))).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@id='createTriggerForm']/div/paper-input/paper-input-container/div[2]/div[1]/input")).sendKeys("trigger");
		 driver.findElement(By.xpath(".//*[@id='createTriggerForm']//textarea")).sendKeys("description");
		 Thread.sleep(1500);
		 
	
	}
}
