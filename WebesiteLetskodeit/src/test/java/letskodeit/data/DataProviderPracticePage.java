package letskodeit.data;

import org.testng.annotations.DataProvider;

public class DataProviderPracticePage {

    private static Object[][] provide(final String url, final String brand, final String color, final String text ){
        String[] retVal = {url,brand,color,text};

        return new Object[][]{{retVal}};
    }

    @DataProvider(name = "benz_01")
    public static Object[][] benz_01(){
        return provide("https://letskodeit.teachable.com/","benz", "orange","loreYpsheft");
    }

    @DataProvider(name = "honda_01")
    public static Object[][] honda_01(){
        return provide("https://letskodeit.teachable.com/","honda", "peach",null);
    }
}
