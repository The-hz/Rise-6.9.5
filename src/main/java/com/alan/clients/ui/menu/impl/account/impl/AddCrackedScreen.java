package com.alan.clients.ui.menu.impl.account.impl;

import com.alan.clients.ui.menu.impl.account.AccountManagerScreen;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import com.alan.clients.util.vector.Vector2d;
import com.alan.clients.ui.menu.component.button.MenuButton;
import com.alan.clients.ui.menu.component.button.impl.MenuTextButton;
import com.alan.clients.util.MouseUtil;
import hackclient.rise.aeo;
import hackclient.rise.aff;
import hackclient.rise.agc;
import hackclient.rise.agl;
import hackclient.rise.agm;
import hackclient.rise.aiv;
import hackclient.rise.aiz;
import hackclient.rise.gb;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class AddCrackedScreen extends GuiScreen implements InstanceAccess {
    private static final agc FONT_RENDERER = gb.MAIN.a(36, gd.BOLD);
    private final MenuButton[] menuButtons = new MenuButton[5];
    private static agm usernameBox;
    private static GuiScreen reference;
    private Animation animation;
    private static final Runnable TEXT_BOX_RUNNABLE = () -> usernameBox.I(true);
    private static final Runnable CANCEL_RUNNABLE = () -> aEg.displayGuiScreen(new AccountManagerScreen(reference));
    private static final Runnable GENERATE_RANDOM_RUNNABLE = () -> new Thread(() -> {
        String s = aff.sy();
        if (s != null && validate(s)) {
            usernameBox.bW(s);
        }
    }, "Account generation thread").start();
    private static final Runnable ADD_RUNNABLE = () -> {
        String s = usernameBox.XS;
        if (validate(s)) {
            aeo aeo = new aeo(s);
            AccountManagerScreen.addAccount(aeo);
            aeo.se();
            CANCEL_RUNNABLE.run();
        }
    };
    private static final Runnable LOGIN_RUNNABLE = () -> {
        String s = usernameBox.XS;
        if (validate(s)) {
            new aeo(s).se();
            CANCEL_RUNNABLE.run();
        }
    };
    private static final Runnable BACKGROUND_RUNNABLE = () -> {
        ScaledResolution scaledresolution = new ScaledResolution(aEg);
        RenderUtil.d(0.0, 0.0, scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight(), Color.BLACK);
    };

    public AddCrackedScreen() {
        reference = this;
    }

    @Override
    public void drawScreen(int var1, int var2, float var3) {
        this.animation.Q(0.0);
        aiv.aPL.a(aiz.OVERLAY, var3, null);
        this.b(gg.BLUR).c(BACKGROUND_RUNNABLE);
        MenuButton[] aadh = this.menuButtons;
        int i = aadh.length;

        for (int j = 0; j < i; j++) {
            aadh[j].draw(var1, var2, var3);
        }

        this.b(gg.REGULAR).c(() -> {
            FONT_RENDERER.c("Select your username", this.width / 2, this.height / 2 - 64 + this.animation.sG(), Color.WHITE.getRGB());
            usernameBox.draw();
        });
    }

    @Override
    public void mouseClicked(int var1, int var2, int var3) {
        usernameBox.click(var1, var2, var3);

        for (MenuButton adh : this.menuButtons) {
            if (MouseUtil.isHovered(adh.getX(), adh.getY(), adh.oM(), adh.da(), var1, var2)) {
                adh.runAction();
                break;
            }
        }
    }

    @Override
    protected void keyTyped(char var1, int var2) {
        if (usernameBox.tO()) {
            usernameBox.key(var1, var2);
        }
    }

    @Override
    public void initGui() {
        short short1 = 200;
        byte b0 = 24;
        byte b1 = 4;
        float f = 192 / 3.0F;
        Vector2d vector2d = new Vector2d(this.width / 2 - 100, this.height / 2 - 24);
        usernameBox = new agm(vector2d.offset(100, 8.0), gb.MAIN.a(24, gd.BOLD), Color.WHITE, agl.CENTER, "Username", short1);
        this.menuButtons[0] = new MenuTextButton(vector2d.x, vector2d.y, short1, b0, TEXT_BOX_RUNNABLE, "");
        this.menuButtons[1] = new MenuTextButton(vector2d.x, vector2d.y + b0 + b1, short1, b0, GENERATE_RANDOM_RUNNABLE, "Generate random");
        this.menuButtons[2] = new MenuTextButton(vector2d.x, vector2d.y + (b0 + b1) * 2, f, b0, ADD_RUNNABLE, "Add");
        this.menuButtons[3] = new MenuTextButton(vector2d.x + f + b1, vector2d.y + (b0 + b1) * 2, f, b0, LOGIN_RUNNABLE, "Login");
        this.menuButtons[4] = new MenuTextButton(vector2d.x + (f + b1) * 2.0F, vector2d.y + (b0 + b1) * 2, f, b0, CANCEL_RUNNABLE, "Cancel");
        this.animation = new Animation(Easing.EASE_OUT_QUINT, 600L);
        this.animation.R(-200.0);
    }

    private static boolean validate(String var0) {
        if (var0.length() >= 3 && var0.length() <= 16) {
            for (char c0 : var0.toCharArray()) {
                if (!Character.isLetterOrDigit(c0) && c0 != '_') {
                    return false;
                }
            }

            return true;
        }
        return false;
    }
}
