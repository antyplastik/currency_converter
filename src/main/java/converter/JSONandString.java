package converter;

import com.google.gson.Gson;
import nbp.api.currency.CurrencyObj;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JSONandString implements Converter<String, Gson> {

    private Gson gson;

    public JSONandString() {
        this.gson = new Gson();
    }

    @Override
    public Gson serialization(String strToSerial) {
        gson.toJson(strToSerial);
        return gson;
    }

    @Override
    public String deserialization(String jsonStr) {
        List<String> list = Arrays.stream(jsonStr
                .split("\n"))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++)
            list.remove(0);

        for (int i = 0; i < 2; i++)
            list.remove(4);

        for (int i = 0; i < 2; i++)
            list.remove(8);

        jsonStr = list.stream().collect(Collectors.joining()).replaceAll("([\\s]{2,})", "");

        CurrencyObj strFromJSON = gson.fromJson(jsonStr, CurrencyObj.class);

        return strFromJSON.toString();
    }
}
