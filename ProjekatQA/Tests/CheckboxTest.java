package ProjekatQA.Tests;

import ProjekatQA.Base.BaseTest;
import ProjekatQA.Pages.CheckboxPage;
import ProjekatQA.Pages.HomepageQA;
import ProjekatQA.Pages.Sidebar;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    public HomepageQA homePageQA;
    public Sidebar sidebar;
    public CheckboxPage checkboxPage;

    @BeforeMethod
    public void pageSetUp() {
        homePageQA = new HomepageQA();
        sidebar = new Sidebar();
        checkboxPage = new CheckboxPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePageQA.clickOnElement();
        sidebar.clickOnSidebarButtons("Check Box");
    }
    @Test (priority = 10)
    public void userTickCheckbox() throws InterruptedException {
        Thread.sleep(500);
        checkboxPage.checkTheTickBox();
        Assert.assertTrue(checkboxPage.result.isDisplayed());
    }
    @Test(priority = 20)
    public void userUntickCheckbox() throws InterruptedException {
        Thread.sleep(500);
        if (checkboxPage.TickBox.isSelected()) {
            checkboxPage.checkTheTickBox();
        } else {
            checkboxPage.checkTheTickBox();
            checkboxPage.checkTheTickBox();
        }
        Assert.assertFalse(checkboxPage.TickBox.isSelected());
    }
    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}
