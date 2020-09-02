package acrylic.nmsutils.NMSEntity.Exceptions;

public class NotNMSSupportedException extends RuntimeException {

    public NotNMSSupportedException(String exception) {
        super("This use case does not support NMS: " + exception);
    }
}
