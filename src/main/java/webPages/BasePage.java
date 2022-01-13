package webPages;

import driver.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertyReader;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    protected BasePage() {
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 40);
        properties = PropertyReader.getProperties();
    }

    protected void openPageByUrl() {
        driver.get(properties.getProperty("url"));
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void sendKeys(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    protected String getText(By element) {
       return driver.findElement(element).getText();
    }

    protected void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }
}