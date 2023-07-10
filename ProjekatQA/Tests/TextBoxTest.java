package ProjekatQA.Tests;

import ProjekatQA.Base.BaseTest;
import ProjekatQA.Pages.HomepageQA;
import ProjekatQA.Pages.Sidebar;
import ProjekatQA.Pages.TextBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    public HomepageQA homePageQA;
    public Sidebar sidebar;
    public TextBox textbox;

    @BeforeMethod
    public void pageSetUp() {
        homePageQA = new HomepageQA();
        sidebar = new Sidebar();
        textbox = new TextBox();
        driver.manage().window().maximize();
        driver.get(homeURL);
    }
    @Test(priority = 10)
    public void userCanLoadDataUsingForm() {
        homePageQA.clickOnElement();
        sidebar.clickOnSidebarButtons("Text Box");
        String fullName = excelReader.getStringData("TextBox", 1, 0);
        String email = excelReader.getStringData("TextBox", 4, 0);
        String currentAddress = excelReader.getStringData("TextBox", 3, 1);
        String permanentAddress = excelReader.getStringData("TextBox", 4, 1);
        textbox.insertFullName(fullName);
        textbox.insertEmail(email);
        textbox.insertCurrentAddress(currentAddress);
        textbox.insertPermanentAddress(permanentAddress);
        textbox.clickOnSubmitButton();


        Assert.assertTrue(textbox.visibleName.getText().contains(fullName));
        Assert.assertTrue(textbox.visibleEmail.getText().contains(email));
        Assert.assertTrue(textbox.currentAddress.getText().contains(currentAddress));
        Assert.assertTrue(textbox.permanentAddress.getText().contains(permanentAddress));
    }
}
