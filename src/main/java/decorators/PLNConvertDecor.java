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
    public String decorate(Rates rate) {
        StringBuilder stringBuilder = new StringBuilder();
        BigDecimal value;

        String bid = rate.getBid(); // sell
        String ask = rate.getAsk(); // buy
        String mid = rate.getMid();

        if (bid != null) {
            value = amountOfCurrency.divide(new BigDecimal(bid));
            stringBuilder.append("You can buy: " + value.toPlainString() + "\t");
        }
        if (ask != null) {
            value = amountOfCurrency.divide(new BigDecimal(ask));
            stringBuilder.append("You can get: " + value.toPlainString() + "\t");
        }

        if (mid != null) {
            value = amountOfCurrency.divide(new BigDecimal(bid));
            stringBuilder.append("You can buy: " + value.toPlainString());
        }

        return stringBuilder.toString();
    }
}
