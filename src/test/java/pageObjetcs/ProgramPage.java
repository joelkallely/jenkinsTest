package pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;
public class ProgramPage extends Init{

	JSWaiter jswait = new JSWaiter();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public ProgramPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='programList']")
	private WebElement programList;
	@FindBy(xpath="//data-table-cell[contains(.,'Name')]")
	private WebElement programListNameColumn;
	@FindBy(xpath="//data-table-cell[contains(.,'Status')]")
	private WebElement programListStatusColumn;
	@FindBy(xpath="//data-table-cell[contains(.,'Offer Catalog')]")
	private WebElement programListOfferCatalogColumn;
	@FindBy(xpath="//data-table-cell[contains(.,'Channels')]")
	private WebElement programListChannelsColumn;
	@FindBy(xpath="//data-table-cell[contains(.,'# Rules')]")
	private WebElement programListRulesColumn;
	@FindBy(xpath="//data-table-cell[contains(.,'# Views')]")
	private WebElement programListViewsColumn;
	@FindBy(xpath="//paper-button[contains(.,'Create Program')]")
	private WebElement createProgramButton;
	@FindBy(xpath="//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..")
	private WebElement filterButton;
	@FindBy(xpath=".//*[@id='filterDialog']/div//paper-button[contains(.,'Cancel')]")
	private WebElement filterCancelButton;
	@FindBy(xpath=".//*[@id='topBar']/paper-button[1]")
	private WebElement createProgramCancelButton;
	@FindBy(xpath=".//*[@id='topBar']/paper-button[contains(.,'Save')]")
	private WebElement createProgramSaveButton;
	@FindBy(xpath=".//*[@id='topBar']/paper-button[contains(.,'Proceed')]")
	private WebElement createProgramProceedButton;
	@FindBy(xpath="//h5[contains(.,'Basic Information')]/..//label[contains(.,'Name')]/..//*[@id='input']")
	private WebElement createProgramName;
	@FindBy(xpath="//h5[contains(.,'Basic Information')]/..//label[contains(.,'Description')]/..//textarea")
	private WebElement createProgramDescription;
	@FindBy(xpath="//h5[contains(.,'Basic Information')]/..//label[contains(.,'Choose Offer Catalog')]/..//*[@id='input']")
	private WebElement createProgramChooseOfferCatalog;
	@FindBy(xpath="//form[@id='detailForm']//paper-item[contains(.,'')][2]")
	private WebElement createProgramCatalogSelect;
	@FindBy(xpath=".//*[@id='crumbs']/flytxt-breadcrumb[4]//paper-button[contains(.,'Create Program')]")
	private WebElement createProgramBreadcrumb;
	@FindBy(xpath="//paper-button[contains(.,'Add Touchpoint')]")
	private WebElement createProgramAddTouchpointButton;
	@FindBy(xpath="//data-table-cell[contains(.,'Touchpoint')]")
	private WebElement createProgramTouchpointGridName;
	@FindBy(xpath="//data-table-cell[text()='Channel']")
	private WebElement createProgramTouchpointGridChannel;
	@FindBy(xpath="//data-table-cell[contains(.,'Response Channel')]")
	private WebElement createProgramTouchpointGridResponseChannel;
	@FindBy(xpath="//data-table-cell[contains(.,'Other Attrib')]")
	private WebElement createProgramTouchpointGridOttherAttributes;
	@FindBy(xpath="//form[@id='addTouchpointForm']//label[text()='Channel']/..//*[@id='input']")
	private WebElement addTouchpointChannel;
	@FindBy(xpath="//paper-item[text()='SMS']")
	private WebElement addTouchpointSelectSMS;
	@FindBy(xpath="//form[@id='addTouchpointForm']//label[text()='Keyword Aliases']/..//textarea")
	private WebElement addTouchpointKeywordAliases;
	@FindBy(xpath="//form[@id='addTouchpointForm']//label[text()='Touchpoint']/..//*[@id='input']")
	private WebElement addTouchpointTouchpointName;
	@FindBy(xpath="//form[@id='addTouchpointForm']//label[text()='Touchpoint']/..//*[@id='input']/../../../../../..//paper-item[2]")
	private WebElement addTouchpointSelectSMS1024;
	@FindBy(xpath="//form[@id='addTouchpointForm']//label[text()='Response Channel']/..//*[@id='input']")
	private WebElement addTouchpointResponseChannel;
	@FindBy(xpath="//paper-item[text()='SMS']")
	private WebElement addTouchpointChannelSelectSMS;
	@FindBy(xpath="//form[@id='addTouchpointForm']//label[text()='Response Channel']/../../../../../../..//paper-item[text()='SMS']")
	private WebElement addTouchpointResponseChannelSelectSMS;
	@FindBy(xpath="//*[@id='addTouchpointForm']//paper-button[text()='Save']")
	private WebElement addTouchpointSaveButton;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
