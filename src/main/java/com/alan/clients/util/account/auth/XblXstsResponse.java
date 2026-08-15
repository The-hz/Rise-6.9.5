package com.alan.clients.util.account.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class XblXstsResponse {
    @Expose
    @SerializedName("Token")
    public String aFa;
    @Expose
    @SerializedName("DisplayClaims")
    public DisplayClaims aFb;

    private XblXstsResponse() {
    }
}
