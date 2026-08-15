package com.alan.clients.module.impl.combat;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.alan.clients.component.impl.player.PingSpoofComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.combat.velocity.GrimReduceVelocity;
import com.alan.clients.module.impl.combat.velocity.GrimVelocity;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.movement.speed.GrimSpeed;
import com.alan.clients.module.impl.player.Breaker;
import com.alan.clients.module.impl.player.Manager;
import com.alan.clients.module.impl.player.OldManager;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.module.impl.player.Stealer;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ClickEvent;
import com.alan.clients.newevent.impl.motion.HitSlowDownEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.SlowDownEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.MouseOverEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.newevent.impl.render.RenderItemEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.ListValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import hackclient.rise.adz;
import hackclient.rise.aef;
import hackclient.rise.afi;
import com.alan.clients.util.packet.PacketUtil;
import hackclient.rise.ahm;
import com.alan.clients.util.player.PlayerUtil;
import com.alan.clients.util.rotation.RotationUtil;
import hackclient.rise.aka;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import hackclient.rise.component.bc;
import com.alan.clients.component.impl.player.GUIDetectionComponent;
import hackclient.rise.component.bv;
import hackclient.rise.bx;
import com.alan.clients.component.impl.render.ESPComponent;
import hackclient.rise.component.esp.co;
import hackclient.rise.component.esp.cp;
import hackclient.rise.component.esp.ct;
import hackclient.rise.ea;
import hackclient.rise.en;
import hackclient.rise.gt;
import hackclient.rise.gu;
import hackclient.rise.gv;
import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.bw;
import net.minecraft.item.cn;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.l;
import net.minecraft.network.play.client.m;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Tuple;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases = {"module.combat.killaura.name", "Aura", "Force Field"}, description = "module.combat.killaura.description", category = Category.COMBAT)
public class KillAura extends Module {
   public MovingObjectPosition movingObjectPosition;
   public BooleanValue blockSlowdown;
   public BooleanValue rayCast;
   public int oB;
   public int ov;
   public int op;
   public static Object Oo0o00000O00;
   public NumberValue fOV;
   public int oH;
   public NumberValue advancedOvershootMax;
   public NumberValue randomizeFactor;
   public BooleanValue advancedSwing;
   public BooleanValue badPacketsCheck;
   public int of;
   public List<EntityLivingBase> oM;
   public NumberValue advancedDampedDistance;
   public boolean oJ;
   public BooleanValue showTargets;
   public boolean ob;
   public BooleanValue coloredSigmaRing;
   public BooleanValue extra;
   public boolean oI;
   public NumberValue advancedTriggerReaction;
   public EntityLivingBase jE;
   public BooleanValue advancedFlickGuard;
   public static Object[] o0Oo000O0oO = new Object[358];
   @EventLink
   public Listener<Render2DEvent> onRender2D;
   public BooleanValue keepSprint;
   public ModeValue lV;
   public NumberValue advancedGravity;
   @EventLink
   public Listener<SlowDownEvent> onSlowDown;
   public BooleanValue fireAspect;
   public boolean oD;
   public static boolean nS;
   public static Object[] oO00O0OO0ooO;
   public BooleanValue oldPredictionKeepSprint;
   public BooleanValue axes;
   public static boolean cK;
   public long ox;
   public static boolean nR;
   public BooleanValue oldMovefixBoost;
   public int oC;
   public boolean oc;
   public int mA;
   @EventLink
   public Listener<PreUpdateEvent> oS;
   public float oz;
   public ModeValue mode;
   public boolean mz;
   public boolean nU;
   public boolean oE;
   public BooleanValue hideSecondSword;
   public double mJ;
   public BoundsNumberValue switchDelay;
   public float om;
   public int ot;
   @EventLink
   public Listener<PostMotionEvent> onPostMotion;
   public BooleanValue showFOVCircle;
   public int nZ;
   public BooleanValue rightClickOnly;
   public float ol;
   public int my;
   public NumberValue advancedMinStep;
   public NumberValue advancedTriggerReactionJitter;
   public a nP;
   public BooleanValue silentRotations;
   public NumberValue advancedFlickMax;
   public ModeValue sorting;
   public BooleanValue noSwing;
   public BooleanValue velocityBoost;
   @EventLink
   public Listener<ea> oX;
   public aka os;
   public int mF;
   public boolean oF;
   public NumberValue advancedPrediction;
   public NumberValue advancedDeadzone;
   public gu mD;
   public float ok;
   public List<EntityLivingBase> nV;
   public int oa;
   public a nO;
   public int oA;
   public BooleanValue attackWhilstScaffolding;
   public Entity target;
   public float oi;
   public BooleanValue subtickRaycast;
   public NumberValue advancedPaceJitter;
   public NumberValue advancedAnchor;
   public BooleanValue preventServersideBlocking;
   public BooleanValue newYouNeedThisToggledOnCurreFake;
   public aka oq;
   public long nT;
   public BooleanValue sharpness;
   @EventLink
   public Listener<WorldChangeEvent> onWorldChange;
   public Map<Entity, Integer> oL;
   @EventLink(value = 3)
   public Listener<PacketSendEvent> onPacketSend;
   public BooleanValue knockbackDisplacementDebug;
   public BooleanValue playerTeammates;
   public Queue<Packet<?>> nN;
   @EventLink
   public Listener<MouseOverEvent> onMouseOver;
   public static float og;
   public int mH;
   public NumberValue advancedOvershootScale;
   public Random od;
   public adz<EntityLivingBase> oK;
   public int oo;
   public Animation oO;
   public BooleanValue swords;
   public NumberValue advancedWind;
   public boolean ow;
   public BoundsNumberValue cps;
   public Vector2f mG;
   public NumberValue advancedAimReactionJitter;
   public ModeValue boxMode;
   public BooleanValue weapons;
   public int oe;
   public boolean mK;
   @EventLink
   public Listener<HitSlowDownEvent> onHitSlowDown;
   public NumberValue advancedMaxStep;
   @EventLink
   public Listener<en> pb;
   public BooleanValue throughWalls;
   public BooleanValue fallbackToWatchdog;
   @EventLink(value = 3)
   public Listener<RenderItemEvent> onRenderItem;
   public boolean oG;
   public NumberValue advancedAimReaction;
   public static boolean nQ;
   public BooleanValue animals;
   public BooleanValue knockbackDisplacement;
   public BooleanValue invisibles;
   public NumberValue advancedHoldTicks;
   public BooleanValue fist;
   public BooleanValue mobs;
   public boolean mC;
   public String mE;
   public int nW;
   public NumberValue advancedGaussian;
   public BooleanValue newUniversalKeepSprint;
   public BooleanValue advanced;
   public BoundsNumberValue rotationSpeed;
   public NumberValue advancedOvershootChance;
   public ListValue<MovementFix> movementCorrection;
   public aka or;
   public NumberValue rotationRange;
   public ModeValue rotationMode;
   public BooleanValue autoDisable;
   public BooleanValue showMovementArc;
   @EventLink
   public Listener<ClickEvent> onClick;
   public NumberValue range;
   public BooleanValue randomize19Speed;
   public int hV;
   public int oy;
   public BooleanValue player;
   public Animation oN;
   @EventLink
   public Listener<JumpEvent> onJump;
   public Vector2f nt;
   public NumberValue advancedCruiseFloor;
   public int nY;
   public NumberValue boostTicks;
   public String nE;
   public static Object[] fld_0OOOoo00o0_17;
   public ModeValue clickMode;
   public NumberValue advancedAccuracy;
   public float oj;
   public Vector2f on;
   public NumberValue advancedBurstStrength;
   @EventLink
   public Listener<PreMotionEvent> onPreMotionEvent;
   public long ou;
   public static boolean mB;
   public static Object[] fld_0oOOoOo0O00O_18;
   public NumberValue advancedBurstChance;
   @EventLink(value = 3)
   public Listener<PreUpdateEvent> oR;
   public BooleanValue knockback;
   public int nX;
   public ModeValue espMode;
   public static float oh;

   public Tuple<Boolean, Double> eo() {
      Object var52 = null;
      double var53 = 0.0;
      Object var55 = null;
      double var64 = 0.0;
      var64 = -1.0;
      int var50_lo = 0;
      var52 = this.clickMode.wo().getName();
      int var50_hi = -1;
      switch (((String)var52).hashCode()) {
         case 1505775:
            if (((String)var52).equals("1.9+")) {
               var50_hi = 1;
            }
            break;
         case 1934158813:
            if (((String)var52).equals("1.9+ With 1.8 Animations")) {
               var50_hi = 0;
            }
      }

      switch (var50_hi) {
         case 0:
         case 1:
            if (this.clickMode.wo().getName().equals("1.9+ With 1.8 Animations") && Math.random() > 0.2) {
               RenderUtil.E(this.jE);
            }

            var53 = 4.0;
            if (aEg.thePlayer.getHeldItem() != null) {
               var55 = aEg.thePlayer.getHeldItem().getItem();
               if ((Item)var55 instanceof ItemSword) {
                  var53 = 1.6;
               } else if ((Item)var55 instanceof cn) {
                  var53 = 1.0;
               } else if ((Item)var55 instanceof bw) {
                  var53 = 1.2;
               } else if ((Item)var55 instanceof ItemAxe) {
                  switch (gt.pe[((ItemAxe)((Item)var55)).getToolMaterial().ordinal()]) {
                     case 1:
                     case 2:
                        var53 = 0.8;
                        break;
                     case 3:
                        var53 = 0.9;
                        break;
                     default:
                        var53 = 1.0;
                  }
               } else if ((Item)var55 instanceof ItemHoe) {
                  switch (gt.pe[((ItemHoe)((Item)var55)).getToolMaterial().ordinal()]) {
                     case 1:
                     case 4:
                        var53 = 1.0;
                        break;
                     case 2:
                        var53 = 2.0;
                        break;
                     case 3:
                        var53 = 3.0;
                  }
               }
            }

            if (this.randomize19Speed.wo()) {
               var53 -= Math.random() * this.randomizeFactor.wo().doubleValue();
            }

            var64 = 1.0 / var53 * 20.0 - 1.0;
         default:
            var64 = this.j(var64);
            return new Tuple<>(Boolean.valueOf((var50_lo) != 0), var64);
      }
   }

   public boolean eF() {
      return aEg.thePlayer != null && this.eD()[1] != -1;
   }

   public void c(MovingObjectPosition var1) {
      if (!aEg.playerController.isPlayerRightClickingOnEntity(aEg.thePlayer, var1.entityHit, var1)) {
         aEg.playerController.interactWithEntitySendPacket(aEg.thePlayer, var1.entityHit);
      }
   }

   public boolean a(EntityLivingBase var1, MovingObjectPosition var2, double var3) {
      long var88 = 0L;
      long var92 = 0L;
      if (!this.eR()) {
         return true;
      } else if (var1 == null) {
         this.ov = Integer.MIN_VALUE;
         this.ow = false;
         this.ox = 0L;
         return false;
      }
      int notDistanceToEntity = (this.rayCast.wo() || !(aEg.thePlayer.getDistanceToEntity(var1) <= var3)) && (var2 == null || var2.entityHit != var1) ? 0 : 1;
      if (notDistanceToEntity == 0) {
         this.ow = false;
         this.ov = Integer.MIN_VALUE;
         this.ox = 0L;
         return false;
      }
      int entityId = var1.getEntityId();
      var92 = System.currentTimeMillis();
      if (this.ow && this.ov == entityId) {
         return var92 >= this.ox;
      }
      this.ov = entityId;
      this.ow = true;
      var88 = this.a(this.advancedTriggerReaction.wo().doubleValue(), this.advancedTriggerReactionJitter.wo().doubleValue(), 0L, 450L);
      this.ox = var92 + var88;
      return var88 <= 0L;
   }

   public boolean eG() {
      int keyDown = (int)(aEg.gameSettings.cgI.isKeyDown() ? 1L : 0L);
      if (!this.eA() || !this.rightClickOnly.wo()) {
         this.oH = -1;
         this.oI = (keyDown) != 0;
         return false;
      } else if (this.oH != -1) {
         this.oJ = true;
         nR = false;
         if (aEg.thePlayer.ticksExisted != this.oH) {
            this.q(true);
            this.oH = -1;
         }

         this.oI = (keyDown) != 0;
         return true;
      } else if (this.oI && keyDown == 0) {
         this.oH = aEg.thePlayer.ticksExisted;
         this.oJ = true;
         nR = false;
         this.oI = false;
         return true;
      }
      this.oI = (keyDown) != 0;
      return false;
   }

   public Vector2f a(EntityLivingBase var1, double var2, boolean var4) {
      Object var37 = null;
      float var44 = 0.0F;
      Object var46 = null;
      if (var1 == null) {
         return new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch);
      }
      int ticksExisted2 = aEg.thePlayer.ticksExisted;
      if (this.mG != null && this.mH == ticksExisted2 && this.target == var1 && this.mJ == var2 && this.mK == var4) {
         return this.mG;
      }
      var37 = var1.getEntityBoundingBox();
      if ((AxisAlignedBB)var37 != null && !((AxisAlignedBB)var37).hasNaN()) {
         var44 = this.en();
         var37 = ((AxisAlignedBB)var37).expand(var44, var44, var44);
         var46 = RotationUtil.a(var1, (AxisAlignedBB)var37, true, var2, var4, var44);
      } else {
         var46 = RotationUtil.calculate(var1, true, var2);
      }

