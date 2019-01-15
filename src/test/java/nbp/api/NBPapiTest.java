package nbp.api;

import com.mashape.unirest.http.exceptions.UnirestException;
import converter.JSONToCurrencyData;
import currency.structures.CurrencyData;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nbp.api.rest.NBPapi;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitParamsRunner.class)
public class NBPapiTest {

    @Test
    @Parameters(method = "getJSONRequestResponse")
    public void NBPapiFunctionalTest(String table, String code, String date, String topCount, String expectedResponse) throws UnirestException {
        JSONToCurrencyData jsonDeserializer = new JSONToCurrencyData();

        CurrencyData expectedCurrencyData = jsonDeserializer.deserialization(expectedResponse);
        CurrencyData responseCurrencyData = jsonDeserializer.deserialization(NBPapi.getRates(table,code,date,"","",topCount));

        assertThat(responseCurrencyData.getRates().size(),equalTo(expectedCurrencyData.getRates().size()));
    }

    public Object[] getJSONRequestResponse(){
        return new Object[]{
                new Object[]{"c","usd","2016-04-04","","// 20190106202504\n" +
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
                        "}"},
                new Object[]{"a","gbp","last","10","// 20190110201816\n" +
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
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"001/A/NBP/2019\",\n" +
                        "      \"effectiveDate\": \"2019-01-02\",\n" +
                        "      \"mid\": 4.7737\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"002/A/NBP/2019\",\n" +
                        "      \"effectiveDate\": \"2019-01-03\",\n" +
                        "      \"mid\": 4.7589\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"003/A/NBP/2019\",\n" +
                        "      \"effectiveDate\": \"2019-01-04\",\n" +
                        "      \"mid\": 4.7803\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": \"004/A/NBP/2019\",\n" +
                        "      \"effectiveDate\": \"2019-01-07\",\n" +
                        "      \"mid\": 4.7907\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"}
        };
    }
}