package com.alan.clients.util.interfaces;

import com.alan.clients.Client;
import com.alan.clients.component.Component;
import com.alan.clients.module.Module;
import com.alan.clients.ui.click.standard.RiseClickGUI;
import com.google.gson.Gson;
import hackclient.rise.adv;
import hackclient.rise.ge;
import hackclient.rise.gf;
import hackclient.rise.gg;
import net.minecraft.client.Minecraft;

public interface InstanceAccess {
    Minecraft aEg = Minecraft.getMinecraft();

    default Client rN() {
        return Client.a;
    }

    default gf u() {
        return this.rN().u();
    }

    default RiseClickGUI getStandardClickGUI() {
        return this.rN().v();
    }

    default ge b(gg var1) {
        return this.u().a(var1);
    }

    default ge b(gg var1, int var2) {
        return this.u().a(var1, var2);
    }

    default <T extends Component> T d(Class<T> var1) {
        return this.rN().h().b(var1);
    }

    default adv rz() {
        return this.rN().k().rz();
    }

    default <T extends Module> T e(Class<T> var1) {
        return this.rN().g().c(var1);
    }

    default Gson A() {
        return this.rN().A();
    }

    default Minecraft rO() {
        return Minecraft.getMinecraft();
    }
}
