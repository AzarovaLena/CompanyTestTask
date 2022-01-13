package webPages;

import enums.CountryAndCurrency;
import org.openqa.selenium.By;

public class SelectCountryBlock extends BasePage {
    private final By localization = By.xpath("//span[contains(@class, 'js-localization-popover')]");
    private final By countryNameField = By.id("countries-dropdown");
    public String countryName = "//a[text()[contains(.,'%s')]]";
    private final By currencyRate = By.xpath("//tr[contains(@data-ng-repeat, 'currency_to in currencyExchange')]");

    public SelectCountryBlock moveToCountryType() {
        moveToElement(driver.findElement(localization));
        return this;
    }

    public SelectCountryBlock clickCountryType() {
        click(localization);
        return this;
    }

    public SelectCountryBlock clickCountryField() {
        click(countryNameField);
        return this;
    }

    public SelectCountryBlock selectCountry(CountryAndCurrency country) {
        driver.findElement(By.xpath(String.format(countryName, country.getCountry())))
                .click();
        return this;
    }

    public String getCurrencyRate(){
        return getText(currencyRate);
    }
}