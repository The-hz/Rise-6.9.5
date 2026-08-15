package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class f extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOG;

    public f(String var1) {
        super((byte)5);
        this.eOG = var1;
    }

    public f(JSONObject json) {
        super((byte)5);
        this.eOG = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOG);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String aJq() {
        return this.eOG;
    }
}
