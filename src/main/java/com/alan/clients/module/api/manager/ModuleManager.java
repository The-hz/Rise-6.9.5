package com.alan.clients.module.api.manager;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.impl.combat.AntiBot;
import com.alan.clients.module.impl.combat.ComboOneHit;
import com.alan.clients.module.impl.combat.Criticals;
import com.alan.clients.module.impl.combat.Fences;
import com.alan.clients.module.impl.combat.KeepRange;
import com.alan.clients.module.impl.combat.KillAura;
import com.alan.clients.module.impl.combat.LagBreak;
import com.alan.clients.module.impl.combat.LegitReach;
import com.alan.clients.module.impl.combat.Piercing;
import com.alan.clients.module.impl.combat.Regen;
import com.alan.clients.module.impl.combat.TeleportAura;
import com.alan.clients.module.impl.combat.ThrowableAura;
import com.alan.clients.module.impl.combat.TickBase;
import com.alan.clients.module.impl.combat.Velocity;
import com.alan.clients.module.impl.combat.WatchdogTPAura;
import com.alan.clients.module.impl.exploit.BlockTracker;
import com.alan.clients.module.impl.exploit.ConsoleSpammer;
import com.alan.clients.module.impl.exploit.Crasher;
import com.alan.clients.module.impl.exploit.Disabler;
import com.alan.clients.module.impl.exploit.GhostHand;
import com.alan.clients.module.impl.exploit.GodMode;
import com.alan.clients.module.impl.exploit.LightningTracker;
import com.alan.clients.module.impl.exploit.NoRotate;
import com.alan.clients.module.impl.exploit.PingSpoof;
import com.alan.clients.module.impl.exploit.StaffDetector;
import com.alan.clients.module.impl.ghost.AimAssist;
import com.alan.clients.module.impl.ghost.AimBacktrack;
import com.alan.clients.module.impl.ghost.AutoClicker;
import com.alan.clients.module.impl.ghost.ClickAssist;
import com.alan.clients.module.impl.ghost.FastPlace;
import com.alan.clients.module.impl.ghost.GuiClicker;
import com.alan.clients.module.impl.ghost.HitBox;
import com.alan.clients.module.impl.ghost.KeepSprint;
import com.alan.clients.module.impl.ghost.LegitScaffold;
import com.alan.clients.module.impl.ghost.ManualKBDisplacement;
import com.alan.clients.module.impl.ghost.NoClickDelay;
import com.alan.clients.module.impl.ghost.Reach;
import com.alan.clients.module.impl.ghost.SafeWalk;
import com.alan.clients.module.impl.ghost.WTap;
import com.alan.clients.module.impl.movement.AutoMLG;
import com.alan.clients.module.impl.movement.AutoStuck;
import com.alan.clients.module.impl.movement.Clipper;
import com.alan.clients.module.impl.movement.Flight;
import com.alan.clients.module.impl.movement.InventoryMove;
import com.alan.clients.module.impl.movement.Jesus;
import com.alan.clients.module.impl.movement.LongJump;
import com.alan.clients.module.impl.movement.NoClip;
import com.alan.clients.module.impl.movement.NoJumpDelay;
import com.alan.clients.module.impl.movement.NoSlow;
import com.alan.clients.module.impl.movement.Phase;
import com.alan.clients.module.impl.movement.PotionExtender;
import com.alan.clients.module.impl.movement.ResourcePackSpoof;
import com.alan.clients.module.impl.movement.SnapTap;
import com.alan.clients.module.impl.movement.Sneak;
import com.alan.clients.module.impl.movement.Speed;
import com.alan.clients.module.impl.movement.Sprint;
import com.alan.clients.module.impl.movement.Step;
import com.alan.clients.module.impl.movement.Strafe;
import com.alan.clients.module.impl.movement.Stuck;
import com.alan.clients.module.impl.movement.TargetStrafe;
import com.alan.clients.module.impl.movement.Teleport;
import com.alan.clients.module.impl.movement.TerrainSpeed;
import com.alan.clients.module.impl.movement.WallClimb;
import com.alan.clients.module.impl.other.AntiAFK;
import com.alan.clients.module.impl.other.AntiCrash;
import com.alan.clients.module.impl.other.AutoGG;
import com.alan.clients.module.impl.other.AutoGroomer;
import com.alan.clients.module.impl.other.BedwarsUtils;
import com.alan.clients.module.impl.other.ChatBypass;
import com.alan.clients.module.impl.other.CheatDetector;
import com.alan.clients.module.impl.other.ClickSounds;
import com.alan.clients.module.impl.other.ClientSpoofer;
import com.alan.clients.module.impl.other.Debugger;
import com.alan.clients.module.impl.other.HypixelAutoPlay;
import com.alan.clients.module.impl.other.IRC;
import com.alan.clients.module.impl.other.Insults;
import com.alan.clients.module.impl.other.MurderMystery;
import com.alan.clients.module.impl.other.NoGuiClose;
import com.alan.clients.module.impl.other.Nuker;
import com.alan.clients.module.impl.other.PlayerNotifier;
import com.alan.clients.module.impl.other.SamplerDev;
import com.alan.clients.module.impl.other.Spammer;
import com.alan.clients.module.impl.other.Spotify;
import com.alan.clients.module.impl.other.Test;
import com.alan.clients.module.impl.other.Timer;
import com.alan.clients.module.impl.other.Translator;
import com.alan.clients.module.impl.player.AntiFireBall;
import com.alan.clients.module.impl.player.AntiSuffocate;
import com.alan.clients.module.impl.player.AntiVoid;
import com.alan.clients.module.impl.player.AutoHead;
import com.alan.clients.module.impl.player.AutoPot;
import com.alan.clients.module.impl.player.AutoTool;
import com.alan.clients.module.impl.player.Blink;
import com.alan.clients.module.impl.player.Breaker;
import com.alan.clients.module.impl.player.Clutch;
import com.alan.clients.module.impl.player.FastBreak;
import com.alan.clients.module.impl.player.FastUse;
import com.alan.clients.module.impl.player.HealthBypass;
import com.alan.clients.module.impl.player.InventorySync;
import com.alan.clients.module.impl.player.Manager;
import com.alan.clients.module.impl.player.NoFall;
import com.alan.clients.module.impl.player.OldManager;
import com.alan.clients.module.impl.player.PolarDetector;
import com.alan.clients.module.impl.player.Scaffold;
import com.alan.clients.module.impl.player.Stealer;
import com.alan.clients.module.impl.player.Twerk;
import com.alan.clients.module.impl.player.WatchdogBlink;
import com.alan.clients.module.impl.render.Ambience;
import com.alan.clients.module.impl.render.Animations;
import com.alan.clients.module.impl.render.AppleSkin;
import com.alan.clients.module.impl.render.BPSCounter;
import com.alan.clients.module.impl.render.BedPlates;
import com.alan.clients.module.impl.render.BlackHoleOrbit;
import com.alan.clients.module.impl.render.BossBar;
import com.alan.clients.module.impl.render.BreadCrumbs;
import com.alan.clients.module.impl.render.CPSCounter;
import com.alan.clients.module.impl.render.Chat;
import com.alan.clients.module.impl.render.ChestESP;
import com.alan.clients.module.impl.render.ClickGUI;
import com.alan.clients.module.impl.render.ESP;
import com.alan.clients.module.impl.render.FPSCounter;
import com.alan.clients.module.impl.render.FreeCam;
import com.alan.clients.module.impl.render.FreeLook;
import com.alan.clients.module.impl.render.FullBright;
import com.alan.clients.module.impl.render.Glint;
import com.alan.clients.module.impl.render.HotBar;
import com.alan.clients.module.impl.render.HurtCamera;
import com.alan.clients.module.impl.render.HurtColor;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.module.impl.render.ItemPhysics;
import com.alan.clients.module.impl.render.JumpCircles;
import com.alan.clients.module.impl.render.KeyStrokes;
import com.alan.clients.module.impl.render.KillEffect;
import com.alan.clients.module.impl.render.M2DESP;
import com.alan.clients.module.impl.render.NameTags;
import com.alan.clients.module.impl.render.NoCameraClip;
import com.alan.clients.module.impl.render.OreESP;
import com.alan.clients.module.impl.render.Particles;
import com.alan.clients.module.impl.render.ScoreBoard;
import com.alan.clients.module.impl.render.SessionStats;
import com.alan.clients.module.impl.render.Streamer;
import com.alan.clients.module.impl.render.TargetInfo;
import com.alan.clients.module.impl.render.Tracers;
import com.alan.clients.module.impl.render.UnlimitedChat;
import com.alan.clients.module.impl.render.ViewBobbing;
import com.alan.clients.util.RegistryMap;
import java.util.ArrayList;
import java.util.Arrays;

