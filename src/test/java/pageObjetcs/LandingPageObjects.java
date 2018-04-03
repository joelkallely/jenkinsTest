package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class LandingPageObjects extends Init{
	
	public LandingPageObjects() {
		PageFactory.initElements(driver, this);
	}
	JSWaiter jswait = new JSWaiter();

	@FindBy(xpath="//*[@id='outLogo']")
	private WebElement precisionMarketer;
	@FindBy(xpath=".//div[text()='Intent Management']/../..")
	private WebElement intentManagement;
	@FindBy(xpath="//div[contains(text(),'Insights Workbench')]")
	private WebElement insightsWorkbench;
	@FindBy(xpath="//div[contains(text(),'Configuration Management')]/..")
	private WebElement configurationManagement;
	@FindBy(xpath="//div[contains(text(),'Data Foundation')]/..")
	private WebElement dataFoundation;
	@FindBy(xpath=".//*[@id='topBar']//img")
	private WebElement flytxtLogo;
	@FindBy(xpath="//div[contains(@class,'profile-name')]/..")
	private WebElement topbarProfileName;
	@FindBy(xpath="//span[contains(text(),'Change Password')]/..")
	private WebElement profileNameDropdownChangePassword;
	@FindBy(xpath="//span[contains(text(),'Edit Profile')]/..")
	private WebElement profileNameDropdownEditProfile;
	@FindBy(xpath="//span[contains(text(),'Preferences')]/..")
	private WebElement profileNameDropdownPreferenes;
	@FindBy(xpath="//span[contains(text(),'Logout')]/..")
	private WebElement profileNameDropdownLogout;
	@FindBy(xpath="//label[contains(.,'Current Password')]/../input")
	private WebElement changePasswordCurrentPassword;
	@FindBy(xpath="//label[contains(.,'New Password')]/../input")
	private WebElement changePasswordNewPassword;
	@FindBy(xpath="//label[contains(.,'Confirm Password')]/../input")
	private WebElement changePasswordConfirmPassword;
	@FindBy(xpath=".//*[@id='changePassword']//paper-button[2]")
	private WebElement changePasswordSaveButton;
	@FindBy(xpath=".//*[@id='changePassword']//paper-button[1]")
	private WebElement changePasswordCancelButton;
	
	
	
	public void navigateToPrecisionMarketer() throws InterruptedException {
		jswait.loadClick(precisionMarketer);
	}
	public void navigateToIntentManagement() throws InterruptedException {
		jswait.loadClick(intentManagement);
	}
	public void navigateToInsightsWorkbench() throws InterruptedException {
		jswait.loadClick(insightsWorkbench);
	}
	public void navigateToConfigurationManagement() throws InterruptedException {
		jswait.loadClick(configurationManagement);
	}
	public void navigateToDataFoundation() throws InterruptedException {
		jswait.loadClick(dataFoundation);
	}
	public void navigateToLandingPage() throws InterruptedException {
		jswait.loadClick(flytxtLogo);
	}
	public void clickDropdownChangePassword() throws InterruptedException {
		jswait.loadClick(profileNameDropdownChangePassword);
	}
	public void clickDropdownEditProfile() throws InterruptedException {
		jswait.loadClick(profileNameDropdownEditProfile);
	}
	public void clickDropdownPreferences() throws InterruptedException {
		jswait.loadClick(profileNameDropdownPreferenes);
	}
	public void clickDropdownLogout() throws InterruptedException {
		jswait.loadClick(profileNameDropdownLogout);
	}
	public void clickProfileNameTopbar() throws InterruptedException {
		jswait.loadClick(topbarProfileName);
	}
	public void clickChangePasswordSave() throws InterruptedException {
		jswait.loadClick(changePasswordSaveButton);
	}
	public void clickChangePasswordCancel() throws InterruptedException {
		jswait.loadClick(changePasswordCancelButton);
	}
	public boolean checkProfileDropdown() throws InterruptedException {
		if(jswait.checkClickable(profileNameDropdownChangePassword) && jswait.checkClickable(profileNameDropdownChangePassword) && jswait.checkClickable(profileNameDropdownLogout) && jswait.checkClickable(profileNameDropdownPreferenes)) {
			return true;
		}
		else return false;	
	}
	public void enterCurrentPassword(String curr) throws InterruptedException {
		jswait.loadSendKeys(changePasswordCurrentPassword, curr);
	}
	public void enterNewPassword(String newpass) throws InterruptedException {
		jswait.loadSendKeys(changePasswordNewPassword, newpass);
	}
	public void enterConfirmPassword(String confirm) throws InterruptedException {
		jswait.loadSendKeys(changePasswordConfirmPassword, confirm);
	}
}
