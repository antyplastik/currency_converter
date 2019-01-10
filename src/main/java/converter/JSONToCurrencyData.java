package converter;

import com.google.gson.Gson;
import currency.CurrencyData;
import nbp.api.NBPjsonPreparation;

public class JSONToCurrencyData implements Converter<CurrencyData, String> {

    @Override
    public String serialization(String strToSerial) {
        return new Gson().toJson(strToSerial);
    }

    @Override
    public CurrencyData deserialization(String jsonStr) {
        NBPjsonPreparation jsonPreparation = new NBPjsonPreparation();
        String formattedJson = jsonPreparation.prepare(jsonStr);
        return new Gson().fromJson(formattedJson, CurrencyData.class);
    }
}
