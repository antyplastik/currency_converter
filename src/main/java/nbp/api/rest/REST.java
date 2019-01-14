package nbp.api.rest;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface REST<T> {

    void post(String putStr);

    T get(T ... args) throws UnirestException;

}
