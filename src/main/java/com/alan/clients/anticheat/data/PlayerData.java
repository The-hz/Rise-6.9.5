package com.alan.clients.anticheat.data;

import com.alan.clients.Client;
import com.alan.clients.anticheat.check.Check;
import hackclient.rise.aih;
import hackclient.rise.l;
import hackclient.rise.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S14PacketEntity.S17PacketEntityLookMove;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.ad;
import net.minecraft.network.play.server.z;
import net.minecraft.util.MathHelper;
import rip.vantage.commons.util.time.a;

public final class PlayerData {
    private final EntityOtherPlayerMP player;
    private final List<Check> checks;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private double x;
    private double y;
    private double z;
    private double at;
    private double au;
    private double av;
    private double aw;
    private double ax;
    private double ay;
    private double az;
    private double aA;
    private double aB;
    private double aC;
    private double aD;
    private double aE;
    private double aF;
    private double aG;
    private double aH;
    private double aI;
    private double aJ;
    private double aK;
    private double aL;
    private double aM;
    private double aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ;
    private int aR;
    private boolean aS;
    private boolean aT;
    private final a aU = new a();
    private final a aV = new a();
    private int aW = 20;
    private int aX = 1;
    private int aY;
    private int aZ;
    private EntityPlayer lastAttackEntity;
    private final Map<Check, Float> bb = new HashMap<>();
    private boolean bc;
    private final a bd = new a();
    private final a be = new a();
    private final a bf = new a();
    private boolean bg;
    private boolean bh;
    private boolean bi;
    private int bj;
    private Item bk;

    public PlayerData(EntityOtherPlayerMP var1) {
        this.player = var1;
        this.ao = var1.serverPosX;
        this.ap = var1.serverPosY;
        this.aq = var1.serverPosZ;
        this.checks = l.loadChecks(this);
    }

