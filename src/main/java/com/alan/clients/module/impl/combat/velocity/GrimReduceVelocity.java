package com.alan.clients.module.impl.combat.velocity;

import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.movement.speed.GrimSpeed;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.NumberValue;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import hackclient.rise.ahj;
import hackclient.rise.aih;
import hackclient.rise.aiu;
import hackclient.rise.bb;
import hackclient.rise.bv;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.m;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.ad;
import net.minecraft.network.play.server.z;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class GrimReduceVelocity
extends Mode<Velocity> {
    public static boolean dj;
    public static Object[] fld_0oOOoOo0O00O_21;
    public ArrayList<Packet<?>> tu = new ArrayList();
    public static Object[] oO00O0OO0ooO;
    public NumberValue ty;
    @EventLink
    public Listener<PacketReceiveEvent> tG;
    public boolean tv;
    @EventLink(cH=0)
    public Listener<PreUpdateEvent> tH;
    @EventLink
    public Listener<PreMotionEvent> tJ;
    @EventLink
    public Listener<MoveInputEvent> tK;
    public BooleanValue tC;
    public BooleanValue tB;
    public static float jq;
    public static Object Oo0o00000O00;
    public BooleanValue tw = new BooleanValue("Delay till Ground", (Mode<?>)this, (Boolean)true);
    public NumberValue tF;
    public static float jp;
    public BooleanValue tE;
    public static Object[] o0Oo000O0oO;
    public BooleanValue tx = new BooleanValue("Jump Reset", (Mode<?>)this, (Boolean)true);
    public BooleanValue tD;
    public static boolean dk;
    @EventLink(cH=2)
    public Listener<PreUpdateEvent> tI;
    public static boolean tt;
    public NumberValue tz;
    public BooleanValue tA;
    public static Object[] fld_0OOOoo00o0_22;
    public boolean gD;

    public static Object o0Oo000O0oO(Object[] objectArray) {
        try {
            Object object;
            int n2 = (Integer)objectArray[1];
            String string = (String)objectArray[2];
            Object object2 = objectArray[0];
            Object[] objectArray2 = oO00O0OO0ooO;
            if (oO00O0OO0ooO == null) {
                objectArray2 = oO00O0OO0ooO = new Object[1];
            }
            if ((object = objectArray2[n2]) == null) {
                Object[] objectArray3 = (Object[])object2;
                if (objectArray3 == null) {
                    Object[] objectArray4 = new Object[1];
                    fld_0OOOoo00o0_22 = objectArray4;
                    objectArray3 = objectArray4;
                    byte[] byArray = new byte[16];
                    byArray[14] = -107;
                    byArray[2] = -3;
                    byArray[8] = -65;
                    byArray[7] = 46;
                    byArray[6] = -121;
                    byArray[11] = -101;
                    byArray[0] = 42;
                    byArray[9] = 101;
                    byArray[5] = -17;
                    byArray[10] = 0;
                    byArray[3] = 109;
                    byArray[4] = 75;
                    byArray[13] = -111;
                    byArray[1] = -128;
                    byArray[15] = -112;
                    byArray[12] = 125;
                    objectArray4[0] = byArray;
                }
                byte[] byArray = (byte[])objectArray3[0];
                if (Oo0o00000O00 == null) {
                    byte[] byArray2 = new byte[32];
                    byArray2[26] = -114;
                    byArray2[27] = -65;
                    byArray2[2] = -28;
                    byArray2[23] = -34;
                    byArray2[25] = 63;
                    byArray2[4] = -75;
                    byArray2[21] = -16;
                    byArray2[1] = -88;
                    byArray2[3] = 48;
                    byArray2[22] = 71;
                    byArray2[28] = -106;
                    byArray2[29] = 97;
                    byArray2[13] = -28;
                    byArray2[30] = 111;
                    byArray2[9] = 41;
                    byArray2[5] = -105;
                    byArray2[31] = 4;
                    byArray2[15] = -77;
                    byArray2[6] = 40;
                    byArray2[14] = -19;
                    byArray2[20] = -8;
                    byArray2[0] = 118;
                    byArray2[16] = -97;
                    byArray2[19] = -24;
                    byArray2[17] = -11;
                    byArray2[24] = 3;
                    byArray2[12] = 9;
                    byArray2[18] = -98;
                    byArray2[8] = -61;
                    byArray2[7] = 21;
                    byArray2[10] = 56;
                    byArray2[11] = 85;
                    byte[] byArray3 = new byte[byArray.length + byArray2.length];
                    System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
                    System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
                    Object object3 = GrimReduceVelocity.mth_0OOOoo00o0_10()[1];
                    if (object3 == null) {
                        char[] cArray = "\u7e45\u7df3\u7e4c\u7e49\u7e57\u7de3\u7e18\u72ae\u72f9\u72ad\u7e4d\u72a2\u7e56\u7e54\u7e44\u7e4d\u7df6\u7de6".toCharArray();
                        for (int i2 = 0; i2 < 18; ++i2) {
                            char c2 = cArray[i2];
                            int n3 = c2 ^ 0xF441;
                            int n4 = n3 ^ 0x93A6;
                            int n5 = n4 + 33895;
                            int n6 = n5 ^ 0x4DA7;
                            int n7 = n6 + 8104;
                            int n8 = n7 + 34795;
                            int n9 = n8 - 57869;
                            int n10 = n9 + 4591;
                            int n11 = n10 ^ 0xF710;
                            int n12 = n11 + 32338;
                            int n13 = n12 - 16247;
                            int n14 = n13 - 24824;
                            int n15 = n14 ^ 0x48BA;
                            int n16 = n15 - 29276;
                            cArray[i2] = (char)n16;
                        }
                        object3 = GrimReduceVelocity.mth_0OOOoo00o0_10()[1] = new String(cArray);
                    }
                    SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance((String)object3);
                    byte[] byArray4 = new byte[16];
                    byArray4[8] = 114;
                    byArray4[1] = 58;
                    byArray4[11] = 45;
                    byArray4[7] = 109;
                    byArray4[15] = -122;
                    byArray4[9] = -93;
                    byArray4[0] = -39;
                    byArray4[3] = 66;
                    byArray4[12] = 88;
                    byArray4[13] = 107;
                    byArray4[6] = 2;
                    byArray4[4] = 119;
                    byArray4[10] = -80;
                    byArray4[5] = 49;
                    byArray4[2] = 64;
                    byArray4[14] = -11;
                    PBEKeySpec pBEKeySpec = new PBEKeySpec(new String(byArray3, StandardCharsets.UTF_8).toCharArray(), byArray4, 7, 256);
                    byte[] byArray5 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
                    Object object4 = GrimReduceVelocity.mth_0OOOoo00o0_10()[2];
                    if (object4 == null) {
                        char[] cArray = "\u9c2b\u9c27\u9c1d".toCharArray();
                        for (int i3 = 0; i3 < 3; ++i3) {
                            char c3 = cArray[i3];
                            int n17 = c3 + 33698;
                            int n18 = n17 - 8931;
                            int n19 = n18 + 17093;
                            int n20 = n19 - 9350;
                            int n21 = n20 ^ 0x73A8;
                            int n22 = n21 ^ 0x47E9;
                            int n23 = n22 + 25198;
                            int n24 = n23 + 51282;
                            int n25 = n24 - 51859;
                            int n26 = n25 ^ 0x9754;
                            int n27 = n26 + 20920;
                            int n28 = n27 - 37787;
                            int n29 = n28 - 4542;
                            int n30 = n29 - 50399;
                            cArray[i3] = (char)n30;
                        }
                        object4 = GrimReduceVelocity.mth_0OOOoo00o0_10()[2] = new String(cArray);
                    }
                    Oo0o00000O00 = new SecretKeySpec(byArray5, (String)object4);
                }
                byte[] byArray6 = Base64.getDecoder().decode(string);
                byte[] byArray7 = Arrays.copyOfRange(byArray6, 0, 16);
                byte[] byArray8 = Arrays.copyOfRange(byArray6, 16, byArray6.length);
                Object object5 = GrimReduceVelocity.mth_0OOOoo00o0_10()[3];
                if (object5 == null) {
                    char[] cArray = "\u4872\u486e\u4980\u4864\u4870\u4877\u4870\u4864\u4981\u4868\u4870\u4980\u499e\u4981\u4992\u498d\u498d\u498a\u498b\u498c".toCharArray();
                    for (int i4 = 0; i4 < 20; ++i4) {
                        char c4 = cArray[i4];
                        int n31 = c4 ^ 0x9960;
                        int n32 = n31 + 61923;
                        int n33 = n32 - 54087;
                        int n34 = n33 + 24012;
                        int n35 = n34 + 56942;
                        int n36 = n35 - 50478;
                        int n37 = n36 + 26702;
                        int n38 = n37 + 4594;
                        int n39 = n38 ^ 0x9653;
                        int n40 = n39 + 25747;
                        int n41 = n40 + 15861;
                        int n42 = n41 - 14453;
                        int n43 = n42 ^ 0xE0FD;
                        cArray[i4] = (char)n43;
                    }
                    object5 = GrimReduceVelocity.mth_0OOOoo00o0_10()[3] = new String(cArray);
                }
                Cipher cipher = Cipher.getInstance((String)object5);
                cipher.init(2, (Key)((SecretKey)Oo0o00000O00), new IvParameterSpec(byArray7));
                byte[] byArray9 = cipher.doFinal(byArray8);
                object = new String(byArray9, StandardCharsets.UTF_8);
            }
            return object;
        } catch (java.security.GeneralSecurityException generalsecurityexception) {
            throw new RuntimeException(generalsecurityexception);
        }
    }

    public static Vec3 a(Vec3 vec3, AxisAlignedBB axisAlignedBB) {
        double d5 = GrimReduceVelocity.c(vec3.xCoord, axisAlignedBB.minX, axisAlignedBB.maxX);
        double d6 = GrimReduceVelocity.c(vec3.yCoord, axisAlignedBB.minY, axisAlignedBB.maxY);
        double d7 = GrimReduceVelocity.c(vec3.zCoord, axisAlignedBB.minZ, axisAlignedBB.maxZ);
        return new Vec3(d5, d6, d7);
    }

    static {
        o0Oo000O0oO = new Object[13];
        int l17_hi = 0;
        Object[] objectArray = new Object[3];
        objectArray[0] = fld_0OOOoo00o0_22;
        objectArray[1] = 0;
        Object object = GrimReduceVelocity.mth_0OOOoo00o0_10()[0];
        if (object == null) {
            char[] cArray = "\uf31a\uf39e\uf2e3\uf317\uf323\uf39c\uf685\uf2d9\uf683\uf667\uf66a\uf671\uf317\uf39d\uf67d\uf39c\uf667\uf324\uf324\uf685\uf398\uf393\uf667\uf67e\uf2ec\uf2d7\uf67c\uf2e0\uf2ec\uf38a\uf39d\uf675\uf678\uf2da\uf38f\uf684\uf67d\uf683\uf66a\uf676\uf321\uf321\uf320\uf2d9\uf67b\uf2e0\uf684\uf2e0\uf39c\uf326\uf38f\uf669\uf2e4\uf680\uf2da\uf676\uf2e1\uf31a\uf667\uf67b\uf2e0\uf686\uf2d9\uf323\uf674\uf321\uf392\uf681\uf39d\uf2d9\uf65b\uf39e\uf387\uf66f\uf671\uf39e\uf2e4\uf317\uf389\uf31a\uf2d9\uf393\uf686\uf392\uf675\uf391\uf686\uf395\uf391\uf39e\uf326\uf395\uf394\uf67b\uf396\uf396\uf38a\uf2e1\uf64c\uf396\uf392\uf39d\uf677\uf676\uf38a\uf390\uf2e5\uf326\uf66f\uf683\uf679\uf38a\uf674\uf2e3\uf39b\uf669\uf672\uf2e6\uf2da\uf2e4\uf393\uf686\uf67c\uf398\uf2e6\uf395\uf325\uf675\uf67c\uf38a\uf393\uf673\uf389\uf2d7\uf64c\uf389\uf674\uf670\uf674\uf324\uf2d7\uf2e6\uf680\uf680\uf2e5\uf39e\uf667\uf387\uf65e\uf65b\uf321\uf391\uf669\uf319\uf39c\uf675\uf39e\uf675\uf326\uf39d\uf326\uf390\uf2e6\uf672\uf395\uf2ec\uf66f\uf680\uf64f\uf686\uf2e5\uf325\uf64c\uf2e5\uf317\uf2ec\uf38f\uf39e\uf398\uf67b\uf672\uf672\uf323\uf671\uf325\uf683\uf677\uf39e\uf67a\uf325\uf2e3\uf39d\uf66a\uf2e1\uf675\uf390\uf677\uf66f\uf2e1\uf671\uf67c\uf64c\uf2e6\uf391\uf680\uf395\uf67c\uf671\uf672\uf396\uf2ec\uf683\uf678\uf680\uf65b\uf2d7\uf2e4\uf320\uf677\uf320\uf674\uf2e6\uf680\uf321\uf396\uf686\uf675\uf683\uf67a\uf393\uf672\uf2e3\uf2d9\uf685\uf2e6\uf3ad".toCharArray();
            for (int i2 = 0; i2 < 236; ++i2) {
                char c2 = cArray[i2];
                int n2 = c2 - 53122;
                int n3 = n2 - 44869;
                int n4 = n3 ^ 0x6365;
                int n5 = n4 - 19029;
                int n6 = n5 - 54998;
                int n7 = n6 - 34570;
                int n8 = n7 ^ 0xEBC;
                int n9 = n8 + 7934;
                int n10 = n9 - 48494;
                int n11 = n10 ^ 0x8DDE;
                int n12 = n11 - 19999;
                cArray[i2] = (char)n12;
            }
            object = GrimReduceVelocity.mth_0OOOoo00o0_10()[0] = new String(cArray);
        }
        objectArray[2] = (String)object;
        char[] cArray = ((String)GrimReduceVelocity.o0Oo000O0oO(objectArray)).toCharArray();
        int l19_hi = 152;
        int limit = 0;
        while (limit < l19_hi) {
            int limit3 = limit + 1;
            int l10_lo = cArray[limit];
            int limit4 = limit3 + 1;
            int l11_hi = cArray[limit3];
            int limit2 = l10_lo << 16 | l11_hi;
            char[] cArray2 = new char[limit2];
            int j = 0;
            while (j < limit2) {
                cArray2[j] = cArray[limit4 + j];
                j++;
            }
            int n13 = l17_hi;
            l17_hi++;
            GrimReduceVelocity.o0Oo000O0oO[n13] = new String(cArray2);
            limit = limit4 + limit2;
        }
        dj = false;
    }


    public GrimReduceVelocity(String string, Velocity velocity) {
        super(string, velocity);
        this.ty = new NumberValue("Reduce Ticks", this, (Number)14, (Number)1, (Number)20, (Number)1);
        this.tz = new NumberValue("Teleport Disable Ticks", this, (Number)2, (Number)1, (Number)7, (Number)1);
        this.tA = new BooleanValue("On Swing Disable on Aura", (Mode<?>)this, (Boolean)true);
        this.tB = new BooleanValue("Rotate", (Mode<?>)this, (Boolean)false);
        this.tC = new BooleanValue("Delay Plus", (Mode<?>)this, (Boolean)false);
        this.tD = new BooleanValue("Extra Hit", (Mode<?>)this, (Boolean)true);
        this.tE = new BooleanValue("Stop Sprint", (Mode<?>)this, (Boolean)true);
        this.tF = new NumberValue("Range", this, (Number)8, (Number)1, (Number)100, (Number)1);
        this.tG = packetReceiveEvent -> {
            Packet<?> packet;
            Packet<?> packet2;
            Packet<?> packet3;
            Packet<?> packet4;
            S12PacketEntityVelocity s12PacketEntityVelocity;
            Speed speed = this.e(Speed.class);
            int wo2 = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && (Boolean)((GrimSpeed)speed.hl().wo()).Px.wo() != false ? 1 : 0;
            if (tt || GrimReduceVelocity.aEg.thePlayer.Zl < 3 || GrimReduceVelocity.aEg.thePlayer.isInWeb || !((Boolean)this.tw.wo()).booleanValue() && !((Boolean)this.tC.wo()).booleanValue() || wo2 != 0) {
                return;
            }
            Packet<?> packet5 = packetReceiveEvent.dq();
            if (packet5 instanceof S12PacketEntityVelocity && (s12PacketEntityVelocity = (S12PacketEntityVelocity)packet5).getEntityID() == GrimReduceVelocity.aEg.thePlayer.getEntityId()) {
                this.gD = true;
                this.tu.add((Packet<?>)s12PacketEntityVelocity);
                dj = true;
                packetReceiveEvent.setCancelled();
                boolean cfr_ignored_0 = GrimReduceVelocity.aEg.thePlayer.onGround;
            }
            if ((packet4 = packetReceiveEvent.dq()) instanceof S32PacketConfirmTransaction) {
                S32PacketConfirmTransaction s32PacketConfirmTransaction = (S32PacketConfirmTransaction)packet4;
                if (dj) {
                    this.tu.add((Packet<?>)s32PacketConfirmTransaction);
                    packetReceiveEvent.setCancelled();
                }
            }
            if ((packet3 = packetReceiveEvent.dq()) instanceof S14PacketEntity) {
                S14PacketEntity s14PacketEntity = (S14PacketEntity)packet3;
                if (dj) {
                    this.tu.add((Packet<?>)s14PacketEntity);
                    packetReceiveEvent.setCancelled();
                }
            }
            if ((packet2 = packetReceiveEvent.dq()) instanceof ad) {
                ad ad2 = (ad)packet2;
                if (dj) {
                    this.tu.add((Packet<?>)ad2);
                    packetReceiveEvent.setCancelled();
                }
            }
            if ((packet = packetReceiveEvent.dq()) instanceof z) {
                z z2 = (z)packet;
                if (dj) {
                    this.tu.add((Packet<?>)z2);
                    packetReceiveEvent.setCancelled();
                }
            }
        };
        this.tH = preUpdateEvent -> {
            List<EntityLivingBase> list;
            EntityLivingBase entityLivingBase;
            this.tv = false;
            KillAura killAura = this.e(KillAura.class);
            List<EntityLivingBase> list2 = bv.f(((Number)this.tF.wo()).intValue());
            List<EntityLivingBase> list3 = bv.bR();
            EntityLivingBase entityLivingBase2 = killAura.isEnabled() && killAura.jE != null ? killAura.jE : this.e(list3);
            if (entityLivingBase2 == null) {
                return;
            }
            if (GrimReduceVelocity.aEg.thePlayer.ae < 7 && ((Boolean)this.tB.wo()).booleanValue() && !this.e(Scaffold.class).isEnabled()) {
                this.l((Entity)entityLivingBase2);
            }
            if (((Boolean)((Velocity)this.wj()).qQ.wo()).booleanValue() && !GrimReduceVelocity.aEg.thePlayer.isSwingInProgress) {
                if (this.e(KillAura.class).jE == null) return;
                if (!((Boolean)this.tA.wo()).booleanValue()) {
                    return;
                }
            }
            Speed speed = this.e(Speed.class);
            int wo2 = speed.isEnabled() && speed.hl().wo() instanceof GrimSpeed && (Boolean)((GrimSpeed)speed.hl().wo()).Px.wo() != false ? 1 : 0;
            if (GrimReduceVelocity.aEg.thePlayer.ticksExisted <= 20) return;
            if (wo2 != 0) {
                return;
            }
            entityLivingBase = killAura.isEnabled() && killAura.jE != null ? killAura.jE : this.e(list2);
            if (GrimReduceVelocity.aEg.thePlayer.ae <= ((Number)this.ty.wo()).intValue() && !bb.a(false, false, false, true, false) && !this.e(Scaffold.class).isEnabled() && GrimReduceVelocity.aEg.thePlayer.Zl > ((Number)this.tz.wo()).intValue()) {
                this.tv = true;
            }
            if ((list = bv.f(((Number)this.tF.wo()).intValue())) == null || list.isEmpty()) {
                if (killAura == null) return;
                if (killAura.jE == null) {
                    return;
                }
            }
            if (killAura.isEnabled() && killAura.jE != null) {
                EntityLivingBase entityLivingBase4 = killAura.jE;
                MovingObjectPosition movingObjectPosition = GrimReduceVelocity.aEg.objectMouseOver;
                if (!((double)GrimReduceVelocity.aEg.thePlayer.getDistanceToEntity((Entity)entityLivingBase4) <= 3.0 || movingObjectPosition != null && movingObjectPosition.entityHit == entityLivingBase4 || ((Number)this.tF.wo()).intValue() <= 3)) {
                    RotationComponent.d(false);
                    RotationComponent.setRotations(new Vector2f(GrimReduceVelocity.aEg.thePlayer.pl, (float)(90.0 - Math.random() * 0.1)), 10.0, MovementFix.NORMAL);
                }
            } else {
                EntityLivingBase entityLivingBase5 = list.get(0);
                Vec3 vec3 = GrimReduceVelocity.aEg.thePlayer.getPositionEyes(1.0f);
                AxisAlignedBB axisAlignedBB = entityLivingBase5.getEntityBoundingBox().expand(0.1, 0.1, 0.1);
                Vec3 vec32 = new Vec3((axisAlignedBB.minX + axisAlignedBB.maxX) * 0.5, (axisAlignedBB.minY + axisAlignedBB.maxY) * 0.5, (axisAlignedBB.minZ + axisAlignedBB.maxZ) * 0.5).subtract(vec3).normalize();
                Vec3 vec33 = vec3.addVector(vec32.xCoord * 3.0, vec32.yCoord * 3.0, vec32.zCoord * 3.0);
                MovingObjectPosition movingObjectPosition = axisAlignedBB.calculateIntercept(vec3, vec33);
                if (!((movingObjectPosition != null ? vec3.distanceTo(movingObjectPosition.hitVec) : vec3.distanceTo(GrimReduceVelocity.a(vec3, axisAlignedBB))) <= 3.0) && GrimReduceVelocity.aEg.thePlayer.ae <= ((Number)this.ty.wo()).intValue() && !bb.a(false, false, false, true, false)) {
                    RotationComponent.d(false);
                    RotationComponent.setRotations(new Vector2f(GrimReduceVelocity.aEg.thePlayer.pl, (float)(90.0 - Math.random() * 0.2)), 10.0, MovementFix.NORMAL);
                }
            }
            if (entityLivingBase == null) return;
            if (GrimReduceVelocity.aEg.thePlayer.ae > ((Number)this.ty.wo()).intValue() + 1) return;
            if (bb.a(false, false, false, true, false)) return;
            if (this.e(Scaffold.class).isEnabled()) return;
            if (GrimReduceVelocity.aEg.thePlayer.Zl <= ((Number)this.tz.wo()).intValue()) return;
            if (ViaLoadingBase.getInstance().getTargetVersion().newerThan(ProtocolVersion.v1_8)) {
                if ((Boolean)this.tD.wo() == false) return;
                GrimReduceVelocity.aEg.playerController.attackEntity((EntityPlayer)GrimReduceVelocity.aEg.thePlayer, (Entity)entityLivingBase);
                ahj.l(new m());
                return;
            }
            if ((Boolean)this.tD.wo() == false) return;
            ahj.l(new m());
            GrimReduceVelocity.aEg.playerController.attackEntity((EntityPlayer)GrimReduceVelocity.aEg.thePlayer, (Entity)entityLivingBase);
        };
        this.tI = preUpdateEvent -> {
            if (GrimReduceVelocity.aEg.thePlayer.onGround && dj && (Boolean)this.tC.wo() == false || GrimReduceVelocity.aEg.thePlayer.Zl < 3 && dj || ((Boolean)this.tC.wo()).booleanValue() && (GrimReduceVelocity.aEg.thePlayer.onGround || !((Boolean)this.tw.wo()).booleanValue()) && dj && (this.e(KillAura.class).jE == null || aih.v((Entity)this.e(KillAura.class).jE) < 2.7 || GrimReduceVelocity.aEg.thePlayer.aY == 1)) {
                dj = false;
                tt = true;
                BlinkComponent.dispatch();
                this.tu.forEach(p -> ahj.p(p));
                this.tu.clear();
                tt = false;
            }
            if (GrimReduceVelocity.aEg.thePlayer.tR > 25 && dj) {
                dj = false;
                tt = true;
                BlinkComponent.dispatch();
                this.tu.forEach(p -> ahj.p(p));
                this.tu.clear();
                tt = false;
            }
        };
        this.tJ = preMotionEvent -> {
            this.gD = false;
        };
        this.tK = moveInputEvent -> {
            if (this.gD && ((Boolean)this.tx.wo()).booleanValue()) {
                moveInputEvent.setJump(true);
            }
            if (GrimReduceVelocity.aEg.thePlayer.ae < 7 && ((Boolean)this.tB.wo()).booleanValue() && !this.e(Scaffold.class).isEnabled()) {
                moveInputEvent.setForward(1.0f);
                moveInputEvent.setStrafe(0.0f);
            }
        };
    }

    public static double c(double d2, double d3, double d4) {
        double d5;
        if (d2 < d3) {
            d5 = d3;
            return d5;
        }
        d5 = Math.min(d2, d4);
        return d5;
    }

    public EntityLivingBase e(List<EntityLivingBase> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.stream().min(Comparator.comparingDouble(entityLivingBase -> GrimReduceVelocity.aEg.thePlayer.getDistanceToEntity((Entity)entityLivingBase))).orElse(null);
    }

    public void l(Entity entity) {
        if (entity == null) {
            return;
        }
        Vector2f vector2f = aiu.y(entity);
        RotationComponent.d(false);
        RotationComponent.setRotations(new Vector2f(vector2f.x, GrimReduceVelocity.aEg.thePlayer.rotationPitch), 10.0, MovementFix.NORMAL);
    }

    public static Object[] mth_0OOOoo00o0_10() {
        Object[] objectArray = fld_0oOOoOo0O00O_21;
        if (fld_0oOOoOo0O00O_21 == null) {
            fld_0oOOoOo0O00O_21 = new Object[4];
            objectArray = fld_0oOOoOo0O00O_21;
        }
        return objectArray;
    }
}
