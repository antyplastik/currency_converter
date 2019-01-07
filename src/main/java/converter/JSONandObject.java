package converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nbp.api.currency.rates.CurrencyRate;
import nbp.api.currency.rates.CurrencyTable;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class JSONandObject implements Converter<CurrencyTable, Gson> {

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
    public CurrencyTable deserialization(String jsonStr) {
        List<String> list = Arrays.stream(jsonStr
                .split("\n"))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++)
            list.remove(0);

        jsonStr = list.stream().collect(Collectors.joining()).replaceAll("([\\s]{2,})", "").replaceAll("\\[","").replaceAll("\\]","");

        CurrencyTable JSONtoObj = deserializeCurrentTable(jsonStr);
//        CurrencyRates currencyRates = deserializeCurrencyRates(jsonStr);

        return JSONtoObj;
    }


    private CurrencyTable deserializeCurrentTable(String jsonStr){
        CurrencyTable JSONtoCurrencyTable = gson.fromJson(jsonStr, CurrencyTable.class);
        return JSONtoCurrencyTable;
    }

    private HashMap<String,CurrencyRate> deserializeCurrencyRates(String jsonStr){
        Type jsonToCurrencyRates = new TypeToken<HashMap<String, CurrencyRate>>(){}.getType();
        HashMap <String,CurrencyRate> currencyRateHashMap = gson.fromJson(jsonStr,jsonToCurrencyRates);
        return null;
    }
}
