package nbp.api.currency;

public class CurrencyObj {

    private String table;           // – typ tabeli
    private String no;              // – numer tabeli
    private String tradingDate;     // – data notowania (dotyczy tabeli C)
    private String effectiveDate;   // – data publikacji
//    private String rates;           // – lista kursów poszczególnych walut w tabeli
    private String country;         // – nazwa kraju                                               X
    private String symbol;          // – symbol waluty (numeryczny, dotyczy kursów archiwalnych)    X
    private String currency;        // – nazwa waluty
    private String code;            // – kod waluty
    private String bid;             // – przeliczony kurs kupna waluty (dotyczy tabeli C)
    private String ask;             // – przeliczony kurs sprzedaży waluty (dotyczy tabeli C)
    private String mid;             // – przeliczony kurs średni waluty (dotyczy tabel A oraz B)       X

    public CurrencyObj(String table, String no, String tradingDate, String effectiveDate, String country,
                        String symbol, String currency, String code, String bid, String ask, String mid) {
        this.table = table;
        this.no = no;
        this.tradingDate = tradingDate;
        this.effectiveDate = effectiveDate;
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
        this.mid = mid;
    }

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
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

    public String getBid() {
        return bid;
    }

    public String getAsk() {
        return ask;
    }

    public String getMid() {
        return mid;
    }


}
