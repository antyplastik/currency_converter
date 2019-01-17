package main_and_communication_with_user;

import com.mashape.unirest.http.exceptions.UnirestException;
import controller.Controller;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "NBP api client", description = "NBP api client and currency json_converter", version = "v1.0")
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

    Controller controller;

    @Override
    public void run() {
        System.out.println("NBP Api Client and currency json_converter" + "\t" + "v1.0");
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
            if (startStopDate != null)
                controller = new Controller(inputParametersArgs, date, startStopDate[0], startStopDate[1], table, lastTopCount);

        } else
            System.out.println("[ERROR] Bad arguments!");

        try {
            System.out.print(controller.getRates());
        } catch (UnirestException e) {
            System.out.println("[ERROR] API error!");
        }
    }
}
