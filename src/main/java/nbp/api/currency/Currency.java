package nbp.api.currency;

import java.util.Map;

public interface Currency {

    void setCurrency (String parameter, String value);
    Map<String,String> getCurrencyMap();

}
