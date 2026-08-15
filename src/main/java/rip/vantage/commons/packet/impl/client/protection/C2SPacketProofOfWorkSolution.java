package rip.vantage.commons.packet.impl.client.protection;

import java.util.Base64;
import org.json.JSONObject;

public class C2SPacketProofOfWorkSolution extends rip.vantage.commons.packet.api.abstracts.AbstractC2SPacket {
    public byte[] ePw;
    public int ePy;
    public long ePx;

    public long getTimestamp() {
        return this.ePx;
    }

    @Override
    public void handle(rip.vantage.commons.handler.api.C2SPacketHandler handler) {
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", Base64.getEncoder().encodeToString(this.ePw));
        jsonobject.put("b", this.ePx);
        jsonobject.put("c", this.ePy);
        jsonobject.put("id", this.getId());
        return jsonobject.toString();
    }

    public C2SPacketProofOfWorkSolution(byte[] var1, long var2, int var4) {
        super((byte)20);
        this.ePw = var1;
        this.ePx = var2;
        this.ePy = var4;
    }


    public byte[] getProof() {
        return this.ePw;
    }

    public C2SPacketProofOfWorkSolution(JSONObject json) {
        super((byte)20);
        this.ePw = Base64.getDecoder().decode(json.getString("a"));
        this.ePx = json.getLong("b");
        this.ePy = json.getInt("c");
    }

    static {
    }

    public int getChecksumCount() {
        return this.ePy;
    }
}
