package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class c extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOu;

    public c(String var1) {
        super((byte)10);
        this.eOu = var1;
    }

    public c(JSONObject var1) {
        super((byte)10);
        this.eOu = var1.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOu);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String aJl() {
        return this.eOu;
    }
}
