package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchSteps extends CommonMethods {

    //***********************Declaration of Global Variables************************************
    List<String> askEngineKeywordLinks = new ArrayList();
    List<String> askEngineNoKeywordsLinks = new ArrayList();
    List<String> googleEngineKeywordLinks = new ArrayList();
    List<String> googleEngineNoKeywordsLinks = new ArrayList();
    List<String> commonList1 = new ArrayList();
    List<String> commonList2 = new ArrayList();


    //    -------------------FOR GOOGLE SEARCH ENGINE----------------------------------------
    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        System.out.println("Navigating to " + url + " . . . . . . . .");
        launchUrl(url);
    }

    @When("user searches using the keyWord")
    public void user_searches_using_the_key_word() {
        System.out.println("writing the search keyWord in the search Bar . . . . . . . .");
        sendText(googleSearchPage.searchField, searchKeyword);
    }

    @When("user clicks on enter tab from keyboard")
    public void user_clicks_on_enter_tab_from_keyboard() {
        System.out.println("Clicking on enter tab on keyboard . . . . . . . .");
        googleSearchPage.searchField.sendKeys(Keys.ENTER);
    }

    @Then("user is able to see the search results for the keyWord")
    public void user_is_able_to_see_the_search_results_for_the_key_word() {

        List<WebElement> searchResultsLinks = googleSearchPage.googleSearchResultsLinks;
        for (int i = 0; i < 10; i++) {
            String searchLink = searchResultsLinks.get(i).getAttribute("href");
            searchLink = searchLink.toLowerCase(Locale.ROOT);
            searchKeyword = searchKeyword.toLowerCase(Locale.ROOT);
            if (searchLink.contains(searchKeyword)) {
                googleEngineKeywordLinks.add(searchLink);
            } else {
                googleEngineNoKeywordsLinks.add(searchLink);
            }
        }

        System.out.println("-------result for Google engine for the keyword" + searchKeyword + "--------");
        System.out.println("**" + " Links that contains the keyword " + searchKeyword + " **");

        int size = googleEngineKeywordLinks.size();
        for (int i = 0; i < size; i++) {
            System.out.println(googleEngineKeywordLinks.get(i));
        }
        System.out.println("*******************************");
        System.out.println("**" + " Links that does not contains the keyword " + searchKeyword + " **");
        size = googleEngineNoKeywordsLinks.size();
        for (int i = 0; i < size; i++) {
            System.out.println(googleEngineNoKeywordsLinks.get(i));
        }
        System.out.println("*********************************");
        System.out.println("--------------------------------------------------------------------");
        System.out.println(" ");
    }

    //    -----------------FOR ASK SEARCH ENGINE-------------------------------------------------
    @When("user searches for the keyWord")
    public void user_searches_for_the_key_word() {
        System.out.println("writing the search keyWord in the search Bar . . . . . . . .");
        sendText(askSearchPage.searchField, searchKeyword);
    }

    @When("user clicks on enter")
    public void user_clicks_on_enter() {
        System.out.println("Clicking on enter . . . . . . . .");
        askSearchPage.searchField.sendKeys(Keys.ENTER);
    }

    @Then("user is able to see the  results for the keyWord")
    public void user_is_able_to_see_the_results_for_the_key_word() {

        List<WebElement> searchResultsLinks = askSearchPage.askSearchResultsLinks;
        for (int i = 0; i < 10; i++) {
            String searchLink = searchResultsLinks.get(i).getAttribute("href");

            searchLink = searchLink.toLowerCase(Locale.ROOT);
            searchKeyword = searchKeyword.toLowerCase(Locale.ROOT);
            if (searchLink.contains(searchKeyword)) {
                askEngineKeywordLinks.add(searchLink);

            } else {
                askEngineNoKeywordsLinks.add(searchLink);
            }
        }

        System.out.println("-------result for ask engine for the keyword " + searchKeyword + "--------");
        System.out.println("**" + " Links that contains the keyword " + searchKeyword + " **");
        int size = askEngineKeywordLinks.size();
        for (int i = 0; i < size; i++) {
            System.out.println(askEngineKeywordLinks.get(i));
        }
        System.out.println("**********************************");
        System.out.println("**" + " Links that does not contains the keyword " + searchKeyword + " **");
        System.out.println(askEngineNoKeywordsLinks);
        size = askEngineNoKeywordsLinks.size();
        for (int i = 0; i < size; i++) {
            System.out.println(askEngineNoKeywordsLinks.get(i));
        }
        System.out.println("*********************************");
        System.out.println("--------------------------------------------------------------------");
        System.out.println(" ");
    }

    //   -------------------- Comparing the results of BOTH Google and Ask Search Engines-------------------------
    @Then("then the result is compared between both the search engines")
    public void then_the_result_is_compared_between_both_the_search_engines() {

        System.out.println("***************Result Comparison****************");

        int askLinksize = askEngineKeywordLinks.size();
        int googleLinksize = googleEngineKeywordLinks.size();
        for (int i = 0; i < askLinksize; i++) {
            String askLink = askEngineKeywordLinks.get(i);
            for (int j = 0; j < googleLinksize; j++) {
                String googleLink = googleEngineKeywordLinks.get(j);
                if (askLink.equalsIgnoreCase(googleLink)) {
                    commonList1.add(askLink);
                }
            }
        }

        int askLink_size = askEngineNoKeywordsLinks.size();
        int googleLink_size = googleEngineNoKeywordsLinks.size();
        for (int i = 0; i < askLink_size; i++) {
            String askLink = askEngineNoKeywordsLinks.get(i);
            for (int j = 0; j < googleLink_size; j++) {
                String googleLink = googleEngineNoKeywordsLinks.get(j);
                if (askLink.equalsIgnoreCase(googleLink)) {
                    commonList2.add(askLink);
                }
            }
        }
        if (commonList1.isEmpty() && commonList2.isEmpty()) {
            System.out.println("No common search result found between both engines");
        } else {
            int size = commonList1.size();
            for (int i = 0; i < size; i++) {
                System.out.println(commonList1.get(i));
            }
            size = commonList2.size();
            for (int i = 0; i < size; i++) {
                System.out.println(commonList2.get(i));
            }
        }
    }
}
