package com.alan.clients.newevent.impl.other;

import com.alan.clients.newevent.Event;
import java.util.List;
import lombok.Generated;

public final class ServerKickEvent implements Event {
    public List<String> message;

    @Generated
    public List<String> dm() {
        return this.message;
    }

    @Generated
    public ServerKickEvent(List<String> var1) {
        this.message = var1;
    }
}
