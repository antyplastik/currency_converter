package decorators;

public interface Decorator <T, R> {

    T decorate(String string, R objectToDecorate);

}
