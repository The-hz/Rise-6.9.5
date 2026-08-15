package rip.vantage.commons.packet.impl.server.protection;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends rip.vantage.commons.packet.api.abstracts.b {
    private final List<rip.vantage.commons.packet.impl.client.protection.g> eQs;
    private final int eQt;

    public c(List<rip.vantage.commons.packet.impl.client.protection.g> var1, int var2) {
        super((byte)7);
        this.eQs = var1;
        this.eQt = var2;
    }

    public c(JSONObject json) {
        super((byte)7);
        JSONArray jsonarray = json.getJSONArray("a");
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            arraylist.add(new rip.vantage.commons.packet.impl.client.protection.g(jsonobject.getInt("a"), -1, false));
        }

        this.eQs = arraylist;
        this.eQt = json.getInt("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();

        for (rip.vantage.commons.packet.impl.client.protection.g g : this.eQs) {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("a", g.getEntityId());
            jsonarray.put(jsonobject1);
        }

        jsonobject.put("a", jsonarray);
        jsonobject.put("b", this.eQt);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public List<rip.vantage.commons.packet.impl.client.protection.g> aJx() {
        return this.eQs;
    }

    public int aJC() {
        return this.eQt;
    }
}
