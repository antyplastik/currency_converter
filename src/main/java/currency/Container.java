package currency;

public interface Container<T, S> {

    void add(S stringOfObjectToSet);

    T get(S objectToFind);

}
