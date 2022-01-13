package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CurrencyExchangePageFactory extends BasePage{

    @FindBy(xpath= "//a[contains(@class, 'btn btn-success')]")
    WebElement seeRatesBtn;
    @FindBy(xpath= "//input[contains(@data-ng-model, 'currencyExchangeVM.filter.from_amount')]")
    WebElement sellInput;
    @FindBy(xpath= "//input[contains(@data-ng-model, 'currencyExchangeVM.filter.to_amount')]")
    WebElement buyInput;
    @FindBy(xpath= "//td[contains(@data-ng-if, 'currencyExchangeVM.rates')]")
    WebElement currencyExchange;
    @FindBy(xpath= "//span[@data-ng-bind ='$select.selected']")
    WebElement currencyType;

    public CurrencyExchangePageFactory (){
        initElements(driver, this);
    }

    public CurrencyExchangePageFactory openPage() {
        openPageByUrl();
        return this;
    }

    public CurrencyExchangePageFactory moveToCurrencyExchangeBlock() {
        seeRatesBtn.click();
        wait.until(ExpectedConditions.visibilityOf(currencyExchange));
        return this;
    }

    public CurrencyExchangePageFactory enterTextInSellField(String text) {
        sellInput.click();
        sellInput.sendKeys(text);
        return this;
    }

    public CurrencyExchangePageFactory enterTextInBuyField(String text) {
        buyInput.click();
        buyInput.sendKeys(text);
        return this;
    }

    public String getTextInSellField() {
        return sellInput.getText();
    }

    public String getTextInBuyField() {
        return buyInput.getText();
    }

    public String getCurrencyType () {
        return currencyType.getText();
    }

    public String random () {
        Random ran = new Random();
        int result = ran.nextInt(1000);
        return String.valueOf(result);
    }
}
