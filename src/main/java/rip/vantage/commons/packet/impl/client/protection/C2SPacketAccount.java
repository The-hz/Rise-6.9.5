package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;

public class C2SPacketAccount extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final String eOO;
    private String eOP;

    public C2SPacketAccount(String var1) {
        super((byte)4);
        this.eOO = var1;
    }

    public C2SPacketAccount(JSONObject json) {
        super((byte)4);
        this.eOO = json.getString("a");
        if (json.has("b")) {
            this.eOP = new SvgMeasurer(json.getString("b")).toString();
        }
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOO);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String so() {
        return this.eOO;
    }

    public String aJr() {
        return this.eOP;
    }
}
