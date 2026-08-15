package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class d extends rip.vantage.commons.packet.api.abstracts.b {
    public String eQa;

    public String ajm() {
        return this.eQa;
    }

    static {
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    public d(JSONObject var1) {
        super((byte)25);
        this.eQa = var1.getString("a");
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eQa);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public d(String var1) {
        super((byte)25);
        this.eQa = var1;
    }

}
