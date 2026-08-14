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
import hackclient.rise.ao;
import hackclient.rise.ap;
import hackclient.rise.aq;
import hackclient.rise.aw;
import hackclient.rise.ax;
import hackclient.rise.ay;
import hackclient.rise.az;
import hackclient.rise.ba;
import hackclient.rise.bb;
import hackclient.rise.bc;
import hackclient.rise.bd;
import hackclient.rise.be;
import hackclient.rise.bf;
import hackclient.rise.bg;
import hackclient.rise.bj;
import hackclient.rise.bk;
import hackclient.rise.bo;
import hackclient.rise.bq;
import hackclient.rise.bt;
import hackclient.rise.bv;
import hackclient.rise.ca;
import hackclient.rise.cf;
import hackclient.rise.cg;
import hackclient.rise.ci;
import hackclient.rise.cl;
import hackclient.rise.cu;
import hackclient.rise.cx;
import hackclient.rise.cy;
import hackclient.rise.da;
import hackclient.rise.db;
import hackclient.rise.dd;
import hackclient.rise.de;
import hackclient.rise.df;
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
        this.a(new ay());
        this.a(new az());
        this.a(new ba());
        this.a(new bb());
        this.a(new bc());
        this.a(new be());
        this.a(new bg());
        this.a(new LastConnectionComponent());
        this.a(new bj());
        this.a(new PingSpoofComponent());
        this.a(new BlinkComponent());
        this.a(new RotationComponent());
        this.a(new bt());
        this.a(new SlotComponent());
        this.a(new cf());
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
        this.a(new bd());
        this.a(new bv());
        this.a(new ap());
        this.a(new bk());
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
