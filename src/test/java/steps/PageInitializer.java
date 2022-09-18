package steps;

import pages.GooglePage;
import pages.GoogleSearchPage;

public class PageInitializer {
    public static GooglePage googlePage;
    public static GoogleSearchPage googleSearchPage;
    public static void initializePageObjects() {

        googlePage = new GooglePage();
        googleSearchPage = new GoogleSearchPage();
    }
}
