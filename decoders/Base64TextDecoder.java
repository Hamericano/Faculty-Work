package decoders;

public class Base64TextDecoder implements ITextDecoder {
    @Override
    public String decode(String inputToDecode) {
        return inputToDecode;
    }

    @Override
    public String getIdentifier() {
        return "base64";
    }
}
