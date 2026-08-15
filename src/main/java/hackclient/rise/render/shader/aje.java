package hackclient.rise.render.shader;

import hackclient.rise.aiz;

class aje {
    static final int[] aQb = new int[aiz.values().length];

    static {
        try {
            aQb[aiz.CAMERA.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            aQb[aiz.OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
