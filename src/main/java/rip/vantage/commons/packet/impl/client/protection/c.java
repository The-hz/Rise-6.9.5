package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;
import rip.vantage.commons.handler.api.b;
import rip.vantage.commons.packet.api.abstracts.a;

public class c extends a
{
    private final String eOR;
    private final String eOS;
    private final String eOT;
    private final int eOU;

    public String aJt() {
        return null;
    }

    public c(final String eor, final String eot, final String eos, final int eou) {
        super((byte)1);
        this.eOR = eor;
        this.eOT = eot;
        this.eOS = eos;
        this.eOU = eou;
    }

    public c(final JSONObject jsonObject) {
        super((byte)1);
        this.eOR = jsonObject.getString("a");
        this.eOT = jsonObject.getString("b");
        this.eOU = jsonObject.getInt("c");
        this.eOS = jsonObject.getString("d");
    }


    public String aJk() {
        return null;
    }

    public String bX() {
        return null;
    }

    public String aJu() {
        return null;
    }

    public int aJv() {
        return 0;
    }

    public void a(final rip.vantage.commons.handler.api.a a) {
    }
}
