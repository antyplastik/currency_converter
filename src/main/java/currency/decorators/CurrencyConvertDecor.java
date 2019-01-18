package currency.decorators;

import currency.structures.CurrencyData;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConvertDecor {

    public  String conversionToPLN(Map<String, CurrencyData> currencyDataMap, String foreignCurrency) {
        StringBuilder result = new StringBuilder();

        BigDecimal toPln = new BigDecimal(foreignCurrency);
        if(toPln != null)
            ;
        else
            ;

        return result.toString();
    }

    public static String conversionFromPLN(Map<String, CurrencyData> currencyDataMap, String pln) {
        StringBuilder result = new StringBuilder();

        BigDecimal fromPln = new BigDecimal(pln);
        if(fromPln != null)
            ;
        else
            ;

        return result.toString();
    }

}
