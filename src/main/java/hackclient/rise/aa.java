package hackclient.rise;

import com.alan.clients.command.Command;

public final class aa extends Command {
    public aa() {
        super("command.insults.description", "insults", "killinsults", "insult");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length >= 3) {
            String s = var1[1].toLowerCase();
            String s1 = var1[2];
            if (s.equals("create")) {
                this.rN().r().set(s1);
                afi.b("command.insults.created", s1);
            } else if (s.equals("delete")) {
                this.rN().r().delete(s1);
                afi.b("command.insults.removed", s1);
            }
        } else {
            afi.b("command.insults.help1");
            afi.b("command.insults.help2");
        }
    }
}
