package decoders;

public interface ITextDecoder {
    String getIdentifier();
    String decode(String inputToDecode);
}
