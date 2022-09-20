package steps;

import pages.AskSearchPage;
import pages.GoogleSearchPage;

public class PageInitializer {
    public static AskSearchPage askSearchPage;
    public static GoogleSearchPage googleSearchPage;
    public static void initializePageObjects() {

        askSearchPage = new AskSearchPage();
        googleSearchPage = new GoogleSearchPage();
    }
}
