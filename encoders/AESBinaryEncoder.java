package encoders;

public class AESBinaryEncoder implements IBinaryEncoder{


    private byte[] key;
    private byte[] initVector;

    public AESBinaryEncoder(byte[] key, byte[] initVector)
    {
        this.key = new byte[key.length];
        this.initVector = new byte[initVector.length];
        System.arraycopy(key, 0, this.key, 0, key.length);
        System.arraycopy(initVector, 0, this.initVector, 0, initVector.length);
    }

    @Override
    public byte[] encode(byte[] dataToEncode) {
        return dataToEncode;
    }

}
