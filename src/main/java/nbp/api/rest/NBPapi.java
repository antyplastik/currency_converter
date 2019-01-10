package nbp.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class NBPapi implements REST<String> {

    private String nbpApiURL = "http://api.nbp.pl/api/exchangerates/";
    //e.g. http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json

    HttpResponse<JsonNode> jsonResponse;

    @Override
    public void post(String putStr) {
        System.out.println();
    }

    @Override
    public String get(String ... args) {


        return null;
    }


}
