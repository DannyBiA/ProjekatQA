package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "userName")
    public WebElement usernameTextBox;
    @FindBy(id = "password")
    public WebElement passwordTextBox;
    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(id = "userName")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div/p")
    public WebElement wrongCredentials;

    @FindBy(id = "userName-label")
    public WebElement successfullLogin;
    public void insertUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void insertPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }
}