package nbp.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.management.ServiceNotFoundException;

public class NBPapi {

    private String nbpApiURL = "http://api.nbp.pl/api/exchangerates/";
    //e.g. http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json

    public static String getRates(String table, String code, String date, String startDate, String stopDate, String topCount) throws UnirestException, ServiceNotFoundException { // date can be today, last or date in format YYYY-MM-DD
        String url = "";

        if (!startDate.equals("") && !stopDate.equals(""))
            url = "http://api.nbp.pl/api/exchangerates/rates/" + table.toLowerCase() + "/" + code.toLowerCase() + "/" + startDate.toLowerCase()+ "/"+ stopDate.toLowerCase() + "/" + topCount;
        else if (!date.equals(""))
            url = "http://api.nbp.pl/api/exchangerates/rates/" + table.toLowerCase() + "/" + code.toLowerCase() + "/" + date.toLowerCase() + "/" + topCount;
        else
            throw new IllegalArgumentException();

        HttpResponse<String> currencyDataHttpResponse =
                Unirest.get(url + "/?format=json")
                        .asString();

        if (currencyDataHttpResponse.getCode() > 400){
            String exceptionResponse = currencyDataHttpResponse.getBody().toString();
            throw new ServiceNotFoundException(exceptionResponse);
        }

        return currencyDataHttpResponse.getBody();
    }
}