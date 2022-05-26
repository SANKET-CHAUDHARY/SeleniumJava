package action_page;

import locator_page.HomeLocatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePage extends HomeLocatorPage {

    public HomePage(){
        super();
    }

    public List<String> getListOfLink() {
        List<String> list = new ArrayList<>();
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            list.add(it.next().getAttribute("href"));
        }
        return list;
    }

    public boolean linkValidater(String link) {
        HttpURLConnection huc = null;
        int respCode = 200;
        boolean flag =false;

        try {
            huc = (HttpURLConnection) (new URL(link).openConnection());

            huc.setRequestMethod("HEAD");

            huc.connect();

            respCode = huc.getResponseCode();

            if (respCode >= 200 && respCode < 400) {
                flag = true;
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }


}
