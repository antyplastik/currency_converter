package decorators;

import adapters.JSONToCurrencyData;
import currency.structures.CurrencyData;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class DecoratorsContainerTest {

    JSONToCurrencyData jsonConvert;
    DecoratorsContainer dc;
    List<Decorator> decoratorsList;

    @Before
    public void setUp() {
        jsonConvert = new JSONToCurrencyData();
        dc = new DecoratorsContainer();
        decoratorsList = new ArrayList<>();
    }

    @Test
    @Parameters(method = "jsonToTest")
    public void decoratorPLNConvertDecorTest(String jsonToTest, String valueToConvert, String expectedResult) {
        CurrencyData currencyData = jsonConvert.deserialization(jsonToTest);

        decoratorsList.add(new PLNConvertDecor(valueToConvert, "PLN"));

        dc.add(currencyData.getCode(), currencyData, decoratorsList);
        String result = dc.toString();

        assertThat(result, is(equalTo(expectedResult)));

    }

    public Object[] jsonForPLNConvertDecorTest() {
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
                        "}",

                        "100.00",

                        "Currency: USD\n" +
                                "Currency name: dolar amerykański\n" +
                                " 064/C/NBP/2016\t2016-04-04\tbuy: 3.6929 PLN\tsell: 3.7675 PLN\tTo have 100.00 PLN you have to sell 27.0790 USD\tFor 100.00 PLN you can buy 26.5428 USD\n"},

                new Object[]{"// 20190110201816\n" +
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
                        "}",

                        "100.00",

                        "Currency: GBP\n" +
                                "Currency name: funt szterling\n" +
                                " 247/A/NBP/2018\t2018-12-20\tmiddle: 4.7357 PLN\t100.00 is worth: 21.1162 GBP\n" +
                                " 248/A/NBP/2018\t2018-12-21\tmiddle: 4.7530 PLN\t100.00 is worth: 21.0393 GBP\n" +
                                " 249/A/NBP/2018\t2018-12-24\tmiddle: 4.7544 PLN\t100.00 is worth: 21.0331 GBP\n" +
                                " 250/A/NBP/2018\t2018-12-27\tmiddle: 4.7493 PLN\t100.00 is worth: 21.0557 GBP\n" +
                                " 251/A/NBP/2018\t2018-12-28\tmiddle: 4.7480 PLN\t100.00 is worth: 21.0615 GBP\n" +
                                " 252/A/NBP/2018\t2018-12-31\tmiddle: 4.7895 PLN\t100.00 is worth: 20.8790 GBP\n" +
                                " 001/A/NBP/2019\t2019-01-02\tmiddle: 4.7737 PLN\t100.00 is worth: 20.9481 GBP\n" +
                                " 002/A/NBP/2019\t2019-01-03\tmiddle: 4.7589 PLN\t100.00 is worth: 21.0133 GBP\n" +
                                " 003/A/NBP/2019\t2019-01-04\tmiddle: 4.7803 PLN\t100.00 is worth: 20.9192 GBP\n" +
                                " 004/A/NBP/2019\t2019-01-07\tmiddle: 4.7907 PLN\t100.00 is worth: 20.8738 GBP\n"}
        };
    }

}
