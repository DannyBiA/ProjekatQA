package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseTest {
    public ProfilePage() {
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "userName-value")
    public WebElement userName;
    @FindBy(id = "submit")
    public WebElement logOut;
    public void clickOnLogout() {
        logOut.click();
    }
}