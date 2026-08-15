package com.alan.clients.util.gui.textbox;

import com.alan.clients.util.font.FontManager;
import com.alan.clients.util.gui.GUIUtil;
import com.alan.clients.util.vector.Vector2d;
import hackclient.rise.agc;
import hackclient.rise.agl;
import hackclient.rise.gd;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import lombok.Generated;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;
import rip.vantage.commons.util.time.a;

public class TextBox {
    public String XS = "";
    public boolean ayU;
    public int aJk;
    public Vector2d position;
    public float width;
    public agc lq;
    public Color color;
    public agl aJl;
    public String aJm;
    public boolean aJn;
    private int aJo;
    private int aJp = 32767;
    private String aJq = tN();
    private double gW;
    private double aJr;
    private double aJs;
    private float aJt;
    private float aJu;
    public a aJv = new a();

    public TextBox(Vector2d position, agc var2, Color color, agl var4, String var5, float width, boolean var7) {
        this.position = position;
        this.lq = var2;
        this.color = color;
        this.aJl = var4;
        this.aJm = var5;
        this.width = width;
        this.aJn = var7;
    }

    public TextBox(Vector2d vector2d, agc var2, Color var3, agl var4, String var5, float var6) {
        this(vector2d, var2, var3, var4, var5, var6, false);
    }

    public TextBox(Vector2d vector2d, agc var2, Color var3, agl var4, String var5, float var6, String var7) {
        this(vector2d, var2, var3, var4, var5, var6, false);
        this.aJq = var7;
    }

    public void draw() {
        this.aJv.aX();
        Keyboard.enableRepeatEvents(true);
        this.aJk = Math.max(0, Math.min(this.aJk, this.XS.length()));
        this.aJu = (float)this.position.y;
        boolean flag = this.isEmpty();
        String s = flag ? this.aJm : (this.aJn ? "*".repeat(this.XS.length()) : this.XS);
        String s1;
        if (flag) {
            this.aJo = 0;
            s1 = s;
        } else {
            this.aJo = this.bU(s);
            s1 = s.substring(this.aJo);

            while (this.lq.getStringWidth(s1) > this.width && !s1.isEmpty()) {
                s1 = s1.substring(0, s1.length() - 1);
            }
        }

        float f = this.lq.getStringWidth(s1);
        double d0 = System.currentTimeMillis();
        double d1 = Math.min(Math.abs(d0 - this.aJs), 500.0);
        this.aJs = d0;
        switch (this.aJl) {
            case CENTER:

                for (int i = 0; i < d1; i++) {
                    this.gW = (this.gW * 19.0 + (this.position.x - f / 2.0F)) / 20.0;
                }
                break;
            case LEFT:
            default:
                this.gW = this.position.x;
        }

        if (flag) {
            this.lq
                .a(
                    s1,
                    this.gW,
                    this.position.y,
                    new Color(this.color.getRed(), this.color.getBlue(), this.color.getGreen(), (int)(this.color.getAlpha() * (this.ayU ? 0.3F : 0.2F))).hashCode()
                );
        } else {
            this.lq.a(s1, this.gW, this.position.y, this.color.hashCode());
        }

        if (this.ayU) {
            String s2 = this.c(s, this.aJo, this.aJk);
            float f1 = this.lq.getStringWidth(s2);
            this.aJt = (float)(this.gW + f1);

            for (int j = 0; j < d1; j++) {
                this.aJr = (this.aJr * 19.0 + (f1 - 2.0F)) / 20.0;
            }

            (this.lq == Minecraft.getMinecraft().fontRendererObj ? FontManager.MAIN.a(18, gd.REGULAR) : this.lq)
                .a(
                    "|",
                    (float)(this.gW + this.aJr + 1.0),
                    this.position.y - 1.0,
                    new Color(
                            this.color.getRed(),
                            this.color.getBlue(),
                            this.color.getGreen(),
                            this.color.getAlpha() == 0 ? 0 : (int)((Math.sin(System.currentTimeMillis() / 150.0) + 1.0) / 2.0 * 255.0)
                        )
                        .hashCode()
                );
        }
    }

    public float tL() {
        return this.aJt;
    }

    public float tM() {
        return this.aJu;
    }

    private int bU(String var1) {
        if (this.lq.getStringWidth(var1) <= this.width) {
            return 0;
        }

        int i = this.aJk;

        while (i > 0 && this.lq.getStringWidth(var1.substring(i - 1, this.aJk)) < this.width) {
            i--;
        }

        return i;
    }

    private String c(String var1, int var2, int var3) {
        int i = Math.max(0, Math.min(var2, var1.length()));
        int j = Math.max(i, Math.min(var3, var1.length()));
        return var1.substring(i, j);
    }

    public void click(int var1, int var2, int var3) {
        Vector2d vector2d = this.getPosition();
        boolean flag = GUIUtil.c(vector2d.x + (this.aJl == agl.CENTER ? -this.width / 2.0F : 0.0F), vector2d.y, this.width, this.lq.height(), var1, var2);
        this.ayU = var3 == 0 && flag;
        if (this.ayU) {
            this.aJk = this.XS.length();
        }
    }

