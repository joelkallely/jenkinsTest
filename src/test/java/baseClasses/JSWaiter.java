package baseClasses;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

		public class JSWaiter extends Init{
			public void loadClick(WebElement element) throws InterruptedException{
				 WebDriverWait wait = new WebDriverWait(driver, 8);
				 String loadMaskStatus = "";
				 Thread.sleep(400);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 System.out.println("Couldnt get style of loadMask. Trying again......");
				 }
				 while(loadMaskStatus.contains("block")) {
					 Thread.sleep(1000);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 System.out.println("messsage2:"+e.getMessage());
				 }
				 }
//				 wait.until(ExpectedConditions.elementToBeClickable(element));
				 Thread.sleep(400);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 System.out.println("Couldnt get style of loadMask. Proceeding without checking loadMask");
				 }
				 while(loadMaskStatus.contains("block")) {
					 Thread.sleep(1000);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 
				 }
				 }
				 try {
				 wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				 }catch(Exception e) {
					 System.out.println("messsage5:"+e.getMessage());
					 Thread.sleep(1000);
					 wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				 }
		}
			public void loadClick(String element) throws InterruptedException{
				 WebDriverWait wait = new WebDriverWait(driver, 8);
				 String loadMaskStatus = "";
				 Thread.sleep(400);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 System.out.println("Couldnt get style of loadMask. Trying again......");
				 }
				 while(loadMaskStatus.contains("block")) {
					 Thread.sleep(1000);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 System.out.println("messsage2:"+e.getMessage());
				 }
				 }
//				 wait.until(ExpectedConditions.elementToBeClickable(element));
				 Thread.sleep(400);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 System.out.println("Couldnt get style of loadMask. Proceeding without checking loadMask");
				 }
				 while(loadMaskStatus.contains("block")) {
					 Thread.sleep(1000);
				 try {
					 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
				 }catch(Exception e) {
					 
				 }
				 }
				 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();
				 }catch(Exception e) {
					 System.out.println("messsage5:"+e.getMessage());
					 Thread.sleep(1000);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();
				 }
		}

		public void loadSendKeys(WebElement element, String key) throws InterruptedException{
			 WebDriverWait wait = new WebDriverWait(driver, 8);
			 String loadMaskStatus = "";
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 }
			 wait.until(ExpectedConditions.visibilityOf(element));	
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 }
			 try {
				 wait.until(ExpectedConditions.visibilityOf(element)).clear();
				 wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
			 }catch(Exception e) {
				 System.out.println("messsage5:"+e.getMessage());
				 Thread.sleep(1000);
				 wait.until(ExpectedConditions.visibilityOf(element)).clear();
				 wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
			 }
		}
		public void loadSendKeys(String element, String key) throws InterruptedException{
			 WebDriverWait wait = new WebDriverWait(driver, 8);
			 String loadMaskStatus = "";
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 }
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));	
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 }
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).clear();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).sendKeys(key);
			 }catch(Exception e) {
				 System.out.println("messsage5:"+e.getMessage());
				 Thread.sleep(1000);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).clear();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).sendKeys(key);
			 }
		}
		public void waitUntil(WebElement element) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 8);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void waitUntil(String xpath) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver, 8);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		public void waitForInvisibility(String xpath) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver, 8);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}
		public void waitForOverlay() throws InterruptedException{
			boolean overlayStatus = false;
			try {
				overlayStatus = driver.findElement(By.xpath(".//iron-overlay-backdrop")).isDisplayed();
			}catch(Exception e) {
				 
			 	}
			while(overlayStatus) {
				try {
					overlayStatus = driver.findElement(By.xpath(".//iron-overlay-backdrop")).isDisplayed();
				Thread.sleep(1000);
			 }catch(Exception e) {
				 
			 	}
			}
		}
		public boolean checkClickable(WebElement element) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 8);
			 String loadMaskStatus = "";
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 System.out.println("Couldnt get style of loadMask. Trying again......");
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 System.out.println("messsage2:"+e.getMessage());
			 }
			 }
//			 wait.until(ExpectedConditions.elementToBeClickable(element));
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 System.out.println("Couldnt get style of loadMask. Proceeding without checking loadMask");
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 }
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(element));
			 return true;
			 }catch(Exception e) {
				 System.out.println("messsage5:"+e.getMessage());
				 Thread.sleep(1000);
				 try {
					 wait.until(ExpectedConditions.elementToBeClickable(element));
					 return true;
				 }catch(Exception e1) {
					 return false;
				 }
				 
			 }
		}
		public boolean checkClickable(String element) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 8);
			 String loadMaskStatus = "";
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 System.out.println("Couldnt get style of loadMask. Trying again......");
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 System.out.println("messsage2:"+e.getMessage());
			 }
			 }
//			 wait.until(ExpectedConditions.elementToBeClickable(element));
			 Thread.sleep(400);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 System.out.println("Couldnt get style of loadMask. Proceeding without checking loadMask");
			 }
			 while(loadMaskStatus.contains("block")) {
				 Thread.sleep(1000);
			 try {
				 loadMaskStatus = driver.findElement(By.xpath(".//*[@id='loadMask']")).getAttribute("style");
			 }catch(Exception e) {
				 
			 }
			 }
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
			 return true;
			 }catch(Exception e) {
				 System.out.println("messsage5:"+e.getMessage());
				 Thread.sleep(1000);
				try {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
					return true;
				}catch(Exception e1) {
				return false;
				}
			 }
		}
		public boolean checkVisible(WebElement element) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 8);
			try{
				wait.until(ExpectedConditions.visibilityOf(element));
				return true;
			}catch(Exception e) {
				return false;
			}
		}
		}
		
	
