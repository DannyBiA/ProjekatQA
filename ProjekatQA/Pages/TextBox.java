package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox extends BaseTest {
    public TextBox() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userName")
    public WebElement userNameField;
    @FindBy(id = "userEmail")
    public WebElement emailField;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "name")
    public WebElement visibleName;
    @FindBy(id = "email")
    public WebElement visibleEmail;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")
    public WebElement currentAddress;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")
    public WebElement permanentAddress;
    @FindBy(id = "output")
    public WebElement output;
    public void insertFullName(String fullName) {
        userNameField.clear();
        userNameField.sendKeys(fullName);
    }
    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void insertCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }
    public void clickOnSubmitButton() {
        scrollIntoView(submitButton);
        submitButton.click();
    }
}