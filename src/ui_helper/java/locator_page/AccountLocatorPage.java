package locator_page;

import base_page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountLocatorPage extends BasePage {
    public AccountLocatorPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "[class='my-account'] [class='dashboard']")
    public WebElement accountDashboard;
}
