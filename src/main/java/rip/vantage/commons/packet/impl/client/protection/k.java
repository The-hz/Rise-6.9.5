package rip.vantage.commons.packet.impl.client.protection;

import java.util.Base64;
import org.json.JSONObject;

public class k extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    private final byte[] ePz;

    public k(byte[] var1) {
        super((byte)32);
        this.ePz = var1;
    }

    @Override
    public void a(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", Base64.getEncoder().encodeToString(this.ePz));
        jsonobject.put("id", this.aeq());
        return jsonobject.toString();
    }

    public byte[] aJL() {
        return this.ePz;
    }
}
