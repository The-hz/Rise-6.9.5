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

    public h(JSONObject json) {
        super((byte)9);
        this.eOI = json.getString("a");
        this.eOJ = json.getInt("b");
        this.eOK = json.getInt("c");
        this.eOL = json.getInt("d");
        this.eOM = json.getString("e");
        this.eON = json.getString("f");
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
