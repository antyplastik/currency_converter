package nbp.api.currency;

import nbp.api.currency.rates.CurrencyTable;

import java.util.Map;

public class CurrencyImpl implements Currency {

    private String currencyLabel;
    private Map<String, String> currencyParameters;

    private CurrencyTable currency;

    public CurrencyImpl(CurrencyTable currency) {
        this.currency = currency;
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
