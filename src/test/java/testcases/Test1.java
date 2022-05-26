package testcases;

import basetest.BaseTest;
import action_page.HomePage;
import base_page.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testlistener.TestListener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Listeners(TestListener.class)
public class Test1 extends BaseTest {
    BasePage basePage;
    HomePage homePage;
    SoftAssert softAssert ;
    List<String> links;

    @BeforeMethod()
    public void methodSetup(){
        basePage = new BasePage();
        homePage = new HomePage();
        softAssert = new SoftAssert();
    }
    /***************************************************************************
     * @TestCaseTitle Verify JS errors and broken links
     * @Steps
     *        When: Visit Home page
     *        Then: Verify no JavaScript error on webpage
     *        When: Collect all links from webpage
     *        Then: Verify there is no broken links
     *
     * @author  Sanket Chaudhari
     * @version 1.0
     * @since   2021-12-19
     ***************************************************************************/
    @Test(priority = 0)
    public void testCase_C01(){
        //Verify and Assert JavaScript Errors
        homePage.waitForElementToBeVisible(homePage.logo);
        Set<String> errorStrings = new HashSet<>();
        errorStrings.add("SyntaxError");
        errorStrings.add("EvalError");
        errorStrings.add("ReferenceError");
        errorStrings.add("RangeError");
        errorStrings.add("TypeError");
        errorStrings.add("URIError");

        //Verify all links present in Webpage
        links = homePage.getListOfLink();

        for(String url: links){
            softAssert.assertTrue(homePage.linkValidater(url),"This Url is broken = "+ url);
        }
        softAssert.assertAll();
    }

    @AfterMethod()
    public void methodCleanup(){

    }
}
