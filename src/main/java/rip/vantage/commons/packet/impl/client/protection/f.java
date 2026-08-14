package rip.vantage.commons.packet.impl.client.protection;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends rip.vantage.commons.packet.api.abstracts.a {
    private final List<g> eOZ;
    private final boolean ePa;
    private final boolean ePb;
    private final boolean ePc;
    private final boolean ePd;
    private final int ePe;

    public f(List<g> var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6) {
        super((byte)8);
        this.eOZ = var1;
        this.ePa = var2;
        this.ePb = var3;
        this.ePc = var4;
        this.ePd = var5;
        this.ePe = var6;
    }

    public f(JSONObject var1) {
        super((byte)8);
        JSONArray jsonarray = var1.getJSONArray("a");
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            arraylist.add(new g(jsonobject.getInt("a"), jsonobject.getInt("b"), jsonobject.getBoolean("c")));
        }

        this.eOZ = arraylist;
        this.ePa = var1.getBoolean("b");
        this.ePb = var1.getBoolean("c");
        this.ePc = var1.getBoolean("d");
        this.ePd = var1.getBoolean("e");
        this.ePe = var1.getInt("f");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();

        for (g g : this.eOZ) {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("a", g.getEntityId());
            jsonobject1.put("b", g.agr());
            jsonobject1.put("c", g.isInvisible());
            jsonarray.put(jsonobject1);
        }

        jsonobject.put("a", jsonarray);
        jsonobject.put("b", this.ePa);
        jsonobject.put("c", this.ePb);
        jsonobject.put("d", this.ePc);
        jsonobject.put("e", this.ePd);
        jsonobject.put("f", this.ePe);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public List<g> aJx() {
        return this.eOZ;
    }

    public boolean aJy() {
        return this.ePa;
    }

    public boolean aJz() {
        return this.ePb;
    }

    public boolean aJA() {
        return this.ePc;
    }

    public boolean aJB() {
        return this.ePd;
    }

    public int aJC() {
        return this.ePe;
    }
}
