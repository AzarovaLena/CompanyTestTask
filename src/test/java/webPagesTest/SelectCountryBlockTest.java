package webPagesTest;

import base.BaseTest;
import enums.CountryAndCurrency;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import webPages.CurrencyExchangeBlock;
import webPages.SelectCountryBlock;

public class SelectCountryBlockTest extends BaseTest {
    CurrencyExchangeBlock currencyExchangeBlock;
    SelectCountryBlock selectCountryBlock;

    @BeforeTest
    public void preconditions() {
        currencyExchangeBlock = new CurrencyExchangeBlock()
                .openPage();
        selectCountryBlock = new SelectCountryBlock();
    }

    @DataProvider(name = "using enum with country name and currency type")
    public Object[][] currencyAndCountry() {
        return new Object[][]{
                {CountryAndCurrency.LATVIA},
                {CountryAndCurrency.BULGARIA},
                {CountryAndCurrency.ESTONIA},
                {CountryAndCurrency.POLAND},
                {CountryAndCurrency.SPAIN},
                {CountryAndCurrency.ROMANIA},
                {CountryAndCurrency.LITHUANIA}
        };
    }

    @Test(dataProvider = "using enum with country name and currency type")
    public void selectCountryCheckCurrencyType(CountryAndCurrency country) {
        currencyExchangeBlock.moveToCurrencyExchangeBlock();
        String currencyRate = selectCountryBlock.getCurrencyRate();
        selectCountryBlock.moveToCountryType()
                .clickCountryType()
                .clickCountryField()
                .selectCountry(country);
        currencyExchangeBlock.moveToCurrencyExchangeBlock();
        Assert.assertEquals(currencyExchangeBlock.getCurrencyType(), country.getCurrency());
        String currencyRateUpdated = selectCountryBlock.getCurrencyRate();
        Assert.assertNotEquals(currencyRate, currencyRateUpdated);
    }
}