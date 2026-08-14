package hackclient.rise;

import java.awt.TrayIcon.MessageType;
import lombok.Generated;

public enum ahi {
    NONE(MessageType.NONE),
    WARNING(MessageType.WARNING),
    INFO(MessageType.INFO),
    ERROR(MessageType.ERROR);

    private final MessageType aNm;
    private static final ahi[] $VALUES = uJ();

    @Generated
    ahi(MessageType var3) {
        this.aNm = var3;
    }

    @Generated
    public MessageType uI() {
        return this.aNm;
    }

    private static ahi[] uJ() {
        return new ahi[]{NONE, WARNING, INFO, ERROR};
    }
}
