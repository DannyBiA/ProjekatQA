package ProjekatQA.Tests;

import ProjekatQA.Base.BaseTest;
import ProjekatQA.Pages.HomepageQA;
import ProjekatQA.Pages.LoginPage;
import ProjekatQA.Pages.ProfilePage;
import ProjekatQA.Pages.Sidebar;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    public HomepageQA homepagePageQA;
    public Sidebar sidebar;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePageQA = new HomepageQA();
        sidebar = new Sidebar();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.manage().window().maximize();
        driver.get(homeURL);
        String validUsername = excelReader.getStringData("Credentials", 1, 0);
        String validPassword = excelReader.getStringData("Credentials", 1, 3);


        homepagePageQA.openBookstoreApp();
        sidebar.clickOnSidebarButtons("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(profilePage.userName);
    }
    @Test(priority = 10)
    public void userCanLogOut() {
        profilePage.clickOnLogout();
        String expectedURL = "https://demoqa.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}