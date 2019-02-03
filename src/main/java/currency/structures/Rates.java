package currency.structures;

public class Rates {

    private String no;              // – numer tabeli
    private String tradingDate;     // – data notowania (dotyczy tabeli C)
    private String effectiveDate;   // – data publikacji
    private String bid;             // – przeliczony kurs kupna waluty (dotyczy tabeli C)
    private String ask;             // – przeliczony kurs sprzedaży waluty (dotyczy tabeli C)
    private String mid;             // – przeliczony kurs średni waluty (dotyczy tabel A oraz B)       X

    // for a the table with various currencies
    private String currency;
    private String code;

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

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        StringBuilder resultStr = new StringBuilder();

        resultStr.append(no);
        if (tradingDate != null)
            resultStr.append("\t" + tradingDate);
        if (effectiveDate != null)
            resultStr.append("\t" + effectiveDate);
        if (bid != null)
            resultStr.append("\t" + "buy: " + bid + " PLN");
        if (ask != null)
            resultStr.append("\t" + "sell: " + ask + " PLN");
        if (mid != null)
            resultStr.append("\t" + "middle: " + mid + " PLN");

        return resultStr.toString();
    }
}
