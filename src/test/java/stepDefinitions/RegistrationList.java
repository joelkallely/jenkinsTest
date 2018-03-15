package stepDefinitions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ExcelHelper;
import baseClasses.browserInit;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegistrationList extends browserInit{
	public int profileListUploaded = 0;
	public WebDriverWait wait = new WebDriverWait(driver, 8);
	ExcelHelper eh = new ExcelHelper();
	ExcelHelper list = new ExcelHelper();
	String msisdn = "";
	BufferedWriter bw = null;
	FileWriter fw = null;
	String[] profileFields = {"First Name","Last Name","Country","Email","Languages","Balance","Boolean","Age"};
	String[] country = {"India","USA","Pakisthan","Korea"};
	String[] languages = {"Malayalam","English","Korean","Hindi"};
	String[] Secondlanguages = {"Tamil","Spanish","Mandarin","Urdu"};
	String[] bool = {"Yes","No"};
	
	
	
	@Given("^random registration list is generated$")
    public void loginuser() throws IOException{
		System.out.println("in rand");
		 Random r = new Random();
    	 msisdn = "9199"+ String.valueOf(r.nextInt(9000)+1000);
		list.setExcelFile("registrationListInputData", "Sheet1");
		String filename = "list_"+msisdn+".csv";
		list.setCell(1, 0, filename);
		list.setCell(1, 2, "list_"+msisdn);
		//FileOutputStream fileOut = new FileOutputStream("ExcelFiles\\new.csv");
		File csvfile = new File("ExcelFiles\\"+filename);
		list.setCell(1, 1,csvfile.getCanonicalPath());
		PrintWriter pw = new PrintWriter(csvfile);
        StringBuilder sb = new StringBuilder();
        sb.append("msisdn");
        sb.append(',');
        sb.append("first name");
        sb.append(',');
        sb.append("last name");
        sb.append(',');
        sb.append("country");
        sb.append(',');
        sb.append("email");
        sb.append(',');
        sb.append("language 1");
        sb.append(',');
        sb.append("language 2");
        sb.append(',');
        sb.append("balance");
        sb.append(',');
        sb.append("boolean");
        sb.append(',');
        sb.append("age");
        pw.write(sb.toString());
        sb.setLength(0);
        
    	
    	 String alphabet = "abcdefghijklmnopqrstuvwxyz";
 	    final int N = 6;
    	for(int i=1; i<=50; i++){
    	///////random name generation
    	    StringBuilder sb1 = new StringBuilder();
    	    for (int j = 0; j < N; j++) {
    	        sb1.append(alphabet.charAt(r.nextInt(alphabet.length())));
    	    }
    	    String randomFirstName = sb1.toString();
    	    StringBuilder sb2 = new StringBuilder();
    	    for (int j = 0; j < N; j++) {
    	        sb2.append(alphabet.charAt(r.nextInt(alphabet.length())));
    	    }
    	    String randomLastName = sb2.toString();
    	///////random name generation
    	    int countrySelect = r.nextInt(4);
    	    int languageSelect = r.nextInt(4);
    	    int secondlanguageSelect = r.nextInt(4);
    	    int boolSelect = r.nextInt(2);
    	    int balance = r.nextInt(400);
    	    
            sb.append('\n');
    	    sb.append(msisdn+String.format("%04d",i));
            sb.append(',');
            sb.append(randomFirstName);
            sb.append(',');
            sb.append(randomLastName);
            sb.append(',');
            sb.append(country[countrySelect]);
            sb.append(',');
            sb.append(randomFirstName+"@gmail.com");
            sb.append(',');
            sb.append(languages[languageSelect]);
            sb.append(',');
            sb.append(Secondlanguages[secondlanguageSelect]);
            sb.append(',');
            sb.append(String.valueOf(balance));
            sb.append(',');
            sb.append(bool[boolSelect]);
            sb.append(',');
            sb.append(String.valueOf(r.nextInt(60)+15));
            pw.write(sb.toString());
            sb.setLength(0);
    	}
        pw.close();
        System.out.println("reg list creation done!");
		
    }
	public void add_profile_field() throws InterruptedException
	{		
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Country_q11");
	
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Single Select']");
	loadSendKeys("//h4[text()='Options']/../div[1]//input",country[0]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[2]//input",country[1]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[3]//input",country[2]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[4]//input",country[3]);
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Languages_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Multi Select']");
	loadSendKeys("//h4[text()='Options']/../div[1]//input",languages[0]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[2]//input",languages[1]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[3]//input",languages[2]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[4]//input",languages[3]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[5]//input",Secondlanguages[0]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[6]//input",Secondlanguages[1]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[7]//input",Secondlanguages[2]);
	loadClick("//h4[text()='Options']/../..//paper-icon-button[@icon='icons:add']");
	loadSendKeys("//h4[text()='Options']/../div[8]//input",Secondlanguages[3]);
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","First Name_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Text']");
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Last Name_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Text']");
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Email_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Text']");
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Balance_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Number']");
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Boolean_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Yes or No']");
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");
	
	loadClick("//paper-button[contains(.,'Create New Profile Field')]");
	loadSendKeys("//create-profile//label[contains(.,'Name')]/../input","Age_q11");
	loadSendKeys("//create-profile//label[contains(.,'Description')]/..//textarea","q11");
	loadClick("//create-profile//label[contains(.,'Context Type')]/../input");
	loadClick("//paper-item[contains(.,'Normal')]");
	loadClick("//create-profile//label[text()='Type']/../input");
	loadClick("//create-profile//paper-item[text()='Number']");
	loadClick(".//*[@id='createNew']//paper-button[contains(.,'Save')]");	
	}
	public void delete_profile_field() throws InterruptedException
	{
		loadClick("//*[@d='M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z']/../../..");
		loadClick("//paper-item[contains(.,'Delete')]");
		loadClick("//paper-button[contains(.,'Yes')]");
	
	}
	
	@Then("^check and add profile fields$")
    public void addProfileFields() throws IOException, InterruptedException{
		loadClick("//div[text()='Data Foundation']/../../a");
		loadClick("//a/div//div[contains(.,'Profile Fields')]/../..");
		loadClick("//*[@d='M10 18h4v-2h-4v2zM3 6v2h18V6H3zm3 7h12v-2H6v2z']/../../..");
		loadSendKeys("//form/paper-input[1]/paper-input-container/div[2]/div/input","_q11");
		loadClick("//paper-button[contains(text(),'Apply')]");
		Thread.sleep(3000);
		try{
		 if(driver. findElement(By.xpath("//*[@id='item1']//span[contains(.,'_q11')]")).isDisplayed()){
			 System.out.println("fields already present");
		 }
		}catch(Exception e){
			add_profile_field();
			profileListUploaded = 1;
		}
		
	}
	@Then("^upload list$")
    public void uploadList() throws Exception{
		driver.close();
		WebDriverWait wait = new WebDriverWait(driver, 8);
		System.out.println("in upload");
		list.setExcelFile("registrationListInputData", "Sheet1");
		String filename =(String) list.getCell(1, 0);
		
		init();
//		String[] temp = filename.split(".");
		String listname = (String) list.getCell(1, 2);
		System.out.println(listname);
		driver.get("http://node2.qaenv06.flytxt.com:31867");
		driver.findElement(By.xpath(".//*[@name='email']")).sendKeys("flyops@flytxt.com");
		driver.findElement(By.xpath(".//*[@name='password']")).sendKeys("flytxt");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		if(profileListUploaded==1){
		  Thread.sleep(3000);
		  loadClick("//span[text()='Support Tools']");
		  Thread.sleep(4000);
		  loadClick("//span[text()='Cache Manager']");
		  Thread.sleep(3000);
		  loadClick("//*[@id='bpOffRadio']");
		  Thread.sleep(5000);
		  loadClick("//button[text()='Flush']");
		  Thread.sleep(10000);
//		  Actions action1= new Actions(driver);
//		  action1.moveToElement(driver.findElement(By.xpath("//button[text()='OK']"))).click().build().perform();
		  loadClick(".//*[@id='ext-gen21']");
		  Thread.sleep(10000);
		}
		loadClick("//span[text()='Mobile Marketing DB']");
		Thread.sleep(3000);
		loadClick("//span[text()='Registration Lists']");
		Thread.sleep(3000);
		loadClick("//button[contains(.,'New List')]");
		Thread.sleep(3000);
		loadClick("//span[contains(.,'Create Registration List')]");
		Thread.sleep(3000);
		loadSendKeys(".//*[@id='registrationListName']",listname);
		loadSendKeys(".//*[@id='description']","flytxt");
		loadClick(".//*[@id='registrationListTypeId']");
		loadClick("//div[contains(@class,'x-combo-list-item') and text()='Standard']");
		loadClick(".//*[@id='moveAllLeft']");
		Thread.sleep(3000);
		loadClick("//button[text()='Save and Import Data']");
		
		//waitUntil("//label[text()='File Structure:']");
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(".//*[@id='theFile-file']")).sendKeys((String) list.getCell(1, 1));
		loadClick("//button[text()='Get File']");
		Thread.sleep(3000);
		loadClick("//span[text()='2. Map and Transform']");
		
		//waitUntil(".//*[@id='recurJobMapAndTransformPage']");
		Thread.sleep(10000);
		driver.switchTo().frame("recurJobMapAndTransformPage");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('consumerIdentification').selectedIndex = 1;");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//select[@id='consumerIdentification']/option[normalize-space(text())='1 - msisdn - \"9012233200\"']")).click();
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='consumerIdentification']")));
		dropdown.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[@value='0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Profile uploads:']/../..//a[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_0']//option[contains(.,'first name')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_0']/option[contains(.,'Name_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_1']//option[contains(.,'country')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_1']/option[contains(.,'Country_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileAdvancedOptions.autoUploadChk.0_1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_2']//option[contains(.,'email')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_2']/option[contains(.,'Email_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_3']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_3']//option[contains(.,'language 1')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_3']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_3']/option[contains(.,'Languages_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileAdvancedOptions.autoUploadChk.0_3']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_4']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_4']//option[contains(.,'language 2')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_4']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_4']/option[contains(.,'Languages_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileAdvancedOptions.autoUploadChk.0_4']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_5']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_5']//option[contains(.,'balance')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_5']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_5']/option[contains(.,'Balance_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_6']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_6']//option[contains(.,'boolean')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_6']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_6']/option[contains(.,'Boolean_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileAdvancedOptions.autoUploadChk.0_6']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/*[@id='addProfileUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_7']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='profileSourceField0_7']//option[contains(.,'- age -')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_7']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='partnerProfileField0_7']/option[contains(.,'Age_q11')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='addSubsUpdateBtn_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='listActionId_0_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='listActionId_0_0']/option[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='regListId_0_0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='regListId_0_0']/option[contains(.,'"+listname+"')]")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='5. Upload']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Start Upload']")).click();
		Thread.sleep(20000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'data_job_name')]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'data_job_name')]/a")).click();
		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Filters']/.."))).build().perform();
		Thread.sleep(3000);
		loadSendKeys(".//*[@name='data_job_name_filter']",listname);
		Thread.sleep(7000);
		driver.findElement(By.xpath(".//button[contains(.,'Refresh Now')]")).click();
		String status = driver.findElement(By.xpath("//label[contains(.,'"+listname+"')]/../../../td[1]//label")).getText();
		 System.out.println(status); 
	        while(status.contains("Scheduled")||status.contains("Processing")){
	        	Thread.sleep(3000);
	        	driver.findElement(By.xpath(".//button[contains(.,'Refresh Now')]")).click();
	        	Thread.sleep(3000);
	        	status = driver.findElement(By.xpath("//label[contains(.,'"+listname+"')]/../../../td[1]//label")).getText();
	        	System.out.println(status); 
	        }
	        Exception uploadFailed = new Exception("List upload failed");
		if(!status.contains("Completed"))
			throw uploadFailed;
		driver.close();
	}
	@Then("^check the upoaded list in ui$")
    public void checkDataInUI() throws IOException, InterruptedException{
//		System.out.println("hjhgc");
		eh.setExcelFile("registrationListInputData", "Sheet1");
		String file = (String) eh.getCell(1, 0);
		System.out.println(file);
		 String csvFile = "ExcelFiles\\"+file;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            line = br.readLine();
	            int i=0;
	            while ((line = br.readLine()) != null && i<10) {
	            	
	            	i++;
	                
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        String[] rowData = line.split(cvsSplitBy);
            

		loadClick("//label[contains(.,'Reports')]/..");
		loadClick("//div[contains(text(),'Customer Profile')]/..");
		loadSendKeys("//label[contains(text(),'Customer Number')]/../input",rowData[0]);
		loadClick("//paper-button[contains(text(),'Search')]");
		try{
			driver.findElement(By.xpath("//h3[contains(@class,'consumer-profile') and contains(text(),'"+rowData[0]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'Age_q11')]/../../data-table-cell[2]//span[contains(.,'Number')]/../../data-table-cell[3]//span[contains(.,'"+rowData[9]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'Balance_q11')]/../../data-table-cell[2]//span[contains(.,'Number')]/../../data-table-cell[3]//span[contains(.,'"+rowData[7]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'Boolean_q11')]/../../data-table-cell[2]//span[contains(.,'Yes or No')]/../../data-table-cell[3]//span[contains(.,'"+rowData[8]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'Country_q11')]/../../data-table-cell[2]//span[contains(.,'Single Select')]/../../data-table-cell[3]//span[contains(.,'"+rowData[3]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'Email_q11')]/../../data-table-cell[2]//span[contains(.,'Text')]/../../data-table-cell[3]//span[contains(.,'"+rowData[4]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'First Name_q11')]/../../data-table-cell[2]//span[contains(.,'Text')]/../../data-table-cell[3]//span[contains(.,'"+rowData[1]+"')]"));
			driver.findElement(By.xpath("//span[contains(.,'Languages_q11')]/../../data-table-cell[2]//span[contains(.,'Multi Select')]/../../data-table-cell[3]//span[contains(.,'"+rowData[5]+"/"+rowData[6]+"')]"));
			driver.findElement(By.xpath("//span[contains(@title,'_q11')]"));

		}catch(Exception e1){
			
		}
										
	}
	
}

//919913740011
