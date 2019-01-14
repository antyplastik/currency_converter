package converter;

public interface ObjectConverter<T,R> {

    R serialization(String strToSerial);

    T deserialization(String jsonToStr);
}
