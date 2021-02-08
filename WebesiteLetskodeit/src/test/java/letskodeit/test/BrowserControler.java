package letskodeit.test;


import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.letskodeit.LoginPage;
import pageObjects.letskodeit.PracticePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserControler {
    protected WebDriver driver;
    protected final static Logger LOG = Logger.getLogger(BrowserControler.class);
    protected static LoginPage coursesObject;
    protected static PracticePage practicePageObject;

    @Parameters({"browsername"})
    @BeforeMethod
    protected void setup(@Optional("firefox") String browsername) {
        String userDir = System.getProperty("user.dir");

        LOG.info("Userdir: "+userDir);

        if (browsername.equals("firefox")){
            System.setProperty ("webdriver.gecko.driver", userDir+ "\\Driver\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();

        }else if (browsername.equals("chrome")){
            System.setProperty ("webdriver.chrome.driver", userDir+ "\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();

        }else{
            LOG.error("Browser was not chrome or firefox");
            System.exit(-1);
        }

        driver.manage ().window ().maximize ();

        coursesObject = new LoginPage(driver);
        practicePageObject = new PracticePage(driver);
    }

    @AfterMethod()
    public void ThreadDown(){
        if(driver != null)
          driver.quit ();
    }
}
