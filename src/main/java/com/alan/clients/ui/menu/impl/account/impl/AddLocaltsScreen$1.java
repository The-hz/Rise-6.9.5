package com.alan.clients.ui.menu.impl.account.impl;

import hackclient.rise.aew;
import java.util.Comparator;

public class AddLocaltsScreen$1 implements Comparator<aew> {
    AddLocaltsScreen$1() {
    }

    public int compare(aew var1, aew var2) {
        int i = AddLocaltsScreen.productPriority(var1) - AddLocaltsScreen.productPriority(var2);
        return i != 0 ? i : var1.aFD.compareToIgnoreCase(var2.aFD);
    }
}
