package runner_and_communication_with_user;

import com.mashape.unirest.http.exceptions.UnirestException;
import controller.Controller;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "text_statistics", description = "Language detector\nYou can detect language of input text (pasted text) or file", version = "v1.0")
public class PicoTerm implements Runnable {

    @Parameters(arity = "1..*", paramLabel = "TEXT", description = "Input currency or currencies to process. Use three-letter currency code compliant with ISO4217" +
            "\nIf you don't use any options, you'll get today's exchange rate from ")
    private String[] inputParametersArgs;

    @Option(names = {"-t", "--table"}, arity = "1", description = "Type A, B or C (buy-sell table)")
    private String table;

    @Option(names = {"-c", "--last-top-count"}, arity = "1", description = "The number of recent exchange rates")
    private String lastTopCount;

    @Option(names = {"-s", "--date"}, arity = "1", description = "Enter the date of the currency rate")
    private String date;

    @Option(names = {"-d", "--start-stop-date"}, arity = "2", description = "Series of {table} exchange tables published in the date range from {start-date} to {end-date}")
    private String[] startStopDate;

//    @Option(names = {"-e", "--end-date"}, description = "Second parameter of series of {table} exchange tables published in the date range from {start-date} to {end-date}")
//    private String[] stopDate;

    Controller controller;

    @Override
    public void run() {

        if (inputParametersArgs != null && table == null && date == null && startStopDate == null && lastTopCount == null)
            controller = new Controller(inputParametersArgs, "today", "", "", "a", "");

        else if (inputParametersArgs != null && table != null && date != null && startStopDate == null && lastTopCount != null)
            controller = new Controller(inputParametersArgs, date, "", "", table, lastTopCount);

        else if (inputParametersArgs != null && table != null && startStopDate[0] != null && startStopDate[1] != null)
            controller = new Controller(inputParametersArgs, "", "", "", table, "");

        else
            System.out.println("[ERR] Bad arguments!");

        try {
            System.out.print(controller.getRates());
        } catch (UnirestException e) {
            System.out.println("[ERR] API error!");
        }
    }
}
