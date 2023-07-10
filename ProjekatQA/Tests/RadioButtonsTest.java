package ProjekatQA.Tests;

import ProjekatQA.Base.BaseTest;
import ProjekatQA.Pages.ElementsPage;
import ProjekatQA.Pages.HomepageQA;
import ProjekatQA.Pages.RadioButtonsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest extends BaseTest {
    String expectedMessage;
    public HomepageQA homepagePage;
    public ElementsPage elementsPage;
    public RadioButtonsPage radioButtonsPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepageQA();
        elementsPage = new ElementsPage();
        radioButtonsPage = new RadioButtonsPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        homepagePage.clickOnElement();
    }
    @Test (priority = 10)
    public void clickOnYesRadioButton() {
        scrollIntoView(elementsPage.radioButtonMenuItem);
        elementsPage.clickOnRadioButtonMenuItem();
        waitForURL("https://demoqa.com/radio-button");
        radioButtonsPage.clickRadioButton(radioButtonsPage.yesRadio);
        expectedMessage = "You have selected Yes";
        waitForVisibility(radioButtonsPage.yesMessage);
        Assert.assertEquals(radioButtonsPage.yesMessage.getText(), expectedMessage);
    }
    @Test (priority = 20)
    public void clickOnImpressiveRadioButton() throws InterruptedException{
        scrollIntoView(elementsPage.radioButtonMenuItem);
        elementsPage.clickOnRadioButtonMenuItem();
        waitForURL("https://demoqa.com/radio-button");
        radioButtonsPage.clickRadioButton(radioButtonsPage.impressiveRadio);
        expectedMessage = "You have selected Impressive";
        waitForVisibility(radioButtonsPage.impressiveMessage);
        Assert.assertEquals(radioButtonsPage.impressiveMessage.getText(), expectedMessage);
    }
    @Test (priority = 30)
    public void isNoRadioButtonDisabled() {
        scrollIntoView(elementsPage.radioButtonMenuItem);
        elementsPage.clickOnRadioButtonMenuItem();
        Assert.assertFalse(radioButtonsPage.noRadio.isEnabled());
    }
    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}