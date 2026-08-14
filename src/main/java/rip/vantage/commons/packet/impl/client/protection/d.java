package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;

public class d extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOV;
    private final int eOW;
    private final String eOX;

    public d(String var1, int var2, String var3) {
        super((byte)3);
        this.eOV = var1;
        this.eOW = var2;
        this.eOX = var3;
    }

    public d(JSONObject var1) {
        super((byte)3);
        this.eOV = var1.getString("a");
        this.eOW = var1.getInt("b");
        this.eOX = var1.getString("c");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOV);
        jsonobject.put("b", this.eOW);
        jsonobject.put("c", this.eOX);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getIp() {
        return this.eOV;
    }

    public int getPort() {
        return this.eOW;
    }
}
