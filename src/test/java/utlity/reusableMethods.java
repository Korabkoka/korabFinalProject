package utlity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class reusableMethods {


    public static WebDriver getDriver()
    {
        WebDriverManager.chromedriver().setup();//latest version of browser downloaded to local cache, can also do manual setup with desired chrome update
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    //method to compare expected title with actual
    public static void verifyPageTitle(WebDriver driver, String expectedTitle, ExtentTest logger){
        //verifying the title using if else condition
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title matches");
            logger.log(LogStatus.PASS,"Title matches");
        } else {
            System.out.println("Title doesn't match " + actualTitle);
            logger.log(LogStatus.FAIL,"Title doesn't match " + actualTitle);
        }//end of get title condition
    }//end of verifyPageTitle

    //clear and enter a value using sendKeys
    public static void sendKeysMethod(WebDriver driver,WebElement xpath,String userValue,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on " + elementName);
            logger.log(LogStatus.PASS,"Successfully entered a value on " + elementName);
        } catch (Exception err) {
            System.out.println("Unable to enter a value on " + elementName);
            logger.log(LogStatus.FAIL,"Unable to enter a value on " + elementName);
        }
    }//end of sendKeysMethod

    //click on pop up element
    public static void clickIfPopupExist(WebDriver driver,WebElement xpath,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"Succesfully closed popup");
        } catch (Exception err) {
            System.out.println("Popup didn't appear...Proceed to next step");
            logger.log(LogStatus.FAIL,"Popup didn't appear...Proceed to next step" +elementName);
        }
    }//end of clickIfPopupExist

    //click on element
    public static void clickMethod(WebDriver driver,WebElement xpath,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"Succesfully clicked " + elementName);
        } catch (Exception err) {
            System.out.println("Unable to click on " + elementName);
            logger.log(LogStatus.FAIL,"unable to click " + elementName);
        }
    }//end of clickMethod

    //hover a element
    public static void mouseHoverAc(WebDriver driver, WebElement xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);
        try {
            System.out.println("attempting to hover mouse over element");
            WebElement elementHovered = wait.until(ExpectedConditions.visibilityOf((xpath)));
            actions.moveToElement(elementHovered).perform();
            logger.log(LogStatus.PASS, "Successfully hovered " + elementName);
        } catch (Exception err) {
            System.out.println("unable to find element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to hovere " + elementName);
        }
    }//end of mouseHover exception

    //submit on element
    public static void submitMethod(WebDriver driver,WebElement xpath,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.submit();
            System.out.println("Successfully submitted on " + elementName);
            logger.log(LogStatus.PASS,"Successfully submitted on " + elementName);
        } catch (Exception err) {
            System.out.println("Unable to submit on " + elementName);
            logger.log(LogStatus.FAIL,"Unable to submit on " + elementName);
        }
    }//end of submitMethod

    public static void selectMethod(WebDriver driver, WebElement xpath, String choice, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Selecting from dropdown menu " + elementName);
            //define object for the dropdown WebElement
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            //define object for selection and pass it the dropdown object
            Select choiceSelect = new Select(element);
            //use selectByVisbibleText method on to the selection object and pass it the choice
            choiceSelect.selectByVisibleText(choice);
            logger.log(LogStatus.PASS,"selected " + choice + " for " + elementName);
        } catch(Exception err){
            System.out.println("Unable to select from " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"unable to select " + choice + " for " + elementName);
        }//end of try catch
    }//end of selectMethod

    public static void selectByValue(WebDriver driver, WebElement xpath, String choice, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Selecting from dropdown menu " + elementName);
            //define object for the dropdown WebElement
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            //define object for selection and pass it the dropdown object
            Select choiceSelect = new Select(element);
            //use selectByVisbibleText method on to the selection object and pass it the choice
            choiceSelect.selectByValue(choice);
            logger.log(LogStatus.PASS,"selected " + choice + " for " + elementName);
        } catch(Exception err){
            System.out.println("Unable to select value from " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"unable to select value: " + choice + " for " + elementName);
        }//end of try catch
    }//end of selectMethod

    public static String getText(WebDriver driver, WebElement xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            Result = element.getText();
            System.out.println("Result is " + Result);
            logger.log(LogStatus.PASS,"Result is " + Result + " for " + elementName);
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
            logger.log(LogStatus.FAIL,"Unable to Get Text " + elementName);
        }
        return Result;
    }//end of getText

    public static String getTextByIndex(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            Result = element.getText();
            System.out.println("Result is " + Result);
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
        }
        return Result;
    }//end of getTextByindex


    //hover over an element
    public static void mouseHover(WebDriver driver,WebElement xpath,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Hovering on " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Hovering on " + elementName);
        } catch (Exception err) {
            System.out.println("Unable to hover on " + elementName);
            logger.log(LogStatus.FAIL,"unable to hovering on " + elementName);
        }
    }//end of hover method


    //method to verify if checkbox is selected or not
    public static void verifyStatusOfCheckbox(WebDriver driver,String xpath,boolean checkStatus, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Verifying checkbox status of " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            boolean checkboxStatus = element.isSelected();
            if (checkboxStatus == checkStatus) {
                System.out.println("Checkbox is selected as expected on " + elementName);
            } else {
                System.out.println("Checkbox is not selected for " + elementName);
            }//end of condition
        } catch (Exception err) {
            System.out.println("Unable to click on " + elementName);
        }
    }//end of verifyStatusOfCheckbox

    //slider by SendKeys method
    public static void sliderSendKeysMethod(WebDriver driver, WebElement xpath, int resetPoint, String desiredPoint, String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        try {

            //storing the WebElement as a variable
            WebElement slider = wait.until(ExpectedConditions.visibilityOf(xpath));

            //calling mouse action to click on the slider
            Actions action = new Actions(driver);
            action.click(slider).build().perform();
            Thread.sleep(1500);

            //reset loop
            for (int i = 0; i < resetPoint; i++) {
                action.sendKeys(Keys.ARROW_LEFT).build().perform();
            }//end of reset

            Thread.sleep(1500);

            //desired loop
            //converting String desiredPoint to integer so I can use it on for loop
            int intDesiredPoint = Integer.parseInt(desiredPoint);
            for (int i = 0; i < intDesiredPoint; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }//end of desired

            Thread.sleep(1500);
            logger.log(LogStatus.PASS,"Slider set to " + desiredPoint + " for " + elementName);
        } catch (Exception e) {

            System.out.println("Unable to move the slider " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to move the slider " + elementName + " " + e);
        }//end of slider by SendKeys method

    }//end of slider method

    public static void getScreenShot(WebDriver driver,String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/Extent_Report/screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.PASS, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void pageScrollerJS(WebDriver driver, WebElement xpath, String elementName, ExtentTest logger)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver,15);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
            logger.log(LogStatus.PASS, "scrolled to " +elementName);
        } catch (Exception e){
            logger.log(LogStatus.FAIL, "error occured while trying to scroll to " +elementName);
            e.printStackTrace();
        }
    }

    //method to add txt to excel sheet
    public static void writeToSheet(WritableSheet sheet, int c, int r, String txt, ExtentTest logger) throws WriteException {
        try{
            WritableCellFormat j = new WritableCellFormat();
            sheet.addCell(new Label(c,r,txt,j));
            logger.log(LogStatus.PASS, "added " +txt+ " to excel sheet");
        }catch(Exception e){
            logger.log(LogStatus.FAIL,"could not add "+txt+" to excel sheet");
        }
    }

    public static void closeTab(WebDriver driver, int whatTab, ExtentTest logger)
    {
        try{
            driver.switchTo().window(driver.getWindowHandles().toArray()[whatTab].toString());
            driver.close();
            Thread.sleep(1000);
            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
            logger.log(LogStatus.PASS,"closed: "+ driver.getWindowHandles().toArray()[whatTab].toString() +" tab");
        }catch(Exception e){
            logger.log(LogStatus.FAIL,"no driver so no tab to close" + e);
        }
    }

    public static void goBackPg(WebDriver driver, ExtentTest logger)
    {
        try{
            driver.navigate().back();
            logger.log(LogStatus.PASS,"driver goes back to"+ driver.getTitle() +" tab");
        }catch(Exception e){
            logger.log(LogStatus.FAIL,"can't go back" + e);
        }
    }

    public static void switchToTab(WebDriver driver, int whatTab, ExtentTest logger)
    {
        try{
            driver.switchTo().window(driver.getWindowHandles().toArray()[whatTab].toString());
            logger.log(LogStatus.PASS,"switched to: "+ driver.getWindowHandles().toArray()[whatTab].toString() +" tab");
        }catch(Exception e){
            logger.log(LogStatus.FAIL,"could not switch to that tab");
        }
    }

     /* public static WebElement getElem(WebDriver driver, List<WebElement> xpath, String elementName, int index, ExtentTest logger)
    {
        WebElement finder=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,15);
            System.out.println("attempting to find elements");
            finder= wait.until(ExpectedConditions.visibilityOf(xpath.get(index)));
            logger.log(LogStatus.PASS,"Returning element at index:" +index +" for " + elementName);
        } catch (Exception err) {
            System.out.println("unable to find element " + elementName);
            logger.log(LogStatus.FAIL,"Hovering on " + elementName);
        }//end of findElems exception
        return finder;
    }
    public void clickContaining(WebDriver driver,WebElement xpath, String elementName, ExtentTest logger)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver,15);
            System.out.println("attempting to click element containing "+elementName);
            logger.log(LogStatus.PASS,"Returning element at index:" +index +" for " + elementName);
        } catch (Exception err) {
            System.out.println("unable to find element " + elementName);
            logger.log(LogStatus.FAIL,"Hovering on " + elementName);
        }//end of clickContaining exception
    }*/



}
