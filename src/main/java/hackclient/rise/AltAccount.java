package hackclient.rise;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class AltAccount {
    private AltType aEK;
    private String gK;
    private String aEL;
    private String aEM;
    private long aEN;

    public AltAccount(AltType var1, String var2, String var3, String var4) {
        this.aEK = var1;
        this.gK = var2;
        this.aEL = var3;
        this.aEM = var4;
    }

    public boolean se() {
        Minecraft.getMinecraft().setSession(new Session(this.gK, this.aEL, this.aEM, "mojang"));
        this.aEN = System.currentTimeMillis();
        return true;
    }

    public boolean kW() {
        return this.gK != null && this.aEL != null && this.aEM != null && !this.gK.isEmpty() && !this.aEL.isEmpty() && !this.aEM.isEmpty();
    }

    public JsonObject sf() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", this.aEK.getName());
        jsonobject.addProperty("name", this.gK);
        jsonobject.addProperty("uuid", this.aEL);
        jsonobject.addProperty("accessToken", this.aEM);
        jsonobject.addProperty("lastUsed", this.aEN);
        return jsonobject;
    }

    public void b(JsonObject var1) {
        if (var1.has("type")) {
            this.aEK = AltType.bi(var1.get("type").getAsString());
        } else {
            this.aEK = AltType.CRACKED;
        }

        if (var1.has("name")) {
            this.gK = var1.get("name").getAsString();
        }

        if (var1.has("uuid")) {
            this.aEL = var1.get("uuid").getAsString();
        }

        if (var1.has("accessToken")) {
            this.aEM = var1.get("accessToken").getAsString();
        }

        if (var1.has("lastUsed")) {
            this.aEN = var1.get("lastUsed").getAsLong();
        }
    }

    @Generated
    public AltType sg() {
        return this.aEK;
    }

    @Generated
    public String getName() {
        return this.gK;
    }

    @Generated
    public String sh() {
        return this.aEL;
    }

    @Generated
    public String si() {
        return this.aEM;
    }

    @Generated
    public long sj() {
        return this.aEN;
    }

    @Generated
    public void a(AltType var1) {
        this.aEK = var1;
    }

    @Generated
    public void setName(String var1) {
        this.gK = var1;
    }

    @Generated
    public void bg(String var1) {
        this.aEL = var1;
    }

    @Generated
    public void bh(String var1) {
        this.aEM = var1;
    }

    @Generated
    public void e(long var1) {
        this.aEN = var1;
    }
}
