package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class GoogleSearchPage extends CommonMethods {

    @FindBy(xpath = "//input[@title='Search']")
    public WebElement searchField;

    @FindBy(xpath = "//input[@value='Google Search']")
    public  WebElement searchBTn;

    @FindBy(xpath = "//div[@class='yuRUbf']/a")
    public List<WebElement> googleSearchResultsLinks;

    @FindBy(xpath = "//div[@class='yuRUbf']/a/h3")
    public List<WebElement> googleSearchResultsTitle;


    public GoogleSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
