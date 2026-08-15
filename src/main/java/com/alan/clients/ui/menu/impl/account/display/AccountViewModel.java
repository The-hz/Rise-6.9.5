package com.alan.clients.ui.menu.impl.account.display;

import com.alan.clients.ui.menu.impl.account.impl.RenameAccountScreen;
import com.alan.clients.util.animation.Animation;
import com.alan.clients.util.animation.Easing;
import com.alan.clients.util.interfaces.InstanceAccess;
import com.alan.clients.util.render.RenderUtil;
import hackclient.rise.adf;
import hackclient.rise.ui.menu.adl;
import com.alan.clients.ui.theme.Themes;
import com.alan.clients.util.MouseUtil;
import com.alan.clients.util.SkinUtil;
import hackclient.rise.aei;
import hackclient.rise.AltAccount;
import hackclient.rise.aep;
import hackclient.rise.aeq;
import hackclient.rise.agc;
import com.alan.clients.util.render.ColorUtil;
import hackclient.rise.ais;
import com.alan.clients.util.font.FontManager;
import hackclient.rise.gd;
import hackclient.rise.gg;
import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import lombok.Generated;

public class AccountViewModel<T extends AltAccount> implements adf, InstanceAccess {
    private static final agc FONT_RENDERER = FontManager.MAIN.a(24, gd.BOLD);
    private static final agc INFO_FONT_RENDERER = FontManager.MAIN.a(18, gd.MEDIUM);
    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(3);
    private static final Color BLOOM_COLOR = ColorUtil.d(Color.BLACK, 150);
    private static final Color FONT_COLOR = ColorUtil.d(Color.WHITE, 150);
    private static final Color INFO_COLOR = ColorUtil.d(FONT_COLOR.darker(), 150);
    private static final Color BACKGROUND_COLOR = ColorUtil.d(aBV, 50);
    private static final Color BORDER_ONE_COLOR = ColorUtil.d(aBP, 32);
    private static final Color BORDER_TWO_COLOR = ColorUtil.d(aBO, 32);
    private final Animation hoverAnimation;
    private final Animation positionAnimation;
    private T account;
    private float x;
    private float y;
    private double scroll;
    private float width;
    private float height;
    private int screenHeight;
    private boolean removable;
    private adl[] labelButtons;
    private final Runnable defaultRenderRunnable = () -> {
        RenderUtil.roundedRectangle(this.x, this.y + this.scroll, this.width, this.height, 5.0, BACKGROUND_COLOR);
        RenderUtil.roundedOutlineGradientRectangle(this.x, this.y + this.scroll, this.width, this.height, 5.0, 1.0, BORDER_ONE_COLOR, BORDER_TWO_COLOR);
        this.renderHead(this.x + 4.0F, this.y + 4.0F + this.scroll, 32);
        FONT_RENDERER.a(this.account.getName(), this.x + 40.0F, this.y + 6.0F + this.scroll, FONT_COLOR.getRGB());
        String s = this.account.sj() < 31536000000L ? "Not yet" : DATE_FORMAT.format(new Date(this.account.sj()));
        INFO_FONT_RENDERER.a("Last login: " + s, this.x + 40.0F, this.y + 19.0F + this.scroll, INFO_COLOR.getRGB());
        INFO_FONT_RENDERER.a("Actions:", this.x + 40.0F, this.y + 29.0F + this.scroll, INFO_COLOR.getRGB());

        for (adl adl : this.labelButtons) {
            adl.setY(adl.getY() + this.scroll);
            adl.draw(0, 0, 0.0F);
            adl.setY(adl.getY() - this.scroll);
        }
    };
    private final Runnable invalidRenderRunnable = () -> {
        RenderUtil.roundedRectangle(this.x, this.y, this.width, this.height, 5.0, BACKGROUND_COLOR);
        RenderUtil.roundedOutlineGradientRectangle(this.x, this.y, this.width, this.height, 5.0, 1.0, BORDER_ONE_COLOR, BORDER_TWO_COLOR);
        this.renderInvalidHead(this.x + 4.0F, this.y + 4.0F, 32);
        FONT_RENDERER.a("Waiting...", this.x + 40.0F, this.y + 6.0F, FONT_COLOR.getRGB());
        INFO_FONT_RENDERER.a("Last login: -", this.x + 40.0F, this.y + 19.0F, INFO_COLOR.getRGB());
        INFO_FONT_RENDERER.a("Actions: -", this.x + 40.0F, this.y + 29.0F, INFO_COLOR.getRGB());
    };
    private final Runnable bloomRunnable = () -> RenderUtil.roundedRectangle(
        this.x + 0.5F, this.y + 0.5F + this.scroll, this.width - 1.0F, this.height - 1.0F, 6.0, BLOOM_COLOR
    );

