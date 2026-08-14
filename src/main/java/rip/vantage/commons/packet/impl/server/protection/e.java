package rip.vantage.commons.packet.impl.server.protection;

import org.json.JSONObject;

public class e extends rip.vantage.commons.packet.api.abstracts.b {
    private final String eQB;
    private final int eQC;

    public e(String var1, int var2) {
        super((byte)3);
        this.eQB = var1;
        this.eQC = var2;
    }

    public e(JSONObject var1) {
        super((byte)3);
        this.eQB = var1.getString("a");
        this.eQC = var1.getInt("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eQB);
        jsonobject.put("b", this.eQC);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getIp() {
        return this.eQB;
    }

    public int getPort() {
        return this.eQC;
    }
}
