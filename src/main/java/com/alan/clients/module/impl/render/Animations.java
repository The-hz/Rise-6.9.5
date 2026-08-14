package com.alan.clients.module.impl.render;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.module.impl.movement.TerrainSpeed;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.render.RenderItemEvent;
import com.alan.clients.newevent.impl.render.SwingAnimationEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.abs;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemMap;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@ModuleInfo(aliases = "module.render.animations.name", description = "module.render.animations.description", category = Category.RENDER)
public final class Animations extends Module {
    private final ModeValue akK = new ModeValue("Block Animation", this)
        .add(new SubMode("None"))
        .add(new SubMode("1.7"))
        .add(new SubMode("1.7 Accurate"))
        .add(new SubMode("Sunny"))
        .add(new SubMode("Lucid"))
        .add(new SubMode("Astro"))
        .add(new SubMode("Smooth"))
        .add(new SubMode("Spin"))
        .add(new SubMode("Leaked"))
        .add(new SubMode("Old"))
        .add(new SubMode("Exhibition"))
        .add(new SubMode("Exhibition Old"))
        .add(new SubMode("Exhibition New"))
        .add(new SubMode("Swong"))
        .add(new SubMode("Stella"))
        .add(new SubMode("Flup"))
        .add(new SubMode("Noov"))
        .add(new SubMode("Komorebi"))
        .add(new SubMode("Rhys"))
        .add(new SubMode("Swing"))
        .add(new SubMode("?"))
        .add(new SubMode("Stab"))
        .add(new SubMode("Beta"))
        .add(new SubMode("Dortware"))
        .add(new SubMode("Avatar"))
        .add(new SubMode("Tap"))
        .add(new SubMode("XIV"))
        .setDefault("None");
    public final ModeValue akL = new ModeValue("Swing Animation", this)
        .add(new SubMode("None"))
        .add(new SubMode("Punch"))
        .add(new SubMode("Shove"))
        .add(new SubMode("Smooth"))
        .add(new SubMode("1.9+"))
        .setDefault("None");
    private final BooleanValue akM = new BooleanValue("Update Position Only When Blocking", this, true);
    public final NumberValue akN = new NumberValue("Swing Speed", this, 1, -200, 50, 1);
    private final NumberValue akO = new NumberValue("X", this, 0.0F, -2.0F, 2.0F, 0.05F);
    private final NumberValue akP = new NumberValue("Y", this, 0.0F, -2.0F, 2.0F, 0.05F);
    private final NumberValue akQ = new NumberValue("Z", this, 0.0F, -2.0F, 2.0F, 0.05F);
    private final NumberValue akR = new NumberValue("Scale", this, 1, 0.1, 2, 0.1);
    private final BooleanValue akS = new BooleanValue("Always Show", this, false);
    @EventLink
    public final Listener<RenderItemEvent> akT = var1 -> {
        if (!(var1.dG().getItem() instanceof ItemMap)) {
            if (!this.akM.wo()) {
                GlStateManager.translate(this.akO.wo().floatValue(), this.akP.wo().floatValue(), this.akQ.wo().floatValue());
            }

            double d0 = 0.0;
            double d1 = this.akR.wo().doubleValue();
            EnumAction enumaction = var1.dD();
            ItemRenderer itemrenderer = aEg.getItemRenderer();
            float f = this.akS.wo() && var1.db() ? 0.0F : var1.dE();
            float f1 = var1.dF();
            float f2 = MathHelper.sin(MathHelper.sqrt_float(f1) * (float)abs.aHb);
            if (var1.db() && enumaction == EnumAction.BLOCK) {
                if (this.akM.wo()) {
                    GlStateManager.translate(this.akO.wo().floatValue(), this.akP.wo().floatValue(), this.akQ.wo().floatValue());
                }

                label274: {
                    label273: {
                        label272: {
                            label271: {
                                label270: {
                                    label269: {
                                        label268: {
                                            label267: {
                                                label266: {
                                                    label265: {
                                                        label264: {
                                                            label263: {
                                                                label262: {
                                                                    label261: {
                                                                        label260: {
                                                                            label259: {
                                                                                label258: {
                                                                                    label257: {
                                                                                        label256: {
                                                                                            label255: {
                                                                                                label254: {
                                                                                                    label253: {
                                                                                                        label252: {
                                                                                                            label251: {
                                                                                                                label250: {
                                                                                                                    label293: {
                                                                                                                        label248: {
                                                                                                                            String s = this.akK.wo().getName();
                                                                                                                            byte b0 = -1;
                                                                                                                            switch (s.hashCode()) {
                                                                                                                                case -2022880414:
                                                                                                                                    if (s.equals("Leaked")) {
                                                                                                                                        byte b12 = 13;
                                                                                                                                        break label262;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case -1814666802:
                                                                                                                                    if (s.equals("Smooth")) {
                                                                                                                                        byte b9 = 10;
                                                                                                                                        break label265;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case -1808503203:
                                                                                                                                    if (s.equals("Stella")) {
                                                                                                                                        byte b18 = 19;
                                                                                                                                        break label256;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case -1135075377:
                                                                                                                                    if (s.equals(
                                                                                                                                        "Exhibition New"
                                                                                                                                    )) {
                                                                                                                                        byte b16 = 17;
                                                                                                                                        break label258;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case -1135074218:
                                                                                                                                    if (s.equals(
                                                                                                                                        "Exhibition Old"
                                                                                                                                    )) {
                                                                                                                                        byte b15 = 16;
                                                                                                                                        break label259;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case -1019669830:
                                                                                                                                    if (s.equals("1.7 Accurate")
                                                                                                                                        )
                                                                                                                                     {
                                                                                                                                        byte b1 = 2;
                                                                                                                                        break label272;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case -352259601:
                                                                                                                                    if (s.equals("Exhibition")) {
                                                                                                                                        byte b14 = 15;
                                                                                                                                        break label260;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 63:
                                                                                                                                    if (s.equals("?")) {
                                                                                                                                        byte b24 = 25;
                                                                                                                                        break label250;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 48570:
                                                                                                                                    if (s.equals("1.7")) {
                                                                                                                                        boolean flag = true;
                                                                                                                                        break label273;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 79367:
                                                                                                                                    if (s.equals("Old")) {
                                                                                                                                        byte b13 = 14;
                                                                                                                                        break label261;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 83843:
                                                                                                                                    if (s.equals("Tap")) {
                                                                                                                                        byte b5 = 6;
                                                                                                                                        break label268;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 86917:
                                                                                                                                    if (s.equals("XIV")) {
                                                                                                                                        byte b7 = 8;
                                                                                                                                        break label267;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2066960:
                                                                                                                                    if (s.equals("Beta")) {
                                                                                                                                        byte b6 = 7;
                                                                                                                                        break label248;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2192897:
                                                                                                                                    if (s.equals("Flup")) {
                                                                                                                                        byte b19 = 20;
                                                                                                                                        break label255;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2433880:
                                                                                                                                    if (s.equals("None")) {
                                                                                                                                        b0 = 0;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2433928:
                                                                                                                                    if (s.equals("Noov")) {
                                                                                                                                        byte b20 = 21;
                                                                                                                                        break label254;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2546672:
                                                                                                                                    if (s.equals("Rhys")) {
                                                                                                                                        byte b22 = 23;
                                                                                                                                        break label252;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2583650:
                                                                                                                                    if (s.equals("Spin")) {
                                                                                                                                        byte b11 = 12;
                                                                                                                                        break label263;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 2587234:
                                                                                                                                    if (s.equals("Stab")) {
                                                                                                                                        byte b10 = 11;
                                                                                                                                        break label264;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 63569951:
                                                                                                                                    if (s.equals("Astro")) {
                                                                                                                                        byte b4 = 5;
                                                                                                                                        break label269;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 73771637:
                                                                                                                                    if (s.equals("Lucid")) {
                                                                                                                                        byte b3 = 4;
                                                                                                                                        break label270;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 80247031:
                                                                                                                                    if (s.equals("Sunny")) {
                                                                                                                                        byte b2 = 3;
                                                                                                                                        break label271;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 80301790:
                                                                                                                                    if (s.equals("Swing")) {
                                                                                                                                        byte b23 = 24;
                                                                                                                                        break label251;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 80307556:
                                                                                                                                    if (s.equals("Swong")) {
                                                                                                                                        byte b17 = 18;
                                                                                                                                        break label257;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 522034400:
                                                                                                                                    if (s.equals("Komorebi")) {
                                                                                                                                        byte b21 = 22;
                                                                                                                                        break label253;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 1355172906:
                                                                                                                                    if (s.equals("Dortware")) {
                                                                                                                                        byte b25 = 26;
                                                                                                                                        break label293;
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 1972874617:
                                                                                                                                    if (s.equals("Avatar")) {
                                                                                                                                        byte b8 = 9;
                                                                                                                                        break label266;
                                                                                                                                    }
                                                                                                                            }

                                                                                                                            switch (b0) {
                                                                                                                                case 0:
                                                                                                                                    itemrenderer.transformFirstPersonItem(
                                                                                                                                        f, 0.0F
                                                                                                                                    );
                                                                                                                                    GlStateManager.scale(
                                                                                                                                        d1, d1, d1
                                                                                                                                    );
                                                                                                                                    itemrenderer.doBlockTransformations();
                                                                                                                                    break label274;
                                                                                                                                case 1:
                                                                                                                                    break label273;
                                                                                                                                case 2:
                                                                                                                                    break label272;
                                                                                                                                case 3:
                                                                                                                                    break label271;
                                                                                                                                case 4:
                                                                                                                                    break label270;
                                                                                                                                case 5:
                                                                                                                                    break label269;
                                                                                                                                case 6:
                                                                                                                                    break label268;
                                                                                                                                case 7:
                                                                                                                                    break;
                                                                                                                                case 8:
                                                                                                                                    break label267;
                                                                                                                                case 9:
                                                                                                                                    break label266;
                                                                                                                                case 10:
                                                                                                                                    break label265;
                                                                                                                                case 11:
                                                                                                                                    break label264;
                                                                                                                                case 12:
                                                                                                                                    break label263;
                                                                                                                                case 13:
                                                                                                                                    break label262;
                                                                                                                                case 14:
                                                                                                                                    break label261;
                                                                                                                                case 15:
                                                                                                                                    break label260;
                                                                                                                                case 16:
                                                                                                                                    break label259;
                                                                                                                                case 17:
                                                                                                                                    break label258;
                                                                                                                                case 18:
                                                                                                                                    break label257;
                                                                                                                                case 19:
                                                                                                                                    break label256;
                                                                                                                                case 20:
                                                                                                                                    break label255;
                                                                                                                                case 21:
                                                                                                                                    break label254;
                                                                                                                                case 22:
                                                                                                                                    break label253;
                                                                                                                                case 23:
                                                                                                                                    break label252;
                                                                                                                                case 24:
                                                                                                                                    break label251;
                                                                                                                                case 25:
                                                                                                                                    break label250;
                                                                                                                                case 26:
                                                                                                                                    break label293;
                                                                                                                                default:
                                                                                                                                    break label274;
                                                                                                                            }
                                                                                                                        }

                                                                                                                        GL11.glTranslatef(0.0F, 0.3F, 0.0F);
                                                                                                                        float f4 = MathHelper.sin(
                                                                                                                            f1 * f1 * (float) Math.PI
                                                                                                                        );
                                                                                                                        itemrenderer.transformFirstPersonItem(
                                                                                                                            itemrenderer.equippedProgress
                                                                                                                                * 0.5F,
                                                                                                                            0.0F
                                                                                                                        );
                                                                                                                        GlStateManager.scale(d1, d1, d1);
                                                                                                                        GlStateManager.rotate(
                                                                                                                            -f4 * 55.0F / 2.0F,
                                                                                                                            -8.0F,
                                                                                                                            -0.0F,
                                                                                                                            9.0F
                                                                                                                        );
                                                                                                                        GlStateManager.rotate(
                                                                                                                            -f4 * 45.0F, 1.0F, f4 / 2.0F, -0.0F
                                                                                                                        );
                                                                                                                        itemrenderer.doBlockTransformations();
                                                                                                                        GL11.glTranslated(1.2, 0.3, 0.5);
                                                                                                                        GL11.glTranslatef(
                                                                                                                            -1.0F,
                                                                                                                            aEg.thePlayer.isSneaking()
                                                                                                                                ? -0.1F
                                                                                                                                : -0.2F,
                                                                                                                            0.2F
                                                                                                                        );
                                                                                                                        break label274;
                                                                                                                    }

                                                                                                                    float f12 = MathHelper.sin(
                                                                                                                        (float)(f1 * f1 * Math.PI - 3.0)
                                                                                                                    );
                                                                                                                    float f13 = MathHelper.sin(
                                                                                                                        (float)(
                                                                                                                            MathHelper.sqrt_float(f1) * Math.PI
                                                                                                                        )
                                                                                                                    );
                                                                                                                    itemrenderer.transformFirstPersonItem(
                                                                                                                        f, 1.0F
                                                                                                                    );
                                                                                                                    GlStateManager.rotate(
                                                                                                                        -f13 * 10.0F, 0.0F, 15.0F, 200.0F
                                                                                                                    );
                                                                                                                    GlStateManager.rotate(
                                                                                                                        -f13 * 10.0F, 300.0F, f13 / 2.0F, 1.0F
                                                                                                                    );
                                                                                                                    itemrenderer.doBlockTransformations();
                                                                                                                    GL11.glTranslated(2.4, 0.3, 0.5);
                                                                                                                    GL11.glTranslatef(-2.1F, -0.2F, 0.1F);
                                                                                                                    GlStateManager.rotate(
                                                                                                                        f12 * 13.0F, -10.0F, -1.4F, -10.0F
                                                                                                                    );
                                                                                                                    break label274;
                                                                                                                }

                                                                                                                itemrenderer.transformFirstPersonItem(f, f1);
                                                                                                                GlStateManager.scale(d1, d1, d1);
                                                                                                                GL11.glTranslatef(-0.35F, 0.1F, 0.0F);
                                                                                                                GL11.glTranslatef(-0.05F, -0.1F, 0.1F);
                                                                                                                itemrenderer.doBlockTransformations();
                                                                                                                break label274;
                                                                                                            }

                                                                                                            itemrenderer.transformFirstPersonItem(f, f1);
                                                                                                            GlStateManager.scale(d1, d1, d1);
                                                                                                            itemrenderer.doBlockTransformations();
                                                                                                            GlStateManager.translate(-0.3F, -0.1F, -0.0F);
                                                                                                            break label274;
                                                                                                        }

                                                                                                        GlStateManager.translate(0.41F, -0.25F, -0.5555557F);
                                                                                                        GlStateManager.translate(0.0F, 0.0F, 0.0F);
                                                                                                        GlStateManager.rotate(35.0F, 0.0F, 1.5F, 0.0F);
                                                                                                        float f11 = MathHelper.sin(
                                                                                                            f1 * f1 / 64.0F * (float)abs.aHb
                                                                                                        );
                                                                                                        GlStateManager.rotate(f11 * -5.0F, 0.0F, 0.0F, 0.0F);
                                                                                                        GlStateManager.rotate(f2 * -12.0F, 0.0F, 0.0F, 1.0F);
                                                                                                        GlStateManager.rotate(f2 * -65.0F, 1.0F, 0.0F, 0.0F);
                                                                                                        GlStateManager.scale(d1, d1, d1);
                                                                                                        itemrenderer.doBlockTransformations();
                                                                                                        break label274;
                                                                                                    }

                                                                                                    itemrenderer.transformFirstPersonItem(
                                                                                                        -0.25F, 1.0F + f2 / 10.0F
                                                                                                    );
                                                                                                    GlStateManager.scale(d1, d1, d1);
                                                                                                    GL11.glRotated(-f2 * 25.0F, 1.0, 0.0, 0.0);
                                                                                                    itemrenderer.doBlockTransformations();
                                                                                                    break label274;
                                                                                                }

                                                                                                itemrenderer.transformFirstPersonItem(f / 1.5F, 0.0F);
                                                                                                GlStateManager.scale(d1, d1, d1);
                                                                                                itemrenderer.doBlockTransformations();
                                                                                                GlStateManager.translate(-0.05F, 0.3F, 0.3F);
                                                                                                GlStateManager.rotate(-f2 * 140.0F, 8.0F, 0.0F, 8.0F);
                                                                                                GlStateManager.rotate(f2 * abs.aHc, 8.0F, 0.0F, 8.0F);
                                                                                                break label274;
                                                                                            }

                                                                                            GlStateManager.translate(0.0F, 0.1F, -0.05F);
                                                                                            itemrenderer.transformFirstPersonItem(f, 0.0F);
                                                                                            GlStateManager.scale(d1, d1, d1);
                                                                                            itemrenderer.doBlockTransformations();
                                                                                            GlStateManager.translate(-0.05F, 0.2F, 0.0F);
                                                                                            GlStateManager.rotate(-f2 * 70.0F / 2.0F, -8.0F, -0.0F, 9.0F);
                                                                                            GlStateManager.rotate(-f2 * 70.0F, 1.0F, -0.4F, -0.0F);
                                                                                            break label274;
                                                                                        }

                                                                                        itemrenderer.transformFirstPersonItem(f, f1);
                                                                                        GlStateManager.scale(d1, d1, d1);
                                                                                        GlStateManager.translate(-0.5F, 0.4F, -0.2F);
                                                                                        GlStateManager.rotate(30.0F, 0.0F, 1.0F, 0.0F);
                                                                                        GlStateManager.rotate(-70.0F, 1.0F, 0.0F, 0.0F);
                                                                                        GlStateManager.rotate(40.0F, 0.0F, 1.0F, 0.0F);
                                                                                        break label274;
                                                                                    }

                                                                                    GlStateManager.translate(0.0F, 0.1F, -0.05F);
                                                                                    itemrenderer.transformFirstPersonItem(f / 2.0F, f1);
                                                                                    GlStateManager.scale(d1, d1, d1);
                                                                                    GlStateManager.rotate(f2 * 30.0F, -f2, -0.0F, 9.0F);
                                                                                    GlStateManager.rotate(f2 * 40.0F, 1.0F, -f2, -0.0F);
                                                                                    itemrenderer.doBlockTransformations();
                                                                                    break label274;
                                                                                }

                                                                                GlStateManager.translate(0.0F, -0.04F, -0.01F);
                                                                                itemrenderer.transformFirstPersonItem(f / 2.0F, 0.0F);
                                                                                GlStateManager.scale(d1, d1, d1);
                                                                                GlStateManager.translate(0.0F, 0.3F, -0.0F);
                                                                                GlStateManager.rotate(-f2 * 30.0F, 1.0F, 0.0F, 2.0F);
                                                                                GlStateManager.rotate(-f2 * 44.0F, 1.5F, f2 / 1.2F, 0.0F);
                                                                                itemrenderer.doBlockTransformations();
                                                                                break label274;
                                                                            }

                                                                            GlStateManager.translate(0.0F, -0.05F, 0.0F);
                                                                            GlStateManager.translate(-0.04F, 0.13F, 0.0F);
                                                                            itemrenderer.transformFirstPersonItem(f / 2.5F, 0.0F);
                                                                            GlStateManager.scale(d1, d1, d1);
                                                                            GlStateManager.rotate(-f2 * 40.0F / 2.0F, f2 / 2.0F, 1.0F, 4.0F);
                                                                            GlStateManager.rotate(-f2 * 30.0F, 1.0F, f2 / 3.0F, -0.0F);
                                                                            itemrenderer.doBlockTransformations();
                                                                            break label274;
                                                                        }

                                                                        GlStateManager.translate(0.0F, -0.05F, -0.0F);
                                                                        itemrenderer.transformFirstPersonItem(f / 2.0F, 0.0F);
                                                                        GlStateManager.scale(d1, d1, d1);
                                                                        GlStateManager.translate(0.0F, 0.3F, -0.0F);
                                                                        GlStateManager.rotate(-f2 * 31.0F, 1.0F, 0.0F, 2.0F);
                                                                        GlStateManager.rotate(-f2 * 33.0F, 1.5F, f2 / 1.1F, 0.0F);
                                                                        itemrenderer.doBlockTransformations();
                                                                        break label274;
                                                                    }

                                                                    GlStateManager.translate(0.0F, 0.1F, 0.0F);
                                                                    itemrenderer.transformFirstPersonItem(f / 2.0F - 0.2F, f1);
                                                                    GlStateManager.scale(d1, d1, d1);
                                                                    itemrenderer.doBlockTransformations();
                                                                    break label274;
                                                                }

                                                                GlStateManager.translate(0.0F, -0.03F, -0.13F);
                                                                itemrenderer.transformFirstPersonItem(f / 3.0F, 0.0F);
                                                                GlStateManager.scale(d1, d1, d1);
                                                                GlStateManager.translate(0.0F, 0.1F, 0.0F);
                                                                itemrenderer.doBlockTransformations();
                                                                GlStateManager.rotate(f2 * 20.0F / 2.0F, 0.0F, 1.0F, 1.5F);
                                                                GlStateManager.rotate(-f2 * 200.0F / 4.0F, 1.0F, 0.9F, 0.0F);
                                                                break label274;
                                                            }

                                                            itemrenderer.transformFirstPersonItem(f, 0.0F);
                                                            GlStateManager.scale(d1, d1, d1);
                                                            GlStateManager.translate(0.0F, 0.2F, -1.0F);
                                                            GlStateManager.rotate(-59.0F, -1.0F, 0.0F, 3.0F);
                                                            GlStateManager.rotate((float)(-(System.currentTimeMillis() / 2L % 360L)), 1.0F, 0.0F, 0.0F);
                                                            GlStateManager.rotate(60.0F, 0.0F, 1.0F, 0.0F);
                                                            break label274;
                                                        }

                                                        float f10 = MathHelper.sin(MathHelper.sqrt_float(f1) * (float)abs.aHb);
                                                        GlStateManager.translate(0.6F, 0.3F, -0.6F + -f10 * 0.7);
                                                        GlStateManager.rotate(6090.0F, 0.0F, 0.0F, 0.1F);
                                                        GlStateManager.rotate(6085.0F, 0.0F, 0.1F, 0.0F);
                                                        GlStateManager.rotate(6110.0F, 0.1F, 0.0F, 0.0F);
                                                        itemrenderer.transformFirstPersonItem(0.0F, 0.0F);
                                                        GlStateManager.scale(d1, d1, d1);
                                                        itemrenderer.doBlockTransformations();
                                                        break label274;
                                                    }

                                                    itemrenderer.transformFirstPersonItem(f, 0.0F);
                                                    GlStateManager.scale(d1, d1, d1);
                                                    float f9 = -f2 * 2.0F;
                                                    GlStateManager.translate(0.0F, f9 / 10.0F + 0.1F, 0.0F);
                                                    GlStateManager.rotate(f9 * 10.0F, 0.0F, 1.0F, 0.0F);
                                                    GlStateManager.rotate(250.0F, 0.2F, 1.0F, -0.6F);
                                                    GlStateManager.rotate(-10.0F, 1.0F, 0.5F, 1.0F);
                                                    GlStateManager.rotate(-f9 * 20.0F, 1.0F, 0.5F, 1.0F);
                                                    break label274;
                                                }

                                                GlStateManager.translate(0.56F, -0.52F, -0.71999997F);
                                                GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
                                                float f7 = MathHelper.sin(f1 * f1 * (float) Math.PI);
                                                float f8 = MathHelper.sin(MathHelper.sqrt_float(f1) * (float) Math.PI);
                                                GlStateManager.rotate(f7 * -20.0F, 0.0F, 1.0F, 0.0F);
                                                GlStateManager.rotate(f8 * -20.0F, 0.0F, 0.0F, 1.0F);
                                                GlStateManager.rotate(f8 * -40.0F, 1.0F, 0.0F, 0.0F);
                                                itemrenderer.transformFirstPersonItem(-0.1F, -0.1F);
                                                GlStateManager.scale(0.4F, 0.4F, 0.4F);
                                                GlStateManager.scale(d1, d1, d1);
                                                itemrenderer.doBlockTransformations();
                                                break label274;
                                            }

                                            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
                                            itemrenderer.transformFirstPersonItem(f, f1);
                                            GlStateManager.scale(d1, d1, d1);
                                            itemrenderer.doBlockTransformations();
                                            float f5 = MathHelper.sin(f1 * f1 * (float) Math.PI);
                                            float f6 = MathHelper.sin(MathHelper.sqrt_float(f1) * (float) Math.PI);
                                            GlStateManager.rotate(-f5 * 20.0F, 0.0F, 1.0F, 0.0F);
                                            GlStateManager.rotate(-f6 * 20.0F, 0.0F, 0.0F, 1.0F);
                                            GlStateManager.rotate(-f6 * 80.0F, 1.0F, 0.0F, 0.0F);
                                            break label274;
                                        }

                                        GL11.glTranslatef(0.0F, 0.3F, 0.0F);
                                        float f3 = f1 * 0.8F - f1 * f1 * 0.8F;
                                        GlStateManager.scale(d1, d1, d1);
                                        GlStateManager.translate(0.56F, -0.52F, -0.71999997F);
                                        GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
                                        GlStateManager.rotate(f3 * -90.0F, 0.0F, 1.0F, 0.0F);
                                        GlStateManager.scale(0.37F, 0.37F, 0.37F);
                                        itemrenderer.doBlockTransformations();
                                        break label274;
                                    }

                                    GlStateManager.translate(0.0F, 0.03F, -0.05F);
                                    itemrenderer.transformFirstPersonItem(f / 2.0F, f1);
                                    GlStateManager.scale(d1, d1, d1);
                                    GlStateManager.rotate(f2 * 30.0F / 2.0F, -f2, -0.0F, 9.0F);
                                    GlStateManager.rotate(f2 * 40.0F, 1.0F, -f2 / 2.0F, -0.0F);
                                    itemrenderer.doBlockTransformations();
                                    break label274;
                                }

                                itemrenderer.transformFirstPersonItem(f - 0.1F, f1);
                                GlStateManager.scale(d1, d1, d1);
                                itemrenderer.doBlockTransformations();
                                break label274;
                            }

                            double d2 = d1 * 0.99;
                            GlStateManager.translate(0.05F, -0.05F, -0.12F);
                            itemrenderer.transformFirstPersonItem(f + 0.15F, f1);
                            GlStateManager.scale(d2, d2, d2);
                            itemrenderer.doBlockTransformations();
                            GlStateManager.translate(-0.5F, 0.2F, 0.0F);
                            break label274;
                        }

                        itemrenderer.transformFirstPersonItem(f, f1);
                        GlStateManager.scale(d1, d1, d1);
                        itemrenderer.doBlockTransformations();
                        itemrenderer.JX();
                        break label274;
                    }

                    itemrenderer.transformFirstPersonItem(f, f1);
                    GlStateManager.scale(d1, d1, d1);
                    itemrenderer.doBlockTransformations();
                }

                var1.setCancelled();
            } else if (!var1.db()) {
                label160: {
                    label159: {
                        label158: {
                            label157: {
                                label156: {
                                    String s1 = this.akL.wo().getName();
                                    byte b26 = -1;
                                    switch (s1.hashCode()) {
                                        case -1814666802:
                                            if (s1.equals("Smooth")) {
                                                byte b29 = 4;
                                                break label159;
                                            }
                                            break;
                                        case 1505775:
                                            if (s1.equals("1.9+")) {
                                                byte b27 = 2;
                                                break label157;
                                            }
                                            break;
                                        case 2433880:
                                            if (s1.equals("None")) {
                                                b26 = 0;
                                            }
                                            break;
                                        case 77476110:
                                            if (s1.equals("Punch")) {
                                                boolean flag1 = true;
                                                break label156;
                                            }
                                            break;
                                        case 79860937:
                                            if (s1.equals("Shove")) {
                                                byte b28 = 3;
                                                break label158;
                                            }
                                    }

                                    switch (b26) {
                                        case 0:
                                            itemrenderer.doItemUsedTransformations(f1);
                                            itemrenderer.transformFirstPersonItem(f, f1);
                                            if (!this.akM.wo()) {
                                                GlStateManager.scale(d1, d1, d1);
                                            }
                                            break label160;
                                        case 1:
                                            break;
                                        case 2:
                                            break label157;
                                        case 3:
                                            break label158;
                                        case 4:
                                            break label159;
                                        default:
                                            break label160;
                                    }
                                }

                                itemrenderer.transformFirstPersonItem(f, f1);
                                itemrenderer.doItemUsedTransformations(f1);
                                if (!this.akM.wo()) {
                                    GlStateManager.scale(d1, d1, d1);
                                }
                                break label160;
                            }

                            itemrenderer.doItemUsedTransformations(f1);
                            itemrenderer.transformFirstPersonItem(f, f1);
                            if (!this.akM.wo()) {
                                GlStateManager.scale(d1, d1, d1);
                            }
                            break label160;
                        }

                        itemrenderer.transformFirstPersonItem(f, f);
                        itemrenderer.doItemUsedTransformations(f1);
                        if (!this.akM.wo()) {
                            GlStateManager.scale(d1, d1, d1);
                        }
                        break label160;
                    }

                    itemrenderer.transformFirstPersonItem(f, f1);
                    itemrenderer.doItemUsedTransformations(f);
                    if (!this.akM.wo()) {
                        GlStateManager.scale(d1, d1, d1);
                    }
                }

                var1.setCancelled();
            }
        }
    };
    @EventLink
    public final Listener<SwingAnimationEvent> akU = var1 -> {
        int i = var1.dK();
        TerrainSpeed terrainspeed = this.e(TerrainSpeed.class);
        if (terrainspeed.isEnabled() && "Bloxd".equals(terrainspeed.Fe.wo().getName())) {
            i = (int)(i * 1.5F);
        }

        int j = (int)(i * (-this.akN.wo().floatValue() / 100.0F + 1.0F));
        var1.m(j);
    };

    public Animations() {
    }
}
