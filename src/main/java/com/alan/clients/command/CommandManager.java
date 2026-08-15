package com.alan.clients.command;

import com.alan.clients.Client;
import com.alan.clients.command.impl.Bind;
import com.alan.clients.command.impl.Clip;
import com.alan.clients.command.impl.Config;
import com.alan.clients.command.impl.Help;
import com.alan.clients.command.impl.Module;
import com.alan.clients.command.impl.Name;
import com.alan.clients.command.impl.Panic;
import com.alan.clients.command.impl.Script;
import com.alan.clients.command.impl.Spotify;
import com.alan.clients.command.impl.Stuck;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ChatInputEvent;
import hackclient.rise.aa;
import hackclient.rise.ae;
import hackclient.rise.afi;
import hackclient.rise.afj;
import hackclient.rise.ai;
import hackclient.rise.aj;
import hackclient.rise.ak;
import hackclient.rise.u;
import hackclient.rise.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;

public final class CommandManager {
    private final List<Command> bp = new ArrayList<>();
    @EventLink
    public final Listener<ChatInputEvent> onChatInput = var1 -> {
        if (this.a(var1.getMessage(), true) != u.NOT_A_COMMAND) {
            var1.setCancelled();
        }
    };

    public CommandManager() {
    }

    public void init() {
        this.a(new Bind());
        this.a(new Module());
        this.a(new Clip());
        this.a(new Config());
        this.a(new y());
        this.a(new Help());
        this.a(new aa());
        this.a(new Name());
        this.a(new aj());
        this.a(new Panic());
        this.a(new ae());
        this.a(new Script());
        this.a(new Stuck());
        this.a(new ak());
        this.a(new Spotify());
        this.a(new ai());
        Client.a.e().b(this);
    }

    public void a(Command var1) {
        this.bp.add(var1);
    }

    public <T extends Command> T get(String var1) {
        return (T)this.bp
            .stream()
            .filter(var1x -> Arrays.stream(var1x.getExpressions()).anyMatch(var1xx -> var1xx.equalsIgnoreCase(var1)))
            .findAny()
            .orElse(null);
    }

    public u c(String var1) {
        return this.a(var1, true);
    }

    public u a(String var1, boolean var2) {
        if (var1 == null) {
            return u.NOT_A_COMMAND;
        }

        String s = var1.trim();
        if (s.isEmpty()) {
            return u.NOT_A_COMMAND;
        }

        boolean flag = s.startsWith(".");
        boolean flag1 = !var2 && s.startsWith("/");
        if (flag) {
            s = s.substring(1);
        } else if (flag1) {
            s = s.substring(1);
        } else if (var2) {
            return u.NOT_A_COMMAND;
        }

        if (s.isEmpty()) {
            afi.b("command.unknown");
            return u.UNKNOWN;
        }

        String[] astring = s.trim().split("\\s+");
        AtomicBoolean atomicboolean = new AtomicBoolean(false);
        AtomicReference atomicreference = new AtomicReference(null);

        try {
            this.bp.stream().filter(var1x -> Arrays.stream(var1x.getExpressions()).anyMatch(var1xx -> var1xx.equalsIgnoreCase(astring[0]))).forEach(var3 -> {
                atomicboolean.set(true);
                atomicreference.set(var3);
                var3.execute(astring);
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (!atomicboolean.get()) {
            afi.b("command.unknown");
            return u.UNKNOWN;
        }

        try {
            afj.sJ().a((Command)atomicreference.get(), astring);
        } catch (Throwable throwable) {
        }

        return u.EXECUTED;
    }

    @Generated
    public List<Command> aQ() {
        return this.bp;
    }
}
