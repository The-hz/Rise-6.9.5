package hackclient.rise;

import com.alan.clients.util.account.auth.MicrosoftLogin;
import com.alan.clients.util.account.auth.d;
import com.google.gson.JsonObject;
import lombok.Generated;

public class aep extends ael {
    private String aFe;

    public aep(String var1, String var2, String var3, String var4) {
        super(aem.MICROSOFT, var1, var2, var3);
        this.aFe = var4;
    }

    public static aep sn() {
        aep aep = new aep("", "", "", "");
        MicrosoftLogin.getRefreshToken(var1x -> {
            aep.bm(var1x);
            aep.se();
        });
        return aep;
    }

    @Override
    public boolean se() {
        if (this.aFe.isEmpty()) {
            return super.se();
        }

        d d = MicrosoftLogin.login(this.aFe);
        if (!d.sm()) {
            d = MicrosoftLogin.loginMarketplaceRefreshToken(this.aFe);
        }

        if (!d.sm()) {
            return false;
        }

        this.setName(d.aCj);
        this.bg(d.aEL);
        this.bh(d.aEX);
        this.bm(d.aEY);
        return super.se();
    }

    @Override
    public boolean kW() {
        return super.kW();
    }

    @Override
    public JsonObject sf() {
        JsonObject jsonobject = super.sf();
        jsonobject.addProperty("refreshToken", this.aFe);
        return jsonobject;
    }

    @Override
    public void b(JsonObject var1) {
        super.b(var1);
        if (var1.has("refreshToken")) {
            this.aFe = var1.get("refreshToken").getAsString();
        }
    }

    @Generated
    public String so() {
        return this.aFe;
    }

    @Generated
    public void bm(String var1) {
        this.aFe = var1;
    }
}
