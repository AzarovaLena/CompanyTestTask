package webPagesTest;

import base.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webPages.CurrencyExchangeBlock;

public class CurrencyExchangeBlockTest extends BaseTest {
    CurrencyExchangeBlock currencyExchangeBlock;

    @BeforeTest
    public void preconditions() {
        currencyExchangeBlock = new CurrencyExchangeBlock()
                .openPage();
    }

    @Test
    public void checkFieldCurrencyExchangeBlock() {
        String res = currencyExchangeBlock.random();
        currencyExchangeBlock
                .moveToCurrencyExchangeBlock()
                .enterTextInBuyField(res);
        Assert.assertEquals(currencyExchangeBlock.getTextInSellField(), StringUtils.EMPTY);
        currencyExchangeBlock
                .enterTextInSellField(res);
        Assert.assertEquals(currencyExchangeBlock.getTextInBuyField(), StringUtils.EMPTY);
    }
}