package encoders;

public class Base64TextEncoder implements ITextEncoder {

    @Override
    public String encode(String text) {
        return text;
    }

    @Override
    public String getIdentifier() {
        return "base64";
    }

}
