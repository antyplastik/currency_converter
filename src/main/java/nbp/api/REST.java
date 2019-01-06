package nbp.api;

public interface REST<T> {

    void put(String putStr);

    T get();

}
