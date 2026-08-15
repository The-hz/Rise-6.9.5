package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;

public class d extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final String eOV;
    private final int eOW;
    private final String eOX;

    public d(String var1, int var2, String var3) {
        super((byte)3);
        this.eOV = var1;
        this.eOW = var2;
        this.eOX = var3;
    }

    public d(JSONObject json) {
        super((byte)3);
        this.eOV = json.getString("a");
        this.eOW = json.getInt("b");
        this.eOX = json.getString("c");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOV);
        jsonobject.put("b", this.eOW);
        jsonobject.put("c", this.eOX);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getIp() {
        return this.eOV;
    }

    public int getPort() {
        return this.eOW;
    }
}
