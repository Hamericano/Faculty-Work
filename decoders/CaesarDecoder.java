package decoders;

public class CaesarDecoder implements ITextDecoder {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    @Override
    public String decode(String inputToDecode) {
        return inputToDecode;
    }

    @Override
    public String getIdentifier() {
        return "caesar";
    }
}
