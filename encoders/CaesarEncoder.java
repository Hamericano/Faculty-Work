package encoders;

public class CaesarEncoder implements ITextEncoder {

    private String key = "";


    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }


    @Override
    public String encode(String text) {
        //
        String encoded = text;
        return encoded;
    }

    @Override
    public String getIdentifier() {
        return "caesar";
    }

}
