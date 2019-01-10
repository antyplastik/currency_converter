package converter;

import com.google.gson.Gson;
import currency.CurrencyData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JSONandObject implements Converter<CurrencyData, Gson> {

    private Gson gson;

    public JSONandObject() {
        this.gson = new Gson();
    }

    @Override
    public Gson serialization(String strToSerial) {
        gson.toJson(strToSerial);
        return gson;
    }

    @Override
    public CurrencyData deserialization(String jsonStr) {
        List<String> list = Arrays.stream(jsonStr
                .split("\n"))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++)
            list.remove(0);

        String formattedJson = list.stream().collect(Collectors.joining()).replaceAll("([\\']{2,})", "");
        CurrencyData JSONtoCurrencyData = gson.fromJson(formattedJson, CurrencyData.class);

        return JSONtoCurrencyData;
    }
}
