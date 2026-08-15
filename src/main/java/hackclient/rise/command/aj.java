package hackclient.rise.command;

import com.alan.clients.command.Command;
import rip.vantage.commons.packet.impl.client.community.h;
import rip.vantage.network.core.a;

public class aj extends Command {
    public aj() {
        super("command.title.description", "title");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length != 7) {
            this.error(".title <message> <fadeInTime> <displayTime> <fadeOutTime> <color> <group/user>");
        } else {
            a.aKB().aKK().sendMessage(new h(var1[1], Integer.parseInt(var1[2]), Integer.parseInt(var1[3]), Integer.parseInt(var1[4]), var1[5], var1[6]).aJk());
        }
    }
}
