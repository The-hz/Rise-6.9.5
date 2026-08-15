package com.alan.clients.module.impl.render.chat;

enum ImageFormat {
    PNG,
    JPEG,
    GIF,
    BMP,
    WEBP,
    UNKNOWN;

    private static final ImageFormat[] $VALUES = nl();

    ImageFormat() {
    }

    private static ImageFormat[] nl() {
        return new ImageFormat[]{PNG, JPEG, GIF, BMP, WEBP, UNKNOWN};
    }
}
