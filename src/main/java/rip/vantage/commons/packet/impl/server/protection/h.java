package rip.vantage.commons.packet.impl.server.protection;

import java.util.Base64;
import org.json.JSONObject;

public class h extends rip.vantage.commons.packet.api.abstracts.b {
    private final byte[] eQG;

    public h(JSONObject var1) {
        super((byte)32);
        this.eQG = Base64.getDecoder().decode(var1.optString("a", ""));
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", Base64.getEncoder().encodeToString(this.eQG));
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public byte[] aKq() {
        return this.eQG;
    }
}
