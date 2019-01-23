package adapters;

public interface JSONConverter<T> {

    String serialization(T strToSerial);

    T deserialization(String jsonToStr);
}
