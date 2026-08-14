package com.alan.clients.script.api;

import com.alan.clients.Client;
import com.alan.clients.script.api.wrapper.impl.ScriptItemStack;
import com.alan.clients.script.api.wrapper.impl.ScriptMCFontRenderer;
import com.alan.clients.script.api.wrapper.impl.ScriptRiseFontRenderer;
import com.alan.clients.script.api.wrapper.impl.vector.ScriptVector3d;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import hackclient.rise.adv;
import hackclient.rise.agf;
import hackclient.rise.cl;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import javax.script.ScriptException;
import net.minecraft.client.renderer.entity.RenderManager;
import org.openjdk.nashorn.api.scripting.JSObject;

public class RenderAPI extends API implements InstanceAccess {
    public RenderAPI() {
    }

    public ScriptVector3d getCameraPosition() {
        MC.getRenderManager();
        double d0 = RenderManager.bUO;
        MC.getRenderManager();
        double d1 = RenderManager.bUP;
        MC.getRenderManager();
        return new ScriptVector3d(d0, d1, RenderManager.bUQ);
    }

    public static Color intArrayToColor(int[] var0) {
        int[] aint = Arrays.stream(var0).map(var0x -> Math.min(var0x, 255)).toArray();
        return new Color(aint[0], aint[1], aint[2], aint.length >= 4 ? aint[3] : 255);
    }

    public void rectangle(double var1, double var3, double var5, double var7, int[] var9) throws ScriptException {
        try {
            RenderUtil.d(var1, var3, var5, var7, intArrayToColor(var9));
        } catch (Exception exception) {
            throw new ScriptException("Not enough elements in the array!");
        }
    }

    public void rectangle(double var1, double var3, double var5, double var7) {
        RenderUtil.rectangle(var1, var3, var5, var7);
    }

    public void rainbowRectangle(double var1, double var3, double var5, double var7) {
        RenderUtil.rainbowRectangle(var1, var3, var5, var7);
    }

    public void roundedRectangle(double var1, double var3, double var5, double var7, double var9, int[] var11) {
        RenderUtil.roundedRectangle(var1, var3, var5, var7, var9, intArrayToColor(var11));
    }

    public void roundedOutlineRectangle(double var1, double var3, double var5, double var7, double var9, double var11, int[] var13) {
        RenderUtil.roundedOutlineRectangle(var1, var3, var5, var7, var9, var11, intArrayToColor(var13));
    }

    public void centeredRectangle(double var1, double var3, double var5, double var7, int[] var9) throws ScriptException {
        try {
            RenderUtil.d(var1 - var5 / 2.0, var3 - var7 / 2.0, var5, var7, intArrayToColor(var9));
        } catch (Exception exception) {
            throw new ScriptException("Not enough elements in the array!");
        }
    }

    public void centeredRectangle(double var1, double var3, double var5, double var7) {
        RenderUtil.rectangle(var1 - var5 / 2.0, var3 - var7 / 2.0, var5, var7);
    }

    public void smoothCamera() {
        cl.cn();
    }

    public void renderItemIcon(double var1, double var3, int var5, ScriptItemStack var6) {
        RenderUtil.a(var1, var3, var5, var6.getWrapped());
    }

    public void drawLine3D(double var1, double var3, double var5, double var7, double var9, double var11, int[] var13, float var14) {
        RenderUtil.drawLine(var1, var3, var5, var7, var9, var11, intArrayToColor(var13), var14);
    }

    public void drawLine3D(ScriptVector3d var1, ScriptVector3d var2, int[] var3, float var4) {
        this.drawLine3D(var1.getX(), var1.getY(), var1.getZ(), var2.getX(), var2.getY(), var2.getZ(), var3, var4);
    }

    public ScriptMCFontRenderer getMinecraftFontRenderer() {
        return new ScriptMCFontRenderer(MC.fontRendererObj);
    }

    public ScriptRiseFontRenderer getMainFontRenderer(int var1) {
        return new ScriptRiseFontRenderer((agf)gb.MAIN.a(var1, gd.REGULAR));
    }

    public ScriptRiseFontRenderer getMainFontRendererBold(int var1) {
        return new ScriptRiseFontRenderer((agf)gb.MAIN.a(var1, gd.BOLD));
    }

    public ScriptRiseFontRenderer getMainFontRendererMedium(int var1) {
        return new ScriptRiseFontRenderer((agf)gb.MAIN.a(var1, gd.MEDIUM));
    }

    public ScriptRiseFontRenderer getMainFontRendererLight(int var1) {
        return new ScriptRiseFontRenderer((agf)gb.MAIN.a(var1, gd.LIGHT));
    }

    public ScriptRiseFontRenderer getCustomFontRenderer(String var1, int var2, boolean var3) {
        return new ScriptRiseFontRenderer(new agf(new Font(var1, 0, var2), var3));
    }

    public ScriptRiseFontRenderer getCustomFontRendererBold(String var1, int var2, boolean var3) {
        return new ScriptRiseFontRenderer(new agf(new Font(var1, 1, var2), var3));
    }

    public ScriptRiseFontRenderer getCustomFontRendererItalic(String var1, int var2, boolean var3) {
        return new ScriptRiseFontRenderer(new agf(new Font(var1, 2, var2), var3));
    }

    public ScriptRiseFontRenderer getCustomFontRendererBoldItalic(String var1, int var2, boolean var3) {
        return new ScriptRiseFontRenderer(new agf(new Font(var1, 3, var2), var3));
    }

    public float getEyeHeight() {
        return MC.thePlayer.getEyeHeight();
    }

    public int[] getThemeColor() {
        int[] aint = new int[4];
        Color color = Client.a.k().rz().rA();
        aint[0] = color.getRed();
        aint[1] = color.getGreen();
        aint[2] = color.getBlue();
        aint[3] = color.getAlpha();
        return aint;
    }

    public int[] getSecondaryColor() {
        int[] aint = new int[4];
        Color color = Client.a.k().rz().rB();
        aint[0] = color.getRed();
        aint[1] = color.getGreen();
        aint[2] = color.getBlue();
        aint[3] = color.getAlpha();
        return aint;
    }

    public void blur(JSObject var1) throws ScriptException {
        if (!var1.isFunction()) {
            throw new ScriptException("Not a function!");
        }

        this.b(gg.BLUR).c(() -> var1.call(null));
    }

    public void postBloom(JSObject var1) throws ScriptException {
        this.bloom(var1);
    }

    public void bloom(JSObject var1) throws ScriptException {
        if (!var1.isFunction()) {
            throw new ScriptException("Not a function!");
        }

        this.b(gg.BLOOM).c(() -> var1.call(null));
    }

    public int[] getBackgroundShade() {
        this.rz();
        Color color = adv.rK();
        return new int[]{color.getRed(), color.getBlue(), color.getGreen(), color.getAlpha()};
    }

    public int[] getDropShadow() {
        Color color = this.rz().rE();
        return new int[]{color.getRed(), color.getBlue(), color.getGreen(), color.getAlpha()};
    }
}
