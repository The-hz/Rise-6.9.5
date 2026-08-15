package com.alan.clients.util.pathfinding.unlegit;

import java.util.Comparator;

public class ahw implements Comparator<ahx> {
    public ahw() {
    }

    public int a(ahx var1, ahx var2) {
        return (int)(var1.uU() + var1.uW() - (var2.uU() + var2.uW()));
    }

    public int compare(ahx var1, ahx var2) {
        return this.a(var1, var2);
    }
}
