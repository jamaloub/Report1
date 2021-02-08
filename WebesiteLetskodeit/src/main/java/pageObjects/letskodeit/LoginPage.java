package pageObjects.letskodeit;

import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public static final String CLICK_LOGIN_BUTTON = "CLICK_LOGIN_BUTTON";
    public static final String CLICK_COMMIT_BUTTON = "CLICK_COMMIT_BUTTON";
    public static final String INPUT_EMAIL_ADDRESS = "INPUT_EMAIL_ADDRESS";
    public static final String INPUT_PASSWORD = "INPUT_PASSWORD";
    public static final String CLICK_FORGOT_PASSWORD_LINK = "CLICK_FORGOT_PASSWORD_LINK";

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement EmailElement;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement PasswordElement;

    @FindBy(name="commit")
    private WebElement commitName;

    @FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
    private WebElement Forgot_Password_Link;

    public LoginPage(WebDriver driver) {
        super (driver);
    }

    public boolean clickButton(String FieldName) {
        WebElement button = null;
        switch (FieldName) {
            case CLICK_LOGIN_BUTTON:
                button = loginButton;
                break;
            case CLICK_COMMIT_BUTTON:
                button = commitName;
                break;
            case CLICK_FORGOT_PASSWORD_LINK:
                button = Forgot_Password_Link;
                break;
        }

        return super.clickButton (button,FieldName);
    }

    public boolean setInputField(String FieldName, String value) {
        WebElement inputField = null;
        String inputValue= value;
        switch (FieldName) {
            case INPUT_EMAIL_ADDRESS:
                inputField = EmailElement;
                break;
            case INPUT_PASSWORD:
                inputField = PasswordElement;
                break;
            default:
        }

        return super.type(inputField,inputValue);
    }
}
