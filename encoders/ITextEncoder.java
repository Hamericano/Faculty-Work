package encoders;

public interface ITextEncoder {
    String getIdentifier();
    String encode(String text);
}
