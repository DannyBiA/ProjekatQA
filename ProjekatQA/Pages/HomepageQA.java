package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepageQA extends BaseTest {
    public HomepageQA() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> card;

    public void openBookstoreApp() {
        for (int i = 0; i < card.size(); i++) {
            if(card.get(i).getText().equals("Book Store Application")) {
                scrollIntoView(card.get(i));
                card.get(i).click();
                break;
            }
        }
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
    public WebElement Card;
    public void clickOnElement() {
        Card.click();

    }
}