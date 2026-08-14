package de.florianmichael.vialoadingbase.platform.viaversion;

import com.viaversion.viaversion.ViaAPIBase;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import io.netty.buffer.ByteBuf;

public class VLBViaAPIWrapper extends ViaAPIBase<UserConnection> {
    public VLBViaAPIWrapper() {
    }

    public ProtocolVersion getPlayerProtocolVersion(UserConnection var1) {
        return var1.getProtocolInfo().protocolVersion();
    }

    public void sendRawPacket(UserConnection var1, ByteBuf var2) {
        var1.scheduleSendRawPacket(var2);
    }
}
