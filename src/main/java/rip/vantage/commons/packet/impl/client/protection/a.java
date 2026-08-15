package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;

public class a extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOO;
    private String eOP;

    public a(String var1) {
        super((byte)4);
        this.eOO = var1;
    }

    public a(JSONObject json) {
        super((byte)4);
        this.eOO = json.getString("a");
        if (json.has("b")) {
            this.eOP = new b(json.getString("b")).toString();
        }
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
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
