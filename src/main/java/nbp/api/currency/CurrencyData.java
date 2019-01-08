package nbp.api.currency;

import java.util.List;

public class CurrencyData {

    private String table;           // – typ tabeli

    private String country;         // – nazwa kraju                                               X
    private String symbol;          // – symbol waluty (numeryczny, dotyczy kursów archiwalnych)    X
    private String currency;        // – nazwa waluty
    private String code;            // – kod waluty

    private List<Rates> rates;          // – lista kursów poszczególnych walut w tabeli

    public CurrencyData(String table, String country, String symbol, String currency, String code, List<Rates> rates) {
        this.table = table;
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

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
}
