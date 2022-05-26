package testcases;

import action_page.AccountPage;
import basetest.BaseTest;
import action_page.HomePage;
import base_page.BasePage;
import config.ConfigHolder;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import testlistener.TestListener;

@Listeners(TestListener.class)
public class Test2 extends BaseTest {
    BasePage basePage;
    HomePage homePage;
    AccountPage accountPage;
    SoftAssert softAssert ;

    @BeforeClass
    public void setup(){
        basePage = new BasePage();
        homePage = new HomePage();
        accountPage = new AccountPage();
    }
    @BeforeMethod()
    public void methodSetup(){
        softAssert = new SoftAssert();
    }
    /***************************************************************************
     * @TestCaseTitle Verify JS errors and broken links
     * @Steps
     *        When: Visit Home page
     *        Then: Home page will load
     *        When: Hover on my account
     *        Then: Login pop up will load
     *        When: Enter user name and password
     *        Then: Username and password gets entered
     *        When: Click on submit button
     *        Then: User will get login and my account page will load.
     *
     * @author  Sanket Chaudhari
     * @version 1.0
     * @since   2021-12-19
     ***************************************************************************/
    @Test(priority = 0)
    public void testCase_C01(){
        //Hover on My account and enter user name and password and click on login button
        homePage.waitForElementToBeVisible(homePage.logo);
        homePage.moveToElement(homePage.myAccount);
        homePage.moveToElement(homePage.myAccount);
        softAssert.assertTrue(homePage.waitForElementToBeVisible(homePage.popupEmailField).isDisplayed(),"Login pop is hidden");
        homePage.waitForElementToBeVisible(homePage.popupEmailField).sendKeys(ConfigHolder.getUserName());
        homePage.waitForElementToBeVisible(homePage.popupPasswordField).sendKeys(ConfigHolder.getPassword());
        homePage.waitForElementToBeClickable(homePage.popupLoginButton).click();

        //Verify user is able to login and account page will load.
        softAssert.assertTrue(accountPage.waitForElementToBeVisible(accountPage.accountDashboard).isDisplayed(),"Account page is not loading");
    }

    @AfterMethod()
    public void methodCleanup(){
        softAssert.assertAll();
    }
    @AfterClass
    public void cleanup(){

    }
}

