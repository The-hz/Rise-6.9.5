package com.alan.clients.script.api;

import com.alan.clients.Client;
import com.alan.clients.command.Command;
import com.alan.clients.component.impl.player.BlinkComponent;
import com.alan.clients.component.impl.player.PingSpoofComponent;
import com.alan.clients.component.impl.player.RotationComponent;
import com.alan.clients.component.impl.player.rotationcomponent.MovementFix;
import com.alan.clients.module.Module;
import com.alan.clients.script.api.wrapper.impl.ScriptBlockPos;
import com.alan.clients.script.api.wrapper.impl.ScriptCommand;
import com.alan.clients.script.api.wrapper.impl.ScriptModule;
import com.alan.clients.script.api.wrapper.impl.vector.ScriptVector2f;
import com.alan.clients.script.api.wrapper.impl.vector.ScriptVector3d;
import com.alan.clients.script.util.ScriptModuleInfo;
import com.alan.clients.util.vector.Vector2f;
import hackclient.rise.afi;
import hackclient.rise.aha;
import hackclient.rise.ahd;
import hackclient.rise.aiu;
import hackclient.rise.aka;
import hackclient.rise.bx;
import hackclient.rise.cg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.script.ScriptException;
import net.minecraft.client.Minecraft;
import org.openjdk.nashorn.api.scripting.JSObject;

public class RiseAPI {
    private static final Map<Module, ScriptModule> SCRIPT_MODULE_MAP = new HashMap<>();
    private static final Map<Command, ScriptCommand> SCRIPT_COMMAND_MAP = new HashMap<>();

    public RiseAPI() {
    }

    private static ScriptModule getModule(Module var0) {
        SCRIPT_MODULE_MAP.putIfAbsent(var0, new ScriptModule(var0, true));
        return SCRIPT_MODULE_MAP.get(var0);
    }

    private static ScriptCommand getCommand(Command var0) {
        SCRIPT_COMMAND_MAP.putIfAbsent(var0, new ScriptCommand(var0));
        return SCRIPT_COMMAND_MAP.get(var0);
    }

    public ScriptModule registerModule(String var1, String var2) {
        AtomicReference atomicreference = new AtomicReference(null);
        RiseAPI$1 riseapi$1 = new RiseAPI$1(this, new ScriptModuleInfo(var1, var2), atomicreference);
        atomicreference.set(getModule(riseapi$1));
        Client.a.g().add(riseapi$1);
        if (Client.a.v() != null) {
            Client.a.v().oS();
        }

        return (ScriptModule)atomicreference.get();
    }

    public ScriptModule[] getModules() {
        ArrayList arraylist = Client.a.g().ef();
        ScriptModule[] ascriptmodule = new ScriptModule[arraylist.size()];

        for (int i = 0; i < arraylist.size(); i++) {
            ascriptmodule[i] = new ScriptModule((Module)arraylist.get(i));
        }

        return ascriptmodule;
    }

    public ScriptModule getModule(String var1) {
        return new ScriptModule(Client.a.g().get(var1));
    }

    public void rotate(float var1, float var2, double var3) {
        RotationComponent.setRotations(new Vector2f(var1, var2), var3, MovementFix.OFF);
    }

    public float[] getRotations(int var1) {
        Vector2f vector2f = aiu.y(Minecraft.getMinecraft().theWorld.getEntityByID(var1));
        return new float[]{vector2f.x, vector2f.y};
    }

    public float[] getRotations(ScriptVector3d var1) {
        Vector2f vector2f = aiu.d(new aka(var1.getX(), var1.getY(), var1.getZ()));
        return new float[]{vector2f.x, vector2f.y};
    }

    public ScriptCommand registerCommand(String var1, String var2) {
        AtomicReference atomicreference = new AtomicReference(null);
        RiseAPI$2 riseapi$2 = new RiseAPI$2(this, var2, new String[]{var1}, atomicreference);
        atomicreference.set(getCommand(riseapi$2));
        Client.a.getCommandManager().aQ().add(riseapi$2);
        return (ScriptCommand)atomicreference.get();
    }

    public ScriptCommand[] getCommands() {
        List list = Client.a.getCommandManager().aQ();
        ScriptCommand[] ascriptcommand = new ScriptCommand[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ascriptcommand[i] = getCommand((Command)list.get(i));
        }

        return ascriptcommand;
    }

    public ScriptCommand getCommand(String var1) {
        return getCommand(Client.a.getCommandManager().get(var1));
    }

    public void displayChat(String var1) {
        afi.b(var1);
    }

    public void displayInfoNotification(String var1, String var2) {
        cg.e(var1, var2);
    }

    public void displayInfoNotification(String var1, String var2, int var3) {
        cg.a(var1, var2, var3);
    }

    public void pingspoof(int var1, boolean var2, boolean var3, boolean var4, boolean var5) {
        BlinkComponent.a(var1, var2, var3, var4, var5);
    }

    public void blink() {
        BlinkComponent.blink();
    }

    public void dispatch() {
        BlinkComponent.dispatch();
    }

    public void pingspoof(int var1) {
        BlinkComponent.a(var1, true, false, false, false);
    }

    public String getRiseName() {
        return Client.b;
    }

    public String getRiseVersion() {
        return "6";
    }

    public long getSystemMillis() {
        return System.currentTimeMillis();
    }

    public ScriptVector2f newVec2(float var1, float var2) {
        return new ScriptVector2f(var1, var2);
    }

    public ScriptVector3d newVec3(double var1, double var3, double var5) {
        return new ScriptVector3d(var1, var3, var5);
    }

    public int getFPS() {
        return Minecraft.getDebugFPS();
    }

    public long getPing() {
        return PingSpoofComponent.getPing();
    }

    public boolean isBot(int var1) {
        return Client.a.x().a(Minecraft.getMinecraft().theWorld.getEntityByID(var1));
    }

    public boolean isFriend(String var1) {
        return bx.isFriend(var1);
    }

    public ScriptBlockPos newBlockPos(int var1, int var2, int var3) {
        afi.b("Please use world.newBlockPos(), instead of rise.newBlockPos().");
        return null;
    }

    public void setName(String var1) {
        Client.b = var1;
    }

    public void threadPool(JSObject var1) throws ScriptException {
        if (!var1.isFunction()) {
            throw new ScriptException("Not a function!");
        }

        aha.aMR.execute(() -> var1.call(null));
    }

    public void thread(JSObject var1) throws ScriptException {
        if (!var1.isFunction()) {
            throw new ScriptException("Not a function!");
        }

        new Thread(() -> var1.call(null)).start();
    }

    public String translate(String var1) {
        return ahd.ce(var1);
    }

    public String getLocale() {
        return Client.a.getLocale().getFile();
    }
}
