import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css ="form#new_user input[id='user_email']")
    private WebElement emailInput;

    @FindBy(css = "form#new_user input[id='user_password']")
    private WebElement passwordInput;

    @FindBy(css = "form#new_user input[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@id='parsley-id-5']/li[@class='parsley-type']")
    private WebElement emailError;

    @FindBy(xpath = "//ul[@class='parsley-errors-list filled']/li[@class='parsley-required']")
    private WebElement passwordError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isEmailErrorDisplayed() {
        return emailError.isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }
}
