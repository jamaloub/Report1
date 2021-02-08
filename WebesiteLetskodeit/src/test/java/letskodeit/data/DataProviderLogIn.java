package letskodeit.data;

import org.testng.annotations.DataProvider;

public class DataProviderLogIn {

    private static Object[][] provide(final String url, final String usr, final String psswd ){
        String[] retVal = {url,usr,psswd};

        return new Object[][]{{retVal}};
    }

    @DataProvider(name = "jamalLogIn")
    public static Object[][] jamalLogIn(){
        return provide("https://letskodeit.teachable.com/","Jamal_oubaouih@yahoo.de", "1111");
    }

    @DataProvider(name = "forgottenPswd")
    public static Object[][] forgottenPswd(){
        return provide("https://letskodeit.teachable.com/","Jamal_oubaouih@yahoo.de", null);
    }
}
