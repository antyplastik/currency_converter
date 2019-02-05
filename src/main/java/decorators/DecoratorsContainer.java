package decorators;

import currency.structures.CurrencyData;
import currency.structures.Rates;

import java.util.*;
import java.util.stream.Collectors;

public class DecoratorsContainer {

    private List containerList = new LinkedList();
    private Map<String, List<String>> resultMap = new HashMap();

    public void add(String currencyCode, CurrencyData currencyData, List<Decorator> decorators) {
        List<Rates> currencyRatesList = currencyData.getRates();
        List<String> currencyRatesResult = new ArrayList<>();

        for (Rates oneRate : currencyRatesList) {
            StringBuilder rateStr = new StringBuilder(oneRate.toString());

            for (Decorator decorator : decorators) {
                rateStr.append(decorator.decorate(currencyCode, oneRate));
            }
            currencyRatesResult.add(rateStr.toString());
        }

        currencyRatesResult.add(0, ("Currency: " + currencyData.getCode()+ "\nCurrency name: "+ currencyData.getCurrency()));

        resultMap.put(currencyCode, currencyRatesResult.stream()
                .map(s -> s + "\n")
                .collect(Collectors.toList()));
    }

    public Object get(String objectToFind) {

        return null;
    }

    public String toString() {
//        String result = resultMap.entrySet().stream()
//                .map(entry ->entry.getValue().toString() + "\n")
//                .map(e->e.replaceAll(",",""))
//                .collect(Collectors.joining())
//                ..replaceAll("\\[","")
//                .replaceAll(",","")
//                .replaceAll("\\]","");

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, List<String>> entry: resultMap.entrySet()){
            sb.append(entry.getValue());
        }

        return sb.toString().replaceAll("\\[","").replaceAll(",","").replaceAll("\\]","");
    }
}
