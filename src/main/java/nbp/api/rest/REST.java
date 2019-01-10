package nbp.api.rest;

public interface REST<T> {

    void post(String putStr);

    T get(T ... args);

}
