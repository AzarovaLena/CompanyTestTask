package webPages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class CurrencyExchangeBlock extends BasePage {

    private final By seeRatesBtn = By.xpath("//a[contains(@class, 'btn btn-success')]");
    private final By sellInput = By.xpath("//input[contains(@data-ng-model, 'currencyExchangeVM.filter.from_amount')]");
    private final By buyInput = By.xpath("//input[contains(@data-ng-model, 'currencyExchangeVM.filter.to_amount')]");
    private final By currencyExchange = By.xpath("//td[contains(@data-ng-if, 'currencyExchangeVM.rates')]");
    private final By currencyType = By.xpath("//span[@data-ng-bind ='$select.selected']");

    public CurrencyExchangeBlock openPage() {
        openPageByUrl();
        return this;
    }

    public CurrencyExchangeBlock moveToCurrencyExchangeBlock() {
        click(seeRatesBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencyExchange));
        return this;
          }

    public CurrencyExchangeBlock enterTextInSellField(String text) {
        click(sellInput);
        sendKeys(sellInput, text);
        return this;
    }

    public CurrencyExchangeBlock enterTextInBuyField(String text) {
        click(buyInput);
        sendKeys(buyInput, text);
        return this;
    }

    public String getTextInSellField() {
        return getText(sellInput);
    }

    public String getTextInBuyField() {
        return getText(buyInput);
    }

    public String getCurrencyType () {
       return getText(currencyType);
    }

    public String random () {
        Random ran = new Random();
        int result = ran.nextInt(1000);
       return String.valueOf(result);
    }

}