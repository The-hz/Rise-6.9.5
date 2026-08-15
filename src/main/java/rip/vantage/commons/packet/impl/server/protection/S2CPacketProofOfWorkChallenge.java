package rip.vantage.commons.packet.impl.server.protection;

import java.util.Base64;
import org.json.JSONObject;

public class S2CPacketProofOfWorkChallenge extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final byte[] eQE;
    private final long eQF;

    public S2CPacketProofOfWorkChallenge(byte[] var1, long var2) {
        super((byte)21);
        this.eQE = var1;
        this.eQF = var2;
    }

    public S2CPacketProofOfWorkChallenge(JSONObject json) {
        super((byte)21);
        this.eQE = Base64.getDecoder().decode(json.getString("a"));
        this.eQF = json.getLong("b");
    }

    @Override
    public void handle(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.a(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", Base64.getEncoder().encodeToString(this.eQE));
        jsonobject.put("b", this.eQF);
        jsonobject.put("id", this.getId());
        return jsonobject.toString();
    }

    public byte[] getChallenge() {
        return this.eQE;
    }

    public long getTimestamp() {
        return this.eQF;
    }
}
