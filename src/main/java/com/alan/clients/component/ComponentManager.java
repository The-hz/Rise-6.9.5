package com.alan.clients.component;

import com.alan.clients.Client;
import com.alan.clients.component.impl.event.EntityKillEventComponent;
import com.alan.clients.component.impl.hud.DragComponent;
import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.alan.clients.component.impl.player.PingSpoofComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.component.impl.render.NotificationComponent;
import com.alan.clients.component.impl.render.ProjectionComponent;
import com.alan.clients.component.impl.viamcp.BlockPlacementFixComponent;
import com.alan.clients.component.impl.viamcp.HitboxFixComponent;
import com.alan.clients.component.impl.viamcp.MinimumMotionFixComponent;
import hackclient.rise.component.ao;
import hackclient.rise.component.ap;
import hackclient.rise.component.aq;
import hackclient.rise.component.aw;
import hackclient.rise.component.ax;
import com.alan.clients.component.impl.packetlog.PacketLogComponent;
import hackclient.rise.component.az;
import hackclient.rise.component.ba;
import com.alan.clients.component.impl.player.BadPacketsComponent;
import hackclient.rise.component.bc;
import com.alan.clients.component.impl.player.FallDistanceComponent;
import com.alan.clients.component.impl.player.GUIDetectionComponent;
import hackclient.rise.bf;
import com.alan.clients.component.impl.player.ItemDamageComponent;
import hackclient.rise.component.bj;
import com.alan.clients.component.impl.player.PacketlessDamageComponent;
import hackclient.rise.bo;
import hackclient.rise.component.bq;
import com.alan.clients.component.impl.player.SelectorDetectionComponent;
import hackclient.rise.component.bv;
import hackclient.rise.component.ca;
import com.alan.clients.component.impl.render.ESPComponent;
import hackclient.rise.cg;
import hackclient.rise.component.ci;
import hackclient.rise.cl;
import hackclient.rise.cu;
import hackclient.rise.component.cx;
import hackclient.rise.component.cy;
import hackclient.rise.component.da;
import hackclient.rise.component.db;
import hackclient.rise.component.dd;
import hackclient.rise.component.de;
import hackclient.rise.component.df;
import java.util.HashMap;
import java.util.Map;

public class ComponentManager {
    public Map<Class<Component>, Component> bx = new HashMap<>();

    public ComponentManager() {
    }

    public void init() {
        this.a(new EntityKillEventComponent());
        this.a(new ao());
        this.a(new aq());
        this.a(new DragComponent());
        this.a(new ax());
        this.a(new aw());
        this.a(new PacketLogComponent());
        this.a(new az());
        this.a(new ba());
        this.a(new BadPacketsComponent());
        this.a(new bc());
        this.a(new GUIDetectionComponent());
        this.a(new ItemDamageComponent());
        this.a(new LastConnectionComponent());
        this.a(new bj());
        this.a(new PingSpoofComponent());
        this.a(new BlinkComponent());
        this.a(new RotationComponent());
        this.a(new SelectorDetectionComponent());
        this.a(new SlotComponent());
        this.a(new ESPComponent());
        this.a(new cg());
        this.a(new bf());
        this.a(new NotificationComponent());
        this.a(new ci());
        this.a(new ProjectionComponent());
        this.a(new cl());
        this.a(new BlockPlacementFixComponent());
        this.a(new cy());
        this.a(new HitboxFixComponent());
        this.a(new db());
        this.a(new MinimumMotionFixComponent());
        this.a(new FallDistanceComponent());
        this.a(new bv());
        this.a(new ap());
        this.a(new PacketlessDamageComponent());
        this.a(new cx());
        this.a(new df());
        this.a(new de());
        this.a(new dd());
        this.a(new ca());
        this.a(new da());
        this.a(new bo());
        this.a(new bq());
        this.a(new cu());
        this.bx.forEach((var0, var1) -> Client.a.e().b(var1));
        this.bx.forEach((var0, var1) -> var1.aT());
    }

    public void a(Component var1) {
        this.bx.put((Class<Component>)var1.getClass(), var1);
    }

    public <T extends Component> T b(Class<T> var1) {
        return (T)this.bx.get(var1);
    }
}