    public void key(char var1, int var2) {
        if (this.ayU && var2 != 28) {
            this.aJk = Math.max(0, Math.min(this.aJk, this.XS.length()));
            String s = String.valueOf(var1);
            boolean flag = Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) || Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
            if (var2 != 208 && var2 != 200) {
                if (flag && var2 == 47) {
                    try {
                        String s1 = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                        int i = this.XS.length();
                        this.addText(s1, this.aJk);
                        this.aJk = this.aJk + (this.XS.length() - i);
                    } catch (UnsupportedFlavorException | IOException unsupportedflavorexception) {
                    }
                } else if (flag && var2 == 46) {
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(this.XS), null);
                } else if (var2 == 211 && !this.XS.isEmpty()) {
                    this.aq(this.aJk + 1);
                } else if (var2 == 14 && !this.XS.isEmpty()) {
                    this.aq(this.aJk);
                    this.aJk--;
                    if (flag) {
                        while (this.aJk > 0) {
                            this.aq(this.aJk);
                            this.aJk--;
                        }
                    }
                } else if (var2 == 205) {
                    this.aJk++;
                    if (flag) {
                        this.aJk = this.XS.length();
                    }
                } else if (var2 == 203) {
                    this.aJk--;
                    if (flag) {
                        this.aJk = 0;
                    }
                } else {
                    if (this.m(var1)) {
                        int j = this.XS.length();
                        this.addText(s, this.aJk);
                        if (this.XS.length() > j) {
                            this.aJk++;
                        }
                    }

                    this.aJk = Math.max(0, Math.min(this.aJk, this.XS.length()));
                }
            }
        }
    }

    public int bV(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            this.aJk = Math.max(0, Math.min(this.aJk, this.XS.length()));
            int i = this.XS.length();
            this.addText(var1, this.aJk);
            int j = this.XS.length() - i;
            if (j > 0) {
                this.aJk = Math.max(0, Math.min(this.aJk + j, this.XS.length()));
            }

            return j;
        }
        return 0;
    }

    private boolean m(char var1) {
        if (var1 == 0) {
            return false;
        } else if (var1 == '\n' || var1 == '\r' || var1 == '\t') {
            return false;
        }
        return this.aJq != null && !this.aJq.isEmpty() ? this.aJq.indexOf(var1) >= 0 || this.aJq.indexOf(Character.toLowerCase(var1)) >= 0 : true;
    }

    private void addText(String var1, int var2) {
        if (var1 != null && !var1.isEmpty()) {
            StringBuilder stringbuilder = new StringBuilder(var1.length());

            for (int i = 0; i < var1.length(); i++) {
                char c0 = var1.charAt(i);
                if (this.m(c0)) {
                    stringbuilder.append(c0);
                }
            }

            if (stringbuilder.length() != 0) {
                if (this.XS.length() + stringbuilder.length() <= this.aJp) {
                    int j = Math.max(0, Math.min(var2, this.XS.length()));
                    StringBuilder stringbuilder1 = new StringBuilder(this.XS);
                    stringbuilder1.insert(j, stringbuilder);
                    this.XS = stringbuilder1.toString();
                }
            }
        }
    }

    private void aq(int var1) {
        if (var1 > 0 && var1 <= this.XS.length()) {
            this.XS = new StringBuilder(this.XS).deleteCharAt(var1 - 1).toString();
        }
    }

    public boolean isEmpty() {
        return this.XS.trim().isEmpty();
    }

    private static String tN() {
        StringBuilder stringbuilder = new StringBuilder(4096);

        for (char c0 = 0; c0 < '\uffff'; c0++) {
            if (ChatAllowedCharacters.isAllowedCharacter(c0) || c0 == ' ') {
                stringbuilder.append(c0);
            }
        }

        return stringbuilder.toString();
    }

    @Generated
    public String getText() {
        return this.XS;
    }

    @Generated
    public boolean tO() {
        return this.ayU;
    }

    @Generated
    public int tP() {
        return this.aJk;
    }

    @Generated
    public Vector2d getPosition() {
        return this.position;
    }

    @Generated
    public float ty() {
        return this.width;
    }

    @Generated
    public agc eb() {
        return this.lq;
    }

    @Generated
    public Color getColor() {
        return this.color;
    }

    @Generated
    public agl tQ() {
        return this.aJl;
    }

    @Generated
    public String tR() {
        return this.aJm;
    }

    @Generated
    public boolean tS() {
        return this.aJn;
    }

    @Generated
    public int tT() {
        return this.aJo;
    }

    @Generated
    public int tU() {
        return this.aJp;
    }

    @Generated
    public String tV() {
        return this.aJq;
    }

    @Generated
    public double getPosX() {
        return this.gW;
    }

    @Generated
    public double tW() {
        return this.aJr;
    }

    @Generated
    public double tX() {
        return this.aJs;
    }

    @Generated
    public a tY() {
        return this.aJv;
    }

    @Generated
    public void bW(String var1) {
        this.XS = var1;
    }

    @Generated
    public void I(boolean var1) {
        this.ayU = var1;
    }

    @Generated
    public void ar(int var1) {
        this.aJk = var1;
    }

    @Generated
    public void h(Vector2d var1) {
        this.position = var1;
    }

    @Generated
    public void z(float width) {
        this.width = width;
    }

    @Generated
    public void c(agc var1) {
        this.lq = var1;
    }

    @Generated
    public void setColor(Color color) {
        this.color = color;
    }

    @Generated
    public void a(agl var1) {
        this.aJl = var1;
    }

    @Generated
    public void bX(String var1) {
        this.aJm = var1;
    }

    @Generated
    public void J(boolean var1) {
        this.aJn = var1;
    }

    @Generated
    public void as(int var1) {
        this.aJo = var1;
    }

    @Generated
    public void at(int var1) {
        this.aJp = var1;
    }

    @Generated
    public void bY(String var1) {
        this.aJq = var1;
    }

    @Generated
    public void setPosX(double var1) {
        this.gW = var1;
    }

    @Generated
    public void W(double var1) {
        this.aJr = var1;
    }

    @Generated
    public void X(double var1) {
        this.aJs = var1;
    }

    @Generated
    public void A(float var1) {
        this.aJt = var1;
    }

    @Generated
    public void B(float var1) {
        this.aJu = var1;
    }

    @Generated
    public void e(a var1) {
        this.aJv = var1;
    }
}
