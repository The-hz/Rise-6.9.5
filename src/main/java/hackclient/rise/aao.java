package hackclient.rise;

import com.alan.clients.Client;

public class aao extends aaj {
    public aao() {
        super(aak.JOIN, false);
    }

    @Override
    public boolean check() {
        Thread thread = Client.a.f().oh();
        if (thread.isAlive() && !thread.isInterrupted()) {
            return false;
        }

        Client.a.f().oc();
        return true;
    }
}
