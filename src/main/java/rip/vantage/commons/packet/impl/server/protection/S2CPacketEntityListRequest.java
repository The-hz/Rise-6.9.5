package rip.vantage.commons.packet.impl.server.protection;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class S2CPacketEntityListRequest extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final List<rip.vantage.commons.packet.impl.client.protection.EntityInfo> eQs;
    private final int eQt;

    public S2CPacketEntityListRequest(List<rip.vantage.commons.packet.impl.client.protection.EntityInfo> var1, int var2) {
        super((byte)7);
        this.eQs = var1;
        this.eQt = var2;
    }

    public S2CPacketEntityListRequest(JSONObject json) {
        super((byte)7);
        JSONArray jsonarray = json.getJSONArray("a");
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            arraylist.add(new rip.vantage.commons.packet.impl.client.protection.EntityInfo(jsonobject.getInt("a"), -1, false));
        }

        this.eQs = arraylist;
        this.eQt = json.getInt("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();

        for (rip.vantage.commons.packet.impl.client.protection.EntityInfo g : this.eQs) {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("a", g.getEntityId());
            jsonarray.put(jsonobject1);
        }

        jsonobject.put("a", jsonarray);
        jsonobject.put("b", this.eQt);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public List<rip.vantage.commons.packet.impl.client.protection.EntityInfo> aJx() {
        return this.eQs;
    }

    public int aJC() {
        return this.eQt;
    }
}
