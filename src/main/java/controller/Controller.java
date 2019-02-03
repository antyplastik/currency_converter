package controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import currency.CurrenciesContainer;
import currency.structures.CurrencyData;
import decorators.Decorator;
import decorators.DecoratorsContainer;
import nbp.api.rest.NBPapi;

import javax.management.ServiceNotFoundException;
import java.util.List;
import java.util.Map;

public class Controller {

    private String[] currencies;
    private String date;
    private String startDate;
    private String stopDate;
    private String table;
    private String topCount;
    private List<Decorator> decorators;

    private CurrenciesContainer cc = new CurrenciesContainer();

    public Controller(String[] currencies, String date, String startDate, String stopDate, String table, String topCount, List<Decorator> decorators) {
        this.currencies = currencies;
        this.date = date;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.table = table;
        this.topCount = topCount;
        this.decorators = decorators;
    }

    public String getRates() throws UnirestException {
        for (String code : currencies) {
            try {
                cc.add(NBPapi.getRates(table, code, date, startDate, stopDate, topCount));
            } catch (ServiceNotFoundException e) {
                System.out.println("[ERROR] " + e.getMessage() + " => Because there is no " + code.toUpperCase() + " in table " + table.toUpperCase() + "!");
            }
        }

        if (decorators.size() != 0) {

            return addDecorators(decorators, cc);
        } else
            return cc.toString();
    }

    private String addDecorators(List decorators, CurrenciesContainer currenciesContainer) {
        Map<String, CurrencyData> currenciesMap = currenciesContainer.getCurrencies();
        DecoratorsContainer dc = new DecoratorsContainer();

        for (Map.Entry entry : currenciesMap.entrySet())
            dc.add(entry.getKey().toString(), (CurrencyData) entry.getValue(), decorators);

        return dc.toString();
    }
}
