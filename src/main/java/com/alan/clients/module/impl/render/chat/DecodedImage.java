package com.alan.clients.module.impl.render.chat;

import java.awt.image.BufferedImage;

class DecodedImage {
    final BufferedImage[] arR;
    final int[] arS;
    final int arT;

    DecodedImage(BufferedImage[] images, int[] var2, int var3) {
        this.arR = images;
        this.arS = var2;
        this.arT = var3;
    }
}
