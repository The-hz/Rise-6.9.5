package rip.vantage.commons.packet.impl.client.protection;

import java.util.Base64;
import org.json.JSONObject;

public class h extends rip.vantage.commons.packet.api.abstracts.a {
    public byte[] ePw;
    public int ePy;
    public long ePx;
    public static int[] O0OoOO0OOOOO;
    public static Object[] o0Oo000O0oO = new Object[7];
    public static Object[] oO00O0OO0ooO = new Object[1];

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

    public static void Oo0o00000O00() {
    }

    public byte[] aJJ() {
        return this.ePw;
    }

    public h(JSONObject var1) {
        super((byte)20);
        this.ePw = Base64.getDecoder().decode(var1.getString("a"));
        this.ePx = var1.getLong("b");
        this.ePy = var1.getInt("c");
    }

    static {
        Oo0o00000O00();
        oO00O0OO0ooO[0] = "\u0000\u0001b\u0000\u0001a\u0000\u0001c\u0000\u0002id\u0000\u0001b\u0000\u0001c\u0000\u0001a";
        o0Oo000O0oO[0] = "b";
        o0Oo000O0oO[1] = "a";
        o0Oo000O0oO[2] = "c";
        o0Oo000O0oO[3] = "id";
        o0Oo000O0oO[4] = "b";
        o0Oo000O0oO[5] = "c";
        o0Oo000O0oO[6] = "a";
    }

    public int aJK() {
        return this.ePy;
    }
}
