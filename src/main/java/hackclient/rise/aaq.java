package hackclient.rise;

import com.alan.clients.Client;

public final class aaq extends aaj {
    public aaq() {
        super(aak.REPETITIVE, false);
        System.setSecurityManager(null);
    }

    @Override
    public boolean check() {
        if (System.getSecurityManager() != null) {
            Client.a.f().oc();
            return true;
        }
        return false;
    }
}