//	@FindBy(xpath="")
//	private WebElement ;
	
	//program page functions
	public void clickCreateProgramButton() throws InterruptedException {
		jswait.loadClick(createProgramButton);
	}
	public void clickCreateProgramCancelButton() throws InterruptedException {
		jswait.loadClick(createProgramCancelButton);
	}
	public void clickFilterButton() throws InterruptedException {
		jswait.loadClick(filterButton);
	}
	public void clickFilterCancelButton() throws InterruptedException {
		jswait.loadClick(filterCancelButton);
	}
	public void clickPorogramProceedButton() throws InterruptedException {
		jswait.loadClick(createProgramProceedButton);
	}
	public void checkCancelButtonCreateProgram() throws InterruptedException {
		clickCreateProgramButton();
		clickCreateProgramCancelButton();
	}
	public void checkFilterCancelButton() throws InterruptedException {
		clickFilterButton();
		clickFilterCancelButton();
	}
	public void checkAllColumnsInProductList() throws InterruptedException {
		jswait.checkClickable(programListNameColumn);
		jswait.checkClickable(programListChannelsColumn);
		jswait.checkClickable(programListOfferCatalogColumn);
		jswait.checkClickable(programListRulesColumn);
		jswait.checkClickable(programListViewsColumn);
		jswait.checkClickable(programListStatusColumn);
	}
	public void enterProgramName(String name)throws InterruptedException {
		jswait.loadSendKeys(createProgramName, name);
	}
	public void enterProgramDescription()throws InterruptedException {
		jswait.loadSendKeys(createProgramDescription, "Test Description");
	}
	public void selectOfferCatalog() throws InterruptedException {
		jswait.loadClick(createProgramChooseOfferCatalog);
		jswait.loadClick(createProgramCatalogSelect);
	}
	public void enterProgramDetails(String name)throws InterruptedException {
		enterProgramName(name);
		enterProgramDescription();
		selectOfferCatalog();
	}
	
	public void checkCreateProgramTopbarButtons()throws InterruptedException {
		jswait.checkClickable(createProgramCancelButton);
		jswait.checkClickable(createProgramSaveButton);
		jswait.checkClickable(createProgramProceedButton);
		jswait.checkVisible(createProgramBreadcrumb);
	}
	public void clickCreateProgramAddTouchpointButton() throws InterruptedException {
		jswait.loadClick(createProgramAddTouchpointButton);
	}
	public void createProgramCheckOfferCatalogField() throws Exception {
		Exception e = new Exception("offer catalog displayed exceeds limit");
		jswait.loadClick(createProgramChooseOfferCatalog);
		jswait.waitUntil("//form[@id='detailForm']//paper-item");
		int offerCatalogesCount = driver.findElements(By.xpath("//form[@id='detailForm']//paper-item")).size();
		if(offerCatalogesCount>20) {
			throw e;
		}
		jswait.loadSendKeys(createProgramChooseOfferCatalog, "at");
		Thread.sleep(3000);
		jswait.loadClick(createProgramCatalogSelect);
	}
	public void checkCreateProgramTouchpointGrid() throws InterruptedException {
		jswait.checkVisible(createProgramTouchpointGridChannel);
		jswait.checkVisible(createProgramTouchpointGridName);
		jswait.checkVisible(createProgramTouchpointGridOttherAttributes);
		jswait.checkVisible(createProgramTouchpointGridResponseChannel);
		jswait.checkClickable(createProgramAddTouchpointButton);
	}
	public void addTouchPointSelectSmsChannel() throws InterruptedException {
		jswait.loadClick(addTouchpointChannel);
		jswait.loadClick(addTouchpointChannelSelectSMS);
	}
	public void addTouchPointEnterKeywordAliase() throws InterruptedException {
		jswait.loadSendKeys(addTouchpointKeywordAliases, "SampleKey");
	}
	public void addTouchPointSelectSmsTouchpoint() throws InterruptedException {
		jswait.loadClick(addTouchpointTouchpointName);
		Thread.sleep(3000);
		jswait.loadClick(addTouchpointSelectSMS1024);
	}
	public void addTouchPointSelectSmsResponseChannel() throws InterruptedException {
		jswait.loadClick(addTouchpointResponseChannel);
		jswait.loadClick(addTouchpointResponseChannelSelectSMS);
	}
	public void addTouchPointToProgram() throws InterruptedException {
		addTouchPointSelectSmsChannel();
		addTouchPointEnterKeywordAliase();
		addTouchPointSelectSmsTouchpoint();
		addTouchPointSelectSmsResponseChannel();
		jswait.loadClick(addTouchpointSaveButton);
	}
}
