package com.alan.clients.util.account.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class GameOwnershipResponse {
    @Expose
    @SerializedName("items")
    private Item[] aEW;

    private GameOwnershipResponse() {
    }

    private boolean sl() {
        boolean flag = false;
        boolean flag1 = false;

        for (Item c : this.aEW) {
            if (c.gK.equals("product_minecraft")) {
                flag = true;
            } else if (c.gK.equals("game_minecraft")) {
                flag1 = true;
            }
        }

        return flag && flag1;
    }
}
