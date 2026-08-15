package hackclient.rise;

import com.alan.clients.command.Command;

public final class ae extends Command {
    public ae() {
        super("command.say.description", "say", "chat");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length <= 1) {
            this.error(String.format(".%s <message>", var1[0]));
        } else {
            afi.send(String.join(" ", var1).substring(3).trim());
            afi.b("command.say.sent");
        }
    }
}
