package rip.vantage.commons.packet.impl.server.protection;

import org.json.JSONObject;

public class S2CPacketServerJoin extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final String eQB;
    private final int eQC;

    public S2CPacketServerJoin(String var1, int var2) {
        super((byte)3);
        this.eQB = var1;
        this.eQC = var2;
    }

    public S2CPacketServerJoin(JSONObject json) {
        super((byte)3);
        this.eQB = json.getString("a");
        this.eQC = json.getInt("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eQB);
        jsonobject.put("b", this.eQC);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getIp() {
        return this.eQB;
    }

    public int getPort() {
        return this.eQC;
    }
}
