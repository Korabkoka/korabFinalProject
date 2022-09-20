package stepDefinitions;

import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utlity.prudentialAnnotations;
import utlity.reusableMethods;

import java.util.ArrayList;
import java.util.List;

public class PrudentialLandingStepDefs {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='radio-container ']")
    List<WebElement> container;

    @Given("User launches chrome")
    public void user_launches_chrome() {
        driver= reusableMethods.getDriver();
    }

    @When("User navigates to {string}")
    public void user_navigates_to(String websiteUrl) {
        driver.navigate().to(websiteUrl);
    }

    @Then("User confirms the website title is {string}")
    public void user_confirms_the_website_title_is(String expectedTitle) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Then("User closes chrome")
    public void user_closes_chrome() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Then("user confirms first slide appears")
    public void user_confirms_first_slide_appears() throws Exception {
        List<WebElement> elements = new ArrayList<WebElement>();
        Thread.sleep(1000);
        elements = driver.findElements(By.xpath("//*[@class='display-fluid text-white mb-2']"));
        //booleans only return true or false
        if(!elements.get(0).isDisplayed())//in logic: if the title of slideshow 1 is not displayed, throw an error because the user is suppose to see the title of slide show 1        //IF STATEMENTS ONLY RUN IF WHATS INSIDE IT'S PARAMETERS IS TRUE
        {
            throw new Exception("ERROR : Slide show 1 title text is not displayed");
        }
    }
    @When("user clicks on plan for your future")
    public void user_clicks_on_plan_for_your_future() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(0).click();
    }
    @Then("user confirms second slide appears")
    public void user_confirms_second_slide_appears() throws Exception {
        List<WebElement> elements = new ArrayList<WebElement>();
        Thread.sleep(1000);
        elements = driver.findElements(By.xpath("//*[@class='display-fluid text-white mb-2']"));
        //booleans only return true or false
        if(!elements.get(1).isDisplayed())//in logic: if the title of slideshow 1 is not displayed, throw an error because the user is suppose to see the title of slide show 1        //IF STATEMENTS ONLY RUN IF WHATS INSIDE IT'S PARAMETERS IS TRUE
        {
            throw new Exception("ERROR : Slide show 1 title text is not displayed");
        }
    }
    @When("user clicks on reach your investment goals")
    public void user_clicks_on_reach_your_investment_goals() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(1).click();
    }
    @Then("user confirms third slide appears")
    public void user_confirms_third_slide_appears() throws Exception {
        List<WebElement> elements = new ArrayList<WebElement>();
        Thread.sleep(1000);
        elements = driver.findElements(By.xpath("//*[@class='display-fluid text-white mb-2']"));
        //booleans only return true or false
        if(!elements.get(2).isDisplayed())//in logic: if the title of slideshow 1 is not displayed, throw an error because the user is suppose to see the title of slide show 1        //IF STATEMENTS ONLY RUN IF WHATS INSIDE IT'S PARAMETERS IS TRUE
        {
            reusableMethods.getScreenShot(driver,"no third slide", prudentialAnnotations.logger);
            throw new Exception("ERROR : Slide show 1 title text is not displayed");
        }
    }
    @When("user clicks plan for future")
    public void user_clicks_plan_for_future() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(1).click();
    }

    @When("user clicks on Reach your investing goals")
    public void user_clicks_on_reach_your_investing_goals() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(1).click();
    }
    @When("user clicks on insure your family")
    public void user_clicks_on_insure_your_family() {
        List<WebElement> elements = new ArrayList<WebElement>();

        elements = driver.findElements(By.xpath("//*[@class='carousel-indicator text-white w-100 text-left pt-lg-0 pb-lg-1 py-sm-3']"));
        elements.get(0).click();
    }

}
