package nbp.api.currency;

public interface Container<T, S> {

    void add(T objectToSet);

    T get(S objectToFind);

}
