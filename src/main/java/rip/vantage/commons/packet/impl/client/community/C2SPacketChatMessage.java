package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class C2SPacketChatMessage extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final String eOs;
    private static final String eOt = "63d0f9bc46ca6bf7ad9572b7";

    public C2SPacketChatMessage(String var1) {
        super((byte)4);
        this.eOs = var1;
    }

    public C2SPacketChatMessage(JSONObject json) {
        super((byte)4);
        this.eOs = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOs);
        jsonobject.put("b", "63d0f9bc46ca6bf7ad9572b7");
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.eOs;
    }
}
