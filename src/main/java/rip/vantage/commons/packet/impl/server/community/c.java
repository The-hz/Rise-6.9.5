package rip.vantage.commons.packet.impl.server.community;

import org.json.JSONObject;

public class c extends rip.vantage.commons.packet.api.abstracts.b {
    private final String ePG;

    public c(String var1) {
        super((byte)6);
        this.ePG = var1;
    }

    public c(JSONObject json) {
        super((byte)6);
        this.ePG = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePG);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.ePG;
    }
}
