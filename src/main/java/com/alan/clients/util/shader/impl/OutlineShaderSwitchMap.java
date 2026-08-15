package com.alan.clients.util.shader.impl;

import hackclient.rise.aiz;

class OutlineShaderSwitchMap {
    static final int[] aQk = new int[aiz.values().length];

    static {
        try {
            aQk[aiz.CAMERA.ordinal()] = 1;
        } catch (NoSuchFieldError nosuchfielderror1) {
        }

        try {
            aQk[aiz.OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError nosuchfielderror) {
        }
    }
}
