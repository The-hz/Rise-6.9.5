package de.florianmichael.vialoadingbase.provider;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocol.version.BaseVersionProvider;
import de.florianmichael.vialoadingbase.ViaLoadingBase;

public class VLBBaseVersionProvider extends BaseVersionProvider {
    public VLBBaseVersionProvider() {
    }

    @Override
    public ProtocolVersion getClosestServerProtocol(UserConnection var1) throws Exception {
        return var1.isClientSide() ? ViaLoadingBase.getInstance().getTargetVersion() : super.getClosestServerProtocol(var1);
    }
}
