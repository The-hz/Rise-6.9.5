package rip.vantage.commons.packet.impl.server.protection;

import java.util.Base64;
import org.json.JSONObject;

public class g extends rip.vantage.commons.packet.api.abstracts.b {
    private final byte[] eQE;
    private final long eQF;

    public g(byte[] var1, long var2) {
        super((byte)21);
        this.eQE = var1;
        this.eQF = var2;
    }

    public g(JSONObject json) {
        super((byte)21);
        this.eQE = Base64.getDecoder().decode(json.getString("a"));
        this.eQF = json.getLong("b");
    }

    @Override
    public void a(rip.vantage.commons.handler.api.c var1) {
        var1.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", Base64.getEncoder().encodeToString(this.eQE));
        jsonobject.put("b", this.eQF);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public byte[] aJF() {
        return this.eQE;
    }

    public long nb() {
        return this.eQF;
    }
}
