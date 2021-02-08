package letskodeit.testcomponent;

import java.io.IOException;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
Lieber Jamal, versuch doch mal das hier in die Sturktur zu überführen ;)
 */

public class ReadPdfDocument_TODO {
    WebDriver driver;
    static Logger LOG = Logger.getLogger(ReadPdfDocument_TODO.class);

    public String url;
    public String Text = "The pdf995 suite of products";

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty ("webdriver.chrome.driver", "C:/Users/jamal/IdeaProjects/WebesiteLetskodeit/Driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
        driver.get ("http://tinyupload.com/");


    }

    @Test
    public void ReadPdf() throws InterruptedException, IOException {
        Thread.sleep (5000);
        driver.findElement (By.cssSelector ("input[name='uploaded_file']")).click ();
//        driver.findElement(By.name("uploaded_file")).sendKeys(Keys.RETURN);
        // file:///C:/Users/jamal/Desktop/QS-Pr%C3%A4sentation.pdf
    }

        /*URL url = new URL ("file:///C:/Users/jamal/Desktop/QS-Pr%C3%A4sentation.pdf");
        Thread.sleep (5000);
        InputStream is = url.openStream ();
        BufferedInputStream fileParse = new BufferedInputStream (is);
        PDDocument document = null;

        document = PDDocument.load (fileParse);
        String pdfContent = new PDFTextStripper ().getText (document);
        try {
            Assert.assertTrue ((pdfContent.contains ("Akzeptanz")));
            LOG.info("Matching word: Akzeptanz");
            //System.out.println (pdfContent.contains ("Akzeptanz") + " - passed");

        } catch (AssertionError e) {
            //System.out.println (pdfContent.contains ("Akzeptanz") + " - failed");
            LOG.error ("No match word: Akzeptanz");
            throw e;
        }

        try {
            Assert.assertTrue ((pdfContent.contains ("Koordiniert")));
            //System.out.println (pdfContent.contains ("Koordiniert") + " - passed");
            LOG.info("Matching word: Koordiniert");

        } catch (AssertionError e) {
           // System.out.println (pdfContent.contains ("Koordiniert") + " - failed");
            LOG.error ("No match word: Akzeptanz");
            throw e;
        }

        try {
            Assert.assertTrue ((pdfContent.contains ("Komponenten")));
            LOG.info("Matching word: Komponenten");
           // System.out.println (pdfContent.contains ("Komponenten") + " - passed");

        } catch (AssertionError e) {
            //System.out.println (pdfContent.contains ("Komponenten") + " - failed");
            LOG.error ("No match word: Komponenten");
            throw e;
        }
        System.out.println (pdfContent);
    }


    /*@AfterTest()
    public void ThreadDown(){
        driver.close ();
    }*/



}
