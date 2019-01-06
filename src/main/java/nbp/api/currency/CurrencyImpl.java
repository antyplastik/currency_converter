package nbp.api.currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyImpl implements Currency {

    private String currencyLabel;
    private Map<String, String> currencyParameters;

    private CurrencyObj currency;

    public CurrencyImpl(CurrencyObj currency) {
        this.currency = currency;
    }

    private void mapInit() {
        if (!currency.equals(null)) {
            currencyParameters = new HashMap<>();
            currencyParameters.put("table", currency.getTable());
            currencyParameters.put("no", currency.getNo());
            currencyParameters.put("tradingDate", currency.getTradingDate());
            currencyParameters.put("effectiveDate", currency.getEffectiveDate());
//            currencyParameters.put("rates", currency.getRates());
            currencyParameters.put("country", currency.getCountry());
            currencyParameters.put("symbol", currency.getSymbol());
            currencyParameters.put("currency", currency.getCurrency());
            currencyParameters.put("code", currency.getCode());
            currencyParameters.put("bid", currency.getBid());
            currencyParameters.put("ask", currency.getAsk());
            currencyParameters.put("mid", currency.getMid());
        }
    }

    @Override
    public void setCurrency(String parameter, String value) {
        currencyParameters.replace(parameter, value);
    }

    @Override
    public Map<String, String> getCurrencyMap() {
        return currencyParameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : currencyParameters.entrySet())
            if (!entry.getValue().equals(null))
                sb.append(entry.getKey() + ": " + entry.getValue() + "\n");

        return sb.toString();
    }

}
