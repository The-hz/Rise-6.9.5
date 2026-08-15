package com.alan.clients.module.impl.other;

import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ClickEvent;
import com.alan.clients.newevent.impl.input.GuiClickEvent;
import com.alan.clients.newevent.impl.input.GuiMouseReleaseEvent;
import com.alan.clients.newevent.impl.input.MoveInputEvent;
import com.alan.clients.newevent.impl.motion.JumpEvent;
import com.alan.clients.newevent.impl.motion.PostMotionEvent;
import com.alan.clients.newevent.impl.motion.PostStrafeEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.motion.PreUpdateEvent;
import com.alan.clients.newevent.impl.motion.StrafeEvent;
import com.alan.clients.newevent.impl.motion.WaterEvent;
import com.alan.clients.newevent.impl.other.AttackEvent;
import com.alan.clients.newevent.impl.other.BlockAABBEvent;
import com.alan.clients.newevent.impl.other.TeleportEvent;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.newevent.impl.render.MouseOverEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.newevent.impl.render.Render3DEvent;
import com.alan.clients.util.player.MoveUtil;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.value.impl.DragValue;
import com.alan.clients.value.impl.StringValue;
import hackclient.rise.adz;
import hackclient.rise.aef;
import hackclient.rise.afi;
import com.alan.clients.util.packet.TimedPacket;
import hackclient.rise.ahp;
import com.alan.clients.util.player.PlayerUtil;
import hackclient.rise.aka;
import hackclient.rise.akj;
import hackclient.rise.sv;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import net.minecraft.block.BlockSlime;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Tuple;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import rip.vantage.commons.util.time.a;