    public void handle(Packet<?> var1) {
        if (this.player.ticksExisted <= 80) {
            this.aV.aX();
        } else if (!Client.a.x().a(this.player) && this.player.adr && !this.player.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer)) {
            if (o.b(var1)) {
                S14PacketEntity s14packetentity = (S14PacketEntity)var1;
                if (s14packetentity.entityId == this.player.getEntityId()) {
                    if (this.player.hurtTime != 0 && this.as > 9 && this.aZ > 40) {
                        this.as = 0;
                    }

                    this.ao = this.ao + s14packetentity.posX;
                    this.ap = this.ap + s14packetentity.posY;
                    this.aq = this.aq + s14packetentity.posZ;
                    this.at = this.x;
                    this.au = this.y;
                    this.av = this.z;
                    this.x = this.ao / 32.0;
                    this.y = this.ap / 32.0;
                    this.z = this.aq / 32.0;
                    this.aM = this.aK;
                    this.aN = this.aL;
                    if (var1 instanceof S17PacketEntityLookMove) {
                        this.aK = s14packetentity.yaw;
                        this.aL = s14packetentity.pitch;
                    }

                    this.az = this.aw;
                    this.aA = this.ax;
                    this.aB = this.ay;
                    this.aw = this.x - this.at;
                    this.ax = this.y - this.au;
                    this.ay = this.z - this.av;
                    this.aD = this.aC;
                    this.aC = MathHelper.sqrt_double(this.aw * this.aw + this.ay * this.ay);
                    double d0 = (float)this.aV.aKx() / 50.0F * 0.2;
                    if (this.aV.aKx() / 50L > this.aX && (this.aC > d0 || this.aD > d0)) {
                        this.aX = (int)(this.aV.aKx() / 50L);
                    }

                    this.aV.aX();
                    this.aP = this.aO;
                    this.aO = !(aih.o(this.x - 0.5, this.y - 0.43, this.z - 0.5) instanceof BlockAir)
                        || !(aih.o(this.x + 0.5, this.y - 0.43, this.z - 0.5) instanceof BlockAir)
                        || !(aih.o(this.x + 0.5, this.y - 0.43, this.z + 0.5) instanceof BlockAir)
                        || !(aih.o(this.x - 0.5, this.y - 0.43, this.z + 0.5) instanceof BlockAir);
                    this.aT = this.aS;
                    this.aS = !(aih.o(this.x - 0.5, this.y - 0.99, this.z - 0.5) instanceof BlockAir)
                        || !(aih.o(this.x + 0.5, this.y - 0.99, this.z - 0.5) instanceof BlockAir)
                        || !(aih.o(this.x + 0.5, this.y - 0.99, this.z + 0.5) instanceof BlockAir)
                        || !(aih.o(this.x - 0.5, this.y - 0.99, this.z + 0.5) instanceof BlockAir);
                    if (this.aO) {
                        this.aH = this.aE;
                        this.aI = this.aF;
                        this.aJ = this.aG;
                        this.aE = this.x;
                        this.aF = this.y;
                        this.aG = this.z;
                        this.aR++;
                    } else {
                        this.aR = 0;
                    }

                    if (this.aF - this.y > 2.5) {
                        this.aZ = 0;
                    }

                    double d1 = (MathHelper.wrapAngleTo180_double(Math.toDegrees(Math.atan2(this.at - this.x, this.av - this.z))) + 180.0) * -1.0;
                    double d2 = Math.abs(MathHelper.wrapAngleTo180_double(this.aw()) - d1);
                    this.aQ = d2 < 70.0 || d2 > 290.0;
                }
            } else if (var1 instanceof z zx) {
                if (zx.getEntityId() == this.player.getEntityId()) {
                    this.ao = zx.we();
                    this.ap = zx.wf();
                    this.aq = zx.wi();
                    this.at = this.x;
                    this.au = this.y;
                    this.av = this.z;
                    this.x = this.ao / 32.0;
                    this.y = this.ap / 32.0;
                    this.z = this.aq / 32.0;
                    this.ar = 0;
                    this.aD = this.aC;
                    this.aC = MathHelper.sqrt_double(this.aw * this.aw + this.ay * this.ay);
                    double d3 = (float)this.aV.aKx() / 50.0F * 0.2;
                    if (this.aV.aKx() / 50L > this.aX && (this.aC > d3 || this.aD > d3)) {
                        this.aX = (int)(this.aV.aKx() / 50L);
                    }
                }
            } else if (this.player.isSwingInProgress) {
                ArrayList arraylist = new ArrayList<>(Minecraft.getMinecraft().theWorld.playerEntities);
                List list = arraylist.stream().filter(var1x -> ((Entity)var1x).getDistanceSqToEntity(this.player) < 36.0).toList();
                if (list.size() == 2) {
                    this.lastAttackEntity = (EntityPlayer)list.get(0);
                    this.aY = 0;
                }
            }

            if (var1 instanceof ad ad && ad.getEntityId() == this.player.getEntityId() && ad.func_149376_c() != null) {
                ad.func_149376_c().forEach(var1x -> {
                    if (var1x.getDataValueId() == 0 && var1x.getObject() instanceof Byte) {
                        byte b0 = (Byte)var1x.getObject();
                        boolean flag = (b0 & 2) != 0;
                        boolean flag1 = (b0 & 8) != 0;
                        boolean flag2 = (b0 & 16) != 0;
                        this.bg = flag;
                        this.bh = flag1;
                        if (flag2) {
                            if (!this.bi) {
                                this.bi = true;
                            }

                            this.bj++;
                        } else {
                            this.bi = false;
                            this.bj = 0;
                        }
                    }
                });
            }

            this.checks.forEach(var1x -> var1x.handle(var1));
        }
    }

    public void incrementTick() {
        this.as++;
        this.ar++;
        this.aY++;
        this.aZ++;
    }

    public Check getCheck(Class<?> var1) {
        for (Check check : this.checks) {
            if (check.getClass() == var1) {
                return check;
            }
        }

        return null;
    }

    public float c(Check var1) {
        return this.a(var1, 1);
    }

    public float a(Check var1, int var2) {
        float f = this.bb.getOrDefault(var1, 0.0F) + var2;
        this.bb.put(var1, f);
        return f;
    }

    public float a(Check var1, float var2) {
        float f = this.bb.getOrDefault(var1, 0.0F) * var2;
        if (f < 0.0F) {
            f = 0.0F;
        }

        this.bb.put(var1, f);
        return f;
    }

    public boolean V() {
        return this.bc;
    }

    public boolean isSprinting() {
        return this.bh;
    }

    public boolean isUsingItem() {
        return this.bi;
    }

    public int W() {
        return this.bj;
    }

    public Item X() {
        return this.bk;
    }

    public void a(ItemStack var1) {
        this.bk = var1 != null ? var1.getItem() : null;
    }

    @Generated
    public EntityOtherPlayerMP getPlayer() {
        return this.player;
    }

    @Generated
    public List<Check> getChecks() {
        return this.checks;
    }

    @Generated
    public int aa() {
        return this.ao;
    }

    @Generated
    public int ab() {
        return this.ap;
    }

    @Generated
    public int ac() {
        return this.aq;
    }

    @Generated
    public int ad() {
        return this.ar;
    }

    @Generated
    public int ae() {
        return this.as;
    }

    @Generated
    public double getX() {
        return this.x;
    }

    @Generated
    public double getY() {
        return this.y;
    }

    @Generated
    public double getZ() {
        return this.z;
    }

    @Generated
    public double af() {
        return this.at;
    }

    @Generated
    public double ag() {
        return this.au;
    }

    @Generated
    public double ah() {
        return this.av;
    }

    @Generated
    public double ai() {
        return this.aw;
    }

    @Generated
    public double aj() {
        return this.ax;
    }

    @Generated
    public double ak() {
        return this.ay;
    }

    @Generated
    public double al() {
        return this.az;
    }

    @Generated
    public double am() {
        return this.aA;
    }

    @Generated
    public double an() {
        return this.aB;
    }

    @Generated
    public double ao() {
        return this.aC;
    }

    @Generated
    public double ap() {
        return this.aD;
    }

    @Generated
    public double aq() {
        return this.aE;
    }

    @Generated
    public double ar() {
        return this.aF;
    }

    @Generated
    public double as() {
        return this.aG;
    }

    @Generated
    public double at() {
        return this.aH;
    }

    @Generated
    public double au() {
        return this.aI;
    }

    @Generated
    public double av() {
        return this.aJ;
    }

    @Generated
    public double aw() {
        return this.aK;
    }

    @Generated
    public double ax() {
        return this.aL;
    }

    @Generated
    public double ay() {
        return this.aM;
    }

    @Generated
    public double az() {
        return this.aN;
    }

    @Generated
    public boolean isOnGround() {
        return this.aO;
    }

    @Generated
    public boolean aA() {
        return this.aP;
    }

    @Generated
    public boolean aB() {
        return this.aQ;
    }

    @Generated
    public int getGroundTicks() {
        return this.aR;
    }

    @Generated
    public boolean aC() {
        return this.aS;
    }

    @Generated
    public boolean aD() {
        return this.aT;
    }

    @Generated
    public a aE() {
        return this.aU;
    }

    @Generated
    public a aF() {
        return this.aV;
    }

    @Generated
    public int aG() {
        return this.aW;
    }

    @Generated
    public int aH() {
        return this.aX;
    }

    @Generated
    public int aI() {
        return this.aY;
    }

    @Generated
    public int aJ() {
        return this.aZ;
    }

    @Generated
    public EntityPlayer getLastAttackEntity() {
        return this.lastAttackEntity;
    }

    @Generated
    public Map<Check, Float> aL() {
        return this.bb;
    }

    @Generated
    public a aM() {
        return this.bd;
    }

    @Generated
    public a aN() {
        return this.be;
    }

    @Generated
    public a aO() {
        return this.bf;
    }

    @Generated
    public boolean isSneaking() {
        return this.bg;
    }
}
