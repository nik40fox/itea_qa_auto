package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for Registration Page
 */
public class LoginAndRegistrationPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "join-email")
    private WebElement emailField;

    @FindBy(id = "join-password")
    private WebElement passwordField;

    @FindBy(className = "btn btn-primary join-btn")
    private WebElement joinNowButton;

    @FindBy(css = ".uno-alert.error.hidden>p>strong")
    private WebElement alertText;

    @FindBy(id = "login-email")
    private WebElement loginEmailField;

    @FindBy(id = "login-password")
    private WebElement loginPasswordField;

    @FindBy(name = "submit")
    private WebElement signInButton;

    public LoginAndRegistrationPage() {
        driver.get("https://www.linkedin.com/");
        PageFactory.initElements(driver, this);
        implicitWaitForElement(firstNameField);
    }

    /**
     * Fill registration form
     * @param firstName - user First Name
     * @param lastName - user Last Name
     * @param email - user email
     * @param password - user password
     */
    public void fillRegistrationForm ( String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public HomePage login (String email, String password){
        loginEmailField.sendKeys(email);
        loginPasswordField.sendKeys(password);
        signInButton.click();
        return new HomePage();
    }

    public void clickJoinNowButton (){
        joinNowButton.click();
    }

    public void fillAndSubmitRegistrationForm (String firstName, String lastName, String email, String password){
        fillRegistrationForm(firstName, lastName, email, password);
        clickJoinNowButton();
    }

    public String getAlertText () {
        return alertText.getText();
    }
}
