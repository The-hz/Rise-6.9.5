package rip.vantage.commons.packet.impl.server.general;

import org.json.JSONObject;
import rip.vantage.commons.handler.api.S2CPacketHandler;
import rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket;

public class a extends AbstractS2CPacket {
    long ePO;

    public a() {
        super((byte)0);
        this.ePO = System.currentTimeMillis();
    }

    public a(JSONObject json) {
        super((byte)0);
        this.ePO = json.getLong("a");
    }

    @Override
    public void handle(S2CPacketHandler handler) {
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", this.getId());
        jsonobject.put("a", this.ePO);
        return jsonobject.toString();
    }

    public long getA() {
        return this.ePO;
    }
}