      this.mG = (Vector2f)var46;
      this.mH = ticksExisted2;
      this.target = var1;
      this.mJ = var2;
      this.mK = var4;
      return (Vector2f)var46;
   }

   public Vector2f b(Vector2f var1) {
      Object var147 = null;
      float var153 = 0.0F;
      float var154 = 0.0F;
      float var155 = 0.0F;
      float var160 = 0.0F;
      float var163 = 0.0F;
      float var166 = 0.0F;
      float var173 = 0.0F;
      float var175 = 0.0F;
      float var177 = 0.0F;
      float var180 = 0.0F;
      float var181 = 0.0F;
      float var187 = 0.0F;
      float var188 = 0.0F;
      float var189 = 0.0F;
      float var192 = 0.0F;
      Object var197 = null;
      float var200 = 0.0F;
      float var203 = 0.0F;
      float var204 = 0.0F;
      Object var205 = null;
      float var206 = 0.0F;
      float var208 = 0.0F;
      float var209 = 0.0F;
      float var210 = 0.0F;
      float var212 = 0.0F;
      float var213 = 0.0F;
      float var214 = 0.0F;
      float var215 = 0.0F;
      float var216 = 0.0F;
      if (!this.eR()) {
         return var1;
      }
      var147 = this.eQ();
      if (this.jE == null) {
         return var1;
      }
      var153 = this.advancedMaxStep.wo().floatValue();
      var154 = this.advancedDampedDistance.wo().floatValue();
      var181 = Math.max(0.25F, this.advancedMinStep.wo().floatValue());
      var192 = MathHelper.clamp_float(this.advancedAccuracy.wo().floatValue() / 100.0F, 0.4F, 1.0F);
      if (this.om <= 0.001F) {
         this.om = var153;
      }

      int entityId = this.jE.getEntityId();
      if (entityId != this.op) {
         this.oi = 0.0F;
         this.oj = 0.0F;
         this.ok = 0.0F;
         this.ol = 0.0F;
         this.om = var153;
         this.on = null;
         this.oo = 0;
         this.oq = null;
         this.ot = 0;
         this.ou = 0L;
         this.ov = Integer.MIN_VALUE;
         this.ow = false;
         this.ox = 0L;
         this.oy = 0;
         this.oz = 0.0F;
         this.op = entityId;
         this.a((Vector2f)var147, var1);
      }

      var205 = var1;
      int var184_hi = 0;
      if (this.on != null) {
         var180 = MathHelper.wrapAngleTo180_float(this.on.x - ((Vector2f)var147).x);
         var203 = this.on.y - ((Vector2f)var147).y;
         var160 = (float)Math.hypot(var180, var203);
         if (!(var160 < 1.15F) && this.oo-- > 0) {
            var205 = this.on;
            var184_hi = 1;
         } else {
            this.on = null;
         }
      }

      var180 = MathHelper.wrapAngleTo180_float(((Vector2f)var205).x - ((Vector2f)var147).x);
      var203 = ((Vector2f)var205).y - ((Vector2f)var147).y;
      var160 = (float)Math.hypot(var180, var203);
      var213 = Math.max(0.001F, var160);
      var155 = this.advancedDeadzone.wo().floatValue();
      var197 = aef.a((Vector2f)var147, this.range.wo().doubleValue() + 0.15, this.en(), aEg.thePlayer, this.em());
      int flag = (MovingObjectPosition)var197 != null && ((MovingObjectPosition)var197).typeOfHit == MovingObjectType.ENTITY && ((MovingObjectPosition)var197).entityHit == this.jE ? 1 : 0;
      if (var184_hi == 0 && flag != 0 && var160 <= var155) {
         this.ot = Math.max(this.ot, this.advancedHoldTicks.wo().intValue());
      }

      if (var184_hi == 0 && this.ot > 0 && flag != 0 && var160 <= var155 * 1.35F) {
         this.ot--;
         this.ok *= 0.42F;
         this.ol *= 0.42F;
         return RotationUtil.applySensitivityPatch(new Vector2f(((Vector2f)var147).x, ((Vector2f)var147).y), (Vector2f)var147);
      }
      if (this.ot > 0) {
         this.ot--;
      }

      if (var160 < 0.001F) {
         this.ok *= 0.6F;
         this.ol *= 0.6F;
         return RotationUtil.applySensitivityPatch(new Vector2f(((Vector2f)var147).x, MathHelper.clamp_float(((Vector2f)var147).y, -90.0F, 90.0F)), (Vector2f)var147);
      }
      var204 = Math.min(this.advancedWind.wo().floatValue(), var160);
      if (var160 >= var154) {
         this.oi = this.oi / og + this.b(var204 / oh, var204);
         this.oj = this.oj / og + this.b(var204 / oh, var204);
         var206 = var153 * (0.78F + this.od.nextFloat() * 0.32F);
         this.om = Math.max(this.om, var206);
      } else {
         this.oi = this.oi / og;
         this.oj = this.oj / og;
         if (this.om < var181) {
            this.om = var181 + this.od.nextFloat() * 0.7F;
         } else {
            this.om = Math.max(var181, this.om / oh);
         }
      }

      var206 = this.advancedGravity.wo().floatValue();
      if (var160 < 3.5F) {
         var206 *= 0.82F + var192 * 0.12F;
      }

      this.ok = this.ok + (this.oi + var206 * var180 / var213);
      this.ol = this.ol + (this.oj + var206 * var203 / var213);
      var212 = 1.0F;
      var175 = this.advancedPaceJitter.wo().floatValue();
      if (var175 > 1.0E-4F) {
         var212 += this.b(var175 * 0.42F, var175);
      }

      if (var184_hi == 0 && var160 > var155 * 1.6F && var160 < var154 * 1.45F) {
         var187 = this.advancedBurstChance.wo().floatValue() / 100.0F;
         if (this.oy <= 0 && var187 > 1.0E-4F && this.od.nextFloat() < var187 * 0.12F) {
            this.oy = 1 + this.od.nextInt(2);
            this.oz = this.advancedBurstStrength.wo().floatValue() * (0.65F + this.od.nextFloat() * 0.55F);
         }
      }

      if (this.oy > 0) {
         var212 *= 1.0F + this.oz;
         this.oy--;
      } else {
         this.oz *= 0.55F;
      }

      var212 = MathHelper.clamp_float(var212, 0.72F, 1.55F);
      var187 = Math.max(var181, this.om * var212);
      var173 = (float)Math.hypot(this.ok, this.ol);
      if (var173 > var187) {
         var189 = var187 * (0.52F + this.od.nextFloat() * 0.48F);
         this.ok = this.ok / var173 * var189;
         this.ol = this.ol / var173 * var189;
      }

      if (var160 < 2.0F) {
         var189 = 0.86F + var192 * 0.08F;
         this.ok *= var189;
         this.ol *= var189;
      } else if (var160 < 5.0F) {
         this.ok *= 0.94F;
         this.ol *= 0.94F;
      }

      var189 = this.advancedCruiseFloor.wo().floatValue();
      if (var184_hi == 0 && var189 > 0.01F && var160 > var155 * 1.25F && var160 < 14.0F) {
         var216 = var189 * (0.86F + this.od.nextFloat() * 0.24F);
         var166 = (float)Math.hypot(this.ok, this.ol);
         if (var166 < var216) {
            var177 = (var216 - var166) * (0.72F + this.od.nextFloat() * 0.36F);
            this.ok += var180 / var213 * var177;
            this.ol += var203 / var213 * var177;
         }
      }

      var216 = MathHelper.clamp_float(var160 / 45.0F, 0.0F, 1.0F);
      var166 = (0.16F + var216 * 0.42F) * (0.55F + var192 * 0.45F);
      var166 *= MathHelper.clamp_float(0.88F + (var212 - 1.0F) * 0.5F, 0.74F, 1.18F);
      if (this.oz > 0.02F) {
         var166 *= 1.0F + this.oz * 0.35F;
      }

      if (var184_hi != 0) {
         var166 *= 0.55F;
      }

      var177 = ((Vector2f)var147).x + this.ok + var180 * var166;
      var214 = MathHelper.clamp_float(((Vector2f)var147).y + this.ol + var203 * (var166 * 0.85F), -89.9F, 89.9F);
      if (var184_hi == 0 && var160 < 1.65F) {
         var210 = (0.56F + var192 * 0.28F) * (0.94F + this.od.nextFloat() * 0.1F);
         var177 = ((Vector2f)var147).x + var180 * var210;
         var214 = MathHelper.clamp_float(((Vector2f)var147).y + var203 * var210, -89.9F, 89.9F);
         this.ok *= 0.55F;
         this.ol *= 0.55F;
      }

      var210 = this.advancedGaussian.wo().floatValue();
      if (var210 > 0.0F && var160 > 0.35F) {
         var209 = MathHelper.clamp_float(var160 / 16.0F, 0.25F, 1.0F);
         var209 *= 1.05F - var192 * 0.35F;
         if (var184_hi != 0) {
            var209 *= 0.8F;
         }

         var177 += this.b(var210 * var209, var210 * 2.2F * var209);
         var214 += this.b(var210 * 0.45F * var209, var210 * 1.5F * var209);
         var214 = MathHelper.clamp_float(var214, -89.9F, 89.9F);
      }

      if (this.advancedFlickGuard.wo() && var184_hi == 0) {
         var209 = MathHelper.wrapAngleTo180_float(var177 - ((Vector2f)var147).x);
         var208 = var214 - ((Vector2f)var147).y;
         var188 = (float)Math.hypot(var209, var208);
         if (var188 > 0.001F) {
            var215 = this.advancedFlickMax.wo().floatValue();
            var163 = MathHelper.clamp_float(var160 / 24.0F, 0.0F, 1.0F);
            var215 *= 0.85F + var163 * 0.4F;
            var215 *= 0.92F + this.od.nextFloat() * 0.2F;
            if (var188 > var215) {
               var200 = var215 / var188;
               var177 = ((Vector2f)var147).x + var209 * var200;
               var214 = MathHelper.clamp_float(((Vector2f)var147).y + var208 * var200, -89.9F, 89.9F);
               this.ok *= 0.82F;
               this.ol *= 0.82F;
            }
         }
      }

      return RotationUtil.applySensitivityPatch(new Vector2f(var177, var214), (Vector2f)var147);
   }

   public void eW() {
      this.oi = 0.0F;
      this.oj = 0.0F;
      this.ok = 0.0F;
      this.ol = 0.0F;
      this.om = this.advancedMaxStep.wo().floatValue();
      this.on = null;
      this.oo = 0;
      this.oq = null;
      this.or = new aka(0.0, 0.0, 0.0);
      this.os = new aka(0.0, 0.0, 0.0);
      this.ot = 0;
      this.ou = 0L;
      this.ov = Integer.MIN_VALUE;
      this.ow = false;
      this.ox = 0L;
      this.oy = 0;
      this.oz = 0.0F;
      this.op = Integer.MIN_VALUE;
   }

   public boolean eX() {
      if (!this.rightClickOnly.wo() || aEg.gameSettings.cgI.isKeyDown()) {
         SlotComponent var10000 = this.d(SlotComponent.class);
         if (SlotComponent.getItemStack() != null) {
            var10000 = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack().getItem() instanceof ItemSword && (!this.eA() || this.eE())) {
               return true;
            }
         }
      }

      return false;
   }

   public KillAura() {
      super();
      int var822 = 0;
      var822 = -1696500114;
      this.mode = new ModeValue("Attack Mode", this).add(new SubMode("Single")).add(new SubMode("Switch")).add(new SubMode("Multiple")).setDefault("Single");
      this.switchDelay = new BoundsNumberValue("Switch Delay", this, 0, 0, 0, 10, 1, () -> !this.mode.wo().getName().equals("Switch"));
      this.lV = new ModeValue("Auto Block", this)
         .add(new SubMode("None"))
         .add(new SubMode("Fake"))
         .add(new SubMode("Vanilla"))
         .add(new SubMode("NCP"))
         .add(new SubMode("Legit"))
         .add(new SubMode("Grim"))
         .add(new SubMode("Intave"))
         .add(new SubMode("Old Intave"))
         .add(new SubMode("Imperfect Vanilla"))
         .add(new SubMode("Vanilla ReBlock"))
         .add(new SubMode("Watchdog 1.12"))
         .add(new SubMode("New NCP"))
         .add(new SubMode("Universal"))
         .add(new SubMode("Watchdog"))
         .add(new SubMode("Dual Sword"))
         .add(new SubMode("Watchdog 1.8"))
         .setDefault("None");
      this.newYouNeedThisToggledOnCurreFake = new BooleanValue("New (you need this toggled on curreFake", this, false, () -> !this.lV.wo().getName().equals("Watchdog"));
      this.fallbackToWatchdog = new BooleanValue("Fallback to Watchdog", this, false, () -> !this.eB());
      this.hideSecondSword = new BooleanValue("Hide Second Sword", this, true, () -> (!this.eB() ? 1 : 73 ^ 82 ^ 27) != 0);
      this.rightClickOnly = new BooleanValue(
         "Right Click Only", this, false, () -> this.lV.wo().getName().equals("None") || this.lV.wo().getName().equals("Fake")
      );
      this.preventServersideBlocking = new BooleanValue(
         "Prevent Serverside Blocking",
         this,
         false,
         () -> (!this.lV.wo().getName().equals("None") && !this.lV.wo().getName().equals("Fake") ? 1 : 105 - 105) != 0
      );
      this.blockSlowdown = new BooleanValue(
         "Block Slowdown", this, false, () -> this.lV.wo().getName().equals("None") || this.lV.wo().getName().equals("Fake")
      );
      this.sorting = new ModeValue("Sorting", this).add(new SubMode("Distance")).add(new SubMode("Health")).add(new SubMode("Hurt Time")).setDefault("Distance");
      this.clickMode = new ModeValue("Click Delay Mode", this)
         .add(new SubMode("Normal"))
         .add(new SubMode("Hit Select"))
         .add(new SubMode("1.9+"))
         .add(new SubMode("1.9+ With 1.8 Animations"))
         .setDefault("Normal");
      this.randomize19Speed = new BooleanValue("Randomize 1.9+ Speed", this, false, () -> (!this.clickMode.wo().getName().contains("1.9+") ? 1 : (-57 ^ 17) - -42) != 0);
      this.randomizeFactor = new NumberValue("Randomize Factor", this, 0.2, 0.05, 1.0, 0.05, () -> !this.randomize19Speed.wo() || !this.clickMode.wo().getName().contains("1.9+"));
      this.range = new NumberValue("Range", this, 3, 3, 6, 0.1);
      this.rotationRange = new NumberValue("Rotation Range", this, 3, 0, 6, 0.1);
      this.rotationSpeed = new BoundsNumberValue("Rotation speed", this, 5, 10, 0, 10, 1);
      this.fOV = new NumberValue("FOV", this, 360, 0, 360, 1);
      this.showFOVCircle = new BooleanValue("Show FOV Circle", this, false, () -> (this.fOV.wo().doubleValue() >= 360.0 ? 1 : -109 - -109) != 0);
      this.cps = new BoundsNumberValue("CPS", this, 10, 15, 1, 20, 1);
      this.velocityBoost = new BooleanValue("Velocity Boost", this, false);
      this.boostTicks = new NumberValue("Boost Ticks", this, 4, 1, 10, 1, () -> {
         boolean var10000;
         if (!this.velocityBoost.wo()) {
            var10000 = true;
         } else {
            byte var4x = 11;
            var4x = -109;
            boolean var6 = false;
            var10000 = var6;
         }

         return var10000;
      });
      this.knockbackDisplacement = new BooleanValue("Knockback Displacement", this, true);
      this.knockbackDisplacementDebug = new BooleanValue("Knockback Displacement Debug", this, false, () -> (!this.eV() ? 1 : -94 ^ -94) != 0);
      this.silentRotations = new BooleanValue("Silent Rotations", this, true);
      this.movementCorrection = new ListValue<>("Movement correction", this);
      this.showMovementArc = new BooleanValue(
         "Show Movement Arc", this, false, () -> (this.movementCorrection.wo() == MovementFix.OFF ? 1 : -71 - -57 ^ -14) != 0
      );
      this.keepSprint = new BooleanValue("Keep sprint", this, false);
      this.oldPredictionKeepSprint = new BooleanValue("Old Prediction Keep sprint", this, false);
      this.oldMovefixBoost = new BooleanValue("Old Movefix Boost", this, false);
      this.newUniversalKeepSprint = new BooleanValue("New Universal Keep sprint", this, false);
      this.my = 0;
      this.mz = false;
      this.mA = -1;
      this.mC = false;
      this.mE = "";
      this.mF = -1;
      this.mH = -1;
      this.espMode = new ModeValue("Target ESP Mode", this).add(new SubMode("Ring")).add(new SubMode("Box")).add(new SubMode("None")).setDefault("Ring");
      this.coloredSigmaRing = new BooleanValue("Colored Sigma Ring", this, true, () -> !this.espMode.wo().getName().equals("Ring"));
      this.boxMode = new ModeValue("Box Mode", this, () -> (!this.espMode.wo().getName().equals("Box") ? 1 : 60 ^ 60) != 0)
         .add(new SubMode("Above"))
         .add(new SubMode("Full"))
         .setDefault("Ring");
      this.rayCast = new BooleanValue("Ray cast", this, false);
      this.subtickRaycast = new BooleanValue("Subtick Raycast", this, true, () -> !this.rayCast.wo());
      this.throughWalls = new BooleanValue("Through Walls", this, false, () -> {
         boolean var10000;
         if (!this.rayCast.wo()) {
            var10000 = true;
         } else {
            byte var4x = -74;
            var4x = 12;
            boolean var6 = false;
            var10000 = var6;
         }

         return var10000;
      });
      this.advanced = new BooleanValue("Advanced", this, false);
      this.rotationMode = new ModeValue("Rotation Mode", this, () -> !this.advanced.wo())
         .add(new SubMode("Legit/Normal"))
         .add(new SubMode("Snap"))
         .add(new SubMode("NCP"))
         .add(new SubMode("Autistic AntiCheat"))
         .add(new SubMode("Advanced"))
         .add(new SubMode("Grim"))
         .setDefault("Legit/Normal");
      this.advancedGravity = new NumberValue("Advanced Gravity", this, 9, 1, 20, 0.1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedWind = new NumberValue("Advanced Wind", this, 6, 0, 10, 0.1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedDampedDistance = new NumberValue("Advanced Damped Distance", this, 12, 1, 45, 1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedMaxStep = new NumberValue("Advanced Max Step", this, 15, 3, 60, 0.5, () -> (!this.rotationMode.wo().getName().equals("Advanced") ? 1 : 104 + -104) != 0);
      this.advancedOvershootChance = new NumberValue("Advanced Overshoot Chance", this, 77, 0, 100, 1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedOvershootScale = new NumberValue("Advanced Overshoot Scale", this, 0.0, 0.0, 0.6, 0.01, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedOvershootMax = new NumberValue("Advanced Overshoot Max", this, 17, 2, 45, 0.5, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedGaussian = new NumberValue("Advanced Gaussian", this, 0.0, 0, 0.6, 0.01, () -> {
         boolean var10000;
         if (!this.rotationMode.wo().getName().equals("Advanced")) {
            var10000 = true;
         } else {
            byte var6 = 104;
            var6 = -43;
            boolean var8 = false;
            var10000 = var8;
         }

         return var10000;
      });
      this.advancedAccuracy = new NumberValue("Advanced Accuracy", this, 40, 40, 100, 1, () -> (!this.rotationMode.wo().getName().equals("Advanced") ? 1 : -88 - -88) != 0);
      this.advancedMinStep = new NumberValue("Advanced Min Step", this, 0, 0.0, 8.0, 0.1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedPrediction = new NumberValue("Advanced Prediction", this, 1.0, 0, 3.5, 0.05, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedDeadzone = new NumberValue("Advanced Deadzone", this, 1.0, 0.25, 4.5, 0.05, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedAnchor = new NumberValue(
         "Advanced Anchor", this, 0.0, 0.0, 0.7, 0.01, () -> (!this.rotationMode.wo().getName().equals("Advanced") ? 1 : (28 ^ -53) - -41) != 0
      );
      this.advancedHoldTicks = new NumberValue("Advanced Hold Ticks", this, 2, 0, 8, 1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedCruiseFloor = new NumberValue("Advanced Cruise Floor", this, 1.0, 0.0, 5.0, 0.05, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedPaceJitter = new NumberValue("Advanced Pace Jitter", this, 0.0, 0.0, 0.8, 0.01, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedBurstChance = new NumberValue(
         "Advanced Burst Chance", this, 21, 0, 100, 1, () -> (!this.rotationMode.wo().getName().equals("Advanced") ? 1 : -18 + -54 - -72) != 0
      );
      this.advancedBurstStrength = new NumberValue("Advanced Burst Strength", this, 0.0, 0.0, 1.0, 0.01, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedFlickGuard = new BooleanValue("Advanced Flick Guard", this, true, () -> {
         int var10000;
         if (!this.rotationMode.wo().getName().equals("Advanced")) {
            var10000 = 1;
         } else {
            int var6 = -56;
            var6 += -22;
            var6 -= -78;
            var10000 = var6;
         }

         return var10000 != 0;
      });
      this.advancedFlickMax = new NumberValue("Advanced Flick Max", this, 29, 4, 60, 0.5, () -> (!this.rotationMode.wo().getName().equals("Advanced") ? 1 : -9 + 9) != 0);
      this.advancedSwing = new BooleanValue("Advanced Swing", this, true, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedAimReaction = new NumberValue("Advanced Aim Reaction", this, 180, 30, 450, 5, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.advancedAimReactionJitter = new NumberValue("Advanced Aim Reaction Jitter", this, 44, 0, 220, 1, () -> {
         boolean var10000;
         if (!this.rotationMode.wo().getName().equals("Advanced")) {
            var10000 = true;
         } else {
            byte var6 = -105;
            var6 = 10;
            boolean var8 = false;
            var10000 = var8;
         }

         return var10000;
      });
      this.advancedTriggerReaction = new NumberValue(
         "Advanced Trigger Reaction", this, 95, 0, 300, 5, () -> (!this.rotationMode.wo().getName().equals("Advanced") ? 1 : 123 - 123) != 0
      );
      this.advancedTriggerReactionJitter = new NumberValue("Advanced Trigger Reaction Jitter", this, 30, 0, 140, 1, () -> !this.rotationMode.wo().getName().equals("Advanced"));
      this.nt = null;
      this.attackWhilstScaffolding = new BooleanValue("Attack whilst Scaffolding", this, false, () -> {
         boolean var10000;
         if (!this.advanced.wo()) {
            var10000 = true;
         } else {
            byte var4x = 105;
            var4x = -41;
            boolean var6 = false;
            var10000 = var6;
         }

         return var10000;
      });
      this.noSwing = new BooleanValue("No swing", this, false, () -> !this.advanced.wo());
      this.autoDisable = new BooleanValue("Auto disable", this, false, () -> !this.advanced.wo());
      this.badPacketsCheck = new BooleanValue("BadPackets check", this, true, () -> (!this.advanced.wo() ? 1 : 175 - 54 + -121) != 0);
      this.showTargets = new BooleanValue("Targets", this, false);
      this.player = new BooleanValue("Player", this, true, () -> !this.showTargets.wo());
      this.invisibles = new BooleanValue("Invisibles", this, false, () -> !this.showTargets.wo());
      this.animals = new BooleanValue("Animals", this, false, () -> !this.showTargets.wo());
      this.mobs = new BooleanValue("Mobs", this, false, () -> {
         boolean var10000;
         if (!this.showTargets.wo()) {
            var10000 = true;
         } else {
            byte var4x = -29;
            var4x = -23;
            boolean var6 = false;
            var10000 = var6;
         }

         return var10000;
      });
      this.playerTeammates = new BooleanValue("Player Teammates", this, true, () -> !this.showTargets.wo());
      this.nE = null;
      this.weapons = new BooleanValue("Weapons", this, false);
      this.fist = new BooleanValue("Fist", this, false, () -> (!this.weapons.wo() ? 1 : -92 - -92) != 0);
      this.swords = new BooleanValue("Swords", this, true, () -> !this.weapons.wo());
      this.axes = new BooleanValue("Axes", this, false, () -> (!this.weapons.wo() ? 1 : (103 ^ 74) + -45) != 0);
      this.extra = new BooleanValue("Extra", this, false, () -> {
         int var10000;
         if (!this.weapons.wo()) {
            var10000 = 1;
         } else {
            int var4x = 38;
            var4x ^= -115;
            var4x -= -85;
            var10000 = var4x;
         }

         return var10000 != 0;
      });
      this.sharpness = new BooleanValue("Sharpness", this, false, () -> (!this.weapons.wo() ? 1 : -13 - -13) != 0);
      this.knockback = new BooleanValue("Knockback", this, false, () -> !this.weapons.wo());
      this.fireAspect = new BooleanValue("Fire aspect", this, false, () -> !this.weapons.wo());
      this.nN = new ConcurrentLinkedQueue<>();
      this.nO = new a();
      this.nP = new a();
      this.nU = false;
      this.od = new Random();
      this.oe = 100;
      this.of = 0;
      this.op = Integer.MIN_VALUE;
      this.or = new aka(0.0, 0.0, 0.0);
      this.os = new aka(0.0, 0.0, 0.0);
      this.ov = Integer.MIN_VALUE;
      this.oA = -1;
      this.oB = -1;
      this.oC = -1;
      this.oH = -1;
      this.oK = new adz<>(9);
      this.oL = new HashMap<>();
      this.oM = new ArrayList<>();
      this.oN = new Animation(Easing.EASE_OUT_CUBIC, 300L);
      this.oO = new Animation(Easing.EASE_OUT_CUBIC, 250L);
      this.onPreMotionEvent = var1x -> {
         Object var136 = null;
         Object var144 = null;
         Object var151 = null;
         Object var160 = null;
         int nextInt2;
         Object var168 = null;
         if (!this.oJ) {
            label122: {
               this.nN.forEach(PacketUtil::m);
               this.nN.clear();
               this.oa++;
               SlotComponent var10000 = this.d(SlotComponent.class);
               if (SlotComponent.getItemStack() != null) {
                  var10000 = this.d(SlotComponent.class);
                  if (SlotComponent.getItemStack().getItem() instanceof ItemSword) {
                     break label122;
                  }
               }

               nQ = false;
            }

            if (!GUIDetectionComponent.inGUI()) {
               if (this.jE == null || aEg.thePlayer.isDead || this.e(Scaffold.class).isEnabled()) {
                  if (this.eA()) {
                     this.q(true);
                  } else if (!this.lV.wo().getName().equals("Watchdog 1.12")) {
                     if (this.lV.wo().getName().equals("Watchdog") && !this.mz && nQ && !SlotComponent.dj) {
                        if (this.ez()) {
                           this.mz = true;
                        }
                     } else if (!BadPacketsComponent.aW()) {
                        this.p(false);
                     }
                  } else if (!BadPacketsComponent.aW()) {
                     int bCP2 = aEg.playerController.bCP;

                     do {
                        nextInt2 = ThreadLocalRandom.current().nextInt(8);
                     } while (bCP2 == nextInt2);

                     if (nQ && !SlotComponent.dj) {
                        aEg.getNetHandler().addToSendQueue(new l(nextInt2));
                        aEg.playerController.bCP = nextInt2;
                        aEg.getNetHandler().addToSendQueue(new l(bCP2));
                        aEg.playerController.bCP = bCP2;
                        nQ = false;
                     }
                  }

                  this.jE = null;
               }

               if (this.jE != null) {
                  if (!this.espMode.wo().getName().equals("None")) {
                     this.ei();
                     List var2;
                     if (this.mode.wo().getName().equals("Single")) {
                        var2 = new ArrayList();
                        if (this.jE != null) {
                           var2.add(this.jE);
                        }
                     } else {
                        var2 = this.nV;
                     }

                     var168 = var2.iterator();

                     while (((Iterator)var168).hasNext()) {
                        var136 = (EntityLivingBase)((Iterator)var168).next();
                        var144 = new com.alan.clients.component.impl.render.espcomponent.api.ESPColor(this.rz().rA(), this.rz().rB(), this.rz().rA());
                        if (!this.coloredSigmaRing.wo()) {
                           var144 = new com.alan.clients.component.impl.render.espcomponent.api.ESPColor(Color.WHITE, Color.WHITE, Color.WHITE);
                        }

                        var151 = this.espMode.wo().getName();
                        int var117_hi = -1;
                        switch (((String)var151).hashCode()) {
                           case 66987:
                              if (((String)var151).equals("Box")) {
                                 var117_hi = 1;
                              }
                              break;
                           case 2547280:
                              if (((String)var151).equals("Ring")) {
                                 var117_hi = 0;
                              }
                        }

                        switch (var117_hi) {
                           case 0:
                              ESPComponent.a(new ct((EntityLivingBase)var136, (com.alan.clients.component.impl.render.espcomponent.api.ESPColor)var144));
                              break;
                           case 1:
                              var160 = this.boxMode.wo().getName();
                              int var152_hi = -1;
                              switch (((String)var160).hashCode()) {
                                 case 2201263:
                                    if (((String)var160).equals("Full")) {
                                       var152_hi = 0;
                                    }
                                    break;
                                 case 63058813:
                                    if (((String)var160).equals("Above")) {
                                       var152_hi = 1;
                                    }
                              }

                              switch (var152_hi) {
                                 case 0:
                                    ESPComponent.a(new cp((EntityLivingBase)var136, (com.alan.clients.component.impl.render.espcomponent.api.ESPColor)var144));
                                    break;
                                 case 1:
                                    ESPComponent.a(new co((EntityLivingBase)var136, (com.alan.clients.component.impl.render.espcomponent.api.ESPColor)var144));
                              }
                        }
                     }
                  }
               }
            }
         }
      };
      this.onWorldChange = var1x -> {
         this.oB = -1;
         this.oC = -1;
         this.oH = -1;
         this.oJ = false;
         this.eW();
         if (this.autoDisable.wo()) {
            this.toggle();
         }
      };
      this.oR = var1x -> {
         Object var220 = null;
         Object var221 = null;
         Object var249 = null;
         this.oD = false;
         this.oJ = false;
         if (!this.eG()) {
            if (this.oF) {
               this.eL();
            } else {
               this.eH();
               this.eI();
               if (aEg.thePlayer.isSprinting() || this.jE == null || !this.newUniversalKeepSprint.wo()) {
                  this.mC = false;
               }

               if (!RotationComponent.bK()) {
                  if (this.my > 0) {
                     this.my--;
                  }

                  mB = this.my > 0;
                  if (this.lV.wo().getName().equals("Watchdog 1.12")
                     && !ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_13)
                     && LastConnectionComponent.ip != null
                     && LastConnectionComponent.ip.contains("hypixel")
                     && aEg.thePlayer.ticksExisted % 5 == 0) {
                     afi.b("USE THIS AUTOBLOCK CONFIG ON 1.20 NOT 1.8 instead use Watchdog 1.8 Autoblock on 1.8");
                  }

                  if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_13)
                     && LastConnectionComponent.ip != null
                     && LastConnectionComponent.ip.contains("hypixel")
                     && aEg.thePlayer.ticksExisted % 5 == 0
                     && this.lV.wo().getName().equals("Watchdog 1.8")) {
                     afi.b("USE THIS AUTOBLOCK CONFIG ON 1.8 NOT 1.20 instead use Watchdog 1.12 Autoblock on 1.20");
                  }

                  if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_13)
                     && LastConnectionComponent.ip != null
                     && LastConnectionComponent.ip.contains("hypixel")
                     && aEg.thePlayer.ticksExisted % 5 == 0
                     && this.lV.wo().getName().equals("Watchdog")) {
                     afi.b("USE THIS AUTOBLOCK CONFIG ON 1.8 NOT 1.20 instead use Watchdog 1.12 Autoblock on 1.20");
                  }

                  if (this.rotationMode.wo().getName().equals("Grim") && aEg.thePlayer.ticksExisted % 20 == 0) {
                     int newerThan2 = ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_17) && !ViaLoadingBase.getInstance().getTargetVersion().newerThan(ProtocolVersion.v1_20_5) ? 1 : 0;
                     if (newerThan2 == 0) {
                        afi.b("OnTick rotation only works correctly on versions 1.17-1.20.6. Please switch to a version in that range.");
                     }
                  }

                  aEg.entityRenderer.getMouseOver(1.0F);
                  nR = !BadPacketsComponent.bad(false, false, false, true, true);
                  if (aEg.thePlayer.getHealth() <= 0.0 && this.autoDisable.wo()) {
                     this.toggle();
                  }

                  if (!this.e(Scaffold.class).isEnabled() || this.attackWhilstScaffolding.wo()) {
                     if (Breaker.abT && this.e(Breaker.class).isEnabled() && !this.e(Breaker.class).attackWhileBreaking.wo()) {
                        this.jE = null;
                        this.ek();
                     } else if (!this.eY()) {
                        this.jE = null;
                        this.ek();
                     } else {
                        this.nW = Math.max(Math.min(this.nW, this.nW - 2), 0);
                        var220 = this.e(Manager.class);
                        var249 = this.e(OldManager.class);
                        var221 = this.e(Stealer.class);
                        int jJ2 = (Manager)var220 != null && ((Manager)var220).isEnabled() && ((Manager)var220).jJ() ? 1 : 0;
                        int jJ3 = (OldManager)var249 != null && ((OldManager)var249).isEnabled() && ((OldManager)var249).jJ() ? 1 : 0;
                        int enabled = (Stealer)var221 != null && ((Stealer)var221).isEnabled() && aEg.currentScreen instanceof GuiChest ? 1 : 0;
                        int notFlag = !GUIDetectionComponent.inGUI() && !aEg.gameSettings.cgI.isKeyDown() && !BadPacketsComponent.a(true, false, false, false, true, false) && jJ3 == 0 && enabled == 0 ? 0 : 1;
                        if (aEg.thePlayer.ticksExisted % 20 == 0 && !this.lV.wo().getName().equals("Watchdog 1.8")) {
                           this.nX = (int)(this.rotationRange.wo().doubleValue() + Math.random() * 0.5);
                        }

                        if (aEg.thePlayer.ticksExisted % 2 == 0 && this.lV.wo().getName().equals("Watchdog 1.8") && notFlag == 0) {
                           this.nX = (int)(5.0 + Math.random() * 0.5);
                        }

                        if (notFlag != 0 && this.lV.wo().getName().equals("Watchdog 1.8")) {
                           this.nX = (int)(this.rotationRange.wo().doubleValue() + Math.random() * 0.5);
                        }

                        if (!GUIDetectionComponent.inGUI()) {
                           this.ei();
                           if (this.nV.isEmpty()) {
                              this.jE = null;
                              this.eW();
                              this.ek();
                           } else {
                              this.jE = this.nV.get(0);
                              if (this.jE != null && !aEg.thePlayer.isDead) {
                                 if (this.eX()) {
                                    this.ex();
                                 } else {
                                    this.ek();
                                 }

                                 this.eS();
                                 this.el();
                                 this.oM = this.oL
                                    .entrySet()
                                    .stream()
                                    .filter(var0 -> aEg.thePlayer.ticksExisted - var0.getValue() <= 5)
                                    .map(Entry::getKey)
                                    .map(EntityLivingBase.class::cast)
                                    .collect(Collectors.toList());
                                 if (this.mode.wo().getName().equals("Single") && this.jE != null) {
                                    this.oM.clear();
                                    this.oM.add(this.jE);
                                 }
                              } else {
                                 this.eW();
                                 this.ek();
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      };
      this.oS = var1x -> {
         Object var35 = null;
         if (!this.oF && !this.oJ) {
            if (this.jE != null && !aEg.thePlayer.isDead) {
               if (this.es()) {
                  this.my = 2;
               }

               var35 = this.lV.wo().getName();
               int var29_hi = -1;
               switch (((String)var35).hashCode()) {
                  case -1336727224:
                     if (((String)var35).equals("Watchdog 1.8")) {
                        var29_hi = 0;
                     }
                  default:
                     switch (var29_hi) {
                        case 0:
                        default:
                           this.doAttack(this.nV);
                           if (this.eX()) {
                              this.ew();
                           }
                     }
               }
            }
         }
      };
      this.onMouseOver = var1x -> var1x.setRange(var1x.dA() + this.range.wo().doubleValue() - 3.0);
      this.onPostMotion = var1x -> {
         if (!this.oJ) {
            if (this.jE != null && this.eX()) {
               this.eM();
            }
         }
      };
      this.onRenderItem = var1x -> {
         if (this.jE != null && !this.lV.wo().getName().equals("None") && this.eX()) {
            var1x.setEnumAction(EnumAction.BLOCK);
            var1x.setUseItem(true);
         }
      };
      this.hV = 0;
      this.onPacketSend = var1x -> {
         Object var16 = null;
         if (!var1x.isCancelled()) {
            var16 = var1x.dq();
            if ((Packet)var16 instanceof m) {
               cK = true;
            } else if ((Packet)var16 instanceof C03PacketPlayer) {
               cK = false;
            }

            this.packetBlock(var1x);
         }
      };
      this.oX = var1x -> {
         Object var41 = null;
         if (this.jE != null) {
            SlotComponent var10000 = this.d(SlotComponent.class);
            if (SlotComponent.getItemStack() != null) {
               var10000 = this.d(SlotComponent.class);
               if (SlotComponent.getItemStack().getItem() instanceof ItemSword) {
                  var41 = this.lV.wo().getName();
                  int var39_hi = -1;
                  switch (((String)var41).hashCode()) {
                     case 2182005:
                        if (((String)var41).equals("Fake")) {
                           var39_hi = 0;
                        }
                        break;
                     case 2433880:
                        if (((String)var41).equals("None")) {
                           var39_hi = 1;
                        }
                        break;
                     case 73298841:
                        if (((String)var41).equals("Legit")) {
                           var39_hi = 2;
                        }
                  }

                  switch (var39_hi) {
                     case 0:
                     case 1:
                        if (!this.preventServersideBlocking.wo()) {
                           return;
                        }

                        var10000 = this.d(SlotComponent.class);
                        if (SlotComponent.getItemStack() == null) {
                           return;
                        }

                        var10000 = this.d(SlotComponent.class);
                        if (!(SlotComponent.getItemStack().getItem() instanceof ItemSword)) {
                           return;
                        }

                        var1x.setCancelled();
                     case 2:
                        break;
                     default:
                        var1x.setCancelled();
                  }

                  return;
               }
            }
         }
      };
      this.onClick = var1x -> {
         if (this.lV.wo().getName().equals("Watchdog") && this.jE != null && this.nY == 2) {
            var1x.setCancelled();
         }
      };
      this.onJump = var1x -> {
         if (this.newUniversalKeepSprint.wo() && this.mC && !aEg.thePlayer.isSprinting()) {
            var1x.setCancelled();
         } else {
            if (!this.lV.wo().getName().equals("Watchdog") || this.rightClickOnly.wo() && !aEg.gameSettings.cgI.isKeyDown()) {
               if (this.oldPredictionKeepSprint.wo() && aEg.thePlayer.ticksExisted % 2 == 0 && mB && this.jE != null && PlayerUtil.v(this.jE) <= 3.0 + MoveUtil.speed()) {
                  var1x.setCancelled();
               }
            } else if (!this.newYouNeedThisToggledOnCurreFake.wo() && this.oldPredictionKeepSprint.wo() && this.nY == 2 && mB && this.jE != null && PlayerUtil.v(this.jE) <= 3.0 + MoveUtil.speed()) {
               var1x.setCancelled();
            }
         }
      };
      this.onHitSlowDown = var1x -> {
         if (this.lV.wo().getName().equals("Watchdog")
            && this.jE != null
            && PlayerUtil.v(this.jE) <= 3.0 + MoveUtil.speed()
            && this.oldPredictionKeepSprint.wo()
            && this.newYouNeedThisToggledOnCurreFake.wo()
            && aEg.thePlayer.ae >= 7) {
            var1x.setSlowDown(1.0);
         }
      };
      this.pb = var1x -> {
         if (this.lV.wo().getName().equals("Watchdog")
            && this.jE != null
            && PlayerUtil.v(this.jE) <= 3.0 + MoveUtil.speed()
            && this.oldPredictionKeepSprint.wo()
            && this.newYouNeedThisToggledOnCurreFake.wo()
            && aEg.thePlayer.ae > 7) {
            aEg.thePlayer.setSprinting(false);
         }

         if (!this.lV.wo().getName().equals("Watchdog") || this.rightClickOnly.wo() && !aEg.gameSettings.cgI.isKeyDown()) {
            if (this.oldPredictionKeepSprint.wo()
               && aEg.thePlayer.ticksExisted % 2 == 0
               && mB
               && this.jE != null
               && PlayerUtil.v(this.jE) <= 3.0 + MoveUtil.speed()
               && (aEg.thePlayer.ae >= 7 || this.eZ())) {
               aEg.thePlayer.setSprinting(false);
            }
         } else if (!this.newYouNeedThisToggledOnCurreFake.wo()
            && this.oldPredictionKeepSprint.wo()
            && this.nY > 1
            && mB
            && this.jE != null
            && PlayerUtil.v(this.jE) <= 3.0 + MoveUtil.speed()
            && (aEg.thePlayer.ae >= 7 || this.eZ())) {
            aEg.thePlayer.setSprinting(false);
         }
      };
      this.onSlowDown = var1x -> {
         Object var72 = null;
         var72 = this.lV.wo().getName();
         int var66_hi = -1;
         switch (((String)var72).hashCode()) {
            case -1885322919:
               if (((String)var72).equals("Dual Sword")) {
                  var66_hi = 2;
               }
               break;
            case -1336727224:
               if (((String)var72).equals("Watchdog 1.8")) {
                  var66_hi = 3;
               }
               break;
            case 73298841:
               if (((String)var72).equals("Legit")) {
                  var66_hi = 0;
               }
               break;
            case 609795629:
               if (((String)var72).equals("Watchdog")) {
                  var66_hi = 1;
               }
               break;
            case 1511128849:
               if (((String)var72).equals("Watchdog 1.12")) {
                  var66_hi = 4;
               }
         }

         switch (var66_hi) {
            case 0:
            default:
               break;
            case 1:
               if (this.jE != null && aEg.thePlayer.getHeldItem() != null && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
                  var1x.setCancelled();
               }
               break;
            case 2:
               if (this.jE != null && aEg.thePlayer.getHeldItem() != null && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
                  var1x.setCancelled();
               }
               break;
            case 3:
               if (this.jE != null && aEg.thePlayer.getHeldItem() != null && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
                  var1x.setCancelled();
               }
               break;
            case 4:
               if (this.jE != null && aEg.thePlayer.getHeldItem() != null && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
                  var1x.setCancelled();
               }
         }

         if (this.blockSlowdown.wo() && nQ && this.eX()) {
            var1x.setCancelled(false);
            var1x.k(true);
         }
      };
      this.onRender2D = var1x -> {
         float var121 = 0.0F;
         double var122 = 0.0;
         Object var126 = null;
         Object var127 = null;
         double var132 = 0.0;
         float var135 = 0.0F;
         Object var138 = null;
         Object var140 = null;
         Object var145 = null;
         Object var146 = null;
         float var147 = 0.0F;
         float var149 = 0.0F;
         double var150 = 0.0;
         Object var152 = null;
         float var157 = 0.0F;
         float var161 = 0.0F;
         double var163 = 0.0;
         double var165 = 0.0;
         double var168 = 0.0;
         Object var171 = null;
         double var172 = 0.0;
         float var176 = 0.0F;
         double var179 = 0.0;
         double var181 = 0.0;
         double var183 = 0.0;
         double var186 = 0.0;
         Object var189 = null;
         if (this.showFOVCircle.wo() && !(this.fOV.wo().doubleValue() >= 360.0) || this.showMovementArc.wo()) {
            var181 = this.fOV.wo().doubleValue();
            int scaledWidth = var1x.getScaledResolution().getScaledWidth();
            int scaledHeight = var1x.getScaledResolution().getScaledHeight();
            var149 = scaledWidth / 2.0F;
            var121 = scaledHeight / 2.0F;
            var127 = this.jE;
            var183 = 0.0;
            int var143_hi = 0;
            if ((EntityLivingBase)var127 == null) {
               var145 = Double.MAX_VALUE;
               var152 = this.range.wo().doubleValue() + 3.0;
               var189 = aEg.theWorld.loadedEntityList.iterator();

               while (((Iterator)var189).hasNext()) {
                  var126 = (Entity)((Iterator)var189).next();
                  if ((Entity)var126 instanceof EntityLivingBase && (Entity)var126 != aEg.thePlayer) {
                     var138 = (EntityLivingBase)((Entity)var126);
                     if (!((EntityLivingBase)var138).isDead && (!((EntityLivingBase)var138).isInvisible() || this.invisibles.wo())) {
                        var140 = (double)aEg.thePlayer.getDistanceToEntity((EntityLivingBase)var138);
                        if ((Double)var140 < (Double)var145 && (Double)var140 <= (Double)var152) {
                           var145 = (Double)var140;
                           var127 = (EntityLivingBase)var138;
                        }
                     }
                  }
               }
            }

            if ((EntityLivingBase)var127 != null) {
               var145 = RotationUtil.y((EntityLivingBase)var127);
               var157 = MathHelper.wrapAngleTo180_float(((Vector2f)var145).x - aEg.thePlayer.pl);
               var183 = var157;
               if (this.jE != null && !this.nV.isEmpty()) {
                  if (var181 >= 360.0) {
                     var143_hi = 1;
                  } else {
                     var143_hi = Math.abs(var157) <= var181 / 2.0 ? 1 : 0;
                  }
               }
            }

            var145 = var143_hi != 0 ? 16.0 : 10.0;
            this.oN.Q((Double)var145);
            var152 = (float)this.oN.sG();
            var163 = (EntityLivingBase)var127 != null ? var183 : 0.0;
            this.oO.Q(var163);
            var126 = this.oO.sG();
            GL11.glPushMatrix();
            GL11.glDisable(3553);
            GL11.glEnable(2848);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GL11.glLineWidth(1.5F);
            if (this.showFOVCircle.wo() && var181 < 360.0) {
               var140 = var181 / 2.0;
               var186 = 270.0 + (Double)var126;
               var132 = var186 - (Double)var140;
               var179 = var186 + (Double)var140;
               GL11.glBegin(3);
               var146 = this.rz().rA();
               var171 = var143_hi != 0 ? 1.0F : 0.5F;
               GL11.glColor4f(((Color)var146).getRed() / 255.0F, ((Color)var146).getGreen() / 255.0F, ((Color)var146).getBlue() / 255.0F, (Float)var171);

               for (double var217 = var132; var217 <= var179; var217 += 2.0) {
                  var172 = Math.toRadians(var217);
                  var176 = var149 + (float)(Math.cos(var172) * ((Float)var152).floatValue());
                  var161 = var121 + (float)(Math.sin(var172) * ((Float)var152).floatValue());
                  GL11.glVertex2f(var176, var161);
               }

               GL11.glEnd();
            }

            if (this.showMovementArc.wo() && this.movementCorrection.wo() != MovementFix.OFF && this.jE != null && RotationComponent.fk != null) {
               var140 = RotationComponent.fk.x;
               var150 = MathHelper.wrapAngleTo180_float((Float)var140 - aEg.thePlayer.pl);
               var122 = 270.0 + var150 - 45.0;
               var165 = 270.0 + var150 + 45.0;
               var147 = (Float)var152 * 0.75F;
               GL11.glBegin(3);
               var146 = this.rz().rB();
               GL11.glColor4f(((Color)var146).getRed() / 255.0F, ((Color)var146).getGreen() / 255.0F, ((Color)var146).getBlue() / 255.0F, 0.6F);

               for (Double var223 = var122; var223 <= var165; var223 = var223 + 2.0) {
                  var168 = Math.toRadians(var223);
                  var135 = var149 + (float)(Math.cos(var168) * var147);
                  var176 = var121 + (float)(Math.sin(var168) * var147);
                  GL11.glVertex2f(var135, var176);
               }

               GL11.glEnd();
            }

            GlStateManager.disableBlend();
            GL11.glDisable(2848);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
            GlStateManager.resetColor();
         }
      };
      MovementFix[] var1 = MovementFix.values();
      var822 = var1.length;

      for (int i2 = 0; i2 < var822; i2++) {
         MovementFix var4 = var1[i2];
         this.movementCorrection.add(var4);
      }

      this.movementCorrection.setDefault(MovementFix.OFF);
   }

   public boolean eK() {
      Object var55 = null;
      var55 = this.eD();
      if (((int[])var55)[1] == -1) {
         return false;
      }
      if (this.oB != ((int[])var55)[0] && this.oB != ((int[])var55)[1]) {
         SlotComponent var10000 = this.d(SlotComponent.class);
         int bQ2 = SlotComponent.bQ();
         if (bQ2 != ((int[])var55)[0] && bQ2 != ((int[])var55)[1]) {
            return false;
         }

         this.oB = bQ2;
      }

      SlotComponent var59 = this.d(SlotComponent.class);
      if (SlotComponent.bQ() != this.oB) {
         SlotComponent.b(this.oB, false);
      }

      return true;
   }

   public float a(EntityLivingBase var1, float var2) {
      double var23 = 0.0;
      Object var25 = null;
      double var26 = 0.0;
      double var28 = 0.0;
      Object var30 = null;
      double var31 = 0.0;
      double var33 = 0.0;
      double var35 = 0.0;
      if (var1 == null) {
         return aEg.thePlayer.rotationPitch;
      }
      var25 = aEg.thePlayer.getPositionEyes(1.0F);
      var30 = new Vec3(var1.posX, var1.posY + var1.getEyeHeight() * 0.9, var1.posZ);
      var28 = ((Vec3)var30).xCoord - ((Vec3)var25).xCoord;
      var33 = ((Vec3)var30).yCoord - ((Vec3)var25).yCoord;
      var35 = ((Vec3)var30).zCoord - ((Vec3)var25).zCoord;
      var26 = Math.toRadians(var2);
      var31 = -var28 * Math.sin(var26) + var35 * Math.cos(var26);
      var23 = Math.toDegrees(Math.atan2(-var33, var31));
      var23 = Math.max(-90.0, Math.min(90.0, var23));
      return (float)var23;
   }

   public long a(double var1, double var3, long var5, long var7) {
      double var13 = 0.0;
      var13 = var1;
      if (var3 > 1.0E-4) {
         var13 = var1 + this.od.nextGaussian() * var3;
      }

      if (var13 < var5) {
         var13 = var5;
      }

      if (var13 > var7) {
         var13 = var7;
      }

      return Math.round(var13);
   }

   public void b(gu var1) {
      if (var1 != null && aEg.thePlayer != null) {
         this.eU();
         float var10000 = aEg.thePlayer.pl + MathHelper.wrapAngleTo180_float(var1.pg - aEg.thePlayer.pl);
      }
   }

   public void a(Vector2f var1, Vector2f var2) {
      float var35 = 0.0F;
      float var36 = 0.0F;
      float var37 = 0.0F;
      float var38 = 0.0F;
      float var39 = 0.0F;
      float var40 = 0.0F;
      float var41 = 0.0F;
      float var42 = 0.0F;
      float var45 = 0.0F;
      float var47 = 0.0F;
      float var49 = 0.0F;
      float var50 = 0.0F;
      float var51 = 0.0F;
      float var52 = 0.0F;
      float var53 = 0.0F;
      float var54 = 0.0F;
      var37 = this.advancedOvershootChance.wo().floatValue();
      if (!(var37 <= 0.0F)) {
         var52 = MathHelper.clamp_float(this.advancedAccuracy.wo().floatValue() / 100.0F, 0.4F, 1.0F);
         var40 = var37 * (1.15F - var52 * 0.35F);
         var51 = MathHelper.wrapAngleTo180_float(var2.x - var1.x);
         var39 = var2.y - var1.y;
         var42 = (float)Math.hypot(var51, var39);
         if (!(var42 < 9.0F) && !(this.od.nextFloat() * 100.0F > var40)) {
            var45 = this.advancedOvershootScale.wo().floatValue();
            var54 = Math.min(this.advancedOvershootMax.wo().floatValue(), Math.max(1.5F, var42 * var45));
            var54 *= 0.9F + (1.0F - var52) * 0.35F;
            var47 = Math.max(0.001F, var42);
            var49 = var51 / var47;
            var36 = var39 / var47;
            var53 = -var36;
            var50 = var54 + Math.abs(this.b(var54 * 0.25F, var54));
            var41 = this.b(var54 * 0.35F, var54);
            var38 = var2.x + var49 * var50 + var53 * var41;
            var35 = MathHelper.clamp_float(var2.y + var36 * var50 + var49 * var41 * 0.65F, -89.0F, 89.0F);
            this.on = new Vector2f(var38, var35);
            this.oo = 8 + this.od.nextInt(6);
         }
      }
   }

   public boolean ey() {
      return false;
   }

   public boolean ez() {
      if (aEg.thePlayer == null || SlotComponent.dj) {
         return false;
      } else if (this.oA == aEg.thePlayer.ticksExisted) {
         return false;
      }
      SlotComponent var10000 = this.d(SlotComponent.class);
      int bQ2 = SlotComponent.bQ();
      int nextInt2 = ThreadLocalRandom.current().nextInt(9);

      while (nextInt2 == bQ2) {
         nextInt2 = ThreadLocalRandom.current().nextInt(9);
      }

      BlinkComponent.dispatch();
      if (ahm.vn()) {
         if (!this.blockSlowdown.wo()) {
            SlotComponent.setSlot(nextInt2);
            SlotComponent.setSlot(bQ2);
         }

         this.p(true);
      } else {
         this.p(true);
         if (!this.blockSlowdown.wo()) {
            SlotComponent.setSlot(nextInt2);
            SlotComponent.setSlot(bQ2);
         }
      }

      this.oA = aEg.thePlayer.ticksExisted;
      return true;
   }

   public boolean eC() {
      return this.lV.wo().getName().equals("Watchdog") || this.eA();
   }

   public void ek() {
      Object var50 = null;
      var50 = this.lV.wo().getName();
      int var43_hi = -1;
      switch (((String)var50).hashCode()) {
         case -1885322919:
            if (((String)var50).equals("Dual Sword")) {
               var43_hi = 2;
            }
            break;
         case 609795629:
            if (((String)var50).equals("Watchdog")) {
               var43_hi = 1;
            }
            break;
         case 1594433067:
            if (((String)var50).equals("Universal")) {
               var43_hi = 0;
            }
      }

      switch (var43_hi) {
         case 0:
            this.nY = -1;
         case 1:
         default:
            break;
         case 2:
            this.q(true);
      }
   }

   public void b(MovingObjectPosition var1) {
      if (var1 != null && var1.typeOfHit == MovingObjectType.ENTITY) {
         aEg.objectMouseOver = var1;
         aEg.pointedEntity = var1.entityHit;
      }
   }

   public double a(AxisAlignedBB var1, int var2) {
      Object var125 = null;
      Object var133 = null;
      double var140 = 0.0;
      Object var185 = null;
      int floor_double2 = MathHelper.floor_double(var1.minX + 1.0E-4);
      int floor_double3 = MathHelper.floor_double(var1.maxX - 1.0E-4);
      int floor_double4 = MathHelper.floor_double(var1.minZ + 1.0E-4);
      int floor_double5 = MathHelper.floor_double(var1.maxZ - 1.0E-4);
      int floor_double6 = MathHelper.floor_double(var1.minY) - 1;
      int max2 = Math.max(0, floor_double6 - var2);
      double var11 = Double.longBitsToDouble(9218868437227405312L);

      for (int i = floor_double2; i <= floor_double3; i++) {
         for (int j = floor_double4; j <= floor_double5; j++) {
            int var154_lo = 0;

            for (int k = floor_double6; k >= max2; k--) {
               var185 = new BlockPos(i, k, j);
               var133 = aEg.theWorld.getBlockState((BlockPos)var185);
               var125 = ((IBlockState)var133).getBlock().getCollisionBoundingBox(aEg.theWorld, (BlockPos)var185, (IBlockState)var133);
               if ((AxisAlignedBB)var125 != null) {
                  var140 = Math.max(0.0, var1.minY - ((AxisAlignedBB)var125).maxY);
                  var11 = Math.min(var11, var140);
                  var154_lo = 1;
                  break;
               }
            }

            if (var154_lo == 0) {
               return Double.longBitsToDouble(6568169346052289630L ^ -1957144748560059298L);
            }
         }
      }

      return var11 == Double.longBitsToDouble(9218868437227405312L) ? -1.0 : var11;
   }

   public boolean ep() {
      if (aEg.thePlayer.cqL == 1) {
         return true;
      } else if (aEg.thePlayer.isSprinting()) {
         aEg.thePlayer.setSprinting(false);
         aEg.gameSettings.cgG.setPressed(false);
         this.mC = true;
         return true;
      }
      return false;
   }

   public boolean fa() {
      Object var15 = null;
      var15 = this.e(Velocity.class);
      return (Velocity)var15 != null && ((Velocity)var15).isEnabled() && ((Velocity)var15).mode.wo().getName().equals("Grim") && GrimVelocity.tQ;
   }

   public void ex() {
      double var464 = 0.0;
      int nextInt2;
      Object var486 = null;
      var486 = this.lV.wo().getName();
      int var441_hi = -1;
      switch (((String)var486).hashCode()) {
         case -2099899231:
            if (((String)var486).equals("Intave")) {
               var441_hi = 2;
            }
            break;
         case -1885322919:
            if (((String)var486).equals("Dual Sword")) {
               var441_hi = 9;
            }
            break;
         case -1558462246:
            if (((String)var486).equals("Old Intave")) {
               var441_hi = 6;
            }
            break;
         case -1336727224:
            if (((String)var486).equals("Watchdog 1.8")) {
               var441_hi = 10;
            }
            break;
         case -786683237:
            if (((String)var486).equals("New NCP")) {
               var441_hi = 5;
            }
            break;
         case 77115:
            if (((String)var486).equals("NCP")) {
               var441_hi = 1;
            }
            break;
         case 2228079:
            if (((String)var486).equals("Grim")) {
               var441_hi = 3;
            }
            break;
         case 73298841:
            if (((String)var486).equals("Legit")) {
               var441_hi = 0;
            }
            break;
         case 609795629:
            if (((String)var486).equals("Watchdog")) {
               var441_hi = 8;
            }
            break;
         case 1511128849:
            if (((String)var486).equals("Watchdog 1.12")) {
               var441_hi = 4;
            }
            break;
         case 1594433067:
            if (((String)var486).equals("Universal")) {
               var441_hi = 7;
            }
      }

      switch (var441_hi) {
         case 0:
            var464 = PlayerUtil.v(this.jE);
            aEg.gameSettings.cgI.setPressed(var464 < 3.0 && this.oa <= 5 && aEg.thePlayer.ae >= 5);
            this.nY++;
            if (aEg.gameSettings.cgI.isPressed() || aEg.thePlayer.isUsingItem()) {
               this.nY = 0;
            }

            nR = this.nY >= 2;
            break;
         case 1:
         case 2:
            nR = true;
            break;
         case 3:
            SlotComponent var536 = this.d(SlotComponent.class);
            PacketUtil.l(new l(SlotComponent.bQ() % 8 + 1));
            var536 = this.d(SlotComponent.class);
            PacketUtil.l(new l(SlotComponent.bQ()));
            this.block(false, false);
            break;
         case 4:
            int bCP2 = aEg.playerController.bCP;

            do {
               nextInt2 = ThreadLocalRandom.current().nextInt(8);
            } while (bCP2 == nextInt2);

            if (nQ && !SlotComponent.dj) {
               aEg.getNetHandler().addToSendQueue(new l(nextInt2));
               aEg.playerController.bCP = nextInt2;
               aEg.getNetHandler().addToSendQueue(new l(bCP2));
               aEg.playerController.bCP = bCP2;
               nQ = false;
            }

            if (!BadPacketsComponent.a(false, false, false, false, true, true)) {
               nR = true;
            } else {
               nR = false;
            }
            break;
         case 5:
            if (nQ) {
               SlotComponent var534 = this.d(SlotComponent.class);
               PacketUtil.l(new l(SlotComponent.bQ() % 8 + 1));
               var534 = this.d(SlotComponent.class);
               PacketUtil.l(new l(SlotComponent.bQ()));
               nQ = false;
            }
            break;
         case 6:
            if (aEg.thePlayer.isUsingItem()) {
               SlotComponent var10002 = this.d(SlotComponent.class);
               PacketUtil.l(new l(SlotComponent.bQ() % 8 + 1));
               var10002 = this.d(SlotComponent.class);
               PacketUtil.l(new l(SlotComponent.bQ()));
            }
            break;
         case 7:
            if (aEg.playerController.curBlockDamageMP != 0.0F && aEg.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
               this.nY = 0;
               return;
            }

            this.nY++;
            if (this.nY > 5) {
               this.nY = 2;
            }

            BlinkComponent.a(99999, false, false, false, false, true);
            switch (this.nY) {
               case 2:
                  this.block(false, true);
                  return;
               case 3:
                  this.p(false);
                  return;
               default:
                  return;
            }
         case 8:
            if (aEg.playerController.curBlockDamageMP != 0.0F && aEg.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
               this.nY = 0;
            }

            this.nY++;
            if (this.nY >= (this.nU ? 3 : 4)) {
               this.nY = 1;
            }

            switch (this.nY) {
               case 1:
                  this.nU = !this.newYouNeedThisToggledOnCurreFake.wo();
                  if (!nQ) {
                     ;
                  }

                  SlotComponent var532 = this.d(SlotComponent.class);
                  int bQ2 = SlotComponent.bQ();
                  int nextInt3 = ThreadLocalRandom.current().nextInt(9);

                  while (nextInt3 == bQ2) {
                     nextInt3 = ThreadLocalRandom.current().nextInt(9);
                  }

                  if (ahm.vn() && Math.random() > 0.5 && !this.blockSlowdown.wo() && !this.nU) {
                     SlotComponent.setSlot(nextInt3);
                     SlotComponent.setSlot(bQ2);
                     this.p(false);
                  }

                  BlinkComponent.blink();
                  return;
               case 2:
                  if (!ahm.vn()) {
                     this.p(false);
                  }

                  if (!nQ) {
                     ;
                  }

                  if (this.nU) {
                     SlotComponent var531 = this.d(SlotComponent.class);
                     int bQ3 = SlotComponent.bQ();
                     int nextInt4 = ThreadLocalRandom.current().nextInt(9);

                     while (nextInt4 == bQ3) {
                        nextInt4 = ThreadLocalRandom.current().nextInt(9);
                     }

                     nR = false;
                     BlinkComponent.bf();
                     if (!this.blockSlowdown.wo()) {
                        SlotComponent.setSlot(nextInt4);
                        SlotComponent.setSlot(bQ3);
                     }

                     this.p(true);
                     this.mz = true;
                  }

                  return;
               case 3:
                  if (!this.mz && nQ) {
                     ;
                  }

                  if (!this.nU) {
                     SlotComponent var10000 = this.d(SlotComponent.class);
                     int bQ4 = SlotComponent.bQ();
                     int nextInt5 = ThreadLocalRandom.current().nextInt(9);

                     while (nextInt5 == bQ4) {
                        nextInt5 = ThreadLocalRandom.current().nextInt(9);
                     }

                     nR = false;
                     BlinkComponent.bf();
                     if (ahm.vn()) {
                        if (!this.blockSlowdown.wo()) {
                           SlotComponent.setSlot(nextInt5);
                           SlotComponent.setSlot(bQ4);
                        }

                        this.p(true);
                     } else {
                        this.p(true);
                        if (!this.blockSlowdown.wo()) {
                           SlotComponent.setSlot(nextInt5);
                           SlotComponent.setSlot(bQ4);
                        }
                     }

                     this.mz = true;
                  }

                  return;
               default:
                  return;
            }
         case 9:
            nR = this.eK() && !BadPacketsComponent.bad(false, false, false, true, true) && !ahm.vn() || this.eK() && !BadPacketsComponent.bad(false, false, false, true, true) && Math.random() < 0.6;
            break;
         case 10:
            BlinkComponent.bf();
            this.block(false, true);
      }
   }

   public int[] eD() {
      Object var61 = null;
      Object var68 = null;
      var68 = new int[]{-1, -1};
      if (aEg.thePlayer == null) {
         return (int[])var68;
      }
      int var69_hi = 0;

      for (int i = 0; i < 9 && var69_hi < ((int[])var68).length; i++) {
         var61 = aEg.thePlayer.inventory.getStackInSlot(i);
         if ((ItemStack)var61 != null && ((ItemStack)var61).getItem() instanceof ItemSword) {
            int[] var10000 = (int[])var68;
            int var10001 = var69_hi;
            var69_hi++;
            var10000[var10001] = i;
         }
      }

      return (int[])var68;
   }

   public boolean es() {
      Object var36 = null;
      double var38 = 0.0;
      var36 = this.eo();
      var38 = (Double)((Tuple)var36).getSecond();
      int booleanValue2 = (int)(((Boolean)((Tuple)var36).getFirst()).booleanValue() ? 1L : 0L);
      return this.nO.T(this.nT - 50L)
         && this.jE != null
         && (this.nP.T((long)(var38 * 50.0) - 50L) || booleanValue2 != 0)
         && (!this.clickMode.wo().getName().equals("Hit Select") || this.jE.hurtTime <= PingSpoofComponent.getPing() / 50L - 1L || aEg.thePlayer.ae <= 11)
         && nR;
   }

   public void eS() {
      if (this.eV() && this.jE != null && this.eT()) {
         this.mD = this.j(this.jE);
      } else {
         this.mD = null;
      }
   }

   public int eJ() {
      Object var89 = null;
      var89 = this.eD();
      if (((int[])var89)[1] == -1) {
         return -1;
      }
      int oB2 = this.oB;
      if (oB2 != ((int[])var89)[0] && oB2 != ((int[])var89)[1]) {
         SlotComponent var10000 = this.d(SlotComponent.class);
         oB2 = SlotComponent.bQ();
      }

      if (oB2 != ((int[])var89)[0] && oB2 != ((int[])var89)[1]) {
         return -1;
      }
      return oB2 == ((int[])var89)[0] ? ((int[])var89)[1] : ((int[])var89)[0];
   }

   @Override
   public void onDisable() {
      int nextInt2;
      this.oF = false;
      this.oH = -1;
      this.oJ = false;
      this.mz = false;
      this.nN.forEach(PacketUtil::m);
      this.nN.clear();
      bc.dispatch();
      this.jE = null;
      this.mD = null;
      this.mE = "";
      this.mF = -1;
      this.eW();
      if (this.lV.wo().getName().equals("Watchdog 1.8") && nQ) {
         afi.c("for Autoblock to work best keep Killaura enabled unless it's necessary to turn off");
      }

      if (this.eA()) {
         this.q(true);
      } else if (this.lV.wo().getName().equals("Watchdog 1.12")) {
         if (!BadPacketsComponent.aW()) {
            int bCP2 = aEg.playerController.bCP;

            do {
               nextInt2 = ThreadLocalRandom.current().nextInt(8);
            } while (bCP2 == nextInt2);

            if (nQ && !SlotComponent.dj) {
               aEg.getNetHandler().addToSendQueue(new l(nextInt2));
               aEg.playerController.bCP = nextInt2;
               aEg.getNetHandler().addToSendQueue(new l(bCP2));
               aEg.playerController.bCP = bCP2;
               nQ = false;
            }
         }
      } else if (this.lV.wo().getName().equals("Watchdog") && !this.mz && !SlotComponent.dj && nQ) {
         this.ez();
      } else if (!BadPacketsComponent.aW()) {
         this.p(false);
      }

      aEg.gameSettings.cgI.setPressed(false);
      bc.cR = false;
      this.oL.clear();
      this.oM.clear();
      if (this.oG) {
         this.lV.co("Dual Sword");
         this.oG = false;
      }
   }

   public boolean a(EntityLivingBase var1, gu var2) {
      if (var1 == null || var2 == null) {
         return false;
      } else if (this.h(var1)) {
         return (-67 - 23 - -90) != 0;
      }
      return var1.hurtTime > 0 ? true : var2.pj >= 120.0 || aEg.thePlayer.getDistanceToEntity(var1) <= 2.6F;
   }

   public boolean h(EntityLivingBase var1) {
      return this.g(var1) && aEg.thePlayer.motionY < 0.0;
   }

   public float en() {
      return 0.0F;
   }

   public double j(double var1) {
      Object var115 = null;
      float var125 = 0.0F;
      var115 = this.lV.wo().getName();
      int var135_hi = -1;
      switch (((String)var115).hashCode()) {
         case -1336727224:
            if (((String)var115).equals("Watchdog 1.8")) {
               var135_hi = 2;
            }
            break;
         case 609795629:
            if (((String)var115).equals("Watchdog")) {
               var135_hi = 1;
            }
            break;
         case 1511128849:
            if (((String)var115).equals("Watchdog 1.12")) {
               var135_hi = 3;
            }
            break;
         case 1594433067:
            if (((String)var115).equals("Universal")) {
               var135_hi = 0;
            }
      }

      switch (var135_hi) {
         case 0:
            var1 = this.nY >= 4 ? -1.0 : 500.0;
            break;
         case 1:
            if (aEg.thePlayer.getHeldItem() != null && aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
               if (this.nY == 1 && Math.random() > 0.2 || this.nY == 2 || this.rightClickOnly.wo() && !aEg.gameSettings.cgI.isKeyDown()) {
                  var1 = -1.0;
                  if (this.oldPredictionKeepSprint.wo() && !this.eX()) {
                     if (aEg.thePlayer.ticksExisted % 2 != 1 && this.oldPredictionKeepSprint.wo() && aEg.thePlayer.ae >= 7) {
                        var1 = 500.0;
                     } else {
                        var1 = -1.0;
                     }
                  }
               } else {
                  var1 = 500.0;
               }
            } else if (this.jE != null && aEg.thePlayer.getHeldItem() != null) {
               var1 = 0.0;
            }
            break;
         case 2:
            if (aEg.thePlayer.ticksExisted % 2 != 1 && this.oldPredictionKeepSprint.wo() && aEg.thePlayer.ae >= 131 - 124) {
               var1 = 500.0;
            } else {
               var1 = -1.0;
            }

            if ((aEg.thePlayer.getHeldItem() == null || !(aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword))
               && this.jE != null
               && aEg.thePlayer.getHeldItem() != null) {
            }
            break;
         case 3:
            if (aEg.thePlayer.ticksExisted % 2 != 1 && this.oldPredictionKeepSprint.wo() && (aEg.thePlayer.ae >= 7 || this.eZ())) {
               var1 = 500.0;
            } else {
               var1 = -1.0;
            }

            if ((aEg.thePlayer.getHeldItem() == null || !(aEg.thePlayer.getHeldItem().getItem() instanceof ItemSword))
               && (this.jE != null && aEg.thePlayer.getHeldItem() != null || aEg.thePlayer.getHeldItem() == null)) {
               this.nY = -1;
            }
      }

      if (this.clickMode.wo().getName().equals("Normal") && this.oldPredictionKeepSprint.wo()) {
         var115 = this.c(this.jE);
         if (!this.lV.wo().getName().equals("Watchdog")) {
            if (aEg.thePlayer.ticksExisted % 2 != 1 && this.oldPredictionKeepSprint.wo() && aEg.thePlayer.ae >= 7) {
               var1 = 500.0;
            } else {
               var1 = -1.0;
               if (aEg.thePlayer.cqL < 3 && aEg.thePlayer.onGround && this.oldMovefixBoost.wo()) {
                  RotationComponent.d(false);
                  var125 = this.a(this.jE, aEg.thePlayer.pl);
                  RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, var125), 10.0, MovementFix.NORMAL);
               }
            }
         } else if (aEg.thePlayer.cqL < 3 && aEg.thePlayer.onGround && this.oldMovefixBoost.wo() && this.nY == 1 && aEg.thePlayer.ae > 7) {
            RotationComponent.d(false);
            var125 = this.a(this.jE, aEg.thePlayer.pl);
            RotationComponent.setRotations(new Vector2f(aEg.thePlayer.pl, var125), 10.0, MovementFix.NORMAL);
         }
      }

      return var1;
   }

   public long o(boolean var1) {
      double var8 = 0.0;
      double var10 = 0.0;
      var10 = this.advancedAimReaction.wo().doubleValue();
      var8 = this.advancedAimReactionJitter.wo().doubleValue();
      if (var1) {
         var10 *= 0.6;
         var8 *= 0.5;
      }

      return this.a(var10, var8, 20L, 700L);
   }

   public MovingObjectPosition a(Vector2f var1, double var2) {
      this.movingObjectPosition = null;
      if (this.subtickRaycast.wo()) {
         aEg.entityRenderer.getMouseOver(1.0F);
         if (this.a(aEg.objectMouseOver, this.jE)) {
            this.movingObjectPosition = aEg.objectMouseOver;
            return this.movingObjectPosition;
         }
      }

      this.b(var1, var2);
      if (!this.a(this.movingObjectPosition, this.jE)) {
         this.b(RotationComponent.fk, var2);
      }

      if (!this.a(this.movingObjectPosition, this.jE)) {
         this.b(RotationComponent.fm, var2);
      }

      if (this.a(this.movingObjectPosition, this.jE)) {
         this.b(this.movingObjectPosition);
         return this.movingObjectPosition;
      }
      return this.movingObjectPosition != null && this.movingObjectPosition.typeOfHit == MovingObjectType.ENTITY ? this.movingObjectPosition : null;
   }

   public boolean eT() {
      return (aEg.thePlayer == null || !aEg.thePlayer.isSprinting() && EnchantmentHelper.getKnockbackModifier(aEg.thePlayer) <= 0 ? 104 + -104 : 1) != 0;
   }

   public Vector2f eN() {
      Object var73 = null;
      double var74 = 0.0;
      double var76 = 0.0;
      Object var84 = null;
      long var86 = 0L;
      double var89 = 0.0;
      Object var95 = null;
      Object var96 = null;
      double var98 = 0.0;
      double var101 = 0.0;
      Object var103 = null;
      if (!this.eR()) {
         return this.jE == null ? new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch) : this.c(this.jE);
      } else if (this.jE == null) {
         return new Vector2f(aEg.thePlayer.pl, aEg.thePlayer.rotationPitch);
      }
      var95 = this.jE.getEntityBoundingBox();
      if ((AxisAlignedBB)var95 != null && !((AxisAlignedBB)var95).hasNaN()) {
         this.eO();
         var73 = this.eP();
         var86 = System.currentTimeMillis();
         var74 = aEg.thePlayer.getDistanceToEntity(this.jE);
         if (this.oq == null) {
            this.oq = (aka)var73;
            this.ou = var86 + this.o(false);
         } else {
            var103 = ((aka)var73).subtract(this.oq);
            var84 = 0.028 + Math.min(0.2, var74 * 0.006);
            var101 = ((aka)var103).wg();
            var76 = 0.36 + Math.min(0.85, var74 * 0.07);
            int flag = var101 > var76 ? 1 : 0;
            int flag2 = var86 >= this.ou ? 1 : 0;
            if (var101 > (Double)var84 && (flag2 != 0 || flag != 0)) {
               var89 = this.advancedAnchor.wo().doubleValue();
               var98 = Math.min(0.7, Math.max(0.08, var89 + var101 * 0.32));
               var96 = ((AxisAlignedBB)var95).expand(0.12, 0.12, 0.12);
               this.oq = this.a(this.oq.e(((aka)var103).ag(var98)), (AxisAlignedBB)var96);
               this.ou = var86 + this.o((flag) != 0);
            }
         }

         var103 = (AxisAlignedBB)var95;
         var84 = new Vec3(this.oq.x, this.oq.y, this.oq.z);
         return RotationUtil.h(RotationUtil.a(this.jE, (AxisAlignedBB)var103, (Vec3)var84, this.range.wo().doubleValue(), this.em(), this.en()));
      }
      return RotationUtil.y(this.jE);
   }

   public void b(Vector2f var1, double var2) {
      Object var10 = null;
      if (var1 != null) {
         var10 = aef.a(var1, var2, this.en(), aEg.thePlayer, this.em());
         if ((MovingObjectPosition)var10 != null && ((MovingObjectPosition)var10).typeOfHit == MovingObjectType.ENTITY) {
            this.movingObjectPosition = (MovingObjectPosition)var10;
         }
      }
   }

   public boolean a(AxisAlignedBB var1, Class<? extends Block> var2) {
      return this.a(var1, var2::isInstance);
   }

   public void eI() {
      if (!this.eA()) {
         this.oE = false;
      } else {
         if (!this.eF()) {
            if (!this.oE) {
               afi.b("Dual Sword Auto Block requires two swords in your hotbar. Get a second sword.");
               this.oE = true;
            }
         } else {
            this.oE = false;
         }
      }
   }

   public boolean b(AxisAlignedBB var1) {
      return this.a(var1, var0 -> var0 == Blocks.fire || var0 == Blocks.flowing_lava || var0 == Blocks.lava);
   }

   public gu a(EntityLivingBase var1, AxisAlignedBB var2, double var3, double var5, double var7) {
      double var47 = 0.0;
      float var49 = 0.0F;
      Object var50 = null;
      Object var56 = null;
      Object var59 = null;
      var59 = var2.contract(0.05, 0.0, 0.05);
      var50 = ((AxisAlignedBB)var59).offset(0.0, -0.35, 0.0);
      String var11 = null;
      var47 = Double.longBitsToDouble(-4503599627370496L);
      if (this.a((AxisAlignedBB)var59, Material.lava) || this.a((AxisAlignedBB)var50, Material.lava)) {
         var11 = "Lava";
         var47 = 150.0 - var7 * 8.0;
      } else if (this.a((AxisAlignedBB)var59, BlockWeb.class) || this.a((AxisAlignedBB)var50, BlockWeb.class)) {
         var11 = "Web";
         var47 = 125.0 - var7 * 7.0;
      } else if (!this.b((AxisAlignedBB)var59) && !this.b((AxisAlignedBB)var50)) {
         if (!this.a((AxisAlignedBB)var59, Blocks.cactus) && !this.a((AxisAlignedBB)var50, Blocks.cactus)) {
            var56 = this.a((AxisAlignedBB)var50, 24);
            if ((Double)var56 < 0.0) {
               var11 = ((AxisAlignedBB)var50).minY <= 8.0 ? "Void" : "Deep Drop";
               var47 = (((AxisAlignedBB)var50).minY <= 8.0 ? Double.longBitsToDouble(-9072756156650891733L ^ -4434576306040613333L) : 108.0) - var7 * 7.0;
            } else if ((Double)var56 >= 4.0) {
               var11 = "Ditch";
               var47 = 88.0 + Math.min((Double)var56, 10.0) * 3.5 - var7 * 6.0;
            } else if (this.a((AxisAlignedBB)var59, Material.water) || this.a((AxisAlignedBB)var50, Material.water)) {
               var11 = "Water";
               var47 = 58.0 + Math.max(0.0, (Double)var56) * 2.0 - var7 * 5.0;
            }
         } else {
            var11 = "Cactus";
            var47 = 96.0 - var7 * 6.0;
         }
      } else {
         var11 = "Fire";
         var47 = 100.0 - var7 * 7.0;
      }

      if (var11 == null) {
         return null;
      }
      var56 = this.d(var3, var5);
      var49 = this.a(var1, (Float)var56);
      return new gu(var1.getEntityId(), (Float)var56, var49, var7, var47, var11);
   }

   @Override
   public void setEnabled(boolean var1) {
      if (!var1 && this.isEnabled() && this.eA() && aEg.thePlayer != null && aEg.theWorld != null && aEg.getNetHandler() != null) {
         this.oF = true;
      } else {
         if (var1) {
            this.oF = false;
         }

         super.setEnabled(var1);
      }
   }

   public aka eP() {
      Object var15 = null;
      double var16 = 0.0;
      double var18 = 0.0;
      double var20 = 0.0;
      Object var23 = null;
      Object var25 = null;
      var16 = aEg.thePlayer.Ty().v(0.0, aEg.thePlayer.getEyeHeight(), 0.0).g(new aka(this.jE.posX, this.jE.posY + this.jE.height * 0.75, this.jE.posZ));
      var20 = Math.min(3.5, Math.max(0.0, this.advancedPrediction.wo().doubleValue() + var16 * 0.017));
      var23 = this.or.subtract(this.os);
      var18 = Math.max(0.35, Math.min(this.jE.height * 0.82, this.jE.height - 0.12));
      var25 = (new aka(this.jE.posX, this.jE.posY + var18, this.jE.posZ)).e(((aka)var23).ag(var20));
      var15 = this.jE.getEntityBoundingBox().expand(0.18, 0.1, 0.18);
      var25 = this.a((aka)var25, (AxisAlignedBB)var15);
      return (aka)var25;
   }

   public void ev() {
      if (this.eA() && nQ) {
         int eJ2 = this.eJ();
         if (eJ2 == -1) {
            nR = false;
         } else {
            SlotComponent.b(eJ2, false);
            this.oB = eJ2;
            nQ = false;
         }
      }
   }

   public aka a(aka var1, AxisAlignedBB var2) {
      double var13 = 0.0;
      double var15 = 0.0;
      double var17 = 0.0;
      var15 = Math.max(var2.minX, Math.min(var1.x, var2.maxX));
      var13 = Math.max(var2.minY, Math.min(var1.y, var2.maxY));
      var17 = Math.max(var2.minZ, Math.min(var1.z, var2.maxZ));
      return new aka(var15, var13, var17);
   }

   public boolean f(EntityLivingBase var1) {
      boolean var10000;
      if (this.i(var1) == null) {
         var10000 = true;
      } else {
         byte var5 = -70;
         var5 = 55;
         boolean var7 = false;
         var10000 = var7;
      }

      return var10000;
   }

   @Override
   public void onEnable() {
      this.mz = false;
      this.oB = -1;
      this.oC = -1;
      this.oD = false;
      this.oE = false;
      this.oF = false;
      this.oG = false;
      this.oH = -1;
      this.oI = aEg.gameSettings.cgI.isKeyDown();
      this.oJ = false;
      this.nW = 0;
      this.nY = 0;
      this.nT = 0L;
      this.mA = -1;
      this.mD = null;
      this.mE = "";
      this.mF = -1;
      this.eW();
      if (this.rightClickOnly.wo() && Math.random() > 0.7) {
         afi.b("hold right click to autoblock or turn off right click to autoblock");
      }
   }

   public void eL() {
      if (this.oF) {
         this.oF = false;
         this.q(true);
         super.setEnabled(false);
      }
   }

   public boolean a(AxisAlignedBB var1, Block var2) {
      return this.a(var1, var1x -> {
         boolean var10000;
         if (var1x == var2) {
            var10000 = true;
         } else {
            byte var5 = 45;
            var5 = -26;
            boolean var7 = false;
            var10000 = var7;
         }

         return var10000;
      });
   }

   public boolean eq() {
      return aEg.thePlayer.ae < 8 && !this.eZ();
   }

   public float d(double var1, double var3) {
      return (float)Math.toDegrees(Math.atan2(-var1, var3)) - 90.0F;
   }

   public boolean er() {
      Object var26 = null;
      var26 = this.eo();
      int notBooleanValue = !this.nO.T(this.nT) || !this.nP.T((long)((Double)((Tuple)var26).getSecond() * 50.0)) && !((Boolean)((Tuple)var26).getFirst()).booleanValue() ? 0 : 1;
      return notBooleanValue != 0 && aEg.thePlayer.getDistanceToEntity(this.jE) <= this.range.wo().doubleValue() + 0.5;
   }

   public void doAttack(List<EntityLivingBase> var1) {
      Object var258 = null;
      Object var259 = null;
      double var277 = 0.0;
      Object var304 = null;
      Object var316 = null;
      Object var355 = null;
      Object var361 = null;
      Object var363 = null;
      if (!this.newUniversalKeepSprint.wo() || this.jE == null || this.eq() || !this.er() || !this.ep()) {
         int eR2 = (int)(this.eR() ? 1L : 0L);
         if (eR2 == 0) {
            this.ov = Integer.MIN_VALUE;
            this.ow = false;
            this.ox = 0L;
         }

         if (!this.rotationMode.wo().getName().equals("Grim") || !this.fa()) {
            if (!this.eA() && this.velocityBoost.wo() && this.jE != null && (nR || !this.badPacketsCheck.wo())) {
               int ae2 = aEg.thePlayer.ae;
               int intValue2 = this.boostTicks.wo().intValue();
               if (ae2 < intValue2 && aEg.thePlayer.ticksExisted != this.mA) {
                  this.mA = aEg.thePlayer.ticksExisted;
                  int equals2 = this.rotationMode.wo().getName().equals("Grim") && this.nt != null ? 1 : 0;
                  if (equals2 != 0) {
                     var258 = aEg.thePlayer.pl + MathHelper.wrapAngleTo180_float(this.nt.getX() - aEg.thePlayer.pl);
                     PacketUtil.l(
                        new C06PacketPlayerPosLook(
                           aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, (Float)var258, this.nt.getY(), aEg.thePlayer.onGround
                        )
                     );
                  }

                  var258 = this.mode.wo().getName();
                  int var260_hi = -1;
                  switch (((String)var258).hashCode()) {
                     case -1818398616:
                        if (((String)var258).equals("Single")) {
                           var260_hi = 1;
                        }
                        break;
                     case -1805606060:
                        if (((String)var258).equals("Switch")) {
                           var260_hi = 0;
                        }
                        break;
                     case 718473776:
                        if (((String)var258).equals("Multiple")) {
                           var260_hi = 2;
                        }
                  }

                  switch (var260_hi) {
                     case 0:
                     case 1:
                        var259 = this.a(equals2 != 0 ? this.nt : RotationComponent.fk, this.range.wo().doubleValue());
                        if ((MovingObjectPosition)var259 != null) {
                           this.b((MovingObjectPosition)var259);
                        } else if (!this.rayCast.wo()) {
                           this.d(this.jE);
                        }

                        this.e(this.jE);
                        break;
                     case 2:
                        var363 = this.range.wo().doubleValue();
                        final double var363a = (Double)var363;
                        var1.stream().filter(var2 -> {
                           boolean var10000;
                           if (aEg.thePlayer.getDistanceToEntity(var2) <= var363a) {
                              var10000 = true;
                           } else {
                              byte var6 = 111;
                              var6 = -105;
                              boolean var8 = false;
                              var10000 = var8;
                           }

                           return var10000;
                        }).forEach(var1x -> {
                           if (!this.rayCast.wo()) {
                              this.d(var1x);
                           }

                           this.e(var1x);
                        });
                  }

                  if (equals2 != 0) {
                     PacketUtil.l(
                        new C06PacketPlayerPosLook(
                           aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, aEg.thePlayer.onGround
                        )
                     );
                  }

                  this.nO.aX();
                  return;
               }
            }

            int eA2 = (int)(this.eA() ? 1L : 0L);
            Tuple var4 = eA2 != 0 ? null : this.eo();
            var277 = eA2 != 0 ? -1.0 : (Double)var4.getSecond();
            int booleanValue2 = eA2 == 0 && ((Boolean)var4.getFirst()).booleanValue() ? 1 : 0;
            int t = eA2 != 0 ? (this.oC != -1 && aEg.thePlayer.ticksExisted - this.oC < 2 ? 0 : 1) : (!this.nO.T(this.nT) || !this.nP.T((long)(var277 * 50.0)) && booleanValue2 == 0 ? 0 : 1);
            if (t != 0 && this.jE != null) {
               if (eA2 == 0) {
                  var363 = (long)(this.cps.wv().longValue() * 1.5);
                  this.nT = 1000L / (Long)var363;
               }

               if ((eA2 != 0 || Math.sin(this.nT) + 1.0 > Math.random() || this.nO.T(this.nT + 500L) || Math.random() > 0.5)
                  && (nR || !this.badPacketsCheck.wo())) {
                  var363 = this.range.wo().doubleValue();
                  int equals3 = this.rotationMode.wo().getName().equals("Grim") && this.nt != null ? 1 : 0;
                  var355 = equals3 != 0 ? this.nt : RotationComponent.fk;
                  var361 = this.a((Vector2f)var355, (Double)var363);
                  if (equals3 != 0) {
                     var304 = aEg.thePlayer.pl + MathHelper.wrapAngleTo180_float(this.nt.getX() - aEg.thePlayer.pl);
                     PacketUtil.l(
                        new C06PacketPlayerPosLook(
                           aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, (Float)var304, this.nt.getY(), aEg.thePlayer.onGround
                        )
                     );
                  }

                  var304 = this.mode.wo().getName();
                  int var331_hi = -1;
                  switch (((String)var304).hashCode()) {
                     case -1818398616:
                        if (((String)var304).equals("Single")) {
                           var331_hi = 1;
                        }
                        break;
                     case -1805606060:
                        if (((String)var304).equals("Switch")) {
                           var331_hi = 0;
                        }
                        break;
                     case 718473776:
                        if (((String)var304).equals("Multiple")) {
                           var331_hi = 2;
                        }
                  }

                  switch (var331_hi) {
                     case 0:
                     case 1:
                        int notWo = (!(aEg.thePlayer.getDistanceToEntity(this.jE) <= (Double)var363) || this.rayCast.wo()) && ((MovingObjectPosition)var361 == null || ((MovingObjectPosition)var361).entityHit != this.jE) ? 0 : 1;
                        if (notWo != 0) {
                           if (eR2 == 0 || this.a(this.jE, (MovingObjectPosition)var361, (Double)var363)) {
                              if ((MovingObjectPosition)var361 != null) {
                                 this.b((MovingObjectPosition)var361);
                              } else {
                                 this.d(this.jE);
                              }

                              this.e(this.jE);
                           }
                        } else if ((MovingObjectPosition)var361 == null || ((MovingObjectPosition)var361).typeOfHit != MovingObjectType.ENTITY) {
                           var316 = this.clickMode.wo().getName();
                           int var308_hi = -1;
                           switch (((String)var316).hashCode()) {
                              case -1955878649:
                                 if (((String)var316).equals("Normal")) {
                                    var308_hi = 0;
                                 }
                                 break;
                              case -957532567:
                                 if (((String)var316).equals("Hit Select")) {
                                    var308_hi = 1;
                                 }
                           }

                           switch (var308_hi) {
                              case 0:
                              case 1:
                                 if (aEg.playerController.curBlockDamageMP != 0.0F) {
                                    return;
                                 }

                                 if (eR2 != 0) {
                                    this.eu();
                                 }
                           }
                        } else if (((MovingObjectPosition)var361).entityHit instanceof EntityLivingBase) {
                           this.b((MovingObjectPosition)var361);
                           this.e((EntityLivingBase)((MovingObjectPosition)var361).entityHit);
                        }
                        break;
                     case 2:
                        final double var363b = (Double)var363;
                        var1.removeIf(var2 -> aEg.thePlayer.getDistanceToEntity(var2) > var363b);
                        if (!var1.isEmpty()) {
                           var1.forEach(var1x -> {
                              if (!this.rayCast.wo()) {
                                 this.d(var1x);
                              }

                              this.e(var1x);
                           });
                        }
                  }

                  if (equals3 != 0) {
                     PacketUtil.l(
                        new C06PacketPlayerPosLook(
                           aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ, aEg.thePlayer.pl, aEg.thePlayer.rotationPitch, aEg.thePlayer.onGround
                        )
                     );
                  }

                  this.nO.aX();
               }
            }
         }
      }
   }

   public void ew() {
      Object var148 = null;
      var148 = this.lV.wo().getName();
      int var167_hi = -1;
      switch (((String)var148).hashCode()) {
         case -2099899231:
            if (((String)var148).equals("Intave")) {
               var167_hi = 1;
            }
            break;
         case -1885322919:
            if (((String)var148).equals("Dual Sword")) {
               var167_hi = 7;
            }
            break;
         case -1844299644:
            if (((String)var148).equals("Imperfect Vanilla")) {
               var167_hi = 4;
            }
            break;
         case -1336727224:
            if (((String)var148).equals("Watchdog 1.8")) {
               var167_hi = 3;
            }
            break;
         case 73298841:
            if (((String)var148).equals("Legit")) {
               var167_hi = 0;
            }
            break;
         case 341887541:
            if (((String)var148).equals("Vanilla ReBlock")) {
               var167_hi = 5;
            }
            break;
         case 609795629:
            if (((String)var148).equals("Watchdog")) {
               var167_hi = 6;
            }
            break;
         case 1897755483:
            if (((String)var148).equals("Vanilla")) {
               var167_hi = 2;
            }
      }

      switch (var167_hi) {
         case 0:
         case 1:
         default:
            break;
         case 2:
            if (this.oa != 0) {
               this.block(false, true);
            }
            break;
         case 3:
            nR = false;
            this.nY++;
            BlinkComponent.blink();
            int var10000 = this.nY % 2;
            if (aEg.playerController.curBlockDamageMP != 0.0F && aEg.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
            }
            break;
         case 4:
            if (this.oa == 1 && aEg.thePlayer.isSwingInProgress && Math.random() > 0.1) {
               this.block(false, true);
            }
            break;
         case 5:
            if (this.oa == 1) {
               this.block(false, true);
            }
            break;
         case 6:
            if (!this.nU) {
               if (this.nY == 2) {
                  nR = false;
                  this.block(true, false);
                  BlinkComponent.blink();
                  this.mz = false;
                  nQ = true;
               }
            } else if (this.nY == 1) {
               nR = false;
               this.block(true, false);
               BlinkComponent.blink();
               this.mz = false;
               nQ = true;
            }
            break;
         case 7:
            if (this.oD) {
               this.block(true, false);
            }
      }
   }

   public float eU() {
      return RotationComponent.fk != null ? RotationComponent.fk.getY() : aEg.thePlayer.rotationPitch;
   }

   public void block(boolean var1, boolean var2) {
      Object var14 = null;
      Object var16 = null;
      Object var17 = null;
      if (!nQ || !var1) {
         var14 = aef.c(RotationComponent.fl, 3.0);
         if (var2 && (MovingObjectPosition)var14 != null && ((MovingObjectPosition)var14).typeOfHit == MovingObjectType.ENTITY) {
            this.c((MovingObjectPosition)var14);
         }

         if (ViaLoadingBase.getInstance().getTargetVersion().newerThanOrEqualTo(ProtocolVersion.v1_19) && !BlinkComponent.enabled) {
            var17 = Via.getManager().getConnectionManager().getConnections().iterator().next();
            var16 = PacketWrapper.create(ServerboundPackets1_19.USE_ITEM, (UserConnection)var17);
            ((PacketWrapper)var16).write(Types.VAR_INT, 0);
            ((PacketWrapper)var16).write(Types.VAR_INT, aEg.playerController.GZ());
         }

         SlotComponent var10002 = this.d(SlotComponent.class);
         PacketUtil.l(new C08PacketPlayerBlockPlacement(SlotComponent.getItemStack()));
         nQ = true;
      }
   }

   public void d(EntityLivingBase var1) {
      if (var1 != null) {
         this.b(new MovingObjectPosition(var1, var1.getPositionEyes(1.0F)));
      }
   }

   public boolean eZ() {
      Object var11 = null;
      var11 = this.e(Speed.class);
      return ((Speed)var11).isEnabled() && ((Speed)var11).hl().wo() instanceof GrimSpeed && ((GrimSpeed)((Speed)var11).hl().wo()).fastFall.wo();
   }

   public boolean a(AxisAlignedBB var1, Predicate<Block> var2) {
      Object var132 = null;
      int floor_double2 = MathHelper.floor_double(var1.minX + 1.0E-4);
      int floor_double3 = MathHelper.floor_double(var1.maxX - 1.0E-4);
      int floor_double4 = MathHelper.floor_double(var1.minY + 1.0E-4);
      int floor_double5 = MathHelper.floor_double(var1.maxY - 1.0E-4);
      int floor_double6 = MathHelper.floor_double(var1.minZ + 1.0E-4);
      int floor_double7 = MathHelper.floor_double(var1.maxZ - 1.0E-4);

      for (int i = floor_double2; i <= floor_double3; i++) {
         for (int j = floor_double4; j <= floor_double5; j++) {
            for (int k = floor_double6; k <= floor_double7; k++) {
               var132 = aEg.theWorld.getBlockState(new BlockPos(i, j, k)).getBlock();
               if (var2.test((Block)var132)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void eM() {
      Object var82 = null;
      var82 = this.lV.wo().getName();
      int var79_hi = -1;
      switch (((String)var82).hashCode()) {
         case 609795629:
            if (((String)var82).equals("Watchdog")) {
               var79_hi = 0;
            }
            break;
         case 1511128849:
            if (((String)var82).equals("Watchdog 1.12")) {
               var79_hi = 2;
            }
            break;
         case 1594433067:
            if (((String)var82).equals("Universal")) {
               var79_hi = 1;
            }
      }

      switch (var79_hi) {
         case 0:
         default:
            break;
         case 1:
            if (this.nY == 2) {
               BlinkComponent.dispatch();
            }
            break;
         case 2:
            this.nY++;
            if (this.nY > 0
               && !BadPacketsComponent.a((-9 - 4 ^ -13) != 0, true, false, false, false, true)
               && !this.e(LongJump.class).isEnabled()
               && !SlotComponent.dj
               && (aEg.thePlayer.ticksExisted % 2 == 0 || !this.oldPredictionKeepSprint.wo() || aEg.thePlayer.ae < 7 && !this.eZ())) {
               this.block(true, false);
            }
      }
   }

   public boolean et() {
      double var26 = 0.0;
      Object var35 = null;
      var35 = this.eo();
      var26 = (Double)((Tuple)var35).getSecond();
      int booleanValue2 = (int)(((Boolean)((Tuple)var35).getFirst()).booleanValue() ? 1L : 0L);
      return this.nO.T(this.nT - 1L)
         && this.jE != null
         && (this.nP.T((long)(var26 * 50.0) - 50L) || booleanValue2 != 0)
         && (!this.clickMode.wo().getName().equals("Hit Select") || this.jE.hurtTime <= PingSpoofComponent.getPing() / 50L - 1L || aEg.thePlayer.ae <= 11)
         && nR;
   }

   public void eO() {
      Object var5 = null;
      Object var6 = null;
      var5 = new aka(this.jE.posX - this.jE.lastTickPosX, this.jE.posY - this.jE.lastTickPosY, this.jE.posZ - this.jE.lastTickPosZ);
      var6 = new aka(
         aEg.thePlayer.posX - aEg.thePlayer.lastTickPosX, aEg.thePlayer.posY - aEg.thePlayer.lastTickPosY, aEg.thePlayer.posZ - aEg.thePlayer.lastTickPosZ
      );
      this.or = this.or.ag(0.72).e(((aka)var5).ag(0.28));
      this.os = this.os.ag(0.76).e(((aka)var6).ag(0.24));
   }

   public boolean a(AxisAlignedBB var1, Material var2) {
      return this.a(var1, var1x -> var1x.getMaterial() == var2);
   }

   public boolean eE() {
      Object var13 = null;
      if (aEg.thePlayer == null) {
         return false;
      }
      SlotComponent var10000 = this.d(SlotComponent.class);
      var13 = SlotComponent.getItemStack();
      return (ItemStack)var13 != null && ((ItemStack)var13).getItem() instanceof ItemSword && this.eF();
   }

   static {
      Object var103 = null;
      Object var128 = null;
      Object var129 = null;
      int var149 = 0;
      int var116_hi = 0;
      Object[] var10000 = new Object[]{fld_0OOOoo00o0_17, 0, null};
      Object var10003 = mth_0OOOoo00o0_8()[0];
      if (var10003 == null) {
         var129 = "\uef53\uefa4\uefb9\uf108\uefb4\uf104\uefc4\uefbb\uef51\uefc1\uef53\uef5e\uf103\uefc1\uefb9\uef54\uf102\uef9f\uefa6\uefa0\uef52\uef53\uefb1\uf0ff\uf103\uefba\uef7c\uefab\uefbc\uefc5\uefb6\uef51\uefa6\uef4f\uefa8\uefa8\uefa5\uef54\uef57\uf106\uefcc\uefb9\uef5a\uefc3\uf106\uef7c\uef7c\uef5b\uefb9\uef9e\uefa8\uef51\uefcc\uefc8\uf10b\uefc0\uefc1\uef5c\uef4f\uefc4\uef9f\uefb7\uefc1\uef79\uefc6\uefb8\uefba\uef4f\uefb5\uefc4\uef9d\uefa0\uefa4\uef5a\uf101\uefc6\uef53\uefb6\uefc2\uefac\uefa0\uef7c\uefab\uef51\uefb9\uef5e\uef4f\uefaf\uf0ff\uef4f\uef9d\uefb7\uef4f\uf10b\uefb7\uefb6\uef54\uefb3\uefbe\uefb1\uef9e\uef5b\uf108\uefac\uefb5\uefb7\uef79\uefb1\uef54\uf10b\uefa3\uefac\uef53\uefa8\uefc3\uefa8\uefa3\uef57\uef52\uefbf\uefb9\uf102\uefb3\uefbd\uefa6\uefac\uefbc\uefac\uef53\uefc8\uefcc\uef5c\uef9f\uefbc\uefa1\uef55\uef55\uef57\uefbe\uef9f\uef4f\uefc4\uefa4\uef5b\uef5a\uf104\uefc5\uef7c\uefbc\uf10b\uefc8\uf108\uefb8\uefcc\uef54\uefb3\uefb8\uefb1\uefbf\uef79\uefb2\uf108\uefa8\uefb2\uefbe\uefb4\uefbf\uf105\uf103\uefbd\uefc6\uefa2\uefab\uf10b\uefbe\uef54\uf103\uefb9\uef5a\uef56\uef7c\uefa1\uef9d\uefa8\uf10b\uefa8\uefa2\uefb5\uefa8\uf10b\uef51\uef7a\uef55\uf0ff\uefc8\uefb8\uefb8\uefba\uefba\uf102\uef59\uefb4\uefc8\uefc0\uf106\uefa2\uefc4\uf0ff\uefb8\uf10b\uef55\uefb2\uf104\uf103\uefa5\uefc5\uf10b\uf10b\uefb3\uefac\uefb5\uefb7\uefa5\uf10b\uef9e\uef52\uf106\uefc8\uef7a\uefc2\uf103\uef7a\uef56\uf0ff\uef9f\uf104\uefbc\uefb3\uef5a\uf106\uefb8\uefc3\uef59\uefc2\uf104\uefa3\uefc1\uef55\uf101\uef9e\uefbd\uf106\uefac\uef9d\uefbd\uef51\uef7c\uefc0\uef59\uefb9\uefb8\uefbe\uef9e\uefb9\uf0ff\uefa3\uef54\uefc6\uefbe\uefb8\uefac\uefb4\uef7c\uef79\uef4f\uef59\uef56\uf108\uf108\uefc2\uefbb\uef9e\uf10b\uefbf\uef56\uefb6\uf105\uf10b\uef51\uef58\uef5e\uefab\uefb8\uef7c\uefc0\uefa0\uefba\uef54\uef51\uefac\uf102\uefa3\uefa3\uef5b\uef9e\uefbb\uef59\uefa5\uefa3\uf108\uefbf\uf105\uef9f\uefba\uefc6\uefc5\uefcc\uefb4\uef5a\uef58\uefbb\uf108\uefab\uef58\uefa8\uefa3\uef57\uefc0\uef58\uefc8\uef5a\uefa2\uef9f\uef9e\uefbc\uefa6\uefa0\uefb5\uef5e\uefb1\uef57\uf104\uefb8\uefa1\uef52\uefb2\uefa4\uf103\uef5c\uefc3\uefcc\uef52\uefaf\uf102\uef9e\uefb9\uf101\uefaf\uf10b\uefbe\uef55\uefb6\uefa1\uefbd\uef5a\uef5b\uefb6\uefa4\uefb7\uefb6\uefa1\uef4f\uefc5\uefb4\uefc5\uefc4\uefb7\uef7c\uef9e\uf0ff\uefbe\uefa1\uefbf\uef4f\uefc8\uef9f\uef55\uefab\uefb5\uefa3\uefc4\uefaf\uef55\uef59\uefb7\uef5b\uef5c\uefb4\uefbc\uefbd\uefc0\uefb6\uf102\uefaf\uefbb\uefc5\uefbc\uefbf\uef59\uefb9\uef51\uefa8\uf108\uefb5\uefa8\uef5b\uefab\uf103\uefa6\uf102\uefa8\uef4f\uefa1\uef5b\uefbb\uefb5\uefb8\uefb5\uefcc\uefc3\uefba\uef59\uefb2\uef58\uefbd\uef59\uefbe\uefa6\uef4f\uefb7\uefc0\uef5a\uf103\uefb1\uef7a\uef7a\uefab\uf101\uefc3\uefb7\uefbc\uf102\uef9e\uef59\uefc3\uef5b\uefbf\uef52\uef52\uefc5\uefcc\uefb4\uef7c\uefa5\uef5b\uefc2\uef7a\uefb5\uefb8\uefba\uefc1\uefc1\uefaf\uefa2\uefa0\uf102\uefab\uef5a\uefb3\uefac\uf105\uef58\uefa3\uefb1\uefbc\uf108\uefc5\uefc5\uefb5\uf105\uf108\uef7c\uefb7\uef9e\uefb5\uef5b\uefc6\uef9d\uefbf\uefa1\uefa0\uefb4\uef59\uefb8\uefc8\uefb9\uf105\uefba\uefc0\uefa0\uf102\uef9e\uf101\uef53\uefbc\uf104\uefbf\uef56\uefa0\uef9f\uf101\uefc5\uef53\uef55\uefb9\uefc0\uef51\uef54\uefbd\uefb8\uefb8\uef53\uef5e\uefb6\uefa5\uf10b\uefbc\uefb8\uf0ff\uef7a\uefbe\uefa0\uefb5\uf10b\uefb2\uf101\uefb7\uef9f\uefbf\uefa5\uefb3\uef9d\uef53\uefc6\uefba\uefb4\uef5c\uefa0\uef79\uefb6\uefac\uefa1\uefc5\uf0ff\uf106\uefac\uefaf\uefb6\uefb3\uefc6\uef7c\uefa5\uef56\uefa3\uef54\uef9d\uefac\uefc3\uef4f\uefb4\uefbf\uefc5\uf10b\uef57\uefa1\uef9d\uefa1\uef9d\uefbe\uefab\uef79\uefbb\uefc6\uef57\uf101\uf108\uf0ff\uef5e\uef56\uef9d\uef58\uf104\uefc3\uefab\uefc2\uef53\uf101\uf10b\uefc3\uefb8\uefb5\uef79\uf101\uef4f\uefc5\uefb9\uefbc\uef55\uefb9\uefc5\uef59\uef55\uef5e\uefbf\uefac\uef54\uefa4\uefa6\uef51\uefc3\uefb2\uefb3\uefc6\uefb2\uef56\uef79\uefc4\uef58\uefb5\uef79\uef5c\uf0ff\uf101\uef5e\uefc5\uefb1\uefb4\uefa2\uefb2\uefa5\uefbe\uefa3\uefaf\uf0ff\uefb3\uefb2\uefb4\uefb6\uf101\uefb4\uef7a\uefb2\uefb8\uf105\uefb6\uf101\uefc6\uef9d\uefcc\uefbb\uef55\uef52\uefa1\uefb1\uefa3\uefb9\uf108\uefc3\uefcc\uefcc\uefb1\uefaf\uf105\uef7a\uefbc\uf0ff\uefb9\uefc6\uefc8\uefa2\uefbc\uef56\uefa0\uef79\uefa3\uef5c\uef5a\uefab\uf102\uefac\uefc3\uefc8\uf101\uef57\uef51\uefc1\uefb9\uf102\uf103\uefc8\uefbc\uf106\uefc0\uef7a\uefb1\uefbe\uef55\uefc6\uef53\uefb9\uef5e\uefac\uef9f\uef5e\uef53\uefa4\uefa5\uef4f\uefb4\uefb1\uef59\uf108\uefb4\uefb9\uefc5\uefb5\uef9d\uef9f\uefb3\uef59\uefc4\uefb6\uef53\uef53\uefa5\uef5c\uef56\uefb5\uefab\uef9f\uefaf\uef52\uefab\uefac\uefbd\uef4f\uef57\uf103\uf108\uf108\uefac\uef5e\uefb6\uefc1\uf10b\uefc1\uefb2\uf10b\uefa0\uefaf\uefbd\uefcc\uefc0\uf101\uefbb\uefbd\uefa2\uefb3\uefaf\uef79\uf101\uefb4\uef4f\uf106\uf10b\uefb3\uefb2\uef55\uefa2\uefb4\uef58\uefc8\uefa1\uefcc\uefc2\uefbd\uefb4\uefb1\uefc1\uef58\uefb3\uef9d\uef53\uf0ff\uefb4\uefc3\uefa5\uefbd\uefc8\uef5b\uefc5\uef7c\uefb1\uefb4\uefbf\uefa3\uef55\uefc2\uefab\uefa6\uf103\uefac\uefbc\uefb8\uefa2\uefb9\uf106\uefc4\uf106\uef53\uef54\uefb5\uefba\uefac\uef7a\uefc3\uef59\uefa6\uefc3\uefbd\uefc6\uefa3\uef5a\uf101\uefaf\uefb4\uef79\uf106\uefb5\uef7a\uefb6\uefb4\uefa0\uefbf\uef5e\uefb6\uf108\uefa8\uf108\uefb3\uefc6\uefa5\uf105\uefc8\uef59\uef5b\uefcc\uf102\uefa0\uef56\uef57\uefbb\uef5a\uef79\uefc6\uefbf\uefc5\uefa2\uefb4\uf102\uefb8\uf105\uefc1\uefa4\uefb2\uef56\uef52\uefcc\uf102\uf103\uef57\uefb8\uf108\uefa6\uefc4\uefc4\uefbb\uefab\uf10b\uefbf\uf101\uefac\uefbe\uefa8\uefbd\uef4f\uef5e\uef55\uef9f\uf102\uefb9\uefba\uefbb\uef5a\uef55\uefb3\uefc6\uefb1\uef58\uef54\uefac\uf101\uefac\uef9d\uefa0\uf106\uefbd\uefbd\uefc5\uef52\uefbf\uefc8\uefc2\uefc3\uefb4\uef9e\uefba\uefcc\uef4f\uefb5\uef54\uefc0\uef5a\uefc0\uefc4\uef59\uefbd\uefc0\uefb8\uef58\uef5e\uefbc\uef52\uefc5\uefc2\uefab\uef9d\uefa6\uef9f\uefa4\uef5c\uefbb\uefa6\uefbb\uefaf\uefb1\uef4f\uefb1\uef59\uf102\uef7a\uef9f\uf106\uefa5\uefa4\uef5c\uf102\uefb2\uef9e\uefb1\uefbf\uef5b\uefac\uefb2\uf103\uefa8\uefb1\uefb5\uefc1\uefc6\uefa1\uefbb\uefbc\uefa6\uefab\uefc2\uefbd\uef9e\uefba\uef5b\uefa8\uf101\uefbc\uefc8\uefb3\uef5c\uefc6\uef4f\uefc5\uefb2\uefbe\uefc1\uefb8\uefa0\uef53\uf104\uef9f\uefa4\uefc0\uefb4\uef58\uefc3\uefc0\uefb1\uef56\uefb5\uefba\uefaf\uf101\uefc1\uef7a\uef56\uf106\uef58\uef51\uf102\uefcc\uef4f\uef79\uefa0\uefb2\uefc1\uf105\uef79\uefc0\uefba\uefb7\uefcc\uef59\uefaf\uef7c\uefc2\uefa8\uefc8\uefa6\uefc0\uf10b\uefa3\uef9f\uef59\uefba\uef79\uf105\uefb8\uefbf\uefc2\uefc0\uf0ff\uefaf\uef9f\uef52\uefb6\uf108\uef52\uef4f\uefa3\uef52\uefb5\uef9d\uefcc\uefba\uef57\uefa3\uefb1\uefa2\uef53\uefb9\uef79\uef9e\uef56\uf0ff\uefbb\uef54\uefc1\uefbc\uefa5\uef7c\uefa5\uf105\uf10b\uefc6\uefbb\uef59\uefb7\uef7c\uef51\uefa8\uefc4\uefc2\uef5e\uefa6\uef58\uef54\uef7c\uef51\uf10b\uf103\uf103\uef57\uef57\uef9d\uf0ff\uef9d\uefa4\uefab\uefbb\uefbb\uef9d\uf105\uf106\uef53\uef5b\uef5a\uf104\uef51\uefb5\uefba\uefa5\uef51\uef52\uef51\uefbc\uef4f\uf101\uf108\uefc3\uef7c\uef9f\uf10b\uefb5\uefb5\uf102\uefa6\uef59\uefbf\uefa4\uefb6\uf0ff\uefc5\uefaf\uefbb\uef5c\uefc6\uef54\uefc1\uf10b\uf105\uf10b\uefc1\uf10b\uef54\uefb3\uefb7\uef51\uef55\uefc2\uefa6\uefc6\uefc0\uef54\uefba\uefc0\uef53\uefb3\uefc8\uefb8\uefb6\uefcc\uf10b\uf103\uefb3\uefb1\uefbe\uefa5\uef5a\uef56\uef79\uef9f\uefbe\uefb1\uefc4\uef4f\uefb7\uef52\uefc0\uefa1\uefac\uefa1\uefc0\uefc8\uefa1\uef52\uefc3\uefbc\uefc2\uefb6\uefa1\uefa2\uefbe\uef79\uefb1\uef79\uefaf\uf106\uefc0\uefc2\uefa1\uefb1\uefba\uefc8\uf101\uef51\uefc1\uf103\uef5a\uef5b\uefc1\uef53\uef5c\uef58\uef51\uf0ff\uef9e\uefb5\uefc8\uefb9\uefa5\uefac\uefc8\uefb4\uef9d\uefc3\uefc6\uf103\uef5b\uefb4\uefc3\uefc8\uef55\uefb2\uefbc\uef79\uefb5\uefa5\uefa2\uf104\uef7a\uefc5\uf0ff\uef51\uef9e\uefc5\uf105\uef5e\uefa4\uefc0\uef5e\uefb1\uefbc\uefa4\uefa3\uef5a\uef53\uf106\uefac\uefc1\uefa3\uef5e\uefc5\uef5b\uefc5\uefa5\uef9d\uefbe\uef52\uefc4\uefa6\uef5e\uef56\uef5e\uefc1\uefc2\uefaf\uefc1\uf108\uefc0\uef79\uef7c\uef79\uf108\uf102\uef57\uefc4\uf108\uf105\uef51\uf105\uef53\uf104\uefa5\uefc1\uef54\uefa6\uef53\uef5c\uf101\uef7c\uf108\uefa2\uefcc\uefb3\uefa5\uf0ff\uefb5\uef54\uef54\uefa2\uefc6\uefa2\uefc1\uef58\uf108\uef5b\uef4f\uefbc\uefc1\uefa0\uefab\uefb8\uf101\uef56\uefb8\uf108\uefc6\uf102\uefbe\uf108\uef54\uef9e\uefbe\uefc3\uefc0\uef79\uefb1\uef52\uef4f\uef5c\uefc3\uefb7\uefc2\uefaf\uefbe\uef57\uefa3\uefb2\uefb6\uefa6\uf101\uefc3\uefa4\uef5e\uefb3\uf105\uef56\uefc2\uefa0\uf106\uef7a\uf102\uf10b\uf105\uf10b\uefc0\uefac\uefbb\uef79\uef52\uef54\uefc6\uefbd\uefa3\uefaf\uef9d\uefa0\uefac\uefab\uefba\uef9f\uef5e\uefc4\uefb2\uef58\uefa3\uefa0\uef56\uef4f\uef55\uefb3\uf10b\uefb2\uef5c\uef7c\uefc2\uefb5\uefc6\uef9d\uefa0\uef5a\uefb3\uefab\uf103\uef9e\uefbd\uefaf\uf105\uef5c\uf105\uefa4\uefc0\uefab\uefac\uefb5\uef58\uefb3\uf105\uef9e\uef9e\uf0ff\uef51\uef5e\uef9e\uefa3\uf10b\uefb9\uef56\uef54\uf102\uefb2\uefb3\uefbe\uefa4\uef9f\uefa2\uefb7\uefb7\uefbf\uef9e\uef7a\uef55\uefbe\uefc0\uefb9\uf105\uefbd\uefa2\uef5c\uef55\uefb1\uf106\uf10b\uefc1\uef9e\uefc1\uef79\uefc4\uefbc\uefc5\uefa1\uef52\uefb1\uefc0\uef79\uf101\uefc1\uefab\uefb9\uefb1\uefa4\uf0ff\uefba\uefc3\uef79\uefbe\uef79\uef5a\uefb2\uf10b\uefb5\uefb9\uef5b\uefc1\uf102\uefc5\uef5b\uefbb\uefb9\uefbb\uf0ff\uef5c\uef59\uefc6\uefc6\uf10b\uef9d\uefba\uf102\uef5c\uefab\uf10b\uef5b\uefc0\uefa2\uefba\uef51\uefa1\uefb7\uf106\uf10b\uefa0\uefb1\uefc0\uefa8\uefb6\uf103\uef5e\uefb3\uefb4\uef5a\uf103\uefc8\uef9f\uef53\uef4f\uef9d\uefa4\uefb2\uef7a\uef9f\uef79\uefc3\uf106\uefc0\uef7c\uf10b\uf103\uefc1\uef51\uefcc\uefb6\uefb3\uf0ff\uef5a\uef58\uf10b\uefc5\uefbd\uefc3\uefab\uefc1\uf105\uefb3\uef57\uf105\uf105\uef5a\uefbc\uef59\uef7c\uefc3\uef56\uf0ff\uef5b\uefa6\uef79\uef4f\uefb6\uefa5\uefb5\uefb6\uefbc\uef9f\uefc6\uef79\uefa8\uefc1\uef7a\uf0ff\uf106\uefa3\uefb9\uef57\uefb8\uefa3\uef9d\uefb6\uefab\uf10b\uf106\uefb9\uefcc\uefa5\uf102\uefac\uefa2\uef58\uef58\uef5b\uefc1\uef7a\uefa2\uefaf\uefb4\uef59\uef5b\uef53\uf105\uf10b\uefb6\uefba\uefbd\uef5b\uefb6\uefb9\uf104\uefa6\uef5a\uefc0\uef57\uef52\uefc5\uef5a\uef4f\uf106\uef7c\uefc1\uf101\uef5b\uef59\uf10b\uefbe\uefac\uef56\uefa6\uef79\uef7a\uef9f\uf0ff\uefc2\uefb3\uef79\uefb6\uef7a\uefc0\uef9f\uef9d\uefb4\uefaf\uefc4\uefb4\uf105\uefc0\uefcc\uefc1\uefa3\uefb6\uefc8\uefb1\uefcc\uef58\uef79\uef5b\uefa3\uf103\uefb5\uef5a\uefbd\uefb7\uefc2\uefc1\uf10b\uf10b\uf105\uefc0\uefc0\uefcc\uefc1\uf104\uf106\uef59\uf104\uefa1\uef79\uefac\uef5c\uefbf\uf104\uefc5\uefb6\uefb7\uefc6\uef53\uefb1\uefaf\uef5e\uf104\uefb2\uefba\uefa3\uefc3\uef5b\uefbe\uefc4\uf102\uefa8\uefa8\uf103\uefbb\uefbf\uef9e\uefbf\uef53\uefc2\uf101\uefb9\uef7a\uefb8\uefa4\uefc5\uef79\uf103\uef79\uef7a\uefc1\uf103\uefb4\uef5b\uefb7\uefbf\uef54\uefc4\uefb3\uf0ff\uefb4\uef58\uef51\uefc0\uef59\uefa6\uef56\uefb1\uef52\uef4f\uef54\uefab\uef5e\uef51\uef55\uef7a\uefaf\uef56\uefb3\uef9e\uf103\uefc3\uefbf\uefb4\uefa2\uef55\uefa0\uefcc\uf106\uf0ff\uefbf\uef54\uf0ff\uef7c\uef53\uefa8\uefb4\uf106\uefb7\uef9d\uefbe\uefcc\uefb6\uefab\uef9f\uefbf\uf101\uefb1\uefaf\uefbd\uefb2\uf103\uefbd\uef53\uefaf\uefb4\uefbf\uef58\uefb2\uefbe\uef58\uef58\uefc5\uefbe\uef7c\uef55\uefc1\uefa8\uefb4\uefa4\uefbe\uef9d\uef58\uefa8\uefb8\uefc1\uef51\uef7c\uf106\uef54\uefc8\uf105\uefc0\uefa4\uefc0\uef57\uefc3\uefbc\uefba\uefb6\uef5a\uef79\uefc0\uefb4\uef9d\uefb3\uefb4\uf103\uefc0\uefb1\uefb4\uef54\uef9f\uefb7\uefb6\uefa6\uefa4\uef54\uf0ff\uefb8\uefc3\uef58\uefb1\uefa1\uf103\uf102\uefc3\uef52\uefb1\uef57\uef4f\uef52\uefc4\uf0ff\uefb9\uefc5\uefb4\uefbd\uefbd\uf102\uefa4\uef54\uef59\uefc0\uef56\uefc6\uef5a\uefbc\uefb7\uf106\uefb7\uefbb\uf108\uf103\uefa6\uefc0\uef9e\uf0ff\uefc1\uefb7\uefaf\uefc4\uefa3\uefa1\uefbb\uef5c\uf10b\uf106\uef9f\uef53\uefb4\uefb4\uefa8\uef5e\uefaf\uef5e\uef7a\uefb6\uefba\uefb4\uefbb\uefb7\uefb1\uefa3\uef7c\uef52\uef5b\uefc4\uefba\uefa4\uef7a\uefa0\uef5c\uefc5\uefc3\uefa3\uef53\uefa3\uefab\uef5e\uefb7\uefc2\uf104\uf103\uf108\uf106\uef51\uefbf\uefc8\uefac\uf103\uefbb\uefb9\uef5e\uefcc\uf101\uefc1\uefc3\uf106\uefb2\uefb8\uef7c\uefc2\uefb5\uefba\uefb3\uefb7\uef59\uefa3\uef55\uf101\uf108\uefa8\uefbe\uf0ff\uef51\uefc0\uef54\uf108\uef5c\uefb7\uefa0\uefc0\uefb3\uf105\uef5b\uefa8\uef53\uefc3\uefc0\uefbf\uef58\uf106\uef4f\uefa5\uef79\uefb2\uefa3\uefbe\uefc8\uefa6\uef52\uf106\uefa3\uef5a\uefbe\uef51\uefbe\uf106\uefc6\uefa4\uefa0\uefa2\uefa4\uefc1\uef7a\uefc2\uefab\uef55\uf104\uefb3\uefb7\uef79\uefac\uef58\uef7a\uefbf\uf103\uef56\uef5e\uef4f\uefb7\uef58\uef57\uef54\uefb2\uefb2\uef5c\uefbd\uefc2\uef9e\uefa2\uefc2\uf106\uefab\uf10b\uefc1\uf106\uefcc\uefa3\uefa4\uf106\uefc1\uefb7\uefb1\uefa8\uefbc\uefb8\uef9f\uef9f\uefa3\uefc3\uef52\uefb2\uefa0\uefa6\uefa0\uef5a\uefbc\uefc3\uf101\uefb1\uefb6\uefbc\uf108\uefb2\uefc5\uefa0\uefc3\uf104\uef57\uef57\uefac\uf104\uef52\uef9e\uef56\uefab\uef54\uef55\uefbd\uef53\uefb8\uf10b\uef55\uefb8\uf101\uef57\uefbe\uefa8\uefb6\uef4f\uf103\uef9d\uefb6\uef9d\uefc5\uefa1\uefbf\uefa1\uef58\uefa1\uf0ff\uef55\uef5b\uefc0\uef59\uefb2\uf0ff\uefb9\uefb6\uef9d\uefc4\uf102\uefc2\uefbc\uef53\uef7a\uef55\uef53\uefa3\uefb5\uefa6\uf104\uefa8\uf108\uefb2\uef9d\uefb7\uef9d\uf101\uef52\uefa0\uef51\uef59\uef9d\uef9d\uef5b\uefb1\uef52\uefbd\uef79\uefa4\uefba\uefb2\uefc4\uefb7\uf101\uef9d\uefc5\uefb7\uf101\uefa0\uefc5\uef59\uefc3\uef53\uefb9\uf102\uef5b\uf106\uef58\uefbe\uef51\uef5e\uef5c\uefb4\uefb9\uef9f\uef9d\uefbc\uef59\uef54\uef9d\uf102\uef51\uefb7\uf0ff\uef5c\uefa0\uefc8\uefaf\uef59\uefab\uef53\uefab\uefb6\uf102\uefc8\uefbe\uefb7\uf103\uefbe\uefc2\uef9f\uefcc\uf10b\uefb7\uef5a\uef58\uefb8\uef79\uef79\uf101\uefbf\uefc0\uef5c\uef4f\uf108\uf108\uef9d\uefa2\uef59\uefc4\uef7a\uefcc\uefc5\uef53\uefab\uefac\uef79\uef4f\uf108\uef7c\uefb8\uf105\uf108\uefa0\uefbe\uef57\uefa5\uefc3\uef7a\uef79\uef9e\uef59\uef59\uefb2\uf103\uefc5\uf105\uf104\uf102\uef53\uef79\uefaf\uefbb\uefbb\uefb1\uefb4\uf108\uefa5\uefb8\uefb9\uef59\uef9d\uf102\uef5e\uefbd\uefb3\uefba\uef9e\uf104\uefb3\uef5a\uefc6\uf104\uefa0\uef9f\uef53\uefcc\uef5c\uefa3\uefba\uef58\uefa5\uf106\uef53\uefb4\uefb3\uefc8\uef54\uf0ff\uef7a\uefc6\uefa0\uefa4\uefab\uef51\uefc8\uefc3\uef54\uf102\uefba\uefc2\uef56\uef55\uefb4\uefbb\uefb3\uefac\uef4f\uf101\uefa8\uefbe\uef51\uefbf\uef55\uef56\uef7a\uef52\uefc3\uef59\uefc4\uefa4\uef7a\uefbb\uefbe\uef5e\uefb7\uefc8\uf10b\uf106\uef7a\uefb1\uf103\uefa1\uefac\uef7a\uf105\uef79\uefb4\uefa2\uefc3\uef7a\uef5b\uefb3\uef55\uef59\uefb1\uf103\uf101\uef55\uef53\uefc1\uefc1\uefbd\uefbd\uefaf\uefa6\uefba\uefac\uefbe\uefa6\uf101\uef51\uef9f\uf106\uf106\uefa4\uefa4\uefab\uf103\uef58\uef54\uef54\uf104\uefc3\uef5b\uef7c\uf105\uef5c\uef52\uefb5\uef53\uf108\uefc5\uefb8\uefa6\uef9e\uef7c\uef4f\uef5e\uefc8\uf105\uef9d\uefb5\uef5b\uf104\uef56\uef51\uefc0\uefb7\uefc5\uefc3\uefa6\uef54\uef51\uefac\uef56\uef56\uef56\uefb8\uefbe\uefa2\uefa6\uf10b\uef5e\uf103\uef53\uefaf\uef5c\uefba\uefab\uefb5\uef9e\uefc0\uf108\uefb8\uefb2\uefb8\uef55\uef54\uefbe\uef9f\uefc2\uefa3\uefac\uefb8\uef55\uefbb\uefbe\uef9e\uef5c\uef79\uf104\uefc3\uf104\uefb4\uefb5\uf102\uefc2\uefb3\uefb1\uef56\uf105\uefc4\uefa0\uf108\uf102\uef9e\uef7c\uf101\uefa0\uef5c\uef79\uefc1\uef9d\uf102\uf106\uef51\uefbd\uef79\uefc4\uef58\uefba\uefb2\uefa8\uef4f\uef9d\uf0ff\uefa3\uef56\uf104\uef52\uefba\uef59\uefbd\uefaf\uef51\uefab\uefa8\uefb9\uefc0\uefa2\uef56\uefbd\uefc2\uefa5\uefc3\uefc3\uf10b\uefa5\uf10b\uef7a\uefb2\uefac\uefab\uefa1\uef55\uefb9\uefc5\uefa4\uefc6\uf108\uef5a\uf103\uefbd\uef79\uefc5\uef7c\uf105\uefc8\uefbf\uef57\uefb5\uefc2\uefb6\uef59\uf10b\uefbd\uefac\uef54\uefa6\uefaf\uef54\uef7c\uefa3\uefa0\uefc1\uef9f\uefc5\uefa4\uefa3\uef53\uef9d\uefc1\uefab\uef5a\uf104\uefa3\uef58\uef7c\uefb3\uef51\uef54\uefc6\uf106\uef55\uefc2\uefc8\uefc4\uef9d\uf103\uefb8\uf105\uf104\uefc0\uf108\uefc2\uefb5\uefbc\uefa1\uefc3\uef5b\uefb6\uefbc\uef58\uef51\uefa4\uefc6\uef5e\uefc5\uef55\uefc5\uefa5\uef5b\uefc0\uf101\uef57\uefc1\uef59\uefb7\uefb2\uefb8\uefbb\uefb5\uef58\uefab\uef9f\uef5c\uefa8\uef5b\uefb3\uf101\uefbb\uef58\uefbd\uef4f\uefb5\uef5a\uefcc\uefa4\uef5b\uf101\uefc0\uefc6\uef9f\uef9d\uefc6\uf102\uef52\uefbf\uf101\uefa5\uefcc\uefa4\uef53\uef51\uef5b\uefb5\uf10b\uef5e\uefb6\uef9f\uefab\uef7c\uefc2\uef55\uefac\uef9f\uef59\uef5b\uefb4\uefab\uf108\uefc4\uef52\uef9f\uefc4\uefb6\uf108\uef54\uef5c\uf106\uefb8\uef52\uef9f\uefb6\uefb9\uef4f\uefbf\uefa6\uefc0\uefc6\uefbf\uefbf\uef5c\uefc1\uefac\uef59\uefc5\uef79\uf101\uefbf\uefab\uef51\uefbb\uefb9\uefc0\uefa2\uefbf\uefa4\uefba\uefb5\uf105\uefb4\uefa2\uef52\uefc3\uefbb\uefc0\uf102\uefb6\uefbf\uef4f\uef51\uefb4\uef51\uefc5\uefbd\uef5e\uef5b\uefaf\uef5e\uef57\uefbe\uefba\uefb7\uefc6\uef79\uefc8\uefaf\uefb1\uefc2\uef59\uef5b\uefb7\uef9e\uefc4\uef4f\uef5e\uefc1\uefbe\uefb8\uefcc\uefc4\uef51\uef51\uefbc\uef5c\uf106\uefc6\uf106\uefba\uef4f\uefb8\uefc3\uefac\uf106\uef9e\uef58\uefa4\uef7c\uf102\uefb1\uefc3\uef53\uef58\uef53\uefb8\uefc0\uefba\uef55\uef79\uefb4\uefb4\uefb6\uefc8\uf10b\uefb3\uef9f\uefaf\uefc5\uefc3\uefcc\uef53\uefbb\uf104\uefa3\uef52\uef58\uef5e\uef79\uefb4\uef5e\uefb7\uf108\uefa1\uefc5\uefc1\uefb6\uf101\uef52\uf104\uf105\uefb5\uefa4\uefb8\uefc8\uefab\uf101\uef5b\uef5b\uef9f\uef55\uefc4\uf10b\uef5c\uf101\uefb6\uefbf\uefa8\uef7c\uf108\uef9f\uef58\uefbc\uefc6\uf105\uefa2\uefb9\uf10b\uefb4\uefb7\uef9e\uefa0\uefb6\uefa0\uefb9\uef52\uef5e\uefb3\uefb9\uef59\uefac\uef5c\uef51\uef57\uefb5\uefc2\uef55\uefc2\uefbd\uefa3\uefbe\uf104\uef57\uf0ff\uefa0\uef9f\uef5e\uef7c\uefb7\uef9e\uf106\uefab\uf0ff\uefaf\uefa1\uf104\uf106\uefc2\uefba\uefb8\uef56\uefc0\uefba\uefb4\uefc1\uf105\uef52\uefa4\uef5c\uef5c\uefa6\uefa3\uefa4\uefb1\uef5e\uf102\uef59\uefb5\uef51\uefb5\uef5b\uefc8\uefa8\uef59\uefb7\uefc5\uf0ff\uefbc\uef56\uef54\uefa2\uefab\uef9d\uef5e\uefa1\uefa6\uefb5\uefa5\uef59\uefb1\uef53\uefc3\uef9d\uefa2\uefb5\uef53\uf104\uef53\uef54\uf10b\uefac\uefb8\uef55\uefac\uefab\uef57\uefb1\uef5b\uefa0\uefa4\uefa1\uefa4\uef51\uefb5\uefbe\uefa0\uef57\uefa1\uefb7\uefa4\uefcc\uefc1\uf108\uf103\uefa3\uefa8\uefa3\uef59\uefbf\uf105\uf108\uefa2\uefaf\uefa3\uefa6\uefbe\uef57\uf106\uf10b\uef54\uefc6\uefaf\uef56\uefa0\uef4f\uef79\uef79\uef9d\uefb6\uefa8\uefc8\uefbf\uf0ff\uefb5\uefb9\uefa3\uef59\uefb2\uef59\uefb9\uef5c\uefb1\uf104\uefc5\uefb3\uefa3\uefa5\uefa2\uefa3\uf101\uf104\uef7a\uef5c\uefc8\uef57\uef9f\uefa5\uefa3\uf101\uef59\uefbb\uefbd\uef53\uf104\uefa8\uf104\uf104\uefba\uefa3\uef9e\uf103\uefc5\uefaf\uef57\uefc8\uef58\uefb6\uefb8\uef5a\uef55\uef9d\uefbe\uf106\uefb1\uefb7\uf102\uefbe\uef55\uefbf\uf105\uef9d\uefbe\uef52\uefc0\uef51\uef57\uef9e\uef4f\uef9f\uefc4\uef51\uef54\uefb7\uef51\uefc1\uefb5\uefa1\uefa3\uef5e\uef59\uef5a\uf10b\uefb7\uef52\uefaf\uefcc\uef53\uefbd\uef5c\uefba\uef9f\uef53\uefaf\uefa8\uef7a\uf108\uf10b\uef79\uefa8\uefc0\uefba\uef59\uef9d\uefa0\uefcc\uef55\uf108\uefb7\uf101\uef9d\uefc4\uf101\uefba\uefb3\uef53\uf104\uefa6\uefc3\uefc0\uefbc\uefa6\uefcc\uefc1\uefbe\uefc2\uef54\uf108\uef52\uefbc\uefa5\uefc0\uefa1\uefa1\uefa5\uefa8\uef9e\uef57\uf102\uefa4\uefa6\uef5e\uefa2\uefbc\uef54\uefbb\uefb9\uefa0\uefb9\uefbb\uefbd\uf108\uef5e\uef4f\uef54\uefb8\uefac\uef7a\uef4f\uef52\uefb1\uefab\uefb4\uef53\uefb5\uefbc\uefc5\uef5e\uef5e\uf101\uefc2\uefc6\uf102\uefa0\uef51\uefa2\uefbb\uefa1\uefaf\uefac\uef56\uefb5\uefb1\uf108\uef9d\uefac\uefba\uef9f\uef79\uefb7\uef9f\uefc8\uefc8\uef55\uef57\uefb2\uefc8\uf102\uefbd\uefc6\uefc8\uefbd\uef5b\uefb7\uef56\uefb7\uef55\uef59\uefa6\uefbb\uef5e\uefbe\uefa4\uefac\uef7a\uef7a\uf10b\uef57\uef9d\uefa3\uefb7\uefaf\uefba\uef7a\uef53\uef57\uefb6\uefcc\uefbe\uefc8\uefa3\uef9d\uefaf\uef79\uf0ff\uefc3\uef52\uef7c\uef5c\uefc4\uf101\uefa4\uefb6\uefa6\uefb2\uefc6\uefb1\uefb1\uefa6\uef5a\uefa1\uefa1\uefc4\uf0ff\uef9e\uefbd\uefbc\uef4f\uf108\uefaf\uef9f\uef7a\uefbd\uefc3\uf106\uefbd\uefb7\uefc6\uef53\uf103\uef53\uef79\uefc2\uefbc\uef58\uefbd\uefc8\uefa1\uf101\uef53\uf101\uef55\uf102\uef5a\uefb1\uef56\uefbf\uefb4\uefbc\uefb3\uf10b\uef52\uefb2\uef4f\uefb7\uefb2\uefb7\uefc3\uef53\uefc1\uf106\uef5c\uef4f\uefb4\uefac\uefb4\uefa1\uef5e\uf106\uef52\uef9e\uef58\uef5a\uefba\uef56\uefa0\uf102\uef56\uefc8\uefa5\uefab\uefc0\uefbe\uefb4\uefaf\uef9e\uef56\uef5b\uef5c\uefc6\uefba\uef79\uefbc\uef5c\uef7a\uf102\uefc5\uefb9\uf10b\uef51\uefa3\uefa0\uefac\uef4f\uefbf\uf104\uefc3\uefc5\uefb2\uf108\uef4f\uef53\uf104\uf102\uf10b\uf101\uefb9\uefbc\uefc1\uef4f\uefcc\uefb5\uf103\uefb5\uefa8\uef56\uefcc\uefac\uf0ff\uefa0\uefac\uefa3\uf104\uefb3\uefbb\uefc1\uefbb\uefc6\uefcc\uef5c\uefb4\uefb9\uef54\uf108\uefab\uefa1\uef79\uef4f\uef53\uefa6\uefc2\uef53\uef9f\uf108\uefab\uef54\uef5b\uef55\uefcc\uefa4\uf0ff\uefbd\uefa5\uf102\uefac\uf102\uefb8\uefb9\uef9e\uefc6\uefaf\uefaf\uef57\uefa5\uefbe\uef7a\uefb8\uefc6\uefb9\uef56\uf105\uf102\uf103\uef5e\uefb6\uef7a\uf101\uefc0\uefc3\uefa8\uef5c\uefa3\uefc3\uefc0\uef4f\uf108\uef5c\uef9f\uefb6\uefc4\uefb1\uef54\uef9f\uefb6\uefaf\uefab\uefbe\uefbf\uefb7\uefb7\uefaf\uef55\uf10b\uef55\uefaf\uf103\uefbb\uef55\uefb1\uefbe\uefab\uefa3\uefa0\uef58\uefb5\uefb2\uf105\uefaf\uefb6\uefa4\uef58\uefc4\uf102\uef7c\uefa3\uefac\uef4f\uef57\uefbd\uefa0\uefa0\uefbf\uef51\uefbd\uef5a\uf101\uefac\uf108\uefb4\uefb4\uef51\uef5b\uefc6\uef51\uefb1\uef54\uef55\uefa6\uefb1\uefbe\uef58\uf10b\uefc3\uefc8\uef5b\uf102\uef58\uef51\uef9d\uefa4\uf106\uefc0\uefc5\uef9d\uefc2\uef59\uef54\uf102\uf106\uef9f\uefb9\uefc8\uef9f\uefa2\uef5c\uefba\uefb7\uef5c\uf106\uefa6\uefac\uef53\uefb1\uef57\uf101\uefa6\uefb9\uefc4\uefb2\uefa8\uef54\uef54\uefbc\uefbb\uef4f\uefb7\uefa2\uefa8\uef79\uf108\uefc1\uefc1\uefb5\uef5b\uefc1\uefbf\uf101\uef5e\uefab\uefc3\uefa8\uefb7\uefa6\uef58\uef57\uefa5\uef57\uefa1\uefb8\uefc3\uef5a\uef5b\uefbf\uefb6\uf104\uef5e\uefa6\uefaf\uefa2\uefba\uefc0\uefc3\uefb5\uef57\uefbb\uefab\uefc5\uefba\uefbd\uefc3\uefa1\uefbf\uef9f\uefb7\uef58\uf108\uef5a\uefcc\uf106\uefb2\uefb5\uefa6\uefc8\uefa8\uef55\uef5e\uef79\uefc0\uefa3\uefb1\uefb3\uf105\uef58\uef9d\uefa8\uef4f\uefbc\uefab\uef52\uefbd\uefb7\uf105\uefb3\uf108\uf104\uefc8\uefc4\uf106\uf104\uefb1\uef5e\uefba\uefb6\uefc5\uefa0\uf106\uefc2\uf0ff\uefbf\uefb3\uf10b\uefc6\uefb1\uef54\uefbc\uef56\uefbc\uf104\uef54\uefbb\uf101\uefba\uefb1\uefbb\uefba\uefc0\uef59\uef5e\uef7a\uef55\uefab\uf103\uefa8\uefbc\uef9f\uefc2\uefc4\uf101\uf103\uefc5\uef79\uefac\uefab\uefb5\uefab\uef56\uefb1\uefb3\uef52\uefbf\uef58\uefa5\uefc2\uefa0\uefa6\uef4f\uefb8\uefbc\uef51\uefb6\uefab\uef5c\uefb5\uf10b\uefc5\uef79\uef9e\uefbb\uef79\uefbe\uefc3\uefb7\uef4f\uef53\uefb4\uefa8\uef58\uef59\uefc2\uefb1\uefb2\uef57\uefac\uefcc\uef7a\uef7c\uf104\uefba\uefc3\uefba\uf105\uefb3\uefbd\uefaf\uefbd\uef52\uf101\uefbd\uefb3\uf104\uefb2\uefa3\uf104\uefab\uef5b\uefb6\uef7c\uefc2\uefbb\uefbc\uefc4\uefa2\uef79\uefa5\uf101\uefa2\uefc3\uf108\uefc0\uef5b\uefc3\uef5c\uf108\uef5e\uefa4\uf108\uefc0\uefbc\uef9e\uef9e\uefb5\uf10b\uef9d\uef9d\uf106\uef56\uef7a\uefbc\uefac\uef58\uefb5\uefb8\uef5b\uf105\uefbc\uefa8\uefb5\uefb8\uef4f\uefaf\uef55\uf10b\uefb5\uef4f\uefa8\uef56\uef79\uef55\uef7a\uefc3\uef54\uef7a\uf108\uef9d\uef54\uf101\uefc5\uefc5\uefb9\uef5e\uef52\uefaf\uf10b\uef58\uf101\uefb9\uef58\uefbb\uf102\uf101\uefcc\uefc5\uefb1\uf103\uef52\uefc5\uefa8\uef53\uefbd\uefb7\uf108\uef7a\uefa3\uefac\uefb7\uf102\uefb6\uefb8\uefc0\uefc2\uef7c\uefbd\uefc8\uefb3\uef51\uefb4\uefc2\uefb4\uef59\uefc6\uefcc\uef58\uefa1\uef5b\uefa4\uf101\uefb4\uf108\uefb8\uf101\uf104\uf10b\uefc4\uefba\uef59\uefa6\uef9f\uefc4\uefba\uf10b\uefbf\uf104\uefc1\uef59\uf10b\uefb6\uefb3\uef55\uef4f\uef5c\uefbc\uefb8\uefc3\uefb6\uef7c\uefb7\uef58\uefc5\uefa5\uefbf\uefa1\uefbb\uefb2\uefbd\uefc5\uefc4\uefc3\uef52\uef57\uefc5\uef58\uef54\uefab\uef52\uef55\uefa1\uef9e\uefc3\uefbe\uefcc\uef4f\uef4f\uef5a\uef9e\uefb9\uefba\uefb6\uefc0\uef51\uef79\uefc2\uefa3\uefbc\uefbb\uef58\uefac\uef5b\uefbb\uefba\uf10b\uef5c\uefb1\uefc2\uefa2\uefbb\uefb2\uefaf\uef55\uefb2\uefb7\uefbb\uefbc\uefc0\uef9f\uf105\uef5b\uef9d\uf104\uef57\uef5c\uef57\uefc4\uefb3\uf105\uef5b\uef7c\uefc2\uefbc\uf105\uefc3\uefc6\uefc0\uefb9\uef59\uef5e\uef7c\uf106\uefa5\uefac\uef59\uefa1\uf108\uef79\uf103\uefc1\uef9e\uef51\uefab\uefcc\uef4f\uef9e\uef5e\uf10b\uf101\uefb1\uef4f\uefc3\uefbe\uef4f\uefa8\uef79\uefa0\uefab\uefb6\uef51\uefb8\uefb7\uf103\uefb7\uefb9\uf101\uef5c\uef7a\uefb5\uefbd\uef55\uf0ff\uefb7\uef55\uef79\uef52\uef9d\uefbd\uefa5\uefa0\uefc2\uef4f\uefc8\uefbd\uef5c\uefbd\uefbd\uefb8\uef79\uef5b\uefc5\uefab\uf108\uefbc\uf101\uefac\uef54\uefa5\uefbd\uefc1\uefb9\uefbe\uefc8\uefb8\uefc1\uef5c\uef9d\uefa2\uefc3\uefb2\uef56\uefcc\uef53\uef55\uef7c\uefa1\uefb5\uefa6\uefba\uefb6\uefb8\uefc2\uef51\uef5a\uefa3\uefb9\uf104\uf108\uefc4\uef5a\uf103\uef57\uefbe\uef52\uef58\uf0ff\uefc1\uefa8\uf10b\uefb8\uefa6\uf10b\uefa2\uefb9\uefc5\uefa5\uef59\uefbd\uef58\uefbf\uefa1\uefc8\uef56\uefb2\uefc1\uefbd\uef79\uefb3\uefb9\uef7a\uf103\uefab\uefac\uefc2\uefb2\uefa1\uf108\uef7a\uefb9\uef51\uef52\uefbf\uefbb\uef56\uefa0\uefc1\uefc1\uefbc\uef9d\uef53\uefc8\uefa0\uefbf\uef58\uef53\uefc4\uefbd\uefbc\uef55\uef7c\uefa6\uefa4\uef9d\uefab\uef57\uef55\uf0ff\uefbf\uefb6\uefb8\uefa3\uefba\uef57\uef5b\uefbc\uef56\uefbb\uefbc\uf0ff\uefb9\uefbe\uef56\uef79\uef51\uef9f\uefc5\uefb3\uefbb\uefb5\uf0ff\uefb6\uef58\uefbe\uefc5\uefb6\uef7c\uf104\uefa5\uf108\uefcc\uefbc\uf103\uefb1\uf104\uefb6\uf102\uefa0\uef59\uefb7\uf10b\uf0ff\uefbd\uefa8\uefab\uefbc\uefc3\uefb5\uefb6\uef5e\uef7c\uefc5\uefbe\uef7a\uf102\uef51\uf108\uefbe\uf101\uefa0\uefc3\uef5b\uefa3\uefc2\uefc5\uef55\uefac\uef9e\uefc5\uef58\uefa6\uefa5\uef5e\uef57\uef4f\uefb6\uefab\uef9f\uefbb\uefb9\uf103\uf10b\uef4f\uef5c\uef51\uefa2\uefc2\uefbc\uefb7\uef7a\uefcc\uefb6\uef5a\uef55\uef5e\uef9f\uefbb\uef55\uefb6\uf105\uef52\uefb4\uef55\uefb8\uef59\uef5e\uf102\uefa3\uefb8\uefc8\uef54\uef9e\uf105\uf108\uf103\uefb2\uef51\uef57\uefc6\uf0ff\uefa3\uf104\uef57\uefb8\uefb7\uefba\uf102\uefb7\uefb2\uef58\uefb7\uefc2\uefa8\uefab\uef9d\uef57\uefb4\uefb8\uefac\uef59\uefbd\uf104\uefb2\uefba\uef57\uef5c\uefc3\uefa4\uefc2\uef53\uef54\uf103\uf104\uefc0\uf106\uef5b\uefb7\uefb4\uefa2\uef59\uef7c\uefab\uefb8\uef9e\uefac\uefc0\uefcc\uefcc\uef9f\uf0ff\uefbd\uefa2\uefcc\uefc6\uf10b\uefb9\uefa0\uefc8\uefa4\uefb9\uefbf\uefb1\uef5b\uef5e\uefc8\uefc8\uef53\uefa6\uef5c\uefba\uefb8\uefb4\uef52\uefa8\uefc6\uefc6\uef7a\uefa0\uefc4\uefac\uf105\uefa2\uefcc\uef5c\uefb2\uef9e\uef5b\uefac\uefab\uefbd\uefab\uefc0\uef55\uefc3\uf0ff\uefb9\uefb5\uef9d\uefb1\uefb7\uefb4\uefa0\uefaf\uef5c\uf106\uefc0\uefc3\uef5a\uefb4\uef7c\uefb8\uefab\uefbe\uefaf\uefa6\uefb4\uefbe\uefba\uefbb\uf105\uf0ff\uef5b\uef57\uf108\uefa3\uef58\uef53\uef58\uefc1\uefb5\uefbf\uf10b\uefb4\uefbf\uef56\uefb4\uefaf\uf103\uef7a\uf10b\uef53\uefc4\uf0ff\uef9f\uefb7\uef9e\uef53\uefb8\uefb9\uefb6\uefc4\uefbd\uef59\uef5e\uefb6\uefc3\uefa3\uefa4\uefb3\uefb9\uef79\uefa0\uef51\uef7c\uefb5\uefcc\uefc0\uef56\uefab\uf108\uef5c\uefab\uef51\uefb4\uf103\uef9d\uefb6\uef53\uefc4\uef7c\uef9f\uf0ff\uef4f\uefbe\uef9e\uefb1\uefbe\uef5a\uef56\uf10b\uef56\uefa6\uefb9\uefc5\uef55\uefa1\uefba\uef7a\uef52\uef5a\uf108\uefac\uefb4\uf102\uefa6\uef5c\uefa0\uefbc\uefc2\uefc4\uf105\uefc6\uefb9\uefa8\uefa2\uefa8\uf102\uef56\uefb3\uef9d\uefc8\uefa5\uf0ff\uef4f\uefcc\uefc8\uf108\uef5c\uefb5\uefa2\uef58\uefc4\uefc3\uef79\uf104\uef7a\uef9e\uefb6\uef59\uefa2\uef79\uf10b\uefcc\uf102\uefbc\uefa8\uefbc\uefc2\uef4f\uef5e\uf10b\uf105\uefa1\uefc3\uefc2\uefa6\uef9d\uefbf\uefb4\uef7a\uf103\uf105\uefc1\uef9d\uefb9\uef53\uf106\uef5e\uf101\uefb3\uefcc\uef5b\uefc4\uef7c\uefa6\uefa2\uef54\uefc8\uefb7\uefa8\uef5c\uef7a\uefba\uef79\uefb1\uefb5\uefb1\uefb4\uefbf\uefc0\uef52\uef5e\uefc1\uefc3\uefc6\uef7a\uefc8\uef5c\uefb9\uefc5\uefb6\uefc2\uef58\uefbc\uefac\uef5b\uefb3\uefa5\uefa4\uf103\uef54\uef59\uefb6\uefb8\uef79\uefbd\uef52\uef55\uefb7\uf104\uefc4\uf0ff\uefc8\uef57\uefb6\uefc5\uefbe\uef51\uef9d\uef53\uf0ff\uefc2\uefbb\uef5e\uf105\uefc3\uf105\uefb3\uefb5\uefb8\uef56\uefb2\uefab\uefa6\uefc8\uef57\uefaf\uefbc\uefb5\uef5b\uefa6\uef9e\uef9e\uefb4\uefc3\uefb5\uefbb\uf106\uef52\uefbb\uf106\uf0ff\uefb7\uefbe\uefb1\uefcc\uef7c\uefa3\uef52\uefb2\uf108\uefb5\uefc6\uefb3\uf101\uefb7\uf0ff\uefba\uefc1\uefc5\uf102\uefc2\uefc1\uefbe\uef7a\uf106\uef59\uefa5\uefa4\uf104\uefb6\uefa8\uefc8\uefbf\uefbf\uef56\uefa2\uefaf\uef5a\uefb4\uef5a\uefa2\uefa8\uf104\uefa0\uefc6\uef79\uefa4\uefa0\uefcc\uefbe\uef51\uef79\uefc5\uf105\uefa3\uef4f\uef57\uefb5\uef5a\uef79\uefb4\uefb3\uef5e\uefc2\uefa2\uefa0\uefb3\uefba\uefc5\uefc0\uefc6\uef53\uef53\uefb2\uefba\uefab\uef57\uefb8\uefb2\uefa1\uef9e\uefaf\uefa1\uefb9\uefc1\uefc3\uf108\uf10b\uefb2\uf0ff\uefa6\uefab\uefc8\uef5c\uefbe\uef55\uefa2\uef5e\uef7c\uef5c\uefc6\uf106\uefb1\uef7a\uefa2\uef59\uefa3\uefc8\uefbd\uefc3\uefc6\uefc8\uef54\uef53\uefb5\uef4f\uefb5\uf105\uefa2\uefa8\uefaf\uef53\uefa5\uefc1\uef7a\uf10b\uf101\uefa6\uefb4\uefa6\uef4f\uef5b\uefa8\uef58\uef9f\uf0ff\uef53\uef57\uf108\uefcc\uefc0\uf105\uef5b\uefb7\uf102\uefac\uef5e\uef5e\uefa4\uefc3\uefc2\uef53\uefbf\uef5c\uefa2\uefc4\uefab\uefba\uef53\uef58\uefbb\uf101\uefa5\uef59\uefa3\uef79\uefaf\uefa3\uefa1\uefbe\uef5e\uef52\uf10b\uf108\uefbc\uef79\uefc6\uefa6\uefab\uefbe\uefb9\uefb9\uf104\uef5e\uefa6\uefab\uef51\uefc5\uef5c\uefa6\uefb3\uef79\uefa5\uef7c\uefba\uefcc\uf103\uefa4\uefab\uef51\uefb9\uef7a\uef55\uef54\uef7a\uef52\uf10b\uf102\uefa5\uf105\uf106\uf105\uefc2\uefa8\uf0ff\uefc3\uef53\uefb4\uef79\uf105\uefaf\uf106\uef7a\uef51\uefb3\uef9d\uefc4\uef5b\uf0ff\uefc5\uefa8\uefbe\uef7a\uefcc\uef54\uefb3\uefcc\uefbe\uefcc\uefb8\uefb9\uefac\uefb4\uefb3\uefc6\uefaf\uefa1\uefab\uef55\uefac\uef54\uf105\uef9d\uefa4\uf104\uef5e\uefb9\uef7c\uefc4\uef5e\uefbf\uefa4\uef4f\uf104\uef7a\uef53\uefb9\uefa1\uf104\uef5a\uf10b\uef55\uefb6\uef5e\uefb8\uefb3\uef5a\uef5c\uf10b\uefba\uefc5\uef79\uefac\uef5a\uefa8\uef59\uef5c\uefbe\uefb5\uef79\uefbb\uf101\uefb4\uefb8\uefb1\uf103\uefaf\uef57\uefbb\uefaf\uf106\uefb7\uef52\uefa8\uefa1\uefa1\uefb6\uf106\uefc8\uefa4\uef9f\uefc6\uef54\uf104\uef5c\uef79\uefa3\uef9f\uefa8\uefb6\uefaf\uefaf\uf108\uefb1\uf106\uf106\uefc0\uefb4\uefac\uefa1\uef7a\uefbc\uf106\uef4f\uefaf\uefc5\uef5c\uefc5\uefba\uefa0\uefbc\uef9e\uefb6\uef7a\uef54\uef58\uefa8\uefab\uf103\uefbe\uefcc\uefa4\uef53\uefa1\uefaf\uf0ff\uefa4\uefba\uefc8\uef53\uefa1\uef52\uefbd\uefb7\uf102\uefcc\uefb7\uef54\uf108\uf105\uf105\uf10b\uf106\uefa4\uefa1\uf108\uefaf\uefc6\uefc8\uefb9\uefa5\uef9e\uf103\uefc6\uefc0\uefb5\uef54\uef52\uefc2\uefba\uefab\uf102\uefa5\uefb7\uef9e\uefcc\uef58\uf104\uef5b\uefc6\uef52\uefc1\uef52\uf105\uf102\uef79\uef5b\uef7c\uefb7\uefab\uefb8\uef7a\uefa5\uefa0\uf0ff\uefa8\uefb2\uf102\uefcc\uefba\uf108\uefbf\uefb5\uefa6\uefc3\uef7c\uef52\uf0ff\uefb5\uefa4\uefc2\uefc0\uef5c\uefbf\uf104\uefa0\uef5e\uefbf\uefab\uefbc\uefbc\uef5e\uef5c\uefc1\uef5e\uef51\uefb8\uefa8\uefc5\uefc5\uefcc\uef7a\uefab\uef5b\uefc6\uefba\uefb5\uefc1\uef7a\uef5c\uefc6\uef53\uefa6\uefbb\uefac\uef4f\uef9f\uef58\uef5b\uef52\uefc5\uf102\uef5c\uef5c\uefb1\uefa2\uef57\uef59\uefac\uefb5\uef5c\uefc2\uefc4\uefc1\uefc2\uef5a\uef5e\uefb3\uefb5\uefc3\uefc8\uef5a\uef5b\uef53\uefa2\uef7c\uefbe\uefb3\uef7c\uefaf\uef5c\uef7c\uefb1\uef51\uf103\uefbd\uefa4\uefc2\uefa5\uefa8\uefa3\uefab\uefb1\uef5c\uefac\uefb8\uefc2\uefc0\uefb7\uefb3\uef5a\uef9e\uf10b\uf102\uefc2\uefbd\uef9f\uef79\uefbd\uef5a\uef9e\uefab\uefc8\uefb4\uefb7\uefa0\uf104\uef7a\uefa1\uefaf\uef58\uefab\uf104\uefc2\uefa5\uef53\uef5e\uef55\uef5a\uef4f\uf105\uefa5\uef79\uefc1\uefa5\uefb9\uefa5\uef58\uefcc\uf102\uefbd\uf108\uf101\uefbc\uf104\uefb8\uefc6\uefab\uefbd\uef5e\uef5b\uefa0\uefb5\uef51\uf101\uefa1\uefc5\uf108\uefb2\uefc6\uefb9\uefc5\uf106\uefa3\uefb7\uef52\uefc3\uf105\uefc5\uefb5\uef5c\uefb8\uefa6\uef5e\uef7a\uefc2\uefa4\uefc2\uefb7\uefbc\uefa8\uef5b\uf102\uefb2\uef58\uef9e\uefba\uef9e\uf108\uefba\uefa0\uef9d\uef52\uf10b\uefa5\uefc4\uefba\uefb5\uf108\uf106\uef57\uefba\uefaf\uefa5\uefb2\uf103\uefc8\uefa0\uefa8\uef79\uefb3\uefac\uef7c\uef5e\uef58\uef9d\uf106\uefc5\uefb4\uefa6\uefc5\uefa6\uefa2\uefb8\uf106\uf101\uefb1\uefa1\uefba\uf103\uef52\uef5a\uef55\uefa2\uefba\uefc8\uefb2\uefbe\uef54\uef5a\uefa1\uf106\uef9e\uefc0\uef7a\uefb4\uefc8\uef4f\uefb2\uefc4\uf106\uefcc\uefbf\uefb5\uefac\uefb7\uf108\uefbe\uefa3\uef59\uef7c\uefc3\uef55\uefc4\uefa3\uefa3\uef4f\uef79\uf102\uf102\uef52\uefc6\uefc2\uefc3\uefa4\uef54\uefa8\uefa2\uefb2\uefa2\uefc2\uef5c\uefa5\uefcc\uef7c\uefa6\uef79\uefac\uf103\uefa1\uef7a\uefbb\uef58\uef7c\uef57\uefa0\uefa0\uef5c\uefb2\uef54\uefb4\uefba\uef51\uefb4\uef7a\uef4f\uf108\uefa0\uefa3\uef52\uf102\uf102\uef5e\uefba\uef5b\uef79\uef5a\uefc6\uf105\uefc5\uef58\uefa1\uefc0\uefc0\uef7c\uef55\uef7c\uefb2\uf103\uefa2\uefb5\uef57\uf104\uf104\uf106\uefab\uefa1\uef57\uef5a\uefa6\uf105\uef9f\uef5c\uefc8\uefbb\uef9f\uefa6\uefa3\uefb9\uef5e\uefa5\uefa2\uef79\uefa3\uefaf\uefa0\uefc3\uefbb\uef9d\uefbc\uefb7\uefc6\uf106\uefb6\uef52\uefb8\uef9d\uefa5\uf106\uef79\uefbb\uf106\uef59\uef5e\uefab\uf105\uefb8\uef9f\uefb3\uefbc\uefcc\uefb8\uefc4\uef5a\uef79\uef51\uefb2\uefbb\uef56\uef7a\uefb3\uf0ff\uef54\uef51\uef57\uefbe\uefb3\uefb5\uefb3\uef79\uef58\uf10b\uefb1\uef79\uf104\uef51\uef54\uefc2\uefa1\uef52\uef56\uef57\uefb2\uefbd\uf101\uefbc\uef51\uefa3\uef58\uef57\uf101\uefa4\uefbd\uef54\uefb2\uef57\uefbd\uefbd\uef56\uf0ff\uefcc\uefbe\uefa3\uef5e\uefb8\uefa1\uefb6\uefc5\uefc8\uf106\uef79\uefc0\uefbe\uef79\uf102\uef9d\uefc2\uefbe\uefa2\uef5b\uefc6\uef54\uefaf\uefc4\uefa2\uefb2\uef57\uefb4\uefb1\uefc1\uef4f\uefc8\uefa8\uefa3\uefc4\uf103\uefaf\uefbb\uefa8\uefac\uefc6\uefa0\uefa3\uef56\uefbe\uefb8\uefb7\uf103\uf103\uef9f\uef56\uf101\uefa0\uef9f\uefa3\uefc5\uefc3\uf103\uefac\uef5a\uefbf\uefa8\uefb1\uefb1\uefa6\uefb2\uefb2\uefc1\uefc2\uf106\uf105\uefba\uefbd\uefb4\uefa8\uefc2\uf102\uf102\uefb6\uefc4\uefac\uefb1\uef59\uef57\uef4f\uf103\uef7a\uefc5\uefba\uefcc\uf104\uef79\uef7c\uefa1\uf108\uefba\uefc4\uef9d\uef59\uefbd\uefbd\uefc4\uefb3\uf106\uefbe\uefb2\uef5c\uefb2\uefb9\uefb2\uf108\uefb3\uefbe\uf10b\uef53\uef7a\uefa4\uef51\uef58\uefbe\uef5a\uef59\uefb7\uefc3\uef56\uefb8\uefb2\uef4f\uef59\uefa6\uef9e\uefa5\uef55\uefaf\uefa3\uf104\uefc1\uef53\uef7c\uefa6\uef57\uefac\uf103\uef79\uefbc\uefb1\uefbe\uefa2\uefac\uefa1\uefa0\uefa2\uef9f\uefbf\uefa3\uefac\uef52\uef4f\uefc6\uefb5\uef51\uf106\uef9d\uefa1\uefa2\uef5a\uefab\uf105\uef53\uefb2\uefc0\uef5c\uef57\uefa0\uefba\uef58\uef5e\uef7a\uef5e\uefa6\uefbb\uefac\uefa6\uef79\uefc0\uef52\uef58\uef7a\uef5b\uef7c\uef54\uefb2\uefbf\uef51\uefa5\uef58\uef58\uef4f\uf102\uf105\uefc1\uef4f\uefbf\uef53\uefbb\uefb9\uefb8\uefb3\uf106\uef56\uef5b\uef4f\uefab\uefbe\uefbc\uef7c\uefb2\uefc6\uefa8\uefb5\uefac\uefc8\uf0ff\uf105\uefab\uefc8\uefa3\uf10b\uf108\uefbd\uefc2\uefb6\uef5a\uefbd\uefb1\uefb6\uefb9\uefa0\uf10b\uf108\uf105\uefc3\uef4f\uf106\uf104\uef9d\uefb7\uef7c\uf102\uefb2\uefb8\uefab\uefc5\uefb6\uefc1\uefa5\uefc6\uefbc\uef57\uef9d\uf106\uf101\uf108\uefa4\uef57\uefa3\uef7a\uefa0\uefa3\uefbb\uef57\uef53\uefc4\uefb7\uef5c"
            .toCharArray();

         for (int var158 = 0; var158 < 5696; var158++) {
            var149 = ((char[])var129)[var158];
            var149 += 24737;
            var149 -= 26306;
            var149 ^= 10755;
            var149 -= 33637;
            var149 -= 11561;
            var149 += 60265;
            var149 += 61066;
            var149 += 28783;
            var149 ^= 48818;
            var149 -= 8339;
            var149 ^= 55828;
            var149 += 12277;
            var149 += 46877;
            ((char[])var129)[var158] = (char)var149;
         }

         var10003 = mth_0OOOoo00o0_8()[0] = new String((char[])var129);
      }

      var10000[2] = (String)var10003;
      var103 = ((String)o0Oo000O0oO(var10000)).toCharArray();
      int limit = 4242;
      int i = 0;

      while (i < limit) {
         char[] var180 = (char[])var103;
         int var10001 = i;
         i = i + 1;
         int var95_lo = var180[var10001];
         char[] var181 = (char[])var103;
         var10001 = i;
         i = i + 1;
         int var133_hi = var181[var10001];
         int limit2 = var95_lo << 16 | var133_hi;
         var128 = new char[limit2];

         for (int j = 0; j < limit2; j++) {
            ((char[])var128)[j] = ((char[])var103)[i + j];
         }

         var10001 = var116_hi;
         var116_hi++;
         o0Oo000O0oO[var10001] = new String((char[])var128);
         i = i + limit2;
      }

      mB = false;
      og = (float)Math.sqrt(3.0);
      oh = (float)Math.sqrt(5.0);
   }

   public static Object o0Oo000O0oO(Object[] var0) {
       try {
          Object var43 = null;
          Object var44 = null;
          Object var45 = null;
          Object var46 = null;
          int var48 = 0;
          Object var49 = null;
          Object var50 = null;
          int var52 = 0;
          Object var53 = null;
          Object var54 = null;
          Object var55 = null;
          Object var56 = null;
          Object var57 = null;
          Object var58 = null;
          Object var59 = null;
          int var60 = 0;
          int var61 = 0;
          Object var62 = null;
          Object var64 = null;
          Object var65 = null;
          Object var66 = null;
          var48 = (Integer)((Object[])var0)[1];
          var55 = (String)((Object[])var0)[2];
          final Object var0a = var0[0];
          Object var10000 = oO00O0OO0ooO;
          if (oO00O0OO0ooO == null) {
             var10000 = oO00O0OO0ooO = new Object[1];
          }

          var10000 = ((Object[])var10000)[var48];
          if (var10000 == null) {
             var10000 = (Object[])var0a;
             if ((Object[])var0a == null) {
                var10000 = fld_0OOOoo00o0_17 = new Object[1];
                var44 = new byte[16];
                ((byte[])var44)[14] = 22;
                ((byte[])var44)[12] = -16;
                ((byte[])var44)[5] = 105;
                ((byte[])var44)[9] = 109;
                ((byte[])var44)[8] = -26;
                ((byte[])var44)[11] = -95;
                ((byte[])var44)[13] = -121;
                ((byte[])var44)[0] = 112;
                ((byte[])var44)[1] = -19;
                ((byte[])var44)[3] = 112;
                ((byte[])var44)[10] = 73;
                ((byte[])var44)[4] = -39;
                ((byte[])var44)[2] = -63;
                ((byte[])var44)[15] = 73;
                ((byte[])var44)[6] = -124;
                ((byte[])var44)[7] = 8;
                ((Object[])var10000)[0] = (byte[])var44;
             }

             var56 = (byte[])((Object[])var10000)[0];
             if (Oo0o00000O00 == null) {
                var59 = new byte[32];
                ((byte[])var59)[26] = -15;
                ((byte[])var59)[6] = -41;
                ((byte[])var59)[24] = -16;
                ((byte[])var59)[28] = -95;
                ((byte[])var59)[22] = -109;
                ((byte[])var59)[20] = -88;
                ((byte[])var59)[1] = -48;
                ((byte[])var59)[15] = 74;
                ((byte[])var59)[12] = 73;
                ((byte[])var59)[9] = 12;
                ((byte[])var59)[25] = -42;
                ((byte[])var59)[5] = -35;
                ((byte[])var59)[18] = 96;
                ((byte[])var59)[27] = 67;
                ((byte[])var59)[23] = 27;
                ((byte[])var59)[17] = -73;
                ((byte[])var59)[21] = -1;
                ((byte[])var59)[13] = 10;
                ((byte[])var59)[3] = 102;
                ((byte[])var59)[7] = -59;
                ((byte[])var59)[29] = 68;
                ((byte[])var59)[31] = -61;
                ((byte[])var59)[14] = 91;
                ((byte[])var59)[30] = -94;
                ((byte[])var59)[10] = -118;
                ((byte[])var59)[11] = -128;
                ((byte[])var59)[0] = -77;
                ((byte[])var59)[4] = 15;
                ((byte[])var59)[8] = -99;
                ((byte[])var59)[16] = -21;
                ((byte[])var59)[19] = 31;
                ((byte[])var59)[2] = 97;
                var62 = new byte[((byte[])var56).length + ((byte[])var59).length];
                System.arraycopy((byte[])var56, 0, (byte[])var62, 0, ((byte[])var56).length);
                System.arraycopy((byte[])var59, 0, (byte[])var62, ((byte[])var56).length, ((byte[])var59).length);
                var10000 = mth_0OOOoo00o0_8()[1];
                if (var10000 == null) {
                   var58 = "殂樴樫樮樰樤歿殉歞殊横殅殑殓殃横樱模".toCharArray();

                   for (int var76 = 0; var76 < 18; var76++) {
                      var61 = ((char[])var58)[var76];
                      var61 -= 32577;
                      var61 += 10482;
                      var61 += 35189;
                      var61 += 58117;
                      var61 ^= 31801;
                      var61 ^= 25194;
                      var61 ^= 26878;
                      var61 -= 31598;
                      var61 += 35711;
                      var61 += 63807;
                      ((char[])var58)[var76] = (char)var61;
                   }

                   var10000 = (mth_0OOOoo00o0_8()[1] = new String((char[])var58));
                }

                var66 = SecretKeyFactory.getInstance((String)var10000);
                var50 = new byte[16];
                ((byte[])var50)[3] = 55;
                ((byte[])var50)[10] = -69;
                ((byte[])var50)[12] = -67;
                ((byte[])var50)[9] = 27;
                ((byte[])var50)[7] = -30;
                ((byte[])var50)[0] = -98;
                ((byte[])var50)[14] = 71;
                ((byte[])var50)[4] = -56;
                ((byte[])var50)[6] = 23;
                ((byte[])var50)[2] = -8;
                ((byte[])var50)[8] = 103;
                ((byte[])var50)[13] = 42;
                ((byte[])var50)[1] = -34;
                ((byte[])var50)[11] = 98;
                ((byte[])var50)[15] = 92;
                ((byte[])var50)[5] = 72;
                var49 = new PBEKeySpec(new String((byte[])var62, StandardCharsets.UTF_8).toCharArray(), (byte[])var50, 9, 256);
                var53 = ((SecretKeyFactory)var66).generateSecret((PBEKeySpec)var49).getEncoded();
                byte[] var10002 = (byte[])var53;
                Object var10003 = mth_0OOOoo00o0_8()[2];
                if (var10003 == null) {
                   var65 = "剘凼啶".toCharArray();

                   for (int var122 = 0; var122 < 3; var122++) {
                      var52 = ((char[])var65)[var122];
                      var52 -= 22401;
                      var52 += 29090;
                      var52 ^= 30916;
                      var52 += 30724;
                      var52 ^= 51316;
                      var52 -= 33764;
                      var52 ^= 15030;
                      var52 ^= 43928;
                      var52 += 55129;
                      var52 ^= 27402;
                      var52 += 26013;
                      var52 ^= 42926;
                      ((char[])var65)[var122] = (char)var52;
                   }

                   var10003 = mth_0OOOoo00o0_8()[2] = new String((char[])var65);
                }

                SecretKeySpec var129 = new SecretKeySpec(var10002, (String)var10003);
                Oo0o00000O00 = var129;
             }

             var43 = Base64.getDecoder().decode((String)var55);
             var57 = Arrays.copyOfRange((byte[])var43, 0, 16);
             var46 = Arrays.copyOfRange((byte[])var43, 16, ((byte[])var43).length);
             var10000 = mth_0OOOoo00o0_8()[3];
             if (var10000 == null) {
                var64 = "篢疆篔篰篤篣篤篰繹疌篤篔箖繹繂繭繭繪笏繨".toCharArray();

                for (int var72 = 0; var72 < 20; var72++) {
                   var60 = ((char[])var64)[var72];
                   var60 ^= 33617;
                   var60 += 54899;
                   var60 += 10852;
                   var60 -= 44965;
                   var60 ^= 29429;
                   var60 -= 19704;
                   var60 ^= 15688;
                   var60 += 34841;
                   var60 -= 35435;
                   var60 += 34923;
                   var60 ^= 4060;
                   var60 += 43404;
                   ((char[])var64)[var72] = (char)var60;
                }

                var10000 = (mth_0OOOoo00o0_8()[3] = new String((char[])var64));
             }

             var45 = Cipher.getInstance((String)var10000);
             ((Cipher)var45).init(2, (SecretKey)Oo0o00000O00, new IvParameterSpec((byte[])var57));
             var54 = ((Cipher)var45).doFinal((byte[])var46);
             var10000 = (oO00O0OO0ooO[var48] = new String((byte[])var54, StandardCharsets.UTF_8));
          }

          return var10000;
       } catch (java.security.GeneralSecurityException e) {
           throw new RuntimeException(e);
       }
   }

   public void e(EntityLivingBase var1) {
      Object var66 = null;
      Object var74 = null;
      Object var79 = null;
      var74 = new AttackEvent(var1);
      Client.a.e().d((AttackEvent)var74);
      if (!((AttackEvent)var74).isCancelled() && ((AttackEvent)var74).dc() != null) {
         var79 = ((AttackEvent)var74).dc();
         gu var4 = this.f((EntityLivingBase)var79) ? this.mD : null;
         int flag = var4 != null && this.a((EntityLivingBase)var79, var4) ? 1 : 0;
         gv var6 = flag != 0 ? this.a(var4) : null;
         if (this.eX()) {
            this.ev();
         }

         this.my = Math.max(this.my, 1);
         mB = true;
         if (!this.noSwing.wo() && !ViaLoadingBase.getInstance().getTargetVersion().newerThan(ProtocolVersion.v1_8)) {
            aEg.thePlayer.swingItem();
         }

         if (flag != 0 && !this.rotationMode.wo().getName().equals("Grim")) {
            this.b(var4);
            this.a("forced", var4);
         }

         if (this.keepSprint.wo()
               && (
                  aEg.thePlayer.ae >= 7
                     || !this.e(Velocity.class).isEnabled()
                     || !this.e(Velocity.class).mode.wo().getName().equals("Grim Reduce")
                     || this.e(Velocity.class).mode.wo().getName().equals("Grim Reduce") && !((GrimReduceVelocity)this.e(Velocity.class).mode.wo()).stopSprint.wo()
               )
            || !this.newYouNeedThisToggledOnCurreFake.wo() && this.oldPredictionKeepSprint.wo() && (aEg.thePlayer.ae >= 7 || this.eZ()) && var1 != null) {
            aEg.playerController.syncCurrentPlayItem();
            PacketUtil.l(new C02PacketUseEntity((EntityLivingBase)var79, Action.ATTACK));
            if (this.eC() && this.eX()) {
               var66 = this.k((EntityLivingBase)var79);
               PacketUtil.l(new C02PacketUseEntity((EntityLivingBase)var79, (Vec3)var66));
               PacketUtil.l(new C02PacketUseEntity((EntityLivingBase)var79, Action.INTERACT));
            }

            if (aEg.thePlayer.fallDistance > 0.0F
               && !aEg.thePlayer.onGround
               && !aEg.thePlayer.isOnLadder()
               && !aEg.thePlayer.isInWater()
               && !aEg.thePlayer.isPotionActive(Potion.blindness)
               && aEg.thePlayer.ridingEntity == null) {
               aEg.thePlayer.onCriticalHit((EntityLivingBase)var79);
            }
         } else {
            aEg.playerController.attackEntity(aEg.thePlayer, (EntityLivingBase)var79);
            if (this.eC() && this.eX()) {
               var66 = this.k((EntityLivingBase)var79);
               PacketUtil.l(new C02PacketUseEntity((EntityLivingBase)var79, (Vec3)var66));
               PacketUtil.l(new C02PacketUseEntity((EntityLivingBase)var79, Action.INTERACT));
            }
         }

         if (this.eA()) {
            this.oD = true;
            this.oC = aEg.thePlayer.ticksExisted;
         }

         if (var6 != null) {
            var6.gh();
         }

         if (!this.noSwing.wo() && ViaLoadingBase.getInstance().getTargetVersion().newerThan(ProtocolVersion.v1_8)) {
            aEg.thePlayer.swingItem();
         }

         this.nP.aX();
         this.oa = 0;
         this.oL.put((EntityLivingBase)var79, aEg.thePlayer.ticksExisted);
      }
   }

   public boolean g(EntityLivingBase var1) {
      return var1 != null
         && aEg.thePlayer.fallDistance > 0.0F
         && !aEg.thePlayer.onGround
         && !aEg.thePlayer.isOnLadder()
         && !aEg.thePlayer.isInWater()
         && !aEg.thePlayer.isPotionActive(Potion.blindness)
         && aEg.thePlayer.ridingEntity == null;
   }

   public String i(EntityLivingBase var1) {
      if (!this.eV()) {
         return "disabled";
      } else if (var1 == null) {
         return "no-target";
      } else if (this.mD == null) {
         return "no-plan";
      } else if (!this.eT()) {
         return "no-kb-source";
      } else if (this.mD.pf != var1.getEntityId()) {
         return "target-swap";
      } else if (this.my <= 0 && !this.et()) {
         return "no-attack-window";
      }
      return this.h(var1) ? "crit-priority" : null;
   }

   public void a(String var1, gu var2) {
      Object var51 = null;
      Object var52 = null;
      Object var69 = null;
      if (this.knockbackDisplacementDebug.wo() && aEg.thePlayer != null) {
         if (var2 == null) {
            var51 = String.format("%s hurt=%d", var1, this.jE == null ? -1 : this.jE.hurtTime);
         } else {
            var51 = String.format(
               "%s %s score=%.1f yaw=%.1f pitch=%.1f dist=%.2f hurt=%d",
               var1,
               var2.pk,
               var2.pj,
               var2.pg,
               var2.ph,
               var2.pi,
               this.jE == null ? -1 : this.jE.hurtTime
            );
         }

         if (!((String)var51).equals(this.mE) || aEg.thePlayer.ticksExisted - this.mF >= (-70 ^ -78)) {
            this.mE = (String)var51;
            this.mF = aEg.thePlayer.ticksExisted;
            String var10000 = afi.getPrefix();
            var69 = (String)var51;
            var52 = var10000;
            afi.c((String)var52 + "[KD] " + (String)var69);
         }
      }
   }

   public boolean a(EntityLivingBase var1, double var2) {
      return Math.abs(MathHelper.wrapAngleTo180_float(RotationUtil.y(var1).x - aEg.thePlayer.pl)) <= var2;
   }

   public boolean eY() {
      Object var29 = null;
      Object var37 = null;
      if (!this.weapons.wo()) {
         return true;
      }
      var37 = aEg.thePlayer.getHeldItem();
      if ((ItemStack)var37 == null) {
         return this.fist.wo();
      }
      var29 = ((ItemStack)var37).getItem();
      if ((Item)var29 instanceof ItemSword && this.swords.wo()) {
         return true;
      } else if ((Item)var29 instanceof ItemAxe && this.axes.wo()) {
         return true;
      } else if (!this.extra.wo() || !((Item)var29 instanceof ItemTool) && !((Item)var29 instanceof ItemHoe)) {
         if (this.sharpness.wo() && EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)var37) > 0) {
            return true;
         }
         return this.knockback.wo() && EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, (ItemStack)var37) > 0
            ? true
            : this.fireAspect.wo() && EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)var37) > 0;
      } else {
         return true;
      }
   }

   public Vector2f eQ() {
      return new Vector2f(RotationComponent.bH());
   }

   public void eH() {
      Object var58 = null;
      var58 = this.eD();
      int flag = ((int[])var58)[0] != -1 && ((int[])var58)[1] == -1 ? 1 : 0;
      if (this.oG) {
         if (!this.lV.wo().getName().equals("Watchdog")) {
            this.oG = false;
         } else if (flag == 0 || !this.fallbackToWatchdog.wo()) {
            if (!nQ || this.ez()) {
               this.mz = false;
               this.oG = false;
               this.lV.getModes().stream().filter(var0 -> var0.getName().equals("Dual Sword")).findFirst().ifPresent(this.lV::update);
               int var10000 = ((int[])var58)[1];
            }
         }
      } else if (this.eA() && this.fallbackToWatchdog.wo() && flag != 0) {
         this.q(true);
         this.oE = false;
         this.lV.getModes().stream().filter(var0 -> var0.getName().equals("Watchdog")).findFirst().ifPresent(this.lV::update);
         this.oG = true;
      }
   }

   public gv a(gu var1) {
      Object var7 = null;
      float var8 = 0.0F;
      if (var1 != null && aEg.thePlayer != null) {
         var7 = new gv(
            aEg.thePlayer.pl,
            aEg.thePlayer.rotationPitch,
            aEg.thePlayer.rotationYawHead,
            aEg.thePlayer.po,
            aEg.thePlayer.pp,
            aEg.thePlayer.pq,
            aEg.thePlayer.pr
         );
         var8 = this.eU();
         aEg.thePlayer.pl = var1.pg;
         aEg.thePlayer.rotationPitch = var8;
         aEg.thePlayer.rotationYawHead = var1.pg;
         aEg.thePlayer.po = var8;
         aEg.thePlayer.pp = var1.pg;
         aEg.thePlayer.pq = var1.pg;
         aEg.thePlayer.pr = var1.pg;
         return (gv)var7;
      }
      return null;
   }

   public boolean em() {
      Object var12 = null;
      var12 = this.e(Piercing.class);
      int var10000;
      if (!this.rayCast.wo() || !this.throughWalls.wo() && ((Piercing)var12 == null || !((Piercing)var12).isEnabled())) {
         int var5 = 112;
         var5 = (byte)-70;
         var5 -= -70;
         var10000 = var5;
      } else {
         var10000 = 1;
      }

      return var10000 != 0;
   }

   public void p(boolean var1) {
      if (nQ && (!var1 || !cK)) {
         PacketUtil.l(new C07PacketPlayerDigging(net.minecraft.network.play.client.C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
         nQ = false;
      }

      if (aEg.gameSettings.cgI.isKeyDown()) {
         SlotComponent var10000 = this.d(SlotComponent.class);
         if (SlotComponent.getItemStack() != null) {
            var10000 = this.d(SlotComponent.class);
            boolean var3 = SlotComponent.getItemStack().getItem() instanceof ItemSword;
         }
      }
   }

   public Vector2f c(EntityLivingBase var1) {
      return this.a(var1, this.range.wo().doubleValue(), this.em());
   }

   public void packetBlock(PacketSendEvent var1) {
      Object var36 = null;
      Object var39 = null;
      var39 = var1.dq();
      var36 = this.lV.wo().getName();
      int var41_hi = -1;
      switch (((String)var36).hashCode()) {
         case -2099899231:
            if (((String)var36).equals("Intave")) {
               var41_hi = 0;
            }
         default:
            switch (var41_hi) {
               case 0:
                  if ((Packet)var39 instanceof C03PacketPlayer && this.jE != null) {
                     var1.setCancelled();
                     this.p(false);
                     PacketUtil.m((Packet<?>)var39);
                     this.block(false, (130 + -20 ^ 111) != 0);
                     this.p(false);
                  }
            }
      }
   }

   public boolean p(int var1) {
      Object var24 = null;
      if (this.eA() && this.hideSecondSword.wo()) {
         var24 = this.eD();
         return ((int[])var24)[1] != -1 && var1 == ((int[])var24)[1];
      }
      return false;
   }

   public void ej() {
      this.nV.sort((var0, var1) -> {
         int name = (int)(bx.n(var0.getName()) ? 1L : 0L);
         int name2 = (int)(bx.n(var1.getName()) ? 1L : 0L);
         if (name != 0 && name2 == 0) {
            return -1;
         }
         return name == 0 && name2 != 0 ? -65 - -89 ^ 25 : 0;
      });
   }

   public boolean eA() {
      return this.lV.wo().getName().equals("Dual Sword");
   }

   public void q(boolean var1) {
      if (aEg.thePlayer == null) {
         this.oB = -1;
         nQ = false;
      } else {
         int currentItem2 = aEg.thePlayer.inventory.currentItem;
         int flag = var1 && this.oB != -1 && this.oB != currentItem2 && !SlotComponent.dj ? 1 : 0;
         if (flag != 0) {
            SlotComponent.b(currentItem2, false);
            nQ = false;
         } else if (nQ) {
            this.p(false);
         }

         this.oB = -1;
      }
   }

   public boolean eV() {
      return this.knockbackDisplacement.wo();
   }

   public void eu() {
      if (this.eR()) {
         if (this.advancedSwing.wo() && !this.noSwing.wo()) {
            aEg.thePlayer.swingItem();
            this.nP.aX();
         }
      }
   }

   public void ei() {
      double var37 = 0.0;
      Object var43 = null;
      var37 = this.range.wo().doubleValue();
      this.nV = bv.f(var37);
      if (this.mode.wo().getName().equals("Switch")) {
         this.nV.removeAll(this.oK);
      }

      if (this.nV.isEmpty()) {
         this.oK.clear();
         this.nV = bv.f(var37 + this.nX);
      }

      if (this.fOV.wo().doubleValue() < 360.0) {
         var43 = this.fOV.wo().doubleValue() / 2.0;
         final double var43a = (Double)var43;
         this.nV.removeIf(var3 -> !this.a(var3, var43a));
      }

      var43 = this.sorting.wo().getName();
      int var31_hi = -1;
      switch (((String)var43).hashCode()) {
         case -2137395588:
            if (((String)var43).equals("Health")) {
               var31_hi = 0;
            }
            break;
         case -2087977922:
            if (((String)var43).equals("Hurt Time")) {
               var31_hi = 1;
            }
      }

      switch (var31_hi) {
         case 0:
            this.nV.sort(Comparator.comparingDouble(EntityLivingBase::getHealth));
            this.ej();
            break;
         case 1:
            this.nV.sort(Comparator.comparingDouble(var0 -> var0.hurtTime));
            this.ej();
      }
   }

   public boolean eB() {
      return (!this.eA() && !this.oG ? -189 + 97 - -92 : 1) != 0;
   }

   public Vec3 k(EntityLivingBase var1) {
      double var12 = 0.0;
      Object var14 = null;
      Object var15 = null;
      Object var16 = null;
      Object var17 = null;
      if (var1 == null) {
         return new Vec3(0.0, 0.0, 0.0);
      }
      var16 = aEg.thePlayer.getPositionEyes(1.0F);
      var15 = aEg.thePlayer.getVectorForRotation(RotationComponent.fk.getY(), RotationComponent.fk.getX());
      var12 = this.range.wo().doubleValue();
      var17 = ((Vec3)var16).addVector(((Vec3)var15).xCoord * var12, ((Vec3)var15).yCoord * var12, ((Vec3)var15).zCoord * var12);
      var14 = var1.getEntityBoundingBox().expand(0.1, 0.1, 0.1).calculateIntercept((Vec3)var16, (Vec3)var17);
      return (MovingObjectPosition)var14 != null && ((MovingObjectPosition)var14).hitVec != null
         ? ((MovingObjectPosition)var14).hitVec.subtract(new Vec3(var1.posX, var1.posY, var1.posZ))
         : new Vec3(0.0, var1.getEyeHeight() * 0.5, 0.0);
   }

   public float b(float var1, float var2) {
      float var10 = 0.0F;
      float var11 = 0.0F;
      if (var1 <= 0.0F) {
         return 0.0F;
      }
      var10 = Math.max(1.0E-4F, Math.abs(var2));
      if ((float)(this.od.nextGaussian() * var1) > var10) {
         var11 = var10;
      }

      if (var11 < -var10) {
         var11 = -var10;
      }

      return var11;
   }

   public boolean a(MovingObjectPosition var1, EntityLivingBase var2) {
      return var1 != null && var1.typeOfHit == MovingObjectType.ENTITY && var1.entityHit == var2;
   }

   public void el() {
      Object var133 = null;
      Object var134 = null;
      Object var143 = null;
      Object var144 = null;
      Object var162 = null;
      Object var170 = null;
      Object var171 = null;
      float var179 = 0.0F;
      Object var181 = null;
      Object var184 = null;
      Object var186 = null;
      var179 = this.rotationSpeed.wv().floatValue();
      if (!this.eR()) {
         this.eW();
      }

      var133 = this.rotationMode.wo().getName();
      int var167_hi = -1;
      switch (((String)var133).hashCode()) {
         case -1631405611:
            if (((String)var133).equals("Autistic AntiCheat")) {
               var167_hi = 3;
            }
            break;
         case -654193598:
            if (((String)var133).equals("Advanced")) {
               var167_hi = 4;
            }
            break;
         case 77115:
            if (((String)var133).equals("NCP")) {
               var167_hi = 1;
            }
            break;
         case 2228079:
            if (((String)var133).equals("Grim")) {
               var167_hi = 5;
            }
            break;
         case 2581482:
            if (((String)var133).equals("Snap")) {
               var167_hi = 2;
            }
            break;
         case 1951303741:
            if (((String)var133).equals("Legit/Normal")) {
               var167_hi = 0;
            }
      }

      switch (var167_hi) {
         case 0:
            var171 = this.c(this.jE);
            var171 = this.a(this.jE, (Vector2f)var171);
            if (var179 != 0.0F) {
               RotationComponent.a(
                  (Vector2f)var171, var179, this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(), var1 -> {
                     nS = RotationUtil.a(var1, this.jE, this.range.wo().doubleValue(), this.em(), this.en());
                     return nS;
                  }, this.silentRotations.wo()
               );
            }
            break;
         case 1:
            int random2 = (int)(Math.random() * 1.0);
            var143 = new aka(this.jE.posX, this.jE.posY, this.jE.posZ);
            var144 = new aka(aEg.thePlayer.posX, aEg.thePlayer.posY, aEg.thePlayer.posZ);
            var162 = MoveUtil.a(this.jE, new Vector2f(0.0F, 1.0F), random2, aEg.thePlayer.isSprinting());
            this.jE.setPosition(((aka)var162).x, ((aka)var162).y, ((aka)var162).z);
            aEg.thePlayer
               .setPosition(
                  aEg.thePlayer.posX + aEg.thePlayer.motionX * random2,
                  aEg.thePlayer.posY + (aEg.thePlayer.motionY + 0.17) * random2,
                  aEg.thePlayer.posZ + aEg.thePlayer.motionZ * random2
               );
            var181 = RotationUtil.m(this.c(this.jE));
            this.jE.setPosition(((aka)var143).x, ((aka)var143).y, ((aka)var143).z);
            aEg.thePlayer.setPosition(((aka)var144).x, ((aka)var144).y, ((aka)var144).z);
            var181 = this.a(this.jE, (Vector2f)var181);
            if (var179 != 0.0F) {
               if (Math.random() > 0.1) {
                  RotationComponent.a(
                     (Vector2f)var181,
                     var179,
                     this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(),
                     null,
                     this.silentRotations.wo()
                  );
               } else {
                  RotationComponent.a(
                     (Vector2f)var181,
                     var179,
                     this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(),
                     null,
                     this.silentRotations.wo()
                  );
               }
            }
            break;
         case 2:
            var184 = this.a(this.jE, this.c(this.jE));
            if (var179 != 0.0F && this.et()) {
               RotationComponent.d(false);
               RotationComponent.a(
                  (Vector2f)var184,
                  var179,
                  this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(),
                  null,
                  this.silentRotations.wo()
               );
            } else {
               RotationComponent.d(false);
            }
            break;
         case 3:
            var170 = this.a(this.jE, this.c(this.jE));
            var134 = aef.a((Vector2f)var170, this.range.wo().floatValue(), this.en(), aEg.thePlayer, this.em());
            int flag = (MovingObjectPosition)var134 != null && ((MovingObjectPosition)var134).entityHit == this.jE ? 1 : 0;
            int var155_hi = 1;
            if (this.rayCast.wo()) {
               var186 = aef.a((Vector2f)var170, this.range.wo().floatValue(), this.en(), aEg.thePlayer, this.em());
               var155_hi = (MovingObjectPosition)var186 != null && ((MovingObjectPosition)var186).entityHit == this.jE ? 1 : 0;
            }

            if (var179 != 0.0F && this.et() && flag != 0 && var155_hi != 0 && this.rayCast.wo()) {
               RotationComponent.d(false);
               RotationComponent.a(
                  (Vector2f)var170,
                  var179,
                  this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(),
                  null,
                  this.silentRotations.wo()
               );
            } else {
               RotationComponent.d(false);
               RotationComponent.a(
                  new Vector2f(RotationComponent.fk.x + var179 * 10.0F, 90.0F),
                  var179 * 10.0F / 18.0F,
                  this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(),
                  null,
                  this.silentRotations.wo()
               );
            }
            break;
         case 4:
            var186 = this.a(this.jE, this.eN());
            if (var179 != 0.0F) {
               RotationComponent.a(
                  this.b((Vector2f)var186),
                  var179,
                  this.movementCorrection.wo() == MovementFix.OFF ? MovementFix.OFF : this.movementCorrection.wo(),
                  null,
                  this.silentRotations.wo()
               );
            }
            break;
         case 5:
            this.nt = this.a(this.jE, this.c(this.jE));
      }
   }

   public Vector2f a(EntityLivingBase var1, Vector2f var2) {
      Object var14 = null;
      Object var15 = null;
      var14 = this.i(var1);
      if ((String)var14 != null) {
         var15 = (String)var14;
         this.a("rejected:" + (String)var15, this.mD);
         return var2;
      }
      this.a("applied", this.mD);
      return new Vector2f(this.mD.pg, var2.getY());
   }

   public static Object[] mth_0OOOoo00o0_8() {
      Object[] var10000 = fld_0oOOoOo0O00O_18;
      if (fld_0oOOoOo0O00O_18 == null) {
         var10000 = fld_0oOOoOo0O00O_18 = new Object[4];
      }

      return var10000;
   }

   public gu j(EntityLivingBase var1) {
      double var35 = 0.0;
      Object var40 = null;
      Object var44 = null;
      double var47 = 0.0;
      Object var49 = null;
      double var52 = 0.0;
      var44 = var1.getEntityBoundingBox();
      gu var3 = null;

      for (int i = 0; i < 32; i++) {
         var52 = (Math.PI * 2) * i / 32.0;
         var35 = -Math.sin(var52);
         var47 = Math.cos(var52);

         for (double var59 = 0.8; var59 <= 5.0; var59 += 0.35) {
            var49 = ((AxisAlignedBB)var44).offset(var35 * var59, 0.0, var47 * var59);
            var40 = this.a(var1, (AxisAlignedBB)var49, var35, var47, var59);
            if ((gu)var40 != null && (var3 == null || ((gu)var40).pj > var3.pj)) {
               var3 = (gu)var40;
            }

            if (!aEg.theWorld.getCollidingBoundingBoxes(var1, ((AxisAlignedBB)var49).contract(0.02, 0.0, 0.02)).isEmpty()) {
               break;
            }
         }
      }

      return var3 != null && var3.pj >= 45.0 ? var3 : null;
   }

   public boolean eR() {
      boolean var10000;
      if (this.rotationMode.wo() != null && "Advanced".equals(this.rotationMode.wo().getName())) {
         var10000 = true;
      } else {
         byte var6 = -123;
         var6 = -124;
         boolean var8 = false;
         var10000 = var8;
      }

      return var10000;
   }
}
