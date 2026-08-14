package com.alan.clients.script.api;

import com.alan.clients.command.Command;
import com.alan.clients.script.api.wrapper.impl.ScriptCommand;
import java.util.concurrent.atomic.AtomicReference;

public class RiseAPI$2 extends Command {
    final AtomicReference val$scriptCommandReference;

    RiseAPI$2(RiseAPI var1, String var2, String[] var3, AtomicReference var4) {
        super(var2, var3);
        this.val$scriptCommandReference = var4;
    }

    @Override
    public void execute(String[] var1) {
        ScriptCommand scriptcommand = (ScriptCommand)this.val$scriptCommandReference.get();
        if (scriptcommand != null) {
            scriptcommand.call("onExecute", var1);
        }
    }
}
