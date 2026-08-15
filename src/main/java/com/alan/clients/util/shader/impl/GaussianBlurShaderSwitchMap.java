package com.alan.clients.util.shader.impl;

import hackclient.rise.aiz;

class GaussianBlurShaderSwitchMap {
    static final int[] aQh = new int[aiz.values().length];

    static {
        try {
            aQh[aiz.CAMERA.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            aQh[aiz.OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
