package currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyContainer implements Container<CurrencyData, String> {

    private Map<String, CurrencyData> currencies;

    public CurrencyContainer() {
        currencies = new HashMap<>();
    }

    @Override
    public void add(CurrencyData objectToSet) {
        currencies.put(objectToSet.getCode(), objectToSet);
    }

    @Override
    public CurrencyData get(String objectToFind) {
        return currencies.get(objectToFind);
    }

}
