package rip.vantage.commons.packet.impl.client.protection;

import java.util.Base64;
import org.json.JSONObject;

public class h extends rip.vantage.commons.packet.api.abstracts.a {
    public byte[] ePw;
    public int ePy;
    public long ePx;

    public long nb() {
        return this.ePx;
    }

    @Override
    public void a(rip.vantage.commons.handler.api.a var1) {
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", Base64.getEncoder().encodeToString(this.ePw));
        jsonobject.put("b", this.ePx);
        jsonobject.put("c", this.ePy);
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public h(byte[] var1, long var2, int var4) {
        super((byte)20);
        this.ePw = var1;
        this.ePx = var2;
        this.ePy = var4;
    }


    public byte[] aJJ() {
        return this.ePw;
    }

    public h(JSONObject json) {
        super((byte)20);
        this.ePw = Base64.getDecoder().decode(json.getString("a"));
        this.ePx = json.getLong("b");
        this.ePy = json.getInt("c");
    }

    static {
    }

    public int aJK() {
        return this.ePy;
    }
}
