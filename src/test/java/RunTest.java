
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import baseClasses.Init;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
@RunWith(ExtendedCucumber.class)
//@RunWith(JoelCucumber.class)
//@RunWith(Cucumber.class)
@ExtendedCucumberOptions
	   (jsonReport = "target/81/cucumber.json",
        jsonUsageReport = "target/81/cucumber-usage.json",
        usageReport = true,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        overviewChartsReport = true,
        pdfPageSize = "A4 Landscape",
        toPDF = true,
        outputFolder = "target/81",
        retryCount = 0)
@CucumberOptions(
//        features = { "src/test/resources" },
        //@NX-ProductTestSuite,@tagOfferCatalog,@madhan_test_suite_on_OfferCreation,@tagOfferCatalog,@NX-bcCreationSuite
		tags = { "@OfferCreation" },
		plugin = {
        "html:target/81", "json:target/81/cucumber.json",
        "pretty:target/81/cucumber-pretty.txt",
        "usage:target/81/cucumber-usage.json", "junit:target/81/cucumber-results.xml",
        "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"
        })

public class RunTest extends Init 
{
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting test"); 

	}
//	@AfterClass
	public static void afterClass() {
		 Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("os", "Mac OSX");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	}
	
	public RunTest()
	{
		

//		CucumberResultsOverview results = new CucumberResultsOverview();
//		results.setOutputDirectory("target");
//		results.setOutputName("cucumber-results");
//		results.setSourceFile("./src/test/resources/cucumber.json");
//		results.executeFeaturesOverviewReport();
	}
	public static void main(String[] args) throws Exception {                             
	}

}