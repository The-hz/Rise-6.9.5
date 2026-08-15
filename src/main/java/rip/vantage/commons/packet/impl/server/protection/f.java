package rip.vantage.commons.packet.impl.server.protection;

import org.json.JSONObject;

public class f extends rip.vantage.commons.packet.api.abstracts.b {
    private final String eQD;

    public f(String var1) {
        super((byte)2);
        this.eQD = var1;
    }

    public f(JSONObject json) {
        super((byte)2);
        this.eQD = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eQD);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String aJw() {
        return this.eQD;
    }
}
