package utlity;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utlity.reusableMethods;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class prudentialAnnotations {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setDriver() throws IOException {
        driver = reusableMethods.getDriver();
        reports = new ExtentReports("src/test/resources/extentReports/AutomationReport.html", true);
    }

    @BeforeMethod
    public void getTestName(Method testname){
        logger = reports.startTest(testname.getName());
        driver.navigate().to("https://www.prudential.com/");

    }
    @AfterMethod public void endTest(){

        reports.endTest(logger);
    }

    @AfterSuite public void quitSession() throws IOException, WriteException {
        reports.flush();
        driver.quit();
    }

}
