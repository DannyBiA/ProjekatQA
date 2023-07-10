package ProjekatQA.Pages;

import ProjekatQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends BaseTest {

    public CheckboxPage() {
        PageFactory.initElements(driver, this);}

    @FindBy(css = "#tree-node > ol > li > span > label > span.rct-checkbox > svg")
    public WebElement TickBox;
    @FindBy(id = "result")
    public WebElement result;


    public void checkTheTickBox() {
        TickBox.click();
    };

}