import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rshb.intech.TestProperties;
import ru.rshb.intech.WelcomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTest extends BaseTest {

    private String name;

    WebDriver driver = null;
    TestProperties props;

    public MainTest(){
        super();
    }

    @Before
    public void init() {
//        System.setProperty("webdriver.gecko.driver", TestProperties.getInstance().get("webdriver.driver.path"));
//        driver = new FirefoxDriver();
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Ignore
    @Test
    public void testMethod() {

        props = TestProperties.getInstance();

        driver.get("https://papajohns.ru/moscow");

        WelcomePage page = new WelcomePage(driver);
        page.pressPizzaBtn();

        WebElement targetProduct = page.chooseProduct(arg);

        Assert.assertNotNull("Не найден искомый продукт",targetProduct);
        //Assert.assertNotEquals("Не найден искомый продукт", null, targetProduct);

        Assert.assertTrue("Добавление не было выполнено", page.addToCart());

            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Оформить']")));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMethod4(){
        System.out.println("1 - name4");
        //driver.get("https://yandex.ru");
        System.out.println("run test method2");
    }

    @Test
    public void testMethod3() {
        System.out.println("2 - name3 ");
    }

    @Test
    public void testMethod2() {
        System.out.println("3 - name2");

    }

    @After
    public void terminate(){
        //driver.quit();
    }
}
