package rip.vantage.commons.packet.impl.server.protection;

import org.json.JSONObject;

public class a extends rip.vantage.commons.packet.api.abstracts.b {
    private final String eQb;
    private final String eQc;
    private final String eQd;
    private final String eQe;
    private String eOP;

    public a(String var1, String var2, String var3, String var4) {
        super((byte)4);
        this.eQb = var1;
        this.eQc = var2;
        this.eQd = var3;
        this.eQe = var4;
    }

    public a(JSONObject var1) {
        super((byte)4);
        this.eQb = var1.getString("a");
        this.eQc = var1.getString("b");
        this.eQd = var1.getString("c");
        this.eQe = var1.getString("d");
        if (var1.has("e")) {
            this.eOP = new rip.vantage.commons.packet.impl.client.protection.b(var1.getString("e")).toString();
        }
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
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
