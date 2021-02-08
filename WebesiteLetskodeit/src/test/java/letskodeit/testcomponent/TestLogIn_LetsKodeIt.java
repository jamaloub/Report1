package letskodeit.testcomponent;

import letskodeit.data.DataProviderLogIn;
import org.testng.annotations.Test;
import letskodeit.test.BrowserControler;
import static org.testng.Assert.assertTrue;

public class TestLogIn_LetsKodeIt extends BrowserControler {

    @Test(priority =1, dataProvider = "jamalLogIn", dataProviderClass = DataProviderLogIn.class)
    public void logIn(String[] params){
        String url = params[0];
        String email = params[1];
        String password = params[2];

        assertTrue(coursesObject.visit (url));
        assertTrue (coursesObject.clickButton (coursesObject.CLICK_LOGIN_BUTTON));
        assertTrue (coursesObject.setInputField (coursesObject.INPUT_EMAIL_ADDRESS, email));
        assertTrue (coursesObject.setInputField (coursesObject.INPUT_PASSWORD, password));
        assertTrue (coursesObject.clickButton (coursesObject.CLICK_COMMIT_BUTTON));
    }

    @Test(priority =1, dataProvider = "forgottenPswd", dataProviderClass = DataProviderLogIn.class)
    public void forgotPassword( String[] params) throws InterruptedException {
        String url = params[0];
        String email = params[1];

        assertTrue (coursesObject.visit (url));
        assertTrue (coursesObject.clickButton (coursesObject.CLICK_LOGIN_BUTTON));
        Thread.sleep (3000);
        assertTrue (coursesObject.clickButton (coursesObject.CLICK_FORGOT_PASSWORD_LINK));
        assertTrue (coursesObject.setInputField (coursesObject.INPUT_EMAIL_ADDRESS, email));
        assertTrue (coursesObject.clickButton (coursesObject.CLICK_COMMIT_BUTTON));

    }

}
