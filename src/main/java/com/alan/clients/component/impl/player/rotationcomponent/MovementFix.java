package com.alan.clients.component.impl.player.rotationcomponent;

import lombok.Generated;

public enum MovementFix {
    OFF("Off"),
    NORMAL("Rise"),
    TRADITIONAL("Traditional"),
    BACKWARDS_SPRINT("Backwards Sprint");

    final String gK;
    private static final MovementFix[] $VALUES = cd();

    @Override
    public String toString() {
        return this.gK;
    }

    @Generated
    MovementFix(String var3) {
        this.gK = var3;
    }

    private static MovementFix[] cd() {
        return new MovementFix[]{OFF, NORMAL, TRADITIONAL, BACKWARDS_SPRINT};
    }
}
