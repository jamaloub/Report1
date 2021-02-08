package pageObjects.letskodeit;

import org.apache.log4j.Logger;
import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends BasePage {
    private final static Logger LOG = Logger.getLogger (PracticePage.class);

    public static final String INPUT_YOUR_NAME = "INPUT_YOUR_NAME";
    public static final String OPEN_TAB = "OPEN_TAB";
    public static final String SELECT_CAR = "SELECT_CAR";
    public static final String CAR_HONDA_BUTTON = "CAR_HONDA_BUTTON";
    public static final String CAR_BMW_BUTTON = "CAR_BMW_BUTTON";
    public static final String CAR_BENZ_BUTTON = "CAR_BENZ_BUTTON";
    public static final String CAR_HONDA_CHECK = "CAR_HONDA_CHECK";
    public static final String CAR_BENZ_CHECK = "CAR_BENZ_CHECK";
    public static final String SELECT_COLOR = "SELECT_COLOR";
    public static final String MOUSE_EFFECT = "MOUSE_EFFECT";
    public static final String SELECT_TOP_VALUE = "SELECT_TOP_VALUE";
    public static final String PRACTICE_LINK = "PRACTICE_LINK";


    //Radio Button Example Elements
    @FindBy(xpath = "//input[@id='hondaradio']")
    private WebElement hondaRadio;
    @FindBy(xpath = "//input[@id='benzradio']")
    private WebElement BenzRadio;
    @FindBy(xpath = " //input[@id='bmwcheck']")
    private WebElement BmwRadio;

    //CheckBox Example Elements
    @FindBy(xpath = "//input[@id='hondacheck']")
    private WebElement hondacheck;
    @FindBy(xpath = "//input[@id='benzcheck']")
    private WebElement benzcheck;

    //Select Class Example Elements
    @FindBy(xpath = "//select[@id='carselect']")
    private WebElement selecCarValue;
    @FindBy(xpath = "//select[@id='carselect']")
    private WebElement selectHonda;

    //Multiple Select Example Elements
    @FindBy(xpath = "//select[@id='multiple-select-example']")
    private WebElement selectColorValue;

    @FindBy(xpath = "//a[@id='opentab']")
    private WebElement openTabElement;

    //Input Value
    @FindBy(xpath = "//input[@id='name']")
    public WebElement enterName;

    //Buttons Elements
    @FindBy(xpath = "//button[@id='mousehover']")
    private WebElement mouseHover;


    @FindBy(xpath = "//a[contains(text(),'Top')]")
    private WebElement clickTop;

    @FindBy(xpath ="//legend[contains(text(),'Mouse Hover Example')]")
    private WebElement MoveTo;

    @FindBy(css= "a[href='/pages/practice']")
    private WebElement practiceLink;

    public PracticePage(WebDriver driver) {
        super (driver);
    }

    public Boolean clickLink(String field){
        WebElement link = null;
        switch (field){
            case PRACTICE_LINK:{
                link = practiceLink;
                break;
            }
        }
        return super.clickLink(link,field);
    }

    public boolean setInputField(String FieldName, String value) {
        WebElement inputField = null;
        String inputValue= value;
        switch (FieldName) {
            case INPUT_YOUR_NAME:
                inputField = enterName;
                break;
        }

        return super.type (inputField,inputValue);
    }

    public boolean selectValue(String FieldName, String inputValue) {
        WebElement select = null;
        switch (FieldName) {
            case SELECT_CAR:
                select = selecCarValue;
                break;
            case SELECT_COLOR:
                select = selectColorValue;
                break;

        }

        return super.selectComboBoxValue(select, inputValue);
    }

    public boolean clickButton(String FieldName) {
        WebElement button = null;
        switch (FieldName) {
            case OPEN_TAB:
                button = openTabElement;
                break;
        }

        return super.clickButton (button,FieldName);
    }

    public boolean checkRadioBox(String FieldName) {
        WebElement radioButtonValue = null;
        switch (FieldName) {
            case CAR_HONDA_BUTTON:
                radioButtonValue = hondaRadio;
                break;
            case CAR_BMW_BUTTON:
                radioButtonValue = BmwRadio;
                break;
            case CAR_BENZ_BUTTON:
                radioButtonValue = BenzRadio;
                break;
            case CAR_HONDA_CHECK:
                radioButtonValue = hondacheck;
                break;
            case CAR_BENZ_CHECK:
                radioButtonValue = benzcheck;
                break;
        }

        return super.radioButton (radioButtonValue,FieldName);
    }

     public boolean mouseHoverButton(String MouseHoverButton, String HoverOption){
         WebElement MouseHoverValue = null;
         WebElement MouseHoverElement = null;

         switch (MouseHoverButton) {
             case MOUSE_EFFECT:
                 MouseHoverValue = mouseHover;
                 break;
         }
                switch (HoverOption) {
                    case SELECT_TOP_VALUE:
                        MouseHoverElement = clickTop;
                        break;
                }
         return super.HoverMouse (MouseHoverValue,MouseHoverElement);
     }

    public boolean scrollToElement(String VisibleElement){
        WebElement ScrollToElement= null;
        switch (VisibleElement) {
            case MOUSE_EFFECT:
                ScrollToElement = MoveTo;
                break;
        }

        return super.ScrollByToElement (ScrollToElement, VisibleElement);
    }

    public boolean CloseTab(){
        return super.CloseTab ();
    }

}