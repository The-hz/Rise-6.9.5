package com.alan.clients.module.impl.other.spotify;

import java.util.ArrayList;
import java.util.List;

public class LyricLine {
    public final int XR;
    public final String XS;
    public List<LyricWord> XT;
    public final boolean XU;

    public LyricLine(int var1, String var2, List<LyricWord> var3, boolean var4) {
        this.XR = var1;
        this.XS = var2;
        this.XT = var3 == null ? new ArrayList<>() : var3;
        this.XU = var4;
    }
}
