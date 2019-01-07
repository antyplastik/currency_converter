package nbp.api.currency.rates;

public class CurrencyTable {

    private String table;           // – typ tabeli

    private String country;         // – nazwa kraju                                               X
    private String symbol;          // – symbol waluty (numeryczny, dotyczy kursów archiwalnych)    X
    private String currency;        // – nazwa waluty
    private String code;            // – kod waluty

//    private CurrencyRate rates;           // – lista kursów poszczególnych walut w tabeli

    public CurrencyTable(String table, String country, String symbol, String currency, String code, String no, String tradingDate, String effectiveDate, String bid, String ask, String mid) {
        this.table = table;
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;

//        this.rates = new CurrencyRate(no, tradingDate, effectiveDate, bid, ask, mid);
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

//    public CurrencyRate getRates() {
//        return rates;
//    }
}
