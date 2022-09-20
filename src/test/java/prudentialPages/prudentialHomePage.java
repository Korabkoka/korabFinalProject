package prudentialPages;

import utlity.reusableMethods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utlity.prudentialAnnotations;

import java.util.List;


public class prudentialHomePage extends prudentialAnnotations {
    ExtentTest logger;

    public prudentialHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = prudentialAnnotations.logger;
    }//end of Home_Page constructor

    //insure umbrella icon [button & dropdown open]
    @FindBy(xpath = "//*[@class='evo-icon-umbrella']")
    WebElement insure;


}
