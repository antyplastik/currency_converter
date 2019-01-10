package converter;

import com.google.gson.Gson;
import currency.CurrencyData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JSONandObject implements Converter<CurrencyData, String> {

    @Override
    public String serialization(String strToSerial) {
        return new Gson().toJson(strToSerial);
    }

    @Override
    public CurrencyData deserialization(String jsonStr) {
        List<String> list = Arrays.stream(jsonStr
                .split("\n"))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++)
            list.remove(0);

        String formattedJson = list.stream().collect(Collectors.joining());
        return new Gson().fromJson(formattedJson, CurrencyData.class);
    }
}
