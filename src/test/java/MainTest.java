import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTest {

    WebDriver driver = null;

    @Before
    public void init() {
        System.setProperty("webdriver.gecko.driver", "drvs/geckodriver.exe");
        driver = new FirefoxDriver();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() {
        driver.get("https://papajohns.ru/moscow");

        WebElement pizzaButton = driver.findElement(By.xpath("//*[contains(@class, 'HomePage__menu')]//*[text()='Пицца']"));
        pizzaButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("pizza")));

        List<WebElement> pizzas = driver.findElements(By.xpath("//*[@id='pizza']//*[contains(@class,'ProductCard')]"));

        WebElement targetProduct = null;
        for(WebElement product : pizzas) {
            WebElement productText = product.findElement(By.xpath(".//h3"));
            if(productText.getText().equalsIgnoreCase("Сердце Пепперони1")) {
                targetProduct = product;
                break;
            }
        }

        Assert.assertTrue(targetProduct != null);


            WebElement toCartBtn = targetProduct.findElement(By.xpath(".//*[text()='В корзину']"));
            toCartBtn.click();

//            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Оформить']")));
//
//            WebElement confirmBtm = driver.findElement(By.xpath("//*[text()='Оформить']"));
//            confirmBtm.click();
//
//            new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Ваши контакты']")));
//            new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://papajohns.ru/moscow/order"));
//
//            //if(driver.getCurrentUrl().equalsIgnoreCase("https://papajohns.ru/moscow/order")) {
//                System.out.println("continue order");
    }
    @Test
    public void testMethod2(){
        driver.get("https://yandex.ru");
        System.out.println("run test method2");
    }

    @After
    public void terminate(){
        driver.quit();
    }
}
