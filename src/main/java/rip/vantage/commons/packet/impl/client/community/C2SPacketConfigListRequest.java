package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class C2SPacketConfigListRequest extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    public C2SPacketConfigListRequest() {
        super((byte)11);
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }
}
