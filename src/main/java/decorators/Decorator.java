package decorators;

public interface Decorator <T, R> {

    T decorate(R objectToDecorate);

}
