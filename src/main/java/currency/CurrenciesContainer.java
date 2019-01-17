package currency;

import json_converter.JSONToCurrencyData;
import currency.structures.CurrencyData;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return currencies.entrySet().stream()
                .map(entry-> "\n" + entry.getKey().toUpperCase() + "\n" + entry.getValue().toString() + "\n")
                .collect(Collectors.joining());
    }
}
