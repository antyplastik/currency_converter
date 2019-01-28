package main_and_communication_with_user;

import com.mashape.unirest.http.exceptions.UnirestException;
import controller.Controller;
import decorators.PLNConvertDecor;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "NBP api client", description = "NBP api client and currency adapters", version = "v1.0")
public class PicoTerm implements Runnable {

    @Parameters(arity = "1..*", paramLabel = "CURRENCY_CODE", description = "Input currency or currencies to process. Use three-letter currency code compliant with ISO 4217 standard" +
            "\nIf you don't use any options to CURRENCY_CODE, you'll get today's exchange rate")
    private String[] inputParametersArgs;

    @Option(names = {"-t", "--table"}, arity = "1", description = "Type A, B or C (buy-sell table)")
    private String table;

    @Option(names = {"-c", "--last-top-count"}, arity = "1", description = "The number of recent exchange rates")
    private String lastTopCount;

    @Option(names = {"-s", "--single-date"}, arity = "1", description = "Enter the date of the currency rate (YYYY-MM-DD => ISO 8601 standard)")
    private String date;

    @Option(names = {"-d", "--start-stop-dates"}, arity = "2", description = "Series of {table} exchange tables published in the date range from {start-date} to {end-date} (YYYY-MM-DD => ISO 8601 standard)")
    private String[] startStopDate;

//    @Option(names = {"-p", "--supported-currencies"}, description = "Get a list of supported currencies")
//    private boolean supportedCurrencies = false;

//    @Option(names = {"-r", "--roc-indicator"}, description = "add the ROC indicator. ROC is the percentage change of the exchange rate from the current session in relation to the exchange rate from the previous session")
//    private boolean rocIndicatorDecorator = false;

    @Option(names = {"-a", "--amount-to-convert"}, arity = "1", description = "Enter the amount of PLN to be converted. E.g 100.00 or 100")
    private String amountToConvert;

//    @Option(names = {"-f", "--foreign-currency"}, arity = "2", description = "Enter the foreign currency code and the value to be converted. E.g USD 100.00")
//    private String[] foreignCurrencyDecorator;


    Controller controller;

    @Override
    public void run() {
        System.out.println("NBP Api Client and currency adapters" + "\t" + "v1.0");
        List decorators = new ArrayList();

        if (inputParametersArgs != null) {

            if (table == null)
                table = "c";

            if (date == null)
                date = "today";

            if (startStopDate == null) {
                startStopDate = new String[2];
                startStopDate[0] = "";
                startStopDate[1] = "";
            }

            if (lastTopCount == null)
                lastTopCount = "";
            else {
                date = "last";
                if (Integer.parseInt(lastTopCount) > 10) {
                    System.out.println("[ERROR] The user hasn't entered a number between 0 and 10. Changed to 10");
                    lastTopCount = "10";
                } else if (Integer.parseInt(lastTopCount) <= 0) {
                    System.out.println("[ERROR] The user hasn't entered a number between 0 and 10. Changed to today rates");
                    date = "today";
                    lastTopCount = "";
                }
            }

//            if (rocIndicatorDecorator) {
//                decorators.add(new String[]{"ROC", "true"});
//            }

            if (amountToConvert != null)
                decorators.add(new PLNConvertDecor(amountToConvert));

//            if (foreignCurrencyDecorator != null) {
//                if (foreignCurrencyDecorator[0] != null && foreignCurrencyDecorator[1] != null)
//                    decorators.add(foreignCurrencyDecorator);
//            }

            if (startStopDate != null)
                controller = new Controller(inputParametersArgs, date, startStopDate[0], startStopDate[1], table, lastTopCount, decorators);

//        } else if (supportedCurrencies) {
//            System.out.println(SupportedCurrencies.get());
        } else
            System.out.println("[ERROR] Bad arguments!");

        try {
            System.out.print(controller.getRates());
        } catch (UnirestException e) {
            System.out.println("[ERROR] API error!");
        }
    }
}
