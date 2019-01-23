package currency.structures;

import java.util.List;

public class CurrencyData {

    private String table;           // – typ tabeli

    private String country;         // – nazwa kraju                                               X
    private String symbol;          // – symbol waluty (numeryczny, dotyczy kursów archiwalnych)    X
    private String currency;        // – nazwa waluty
    private String code;            // – kod waluty

    private List<Rates> rates;          // – lista kursów poszczególnych walut w tabeli

    // for a the table with various currencies
    private String no;
    private String tradingDate;
    private String effectiveDate;

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

//        Collections.reverse(rates);

        for (Rates rate : rates)
            resultStr.append("\n"+rate.toString());

        return resultStr.toString();
    }
}
