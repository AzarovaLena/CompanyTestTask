package webPages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultCurrencyExchangeBlock extends BasePage {
    private final By companyAmount = By.xpath("//td[4]//span[@class='ng-binding']");
    public String swedbankAmount = ("//tr[%s]//td[@data-title='Swedbank amount']//span[@class='ng-binding']");
    public String lossAmount = ("//tr[%s]//td[5]//span[2]");

    public List<Double> getCompanyAmount() {
        return driver.findElements(companyAmount)
                .stream()
                .map(WebElement::getText)
                .map(s -> s.replaceAll(",", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public List<Double> getSwedbankAmount() {
        List<Double> payseraAm = getCompanyAmount();
        List<Double> swedbankAm = new ArrayList<>();
        for (int i = 1; i < payseraAm.size() + 1; i++) {
            try {
                swedbankAm.add(Double.valueOf(driver.findElement(By.xpath(String.format(swedbankAmount, i)))
                        .getText()));
            } catch (Exception ignored) {
                swedbankAm.add(0.0);
            }
        }
        return swedbankAm;
    }

    public List<Double> getLossAmount() {
        List<Double> payseraAm = getCompanyAmount();
        List<Double> lossAm = new ArrayList<>();

        for (int i = 1; i < payseraAm.size() + 1; i++) {
            try {
                lossAm.add(
                        getSubStrForLoss(driver.findElement(By.xpath(String.format(lossAmount, i)))
                                .getText()
                        ));
            } catch (Exception ignored) {
                lossAm.add(0.0);
            }
        }
        return lossAm;
    }

    public Double getSubStrForLoss(String text) {
        return Double.valueOf(StringUtils.substringBetween(text, "(", ")"));
    }
}