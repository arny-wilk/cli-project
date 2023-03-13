package registertocsvfile;

public interface ByteParser {
    public abstract byte[] parseArrayToByteArray(Object[] array);
    public abstract String[] parseByteArrayToStringArray(byte[] users);
}
