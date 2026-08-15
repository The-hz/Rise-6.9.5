package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class f extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final String eOG;

    public f(String var1) {
        super((byte)5);
        this.eOG = var1;
    }

    public f(JSONObject json) {
        super((byte)5);
        this.eOG = json.getString("a");
    }

    @Override
    public void handle(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.handle(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOG);
        jsonobject.put("id", this.getId());
        return jsonobject.toString();
    }

    public String getServerIp() {
        return this.eOG;
    }
}
