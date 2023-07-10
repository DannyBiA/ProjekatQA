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

public class LoginTest extends BaseTest {
    public HomepageQA homepagePage;
    public Sidebar sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepageQA();
        sidebarPage = new Sidebar();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }
    @Test(priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Credentials", 1, 0);
        String validPassword = excelReader.getStringData("Credentials", 1, 3);
        homepagePage.openBookstoreApp();
        sidebarPage.clickOnSidebarButtons("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();

        waitForVisibility(profilePage.logOut);
        Assert.assertTrue(elementIsPresent(profilePage.logOut));
    }
    @Test (priority = 20)
    public void userCannotLogInWithWrongUsername() {
        String invalidUsername = excelReader.getStringData("Credentials", 1, 0);
        String validPassword = excelReader.getStringData("Credentials", 1, 1);
        homepagePage.openBookstoreApp();
        sidebarPage.clickOnSidebarButtons("Login");
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.wrongCredentials);
        Assert.assertTrue(loginPage.wrongCredentials.isDisplayed());
    }
    @Test (priority = 30)
    public void userCannotLogInWithWrongPassword() {
        String validUsername = excelReader.getStringData("Credentials", 1, 0);
        String invalidPassword = excelReader.getStringData("Credentials", 1, 4);
        homepagePage.openBookstoreApp();
        sidebarPage.clickOnSidebarButtons("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.wrongCredentials);
        Assert.assertTrue(loginPage.wrongCredentials.isDisplayed());
    }
    @Test (priority = 40)
    public void userCannotLogInWithEmptyPasswordAndCorrectUsername() {
        String validUsername = excelReader.getStringData("Credentials", 1, 0);
        String emptyPassword = excelReader.getStringData("Credentials", 1, 5);
        homepagePage.openBookstoreApp();
        sidebarPage.clickOnSidebarButtons("Login");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword("");
        loginPage.clickOnLoginButton();

        String expectedURL = "https://demoqa.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}