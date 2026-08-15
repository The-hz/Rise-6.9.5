package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;

public class i extends rip.vantage.commons.packet.api.abstracts.a {
    public String ePj;
    public String ePk;
    public String ePi;

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePi);
        jsonobject.put("b", this.ePj);
        jsonobject.put("c", this.ePk);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getReason() {
        return this.ePk;
    }

    public String si() {
        return this.ePj;
    }

    public i(String var1, String var2) {
        super((byte)30);
        this.ePi = var1;
        this.ePj = "";
        this.ePk = var2;
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    public i(JSONObject var1) {
        super((byte)30);
        this.ePi = var1.getString("a");
        this.ePj = var1.optString("b", "");
        this.ePk = var1.optString("c", "");
    }

    static {
    }


    public String aJD() {
        return this.ePi;
    }
}
