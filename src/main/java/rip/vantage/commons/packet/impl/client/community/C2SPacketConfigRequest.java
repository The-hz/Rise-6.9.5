package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class C2SPacketConfigRequest extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final String eOu;

    public C2SPacketConfigRequest(String var1) {
        super((byte)10);
        this.eOu = var1;
    }

    public C2SPacketConfigRequest(JSONObject json) {
        super((byte)10);
        this.eOu = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOu);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String aJl() {
        return this.eOu;
    }
}
