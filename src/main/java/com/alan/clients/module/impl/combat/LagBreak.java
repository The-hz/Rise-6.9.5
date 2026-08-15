package com.alan.clients.module.impl.combat;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.velocity.WatchdogPredictionVelocity;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import com.alan.clients.util.math.MathUtil;
import hackclient.rise.aih;
import hackclient.rise.component.bv;
import hackclient.rise.component.ci;
import hackclient.rise.gb;
import hackclient.rise.gd;
import java.awt.Color;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases={"module.combat.lagbreak.name", "Lag Range", "Fake Lag"}, description="module.combat.lagbreak.description", category=Category.COMBAT)
public class LagBreak
extends Module {
    public int ps;
    public int pt;
    private static final int pu = 6;
    private EntityOtherPlayerMP pv;
    private boolean pw;
    private int px;
    private int py;
    private int pz;
    private float pA;
    private float pB;
    private float pC;
    private final NumberValue maxLagTicks = new NumberValue("Max Lag Ticks", this, (Number)9, (Number)1, (Number)40, (Number)1);
    private final NumberValue range = new NumberValue("Range", this, (Number)10, (Number)8, (Number)15, (Number)0.1);
    private final NumberValue minimumRange = new NumberValue("Minimum Range", this, (Number)0, (Number)0, (Number)3, (Number)0.1);
    private final ModeValue visualMode = new ModeValue("Visual Mode", this).add(new Mode[]{new SubMode("Percentage")}).add(new Mode[]{new SubMode("Circle")}).add(new Mode[]{new SubMode("Text")}).setDefault("Percentage");
    private final NumberValue circleRadius = new NumberValue("Circle Radius", this, (Number)16, (Number)8, (Number)40, (Number)1, () -> {
        if (this.gm()) return false;
        return true;
    });
    private final NumberValue circleThickness = new NumberValue("Circle Thickness", this, (Number)1.5, (Number)0.5, (Number)5, (Number)0.1, () -> {
        if (this.gm()) return false;
        return true;
    });
    private final BooleanValue dispatchOnAttack = new BooleanValue("Dispatch On Attack", (Module)this, (Boolean)true);
    private final BooleanValue dispatchOnHurtime = new BooleanValue("Dispatch On Hurtime", (Module)this, (Boolean)false);
    @EventLink
    public final Listener<PreUpdateEvent> onPreUpdate = preUpdateEvent -> {
        if (LagBreak.aEg.gameSettings.cgI.isKeyDown()) {
            this.gl();
            return;
        }
        if (this.pt > 0) {
            BlinkComponent.blink();
        }
        if (this.pt <= 0) {
            if (this.py <= 0) return;
        }
        float f2 = this.go();
        if (((Mode)this.visualMode.wo()).getName().equals("Percentage")) {
            ci.a(f2, 0.75f, false, true, 10);
            return;
        }
        if (!this.gm()) return;
        this.g(f2);
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotion = preMotionEvent -> {
        EntityLivingBase entityLivingBase;
        if (LagBreak.aEg.gameSettings.cgI.isKeyDown()) {
            this.gl();
            return;
        }
        if (LagBreak.aEg.thePlayer == null || LagBreak.aEg.theWorld == null) {
            return;
        }
        this.pt = LagBreak.aEg.thePlayer.ticksExisted - this.px - 1;
        if (this.pt > 0 && this.py > 0) {
            this.py = 0;
            this.pA = 0.0f;
            this.pz = 0;
            ci.cl();
        }
        boolean bl = (entityLivingBase = this.k(((Number)this.range.wo()).doubleValue())) != null && aih.v((Entity)entityLivingBase) <= 3.0 + MoveUtil.speed() / 2.0;
        boolean bl2 = entityLivingBase != null && aih.v((Entity)entityLivingBase) <= 5.0 && this.a(entityLivingBase, 12.0f, 20.0f);
        int n2 = entityLivingBase != null ? (int)MathUtil.l(9.0, 16.0) : (int)MathUtil.l(10.0, 18.0);
        boolean bl3 = false;
        if (this.pt >= ((Number)this.maxLagTicks.wo()).intValue() || this.e(Scaffold.class).isEnabled() || LagBreak.aEg.gameSettings.cgI.isKeyDown() || !MoveUtil.isMoving() || entityLivingBase == null || aih.v((Entity)entityLivingBase) > ((Number)this.range.wo()).doubleValue() || WatchdogPredictionVelocity.dj || LagBreak.aEg.thePlayer.Zl < 2) {
            bl3 = true;
        }
        if (!((Boolean)this.dispatchOnAttack.wo()).booleanValue()) {
            if (!bl3 && bl) {
                bl3 = true;
            }
            if (!bl3 && this.pt >= n2 && !bl2) {
                bl3 = true;
            }
        }
        if (bl3) {
            this.gk();
        }
        if (entityLivingBase != null && aih.v((Entity)entityLivingBase) < ((Number)this.minimumRange.wo()).doubleValue()) {
            this.gk();
        }
        if (LagBreak.aEg.thePlayer.ae < 2 && ((Boolean)this.dispatchOnHurtime.wo()).booleanValue()) {
            this.gk();
        }
        if (this.pw) {
            this.gk();
            this.pw = false;
        }
    };
    @EventLink(value=1)
    public final Listener<PacketSendEvent> onPacketSend = packetSendEvent -> {
        if (!((Boolean)this.dispatchOnAttack.wo()).booleanValue() || this.pt <= 0 || LagBreak.aEg.thePlayer == null) {
            return;
        }
        Packet<?> packet = packetSendEvent.dq();
        if (packet instanceof C02PacketUseEntity && ((C02PacketUseEntity)packet).getAction() == C02PacketUseEntity.Action.ATTACK) {
            this.pw = true;
        }
    };
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = worldChangeEvent -> {
        this.gi();
        this.py = 0;
        this.pz = 0;
        this.pA = 0.0f;
        if (LagBreak.aEg.thePlayer != null) {
            this.px = LagBreak.aEg.thePlayer.ticksExisted;
        }
    };
    @EventLink
    public final Listener<Render2DEvent> onRender2D = render2DEvent -> {
        if (LagBreak.aEg.gameSettings.cgI.isKeyDown()) {
            this.gl();
            return;
        }
        if (this.pt <= 0) {
            if (this.py <= 0) return;
        }
        block4: {
            float f2;
            block3: {
                block2: {
                    f2 = this.go();
                    String string = ((Mode)this.visualMode.wo()).getName();
                    int n2 = -1;
                    switch (string.hashCode()) {
                        case 2603341: {
                            if (!string.equals("Text")) break;
                            int n3 = 2;
                            break block2;
                        }
                        case 1071632058: {
                            if (!string.equals("Percentage")) break;
                            n2 = 0;
                            break;
                        }
                        case 2018617584: {
                            if (!string.equals("Circle")) break;
                            boolean bl = true;
                            break block3;
                        }
                    }
                    switch (n2) {
                        case 0: {
                            ci.a(f2, 0.75f, false, true, 10);
                            break block4;
                        }
                        case 1: {
                            break block3;
                        }
                        case 2: {
                            break;
                        }
                        default: {
                            break block4;
                        }
                    }
                }
                this.gp();
                break block4;
            }
            this.a(render2DEvent, f2);
        }
        if (this.py > 0 && LagBreak.aEg.thePlayer != null && this.pz != LagBreak.aEg.thePlayer.ticksExisted) {
            this.pz = LagBreak.aEg.thePlayer.ticksExisted;
            --this.py;
        }
    };

    @Override
    public void onEnable() {
        if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_13) && LastConnectionComponent.ip != null) {
            LastConnectionComponent.ip.contains("hypixel");
        }
        this.gi();
        this.py = 0;
        this.pz = 0;
        this.pA = 0.0f;
        this.pC = this.pB = ((Number)this.circleRadius.wo()).floatValue();
        if (LagBreak.aEg.thePlayer != null) {
            this.px = LagBreak.aEg.thePlayer.ticksExisted;
        }
    }

    @Override
    public void onDisable() {
        this.gj();
        BlinkComponent.dispatch();
    }

    public boolean bd() {
        if (this.pt <= 0) return false;
        return true;
    }

    private void gi() {
        if (LagBreak.aEg.thePlayer == null) {
            return;
        }
    }

    private void gj() {
        if (this.pv != null) {
            Client.a.x().c(this, (Entity)this.pv);
            LagBreak.aEg.theWorld.removeEntityFromWorld(this.pv.getEntityId());
            this.pv = null;
        }
    }

    private void gk() {
        if (this.pt > 0) {
            this.pA = this.gn();
            this.py = 6;
            this.pz = 0;
        }
        BlinkComponent.dispatch();
        BlinkComponent.disable();
        if (LagBreak.aEg.thePlayer != null) {
            this.px = LagBreak.aEg.thePlayer.ticksExisted;
        }
        this.pt = 0;
        this.gj();
    }

    private void gl() {
        if (this.pt > 0) {
            BlinkComponent.dispatch();
            BlinkComponent.disable();
        }
        this.py = 0;
        this.pA = 0.0f;
        this.pz = 0;
        this.pt = 0;
        this.pw = false;
        if (LagBreak.aEg.thePlayer != null) {
            this.px = LagBreak.aEg.thePlayer.ticksExisted;
        }
        ci.stop();
    }

    private boolean gm() {
        return ((Mode)this.visualMode.wo()).getName().equals("Circle");
    }

    private float gn() {
        int n2 = Math.max(1, ((Number)this.maxLagTicks.wo()).intValue() - 1);
        return MathHelper.clamp_float((float)((float)this.pt / (float)n2), (float)0.0f, (float)1.0f);
    }

    private float go() {
        if (this.py <= 0) {
            if (this.pt <= 0) return 0.0f;
            float f2 = this.gn();
            return f2;
        }
        float f3 = 1.0f - (float)(this.py - 1) / 6.0f;
        float f4 = 1.0f - (float)Math.pow(1.0f - f3, 3.0);
        return MathHelper.clamp_float((float)(this.pA + (1.0f - this.pA) * f4), (float)0.0f, (float)1.0f);
    }

    private void gp() {
        float f2 = (float)LagBreak.aEg.jY.getScaledWidth() / 2.0f;
        float f3 = (float)LagBreak.aEg.jY.getScaledHeight() / 2.0f;
        int n2 = this.rz().rA().getRGB();
        int n3 = new Color(0, 0, 0, 200).getRGB();
        gb.MAIN.a(17, gd.LIGHT).c("Blinking: " + this.pt, f2 + 1.0f, f3 + 10.0f + 1.0f, n3);
        gb.MAIN.a(17, gd.LIGHT).c("Blinking: " + this.pt, f2, f3 + 10.0f, n2);
    }

    private void a(Render2DEvent render2DEvent, float f2) {
        int n2 = render2DEvent.getScaledResolution().getScaledWidth();
        int n3 = render2DEvent.getScaledResolution().getScaledHeight();
        float f3 = (float)n2 / 2.0f;
        float f4 = (float)n3 / 2.0f;
        float f5 = MathUtil.lerp(this.pC, this.pB, LagBreak.aEg.timer.bWm);
        double d2 = 360.0 * (double)f2;
        double d3 = 270.0 + d2;
        GL11.glPushMatrix();
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GL11.glLineWidth(((Number)this.circleThickness.wo()).floatValue());
        this.a(f3, f4, f5, 270.0, d3, this.rz().rA(), 1.0f);
        GlStateManager.disableBlend();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
        GlStateManager.resetColor();
    }

    private void g(float f2) {
        float f3 = ((Number)this.circleRadius.wo()).floatValue() + f2 * 5.0f;
        this.pC = this.pB;
        this.pB = MathUtil.lerp(this.pB, f3, 0.35f);
    }

    private void a(float f2, float f3, float f4, double d2, double d3, Color color, float f5) {
        GL11.glBegin(3);
        GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, f5);
        double d4 = d2 <= d3 ? 0.75 : -0.75;
        double d5 = d2;
        while (d4 > 0.0 ? d5 <= d3 : d5 >= d3) {
            double d6 = Math.toRadians(d5);
            float f6 = f2 + (float)(Math.cos(d6) * (double)f4);
            float f7 = f3 + (float)(Math.sin(d6) * (double)f4);
            GL11.glVertex2f(f6, f7);
            d5 += d4;
        }
        double d7 = Math.toRadians(d3);
        GL11.glVertex2f(f2 + (float)(Math.cos(d7) * (double)f4), f3 + (float)(Math.sin(d7) * (double)f4));
        GL11.glEnd();
    }

    private EntityLivingBase k(double d2) {
        try {
            List<EntityLivingBase> list = bv.f(d2);
            if (list == null || list.isEmpty()) {
                return null;
            }
            list.sort(Comparator.comparingDouble(entityLivingBase -> aih.v((Entity)entityLivingBase)));
            return list.get(0);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private boolean a(EntityLivingBase entityLivingBase, float f2, float f3) {
        double d2 = LagBreak.aEg.thePlayer.posX - entityLivingBase.posX;
        double d3 = LagBreak.aEg.thePlayer.posZ - entityLivingBase.posZ;
        double d4 = LagBreak.aEg.thePlayer.posY + (double)LagBreak.aEg.thePlayer.getEyeHeight() - (entityLivingBase.posY + (double)entityLivingBase.getEyeHeight());
        double d5 = Math.sqrt(d2 * d2 + d3 * d3);
        float f4 = (float)(Math.toDegrees(Math.atan2(d3, d2)) - 90.0);
        float f5 = (float)(-Math.toDegrees(Math.atan2(d4, d5)));
        float f6 = Math.abs(MathHelper.wrapAngleTo180_float((float)(entityLivingBase.pl - f4)));
        float f7 = Math.abs(MathHelper.wrapAngleTo180_float((float)(entityLivingBase.rotationPitch - f5)));
        if (!(f6 <= f2)) return false;
        if (!(f7 <= f3)) return false;
        return true;
    }
}
