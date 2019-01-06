package converter;

public interface Converter<T,R> {

    R serialization(String strToSerial);

    T deserialization(String jsonToStr);
}
