package rip.vantage.commons.packet.impl.server.community;

import org.json.JSONObject;

public class S2CPacketUserData extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final String ePG;

    public S2CPacketUserData(String var1) {
        super((byte)6);
        this.ePG = var1;
    }

    public S2CPacketUserData(JSONObject json) {
        super((byte)6);
        this.ePG = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePG);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.ePG;
    }
}
