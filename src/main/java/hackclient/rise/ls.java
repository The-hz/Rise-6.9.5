package hackclient.rise;

import net.minecraft.util.EnumFacing;

public class ls {
    public static final int[] CI = new int[EnumFacing.values().length];

    static {
        try {
            CI[EnumFacing.DOWN.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror5) {
        }

        try {
            CI[EnumFacing.UP.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror4) {
        }

        try {
            CI[EnumFacing.NORTH.ordinal()] = 3;
        } catch (NoSuchFieldError nosuchfielderror3) {
        }

        try {
            CI[EnumFacing.SOUTH.ordinal()] = 4;
        } catch (NoSuchFieldError nosuchfielderror2) {
        }

        try {
            CI[EnumFacing.WEST.ordinal()] = 5;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            CI[EnumFacing.EAST.ordinal()] = 6;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
