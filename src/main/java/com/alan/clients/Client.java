package com.alan.clients;

import com.alan.clients.command.Command;
import com.alan.clients.command.CommandManager;
import com.alan.clients.component.Component;
import com.alan.clients.component.ComponentManager;
import com.alan.clients.module.Module;
import com.alan.clients.module.api.manager.ModuleManager;
import com.alan.clients.newevent.Event;
import com.alan.clients.newevent.bus.impl.EventBus;
import com.alan.clients.script.ScriptManager;
import com.alan.clients.security.NativeDecryptor;
import com.alan.clients.security.SecurityFeature;
import com.alan.clients.security.SecurityFeatureManager;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.florianmichael.viamcp.ViaMCP;
import hackclient.rise.aal;
import hackclient.rise.ui.screen.aba;
import hackclient.rise.abs;
import hackclient.rise.adu;
import com.alan.clients.util.ReflectionUtil;
import com.alan.clients.util.file.FileManager;
import hackclient.rise.afv;
import com.alan.clients.util.file.config.ConfigManager;
import hackclient.rise.afz;
import com.alan.clients.util.file.insult.InsultFile;
import com.alan.clients.util.file.insult.InsultManager;
import com.alan.clients.util.localization.Locale;
import hackclient.rise.b;
import com.alan.clients.creative.RiseTab;
import hackclient.rise.gf;
import hackclient.rise.q;
import hackclient.rise.r;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Generated;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public enum Client
{
    a;
    public static String f;
    public static String b;
    public Gson K;
    public static boolean i;
    public static String e;
    public EventBus<Event> eventBus;
    public aba I;
    public ComponentManager componentManager;
    public static String g;
    public aal n;
    public q F;
    public ScriptManager scriptManager;
    public static String d;
    public afv C;
    public static String c;
    public static boolean j;
    public ModuleManager moduleManager;
    public SecurityFeatureManager securityManager;
    public InsultManager D;
    public RiseClickGUI standardClickGUI;
    public adu t;
    public CommandManager commandManager;
    public FileManager A;
    public r s;
    public ExecutorService executor;
    public afz v;
    public RiseTab J;
    public gf G;
    public ConfigManager B;
    public static Client[] $VALUES;


    public b w;
    public static boolean h;
    public Locale l;
    public com.alan.clients.security.b r;

    @Generated
    public void setScriptManager(final ScriptManager scriptManager) {
        this.scriptManager = scriptManager;
    }

    @Generated
    public void a(final RiseClickGUI standardClickGUI) {
        this.standardClickGUI = standardClickGUI;
    }

    @Generated
    public com.alan.clients.security.b j() {
        return this.r;
    }

    @Generated
    public r x() {
        return this.s;
    }

    @Generated
    public ModuleManager g() {
        return this.moduleManager;
    }


    @Generated
    public ConfigManager p() {
        return this.B;
    }

    public void b() {
        if (this.p() != null && this.p().to() != null) {
            this.p().to().write();
        }
    }

    @Generated
    public b n() {
        return this.w;
    }

    public void a(Locale locale) {
        if (locale == null) {
            return;
        }
        if (this.l == locale) {
            return;
        }
        this.l = locale;
        if (this.moduleManager != null) {
            for (Module module : this.moduleManager.ef()) {
                if (module == null || module.getModuleInfo() == null) continue;
                try {
                    module.setAliases((String[])Arrays.stream(module.getModuleInfo().aliases()).map(hackclient.rise.ahd::ce).toArray(String[]::new));
                } catch (Throwable throwable) {
                }
            }
        }
        try {
            com.alan.clients.module.impl.render.Interface interface_;
            if (this.moduleManager != null && (interface_ = this.moduleManager.c(com.alan.clients.module.impl.render.Interface.class)) != null) {
                interface_.lv();
                interface_.createArrayList();
            }
        } catch (Throwable throwable) {
        }
        try {
            if (this.standardClickGUI != null) {
                try {
                    this.standardClickGUI.oS();
                } catch (Throwable throwable2) {
                }
                hackclient.rise.aha.aMR.execute(() -> {
                    try {
                        this.standardClickGUI.oS();
                        return;
                    } catch (Throwable throwable) {
                        return;
                    }
                });
            }
        } catch (Throwable throwable) {
        }
        try {
            if (this.I != null) {
                try {
                    this.I.om();
                } catch (Throwable throwable2) {
                }
                hackclient.rise.aha.aMR.execute(() -> {
                    try {
                        this.I.om();
                        return;
                    } catch (Throwable throwable) {
                        return;
                    }
                });
            }
        } catch (Throwable throwable) {
        }
    }

    @Generated
    public q t() {
        return this.F;
    }

    @Generated
    public Locale getLocale() {
        return this.l;
    }

    @Generated
    public void a(final com.alan.clients.security.b r) {
        this.r = r;
    }

    @Generated
    public SecurityFeatureManager getSecurityManager() {
        return this.securityManager;
    }

    @Generated
    public void a(final ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    @Generated
    public void b(final Locale locale) {
        this.l = locale;
    }

    @Generated
    public ExecutorService getExecutor() {
        return this.executor;
    }

    @Generated
    public aal f() {
        return this.n;
    }

    @Generated
    public ScriptManager getScriptManager() {
        return this.scriptManager;
    }

    public void a() {
        final String[] array = { "hackclient.", "com.alan.clients." };
        int count = array.length;
        for (int i = 0; i < count; i++) {
            final String s = array[i];
            if (ReflectionUtil.bc(s)) {
                final Class<?>[] array2 = ReflectionUtil.ba(s);
                int count2 = array2.length;
                int j = 0;
            Label_0241_Outer:
                while (j < count2) {
                    final Class clazz = array2[j];
                    while (true) {
                        try {
                            if (!Modifier.isAbstract(clazz.getModifiers())) {
                                if (Component.class.isAssignableFrom(clazz)) {
                                    this.componentManager.a((Component)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                                else if (Module.class.isAssignableFrom(clazz)) {
                                    this.moduleManager.a(clazz, (Module)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                                else if (Command.class.isAssignableFrom(clazz)) {
                                    this.commandManager.aQ().add((Command)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                                else if (SecurityFeature.class.isAssignableFrom(clazz)) {
                                    this.securityManager.a((SecurityFeature)clazz.getConstructor((Class[])new Class[0]).newInstance(new Object[0]));
                                }
                            }
                            j++;
                            continue Label_0241_Outer;
                        }
                        catch (final IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ex) {
                            ((Throwable)ex).printStackTrace();
                            continue;
                        }
                    }
                }
                break;
            }
        }
    }

    public static Client[] E() {
        return new Client[] { Client.a };
    }

    @Generated
    public Gson A() {
        return this.K;
    }

    static {
        new StringBuilder().append("Made with <3 by Alan and ").append("The_Bi11iona1re").toString();
        new StringBuilder().append("\u00a9 Rise Client 2026. All Righ").append("ts Reserved").toString();
        final String s = "6.9.5";
        final String s2 = "6";
        Client.$VALUES = E();
        Client.b = "Rise";
    }

    @Generated
    public EventBus<Event> e() {
        return this.eventBus;
    }

    public void reload() {
        this.b();
        this.init();
        Client.a.p().tn();
    }

    @Generated
    public void a(final ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Generated
    public RiseClickGUI v() {
        return this.standardClickGUI;
    }

    @Generated
    public ComponentManager h() {
        return this.componentManager;
    }

    @Generated
    public RiseTab w() {
        return this.J;
    }

    @Generated
    public aba z() {
        return this.I;
    }

    @Generated
    public adu k() {
        return this.t;
    }

    @Generated
    public afv q() {
        return this.C;
    }

    @Generated
    public gf u() {
        return this.G;
    }

    Client() {
        this.executor = Executors.newSingleThreadExecutor();
        this.l = Locale.EN_US;
        this.K = new GsonBuilder().setPrettyPrinting().create();
    }

    @Generated
    public CommandManager getCommandManager() {
        return this.commandManager;
    }

    @Generated
    public InsultManager r() {
        return this.D;
    }

    @Generated
    public FileManager o() {
        return this.A;
    }

    public void init() {
        final Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.gameSettings.guiScale = 2;
        minecraft.gameSettings.cij = false;
        minecraft.gameSettings.ciq = false;
        minecraft.gameSettings.chy = true;
        minecraft.gameSettings.chu = false;
        NativeDecryptor.ok();
        this.n = new aal();
        this.moduleManager = new ModuleManager();
        this.componentManager = new ComponentManager();
        this.commandManager = new CommandManager();
        this.A = new FileManager();
        this.B = new ConfigManager();
        this.C = new afv();
        this.D = new InsultManager();
        this.v = new afz();
        this.r = new com.alan.clients.security.b();
        this.s = new r();
        this.t = new adu();
        this.scriptManager = new ScriptManager();
        this.w = new b();
        this.eventBus = new EventBus<Event>();
        this.securityManager = new SecurityFeatureManager();
        this.F = new q();
        this.G = new gf();
        new abs();
        this.A.init();
        this.v.init();
        this.n.init();
        this.moduleManager.init();
        this.r.init();
        this.s.init();
        this.componentManager.init();
        this.commandManager.init();
        this.C.init();
        this.D.init();
        this.scriptManager.init();
        this.securityManager.init();
        (this.standardClickGUI = new RiseClickGUI()).initGui();
        (this.I = new aba()).initGui();
        this.D.update();
        this.D.forEach(InsultFile::te);
        this.J = new RiseTab();
        new Thread(() -> {
            ViaMCP.create();
            ViaMCP.INSTANCE.initAsyncSlider();
            ViaMCP.INSTANCE.getAsyncVersionSlider().setVersion(47);
            return;
        }).start();
        this.B.init();
        this.F.init();
        Display.setTitle((Object)Client.b + " " + (Object)"6.9.5".replace(".0", ""));
    }

    @Generated
    public afz m() {
        return this.v;
    }

    @Generated
    public void a(final CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}
