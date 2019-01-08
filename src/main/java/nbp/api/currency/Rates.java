package nbp.api.currency;

public class Rates {

    private String no;              // – numer tabeli

    private String tradingDate;     // – data notowania (dotyczy tabeli C)
    private String effectiveDate;   // – data publikacji
    private String bid;             // – przeliczony kurs kupna waluty (dotyczy tabeli C)
    private String ask;             // – przeliczony kurs sprzedaży waluty (dotyczy tabeli C)
    private String mid;             // – przeliczony kurs średni waluty (dotyczy tabel A oraz B)       X

    public Rates(String no, String tradingDate, String effectiveDate, String bid, String ask, String mid) {
        this.no = no;
        this.tradingDate = tradingDate;
        this.effectiveDate = effectiveDate;
        this.bid = bid;
        this.ask = ask;
        this.mid = mid;
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
