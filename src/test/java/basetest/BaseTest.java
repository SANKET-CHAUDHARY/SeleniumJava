package basetest;

import config.ConfigHolder;
import org.testng.annotations.*;
import webdriver_manager.DriverManager;

import java.util.Random;

public class BaseTest {

    @BeforeSuite()
    public void suiteSetup(){
        DriverManager.getDriver().get(ConfigHolder.getUrl());
        DriverManager.getDriver().manage().window().maximize();
    }
    @BeforeClass()
    public void setup(){
    }

    @AfterClass()
    public void cleanup(){
    }
    @AfterSuite()
    public void suiteCleanup(){
        DriverManager.getDriver().quit();
    }

}
