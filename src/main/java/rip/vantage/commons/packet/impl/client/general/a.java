package rip.vantage.commons.packet.impl.client.general;

import org.json.JSONObject;

public class a extends rip.vantage.commons.packet.api.abstracts.a {
    public a() {
        super((byte)0);
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }
}
