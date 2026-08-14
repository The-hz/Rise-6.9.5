package com.alan.clients.script.api.wrapper.impl;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.newevent.Event;
import com.alan.clients.script.api.RenderAPI;
import com.alan.clients.script.api.wrapper.ScriptHandlerWrapper;
import com.alan.clients.script.api.wrapper.impl.event.ScriptEvent;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.ColorValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.StringValue;
import com.alan.clients.value.impl.SubMode;
import java.awt.Color;
import java.util.function.Function;
import org.openjdk.nashorn.api.scripting.JSObject;
import org.openjdk.nashorn.internal.runtime.Undefined;

public final class ScriptModule extends ScriptHandlerWrapper<Module> {
    private final Function<Event, Boolean> eventListenerFunction = var1x -> {
        if (!Client.a.t().aP().contains(this.wrapped)) {
            return true;
        }

        if (this.wrapped.isEnabled()) {
            ScriptEvent scriptevent = var1x.getScriptEvent();
            if (scriptevent != null) {
                this.call(scriptevent.getHandlerName(), scriptevent);
            }
        }

        return false;
    };

    public ScriptModule(Module var1, boolean var2) {
        super(var1);
        if (var2) {
            Client.a.e().a(this.eventListenerFunction);
        }
    }

    public ScriptModule(Module var1) {
        super(var1);
    }

    public void unregister() {
        if (this.wrapped.isEnabled()) {
            this.wrapped.setEnabled(false);
        }

        this.wrapped.getValues().clear();
        Client.a.g().e(this.wrapped);
        Client.a.v().oS();
    }

    public String getName() {
        return this.wrapped.getName();
    }

    public String getCategory() {
        return this.wrapped.getModuleInfo().category().getName();
    }

    public String getDescription() {
        return this.wrapped.getModuleInfo().description();
    }

    public boolean isEnabled() {
        return this.wrapped.isEnabled();
    }

    public void toggle() {
        this.wrapped.toggle();
    }

    public void setEnabled(boolean var1) {
        this.wrapped.setEnabled(var1);
    }

    public String getTag() {
        return !this.wrapped.getValues().isEmpty() && this.wrapped.getValues().get(0) instanceof ModeValue
            ? ((ModeValue)this.wrapped.getValues().get(0)).wo().getName()
            : null;
    }

    @Override
    public void handle(String var1, JSObject var2) {
        super.handle(var1, var2);
    }

    @Override
    public void call(String var1, Object... var2) {
        super.call(var1, var2);
    }

    public void registerSetting(String var1, String var2, Object var3, Object... var4) {
        label97: {
            label98: {
                label99: {
                    label100: {
                        label70: {
                            String s = var1.toLowerCase();
                            byte b0 = -1;
                            switch (s.hashCode()) {
                                case -1034364087:
                                    if (s.equals("number")) {
                                        break label100;
                                    }
                                    break;
                                case -891985903:
                                    if (s.equals("string")) {
                                        b0 = 0;
                                    }
                                    break;
                                case -169986498:
                                    if (s.equals("boundsnumber")) {
                                        break label97;
                                    }
                                    break;
                                case 3357091:
                                    if (s.equals("mode")) {
                                        break label70;
                                    }
                                    break;
                                case 64711720:
                                    if (s.equals("boolean")) {
                                        break label98;
                                    }
                                    break;
                                case 94842723:
                                    if (s.equals("color")) {
                                        break label99;
                                    }
                            }

                            switch (b0) {
                                case 0:
                                    new StringValue(var2, this.wrapped, (String)var3);
                                    return;
                                case 1:
                                    break label100;
                                case 2:
                                    break label97;
                                case 3:
                                    break label98;
                                case 4:
                                    break;
                                case 5:
                                    break label99;
                                default:
                                    return;
                            }
                        }

                        ModeValue modevalue = new ModeValue(var2, this.wrapped);

                        for (Object object : var4) {
                            modevalue.add(new SubMode((String)object));
                        }

                        modevalue.setDefault((String)var3);
                        return;
                    }

                    new NumberValue(var2, this.wrapped, (Number)var3, (Number)var4[0], (Number)var4[1], var4.length >= 3 ? (Number)var4[2] : 1);
                    return;
                }

                Color color = Color.WHITE;
                if (var3 instanceof JSObject jsobject && jsobject.isArray()) {
                    int[] aint = jsobject.values()
                        .stream()
                        .map(var0 -> var0 instanceof Number ? ((Number)var0).intValue() : 255)
                        .mapToInt(Integer::intValue)
                        .toArray();
                    if (aint.length >= 3) {
                        color = RenderAPI.intArrayToColor(aint);
                    }
                }

                new ColorValue(var2, this.wrapped, color);
                return;
            }

            new BooleanValue(var2, this.wrapped, (Boolean)var3);
            return;
        }

        new BoundsNumberValue(var2, this.wrapped, (Number)var3, (Number)var4[0], (Number)var4[1], (Number)var4[2], (Number)var4[3]);
    }

    public Object getSetting(String var1) {
        try {
            Value value = this.wrapped.getAllValues().stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var1)).findFirst().get();
            if (value instanceof ColorValue) {
                int[] aint = new int[4];
                Color color = ((ColorValue)value).wo();
                aint[0] = color.getRed();
                aint[1] = color.getGreen();
                aint[2] = color.getBlue();
                aint[3] = color.getAlpha();
                return aint;
            }

            if (value instanceof NumberValue) {
                return ((NumberValue)value).wo().doubleValue();
            }

            if (value instanceof BoundsNumberValue) {
                return new double[]{((BoundsNumberValue)value).wo().doubleValue(), ((BoundsNumberValue)value).wA().doubleValue()};
            }

            if (value instanceof BooleanValue || value instanceof StringValue) {
                return value.wo();
            }

            if (value instanceof ModeValue) {
                return ((ModeValue)value).wo().getName();
            }
        } catch (Exception exception) {
        }

        return Undefined.getUndefined();
    }

    public void setSetting(String var1, Object var2) {
        try {
            Value value = this.wrapped.getAllValues().stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var1)).findFirst().get();
            if (value instanceof ColorValue) {
                int[] aint = (int[])var2;
                ((ColorValue)value).n(new Color(aint[0], aint[1], aint[2], aint[3]));
            } else if (value instanceof NumberValue) {
                ((NumberValue)value).n((Number)var2);
            } else if (value instanceof BoundsNumberValue) {
                Number[] anumber = (Number[])var2;
                ((BoundsNumberValue)value).n(anumber[0]);
                ((BoundsNumberValue)value).a(anumber[1]);
            } else if (value instanceof BooleanValue) {
                ((BooleanValue)value).setValue((Boolean)var2);
            } else if (value instanceof ModeValue) {
                ((ModeValue)value).co((String)var2);
            } else if (value instanceof StringValue) {
                ((StringValue)value).n((String)var2);
            }
        } catch (Exception exception) {
        }
    }

    public void setSettingVisibility(String var1, boolean var2) {
        try {
            this.wrapped.getValues().stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var1)).findFirst().get().a(() -> !var2);
        } catch (Exception exception) {
        }
    }
}
