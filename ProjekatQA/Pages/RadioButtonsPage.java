package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonsPage extends BaseTest {
    public RadioButtonsPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "yesRadio")
    public WebElement yesRadio;
    @FindBy (id = "impressiveRadio")
    public WebElement impressiveRadio;
    @FindBy (id = "noRadio")
    public WebElement noRadio;
    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    public WebElement yesMessage;
    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    public WebElement impressiveMessage;
    public void clickRadioButton(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
}

