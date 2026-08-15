package com.alan.clients.util.account.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class AuthTokenResponse {
    @Expose
    @SerializedName("access_token")
    public String aEU;
    @Expose
    @SerializedName("refresh_token")
    public String aEV;

    private AuthTokenResponse() {
    }
}
