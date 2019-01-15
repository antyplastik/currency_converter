package controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import currency.CurrenciesContainer;
import nbp.api.rest.NBPapi;

public class Controller {

    private String[] currencies;
    private String date;
    private String startDate;
    private String stopDate;
    private String table;
    private String topCount;

    private CurrenciesContainer cc = new CurrenciesContainer();

    public Controller(String[] currencies, String date, String startDate, String stopDate, String table, String topCount) {
        this.currencies = currencies;
        this.date = date;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.table = table;
        this.topCount = topCount;
    }

    public String getRates() throws UnirestException {
        for (String code : currencies) {
            cc.add(NBPapi.getRates(table, code, date, startDate, stopDate, topCount));
        }
        return cc.toString();
    }
}
