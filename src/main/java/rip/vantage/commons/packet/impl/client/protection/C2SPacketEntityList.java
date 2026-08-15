package rip.vantage.commons.packet.impl.client.protection;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class C2SPacketEntityList extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final List<EntityInfo> eOZ;
    private final boolean ePa;
    private final boolean ePb;
    private final boolean ePc;
    private final boolean ePd;
    private final int ePe;

    public C2SPacketEntityList(List<EntityInfo> var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6) {
        super((byte)8);
        this.eOZ = var1;
        this.ePa = var2;
        this.ePb = var3;
        this.ePc = var4;
        this.ePd = var5;
        this.ePe = var6;
    }

    public C2SPacketEntityList(JSONObject json) {
        super((byte)8);
        JSONArray jsonarray = json.getJSONArray("a");
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            arraylist.add(new EntityInfo(jsonobject.getInt("a"), jsonobject.getInt("b"), jsonobject.getBoolean("c")));
        }

        this.eOZ = arraylist;
        this.ePa = json.getBoolean("b");
        this.ePb = json.getBoolean("c");
        this.ePc = json.getBoolean("d");
        this.ePd = json.getBoolean("e");
        this.ePe = json.getInt("f");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();

        for (EntityInfo g : this.eOZ) {
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

    public List<EntityInfo> aJx() {
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
