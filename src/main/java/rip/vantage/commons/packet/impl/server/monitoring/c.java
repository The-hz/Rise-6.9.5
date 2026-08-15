package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class c extends rip.vantage.commons.packet.api.abstracts.b {
    public String ePQ;
    public String ePP;

    public String aJS() {
        return this.ePP;
    }

    public String aJT() {
        return this.ePQ;
    }


    static {
    }

    public c(JSONObject var1) {
        super((byte)28);
        this.ePP = var1.getString("a");
        this.ePQ = var1.getString("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.b(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePP);
        jsonobject.put("b", this.ePQ);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }
}
