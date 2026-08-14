package hackclient.rise;

import com.alan.clients.module.impl.render.Interface;
import java.nio.FloatBuffer;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL13;

public class ajf extends aix {
    private final aiy aQc = new aiy("blur.frag", "vertex.vsh");
    private Framebuffer aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
    private Framebuffer aPZ = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
    private ajq aQa = new ajq(0);
    public static final int aQd = 12;
    public static final float aQe = 3.0F;
    int aQf = 12;
    float aQg = 3.0F;
    private Interface amf;

    public ajf() {
    }

    @Override
    public void a(aiz var1, float var2, List<Runnable> var3) {
        if (Display.isVisible()) {
            if (this.amf == null) {
                this.amf = this.e(Interface.class);
            }

            int i = this.amf != null ? this.amf.ly() : 12;
            float f = this.amf != null ? this.amf.lz() : 3.0F;
            boolean flag = System.getProperty("os.name").toLowerCase().contains("mac");
            switch (ajg.aQh[var1.ordinal()]) {
                case 1:
                    this.aPV.bindFramebuffer(true);
                    var3.forEach(Runnable::run);
                    aEg.getFramebuffer().bindFramebuffer(true);
                    break;
                case 2:
                    this.aPV.bindFramebuffer(true);
                    var3.forEach(Runnable::run);
                    int j = this.aQc.vO();
                    this.aPZ.bindFramebuffer(true);
                    this.aQc.rt();
                    if (this.aQa.getSize() != i) {
                        this.aQa = new ajq(i);
                        this.aQa.uR();
                        FloatBuffer floatbuffer = BufferUtils.createFloatBuffer(i);
                        floatbuffer.put(this.aQa.vS());
                        floatbuffer.flip();
                        aja.a(j, "u_radius", (float)i);
                        aja.a(j, "u_kernel", floatbuffer);
                        aja.a(j, "u_diffuse_sampler", 0);
                        aja.a(j, "u_other_sampler", flag ? 2 : 20);
                    }

                    aja.a(j, "u_texel_size", 1.0F / aEg.displayWidth, 1.0F / aEg.displayHeight);
                    aja.a(j, "u_direction", f, 0.0F);
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                    GlStateManager.alphaFunc(516, 0.0F);
                    aEg.getFramebuffer().bindFramebufferTexture();
                    aiy.vN();
                    aEg.getFramebuffer().bindFramebuffer(true);
                    aja.a(j, "u_direction", 0.0F, f);
                    this.aPZ.bindFramebufferTexture();
                    GL13.glActiveTexture(flag ? 33986 : 34004);
                    this.aPV.bindFramebufferTexture();
                    GL13.glActiveTexture(33984);
                    aiy.vN();
                    GlStateManager.disableBlend();
                    aiy.stop();
            }
        }
    }

    @Override
    public void ju() {
        this.c(false);
        int i = aEg.displayWidth;
        int j = aEg.displayHeight;
        if (this.aPV.ah(i, j)) {
            this.aPV.deleteFramebuffer();
            this.aPV = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        } else {
            this.aPV.framebufferClear();
        }

        if (this.aPZ.ah(i, j)) {
            this.aPZ.deleteFramebuffer();
            this.aPZ = new Framebuffer(aEg.displayWidth, aEg.displayHeight, true);
        } else {
            this.aPZ.framebufferClear();
        }

        this.aPV.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
        this.aPZ.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
    }

    @Generated
    public void aF(int var1) {
        this.aQf = var1;
    }

    @Generated
    public int vQ() {
        return this.aQf;
    }

    @Generated
    public float vR() {
        return this.aQg;
    }

    @Generated
    public void I(float var1) {
        this.aQg = var1;
    }
}
