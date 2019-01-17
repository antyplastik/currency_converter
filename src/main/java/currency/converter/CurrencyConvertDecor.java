package currency.converter;

import currency.structures.CurrencyData;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConvertDecor {

    public static String conversionToPLN(Map<String, CurrencyData> currencyDataMap, String foreignCurrency) {
        String result = "";

        BigDecimal toPln = new BigDecimal(foreignCurrency);
        if(toPln != null)
            ;
        else
            ;

        return result;
    }

    public static String conversionFromPLN(Map<String, CurrencyData> currencyDataMap, String pln) {
        String result = "";

        BigDecimal fromPln = new BigDecimal(pln);
        if(fromPln != null)
            ;
        else
            ;

        return result;
    }

}
