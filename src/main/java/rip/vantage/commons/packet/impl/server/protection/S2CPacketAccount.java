package rip.vantage.commons.packet.impl.server.protection;

import org.json.JSONObject;

public class S2CPacketAccount extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final String eQb;
    private final String eQc;
    private final String eQd;
    private final String eQe;
    private String eOP;

    public S2CPacketAccount(String var1, String var2, String var3, String var4) {
        super((byte)4);
        this.eQb = var1;
        this.eQc = var2;
        this.eQd = var3;
        this.eQe = var4;
    }

    public S2CPacketAccount(JSONObject json) {
        super((byte)4);
        this.eQb = json.getString("a");
        this.eQc = json.getString("b");
        this.eQd = json.getString("c");
        this.eQe = json.getString("d");
        if (json.has("e")) {
            this.eOP = new rip.vantage.commons.packet.impl.client.protection.SvgMeasurer(json.getString("e")).toString();
        }
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eQb);
        jsonobject.put("b", this.eQc);
        jsonobject.put("c", this.eQd);
        jsonobject.put("d", this.eQe);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String bX() {
        return this.eQb;
    }

    public String sh() {
        return this.eQc;
    }

    public String si() {
        return this.eQd;
    }

    public String so() {
        return this.eQe;
    }

    public String aJr() {
        return this.eOP;
    }
}
