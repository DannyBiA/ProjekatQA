package ProjekatQA.Tests;

import ProjekatQA.Base.BaseTest;
import ProjekatQA.Pages.ButtonsPage;
import ProjekatQA.Pages.ElementsPage;
import ProjekatQA.Pages.HomepageQA;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    String assertMessage;
    public HomepageQA homepagePage;
    public ElementsPage elementsPage;
    public ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepageQA();
        elementsPage = new ElementsPage();
        buttonsPage = new ButtonsPage(driver);
        driver.manage().window().maximize();
        driver.get(homeURL);
        homepagePage.clickOnElement();
    }
    @Test(priority = 10)
    public void doubleClickTest() throws InterruptedException {
        scrollIntoView(elementsPage.buttonsMenuItem);
        elementsPage.clickOnButtonsMenuItem();
        waitForURL("https://demoqa.com/buttons");
        Thread.sleep(500);
        buttonsPage.dupliKlik();

        assertMessage = "You have done a double click";
        Thread.sleep(500);
        waitForVisibility(buttonsPage.doubleClickMessage);
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), assertMessage);
    }

    @Test (priority = 20)
    public void rightClickTest() throws InterruptedException {
        scrollIntoView(elementsPage.buttonsMenuItem);
        elementsPage.clickOnButtonsMenuItem();
        waitForURL("https://demoqa.com/buttons");
        Thread.sleep(500);
        buttonsPage.desniKlik();

        assertMessage = "You have done a right click";
        Thread.sleep(500);
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), assertMessage);
    }
    @Test (priority = 30)
    public void clickMeTest() throws InterruptedException {
        scrollIntoView(elementsPage.buttonsMenuItem);
        elementsPage.clickOnButtonsMenuItem();
        waitForURL("https://demoqa.com/buttons");
        Thread.sleep(500);
        buttonsPage.klikniMe();

        assertMessage = "You have done a dynamic click";
        Thread.sleep(500);
        waitForVisibility(buttonsPage.clickMeMessage);
        Assert.assertEquals(buttonsPage.clickMeMessage.getText(), assertMessage);
    }
}