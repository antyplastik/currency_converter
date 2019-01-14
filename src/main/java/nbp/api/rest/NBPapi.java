package nbp.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class NBPapi {

    private String nbpApiURL = "http://api.nbp.pl/api/exchangerates/";
    //e.g. http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json

    public String getRates(String table, String code, String date, String topCount) throws UnirestException { // date can be today, last or date in format YYYY-MM-DD
        HttpResponse<String> currencyDataHttpResponse = Unirest.get("http://api.nbp.pl/api/exchangerates/rates/"+table+"/"+code+"/"+date+"/"+topCount+"/?format=json")
                .asString();
        return currencyDataHttpResponse.getBody();
    }
}