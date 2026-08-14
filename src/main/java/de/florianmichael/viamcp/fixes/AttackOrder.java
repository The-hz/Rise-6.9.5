package de.florianmichael.viamcp.fixes;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.MovingObjectPosition;

public class AttackOrder {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public AttackOrder() {
    }

    public static void sendConditionalSwing(MovingObjectPosition var0) {
        if (var0 != null && var0.typeOfHit != MovingObjectType.ENTITY) {
            mc.thePlayer.swingItem();
        }
    }

    public static void sendFixedAttack(EntityPlayer var0, Entity var1) {
        if (ViaLoadingBase.getInstance().getTargetVersion().olderThanOrEqualTo(ProtocolVersion.v1_8)) {
            mc.thePlayer.swingItem();
            mc.playerController.attackEntity(var0, var1);
        } else {
            mc.playerController.attackEntity(var0, var1);
            mc.thePlayer.swingItem();
        }
    }
}
