package com.alan.clients.script.util;

import hackclient.rise.afi;
import java.util.HashMap;
import java.util.Map;
import org.openjdk.nashorn.api.scripting.JSObject;
import org.openjdk.nashorn.internal.runtime.ECMAException;

public class ScriptHandler {
    private final Map<String, JSObject> functionRegistry = new HashMap<>();

    public ScriptHandler() {
    }

    public void handle(String var1, JSObject var2) {
        this.functionRegistry.put(var1, var2);
    }

    public void unhandle(String var1) {
        this.functionRegistry.remove(var1);
    }

    public void call(String var1, Object... var2) {
        JSObject jsobject = this.functionRegistry.get(var1);
        if (jsobject != null) {
            try {
                jsobject.call(this, var2);
            } catch (ECMAException ecmaexception) {
                afi.b(ecmaexception.toString());
            } catch (Exception exception) {
                exception.printStackTrace();
                afi.b("A script threw an exception, stacktrace printed.");
            }
        }
    }
}
