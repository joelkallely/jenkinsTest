package stepDefinitions;

import java.util.List;
import java.util.Random;

import org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClasses.ExcelHelper;
import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Then;
import pageObjetcs.CommonObjects;
import pageObjetcs.ProductClassesPageObjects;

public class GenericProductDefinitionSteps extends Init{
	JSWaiter jswait = new JSWaiter();
	ExcelHelper eh = new ExcelHelper();
	CommonObjects commonObjects = new CommonObjects();
	ProductClassesPageObjects productClassesPageObjects = new ProductClassesPageObjects();
	public GenericProductDefinitionSteps() {
		PageFactory.initElements(driver, this);
	}
	
	@Then("^naviagte to product classes")
	public void navigateToProductClasses() throws InterruptedException {
		productClassesPageObjects.navigateToProductClasses();
	}
	public void filterWorkaround(String name) throws InterruptedException {
		commonObjects.clickFilterIcon();                            //issue in filter
		commonObjects.clickFilterResetButton();						//issue in filter
		commonObjects.filterName(name);
	}
	@Then("^create product class and add attributes from \"([^\"]*)\"$")
	public void create_product_class_and_add_attributes_from(String sheet) throws Throwable {
		eh.setExcelFile("productClassInputData",sheet);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eh.setCell(1, 0, name);
		productClassesPageObjects.createProductClass(name, (String) eh.getCell(1, 1));
		filterWorkaround(name);
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickAttributes();
		productClassesPageObjects.addDefaultAttributes();
	}
	@Then("^duplicate \"([^\"]*)\"$")
	public void duplicateProductClass(String sheet) throws Throwable {
		eh.setExcelFile("productClassInputData",sheet);
		String name = (String) eh.getCell(1, 0);
		filterWorkaround(name);
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickDuplicate();
		productClassesPageObjects.clickCreateProcutClassSave();
	}
	@Then("^verify deactivating product class \"([^\"]*)\"$")
	public void verifyDeactivatingProductClass(String sheet) throws Exception {
		eh.setExcelFile("productClassInputData",sheet);
		String name = (String) eh.getCell(1, 0);
		filterWorkaround(name+"_copy");
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickDeactivate();
		jswait.waitUntil("//span[contains(.,'I')]");
	}
	@Then("^verify activating product class \"([^\"]*)\"$")
	public void verifyActivatingProductClass(String sheet) throws Exception {
		eh.setExcelFile("productClassInputData",sheet);
		String name = (String) eh.getCell(1, 0);
		filterWorkaround(name+"_copy");
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickActivate();
		jswait.waitUntil("//span[contains(.,'A')]");
	}
	@Then("^verify duplicating attribute of \"([^\"]*)\"$")
	public void verifyDuplicatingAttributeOfProductClass(String sheet) throws Exception {
		eh.setExcelFile("productClassInputData",sheet);
		String name = (String) eh.getCell(1, 0);
		filterWorkaround(name+"_copy");
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickAttributes();
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickDuplicate();
		productClassesPageObjects.clickAddAttributeSave();
	}
	@Then("^verify edit attribute$")
	public void verifyEditAttribute() throws Exception {
		jswait.loadClick("//span[contains(.,'copy')]/../..//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..");
		jswait.loadClick("//span[contains(.,'copy')]/../..//paper-item[contains(.,'Edit')]");
		productClassesPageObjects.enterAttributeName("edit");
		productClassesPageObjects.clickAddAttributeSave();
	}
	@Then("^verify delete attribute$")
	public void verifyDeleteAttribute() throws Exception {
		jswait.loadClick("//span[contains(.,'edit')]/../..//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..");
		jswait.loadClick("//span[contains(.,'edit')]/../..//paper-item[contains(.,'Delete')]");
		commonObjects.clickConfirmYesButton();
		jswait.waitForInvisibility("//span[contains(.,'edit')]");
	}
	
	@Then("^verify edit product class of \"([^\"]*)\"$")
	public void verifyEditProductClass(String sheet) throws Exception {
		eh.setExcelFile("productClassInputData",sheet);
		String name = (String) eh.getCell(1, 0);
		filterWorkaround(name+"_copy");
		jswait.loadClick("//span[contains(.,'copy')]/../..//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..");
		jswait.loadClick("//span[contains(.,'copy')]/../..//paper-item[contains(.,'Edit')]");
		productClassesPageObjects.enterClassName(name+"_copy"+"_edit");
		productClassesPageObjects.clickCreateProcutClassSave();
	}
	@Then("^delete duplicate of \"([^\"]*)\"$")
	public void deleteProductClass(String sheet) throws Throwable {
		eh.setExcelFile("productClassInputData",sheet);
		String name = (String) eh.getCell(1, 0);
		filterWorkaround(name+"_copy");
		commonObjects.clickOptionsIcon();
		productClassesPageObjects.clickDelete();
		commonObjects.clickConfirmYesButton();
	}
	@Then("^create product class without any attributes from \"([^\"]*)\"$")
	public void createProductClassWithoutAnyAttributes(String sheet) throws Throwable {
		eh.setExcelFile("productClassInputData",sheet);
		Random rn = new Random();
		int  n = rn.nextInt(5000) + 1;
		String name = (String) eh.getCell(1, 0);
		name =  name.replaceAll("[0-9]", "")+n;
		eh.setCell(1, 0, name);
		productClassesPageObjects.createProductClass(name, (String) eh.getCell(1, 1));
	}
}
