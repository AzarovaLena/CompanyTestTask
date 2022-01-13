package webPagesTest;

import base.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webPages.CurrencyExchangeBlock;
import webPages.CurrencyExchangePageFactory;

public class CurrencyExchangePageFactoryTest extends BaseTest {
    CurrencyExchangePageFactory currencyExchangePageFactory;


    @BeforeTest
    public void preconditions() {
        currencyExchangePageFactory = new CurrencyExchangePageFactory()
                .openPage();
    }

    @Test
    public void checkFieldCurrencyExchangeBlock() {
        String res = currencyExchangePageFactory.random();
        currencyExchangePageFactory
                .moveToCurrencyExchangeBlock()
                .enterTextInBuyField(res);
        Assert.assertEquals(currencyExchangePageFactory.getTextInSellField(), StringUtils.EMPTY);
        currencyExchangePageFactory
                .enterTextInSellField(res);
        Assert.assertEquals(currencyExchangePageFactory.getTextInBuyField(), StringUtils.EMPTY);
    }
}
