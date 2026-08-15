package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;

public class e extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOY;

    public e(String var1) {
        super((byte)2);
        this.eOY = var1;
    }

    public e(JSONObject json) {
        super((byte)2);
        this.eOY = json.getString("a");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOY);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String aJw() {
        return this.eOY;
    }
}
