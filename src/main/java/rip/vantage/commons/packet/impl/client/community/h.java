package rip.vantage.commons.packet.impl.client.community;

import org.json.JSONObject;

public class h extends rip.vantage.commons.packet.api.abstracts.a {
    private final String eOI;
    private final int eOJ;
    private final int eOK;
    private final int eOL;
    private final String eOM;
    private final String eON;

    public h(String var1, int var2, int var3, int var4, String var5, String var6) {
        super((byte)9);
        this.eOI = var1;
        this.eOJ = var2;
        this.eOK = var3;
        this.eOL = var4;
        this.eOM = var5;
        this.eON = var6;
    }

    public h(JSONObject var1) {
        super((byte)9);
        this.eOI = var1.getString("a");
        this.eOJ = var1.getInt("b");
        this.eOK = var1.getInt("c");
        this.eOL = var1.getInt("d");
        this.eOM = var1.getString("e");
        this.eON = var1.getString("f");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.eOI);
        jsonobject.put("b", this.eOJ);
        jsonobject.put("c", this.eOK);
        jsonobject.put("d", this.eOL);
        jsonobject.put("e", this.eOM);
        jsonobject.put("f", this.eON);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public String getMessage() {
        return this.eOI;
    }
}