public class ModuleManager {
    public RegistryMap<Class<Module>, Module> lt = new RegistryMap<>();

    public void e(Module module) {
        this.lt.h(module);
        this.eg();
    }

    public boolean add(Module module) {
        this.lt.g(module);
        this.eg();
        return true;
    }

    static {
    }

    public ArrayList<Module> ef() {
        return this.lt.rP();
    }

    public <T extends Module> T get(String var1) {
        return (T)this.ef()
            .stream()
            .filter(
                var1x -> Arrays.stream(var1x.getAliases())
                    .anyMatch(var1xx -> var1xx.replace(" ", "").equalsIgnoreCase(var1.replace(" ", "")))
            )
            .findAny()
            .orElse(null);
    }

    public void eg() {
        Interface interfaceModule = this.c(Interface.class);
        if (interfaceModule != null) {
            interfaceModule.lv();
        }
    }

    public <T extends Module> T c(Class<T> type) {
        return (T)this.lt.get(type);
    }


    public ModuleManager() {
    }

    public void init() {
        this.lt = new RegistryMap<>();
        this.a(AntiBot.class, new AntiBot());
        this.a(ComboOneHit.class, new ComboOneHit());
        this.a(Criticals.class, new Criticals());
        this.a(Fences.class, new Fences());
        this.a(KillAura.class, new KillAura());
        this.a(LagBreak.class, new LagBreak());
        this.a(LegitReach.class, new LegitReach());
        this.a(Piercing.class, new Piercing());
        this.a(Regen.class, new Regen());
        this.a(TeleportAura.class, new TeleportAura());
        this.a(WatchdogTPAura.class, new WatchdogTPAura());
        this.a(TickBase.class, new TickBase());
        this.a(ThrowableAura.class, new ThrowableAura());
        this.a(Velocity.class, new Velocity());
        this.a(WTap.class, new WTap());
        this.a(KeepRange.class, new KeepRange());
        this.a(BlockTracker.class, new BlockTracker());
        this.a(ConsoleSpammer.class, new ConsoleSpammer());
        this.a(Crasher.class, new Crasher());
        this.a(Disabler.class, new Disabler());
        this.a(GodMode.class, new GodMode());
        this.a(GhostHand.class, new GhostHand());
        this.a(LightningTracker.class, new LightningTracker());
        this.a(NoRotate.class, new NoRotate());
        this.a(PingSpoof.class, new PingSpoof());
        this.a(StaffDetector.class, new StaffDetector());
        this.a(AimAssist.class, new AimAssist());
        this.a(AimBacktrack.class, new AimBacktrack());
        this.a(AutoClicker.class, new AutoClicker());
        this.a(ClickAssist.class, new ClickAssist());
        this.a(LegitScaffold.class, new LegitScaffold());
        this.a(FastPlace.class, new FastPlace());
        this.a(GuiClicker.class, new GuiClicker());
        this.a(HitBox.class, new HitBox());
        this.a(KeepSprint.class, new KeepSprint());
        this.a(NoClickDelay.class, new NoClickDelay());
        this.a(Reach.class, new Reach());
        this.a(SafeWalk.class, new SafeWalk());
        this.a(ManualKBDisplacement.class, new ManualKBDisplacement());
        this.a(Flight.class, new Flight());
        this.a(InventoryMove.class, new InventoryMove());
        this.a(Jesus.class, new Jesus());
        this.a(LongJump.class, new LongJump());
        this.a(NoClip.class, new NoClip());
        this.a(NoSlow.class, new NoSlow());
        this.a(Phase.class, new Phase());
        this.a(PotionExtender.class, new PotionExtender());
        this.a(Sneak.class, new Sneak());
        this.a(SnapTap.class, new SnapTap());
        this.a(Speed.class, new Speed());
        this.a(Sprint.class, new Sprint());
        this.a(Step.class, new Step());
        this.a(Strafe.class, new Strafe());
        this.a(AutoStuck.class, new AutoStuck());
        this.a(Stuck.class, new Stuck());
        this.a(TargetStrafe.class, new TargetStrafe());
        this.a(Teleport.class, new Teleport());
        this.a(WallClimb.class, new WallClimb());
        this.a(TerrainSpeed.class, new TerrainSpeed());
        this.a(NoJumpDelay.class, new NoJumpDelay());
        this.a(Clipper.class, new Clipper());
        this.a(AutoMLG.class, new AutoMLG());
        this.a(ResourcePackSpoof.class, new ResourcePackSpoof());
        this.a(SamplerDev.class, new SamplerDev());
        this.a(AntiAFK.class, new AntiAFK());
        this.a(AutoGG.class, new AutoGG());
        this.a(AutoGroomer.class, new AutoGroomer());
        this.a(ClickSounds.class, new ClickSounds());
        this.a(ClientSpoofer.class, new ClientSpoofer());
        this.a(Debugger.class, new Debugger());
        this.a(HypixelAutoPlay.class, new HypixelAutoPlay());
        this.a(Insults.class, new Insults());
        this.a(MurderMystery.class, new MurderMystery());
        this.a(NoGuiClose.class, new NoGuiClose());
        this.a(Nuker.class, new Nuker());
        this.a(PlayerNotifier.class, new PlayerNotifier());
        this.a(AntiCrash.class, new AntiCrash());
        this.a(Spammer.class, new Spammer());
        this.a(Spotify.class, new Spotify());
        this.a(Test.class, new Test());
        this.a(Timer.class, new Timer());
        this.a(Translator.class, new Translator());
        this.a(BedwarsUtils.class, new BedwarsUtils());
        this.a(ChatBypass.class, new ChatBypass());
        this.a(AntiFireBall.class, new AntiFireBall());
        this.a(AntiSuffocate.class, new AntiSuffocate());
        this.a(AntiVoid.class, new AntiVoid());
        this.a(AutoHead.class, new AutoHead());
        this.a(AutoPot.class, new AutoPot());
        this.a(AutoTool.class, new AutoTool());
        this.a(Blink.class, new Blink());
        this.a(WatchdogBlink.class, new WatchdogBlink());
        this.a(Breaker.class, new Breaker());
        this.a(Clutch.class, new Clutch());
        this.a(FastBreak.class, new FastBreak());
        this.a(FastUse.class, new FastUse());
        this.a(NoFall.class, new NoFall());
        this.a(InventorySync.class, new InventorySync());
        this.a(Manager.class, new Manager());
        this.a(OldManager.class, new OldManager());
        this.a(NoFall.class, new NoFall());
        this.a(Scaffold.class, new Scaffold());
        this.a(Stealer.class, new Stealer());
        this.a(Twerk.class, new Twerk());
        this.a(PolarDetector.class, new PolarDetector());
        this.a(CheatDetector.class, new CheatDetector());
        this.a(HealthBypass.class, new HealthBypass());
        this.a(Ambience.class, new Ambience());
        this.a(Animations.class, new Animations());
        this.a(Chat.class, new Chat());
        this.a(AppleSkin.class, new AppleSkin());
        this.a(BedPlates.class, new BedPlates());
        this.a(BPSCounter.class, new BPSCounter());
        this.a(ChestESP.class, new ChestESP());
        this.a(ClickGUI.class, new ClickGUI());
        this.a(CPSCounter.class, new CPSCounter());
        this.a(FPSCounter.class, new FPSCounter());
        this.a(FreeCam.class, new FreeCam());
        this.a(FreeLook.class, new FreeLook());
        this.a(FullBright.class, new FullBright());
        this.a(Glint.class, new Glint());
        this.a(BossBar.class, new BossBar());
        this.a(HotBar.class, new HotBar());
        this.a(HurtCamera.class, new HurtCamera());
        this.a(HurtColor.class, new HurtColor());
        this.a(Interface.class, new Interface());
        this.a(ItemPhysics.class, new ItemPhysics());
        this.a(KeyStrokes.class, new KeyStrokes());
        this.a(KillEffect.class, new KillEffect());
        this.a(NameTags.class, new NameTags());
        this.a(NoCameraClip.class, new NoCameraClip());
        this.a(Particles.class, new Particles());
        this.a(M2DESP.class, new M2DESP());
        this.a(ESP.class, new ESP());
        this.a(ScoreBoard.class, new ScoreBoard());
        this.a(Streamer.class, new Streamer());
        this.a(TargetInfo.class, new TargetInfo());
        this.a(Tracers.class, new Tracers());
        this.a(UnlimitedChat.class, new UnlimitedChat());
        this.a(ViewBobbing.class, new ViewBobbing());
        this.a(IRC.class, new IRC());
        this.a(SessionStats.class, new SessionStats());
        this.a(BreadCrumbs.class, new BreadCrumbs());
        this.a(JumpCircles.class, new JumpCircles());
        this.a(BlackHoleOrbit.class, new BlackHoleOrbit());
        this.a(OreESP.class, new OreESP());
        this.ef().stream().filter(var0 -> var0.getModuleInfo().autoEnabled()).forEach(var0 -> var0.setEnabled(true));
        Client.a.e().b(this);
    }

    public void a(Class type, Module module) {
        this.lt.put(type, module);
    }
}
