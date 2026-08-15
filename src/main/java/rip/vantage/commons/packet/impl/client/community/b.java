package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class b extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOs;
    private static final String eOt = "63d0f9bc46ca6bf7ad9572b7";

    public b(String var1) {
        super((byte)4);
        this.eOs = var1;
    }

    public b(JSONObject json) {
        super((byte)4);
        this.eOs = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOs);
        jsonobject.put("b", "63d0f9bc46ca6bf7ad9572b7");
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.eOs;
    }
}
