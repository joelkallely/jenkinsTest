
import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.JoelCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
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
        //features = { "src/test/resources" },
        tags = { "@NXregistrationList" },//@NX-ProductTestSuite,@tagOfferCatalog,@madhan_test_suite_on_OfferCreation,@tagOfferCatalog,@NX-bcCreationSuite
        plugin = {
        "html:target/81", "json:target/81/cucumber.json",
        "pretty:target/81/cucumber-pretty.txt",
        "usage:target/81/cucumber-usage.json", "junit:target/81/cucumber-results.xml"
        })

public class RunnerTest 
{
	public RunnerTest()
	{
//		CucumberResultsOverview results = new CucumberResultsOverview();
//		results.setOutputDirectory("target");
//		results.setOutputName("cucumber-results");
//		results.setSourceFile("./src/test/resources/cucumber.json");
//		results.executeFeaturesOverviewReport();
	}

}