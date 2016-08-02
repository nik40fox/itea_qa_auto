package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = ".account-settings-tab")
    private WebElement accountSettingsTab;

    @FindBy(id = "advanced-search")
    private WebElement advancedSearchLink;


    public HomePage (){
        PageFactory.initElements(driver, this);
        implicitWaitForElement(accountSettingsTab);
    }

    public SearchResultsPage clickAdvancedSearchLink (){
        advancedSearchLink.click();
        return PageFactory.initElements(driver, SearchResultsPage.class);
    }



}
