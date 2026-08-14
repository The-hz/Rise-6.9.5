package hackclient.rise;

import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public final class ahu implements InstanceAccess
{
    public static List<ahy> a(final ahy ahy, final ahy ahy2, final boolean b) {
        return a(ahy, ahy2, b, 9.5);
    }

    public static List<ahy> a(ahy n, final ahy e, final boolean b, final double n2) {
        final IBlockState blockState = ahu.aEg.theWorld.getBlockState(new BlockPos(n.uY()));
        if (blockState == null) {
            return null;
        }
        final Block block = blockState.getBlock();
        if (block == null) {
            return null;
        }
        if (!g(block)) {
            n = n.n(0.0, 1.0, 0.0);
        }
        final ahv ahv = new ahv(n, e);
        ahv.uR();
        int n3 = 0;
        ahy ahy = null;
        ahy ahy2 = null;
        final ArrayList<ahy> list = new ArrayList<ahy>();
        final ArrayList uq = ahv.uQ();
        for (final ahy ahy3 : (Iterable<ahy>)uq) {
            if (n3 == 0 || n3 == uq.size() - 1) {
                list.add(ahy3.n(0.5, 0.0, 0.5));
                ahy2 = ahy3;
            }
            else {
                int n4 = 1;
                Label_0204: {
                    if (ahy3.c(ahy2) > n2 * n2) {
                        n4 = 0;
                    }
                    else {
                        final double min = Math.min(ahy2.getX(), ahy3.getX());
                        final double min2 = Math.min(ahy2.getY(), ahy3.getY());
                        final double min3 = Math.min(ahy2.getZ(), ahy3.getZ());
                        final double max = Math.max(ahy2.getX(), ahy3.getX());
                        final double max2 = Math.max(ahy2.getY(), ahy3.getY());
                        final double max3 = Math.max(ahy2.getZ(), ahy3.getZ());
                        for (int n5 = (int)min; n5 <= max; ++n5) {
                            for (int n6 = (int)min2; n6 <= max2; ++n6) {
                                for (int n7 = (int)min3; n7 <= max3; ++n7) {
                                    if (!hackclient.rise.ahv.a(n5, n6, n7, false)) {
                                        n4 = 0;
                                        break Label_0204;
                                    }
                                }
                            }
                        }
                    }
                }
                if (n4 == 0) {
                    list.add(ahy.n(0.5, 0.0, 0.5));
                    ahy2 = ahy;
                }
            }
            ahy = ahy3;
            ++n3;
        }
        if (b) {
            list.add(e);
        }
        return list;
    }

    private static boolean g(final Block block) {
        final Material material = block.getMaterial();
        return material == Material.air || material == Material.plants || material == Material.vine || block == Blocks.ladder || block == Blocks.water || block == Blocks.flowing_water || block == Blocks.wall_sign || block == Blocks.standing_sign;
    }

    @Generated
    private ahu() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
