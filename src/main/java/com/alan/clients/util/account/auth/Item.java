package com.alan.clients.util.account.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Item {
    @Expose
    @SerializedName("name")
    String gK;

    private Item() {
    }
}
