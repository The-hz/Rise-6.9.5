package rip.vantage.commons.packet.impl.server.community;

import org.json.JSONObject;

public class e extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final boolean ePM;
    private final boolean ePN;

    public e(boolean var1, boolean var2) {
        super((byte)10);
        this.ePM = var1;
        this.ePN = var2;
    }

    public e(JSONObject json) {
        super((byte)10);
        this.ePM = json.getBoolean("a");
        this.ePN = json.getBoolean("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public boolean aJP() {
        return this.ePM;
    }

    public boolean aJQ() {
        return this.ePN;
    }
}
