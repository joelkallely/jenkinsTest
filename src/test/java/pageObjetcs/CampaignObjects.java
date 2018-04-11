package pageObjetcs;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class CampaignObjects extends Init{
	public CampaignObjects() {
		PageFactory.initElements(driver, this);
	}
	JSWaiter jswait = new JSWaiter();
	public WebDriverWait wait = new WebDriverWait(driver, 8);
	
	@FindBy(xpath=".//*[@id='mainContainer']/paper-menu/div/hexagon-icon[3]/label/..")
	private WebElement lifeCycleMarketing;
	@FindBy(xpath="//paper-item[contains(.,'View Broadcasts')]")
	private WebElement optionsViewBroadcasts;
	@FindBy(xpath="//paper-button[contains(.,'Create New Broadcast')]")
	private WebElement createNewBroadcastButton;
	@FindBy(xpath="//paper-button[contains(.,'Create New Campaign')]")
	private WebElement createNewCampaignButton;
	@FindBy(xpath="//label[contains(.,'Type')]/../input")
	private WebElement typeSelector;
	@FindBy(xpath="//vaadin-combo-box-item[contains(.,'Informational')]")
	private WebElement typeInformational;
	@FindBy(xpath=".//campaign-details//label[contains(.,'Name')]/../input")
	private WebElement campaignName;
	@FindBy(xpath=".//*[@id='textarea']")
	private WebElement campaignDescription;
	@FindBy(xpath=".//campaign-details//label[contains(.,'Offer Catalog')]/../input")
	private WebElement offerCatalogSelector;
	@FindBy(xpath="//paper-button[contains(.,'Proceed')]")
	private WebElement proceedButton;
	@FindBy(xpath="//target-conditions/div/paper-icon-button")
	private WebElement targetConditionViewToggle;
	@FindBy(xpath="//label[contains(.,'Condition Type')]/../input")
	private WebElement targetConditionTypeSelector;
	@FindBy(xpath="//paper-item[contains(.,'Customer Insight')]")
	private WebElement targetConditionTypeCustomerInsight;
	@FindBy(xpath="//label[contains(.,'Field')]/../..//input")
	private WebElement CustomerInsightFieldSelector;
	@FindBy(xpath="//paper-item[contains(.,'Age')]")
	private WebElement CustomerInsightFieldAge;
	@FindBy(xpath="//label[text()='Condition']/../..//input")
	private WebElement conditionSelector;
	@FindBy(xpath="//paper-item[contains(.,'is greater than')]")
	private WebElement conditionIsGreaterThan;
	@FindBy(xpath=".//*[@id='conditionForm']//field-simple/div//paper-input//input")
	private WebElement isGreaterThanValue;
	@FindBy(xpath=".//*[@id='conditionCard']/paper-button[2]")
	private WebElement targetConditionSave;
	@FindBy(xpath=".//*[@id='topBar']/paper-button[contains(.,'Save Campaign')]")
	private WebElement saveCampaignButton;
	@FindBy(xpath=".//*[@id='topBar']/paper-button[contains(.,'Save')]")
	private WebElement saveCampaignTemplateButton;
	@FindBy(xpath="//div[contains(text(),'Campaign Categories')]/../..")
	private WebElement campaignCategoriesButton;
	@FindBy(xpath="//paper-button[contains(text(),'Create New Campaign Category')]")
	private WebElement createNewCampaignCategoryButton;
	@FindBy(xpath=".//*[@id='createNew']//label[contains(.,'Name')]/../input")
	private WebElement categoryNameInput;
	@FindBy(xpath=".//*[@id='createNew']//paper-button[contains(.,'Save')]")
	private WebElement campaignCategorySave;
	@FindBy(xpath="//paper-tab/div[contains(.,'Campaign Templates')]/..")
	private WebElement campaignTemplatesTab;
	@FindBy(xpath="//paper-button[contains(.,'Create Campaign template')]")
	private WebElement createCampaignTemplateButton;
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
//	@FindBy(xpath="")
//	private WebElement ;


	public void clickOptionsViewBroadcasts() throws InterruptedException {
		jswait.loadClick(optionsViewBroadcasts);
	}
	public void clickSaveCampaignTemplate() throws InterruptedException {
		jswait.loadClick(saveCampaignTemplateButton);
	}
	public void clickCampaignTemplateTab() throws InterruptedException {
		jswait.loadClick(campaignTemplatesTab);
	}
	public void clickCreateCampaignTemplateButton() throws InterruptedException {
		jswait.loadClick(createCampaignTemplateButton);
	}
	public void clickCreateCategorySaveButton() throws InterruptedException {
		jswait.loadClick(campaignCategorySave);
	}
	public void enterCategoryName(String name) throws InterruptedException {
		jswait.loadSendKeys(categoryNameInput, name);
	}
	public void createNewCampaignCategory(String name) throws InterruptedException {
		clickCreateNewCampaignCategoryButton();
		enterCategoryName(name);
		clickCreateCategorySaveButton();
	}
	public void clickCreateNewCampaignCategoryButton() throws InterruptedException {
		jswait.loadClick(createNewCampaignCategoryButton);
	}
	public void navigateToCampaignCategories() throws InterruptedException {
		jswait.loadClick(campaignCategoriesButton);
	}
	public void clickSaveCampaignButton() throws InterruptedException {
		jswait.loadClick(saveCampaignButton);
	}
	public void clickTargetConditionViewToggle() throws InterruptedException {
		jswait.loadClick(targetConditionViewToggle);
	}
	public void clickProceedButton() throws InterruptedException {
		jswait.loadClick(proceedButton);
	}
	public void clickCreateNewBroadcastButton() throws InterruptedException {
		jswait.loadClick(createNewBroadcastButton);
	}
	public void clickCreateNewCampaignButton() throws InterruptedException {
		jswait.loadClick(createNewCampaignButton);
	}
	public void clickTypeSelector() throws InterruptedException {
		jswait.loadClick(typeSelector);
	}
	public void clickTypeInformational() throws InterruptedException {
		jswait.loadClick(typeInformational);
	}
	public void selectOfferCatalog(String catalog) throws InterruptedException {
		jswait.loadSendKeys(offerCatalogSelector,catalog);
		jswait.loadClick("//vaadin-combo-box-item[contains(.,'"+catalog+"')]");
	}
	public void enterCampaignName(String name) throws InterruptedException {
		jswait.loadSendKeys(campaignName, name);
	}
	public void enterCampaignDescription(String desc) throws InterruptedException {
		jswait.loadSendKeys(campaignDescription, desc);
	}
	public void selectTypeInformational() throws InterruptedException {
		clickTypeSelector();
		clickTypeInformational();
	}
	public void navigateToLIfeCycleMarketing() throws InterruptedException {
		jswait.loadClick(lifeCycleMarketing);
	}
	public void enterCampaignDeails(String name,String catalog) throws InterruptedException {
		selectTypeInformational();
		enterCampaignName(name);
		enterCampaignDescription("Campaign to check bc craetion in selenium");
		selectOfferCatalog(catalog);
	}
	public void createTargetCondition() throws InterruptedException {
		jswait.loadClick(targetConditionTypeSelector);
		jswait.loadClick(targetConditionTypeCustomerInsight);
		jswait.loadClick(CustomerInsightFieldSelector);
		jswait.loadClick(CustomerInsightFieldAge);
		jswait.loadClick(conditionSelector);
		jswait.loadClick(conditionIsGreaterThan);
		jswait.loadSendKeys(isGreaterThanValue,"18");
		jswait.loadClick(targetConditionSave);
	}
	public void createCampaignTemplate(String name) throws InterruptedException {
		clickCampaignTemplateTab();
		clickCreateCampaignTemplateButton();
		enterCampaignName(name);
		enterCampaignDescription("Desc for Template");
		clickProceedButton();
		clickTargetConditionViewToggle();
		createTargetCondition();
		clickSaveCampaignTemplate();
	}
	public void createCampaign(String name,String catalog) throws InterruptedException {
		enterCampaignDeails(name,catalog);
		clickProceedButton();
		clickTargetConditionViewToggle();
		createTargetCondition();
		clickProceedButton();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='router']/app-route[9]/campaign-form/wizard-tab/div/iron-pages/campaign-schedule/form/paper-card/paper-date-time-input/div/paper-input[2]/paper-input-container/div[2]"))).click();
    	 Thread.sleep(1000);
    	 Calendar rightNow =Calendar.getInstance();
    	 int hours = rightNow.get(Calendar.HOUR);
    	 int min = rightNow.get(Calendar.MINUTE);
    	 int am_pm = rightNow.get(Calendar.AM_PM);
    	 int day = rightNow.get(Calendar.DAY_OF_MONTH);
    	 int year = rightNow.get(Calendar.YEAR);
    	 int month = rightNow.get(Calendar.MONTH)+1;
    	 min+=2;
    	 int rem = min%5;
    	 rem = 5-rem;
    	 min+=rem;
    	 if(min>59){
    		 min-=60;
    		 hours++;
    	 }
    	 Actions builder = new Actions(driver);
    	 WebElement num = driver.findElement(By.xpath(".//*[@id='hourClock']//*[@class='number style-scope paper-clock-selector']["+(hours+1)+"]"));
         builder.moveToElement(num).click().build().perform();
         Thread.sleep(2000);
    	 WebElement num1 = driver.findElement(By.xpath(".//*[@id='minuteClock']//*[@class='number style-scope paper-clock-selector']["+(min+1)+"]"));
         builder.moveToElement(num1).click().build().perform();
         if(am_pm==0)
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[1]"))).click();
         else
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='heading']/iron-selector[2]/div[2]"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='timeDialog']/div/paper-button[2]"))).click();
         clickSaveCampaignButton();
	}
//	public void navigateToPrograms() throws InterruptedException {
//				eh.setExcelFile("productClassInputData",sheet);
//	Actions clickAction = new Actions(driver);
//    WebElement scrollablePane = driver.findElement(By.xpath("//iron-scroll-threshold"));
//    clickAction.moveToElement(scrollablePane).click().build().perform();
//    Actions scrollAction = new Actions(driver);
//    for(int i=0;i<50;i++){
//    scrollAction.sendKeys(Keys.PAGE_DOWN).perform();
//    try{
//    	driver.findElement(By.xpath("//h4[contains(.,'"+eh.getCell(1, 0)+"')]"));
//    	break;
//    }
//    catch(Exception e){
//    }
//    Thread.sleep(1000);
//    }
//    Thread.sleep(2000);
//	jswait.loadClick(".//*[@id='prdClsScrollThreshold']/paper-card//h4[contains(.,'"+eh.getCell(1, 0)+"')]/../..//a");
//	}

}
