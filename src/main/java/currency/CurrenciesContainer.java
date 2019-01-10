package currency;

import converter.JSONToCurrencyData;

import java.util.HashMap;
import java.util.Map;

public class CurrenciesContainer implements Container<CurrencyData, String> {

    private Map<String, CurrencyData> currencies = new HashMap<>();

    @Override
    public void add(String objectToSet) {
        CurrencyData currency = new JSONToCurrencyData().deserialization(objectToSet);
        currencies.put(currency.getCode(), currency);
    }

    @Override
    public CurrencyData get(String objectToFind) {
        return currencies.get(objectToFind);
    }

    public Map<String, CurrencyData> getCurrencies() {
        return currencies;
    }
}
