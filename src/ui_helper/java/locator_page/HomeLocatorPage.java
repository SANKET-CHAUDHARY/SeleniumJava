package locator_page;

import base_page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class HomeLocatorPage extends BasePage {
    public HomeLocatorPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#logo_wrapper a")
    public WebElement logo;

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'https')]")
    public List<WebElement> links;

    @FindBy(how = How.ID, using = "myaccount")
    public WebElement myAccount;

    @FindBy(how = How.XPATH, using = "//li[@id='meta_customer_flyout_trigger']//input[@id='email']")
    public WebElement popupEmailField;

    @FindBy(how = How.XPATH, using = "//li[@id='meta_customer_flyout_trigger']//input[@id='pass']")
    public WebElement popupPasswordField;

    @FindBy(how = How.XPATH, using = "//li[@id='meta_customer_flyout_trigger']//button[@id='send2']")
    public WebElement popupLoginButton;
}
