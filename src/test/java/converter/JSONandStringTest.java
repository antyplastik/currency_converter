package converter;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class JSONandStringTest {

    JSONandString jsonConvert;
    Gson gson;

    @Before
    public void setUP() {
        jsonConvert = new <String>JSONandString();
        gson = new Gson();
    }

    @Test
    public void checkSerializationTest() { // string to JSON

    }

    @Test
    public void checkDeserializationTest() { // JSON to string
        // http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json
        String referenceStr = "";
        String jsonTestResponse = "// 20190106202504\n" +
                "// http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json\n" +
                "\n" +
                "{\n" +
                "  \"table\": \"C\",\n" +
                "  \"currency\": \"dolar amerykański\",\n" +
                "  \"code\": \"USD\",\n" +
                "  \"rates\": [\n" +
                "    {\n" +
                "      \"no\": \"064/C/NBP/2016\",\n" +
                "      \"effectiveDate\": \"2016-04-04\",\n" +
                "      \"bid\": 3.6929,\n" +
                "      \"ask\": 3.7675\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String resultStr = jsonConvert.deserialization(jsonTestResponse);

        assertThat(resultStr, is(equalTo(referenceStr)));

    }

}