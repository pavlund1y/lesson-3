import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public abstract class BaseTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Сердце Пепперони"}
                //,{"Сердце Пепперони2"}
        });
    }

    @Parameterized.Parameter(0)
    public String arg;



}
