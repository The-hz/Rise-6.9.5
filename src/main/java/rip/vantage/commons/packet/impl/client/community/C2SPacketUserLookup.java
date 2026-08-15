package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class C2SPacketUserLookup extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final String eOH;

    public C2SPacketUserLookup(String var1) {
        super((byte)6);
        this.eOH = var1;
    }

    public C2SPacketUserLookup(JSONObject json) {
        super((byte)6);
        this.eOH = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOH);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.eOH;
    }
}