    public AccountViewModel(T account, float var2, float var3, float width, float height) {
        this.account = account;
        this.x = var2;
        this.y = var3;
        this.width = width;
        this.height = height;
        this.hoverAnimation = new Animation(Easing.EASE_OUT_CUBIC, 200L);
        this.positionAnimation = new Animation(Easing.EASE_OUT_CUBIC, 200L);
        if (!(account instanceof aep) && !(account instanceof aeq)) {
            byte b0 = 2;
            this.labelButtons = new adl[]{
                new adl(var2 + 76.0F, var3 + height - 12.0F, 28.0, 8.0, () -> aEg.displayGuiScreen(new RenameAccountScreen(this)), "Rename", Color.YELLOW),
                new adl(var2 + 76.0F + 28.0F + b0, var3 + height - 12.0F, 24.0, 8.0, () -> this.removable = true, "Delete", Color.RED)
            };
        } else {
            this.labelButtons = new adl[]{new adl(var2 + 76.0F, var3 + height - 12.0F, 24.0, 8.0, () -> this.removable = true, "Delete", Color.RED)};
        }
    }

    public boolean draw() {
        if (this.isOutOfScreen()) {
            return false;
        }

        this.b(gg.BLOOM).c(this.bloomRunnable);
        if (this.account.kW()) {
            this.b(gg.REGULAR).c(this.defaultRenderRunnable);
        } else {
            this.b(gg.REGULAR).c(this.invalidRenderRunnable);
        }

        return true;
    }

    public boolean mouseClicked(int var1, int var2, int var3) {
        if (var3 != 0) {
            return false;
        }

        if (!MouseUtil.isHovered(this.x, this.y + this.scroll, this.width, this.height, var1, var2)) {
            return false;
        }

        if (this.account.kW()) {
            for (adl adl : this.labelButtons) {
                if (MouseUtil.isHovered(adl.getX(), adl.getY() + this.scroll, adl.oM(), adl.da(), var1, var2)) {
                    adl.runAction();
                    return true;
                }
            }
        }

        return this.account.se();
    }

    private void renderHead(double var1, double var3, int var5) {
        ais.vK();
        ais.vL();
        double d0 = var5;
        double d1 = var5;
        this.rz();
        RenderUtil.roundedRectangle(var1, var3, d0, d1, 5.0, Themes.rK());
        ais.aD(1);
        RenderUtil.image(SkinUtil.a(aei.SKIN, this.account.sh(), 24), var1, var3, var5, var5, ColorUtil.d(Color.WHITE, (int)(200.0 + this.hoverAnimation.sG())));
        ais.vM();
    }

    private void renderInvalidHead(double var1, double var3, int var5) {
        double d0 = Math.sin(System.currentTimeMillis() * 0.003) * -0.5 + 0.5;
        Color color = Color.getHSBColor(1.0F, 0.0F, (float)(d0 * 0.25) + 0.5F);
        RenderUtil.roundedRectangle(var1, var3, var5, var5, 5.0, color);
    }

    public boolean update() {
        if (!this.account.kW()) {
            return false;
        }

        this.positionAnimation.Q(this.y);
        return true;
    }

    private void addScrollOffset(float scrollOffset) {
        this.y += scrollOffset;
    }

    private boolean isOutOfScreen() {
        double d0 = this.y + this.scroll;
        return d0 + this.height < 0.0 || d0 > this.screenHeight;
    }

    public boolean isRemovable() {
        return this.removable || !this.account.kW();
    }

    @Generated
    public T getAccount() {
        return this.account;
    }

    @Generated
    public void setScroll(double scroll) {
        this.scroll = scroll;
    }

    @Generated
    public float getHeight() {
        return this.height;
    }

    @Generated
    public int getScreenHeight() {
        return this.screenHeight;
    }

    @Generated
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
}
