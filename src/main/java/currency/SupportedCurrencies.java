package currency;

import adapters.JSONToCurrencyData;
import currency.structures.CurrencyData;
import nbp.api.rest.NBPapi;

import java.util.Map;

public class SupportedCurrencies {

    private Map<String, String> availableCurrencies;

    public static String get(){
        CurrencyData currencyTableA = new JSONToCurrencyData().deserialization(NBPapi.getTables());


        return "";
    }
}
