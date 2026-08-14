package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public final class d extends rip.vantage.commons.packet.api.abstracts.a {
    public static final byte eOv = 33;
    private final String eOw;
    private final String eOx;
    private final String eOy;

    public d(String var1, String var2, String var3) {
        super((byte)33);
        this.eOw = var1;
        this.eOx = var2;
        this.eOy = var3;
    }

    public d(JSONObject var1) {
        super((byte)33);
        this.eOw = var1.getString("a");
        this.eOx = var1.getString("b");
        this.eOy = var1.optString("c", "");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOw);
        jsonobject.put("b", this.eOx);
        jsonobject.put("c", this.eOy);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String bX() {
        return this.eOw;
    }

    public String aJm() {
        return this.eOx;
    }

    public String mY() {
        return this.eOy;
    }
}
