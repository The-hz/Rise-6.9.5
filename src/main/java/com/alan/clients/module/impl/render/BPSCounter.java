package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.DragValue;
import hackclient.rise.adv;
import hackclient.rise.ahg;
import hackclient.rise.aka;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;

@ModuleInfo(aliases={"module.render.bpscounter.name"}, description="module.render.bpscounter.description", category=Category.RENDER)
public class BPSCounter
extends Module {
    public aka ali;
    public static int[] O0OoOO0OOOOO;
    public Vector2f scale;
    public static Object[] oO00O0OO0ooO;
    public static Object[] fld_0oOOoOo0O00O_49;
    @EventLink
    public Listener<Render2DEvent> all;
    @EventLink
    public Listener<PostStrafeEvent> alk;
    public static Object[] o0Oo000O0oO;
    public DragValue position;
    public BooleanValue showTitle = new BooleanValue("Title", (Module)this, (Boolean)false);
    public String alj = "";

    public static void Oo0o00000O00() {
    }

    static {
        BPSCounter.Oo0o00000O00();
        fld_0oOOoOo0O00O_49 = new Object[4];
        BPSCounter.fld_0oOOoOo0O00O_49[0] = "kmWRU7kLeDzItprBPCdPgkYkubhRdfDi+Tj9IQVWTNzNgwUL1S8Aq3gHFdzbqsgW";
        BPSCounter.fld_0oOOoOo0O00O_49[1] = "PBKDF2WithHmacSHA1";
        BPSCounter.fld_0oOOoOo0O00O_49[2] = "AES";
        BPSCounter.fld_0oOOoOo0O00O_49[3] = "AES/CBC/PKCS5Padding";
        oO00O0OO0ooO = new Object[1];
        BPSCounter.oO00O0OO0ooO[0] = "\u0000\u0004BPS \u0000\bPosition\u0000\u0005Title";
        o0Oo000O0oO = new Object[3];
        BPSCounter.o0Oo000O0oO[0] = "BPS ";
        BPSCounter.o0Oo000O0oO[1] = "Position";
        BPSCounter.o0Oo000O0oO[2] = "Title";
    }

    public BPSCounter() {
        this.position = new DragValue("Position", (Module)this, new Vector2d(200.0, 200.0));
        this.scale = new Vector2f(22.0f, 22.0f);
        this.ali = new aka(0.0, 0.0, 0.0);
        this.alk = postStrafeEvent -> {
            this.alj = String.valueOf(ahg.a(new aka(BPSCounter.aEg.thePlayer.posX, 0.0, BPSCounter.aEg.thePlayer.posZ).g(this.ali) * 20.0 * (double)BPSCounter.aEg.timer.dzD, 2));
            this.ali = new aka(BPSCounter.aEg.thePlayer.posX, 0.0, BPSCounter.aEg.thePlayer.posZ);
        };
        this.all = render2DEvent -> {
            Vector2d vector2d = this.position.apP;
            String string = (Boolean)this.showTitle.wo() != false ? (String)o0Oo000O0oO[0] : "";
            String string2 = this.alj;
            float f3 = gb.MAIN.a(20, gd.BOLD).getStringWidth(string);
            this.scale.x = f3 + (float)gb.MAIN.a(20, gd.REGULAR).getStringWidth(string2);
            this.b(gg.REGULAR, 1).c(() -> {
                double d4 = vector2d.x;
                double d5 = vector2d.y;
                double d6 = this.scale.x + 6.0f;
                double d7 = this.scale.y - 1.0f;
                double d8 = this.rz().pl();
                this.rz();
                RenderUtil.roundedRectangle(d4, d5, d6, d7, d8, adv.rK());
                this.position.n(new Vector2d(this.scale.x + 6.0f, this.scale.y - 1.0f));
                double d9 = vector2d.x + 3.0;
                double d10 = vector2d.y + (double)(this.scale.y / 2.05f) - (double)(gb.MAIN.a(20, gd.REGULAR).tq() / 4.0f);
                gb.MAIN.a(20, gd.BOLD).b(string, d9, d10, this.rz().rA().getRGB());
                gb.MAIN.a(20, gd.REGULAR).b(string2, d9 + (double)f3, d10, Color.WHITE.getRGB());
            });
            this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(vector2d.x, vector2d.y, this.scale.x + 6.0f, this.scale.y - 1.0f, this.rz().pl(), Color.BLACK));
            this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(vector2d.x + 0.5, vector2d.y + 0.5, this.scale.x + 6.0f - 1.0f, this.scale.y - 2.0f, this.rz().pl() + 1, this.rz().rE()));
        };
    }
}
