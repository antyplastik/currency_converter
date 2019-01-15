package converter;

import com.google.gson.Gson;
import currency.structures.CurrencyData;
import nbp.api.NBPjsonPreparation;

public class JSONToCurrencyData implements ObjectConverter<CurrencyData, String> {

    @Override
    public String serialization(String strToSerial) {
        return new Gson().toJson(strToSerial);
    }

    @Override
    public CurrencyData deserialization(String jsonStr) {
        String formattedJson = NBPjsonPreparation.prepare(jsonStr);
        return new Gson().fromJson(formattedJson, CurrencyData.class);
    }
}
