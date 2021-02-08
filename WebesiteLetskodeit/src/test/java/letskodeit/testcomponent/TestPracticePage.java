package letskodeit.testcomponent;

import letskodeit.data.DataProviderLogIn;
import letskodeit.data.DataProviderPracticePage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import letskodeit.test.BrowserControler;
import pageObjects.letskodeit.PracticePage;
import static org.testng.Assert.assertTrue;

public class TestPracticePage extends BrowserControler {

    @Test(priority = 1, dataProvider = "benz_01", dataProviderClass = DataProviderPracticePage.class)
    public void selectBenzCar(String[] params){
        String url = params[0];
        String brand = params[1];
        String color = params[2];
        String text = params[3];

        assertTrue(practicePageObject.visit (url));
        assertTrue(practicePageObject.clickLink(PracticePage.PRACTICE_LINK));
        assertTrue(practicePageObject.checkRadioBox (PracticePage.CAR_BENZ_BUTTON));
        assertTrue(practicePageObject.selectValue(PracticePage.SELECT_CAR, brand));
        assertTrue(practicePageObject.selectValue (PracticePage.SELECT_COLOR, color));
        assertTrue(practicePageObject.checkRadioBox (PracticePage.CAR_BENZ_CHECK));
        assertTrue(practicePageObject.setInputField (PracticePage.INPUT_YOUR_NAME, text));
        assertTrue(practicePageObject.scrollToElement(PracticePage.MOUSE_EFFECT));
        assertTrue(practicePageObject.mouseHoverButton(PracticePage.MOUSE_EFFECT, PracticePage.SELECT_TOP_VALUE));
        assertTrue(practicePageObject.clickButton (PracticePage.OPEN_TAB));

        practicePageObject.CloseTab();
    }

    @Test(priority = 2, dataProvider = "honda_01", dataProviderClass = DataProviderPracticePage.class)
    public void selectHondaCar(String[] params){
        String url = params[0];
        String brand = params[1];
        String color = params[2];

        assertTrue (practicePageObject.visit (url));
        assertTrue(practicePageObject.clickLink(PracticePage.PRACTICE_LINK));
        assertTrue (practicePageObject.checkRadioBox (PracticePage.CAR_HONDA_BUTTON));
        assertTrue (practicePageObject.selectValue(PracticePage.SELECT_CAR, brand));
        assertTrue (practicePageObject.selectValue (PracticePage.SELECT_COLOR, color));
        assertTrue (practicePageObject.checkRadioBox (PracticePage.CAR_HONDA_CHECK));
    }
}
