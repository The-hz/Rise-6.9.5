package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class g extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOH;

    public g(String var1) {
        super((byte)6);
        this.eOH = var1;
    }

    public g(JSONObject var1) {
        super((byte)6);
        this.eOH = var1.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOH);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.eOH;
    }
}
