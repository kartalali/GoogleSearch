package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.CommonMethods;

public class GooglePageSteps extends CommonMethods {
    @Given("The text user wants to search is written in the search field.")
    public void the_text_user_wants_to_search_is_written_in_the_search_field() {
        waitForClickability(googlePage.searchField);
        sendText(googlePage.searchField, "upwork");
    }

    @Given("Press Enter tab on keyboard")
    public void press_enter_tab_on_keyboard() {
        googlePage.searchField.sendKeys(Keys.ENTER);
    }

    @Given("list first ten results")
    public void list_first_ten_results() {



                String results = googleSearchPage.searchResults.get(1).getText();
                System.out.println("Title " + results.split("/n")[0]);
                System.out.println("Url " + results.split("/n")[1]);
                System.out.println("Descreption " + results.split("/n")[3]);




    }
}
