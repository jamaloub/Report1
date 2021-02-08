package pageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class BasePage {
    private static WebDriver driver;
    private static WebElement blockingIndicator;
    private final static int DEFAULT_TIMEOUT_SEC = 10;
    private final static int MAX_RETRIES = 3;
    private static Logger LOG = Logger.getLogger (BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (driver, this);
    }

    private void waitBlocking() {
        try {
            driver.manage ().timeouts ().implicitlyWait (500, TimeUnit.MILLISECONDS);
            blockingIndicator.getLocation ();
            driver.manage ().timeouts ().implicitlyWait (DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS);
        } catch (WebDriverException nse) {
            //LOG.info ("No Blocker");
            driver.manage ().timeouts ().implicitlyWait (DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS);
        }
    }

    public boolean visit(String url) {
        waitBlocking ();
        try {
            driver.manage ().deleteAllCookies ();
            driver.get (url);
            LOG.info ("<" + url + "> --> Die Webseite ist erfolgreich aufgerufen");

            return true;
        } catch (WebDriverException wde) {
            LOG.error ("<" + url + "> --> Die Webseite ist nicht erfolgreich aufgerufen");

            return false;
        }
    }

    public boolean clickButton(WebElement element, String FieldName) {
        waitBlocking ();
        try {
            element.click ();
            LOG.info ("< Der Button " + FieldName + "> --> wurde angeklickt");

            return true;
        } catch (WebDriverException e) {
            LOG.error ("<Der Button " + FieldName + "> --> Der Button wurde nicht angeklickt");

            return false;
        }
    }

    public boolean type(WebElement element, String inputValue) {
        waitBlocking ();
        try {
            element.clear ();
            element.sendKeys (inputValue);
            LOG.info ("< Der Text " + "" + inputValue + "" + " ist eingegeben");

            return true;
        } catch (WebDriverException wde) {
            LOG.error ("< Der Text " + inputValue + " Kein Text wurde eingegeben ");
            return false;
        }
    }

    public boolean selectComboBoxValue(WebElement element, String inputValue) {
        waitBlocking ();
        Select select = new Select (element);
        try {
            select.selectByValue (inputValue);
            LOG.info ("Die Option " + inputValue + " ist selektiert");
            return true;
        } catch (WebDriverException wde) {
            LOG.error ("Die Option " + inputValue + " ist nicht selektiert");
            return false;
        }

    }

    public boolean radioButton(WebElement radioButtonValue, String FieldName) {
        waitBlocking();
        boolean selectState = radioButtonValue.isSelected();
        try {
            //performing click operation only if element is not selected
            if (selectState == false) {
                radioButtonValue.click();
                LOG.info("Der Button " + FieldName + "> --> ist selektiert");
                return true;
            }

        } catch (WebDriverException wde) {
            LOG.error("Der Button " + FieldName + "> --> wurde nicht selektiert");

            return false;
        }

        return false;
    }


    public boolean HoverMouse(WebElement MouseHoverValue, WebElement MouseHoverElement) {
        waitBlocking ();
        Actions action = new Actions (driver);
        try {
            action.moveToElement (MouseHoverValue);
            Thread.sleep (2000);
            action.moveToElement (MouseHoverElement).click ().build ().perform ();
            LOG.info ("Der Button ist betätigt");
            LOG.info ("Die ausgewählte Option ist selektiert");

            return true;
        } catch (WebDriverException | InterruptedException wde) {
            LOG.error ("Der Button ist nicht selektiert");

            return false;
        }
    }

    public boolean ScrollByToElement (WebElement MouseHoverValue, String VisibleElement){
        //This will scroll the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].scrollIntoView();", MouseHoverValue);
            LOG.info ("Der Element " + VisibleElement + " ist Sichtbar");
            return true;
        } catch (WebDriverException wde) {
            LOG.error ("Der Element " + VisibleElement + " ist nicht Sichtbar");
            return false;
        }
    }
    public Boolean clickLink (WebElement link, String linkName){
        waitBlocking ();
        try {
            if(link != null){
                link.click();
                LOG.info ("< Der Link " + "" + linkName + "" + " wurde angeklickt");
                return true;
            }
            else return null;
        } catch (WebDriverException wde) {
            LOG.error ("< Der Link " + "" + linkName + "" + " wird nicht dargestellt");
            return false;
        }
    }

    public boolean CloseTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles ());
        driver.switchTo ().window (tabs2.get (0));
        driver.close ();
        driver.switchTo ().window (tabs2.get (1));
        return true;
    }
}
