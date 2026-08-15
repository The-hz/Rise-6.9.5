package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONArray;
import org.json.JSONObject;

public class f extends rip.vantage.commons.packet.api.abstracts.b {
    public JSONArray ePS;
    public String ePT;

    public JSONArray aJU() {
        return this.ePS;
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePS);
        jsonobject.put("b", this.ePT);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.b(this);
    }

    public String getVersion() {
        return this.ePT;
    }

    static {
    }


    public f(JSONObject json) {
        super((byte)27);
        this.ePS = json.optJSONArray("a");
        this.ePT = json.optString("b", "1");
    }
}
