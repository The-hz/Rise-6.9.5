package rip.vantage.commons.packet.impl.server.protection;

import org.json.JSONObject;

public class S2CPacketConfig extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final String eQD;

    public S2CPacketConfig(String var1) {
        super((byte)2);
        this.eQD = var1;
    }

    public S2CPacketConfig(JSONObject json) {
        super((byte)2);
        this.eQD = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eQD);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String aJw() {
        return this.eQD;
    }
}
