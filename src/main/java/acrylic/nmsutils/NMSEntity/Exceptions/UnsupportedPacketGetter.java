package acrylic.nmsutils.NMSEntity.Exceptions;

public class UnsupportedPacketGetter extends RuntimeException {

    public UnsupportedPacketGetter(String exception) {
        super("This packet getter cannot be used as it will produce a null.: " + exception);
    }
}
