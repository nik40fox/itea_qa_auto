package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegistrationPage;
import pages.SearchResultsPage;

public class AdvancedSearchTests {
    final static String email = "soul@ukr.net";
    final static String password = "Nataly123";
    final static String searchTerm = "HR";





















    @Test
    public void advancedSearchPositiveTest () {
        LoginAndRegistrationPage loginAndRegistrationPage = new LoginAndRegistrationPage();
        Assert.assertNotNull(loginAndRegistrationPage, "Login page is not loaded.");
        HomePage homePage = loginAndRegistrationPage.login(email, password);
        Assert.assertNotNull(homePage, "Home page is not loaded.");
        SearchResultsPage searchResultsPage = homePage.clickAdvancedSearchLink();
        searchResultsPage.performSearch(searchTerm);
        Assert.assertTrue(searchResultsPage.isSearchTermContained(searchTerm), "Each item from results list not contains searchTerm");

        //Assert that 10 items returned in results list
        //Assert that each item from results list contains searchTerm
    }

}
