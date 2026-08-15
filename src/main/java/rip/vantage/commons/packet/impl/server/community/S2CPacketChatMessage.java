package rip.vantage.commons.packet.impl.server.community;

import org.json.JSONObject;

public class S2CPacketChatMessage extends rip.vantage.commons.packet.api.abstracts.AbstractS2CPacket {
    private final String ePD;
    private final int ePE;
    private final String ePF;

    public S2CPacketChatMessage(String var1, int var2, String var3) {
        super((byte)4);
        this.ePD = var1;
        this.ePE = var2;
        this.ePF = var3;
    }

    public S2CPacketChatMessage(JSONObject json) {
        super((byte)4);
        this.ePD = json.getString("a");
        this.ePE = json.getInt("b");
        this.ePF = json.getString("c");
    }

    @Override
    public void handle(rip.vantage.commons.handler.api.S2CPacketHandler handler) {
        handler.handle(this);
    }

    @Override
    public String aJk() {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("a", this.ePD);
        jsonobject.put("b", this.ePE);
        jsonobject.put("c", this.ePF);
        jsonobject.put("id", this.getId());
        return jsonobject.toString();
    }

    public String getAuthor() {
        return this.ePD;
    }

    public int getProduct() {
        return this.ePE;
    }

    public String getMessage() {
        return this.ePF;
    }
}
