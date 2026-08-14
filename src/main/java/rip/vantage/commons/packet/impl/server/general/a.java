package rip.vantage.commons.packet.impl.server.general;

import org.json.JSONObject;
import rip.vantage.commons.handler.api.c;
import rip.vantage.commons.packet.api.abstracts.b;

public class a extends b {
    long ePO;

    public a() {
        super((byte)0);
        this.ePO = System.currentTimeMillis();
    }

    public a(JSONObject var1) {
        super((byte)0);
        this.ePO = var1.getLong("a");
    }

    @Override
    public void a(c var1) {
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", this.aeq());
        jsonobject.put("a", this.ePO);
        return jsonobject.toString();
    }

    public long aJR() {
        return this.ePO;
    }
}
