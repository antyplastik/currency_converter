package currency.structures;

import java.util.List;

public class CurrencyData {

    private String table;           // – typ tabeli

    private String country;         // – nazwa kraju                                               X
    private String symbol;          // – symbol waluty (numeryczny, dotyczy kursów archiwalnych)    X
    private String currency;        // – nazwa waluty
    private String code;            // – kod waluty

    private List<Rates> rates;          // – lista kursów poszczególnych walut w tabeli


    public String getTable() {
        return table;
    }

    public String getCountry() {
        return country;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rates> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        StringBuilder resultStr = new StringBuilder();

        resultStr.append("Currency: " + code);
        resultStr.append("\nCurrency name: " + currency);
        resultStr.append("\nCurrency used in "+ country);

        for (Rates rate : rates)
            resultStr.append("\n"+rate.toString());

        return resultStr.toString();
    }
}
