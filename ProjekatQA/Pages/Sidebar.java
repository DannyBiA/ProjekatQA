package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sidebar extends BaseTest {
    public Sidebar() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".btn.btn-light")
    public List<WebElement> sidebarButtons;
    public void clickOnSidebarButtons(String button){
        for (int i = 0; i < sidebarButtons.size(); i++) {
            if(sidebarButtons.get(i).getText().equals(button)) {
                scrollIntoView(sidebarButtons.get(i));
                sidebarButtons.get(i).click();
                break;
            }
        }
    }
}