@ModuleInfo(aliases={"module.other.test.name"}, description="module.other.test.description", category=Category.MOVEMENT)
public final class Test
extends Module {
    private final ArrayList<Integer> Ya = new ArrayList();
    private final ArrayList<Double> Yb = new ArrayList();
    private final ArrayList<Float> Yc = new ArrayList();
    private final ArrayList<Packet<?>> Yd = new ArrayList();
    private final ArrayList<Packet<?>> Ye = new ArrayList();
    private int ug;
    private int LM;
    private boolean Eo;
    private boolean LL;
    private boolean yc;
    private double Yf;
    private double Yg;
    private double Hy;
    private double Hz;
    private double HA;
    private float Yh;
    private float Yi;
    private Vec3 Yj;
    private Vec3 Yk;
    private Vec3 Yl;
    private Entity entity;
    private Packet<?> aPacket;
    private EntityOtherPlayerMP otherEntity;
    private final List<Packet<?>> Yo = new ArrayList();
    private final ConcurrentLinkedQueue<TimedPacket> timedPackets = new ConcurrentLinkedQueue();
    private final a Yq = new a();
    private double Yr;
    private double cl;
    private double xv;
    private double y;
    private double at;
    private double au;
    private double av;
    private int FX;
    private int Ys;
    public static boolean zK;
    public static boolean Yt;
    private BlockPos Yu;
    private final DecimalFormat format = new DecimalFormat("0.0");
    private Vec3 Yw;
    private BlockPos Yx;
    private final DragValue positionValue = new DragValue("Position", (Module)this, new Vector2d(255.0, 255.0));
    public Vec3 Jd = new Vec3(0.0, 0.0, 0.0);
    private final StringValue runIf = new StringValue("Run If () ->", (Module)this, "onGround");
    private final akj YA = new akj("Test Curve", this);
    private final ArrayList<Entity> YB = new ArrayList();
    private final ArrayList<aka> YC = new ArrayList();
    private World world;
    private boolean Lw;
    private double Lx;
    private boolean YD;
    Executor threadPool = Executors.newFixedThreadPool(1);
    ahp YF;
    EntityPlayerSP YG;
    adz<BlockPos> YH = new adz(2);
    private final HashMap<Double, HashMap<Integer, Tuple<Double, Boolean>>> YI = new HashMap();
    private Runnable YJ;
    private Runnable YK;
    List<Vector2d> YL = new ArrayList<Vector2d>();
    Vector2d YM = null;
    @EventLink
    public final Listener<MouseOverEvent> onMouseOver = mouseOverEvent -> {
        this.YD = true;
    };
    @EventLink(value=0)
    public final Listener<PacketReceiveEvent> receive = packetReceiveEvent -> {
        this.YD = true;
        Packet<?> packet = packetReceiveEvent.getPacket();
        if (packet instanceof S20PacketEntityProperties) {
            Iterator iterator = ((S20PacketEntityProperties)packet).func_149441_d().iterator();
            while (iterator.hasNext()) {
                Iterator iterator2 = ((S20PacketEntityProperties.Snapshot)iterator.next()).func_151408_c().iterator();
                while (iterator2.hasNext()) {
                    if (!((AttributeModifier)iterator2.next()).getID().equals(Test.aEg.thePlayer.getUniqueID())) continue;
                    afi.c("s", new Object[0]);
                }
            }
        }
    };
    @EventLink
    public final Listener<PacketSendEvent> send = packetSendEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<TeleportEvent> teleport = teleportEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<BlockAABBEvent> blockAABB = blockAABBEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<Render2DEvent> render2D = render2DEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<Render3DEvent> render3D = render3DEvent -> {
        this.YD = true;
    };
    private HashMap<Integer, Integer> YU = new HashMap();
    public static double YV;
    @EventLink
    public final Listener<PreUpdateEvent> preUpdate = preUpdateEvent -> {
        this.YD = true;
        Test.aEg.gameSettings.keyBindSneak.setPressed(PlayerUtil.p(0.0, MoveUtil.predictedMotion(Test.aEg.thePlayer.motionY), 0.0) instanceof BlockSlime && Test.aEg.thePlayer.motionY < -0.1);
    };
    @EventLink
    public final Listener<WaterEvent> water = waterEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<AttackEvent> attack = attackEvent -> {
        ++this.LM;
        this.YD = true;
    };
    @EventLink
    public final Listener<WorldChangeEvent> worldChange = worldChangeEvent -> {
        this.Yx = null;
        this.YD = true;
    };
    @EventLink
    public final Listener<PreMotionEvent> onPreMotionEvent = preMotionEvent -> {
        this.YD = true;
        if (Test.aEg.thePlayer.tR == 0) {
            preMotionEvent.setPosY(Test.aEg.thePlayer.posY - 0.01);
        }
    };
    @EventLink
    public final Listener<GuiMouseReleaseEvent> onGuiMouseRelease = guiMouseReleaseEvent -> {
        this.YM = null;
    };
    @EventLink
    public final Listener<GuiClickEvent> onGuiClick = guiClickEvent -> {
        int n2 = guiClickEvent.cL();
        int n3 = guiClickEvent.cM();
        ArrayList<Vector2d> arrayList = new ArrayList<Vector2d>(this.YL);
        arrayList.sort((vector2d, vector2d2) -> (int)(sv.EUCLIDEAN_DISTANCE.a(vector2d.getX() - (double)n2, vector2d.getY() - (double)n3) - sv.EUCLIDEAN_DISTANCE.a(vector2d2.getX() - (double)n2, vector2d2.getY() - (double)n3)));
        this.YM = (Vector2d)arrayList.stream().findFirst().get();
    };
    @EventLink
    public final Listener<ClickEvent> onClick = clickEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<PostMotionEvent> onPostMotionEvent = postMotionEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<TickEvent> onTick = tickEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<StrafeEvent> onStrafe = strafeEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<PostStrafeEvent> onPostStrafe = postStrafeEvent -> {
        this.YD = true;
    };
    public final Listener<JumpEvent> Zi = jumpEvent -> {
        this.YD = true;
    };
    @EventLink
    public final Listener<MoveInputEvent> onMoveInput = moveInputEvent -> {
        this.YD = true;
    };

    @Override
    public void onDisable() {
        double d2 = 0.0;
        for (double d3 : this.Yb) {
            d2 += d3;
        }
        double d4 = d2 / (double)this.Yb.size();
        this.YD = true;
        Test.aEg.gameSettings.keyBindSneak.setPressed(Keyboard.isKeyDown(Test.aEg.gameSettings.keyBindSneak.getKeyCode()));
        Test.aEg.gameSettings.keyBindJump.setPressed(Keyboard.isKeyDown(Test.aEg.gameSettings.keyBindJump.getKeyCode()));
        Test.aEg.gameSettings.keyBindRight.setPressed(Keyboard.isKeyDown(Test.aEg.gameSettings.keyBindRight.getKeyCode()));
        Test.aEg.gameSettings.keyBindLeft.setPressed(Keyboard.isKeyDown(Test.aEg.gameSettings.keyBindLeft.getKeyCode()));
    }

    @Override
    public void onEnable() {
        this.Yb.clear();
        this.YD = true;
        this.Eo = false;
        this.Yx = null;
        this.YH.clear();
        this.ug = 0;
        this.LM = 0;
        this.YL.clear();
        this.YL.add(new Vector2d(100.0, 500.0));
        this.YL.add(new Vector2d(200.0, 100.0));
        this.YL.add(new Vector2d(600.0, 100.0));
        this.YL.add(new Vector2d(700.0, 500.0));
    }

    private void g(List<Vector2d> list) {
        for (Vector2d vector2d : list) {
            RenderUtil.c(vector2d.x, vector2d.y, 3.0, this.rz().rA());
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glLineWidth(2.0f);
        GL11.glBegin(3);
        float f2 = 0.0f;
        while ((double)f2 <= 1.0) {
            Vector2d vector2d = this.a(f2, list);
            GL11.glVertex2f((float)vector2d.x, (float)vector2d.y);
            f2 += 0.01f;
        }
        GL11.glEnd();
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        RenderUtil.color(Color.WHITE);
    }

    private Vector2d a(float f2, List<Vector2d> list) {
        float f3 = 1.0f - f2;
        float f4 = (float)(Math.pow(f3, 3.0) * list.get((int)0).x + 3.0 * Math.pow(f3, 2.0) * (double)f2 * list.get((int)1).x + (double)(3.0f * f3) * Math.pow(f2, 2.0) * list.get((int)2).x + Math.pow(f2, 3.0) * list.get((int)3).x);
        float f5 = (float)(Math.pow(f3, 3.0) * list.get((int)0).y + 3.0 * Math.pow(f3, 2.0) * (double)f2 * list.get((int)1).y + (double)(3.0f * f3) * Math.pow(f2, 2.0) * list.get((int)2).y + Math.pow(f2, 3.0) * list.get((int)3).y);
        return new Vector2d(f4, f5);
    }

    public void run() {
        if (Test.aEg.gameSettings.keyBindSneak.isKeyDown()) {
            this.YU.clear();
        }
        if (aef.c((Vector2f)RotationComponent.fk, (double)15.0).typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY) {
            this.Yh = Test.aEg.thePlayer.pl;
            this.Yi = Test.aEg.thePlayer.rotationPitch;
            return;
        }
        int n4 = (int)Math.round(Math.hypot(Test.aEg.thePlayer.pl - this.Yh, Test.aEg.thePlayer.rotationPitch - this.Yi));
        this.YU.putIfAbsent(n4, 1);
        this.YU.put(n4, this.YU.get(n4) + 1);
        afi.b("Outputted", new Object[0]);
        this.YU.forEach((n2, n3) -> System.out.println(n3 + "\t" + n2));
        this.Yh = Test.aEg.thePlayer.pl;
        this.Yi = Test.aEg.thePlayer.rotationPitch;
    }
}
