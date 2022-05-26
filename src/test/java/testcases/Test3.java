package testcases;

import basetest.BaseTest;
import git_helper.GitHelper;
import org.testng.annotations.*;
import testlistener.TestListener;

@Listeners(TestListener.class)
public class Test3 extends BaseTest {
    /***************************************************************************
     * @TestCaseTitle Get all open PR request and store in CSV File
     *
     * @author  Sanket Chaudhari
     * @version 1.0
     * @since   2021-12-19
     ***************************************************************************/
    @Test(priority = 0)
    public void testCase_C01(){
        //Collect all open pull request and store in csv file
        GitHelper.searchOpenPullRequests();
    }
}
