package currency.json_to_currency;

public interface JSONConverter<T> {

    String serialization(T strToSerial);

    T deserialization(String jsonToStr);
}
