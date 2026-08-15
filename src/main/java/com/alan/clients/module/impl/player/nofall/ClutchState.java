package com.alan.clients.module.impl.player.nofall;

public enum ClutchState {
    IDLE,
    PREDICT,
    ROTATE,
    PLACE,
    WAIT_LAND,
    PICKUP;

    private static final ClutchState[] $VALUES = kz();

    ClutchState() {
    }

    private static ClutchState[] kz() {
        return new ClutchState[]{IDLE, PREDICT, ROTATE, PLACE, WAIT_LAND, PICKUP};
    }
}
