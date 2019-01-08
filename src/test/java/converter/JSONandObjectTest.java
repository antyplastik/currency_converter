package converter;

import com.google.gson.Gson;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nbp.api.currency.CurrencyData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class JSONandObjectTest {

    JSONandObject jsonConvert;
    Gson gson;

    @Before
    public void setUP() {
        jsonConvert = new <String>JSONandObject();
        gson = new Gson();
    }

    @Test
    public void checkSerializationTest() { // string to JSON

    }

    @Test
    @Parameters(method = "jsonToTest")
    public void checkDeserializationTest(String testJson, String reference) { // JSON to string
        // http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json

        CurrencyData currencyDataObj = jsonConvert.deserialization(testJson);

        assertThat(currencyDataObj.getCode(), is(equalTo(reference)));

    }

    public Object[] jsonToTest() {
        return new Object[]{
                new Object[]{"// 20190106202504\n" +
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
                        "}"
                        , "USD"},
                new Object[]{"// 20190107202958\n" +
                        "// http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json\n" +
                        "\n" +
                        "{\n" +
                        "  \"table\": \"A\",\n" +
                        "  \"currency\": \"funt szterling\",\n" +
                        "  \"code\": \"GBP\",\n" +
                        "  \"rates\": [\n" +
                        "    {\n" +
                        "      \"no\": \"247/A/NBP/2018\",\n" +
                        "      \"effectiveDate\": \"2018-12-20\",\n" +
                        "      \"mid\": 4.7357\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"248/A/NBP/2018\",\n" +
                        "      \"effectiveDate\": \"2018-12-21\",\n" +
                        "      \"mid\": 4.7530\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"249/A/NBP/2018\",\n" +
                        "      \"effectiveDate\": \"2018-12-24\",\n" +
                        "      \"mid\": 4.7544\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"250/A/NBP/2018\",\n" +
                        "      \"effectiveDate\": \"2018-12-27\",\n" +
                        "      \"mid\": 4.7493\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"251/A/NBP/2018\",\n" +
                        "      \"effectiveDate\": \"2018-12-28\",\n" +
                        "      \"mid\": 4.7480\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"252/A/NBP/2018\",\n" +
                        "      \"effectiveDate\": \"2018-12-31\",\n" +
                        "      \"mid\": 4.7895\n" +
                        "    },"
                        , "GBP"}
        };
    }

}