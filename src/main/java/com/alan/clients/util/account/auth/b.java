package com.alan.clients.util.account.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class b {
    @Expose
    @SerializedName("items")
    private c[] aEW;

    private b() {
    }

    private boolean sl() {
        boolean flag = false;
        boolean flag1 = false;

        for (c c : this.aEW) {
            if (c.gK.equals("product_minecraft")) {
                flag = true;
            } else if (c.gK.equals("game_minecraft")) {
                flag1 = true;
            }
        }

        return flag && flag1;
    }
}
