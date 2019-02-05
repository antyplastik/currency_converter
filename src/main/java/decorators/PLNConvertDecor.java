package decorators;

import currency.structures.Rates;

import java.math.BigDecimal;
import java.util.Optional;

public class PLNConvertDecor implements Decorator<String, Rates> {

    private BigDecimal amountOfCurrency;
    private String amountCurrencyCode;

    public PLNConvertDecor(String amountOfCurrency, String amountCurrencyCode) {
        this.amountOfCurrency = valueCheck(amountOfCurrency);
        this.amountCurrencyCode = amountCurrencyCode;
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

    @Override
    public String decorate(String currencyCode, Rates rate) {
        StringBuilder stringBuilder = new StringBuilder();

        String bid = rate.getBid(); // sell
        String ask = rate.getAsk(); // buy
        String mid = rate.getMid();

        if (bid != null) {
            BigDecimal value = amountOfCurrency.divide(new BigDecimal(bid), 4, BigDecimal.ROUND_HALF_UP);
            stringBuilder.append("\tTo have " + amountOfCurrency.toPlainString()+ " "+ amountCurrencyCode + " you have to sell " + value.toPlainString() + " " + currencyCode);
        }
        if (ask != null) {
            BigDecimal value = amountOfCurrency.divide(new BigDecimal(ask), 4, BigDecimal.ROUND_HALF_UP);
            stringBuilder.append("\tFor " + amountOfCurrency.toPlainString()+ " "+ amountCurrencyCode + " you can buy " + value.toPlainString() + " " + currencyCode);
        }

        if (mid != null) {
            BigDecimal value = amountOfCurrency.divide(new BigDecimal(mid), 4, BigDecimal.ROUND_HALF_UP);
            stringBuilder.append("\t" + amountOfCurrency.toPlainString() + " is worth: " + value.toPlainString() + " " + currencyCode);
        }

        return stringBuilder.toString();
    }
}
