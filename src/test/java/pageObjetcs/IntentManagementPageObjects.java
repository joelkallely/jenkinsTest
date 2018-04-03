package pageObjetcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class IntentManagementPageObjects extends Init{
public IntentManagementPageObjects() {
	PageFactory.initElements(driver, this);
}
JSWaiter jswait = new JSWaiter();

@FindBy(xpath="//label[text()='Touchpoints']/..")
private WebElement touchpoints;
@FindBy(xpath="//label[contains(.,'Programs')]/..")
private WebElement programs;



public void navigateToTouchpoints() throws InterruptedException {
	jswait.loadClick(touchpoints);
}
public void navigateToPrograms() throws InterruptedException {
	jswait.loadClick(programs);
}
}
