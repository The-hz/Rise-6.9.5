package rip.vantage.commons.packet.impl.server.community;

import org.json.JSONObject;

public class d extends rip.vantage.commons.packet.api.abstracts.b {
    private final String ePH;
    private final int ePI;
    private final int ePJ;
    private final int ePK;
    private final String ePL;

    public d(String var1, int var2, int var3, int var4, String var5) {
        super((byte)9);
        this.ePH = var1;
        this.ePI = var2;
        this.ePJ = var3;
        this.ePK = var4;
        this.ePL = var5;
    }

    public d(JSONObject json) {
        super((byte)9);
        this.ePH = json.getString("a");
        this.ePI = json.getInt("b");
        this.ePJ = json.getInt("c");
        this.ePK = json.getInt("d");
        this.ePL = json.getString("e");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePH);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.ePH;
    }

    public int getFadeInTime() {
        return this.ePI;
    }

    public int getDisplayTime() {
        return this.ePJ;
    }

    public int getFadeOutTime() {
        return this.ePK;
    }

    public String aJO() {
        return this.ePL;
    }
}
