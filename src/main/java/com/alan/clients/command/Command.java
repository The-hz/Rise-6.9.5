package com.alan.clients.command;

import com.alan.clients.util.interfaces.InstanceAccess;
import hackclient.rise.afi;
import lombok.Generated;

public abstract class Command implements InstanceAccess {
    private final String description;
    private final String[] expressions;

    public Command(String description, String... expressions) {
        this.description = description;
        this.expressions = expressions;
    }

    public abstract void execute(String[] var1);

    protected final void error() {
        afi.b("§cInvalid command arguments.");
    }

    protected final void error(String var1) {
        this.error();
        afi.b("Correct Usage: " + var1);
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public String[] getExpressions() {
        return this.expressions;
    }
}
