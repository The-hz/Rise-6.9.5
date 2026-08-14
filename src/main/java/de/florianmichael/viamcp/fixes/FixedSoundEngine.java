package de.florianmichael.viamcp.fixes;

import de.florianmichael.vialoadingbase.ViaLoadingBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class FixedSoundEngine {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public FixedSoundEngine() {
    }

    public static boolean destroyBlock(World var0, BlockPos var1, boolean var2) {
        IBlockState iblockstate = var0.getBlockState(var1);
        Block block = iblockstate.getBlock();
        var0.playAuxSFX(2001, var1, Block.getStateId(iblockstate));
        if (block.getMaterial() == Material.air) {
            return false;
        }

        if (var2) {
            block.dropBlockAsItem(var0, var1, iblockstate, 0);
        }

        return var0.setBlockState(var1, Blocks.air.getDefaultState(), 3);
    }

    public static boolean onItemUse(
        ItemBlock var0, ItemStack var1, EntityPlayer var2, World var3, BlockPos var4, EnumFacing var5, float var6, float var7, float var8
    ) {
        if (!var3.getBlockState(var4).getBlock().isReplaceable(var3, var4)) {
            var4 = var4.offset(var5);
        }

        if (var1.stackSize == 0) {
            return false;
        }

        if (!var2.canPlayerEdit(var4, var5, var1)) {
            return false;
        }

        if (var3.canBlockBePlaced(var0.getBlock(), var4, false, var5, (Entity)null, var1)) {
            int i = var0.getMetadata(var1.getMetadata());
            IBlockState iblockstate = var0.getBlock().onBlockPlaced(var3, var4, var5, var6, var7, var8, i, var2);
            if (var3.setBlockState(var4, iblockstate, 3)) {
                iblockstate = var3.getBlockState(var4);
                if (iblockstate.getBlock() == var0.getBlock()) {
                    ItemBlock.setTileEntityNBT(var3, var2, var4, var1);
                    var0.getBlock().onBlockPlacedBy(var3, var4, iblockstate, var2, var1);
                }

                if (ViaLoadingBase.getInstance().getTargetVersion().getOriginalVersion() != 47) {
                    mc.theWorld
                        .playSoundAtPos(
                            var4.add(0.5, 0.5, 0.5),
                            var0.getBlock().stepSound.getPlaceSound(),
                            (var0.getBlock().stepSound.getVolume() + 1.0F) / 2.0F,
                            var0.getBlock().stepSound.getFrequency() * 0.8F,
                            false
                        );
                } else {
                    var3.playSoundEffect(
                        var4.getX() + 0.5F,
                        var4.getY() + 0.5F,
                        var4.getZ() + 0.5F,
                        var0.getBlock().stepSound.getPlaceSound(),
                        (var0.getBlock().stepSound.getVolume() + 1.0F) / 2.0F,
                        var0.getBlock().stepSound.getFrequency() * 0.8F
                    );
                }

                var1.stackSize--;
            }

            return true;
        }
        return false;
    }
}
