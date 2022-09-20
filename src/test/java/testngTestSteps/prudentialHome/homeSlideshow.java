package testngTestSteps.prudentialHome;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import prudentialPages.prudentialHomePage;
import utlity.prudentialAnnotations;
import utlity.reusableMethods;

import java.util.ArrayList;
import java.util.List;

public class homeSlideshow  extends prudentialAnnotations {

    @Test
    public void mainTest() throws InterruptedException, Exception {

        prudentialHomePage home = new prudentialHomePage(driver);
        Thread.sleep(2000);
        user_confirms_the_website_title_is("Invest, Insure, Retire and Plan | Prudential Financial");
        user_confirms_first_slide_appears();
        user_clicks_on_plan_for_your_future();
        user_confirms_second_slide_appears();
        user_clicks_on_reach_your_investment_goals();
        user_confirms_third_slide_appears();
        user_clicks_plan_for_future();
        user_clicks_on_reach_your_investing_goals();
        user_clicks_on_insure_your_family();


    }
    public void user_confirms_the_website_title_is(String expectedTitle) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
    public void user_confirms_first_slide_appears() throws Exception {
        List<WebElement> elements = new ArrayList<WebElement>();
        Thread.sleep(1000);
        elements = driver.findElements(By.xpath("//*[@class='display-fluid text-white mb-2']"));
        //booleans only return true or false
        if(!elements.get(0).isDisplayed())//in logic: if the title of slideshow 1 is not displayed, throw an error because the user is suppose to see the title of slide show 1        //IF STATEMENTS ONLY RUN IF WHATS INSIDE IT'S PARAMETERS IS TRUE
        {
            String errormsg="ERROR : Slide show 1 title text is not displayed";
            reusableMethods.getScreenShot(driver,errormsg,logger);
            throw new Exception(errormsg);
        }
    }
    public void user_clicks_on_plan_for_your_future() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(0).click();
    }
    public void user_confirms_second_slide_appears() throws Exception {
        List<WebElement> elements = new ArrayList<WebElement>();
        Thread.sleep(1000);
        elements = driver.findElements(By.xpath("//*[@class='display-fluid text-white mb-2']"));
        //booleans only return true or false
        if(!elements.get(1).isDisplayed())//in logic: if the title of slideshow 1 is not displayed, throw an error because the user is suppose to see the title of slide show 1        //IF STATEMENTS ONLY RUN IF WHATS INSIDE IT'S PARAMETERS IS TRUE
        {
            String errormsg="ERROR : Slide show 2 title text is not displayed";
            reusableMethods.getScreenShot(driver,errormsg,logger);
            throw new Exception(errormsg);
        }
    }
    public void user_clicks_on_reach_your_investment_goals() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(1).click();
    }
    public void user_confirms_third_slide_appears() throws Exception {
        List<WebElement> elements = new ArrayList<WebElement>();
        Thread.sleep(1000);
        elements = driver.findElements(By.xpath("//*[@class='display-fluid text-white mb-2']"));
        //booleans only return true or false
        if(!elements.get(2).isDisplayed())//in logic: if the title of slideshow 1 is not displayed, throw an error because the user is suppose to see the title of slide show 1        //IF STATEMENTS ONLY RUN IF WHATS INSIDE IT'S PARAMETERS IS TRUE
        {
            String errormsg="ERROR : Slide show 3 title text is not displayed";
            reusableMethods.getScreenShot(driver,errormsg,logger);
            throw new Exception(errormsg);
        }
    }
    public void user_clicks_plan_for_future() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(1).click();
    }

    public void user_clicks_on_reach_your_investing_goals() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(1).click();
    }

    public void user_clicks_on_insure_your_family() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(0).click();
    }
}
