package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class GoogleSearchPage extends CommonMethods {

    @FindBy(css = "div.MjjYud")
    public List<WebElement> searchResults;


    public GoogleSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
