package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class AskSearchPage extends CommonMethods {

    @FindBy(xpath = "//input[@aria-label='Search']")
    public WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement searchBTn;

    @FindBy(xpath = "//div[@class='PartialSearchResults-item-title']/a")
    public List<WebElement> askSearchResultsLinks;

    public AskSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
