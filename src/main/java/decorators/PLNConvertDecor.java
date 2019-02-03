package decorators;

import currency.structures.Rates;

import java.math.BigDecimal;
import java.util.Optional;

public class PLNConvertDecor implements Decorator<String, Rates> {

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

    @Override
    public String decorate(String currencyCode, Rates rate) {
        StringBuilder stringBuilder = new StringBuilder();

        String bid = rate.getBid(); // sell
        String ask = rate.getAsk(); // buy
        String mid = rate.getMid();

        if (bid != null) {
            BigDecimal value = amountOfCurrency.divide(new BigDecimal(bid),4,BigDecimal.ROUND_HALF_UP);
            stringBuilder.append("You can sell: " + value.toPlainString() + " " + currencyCode + "\t");
        }
        if (ask != null) {
            BigDecimal value = amountOfCurrency.divide(new BigDecimal(ask),BigDecimal.ROUND_HALF_UP);
            stringBuilder.append("You can buy: " + value.toPlainString() + " " + currencyCode + "\t");
        }

        if (mid != null) {
            BigDecimal value = amountOfCurrency.divide(new BigDecimal(bid));
            stringBuilder.append("Is worth: " + value.toPlainString() + " " + currencyCode);
        }

        return stringBuilder.toString();
    }
}
