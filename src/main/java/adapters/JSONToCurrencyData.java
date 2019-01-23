package adapters;

import com.google.gson.Gson;
import currency.structures.CurrencyData;
import nbp.api.NBPjsonPreparation;

public class JSONToCurrencyData implements JSONConverter<CurrencyData> {

    @Override
    public String serialization(CurrencyData strToSerial) {
        return new Gson().toJson(strToSerial);
    }

    @Override
    public CurrencyData deserialization(String jsonStr) {
        String formattedJson = NBPjsonPreparation.prepare(jsonStr);
        return new Gson().fromJson(formattedJson, CurrencyData.class);
    }
}
