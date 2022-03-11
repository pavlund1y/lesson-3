package ru.rshb.intech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'HomePage__menu')]//*[text()='Пицца']")
    private WebElement pizzaBtn;

    @FindBy(xpath = "//*[@id='pizza']//*[contains(@class,'ProductCard')]")
    private List<WebElement> pizzaes;

    @FindBy(id = "pizza")
    private WebElement checkelelment;

    private WebElement choosedProduct = null;


    public WelcomePage(WebDriver argdriver) {
        PageFactory.initElements(argdriver, this);
        driver = argdriver;
    }

    public void pressPizzaBtn() {
        pizzaBtn.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkelelment));
    }

    public WebElement chooseProduct(String name) {
        for(WebElement product : pizzaes) {
            WebElement productText = product.findElement(By.xpath(".//h3"));
            if(productText.getText().equalsIgnoreCase(name)) {
                choosedProduct = product;
                return product;
            }
        }
        return null;
    }

    public boolean addToCart(){

        if(choosedProduct != null) {
            choosedProduct.findElement(By.xpath(".//*[text()='В корзину']")).click();
            return true;
        }
        return false;

    }

}
