package rip.vantage.commons.packet.impl.server.monitoring;

import org.json.JSONObject;

public class e extends rip.vantage.commons.packet.api.abstracts.b {
    public boolean ePR;

    static {
    }

    public e(JSONObject json) {
        super((byte)26);
        this.ePR = json.optBoolean("a", false);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePR);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.b(this);
    }

    public boolean isAccepted() {
        return this.ePR;
    }

}
