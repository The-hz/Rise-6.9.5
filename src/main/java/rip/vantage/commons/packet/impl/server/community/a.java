package rip.vantage.commons.packet.impl.server.community;

import org.json.JSONArray;
import org.json.JSONObject;

public class a extends rip.vantage.commons.packet.api.abstracts.b {
    private JSONArray ePA;
    private JSONArray ePB;
    private final String ePC;

    public a(JSONObject json) {
        super((byte)11);

        try {
            this.ePA = json.getJSONArray("a");
        } catch (Exception exception1) {
            this.ePA = new JSONArray();
        }

        try {
            this.ePB = json.getJSONArray("b");
        } catch (Exception exception) {
            this.ePB = new JSONArray();
        }

        this.ePC = json.getString("c");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePA);
        jsonobject.put("b", this.ePB);
        jsonobject.put("c", this.ePC);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public JSONArray aJM() {
        return this.ePA;
    }

    public JSONArray aJN() {
        return this.ePB;
    }

    public String getType() {
        return this.ePC;
    }
}
