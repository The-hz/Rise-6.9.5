package rip.vantage.commons.packet.impl.server.protection;

import java.util.Base64;
import org.json.JSONObject;

public class h extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final byte[] eQG;

    public h(JSONObject json) {
        super((byte)32);
        this.eQG = Base64.getDecoder().decode(json.optString("a", ""));
    }

    @Override
    public void a(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
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
