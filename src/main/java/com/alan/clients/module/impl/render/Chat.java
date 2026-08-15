package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.render.Interface;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.KeyboardInputEvent;
import com.alan.clients.newevent.impl.packet.PacketReceiveEvent;
import com.alan.clients.newevent.impl.render.Render2DEvent;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.value.Mode;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.DragValue;
import com.alan.clients.value.impl.NumberValue;
import hackclient.rise.ui.screen.CommandPalette;
import com.alan.clients.ui.theme.Themes;
import hackclient.rise.adz;
import com.alan.clients.util.MouseUtil;
import hackclient.rise.afi;
import hackclient.rise.agc;
import hackclient.rise.agk;
import hackclient.rise.agl;
import com.alan.clients.util.gui.textbox.TextBox;
import hackclient.rise.agw;
import hackclient.rise.agx;
import hackclient.rise.ahd;
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.dt;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import hackclient.rise.ye;
import hackclient.rise.yf;
import hackclient.rise.yl;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lombok.Generated;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.optifine.gui.c;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import rip.vantage.network.core.a;

@ModuleInfo(aliases={"module.render.chat.name"}, description="module.render.chat.description", category=Category.RENDER, autoEnabled=true, allowDisable=false)
public final class Chat
extends Module {
    private static final float aqv = 4.0f;
    private final NumberValue openHeight = new NumberValue("Open Height", this, (Number)130, (Number)0, (Number)200, (Number)1);
    private final NumberValue width = new NumberValue("Width", this, (Number)320, (Number)40, (Number)320, (Number)1);
    private final NumberValue maxClosedHeight = new NumberValue("Max Closed Height", this, (Number)130, (Number)0, (Number)500, (Number)1);
    private final NumberValue messageDisappearanceSpeed = new NumberValue("Message disappearance speed", this, (Number)5000, (Number)0, (Number)5000, (Number)1);
    private final BooleanValue background = new BooleanValue("Background", (Module)this, (Boolean)true);
    private final BooleanValue hidePlayerSourceMessages = new BooleanValue("Hide Player Source Messages", (Module)this, (Boolean)false);
    private final BooleanValue imageChat = new BooleanValue("Image Chat", (Module)this, (Boolean)true);
    private final yf aqD = new yf();
    private final DragValue aqE = new DragValue("", this, new Vector2d(200.0, 200.0), false, true);
    private final Animation aqF = new Animation(Easing.EASE_OUT_EXPO, 500L);
    private final Animation aqG = new Animation(Easing.EASE_OUT_ELASTIC, 400L);
    private final Animation aqH = new Animation(Easing.LINEAR, 400L);
    private final Animation aqI = new Animation(Easing.EASE_OUT_EXPO, 500L);
    private final agk aqJ = new agk();
    private final agc aqK;
    private final agc aqL;
    private static final String aqM = afi.getPrefix();
    private static final String aqN = "[Rise] ";
    private static final agw aqO = new agw();
    private final BooleanValue pinyinChineseIME;
    private static final String aqQ = Chat.mr();
    private static final int aqR = 100;
    private int aqS;
    private String aqT;
    private TextBox aqU;
    private int aqV;
    private int aqW;
    private float aqX;
    public boolean amX;
    public boolean ads;
    private rip.vantage.commons.util.time.a bN;
    private adz<String> aqY;
    private ArrayList<String> aqZ;
    private Interface amf;
    @EventLink
    public final Listener<KeyboardInputEvent> onKeyboardInput;
    @EventLink
    public final Listener<PacketReceiveEvent> onPacketReceive;
    @EventLink
    public final Listener<dt> arc;
    @EventLink
    public final Listener<Render2DEvent> onRender2D;

    public Chat() {
        this.aqK = Chat.aEg.fontRendererObj;
        this.aqL = Chat.aEg.fontRendererObj;
        this.pinyinChineseIME = new BooleanValue("Pinyin Chinese IME", (Module)this, (Boolean)false);
        this.aqS = -1;
        this.aqT = "";
        this.aqU = new TextBox(new Vector2d(0.0, 0.0), this.aqL, Color.WHITE, agl.LEFT, "", 1000.0f, aqQ);
        this.bN = new rip.vantage.commons.util.time.a();
        this.aqY = new adz(20);
        this.onKeyboardInput = keyboardInputEvent -> {
            char c2 = keyboardInputEvent.cP();
            if (c2 == '.' || c2 == '\u3002') {
                String string;
                if (keyboardInputEvent.getGuiScreen() == null) {
                    aEg.displayGuiScreen(new CommandPalette(null));
                    keyboardInputEvent.setCancelled();
                    return;
                }
                if (keyboardInputEvent.getGuiScreen() instanceof c && ((string = this.mL().getText()) == null || string.trim().isEmpty())) {
                    aEg.displayGuiScreen(new CommandPalette(Chat.aEg.currentScreen));
                    keyboardInputEvent.setCancelled();
                    return;
                }
            }
            if (c2 == '/' || c2 == '.') {
                this.aqU.I(true);
                this.aqU.key(c2, keyboardInputEvent.getKeyCode());
            }
        };
        this.onPacketReceive = packetReceiveEvent -> {
            Packet<?> packet = packetReceiveEvent.getPacket();
            if (packet instanceof S3APacketTabComplete) {
                this.aqZ = new ArrayList<String>(Arrays.asList(((S3APacketTabComplete)packet).func_149630_c()));
                for (String string : this.aqZ) {
                    afi.b(string, new Object[0]);
                }
            }
        };
        this.arc = dt2 -> {
            int n2 = dt2.cO();
            char c2 = dt2.cP();
            boolean bl = Chat.aEg.currentScreen instanceof c;
            if (Character.getType(c2) == 18 || c2 >= '\uf700' && c2 <= '\uf8ff') {
                c2 = '\u0000';
            }
            if (bl && ((Boolean)this.pinyinChineseIME.wo()).booleanValue() && agx.isEnabled()) {
                this.aqU.ayU = true;
                if (aqO.a(this.aqU, c2, n2)) {
                    return;
                }
            }
            switch (n2) {
                case 28: {
                    if (this.aqU.getText().isEmpty()) {
                        return;
                    }
                    String string = this.aqU.getText();
                    if (!string.startsWith("#") && string.length() > 100 && this.aqD.Z(string)) {
                        afi.d(afi.getPrefix() + String.valueOf((Object)EnumChatFormatting.RED) + "Vanilla chat only sends 100 characters. Long image URLs will be truncated.", new Object[0]);
                    }
                    if (!string.startsWith("#") && string.length() > 100) {
                        string = string.substring(0, 100);
                    }
                    Chat.aEg.thePlayer.sendChatMessage(string);
                    if (this.aqY.isEmpty() || !string.equals(this.aqY.get(this.aqY.size() - 1))) {
                        this.aqY.add(string);
                    }
                    this.aqU.XS = "";
                    this.aqU.aJk = 0;
                    this.aqS = -1;
                    this.aqT = "";
                    aEg.displayGuiScreen(null);
                    return;
                }
                case 200: {
                    if (this.aqY.isEmpty()) {
                        return;
                    }
                    if (this.aqS == -1) {
                        this.aqT = this.aqU.XS;
                        this.aqS = 0;
                    } else {
                        this.aqS = Math.min(this.aqS + 1, this.aqY.size() - 1);
                    }
                    int n3 = this.aqY.size() - 1 - this.aqS;
                    this.aqU.XS = (String)this.aqY.get(n3);
                    this.aqU.aJk = this.aqU.XS.length();
                    return;
                }
                case 208: {
                    if (this.aqY.isEmpty()) return;
                    if (this.aqS == -1) {
                        return;
                    }
                    --this.aqS;
                    if (this.aqS < 0) {
                        this.aqU.XS = this.aqT;
                        this.aqU.aJk = this.aqU.XS.length();
                        this.aqT = "";
                        return;
                    }
                    int n4 = this.aqY.size() - 1 - this.aqS;
                    this.aqU.XS = (String)this.aqY.get(n4);
                    this.aqU.aJk = this.aqU.XS.length();
                    return;
                }
                case 15: {
                    if (this.aqZ == null) {
                        String string = this.mL().getText();
                        if (!string.startsWith(".") && !string.isEmpty()) {
                            BlockPos blockPos = null;
                            if (Chat.aEg.objectMouseOver != null && Chat.aEg.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                                blockPos = Chat.aEg.objectMouseOver.getBlockPos();
                            }
                            Chat.aEg.thePlayer.sendQueue.addToSendQueue(new C14PacketTabComplete(string, blockPos));
                        }
                        this.aqZ = new ArrayList();
                        return;
                    }
                    if (this.aqZ.isEmpty()) return;
                    CharSequence[] charSequenceArray = this.aqU.getText().split(" ");
                    int n5 = this.aqZ.indexOf(charSequenceArray[charSequenceArray.length - 1]);
                    charSequenceArray[charSequenceArray.length - 1] = this.aqZ.get(this.aqZ.size() > n5 + 1 ? n5 + 1 : 0);
                    this.aqU.XS = String.join((CharSequence)" ", charSequenceArray);
                    this.aqU.aJk = this.aqU.getText().length();
                    return;
                }
            }
            this.aqU.ayU = bl;
            this.aqU.key(c2, n2);
        };
        this.onRender2D = render2DEvent -> {
            this.mn();
            this.mq();
        };
        this.mp();
    }

    public void mn() {
        this.mp();
        this.rz();
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }
        boolean bl = ((Mode)this.amf.lM().wo()).getName().equals("Rise");
        this.ads = Chat.aEg.currentScreen instanceof c;
        this.aqX = this.aqK.height();
        ArrayList<net.minecraft.client.gui.a> arrayList = new ArrayList<net.minecraft.client.gui.a>(Chat.aEg.ingameGUI.getChatGUI().drawnChatLines);
        int n2 = this.p(arrayList);
        float f2 = Math.min((float)((Number)(this.ads ? this.openHeight : this.maxClosedHeight).wo()).intValue(), this.aqX * (float)n2 + (float)(n2 == 0 ? 0 : 7));
        this.aqI.Q(Math.min(f2, this.aqX * (this.ads ? f2 : (float)this.aqW) + (float)(this.aqX * (this.ads ? f2 : (float)this.aqW) == 0.0f ? 0 : 7)));
        this.aqE.aHe = new Vector2d(((Number)this.width.wo()).doubleValue(), this.aqI.sG());
        this.aqE.apP = new Vector2d(this.rz().qd(), (double)(Chat.aEg.jY.getScaledHeight() - 10 - 20) - this.aqE.aHe.y);
        Vector2d vector2d = new Vector2d(this.aqE.apP.x + 5.0, this.aqE.apP.y + this.aqE.aHe.y - 1.5);
        Vector2d vector2d2 = new Vector2d(vector2d.getX(), vector2d.getY());
        double d2 = Math.min(this.aqE.aHe.y / 5.0, 6.0);
        if (((Boolean)this.background.wo()).booleanValue()) {
            if (bl) {
                double d3 = this.amf != null ? this.amf.lD() : d2;
                this.b(gg.REGULAR, 1).c(() -> RenderUtil.roundedRectangle(this.aqE.apP.x, this.aqE.apP.y, this.aqE.aHe.x, this.aqE.aHe.y, d3, Themes.rK()));
                this.b(gg.BLOOM).c(() -> RenderUtil.roundedRectangle(this.aqE.apP.x + 1.0, this.aqE.apP.y + 1.0, this.aqE.aHe.x - 2.0, this.aqE.aHe.y - 2.0, d3, this.rz().rE()));
                this.b(gg.BLUR).c(() -> RenderUtil.roundedRectangle(this.aqE.apP.x, this.aqE.apP.y, this.aqE.aHe.x, this.aqE.aHe.y, d3, Color.BLACK));
            } else {
                this.b(gg.REGULAR, 1).c(() -> RenderUtil.d(this.aqE.apP.x, this.aqE.apP.y, this.aqE.aHe.x, this.aqE.aHe.y, new Color(0, 0, 0, 130)));
            }
        }
        this.b(gg.REGULAR, 1).c(() -> {
            block29: {
                block30: {
                    GL11.glEnable(3089);
                    RenderUtil.g(this.aqE.apP.x, this.aqE.apP.y, this.aqE.aHe.x, this.aqE.aHe.y);
                    this.aqF.Q(0.0);
                    vector2d.setY(vector2d.getY() + this.aqF.sG() - this.aqJ.tE());
                    this.aqJ.E(this.ads);
                    this.aqJ.H(true);
                    this.aqJ.V((double)(-this.aqX * (float)n2) + this.aqE.aHe.y - 6.0);
                    if (!this.ads) {
                        this.aqJ.U(0.0);
                    }
                    if (arrayList.size() > 150) {
                        List<net.minecraft.client.gui.a> list2 = Chat.aEg.ingameGUI.getChatGUI().drawnChatLines;
                        while (list2.size() > 100) {
                            list2.remove(list2.size() - 1);
                        }
                    }
                    if (this.aqV >= n2) break block29;
                    if (!((Boolean)this.hidePlayerSourceMessages.wo()).booleanValue()) break block30;
                    Chat.aEg.ingameGUI.getChatGUI().drawnChatLines.removeIf(a2 -> a2.Dx().getFormattedText().contains(":"));
                    if (this.aqV >= Chat.aEg.ingameGUI.getChatGUI().drawnChatLines.size()) break block29;
                }
                this.aqF.T(this.aqF.sG() + (double)((float)(n2 - this.aqV) * this.aqX));
                this.aqF.Q(this.aqF.sG());
                this.aqW += n2 - this.aqV;
                this.aqW = (int)Math.max(Math.min((float)((Number)this.maxClosedHeight.wo()).intValue() / this.aqX, (float)this.aqW), 0.0f);
            }
            this.aqV = n2;
            if (this.bN.T(((Number)this.messageDisappearanceSpeed.wo()).intValue()) || this.aqW == 0) {
                this.bN.aX();
                this.aqW = Math.max(0, this.aqW - 1);
            }
            IChatComponent iChatComponent = null;
            Iterator iterator = arrayList.iterator();
            block1: while (true) {
                float f2x;
                float f3;
                float f4;
                ye ye2;
                net.minecraft.client.gui.a a3;
                if (iterator.hasNext()) {
                    a3 = (net.minecraft.client.gui.a)iterator.next();
                    vector2d.setX(vector2d2.getX());
                    ye2 = this.a(a3);
                    f4 = this.a(ye2);
                    float f5 = f4 > 0.0f ? 4.0f : 0.0f;
                    float f6 = this.aqX + f5 + f4;
                    vector2d.setY(vector2d.getY() - (double)f6);
                    f3 = (float)(vector2d.getY() + (double)f4 + (double)f5);
                    f2x = (float)vector2d.getY();
                    double d = this.aqE.apP.y - (double)this.aqX + (double)(this.ads ? 0 : 6);
                    double d2x = this.aqE.apP.y + this.aqE.aHe.y;
                    if (vector2d.y + (double)f6 < d || vector2d.y > d2x) continue;
                } else {
                    if (iChatComponent != null) {
                        Vector2d vector2d3 = MouseUtil.rU();
                        Chat.aEg.currentScreen.handleComponentHover(iChatComponent, (int)vector2d3.getX(), (int)vector2d3.getY());
                        if (!this.amX && Mouse.isButtonDown(0)) {
                            Chat.aEg.currentScreen.handleComponentClick(iChatComponent);
                        }
                        this.amX = Mouse.isButtonDown(0);
                    }
                    if (((Boolean)this.background.wo()).booleanValue()) {
                        this.aqJ.a(new Vector2d(this.aqE.apP.x + this.aqE.aHe.x - 5.0, this.aqE.apP.y + 5.0), this.aqE.aHe.y - 10.0);
                    }
                    GL11.glDisable(3089);
                    return;
                }
                Iterator iterator2 = a3.Dx().iterator();
                block2: while (true) {
                    float f7;
                    float f8;
                    EnumChatFormatting enumChatFormatting;
                    String string;
                    IChatComponent iChatComponent2;
                    if (iterator2.hasNext()) {
                        iChatComponent2 = (IChatComponent)iterator2.next();
                        string = iChatComponent2.getUnformattedTextForChat();
                        enumChatFormatting = iChatComponent2.getChatStyle().getColor() == null ? EnumChatFormatting.RESET : iChatComponent2.getChatStyle().getColor();
                        f8 = (float)vector2d.getX();
                        f7 = f3;
                        if (string.startsWith(aqM) || string.startsWith(aqN)) {
                            String string2 = string.startsWith(aqM) ? aqM : aqN;
                            this.a(this.aqK, string2, f8, f7);
                            float f9 = this.aqK.getStringWidth(string2);
                            if (this.ads && MouseUtil.e(f8, f7, f9, this.aqX)) {
                                iChatComponent = iChatComponent2;
                            }
                            vector2d.x += (double)f9;
                            string = string.substring(string2.length());
                            f8 = (float)vector2d.getX();
                        }
                    } else {
                        int n2x;
                        n2x = ye2 == null ? -1 : ye2.nh();
                        if (ye2 == null || !(f4 > 0.0f) || n2x < 0) continue block1;
                        int n4 = ye2.q(this.mo());
                        int n5 = ye2.r(this.mo());
                        RenderUtil.d(vector2d2.getX(), f2x, n4, n5, new Color(30, 30, 30, 200));
                        RenderUtil.a(n2x, (float)vector2d2.getX(), f2x, n4, n5, Color.WHITE);
                        continue block1;
                    }
                    String string3 = string.toLowerCase();
                    String[] stringArray = new String[]{"billionaire2", "billionaire", a.aKB().bX()};
                    int n6 = -1;
                    String string4 = null;
                    String[] stringArray2 = stringArray;
                    int length = stringArray2.length;
                    int n8 = 0;
                    while (true) {
                        block32: {
                            block31: {
                                if (n8 >= length) break block31;
                                String string5 = stringArray2[n8];
                                int n9 = string3.indexOf(string5);
                                if (n9 == -1) break block32;
                                n6 = n9;
                                string4 = string5;
                            }
                            if (n6 == -1 || string4 == null) break;
                            String string6 = string.substring(0, n6);
                            String string7 = string.substring(n6, n6 + string4.length());
                            String string8 = string.substring(n6 + string4.length());
                            if (!string6.isEmpty()) {
                                this.aqK.b(String.valueOf((Object)enumChatFormatting) + string6, f8, f7, 0xFFFFFF);
                                float f10 = this.aqK.getStringWidth(string6);
                                if (this.ads && MouseUtil.e(f8, f7, f10, this.aqX)) {
                                    iChatComponent = iChatComponent2;
                                }
                                vector2d.x += (double)f10;
                                f8 = (float)vector2d.getX();
                            }
                            this.a(this.aqK, string7, f8, f7);
                            float f11 = this.aqK.getStringWidth(string7);
                            if (this.ads && MouseUtil.e(f8, f7, f11, this.aqX)) {
                                iChatComponent = iChatComponent2;
                            }
                            vector2d.x += (double)f11;
                            float f12 = (float)vector2d.getX();
                            if (string8.isEmpty()) continue block2;
                            this.aqK.b(String.valueOf((Object)enumChatFormatting) + string8, f12, f7, 0xFFFFFF);
                            float f13 = this.aqK.getStringWidth(string8);
                            if (this.ads && MouseUtil.e(f12, f7, f13, this.aqX)) {
                                iChatComponent = iChatComponent2;
                            }
                            vector2d.x += (double)f13;
                            continue block2;
                        }
                        ++n8;
                    }
                    float f14 = (float)this.aqK.b(String.valueOf((Object)enumChatFormatting) + string, f8, f7, 0xFFFFFF) - f8;
                    if (this.ads && MouseUtil.e(f8, f7, f14, this.aqX)) {
                        iChatComponent = iChatComponent2;
                    }
                    vector2d.x += (double)f14;
                }
            }
        });
    }

    private int p(List<net.minecraft.client.gui.a> list) {
        int n2 = list.size();
        for (net.minecraft.client.gui.a a2 : list) {
            float f2 = this.a(this.a(a2));
            if (!(f2 > 0.0f)) continue;
            n2 += Math.max(1, (int)Math.ceil(f2 / this.aqX));
        }
        return n2;
    }

    private float a(ye ye2) {
        if (!((Boolean)this.imageChat.wo()).booleanValue() || ye2 == null || ye2.nc() || !ye2.isLoaded()) {
            return 0.0f;
        }
        this.aqD.c(ye2);
        return ye2.r(this.mo());
    }

    private float mo() {
        return Math.max(1.0f, (float)((Number)this.width.wo()).doubleValue() - 10.0f);
    }

    private ye a(net.minecraft.client.gui.a a2) {
        if ((Boolean)this.imageChat.wo() == false) return null;
        if (a2 == null) return null;
        if (!a2.DB()) {
            return null;
        }
        IChatComponent iChatComponent = a2.DA() == null ? a2.Dx() : a2.DA();
        String string = this.aqD.aa(iChatComponent.getUnformattedText());
        if (string == null) {
            return null;
        }
        ye ye2 = this.aqD.ad(string);
        if (ye2 != null) return ye2;
        this.aqD.b(new ye(string, a2.Dy(), a2.getChatLineID()));
        return this.aqD.ad(string);
    }

    private void mp() {
        if (aEg == null || Chat.aEg.ingameGUI == null) {
            return;
        }
        if (Chat.aEg.ingameGUI.getChatGUI() instanceof yl) {
            return;
        }
        GuiNewChat guiNewChat = Chat.aEg.ingameGUI.getChatGUI();
        yl yl2 = new yl(aEg);
        if (guiNewChat != null) {
            yl2.getSentMessages().addAll(guiNewChat.getSentMessages());
            yl2.EK().addAll(guiNewChat.EK());
            yl2.drawnChatLines.addAll(guiNewChat.drawnChatLines);
            yl2.scrollPos = guiNewChat.scrollPos;
            yl2.isScrolled = guiNewChat.isScrolled;
        }
        Chat.aEg.ingameGUI.persistantChatGUI = yl2;
        System.out.println("[ChatImage] Installed RiseGuiNewChat hook");
    }

    public void mq() {
        this.rz();
        if (this.amf == null) {
            this.amf = this.e(Interface.class);
        }
        boolean bl = ((Mode)this.amf.lM().wo()).getName().equals("Rise");
        if (!((Boolean)this.pinyinChineseIME.wo()).booleanValue()) {
            aqO.aX();
            agx.K(false);
            agx.setEnabled(false);
        } else {
            agx.K(true);
        }
        if (!this.ads) {
            aqO.aX();
        }
        if (bl) {
            this.aqG.h(!this.ads ? 300L : 850L);
            this.aqG.setEasing(!this.ads ? Easing.EASE_IN_EXPO : Easing.EASE_OUT_ELASTIC);
        } else {
            this.aqG.h(0L);
            this.aqG.setEasing(!this.ads ? Easing.EASE_IN_EXPO : Easing.EASE_OUT_ELASTIC);
        }
        this.aqG.Q(!this.ads ? 0.0 : 1.0);
        this.aqH.Q(this.ads ? 255.0 : 0.0);
        double d2 = this.aqG.sG() > 1.0 ? 1.0 + (this.aqG.sG() - 1.0) * 0.4 : this.aqG.sG();
        this.aqU.bX("");
        if (this.aqG.sG() <= 0.0) {
            return;
        }
        Vector2d vector2d = new Vector2d(this.rz().qd(), (float)Chat.aEg.jY.getScaledHeight() - this.rz().qd() - FontManager.MAIN.a(20, gd.REGULAR).height() - 3.0f);
        Vector2d vector2d2 = new Vector2d(this.aqE.aHe.x, (double)this.aqL.height() + 7.5);
        Runnable runnable = () -> {
            GlStateManager.pushMatrix();
            GlStateManager.translate((vector2d.x + vector2d2.x / 2.0) * (1.0 - d2), (vector2d.y + vector2d2.y / 2.0) * (1.0 - d2), 0.0);
            GlStateManager.scale(d2, d2, 0.0);
        };
        if (bl) {
            double d3 = this.amf != null ? this.amf.lD() : 6.0;
            this.b(gg.REGULAR, 1).c(() -> {
                runnable.run();
                RenderUtil.roundedRectangle(vector2d.x, vector2d.y, vector2d2.x, vector2d2.y, d3, ColorUtil.d(Themes.rK(), Math.min((int)this.aqH.sG(), Themes.rK().getAlpha())));
                GlStateManager.popMatrix();
            });
            this.b(gg.BLOOM).c(() -> {
                runnable.run();
                RenderUtil.roundedRectangle(vector2d.x, vector2d.y, vector2d2.x, vector2d2.y, d3, this.rz().rE());
                GlStateManager.popMatrix();
            });
            this.b(gg.BLUR).c(() -> {
                runnable.run();
                RenderUtil.roundedRectangle(vector2d.x, vector2d.y, vector2d2.x, vector2d2.y, d3, Color.BLACK);
                GlStateManager.popMatrix();
            });
        } else {
            this.b(gg.REGULAR, 1).c(() -> {
                runnable.run();
                RenderUtil.d(vector2d.x, vector2d.y, vector2d2.x, vector2d2.y, new Color(0, 0, 0, Math.min((int)this.aqH.sG(), 130)));
                GlStateManager.popMatrix();
            });
        }
        this.aqU.setColor(ColorUtil.d(Color.WHITE, (int)this.aqH.sG()));
        this.aqU.c(this.aqL);
        this.aqU.h(new Vector2d(this.rz().qd() + 5.0f, (float)Chat.aEg.jY.getScaledHeight() - this.aqL.height() - this.rz().qd()));
        this.b(gg.REGULAR, 1).c(() -> {
            runnable.run();
            this.aqU.draw();
            if (this.ads && ((Boolean)this.pinyinChineseIME.wo()).booleanValue()) {
                int n = Math.min(255, Math.max(0, (int)this.aqH.sG()));
                String string2 = ahd.ce(agx.isEnabled() ? "ui.chat.pinyin_ime.hint.on" : "ui.chat.pinyin_ime.hint.off");
                float f2 = (float)vector2d.x + 6.0f;
                float f3 = (float)vector2d.y - this.aqL.height() - 2.0f;
                ArrayList<String> arrayList = new ArrayList<String>(3);
                arrayList.add(string2);
                if (agx.isEnabled()) {
                    arrayList.add(ahd.ce("ui.chat.pinyin_ime.hint.help"));
                    try {
                        boolean blx;
                        File file2 = Minecraft.getMinecraft().mcDataDir;
                        File file3 = file2 == null ? null : new File(file2, "Rise");
                        File file4 = file3 == null ? null : new File(file3, "pinyin_dict.properties");
                        File file5 = file3 == null ? null : new File(file3, "pinyin_dict.tsv");
                        File file6 = file3 == null ? null : new File(file3, "pinyin_dict.txt");
                        boolean bl2 = file4 != null && file4.isFile();
                        boolean bl3 = bl2 | (file5 != null && file5.isFile());
                        boolean bl4 = bl3 | (file6 != null && file6.isFile());
                        if (!bl4 && file3 != null && file3.isDirectory()) {
                            File[] fileArray = file3.listFiles((file, string) -> {
                                if (string == null) return false;
                                if (!string.toLowerCase(Locale.ROOT).endsWith(".dict.yaml")) return false;
                                return true;
                            });
                            bl4 = fileArray != null && fileArray.length > 0;
                        }
                        blx = !bl4;
                        if (blx) {
                            arrayList.add(ahd.ce("ui.chat.pinyin_ime.dict.help"));
                        }
                    } catch (Throwable throwable) {
                    }
                }
                double d = 4.0;
                double d3 = this.aqL.height();
                double d4 = 0.0;
                for (String string3 : arrayList) {
                    if (string3 == null || string3.isEmpty()) continue;
                    d4 = Math.max(d4, (double)this.aqL.getStringWidth(string3));
                }
                int n2 = Math.max(1, arrayList.size());
                double d5 = d4 + 8.0;
                double d6 = (double)n2 * d3 + 4.0 + (double)(n2 - 1);
                double d7 = (double)f2 - 4.0;
                double d8 = (double)f3 - (double)(n2 - 1) * (d3 + 1.0);
                double d9 = d8 - 2.0;
                this.b(gg.BLUR).c(() -> {
                    runnable.run();
                    RenderUtil.roundedRectangle(d7, d9, d5, d6, 6.0, Color.BLACK);
                    GlStateManager.popMatrix();
                });
                this.b(gg.BLOOM).c(() -> {
                    runnable.run();
                    RenderUtil.roundedRectangle(d7, d9, d5, d6, 6.0, this.rz().rE());
                    GlStateManager.popMatrix();
                });
                RenderUtil.roundedRectangle(d7, d9, d5, d6, 6.0, ColorUtil.d(Themes.rK(), Math.min(n, Themes.rK().getAlpha())));
                for (int i = 0; i < n2; ++i) {
                    String string4 = (String)arrayList.get(i);
                    if (string4 == null || string4.isEmpty()) continue;
                    float f4 = (float)((double)f3 - (double)i * (d3 + 1.0));
                    int n3 = i == 0 ? 180 : (i == 1 ? 140 : 120);
                    this.aqL.b(string4, f2, f4, ColorUtil.d(Color.WHITE, Math.min(n, n3)).hashCode());
                }
            }
            if (this.ads && ((Boolean)this.pinyinChineseIME.wo()).booleanValue() && agx.isEnabled() && aqO.uc()) {
                String string5 = aqO.uo();
                List<String> list = aqO.up();
                if (string5 != null && !string5.isEmpty()) {
                    int n = Math.min(255, Math.max(0, (int)this.aqH.sG()));
                    float f5 = this.aqU.tL();
                    float f6 = this.aqU.tM();
                    this.aqL.b(string5, f5, f6, ColorUtil.d(new Color(220, 220, 220), n).hashCode());
                    double d = this.aqL.getStringWidth(string5);
                    RenderUtil.d(f5, f6 + this.aqL.height() + 1.0f, d, 1.0, ColorUtil.d(Color.WHITE, Math.min(n, 180)));
                    if (list != null && !list.isEmpty()) {
                        float f7 = (float)this.aqU.getPosition().x;
                        float f8 = f6 - this.aqL.height() - 3.0f;
                        StringBuilder stringBuilder = new StringBuilder();
                        int n4 = Math.min(9, list.size());
                        int n5 = aqO.un();
                        for (int i = 0; i < n4; ++i) {
                            if (i > 0) {
                                stringBuilder.append("  ");
                            }
                            String string6 = i + 1 + "." + list.get(i);
                            if (i == n5) {
                                stringBuilder.append('[').append(string6).append(']');
                                continue;
                            }
                            stringBuilder.append(string6);
                        }
                        stringBuilder.append(aqO.ut());
                        String string7 = stringBuilder.toString();
                        double d11 = this.aqL.getStringWidth(string7) + 6;
                        double d12 = this.aqL.height() + 4.0f;
                        RenderUtil.d(f7 - 2.0f, f8 - 2.0f, d11, d12, ColorUtil.d(new Color(0, 0, 0), Math.min(n, 140)));
                        this.aqL.b(string7, f7 + 1.0f, f8, ColorUtil.d(Color.WHITE, n).hashCode());
                    }
                }
            }
            GlStateManager.popMatrix();
            if (!this.ads) {
                this.aqU.XS = "";
            }
        });
        if (!this.ads) {
            this.aqU.XS = "";
            this.aqZ = null;
        }
    }

    private void a(agc agc2, String string, float f2, float f3) {
        String string2 = EnumChatFormatting.getTextWithoutFormattingCodes(string);
        Color color = this.rz().rA();
        Color color2 = this.rz().rB();
        long now = System.currentTimeMillis();
        double d2 = 0.005;
        float f4 = f2;
        int n2 = string2.length();
        for (int i = 0; i < n2; ++i) {
            char c2 = string2.charAt(i);
            double d3 = (double)i / (double)n2 * Math.PI * 2.0;
            float f5 = (float)((Math.sin((double)now * d2 + d3) + 1.0) * 0.5);
            int n3 = (int)((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f5);
            int n4 = (int)((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f5);
            int n5 = (int)((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f5);
            int n6 = (int)((float)color.getAlpha() + (float)(color2.getAlpha() - color.getAlpha()) * f5);
            agc2.b(String.valueOf(c2), f4, f3, new Color(n3, n4, n5, n6).getRGB());
            f4 += (float)agc2.getStringWidth(String.valueOf(c2));
        }
    }

    private static String mr() {
        StringBuilder stringBuilder = new StringBuilder(4096);
        for (char c2 = '\u0000'; c2 < '\uffff'; c2 = (char)(c2 + '\u0001')) {
            if (!ChatAllowedCharacters.isAllowedCharacter(c2) && c2 != 32) continue;
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    @Generated
    public NumberValue ms() {
        return this.openHeight;
    }

    @Generated
    public NumberValue mt() {
        return this.width;
    }

    @Generated
    public NumberValue mu() {
        return this.maxClosedHeight;
    }

    @Generated
    public NumberValue mv() {
        return this.messageDisappearanceSpeed;
    }

    @Generated
    public BooleanValue mw() {
        return this.background;
    }

    @Generated
    public BooleanValue mx() {
        return this.hidePlayerSourceMessages;
    }

    @Generated
    public BooleanValue my() {
        return this.imageChat;
    }

    @Generated
    public yf mz() {
        return this.aqD;
    }

    @Generated
    public DragValue mA() {
        return this.aqE;
    }

    @Generated
    public Animation mB() {
        return this.aqF;
    }

    @Generated
    public Animation mC() {
        return this.aqG;
    }

    @Generated
    public Animation mD() {
        return this.aqH;
    }

    @Generated
    public Animation mE() {
        return this.aqI;
    }

    @Generated
    public agk mF() {
        return this.aqJ;
    }

    @Generated
    public agc mG() {
        return this.aqK;
    }

    @Generated
    public agc mH() {
        return this.aqL;
    }

    @Generated
    public BooleanValue mI() {
        return this.pinyinChineseIME;
    }

    @Generated
    public int mJ() {
        return this.aqS;
    }

    @Generated
    public String mK() {
        return this.aqT;
    }

    @Generated
    public TextBox mL() {
        return this.aqU;
    }

    @Generated
    public int mM() {
        return this.aqV;
    }

    @Generated
    public int mN() {
        return this.aqW;
    }

    @Generated
    public float mO() {
        return this.aqX;
    }

    @Generated
    public boolean mP() {
        return this.amX;
    }

    @Generated
    public boolean kb() {
        return this.ads;
    }

    @Generated
    public rip.vantage.commons.util.time.a mQ() {
        return this.bN;
    }

    @Generated
    public adz<String> mR() {
        return this.aqY;
    }

    @Generated
    public ArrayList<String> mS() {
        return this.aqZ;
    }

    @Generated
    public Interface mT() {
        return this.amf;
    }

    @Generated
    public Listener<KeyboardInputEvent> mU() {
        return this.onKeyboardInput;
    }

    @Generated
    public Listener<PacketReceiveEvent> mV() {
        return this.onPacketReceive;
    }

    @Generated
    public Listener<dt> mW() {
        return this.arc;
    }

    @Generated
    public Listener<Render2DEvent> lW() {
        return this.onRender2D;
    }
}
