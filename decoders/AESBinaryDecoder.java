package decoders;

public class AESBinaryDecoder implements IBinaryDecoder {
    private byte[] key;
    private byte[] initVector;

    public AESBinaryDecoder(byte[] key, byte[] initVector)
    {
        this.key = new byte[key.length];
        this.initVector = new byte[initVector.length];
        System.arraycopy(key, 0, this.key, 0, key.length);
        System.arraycopy(initVector, 0, this.initVector, 0, initVector.length);
    }


    @Override
    public byte[] decode(byte[] inputToDecode) {
        return inputToDecode;
    }


}
