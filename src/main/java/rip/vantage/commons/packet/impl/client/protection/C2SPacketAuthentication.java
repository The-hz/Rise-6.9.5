package rip.vantage.commons.packet.impl.client.protection;

import org.json.JSONObject;
import rip.vantage.commons.handler.api.PacketHandler;
import rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket;

public class C2SPacketAuthentication extends AbstractC2SPacket
{
    private final String eOR;
    private final String eOS;
    private final String eOT;
    private final int eOU;

    public String aJt() {
        return null;
    }

    public C2SPacketAuthentication(final String eor, final String eot, final String eos, final int eou) {
        super((byte)1);
        this.eOR = eor;
        this.eOT = eot;
        this.eOS = eos;
        this.eOU = eou;
    }

    public C2SPacketAuthentication(final JSONObject jsonObject) {
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

    public int getProduct() {
        return 0;
    }

    public void handle(final rip.vantage.commons.handler.api.C2SPacketHandler handler) {
    }
}
