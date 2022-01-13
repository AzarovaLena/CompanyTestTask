package webPagesTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webPages.CurrencyExchangeBlock;
import webPages.ResultCurrencyExchangeBlock;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ResultCurrencyExchangeBlockTest extends BaseTest {
    CurrencyExchangeBlock currencyExchangeBlock;
    ResultCurrencyExchangeBlock resultCurrencyExchangeBlock;

    @BeforeTest
    public void preconditions() {
        currencyExchangeBlock = new CurrencyExchangeBlock()
                .openPage();
        resultCurrencyExchangeBlock = new ResultCurrencyExchangeBlock();
    }

    @Test
    public void checkLossAmountRate() {
        currencyExchangeBlock
                .moveToCurrencyExchangeBlock();
        List<Double> companyAmount = resultCurrencyExchangeBlock.getCompanyAmount();
        List<Double> swedbankAmount = resultCurrencyExchangeBlock.getSwedbankAmount();
        List<Double> lossAmount = resultCurrencyExchangeBlock.getLossAmount();
        for (int i = 0; i < companyAmount.size(); i++) {
            Double swedbankAmountVal = swedbankAmount.get(i);
            if (swedbankAmountVal == 0.0) {
                continue;
            }
            Double expected = new BigDecimal(swedbankAmountVal - companyAmount.get(i))
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            Double actual = lossAmount.get(i);
            Assert.assertEquals(actual, expected);
        }
    }
}
