package decorators;

import java.math.BigDecimal;
import java.util.Optional;

public class PLNConvertDecor {

    private BigDecimal amountOfCurrency;

    public PLNConvertDecor(String amountOfCurrency) {
        this.amountOfCurrency = valueCheck(amountOfCurrency);
    }

    private static BigDecimal valueCheck(String value) {
        Optional<BigDecimal> bigDecimalTestValue = Optional.ofNullable(new BigDecimal(value));
        BigDecimal bd;
        if (bigDecimalTestValue.isPresent()) {
            bd = new BigDecimal(value);
        } else
            throw new IllegalArgumentException("[ERROR] Wrong value of amount to convert to PLN");
        return bd;
    }

    public static String conversionToPLN(String amountOfcurrency) {


        return "";
    }

    public static String conversionFromPLN(String amountOfPLN) {
        StringBuilder result = new StringBuilder();

        BigDecimal fromPln = new BigDecimal(amountOfPLN);
        if (fromPln != null)
            ;
        else
            ;

        return result.toString();
    }

}
