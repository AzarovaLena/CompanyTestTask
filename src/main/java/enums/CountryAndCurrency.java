package enums;

public enum CountryAndCurrency {
    LITHUANIA("EUR", "Lithuania"),
    LATVIA("EUR", "Latvia"),
    ESTONIA("EUR", "Estonia"),
    BULGARIA("BGN", "Bulgaria"),
    SPAIN("EUR", "Spain"),
    ROMANIA("RON", "Romania"),
    POLAND("PLN", "Poland");

    private final String currency;
    private final String country;

    CountryAndCurrency(String currency, String country) {
        this.currency = currency;
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }
    public String getCountry() {
        return country;
    }
}
