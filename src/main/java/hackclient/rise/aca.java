package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.compat.OfflineMode;
import com.alan.clients.module.api.Category;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.alan.clients.ui.click.standard.components.ModuleComponent;
import hackclient.rise.abw;
import hackclient.rise.abx;
import hackclient.rise.aci;
import hackclient.rise.acj;
import hackclient.rise.aec;
import hackclient.rise.agk;
import hackclient.rise.ajt;
import hackclient.rise.event.er;
import hackclient.rise.gb;
import hackclient.rise.gd;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.stream.Collectors;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import rip.vantage.commons.packet.impl.client.community.c;
import rip.vantage.commons.packet.impl.client.protection.e;
import rip.vantage.network.core.a;

public final class aca
implements abx,
InstanceAccess {
    public agk scrollUtil = new agk();
    public static int auk = 10;
    public static boolean azE;
    private acj azF = new acj(Arrays.asList(new aci("", "Loading"), new aci("", "Loading"), new aci("", "Loading")), "Featured Configs");
    private acj azG = new acj(Arrays.asList(new aci("", "Loading"), new aci("", "Loading"), new aci("", "Loading")), "Community Configs");
    private acj azH = new acj(Arrays.asList(new aci("", ""), new aci("", ""), new aci("", "")), "Your Configs");
    private ArrayList<ModuleComponent> azI = new ArrayList();
    public acj[] azJ = new acj[]{this.azF, this.azH};
    private boolean azK;
    private Animation animation = new Animation(Easing.EASE_OUT_EXPO, 400L);
    @EventLink
    public final Listener<er> azL = er2 -> {
        if (er2.dd() instanceof rip.vantage.commons.packet.impl.server.community.a) {
            JSONArray jSONArray = ((rip.vantage.commons.packet.impl.server.community.a)er2.dd()).aJM();
            this.azG.clear();
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = StringUtils.capitalize(jSONObject.getString("a"));
                jSONObject.getString("b");
                String string2 = jSONObject.getString("c");
                this.azG.add(new aci("Click to load", string, () -> a.aKB().aKK().sendMessage(new c(string2).aJk())));
            }
        }
    };

    @Override
    public void b(int n2, int n3, float f2) {
        if (!this.azK) {
            Client.a.e().b(this);
            this.azK = true;
        }
        RiseClickGUI riseClickGUI = this.getStandardClickGUI();
        Vector2f vector2f = new Vector2f(this.getStandardClickGUI().getScale().x, this.getStandardClickGUI().getScale().y);
        Vector2f vector2f2 = new Vector2f(this.getStandardClickGUI().getPosition().x, this.getStandardClickGUI().getPosition().y);
        double d2 = riseClickGUI.axS - 0.99;
        azE = true;
        for (acj acj2 : this.azJ) {
            acj2.qF();
        }
        this.scrollUtil.E(azE);
        vector2f.x = (float)((double)vector2f.x + (riseClickGUI.axJ.aym + (double)10));
        vector2f.y = (float)((double)vector2f.y + (this.scrollUtil.tE() + (double)10));
        vector2f2.x = (float)((double)vector2f2.x + ((double)-20 - riseClickGUI.axJ.aym));
        Vector2f vector2f3 = new Vector2f(vector2f2.x, 110.0f);
        RenderUtil.roundedRectangle(vector2f.x, vector2f.y, vector2f3.x, vector2f3.y, 10.0, abw.OVERLAY.Y(abw.OVERLAY.pV().getAlpha() * 2));
        vector2f.y += vector2f3.y + (float)20;
        for (acj acj3 : this.azJ) {
            try {
                acj3.j(vector2f);
                vector2f.y += (float)(20 + acj3.getHeight());
            }
            catch (ConcurrentModificationException concurrentModificationException) {}
        }
        gb.MAIN.a(18, gd.REGULAR).a("Your Scripts", vector2f.x, vector2f.y, Color.WHITE.getRGB());
        vector2f.y += (float)10 + gb.MAIN.a(18, gd.REGULAR).height();
        Iterator<ModuleComponent> iterator = this.azI.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                double d3 = 7.0;
                double d4 = riseClickGUI.getScale().getX() + riseClickGUI.getPosition().getX() - 4.0f;
                double d5 = (double)riseClickGUI.getScale().getY() + d3;
                this.scrollUtil.a(new Vector2d(d4, d5), (double)this.getStandardClickGUI().alh.y - d3 * 2.0);
                this.scrollUtil.V(-((double)vector2f.y - this.scrollUtil.tE() - (double)riseClickGUI.axI.y) + (double)riseClickGUI.alh.y - 7.0);
                double d6 = riseClickGUI.axS - 0.99;
                return;
            }
            ModuleComponent abd2 = iterator.next();
            abd2.draw(new Vector2d((double)riseClickGUI.axI.x + riseClickGUI.axJ.aym + 8.0, vector2f.y), n2, n3, f2);
            vector2f.y += abd2.scale.y + 7.0f;
        }
    }

    @Override
    public void a(char c2, int n2) {
        Iterator<ModuleComponent> iterator = this.azI.iterator();
        while (iterator.hasNext()) {
            iterator.next().key(c2, n2);
        }
    }

    @Override
    public void f(int n2, int n3, int n4) {
        for (acj acj2 : this.azJ) {
            try {
                acj2.f(n2, n3, n4);
            }
            catch (ConcurrentModificationException concurrentModificationException) {
                concurrentModificationException.printStackTrace();
            }
        }
        Iterator<ModuleComponent> iterator = this.azI.iterator();
        while (iterator.hasNext()) {
            ModuleComponent abd2 = iterator.next();
            abd2.click(n2, n3, n4);
        }
        return;
    }

    @Override
    public void oG() {
        Iterator<ModuleComponent> iterator = this.azI.iterator();
        while (iterator.hasNext()) {
            iterator.next().pz();
        }
    }

    @Override
    public void pY() {
        Iterator<ModuleComponent> iterator = this.azI.iterator();
        while (iterator.hasNext()) {
            iterator.next().ci();
        }
    }

    @Override
    public void aT() {
        if (!this.azK) {
            Client.a.e().b(this);
            this.azK = true;
        }
        acj[] acjArray = this.azJ;
        int n2 = acjArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            acjArray[i2].init();
        }
        Client.a.p().update();
        this.azH.clear();
        Client.a.p().forEach(configFile -> this.azH.add(new aci("Click to load", configFile.getName(), configFile::te)));
        this.azI = Client.a.v().getModuleList().stream().filter(abd2 -> {
            if (abd2.getModule().getModuleInfo().category() != Category.SCRIPT) return false;
            return true;
        }).collect(Collectors.toCollection(ArrayList::new));
        a.aKB().aKK().sendMessage(new rip.vantage.commons.packet.impl.client.community.a().aJk());
        new Thread(() -> {
            ArrayList<ajt<String, String, String>> arrayList = this.qi();
            this.azF.clear();
            arrayList.forEach(ajt2 -> this.azF.add(new aci("Click to load", (String)ajt2.vT(), () -> a.aKB().aKK().sendMessage(new e(aec.aY("https://raw.githubusercontent.com/risellc/RiseOnlineConfigs/main/" + ((String)ajt2.vT()).toLowerCase() + ".json")).aJk()))));
        }).start();
    }

    public ArrayList<ajt<String, String, String>> qi() {
        //add code
        if (OfflineMode.offline()) {
            return new ArrayList<ajt<String, String, String>>();
        }
        JsonArray jsonArray = aec.aZ("https://raw.githubusercontent.com/risellc/RiseOnlineConfigs/main/index.json");
        ArrayList<ajt<String, String, String>> arrayList = new ArrayList<ajt<String, String, String>>();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JsonObject jsonObject = iterator.next().getAsJsonObject();
            String string = jsonObject.get("name").getAsString();
            String string2 = jsonObject.get("ip").getAsString();
            String string3 = jsonObject.get("last updated").getAsString();
            arrayList.add(new ajt<String, String, String>(string, string2, string3));
        }
        return arrayList;
    }

    @Generated
    public agk qe() {
        return this.scrollUtil;
    }

    @Generated
    public acj qj() {
        return this.azF;
    }

    @Generated
    public acj qk() {
        return this.azG;
    }

    @Generated
    public acj ql() {
        return this.azH;
    }

    @Generated
    public ArrayList<ModuleComponent> qm() {
        return this.azI;
    }

    @Generated
    public acj[] qn() {
        return this.azJ;
    }

    @Generated
    public boolean qo() {
        return this.azK;
    }

    @Generated
    public Animation mB() {
        return this.animation;
    }

    @Generated
    public Listener<er> qp() {
        return this.azL;
    }

    @Generated
    public void a(agk agk2) {
        this.scrollUtil = agk2;
    }

    @Generated
    public void a(acj acj2) {
        this.azF = acj2;
    }

    @Generated
    public void b(acj acj2) {
        this.azG = acj2;
    }

    @Generated
    public void c(acj acj2) {
        this.azH = acj2;
    }

    @Generated
    public void c(ArrayList<ModuleComponent> arrayList) {
        this.azI = arrayList;
    }

    @Generated
    public void a(acj[] acjArray) {
        this.azJ = acjArray;
    }

    @Generated
    public void z(boolean bl) {
        this.azK = bl;
    }

    @Generated
    public void a(Animation animation) {
        this.animation = animation;
    }
}
