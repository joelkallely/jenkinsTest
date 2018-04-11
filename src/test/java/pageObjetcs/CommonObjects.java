package pageObjetcs;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;
import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

public class CommonObjects extends Init{
	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public CommonObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")
	private WebElement filterIcon;
	@FindBy(xpath="//*[@id='filterForm']//input")
	private WebElement filterFormName;
	@FindBy(xpath="//*[@id='filterDialog']/div/paper-button[3]")
	private WebElement filterFormApply;
	@FindBy(xpath="//*[@id='filterDialog']/div/paper-button[1]")
	private WebElement filterFormCancel;
	@FindBy(xpath="//*[@id='filterDialog']/div/paper-button[2]")
	private WebElement filterFormReset;
	@FindBy(xpath="//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..")
	private WebElement optionsIcon;
	@FindBy(xpath="//*[@d='M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z']/../../..")
	private WebElement plusIcon;
	@FindBy(xpath="//paper-button[contains(text(),'Yes')]")
	private WebElement paperButtonYes;
	@FindBy(xpath="//paper-item[contains(.,'Edit')]")
	private WebElement optionsEdit;
	@FindBy(xpath="//paper-item[contains(.,'Delete')]")
	private WebElement optionsDelete;
	@FindBy(xpath="//paper-icon-item[contains(.,'Edit')]")
	private WebElement targetConditionOptionsEdit;
	@FindBy(xpath="//paper-icon-item[contains(.,'Delete')]")
	private WebElement targetConditionOptionsDelete;

	@FindBy(xpath="//*[@id='sym2']")
	private WebElement offers;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
	
	public void clickFilterIcon() throws InterruptedException{
		jswait.loadClick(filterIcon);
	}
	public void clickEditOption() throws InterruptedException{
		jswait.loadClick(optionsEdit);
	}
	public void clickDeleteOption() throws InterruptedException{
		jswait.loadClick(optionsDelete);
	}
	public void clickTargetConditionOptionEdit() throws InterruptedException{
		jswait.loadClick(targetConditionOptionsEdit);
	}
	public void clickTargetConditionOptionDelete() throws InterruptedException{
		jswait.loadClick(targetConditionOptionsDelete);
	}
	public void navigateToOffers() throws InterruptedException{
		jswait.loadClick(offers);
	}
	public void clickOptionsIcon() throws InterruptedException{
		jswait.loadClick(optionsIcon);
	}
	public void clickPlusIcon() throws InterruptedException{
		jswait.loadClick(plusIcon);
	}
	public void clickFilterApplyButton() throws InterruptedException {
		jswait.loadClick(filterFormApply);
	}
	public void enterFilterFormname(String name) throws InterruptedException{
		jswait.loadSendKeys(filterFormName, name);
	}
	public void clickFilterCancelButton() throws InterruptedException {
		jswait.loadClick(filterFormCancel);
	}
	public void clickConfirmYesButton() throws InterruptedException {
		jswait.loadClick(paperButtonYes);
	}
	public void clickFilterResetButton() throws InterruptedException {
		jswait.loadClick(filterFormReset);
	}
	public void filterName(String name) throws InterruptedException{
		clickFilterIcon();
		enterFilterFormname(name);
		clickFilterApplyButton();
	}
	public String getTextFromFilterForm() throws InterruptedException, UnsupportedFlavorException, IOException {
		String text = "";
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection stringSelection = new StringSelection("checkText");
		clipboard.setContents(stringSelection, null);
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(Keys.CONTROL,"a");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='filterForm']/paper-input[1]/paper-input-container/div[1]/../div[2]/div[1]/input[1]")).sendKeys(Keys.CONTROL,"c");
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		text = result;
		return text;
	}
	public String getTextFormTextField(String xpath) throws InterruptedException, UnsupportedFlavorException, IOException {
		String text = "";
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection stringSelection = new StringSelection("checkText");
		clipboard.setContents(stringSelection, null);
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL,"a");
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL,"c");
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		text = result;
		return text;
	}
	public String getTextFormTextField(WebElement element) throws InterruptedException, UnsupportedFlavorException, IOException {
		String text = "";
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection stringSelection = new StringSelection("checkText");
		clipboard.setContents(stringSelection, null);
		element.sendKeys(Keys.CONTROL,"a");
		Thread.sleep(1000);
		element.sendKeys(Keys.CONTROL,"c");
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		text = result;
		return text;
	}
}
